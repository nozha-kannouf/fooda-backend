package it.vkod.woo.product.client.views.mobile;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import it.vkod.woo.product.client.pojo.product.res.ProductResponse;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.clients.WooMatchServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import java.util.Arrays;

import static it.vkod.woo.product.client.views.mobile.SearchView.ROUTE;

@Slf4j
@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/materialize.min.css")
@CssImport("./styles/custom-card.css")
public class SearchView extends Div {

    @Autowired
    private WooMatchServiceClient matchServiceClient;

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    private static final String TOKEN_COOKIE = "token";
    public static final String ROUTE = "search";

    private final String BG_COLOR = "#3333FF"; // RGB 255, 87, 51
    private final String TEXT_COLOR = "white";

    /**
     * Based on Materialize css ..
     * <div class="row">
     *     <div class="col s12 m6">
     *       <div class="card">
     *         <div class="card-image">
     *           <img src="images/sample-1.jpg">
     *           <span class="card-title">Card Title</span>
     *           <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
     *         </div>
     *         <div class="card-content">
     *           <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
     *         </div>
     *       </div>
     *     </div>
     *   </div>
     */

    @PostConstruct
    public void init() {
        if (getTokenCookie() == null)
            UI.getCurrent().navigate("");

        setClassName("container-fluid");

        ProgressBar progressBar = new ProgressBar(0, 100, 25);
        add(progressBar);

        getSearchText();
    }

    private void getSearchText() {

        Div searchDiv = new Div();
        searchDiv.setClassName("card");
        searchDiv.getStyle()
                .set("background", BG_COLOR)
                .set("color", TEXT_COLOR)
                .set("height", "48px")
                .set("text-align", "center")
                .set("margin-left", "0")
                .set("margin-right", "0")
                .set("vertical-align", "middle")
                .set("margin-top", "5%");

        TextField searchTextField = new TextField();
        searchTextField.getStyle()
                .set("background", BG_COLOR)
                .set("color", TEXT_COLOR)
                .set("margin-left", "0")
                .set("margin-right", "0")
                .set("width", "55%")
                .set("align", "center");
        searchTextField.setValueChangeMode(ValueChangeMode.EAGER);
        searchTextField.getElement().callJsFunction("focus");
        Button searchButton = new Button("Search");
        searchButton.addClickShortcut(Key.ENTER);
        searchButton.getStyle()
                .set("background", BG_COLOR)
                .set("color", TEXT_COLOR)
                .set("margin-left", "0")
                .set("margin-right", "0")
                .set("width", "35%");
        searchButton.addClickListener(click -> searchProducts(searchTextField.getValue().toLowerCase()));

        searchDiv.add(searchTextField, searchButton);
        add(searchDiv);
    }

    private void searchProducts(final String search) {
        Arrays.stream(matchServiceClient.apiGetMatchFromAllStores(search)).forEach(productResponse -> {
            Div productCard = new Div();
            productCard.setClassName("card");
            Div productImgCard = createProductImageDiv(productResponse);
            Div productContentCard = createProductContentDiv(productResponse);
            productCard.add(productImgCard, productContentCard);
            add(productCard);
        });
    }

    private Div createProductContentDiv(ProductResponse productResponse) {
        Div productContentCard = new Div();
        productContentCard.setClassName("card-content");
        Paragraph productContentP = new Paragraph();
        //match HTML tags
        final String htmlElementsRegex = "<[^>]*>";
        productContentP.setText(productResponse.getDescription().replaceAll(htmlElementsRegex, ""));
        productContentP.getStyle()
                .set("font-weight", "bold")
                .set("font-size", "11pt");
        productContentCard.add(productContentP);
        return productContentCard;
    }

    private Div createProductImageDiv(ProductResponse productResponse) {
        Div productImgCard = new Div();
        productImgCard.setClassName("card-image");
        Image productImage = new Image(productResponse.getImages().get(0).getSrc(), productResponse.getImages().get(0).getAlt());
        productImage.getStyle()
                .set("height", "150px")
                .set("width", "100%");
        Span cardTitleSpan = new Span();
        cardTitleSpan.setClassName("card-title");
        cardTitleSpan.setText(productResponse.getName());
        final Icon addButtonIcon = VaadinIcon.PLUS_CIRCLE_O.create();
        addButtonIcon.setSize("28px");
        Button addButton = new Button(
                productResponse.getSalePrice() == null ? productResponse.getPrice().toString() : productResponse.getSalePrice()
                , addButtonIcon
        );
//        addButton.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
        addButton.setClassName("btn-floating halfway-fab");
        addButton.getStyle()
                .set("height", "48px")
                .set("width", "120px")
                .set("background-color", BG_COLOR);
        addButton.addClickListener(click -> {
            basketServiceClient.apiAddBasketProduct(BasketProduct.builder()
                    .userId(getTokenCookie().getValue())
                    .storeId(productResponse.getStoreId())
                    .restUrl(productResponse.getRestUrl())
                    .productId(productResponse.getId())
                    .name(productResponse.getName())
                    .price(Precision.round(productResponse.getPrice(), 2))
                    .quantity(1)
                    .imageUrl(productResponse.getImages().get(0).getSrc())
                    .build());

            final String notificationMsg = productResponse.getName() + " is added.";
            new Notification(notificationMsg, 1000).open();
        });
        productImgCard.add(productImage, cardTitleSpan, addButton);
        return productImgCard;
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> TOKEN_COOKIE.equals(cookie.getName())).findFirst().orElse(null);
    }

}