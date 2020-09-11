package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.response.*;

public class FoodaBasketDeliveryHttpMapper implements FoodaHttpMapper<FoodaBasketDeliveryReq, FoodaBasketDeliveryRes> {
    @Override
    public FoodaBasketDeliveryReq responseToRequest(FoodaBasketDeliveryRes res) {
        
        return FoodaBasketDeliveryReq.builder()
                .billingAddressId(res.getBillingAddress().getAddressId())
                .billingContactId(res.getBillingContact().getContactId())
                .deliveryAddressId(res.getDeliveryAddress().getAddressId())
                .deliveryContactId(res.getDeliveryContact().getContactId())
                .session(res.getSession())
                .storeId(res.getStore().getStoreId())
                .userId(res.getUser().getUserId())
                .build();
    }

    @Override
    public FoodaBasketDeliveryRes requestToResponse(FoodaBasketDeliveryReq req) {

        return FoodaBasketDeliveryRes.builder()
                .user(user(req))
                .store(store(req))
                .deliveryContact(deliveryContact(req))
                .deliveryAddress(deliveryAddress(req))
                .billingContact(billingContact(req))
                .billingAddress(billingAddress(req))
                .session(req.getSession())
                .build();
    }

    private FoodaBasketAddressRes billingAddress(FoodaBasketDeliveryReq req) {
        return FoodaBasketAddressRes.builder()
                .addressId(req.getBillingAddressId())
                .build();
    }

    private FoodaBasketContactRes billingContact(FoodaBasketDeliveryReq req) {
        return FoodaBasketContactRes.builder()
                .contactId(req.getBillingContactId())
                .build();
    }

    private FoodaBasketAddressRes deliveryAddress(FoodaBasketDeliveryReq req) {
        return FoodaBasketAddressRes.builder()
                .addressId(req.getDeliveryAddressId())
                .build();
    }

    private FoodaBasketContactRes deliveryContact(FoodaBasketDeliveryReq req) {
        return FoodaBasketContactRes.builder()
                .contactId(req.getDeliveryContactId())
                .build();
    }

    private FoodaBasketStoreRes store(FoodaBasketDeliveryReq req) {
        return FoodaBasketStoreRes.builder()
                .storeId(req.getStoreId())
                .build();
    }

    private FoodaBasketUserRes user(FoodaBasketDeliveryReq req) {
        return FoodaBasketUserRes.builder()
                .userId(req.getUserId())
                .build();
    }
}
