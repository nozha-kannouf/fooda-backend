package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.product.request.*;
import be.fooda.backend.commons.model.template.product.response.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FoodaProductHttpMapper implements FoodaHttpMapper<FoodaProductReq, FoodaProductRes> {

    @Override
    public FoodaProductReq responseToRequest(final FoodaProductRes res) {
        return FoodaProductReq.builder()
                .categories(res.getCategories())
                .description(res.getDescription())
                .images(imagesAsReq(res))
                .isFeatured(false)
                .name(res.getName())
                .orderLimit(res.getOrderLimit())
                .prices(pricesAsReq(res))
        .productId(res.getProductId())
        .store(store(res))
        .tags(res.getTags())
        .taxes(taxes(res))
        .type(type(res))
        .build();
    }

    private FoodaProductTypeReq type(final FoodaProductRes res){
        return FoodaProductTypeReq.builder()
        .title(res.getType().getTitle())
        .typeId(res.getType().getTypeId())
        .build();
    }

    private List<FoodaProductTaxesItemReq> taxes(final FoodaProductRes res){
        return res.getTaxes().stream()
        .map(tax -> FoodaProductTaxesItemReq.builder()
        .taxId(tax.getTaxId())
        .isDefault(tax.getIsDefault())
        .percentage(tax.getPercentage())
        .title(tax.getTitle())
        .build())
        .collect(Collectors.toList());
    }

    private FoodaProductStoreReq store(final FoodaProductRes res){
        return FoodaProductStoreReq.builder()
        .name(res.getStore().getName())
        .logo(res.getStore().getLogo())
        .storeId(res.getStore().getStoreId())
        .build();
    }

    private List<FoodaProductImagesItemReq> imagesAsReq(final FoodaProductRes res) {
        return res.getImages().stream()
                .map(img ->
                        FoodaProductImagesItemReq.builder()
                                .mediaId(img.getMediaId())
                                .isDefault(img.getIsDefault())
                                .type(type(res))
                                .url(img.getUrl())
                                .build()
                ).collect(Collectors.toList());
    }

    private List<FoodaProductPricesItemReq> pricesAsReq(final FoodaProductRes res) {
        return res.getPrices().stream()
                .map(pri -> FoodaProductPricesItemReq.builder()
                        .amount(pri.getAmount())
                        .currency(pri.getCurrency())
                        .expiry(pri.getExpiry())
                        .isDefault(pri.getIsDefault())
                        .priceId(pri.getPriceId())
                        .title(res.getType().getTitle())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public FoodaProductRes requestToResponse(final FoodaProductReq productReq) {
        final FoodaProductRes res = new FoodaProductRes();
            res.setName(productReq.getName());
            res.setIsFeatured(false);
            res.setProductId(productReq.getProductId());
            res.setCategories(productReq.getCategories());
            res.setDescription(productReq.getDescription());
            res.setImages(imageAsRes(productReq));
            res.setOrderLimit(productReq.getOrderLimit());
            res.setPrices(priceAsRes(productReq));
            res.setStockQuantity(productReq.getStockQuantity());
            res.setStore(storeAsRes(productReq));
            res.setTags(productReq.getTags());
            res.setTaxes(taxAsRes(productReq));
            res.setType(typeAsRes(productReq));

        return res;
    }

    private FoodaProductTypeRes typeAsRes(FoodaProductReq productReq) {
        FoodaProductTypeRes typeRes=new FoodaProductTypeRes();
        typeRes.setTypeId(productReq.getType().getTypeId());
        typeRes.setName(productReq.getName());
        typeRes.setTitle(productReq.getType().getTitle());
        return typeRes;
    }

    private List<FoodaProductTaxesItemRes> taxAsRes(FoodaProductReq productReq) {
        return productReq.getTaxes().stream()
                .map(tax->FoodaProductTaxesItemRes.builder()
                        .taxId(tax.getTaxId())
                        .title(tax.getTitle())
                        .percentage(tax.getPercentage())
                        .isDefault(false)
                        .build())
                .collect(Collectors.toList());
    }

    private FoodaProductStoreRes storeAsRes(FoodaProductReq productReq) {
         FoodaProductStoreRes storeRes=new FoodaProductStoreRes();
        storeRes.setStoreId(productReq.getStore().getStoreId());
        storeRes.setName(productReq.getName());
        storeRes.setLogo(productReq.getStore().getLogo());
        return storeRes;
    }

    private List<FoodaProductPricesItemRes> priceAsRes(FoodaProductReq productReq) {
        return productReq.getPrices().stream()
                .map(price->FoodaProductPricesItemRes.builder()
                        .amount(price.getAmount())
                        .currency(price.getCurrency())
                        .expiry(price.getExpiry())
                        .priceId(price.getPriceId())
                        .isDefault(false)
                        .title(price.getTitle())
                        .build())
                .collect(Collectors.toList());
    }

    private List<FoodaProductImagesItemRes> imageAsRes(FoodaProductReq productReq) {
        return productReq.getImages().stream()
                .map(image->FoodaProductImagesItemRes.builder()
                        .isDefault(false)
                        .mediaId(image.getMediaId())
                        .url(image.getUrl())
                        .type(typeAsRes(productReq))
                        .build())
                .collect(Collectors.toList());
    }
}
