package be.fooda.backend.order.service.mapper;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderKeyReq;
import be.fooda.backend.commons.model.template.order.request.FoodaOrderProductReq;
import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.order.model.dto.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FoodaOrderDtoMapper implements FoodaDtoMapper<FoodaOrderDto, FoodaOrderReq, FoodaOrderRes> {
    @Override
    public FoodaOrderDto requestToDto(FoodaOrderReq foodaOrderReq) {
        return FoodaOrderDto.builder()
                .note(foodaOrderReq.getNote())
                .orderKey(orderKey(foodaOrderReq))
                .orderStatus(orderStatus(foodaOrderReq))
                .payments(payments(foodaOrderReq))
                .products(product(foodaOrderReq))
                .requiredTime(foodaOrderReq.getRequiredTime())
                .build();
    }

    private List<FoodaOrderProductDto> product(FoodaOrderReq foodaOrderReq) {
        return foodaOrderReq.getProducts().stream()
                .map(req -> FoodaOrderProductDto.builder()
                        .productKey(FoodaOrderProductKeyDto.builder()
                                .productId(req.getProductId())
                                .storeId(foodaOrderReq.getOrderKey().getStoreId())
                                .build())
                        .price(req.getPrice())
                        .quantity(req.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }

    private List<FoodaOrderProductDto> product(FoodaOrderRes foodaOrderRes) {
        return foodaOrderRes.getOrderedProducts().stream()
                .map(req -> FoodaOrderProductDto.builder()
                        .productKey(FoodaOrderProductKeyDto.builder()
                                .productId(req.getProductId())
                                .storeId(foodaOrderRes.getStore().getStoreId())
                                .build())
                        .price(req.getPrice())
                        .quantity(req.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }


    private List<FoodaOrderPaymentDto> payments(FoodaOrderReq foodaOrderReq) {
        return foodaOrderReq.getPayments().stream()
                .map(req -> FoodaOrderPaymentDto.builder()
                        .paymentId(req)
                        .build())
                .collect(Collectors.toList());
    }

    private List<FoodaOrderPaymentDto> payments(FoodaOrderRes foodaOrderRes) {
        return foodaOrderRes.getPayments().stream()
                .map(res -> FoodaOrderPaymentDto.builder()
                        .orderPaymentId(res.getOrderPaymentId())
                        .paymentId(res.getPaymentId())
                        .amount(res.getAmount())
                        .build())
                .collect(Collectors.toList());
    }

    private FoodaOrderStatusDto orderStatus(FoodaOrderReq foodaOrderReq) {
        return FoodaOrderStatusDto.builder()
                .orderStatusId(foodaOrderReq.getOrderStatusId())
                .build();
    }

    private FoodaOrderStatusDto orderStatus(FoodaOrderRes foodaOrderRes) {
        return FoodaOrderStatusDto.builder()
                .orderStatusId(foodaOrderRes.getStatus().getOrderStatusId())
                .title(foodaOrderRes.getStatus().getTitle())
                .parent(FoodaOrderStatusDto.builder()
                        .title(foodaOrderRes.getStatus().getParent())
                        .build())
                .build();
    }

    private FoodaOrderKeyDto orderKey(FoodaOrderReq foodaOrderReq) {
        return FoodaOrderKeyDto.builder()
                .userId(foodaOrderReq.getOrderKey().getUserId())
                .storeId(foodaOrderReq.getOrderKey().getStoreId())
                .build();
    }

    private FoodaOrderKeyDto orderKey(FoodaOrderRes foodaOrderRes) {
        return FoodaOrderKeyDto.builder()
                .userId(foodaOrderRes.getUserId())
                .storeId(foodaOrderRes.getStore().getStoreId())
                .orderId(foodaOrderRes.getOrderId())
                .externalOrderId(foodaOrderRes.getExternalOrderId())
                .build();
    }

    @Override
    public FoodaOrderDto responseToDto(FoodaOrderRes foodaOrderRes) {
        return FoodaOrderDto.builder()
                .note(foodaOrderRes.getNote())
                .orderKey(orderKey(foodaOrderRes))
                .orderStatus(orderStatus(foodaOrderRes))
                .payments(payments(foodaOrderRes))
                .products(product(foodaOrderRes))
                .requiredTime(foodaOrderRes.getRequiredTime())
                .build();
    }

    @Override
    public FoodaOrderReq dtoToRequest(FoodaOrderDto foodaOrderDto) {
        return FoodaOrderReq.builder()
                .note(foodaOrderDto.getNote())
                .orderKey(orderKey(foodaOrderDto))
                .orderStatusId(foodaOrderDto.getOrderStatus().getOrderStatusId())
                .payments(payments(foodaOrderDto))
                .products(products(foodaOrderDto))
                .requiredTime(foodaOrderDto.getRequiredTime())
                .build();
    }

    private Set<FoodaOrderProductReq> products(FoodaOrderDto foodaOrderDto) {
        return foodaOrderDto.getProducts().stream()
                .map(dto -> FoodaOrderProductReq.builder()
                        .price(dto.getPrice())
                        .productId(dto.getProductKey().getProductId())
                        .quantity(dto.getQuantity())
                        .build())
                .collect(Collectors.toSet());
    }

    private Set<Long> payments(FoodaOrderDto foodaOrderDto) {
        return foodaOrderDto.getPayments().stream()
                .map(FoodaOrderPaymentDto::getPaymentId).collect(Collectors.toSet());
    }

    private FoodaOrderKeyReq orderKey(FoodaOrderDto foodaOrderDto) {
        return FoodaOrderKeyReq.builder()
                .userId(foodaOrderDto.getOrderKey().getUserId())
                .storeId(foodaOrderDto.getOrderKey().getStoreId())
                .build();
    }

    // TODO doorgaan met hier, veel success ..
    @Override
    public FoodaOrderRes dtoToResponse(FoodaOrderDto foodaOrderDto) {
        return FoodaOrderRes.builder()
                .externalOrderId(foodaOrderDto.getOrderKey().getExternalOrderId())
                .productsTotal(productsTotal(foodaOrderDto))
                .build();
    }

    private BigDecimal productsTotal(FoodaOrderDto foodaOrderDto) {
        return BigDecimal.valueOf(foodaOrderDto.getProducts().stream()
                .mapToDouble(prod -> prod.getPrice().doubleValue() * prod.getQuantity())
                .sum());
    }
}
