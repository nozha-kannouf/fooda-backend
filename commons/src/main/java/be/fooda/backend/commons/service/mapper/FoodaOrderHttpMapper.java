package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.order.request.*;
import be.fooda.backend.commons.model.template.order.response.*;

import java.util.List;
import java.util.stream.Collectors;

public class FoodaOrderHttpMapper implements FoodaHttpMapper<FoodaOrderReq, FoodaOrderRes> {
    @Override
    public FoodaOrderReq responseToRequest(FoodaOrderRes foodaOrderRes) {
        return FoodaOrderReq.builder()
                .customerId(foodaOrderRes.getCustomerId())
                .billing(billingAsReq(foodaOrderRes))
                .delivery(deliveryAsReq(foodaOrderRes))
                .orders(orders(foodaOrderRes))
                .build();
    }

    private List<FoodaSubOrderReq> orders(final FoodaOrderRes res) {
        return res.getOrders().stream().map(order -> FoodaSubOrderReq.builder()
                .delivery(order.getDelivery())
                .deliveryTime(order.getDeliveryTime())
                .deliveryTotal(order.getDeliveryTotal())
                .note(order.getNote())
                .payment(order.getPayment())
                .orderedProducts(orderProducts(order))
                .paymentTime(order.getPaymentTime())
                .priceTotal(order.getPriceTotal())
                .registry(order.getRegistry())
                .registryTime(order.getRegistryTime())
                .required(order.getRequired())
                .requiredTime(order.getRequiredTime())
                .taxTotal(order.getTaxTotal())
                .productsTotal(order.getProductsTotal())
                .status(status(order))
                .payments(payments(order))
                .store(store(order))
                .build()
        )
                .collect(Collectors.toList());
    }

    private FoodaOrderStoreReq store(final FoodaSubOrderRes orderRes) {
        return FoodaOrderStoreReq.builder()
                .address(FoodaOrderAddressReq.builder()
                        .street(orderRes.getStore().getAddress().getStreet())
                        .region(orderRes.getStore().getAddress().getRegion())
                        .number(orderRes.getStore().getAddress().getNumber())
                        .municipality(orderRes.getStore().getAddress().getMunicipality())
                        .doorNo(orderRes.getStore().getAddress().getDoorNo())
                        .country(orderRes.getStore().getAddress().getCountry())
                        .city(orderRes.getStore().getAddress().getCity())
                        .build())
                .contact(FoodaOrderContactReq.builder()
                        .phoneNumber(orderRes.getStore().getContact().getPhoneNumber())
                        .firstName(orderRes.getStore().getContact().getFirstName())
                        .familyName(orderRes.getStore().getContact().getFirstName())
                        .email(orderRes.getStore().getContact().getEmail())
                        .company(orderRes.getStore().getContact().getCompany())
                        .call(orderRes.getStore().getContact().getCall())
                        .build())
                .logo(orderRes.getStore().getLogo())
                .name(orderRes.getStore().getName())
                .storeId(orderRes.getStore().getStoreId())
                .build();
    }

    private FoodaOrderStatusReq status(final FoodaSubOrderRes order) {
        return FoodaOrderStatusReq.builder()
                .parent(order.getStatus().getParent())
                .title(order.getStatus().getTitle())
                .build();

    }

    private List<FoodaOrderPaymentReq> payments(final FoodaSubOrderRes order) {
        return order.getPayments().stream()
                .map(p-> FoodaOrderPaymentReq.builder()
                        .amount(p.getAmount())
                        .method(p.getMethod())
                        .title(p.getTitle())
                        .build()
                )
                .collect(Collectors.toList());
    }

    private List<FoodaOrderProductReq> orderProducts(final FoodaSubOrderRes order) {
        return order.getOrderedProducts().stream()
                .map(op-> FoodaOrderProductReq.builder()
                        .name(op.getName())
                        .price(op.getPrice())
                        .productId(op.getProductId())
                        .quantity(op.getQuantity())
                        .type(op.getType())
                        .variant(FoodaOrderVariantReq.builder()
                                .price(op.getVariant().getPrice())
                                .title(op.getVariant().getTitle())
                                .build()
                        )
                        .build())
                .collect(Collectors.toList());

    }

    private FoodaOrderDeliveryReq deliveryAsReq(final FoodaOrderRes res){
        return FoodaOrderDeliveryReq.builder()
                .contact(FoodaOrderContactReq.builder()
                        .call(res.getBilling().getContact().getCall())
                        .company(res.getBilling().getContact().getCompany())
                        .email(res.getBilling().getContact().getEmail())
                        .familyName(res.getBilling().getContact().getFamilyName())
                        .firstName(res.getBilling().getContact().getFirstName())
                        .phoneNumber(res.getBilling().getContact().getPhoneNumber())
                        .build()
                )
                .isAddressSameAsBilling(res.getDelivery().getIsAddressSameAsBilling())
                .build();
    }

    private FoodaOrderBillingReq billingAsReq(final FoodaOrderRes res) {
        return FoodaOrderBillingReq.builder()
                .address(FoodaOrderAddressReq.builder()
                        .city(res.getBilling().getAddress().getCity())
                        .country(res.getBilling().getAddress().getCountry())
                        .doorNo(res.getBilling().getAddress().getDoorNo())
                        .municipality(res.getBilling().getAddress().getMunicipality())
                        .number(res.getBilling().getAddress().getNumber())
                        .region(res.getBilling().getAddress().getRegion())
                        .street(res.getBilling().getAddress().getStreet())
                        .build()
                )
                .contact(FoodaOrderContactReq.builder()
                        .call(res.getBilling().getContact().getCall())
                        .company(res.getBilling().getContact().getCompany())
                        .email(res.getBilling().getContact().getEmail())
                        .familyName(res.getBilling().getContact().getFamilyName())
                        .firstName(res.getBilling().getContact().getFirstName())
                        .phoneNumber(res.getBilling().getContact().getPhoneNumber())
                        .build()
                )
                .build();
    }

    @Override
    public FoodaOrderRes requestToResponse(FoodaOrderReq foodaOrderReq) {
        return FoodaOrderRes.builder()
                .customerId(foodaOrderReq.getCustomerId())
                .billing(billingAsRes(foodaOrderReq))
                .delivery(deliveryAsRes(foodaOrderReq))
                .orders(orders(foodaOrderReq))
                .build();
    }

    private List<FoodaSubOrderRes> orders(final FoodaOrderReq req) {
        return req.getOrders().stream().map(order -> FoodaSubOrderRes.builder()
                .delivery(order.getDelivery())
                .deliveryTime(order.getDeliveryTime())
                .deliveryTotal(order.getDeliveryTotal())
                .note(order.getNote())
                .payment(order.getPayment())
                .orderedProducts(orderProducts(order))
                .paymentTime(order.getPaymentTime())
                .priceTotal(order.getPriceTotal())
                .registry(order.getRegistry())
                .registryTime(order.getRegistryTime())
                .required(order.getRequired())
                .requiredTime(order.getRequiredTime())
                .taxTotal(order.getTaxTotal())
                .productsTotal(order.getProductsTotal())
                .status(status(order))
                .payments(payments(order))
                .store(store(order))
                .build()
        )
                .collect(Collectors.toList());
    }

    private FoodaOrderStoreRes store(final FoodaSubOrderReq orderReq) {
        return FoodaOrderStoreRes.builder()
                .address(FoodaOrderAddressRes.builder()
                        .street(orderReq.getStore().getAddress().getStreet())
                        .region(orderReq.getStore().getAddress().getRegion())
                        .number(orderReq.getStore().getAddress().getNumber())
                        .municipality(orderReq.getStore().getAddress().getMunicipality())
                        .doorNo(orderReq.getStore().getAddress().getDoorNo())
                        .country(orderReq.getStore().getAddress().getCountry())
                        .city(orderReq.getStore().getAddress().getCity())
                        .build())
                .contact(FoodaOrderContactRes.builder()
                        .phoneNumber(orderReq.getStore().getContact().getPhoneNumber())
                        .firstName(orderReq.getStore().getContact().getFirstName())
                        .familyName(orderReq.getStore().getContact().getFirstName())
                        .email(orderReq.getStore().getContact().getEmail())
                        .company(orderReq.getStore().getContact().getCompany())
                        .call(orderReq.getStore().getContact().getCall())
                        .build())
                .logo(orderReq.getStore().getLogo())
                .name(orderReq.getStore().getName())
                .storeId(orderReq.getStore().getStoreId())
                .build();
    }

    private FoodaOrderStatusRes status(final FoodaSubOrderReq order) {
        return FoodaOrderStatusRes.builder()
                .parent(order.getStatus().getParent())
                .title(order.getStatus().getTitle())
                .build();

    }

    private List<FoodaOrderPaymentRes> payments(final FoodaSubOrderReq order) {
        return order.getPayments().stream()
                .map(p-> FoodaOrderPaymentRes.builder()
                        .amount(p.getAmount())
                        .method(p.getMethod())
                        .title(p.getTitle())
                        .build()
                )
                .collect(Collectors.toList());
    }

    private List<FoodaOrderProductRes> orderProducts(final FoodaSubOrderReq order) {
        return order.getOrderedProducts().stream()
                .map(op-> FoodaOrderProductRes.builder()
                        .name(op.getName())
                        .price(op.getPrice())
                        .productId(op.getProductId())
                        .quantity(op.getQuantity())
                        .type(op.getType())
                        .variant(FoodaOrderVariantRes.builder()
                                .price(op.getVariant().getPrice())
                                .title(op.getVariant().getTitle())
                                .build()
                        )
                        .build())
                .collect(Collectors.toList());

    }

    private FoodaOrderDeliveryRes deliveryAsRes(final FoodaOrderReq req){
        return FoodaOrderDeliveryRes.builder()
                .contact(FoodaOrderContactRes.builder()
                        .call(req.getBilling().getContact().getCall())
                        .company(req.getBilling().getContact().getCompany())
                        .email(req.getBilling().getContact().getEmail())
                        .familyName(req.getBilling().getContact().getFamilyName())
                        .firstName(req.getBilling().getContact().getFirstName())
                        .phoneNumber(req.getBilling().getContact().getPhoneNumber())
                        .build()
                )
                .isAddressSameAsBilling(req.getDelivery().getIsAddressSameAsBilling())
                .build();
    }

    private FoodaOrderBillingRes billingAsRes(final FoodaOrderReq req) {
        return FoodaOrderBillingRes.builder()
                .address(FoodaOrderAddressRes.builder()
                        .city(req.getBilling().getAddress().getCity())
                        .country(req.getBilling().getAddress().getCountry())
                        .doorNo(req.getBilling().getAddress().getDoorNo())
                        .municipality(req.getBilling().getAddress().getMunicipality())
                        .number(req.getBilling().getAddress().getNumber())
                        .region(req.getBilling().getAddress().getRegion())
                        .street(req.getBilling().getAddress().getStreet())
                        .build()
                )
                .contact(FoodaOrderContactRes.builder()
                        .call(req.getBilling().getContact().getCall())
                        .company(req.getBilling().getContact().getCompany())
                        .email(req.getBilling().getContact().getEmail())
                        .familyName(req.getBilling().getContact().getFamilyName())
                        .firstName(req.getBilling().getContact().getFirstName())
                        .phoneNumber(req.getBilling().getContact().getPhoneNumber())
                        .build()
                )
                .build();
    }

}
