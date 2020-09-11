package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.basket.request.FoodaBasketOrderReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;

public class FoodaBasketOrderHttpMapper implements FoodaHttpMapper<FoodaBasketOrderReq, FoodaBasketOrderRes> {
    @Override
    public FoodaBasketOrderReq responseToRequest(FoodaBasketOrderRes res) {

        return FoodaBasketOrderReq.builder()
                .note(res.getNote())
                .requiredTime(res.getRequiredTime())
                .session(res.getSession())
                .storeId(res.getStoreId())
                .userId(res.getUserId())
                .build();
    }

    @Override
    public FoodaBasketOrderRes requestToResponse(FoodaBasketOrderReq req) {

        return FoodaBasketOrderRes.builder()
                .note(req.getNote())
                .requiredTime(req.getRequiredTime())
                .session(req.getSession())
                .storeId(req.getStoreId())
                .userId(req.getUserId())
                .build();
    }
}
