package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.basket.request.FoodaBasketProductReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;

public class FoodaBasketProductHttpMapper implements FoodaHttpMapper<FoodaBasketProductReq, FoodaBasketProductRes> {
    @Override
    public FoodaBasketProductReq responseToRequest(FoodaBasketProductRes res) {

        return FoodaBasketProductReq.builder()
                .description(res.getDescription())
                .imageUrl(res.getImageUrl())
                .name(res.getName())
                .price(res.getPrice())
                .productId(res.getProductId())
                .quantity(res.getQuantity())
                .session(res.getSession())
                .storeId(res.getStoreId())
                .userId(res.getUserId())
                .build();
    }

    @Override
    public FoodaBasketProductRes requestToResponse(FoodaBasketProductReq req) {

        return FoodaBasketProductRes.builder()
                .description(req.getDescription())
                .imageUrl(req.getImageUrl())
                .name(req.getName())
                .price(req.getPrice())
                .productId(req.getProductId())
                .quantity(req.getQuantity())
                .session(req.getSession())
                .storeId(req.getStoreId())
                .userId(req.getUserId())
                .build();
    }
}
