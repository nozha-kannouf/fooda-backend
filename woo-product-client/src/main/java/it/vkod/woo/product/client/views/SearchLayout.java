package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "", layout = MainAppLayout.class)
public class SearchLayout extends AbstractView {

    public SearchLayout(@Autowired MessageBean bean, @Autowired MainAppLayout appLayout) {

        Button button = new Button("Click me", e -> Notification.show(bean.getMessage()));
        add(button);

        // can access the AppLayout instance via dependency injection
        int notificationCount = appLayout.getNotifications().getNotificationSize();
        add(new Paragraph("You have " + notificationCount + " notification(s)"));

    }

    @Override
    String getViewName() {
        return getClass().getName();
    }

}
