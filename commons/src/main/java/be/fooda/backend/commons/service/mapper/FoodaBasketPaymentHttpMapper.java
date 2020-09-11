package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.basket.request.FoodaBasketPaymentReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketPaymentRes;

public class FoodaBasketPaymentHttpMapper implements FoodaHttpMapper<FoodaBasketPaymentReq, FoodaBasketPaymentRes> {
    @Override
    public FoodaBasketPaymentReq responseToRequest(FoodaBasketPaymentRes res) {

        return FoodaBasketPaymentReq.builder()
                .amount(res.getAmount())
                .paymentId(res.getPaymentId())
                .session(res.getSession())
                .storeId(res.getStoreId())
                .userId(res.getUserId())
                .build();
    }

    @Override
    public FoodaBasketPaymentRes requestToResponse(FoodaBasketPaymentReq req) {

        return FoodaBasketPaymentRes.builder()
                .amount(req.getAmount())
                .paymentId(req.getPaymentId())
                .session(req.getSession())
                .storeId(req.getStoreId())
                .userId(req.getUserId())
                .build();
    }
}
