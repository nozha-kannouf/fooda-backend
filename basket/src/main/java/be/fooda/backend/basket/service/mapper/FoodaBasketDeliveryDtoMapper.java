package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketDeliveryDto;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.response.*;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;

public class FoodaBasketDeliveryDtoMapper implements FoodaDtoMapper<FoodaBasketDeliveryDto, FoodaBasketDeliveryReq, FoodaBasketDeliveryRes> {

    @Override
    public FoodaBasketDeliveryDto requestToDto(FoodaBasketDeliveryReq req) {

        return FoodaBasketDeliveryDto.builder()
                .basketKey(reqBasketKey(req))
                .billingAddressId(req.getBillingAddressId())
                .billingContactId(req.getBillingContactId())
                .deliveryAddressId(req.getDeliveryAddressId())
                .deliveryContactId(req.getDeliveryContactId())
                .build();
    }

    private FoodaBasketKeyDto reqBasketKey(FoodaBasketDeliveryReq req) {
        return FoodaBasketKeyDto.builder()
                .session(req.getSession())
                .storeId(req.getStoreId())
                .userId(req.getUserId())
                .build();
    }

    @Override
    public FoodaBasketDeliveryDto responseToDto(FoodaBasketDeliveryRes res) {

        return FoodaBasketDeliveryDto.builder()
                .deliveryContactId(res.getDeliveryContact().getContactId())
                .deliveryAddressId(res.getDeliveryAddress().getAddressId())
                .billingContactId(res.getBillingContact().getContactId())
                .billingAddressId(res.getBillingAddress().getAddressId())
                .basketKey(resBasketKey(res))
                .build();
    }

    private FoodaBasketKeyDto resBasketKey(FoodaBasketDeliveryRes res) {
        return FoodaBasketKeyDto.builder()
                .userId(res.getUser().getUserId())
                .storeId(res.getStore().getStoreId())
                .session(res.getSession())
                .build();
    }

    @Override
    public FoodaBasketDeliveryReq dtoToRequest(FoodaBasketDeliveryDto dto) {

        return FoodaBasketDeliveryReq.builder()
                .deliveryContactId(dto.getDeliveryContactId())
                .deliveryAddressId(dto.getDeliveryAddressId())
                .billingContactId(dto.getBillingContactId())
                .billingAddressId(dto.getBillingAddressId())
                .session(dto.getBasketKey().getSession())
                .userId(dto.getBasketKey().getUserId())
                .storeId(dto.getBasketKey().getStoreId())
                .build();
    }

    @Override
    public FoodaBasketDeliveryRes dtoToResponse(FoodaBasketDeliveryDto dto) {

        return FoodaBasketDeliveryRes.builder()
                .session(dto.getBasketKey().getSession())
                .basketDeliveryId(dto.getBasketDeliveryId())
                .billingAddress(billingAddress(dto))
                .billingContact(billingContact(dto))
                .deliveryAddress(deliveryAddress(dto))
                .deliveryContact(deliveryContact(dto))
                .store(store(dto))
                .user(user(dto))
                .build();
    }

    private FoodaBasketUserRes user(FoodaBasketDeliveryDto dto) {
        return FoodaBasketUserRes.builder()
                .userId(dto.getBasketKey().getUserId())
                .build();
    }

    private FoodaBasketStoreRes store(FoodaBasketDeliveryDto dto) {
        return FoodaBasketStoreRes.builder()
                .storeId(dto.getBasketKey().getStoreId())
                .build();
    }

    private FoodaBasketContactRes deliveryContact(FoodaBasketDeliveryDto dto) {
        return FoodaBasketContactRes.builder()
                .contactId(dto.getDeliveryContactId())
                .userId(dto.getBasketKey().getUserId())
                .build();
    }

    private FoodaBasketAddressRes deliveryAddress(FoodaBasketDeliveryDto dto) {
        return FoodaBasketAddressRes.builder()
                .addressId(dto.getDeliveryAddressId())
                .build();
    }

    private FoodaBasketContactRes billingContact(FoodaBasketDeliveryDto dto) {
        return FoodaBasketContactRes.builder()
                .contactId(dto.getBillingContactId())
                .userId(dto.getBasketKey().getUserId())
                .build();
    }

    private FoodaBasketAddressRes billingAddress(FoodaBasketDeliveryDto dto) {
        return FoodaBasketAddressRes.builder()
                .addressId(dto.getBillingAddressId())
                .build();
    }
}
