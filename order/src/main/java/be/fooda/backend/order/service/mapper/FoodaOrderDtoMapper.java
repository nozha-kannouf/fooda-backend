package be.fooda.backend.order.service.mapper;

import be.fooda.backend.commons.model.template.order.request.*;
import be.fooda.backend.commons.model.template.order.response.*;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.order.model.dto.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FoodaOrderDtoMapper implements FoodaDtoMapper<FoodaOrderDto , FoodaOrderReq, FoodaOrderRes>{
    @Override
    public FoodaOrderDto requestToDto(FoodaOrderReq req) {
        return FoodaOrderDto.builder()
                            .note(req.getNote())
                            .priceTotal(req.getPriceTotal())
                            .productsTotal(req.getProductsTotal())
                            .taxTotal(req.getTaxTotal())
                            .deliveryTotal(req.getDeliveryTotal())
                            .requiredTime(req.getRequiredTime())
                            .paymentTime(req.getPaymentTime())
                            .deliveryTime(req.getDeliveryTime())
                            .orderKey(FoodaOrderKeyDto.builder().storeId(req.getStore().getStoreId()).build())
                            .orderStatus(status(req))
                            .payments(payments(req))
                            .products(products(req))
                            .build();
    }

    private List<FoodaOrderProductDto> products(FoodaOrderReq req) {
        return req.getOrderedProducts().stream()
                                .map(op-> FoodaOrderProductDto.builder()
                                                              .quantity(op.getQuantity())
                                                              .price(op.getPrice())
                                                              .productKey(FoodaOrderProductKeyDto.builder()
                                                                                                 .productId(op.getProductId())
                                                                                                 .storeId(req.getStore().getStoreId())
                                                                                                 .build())
                                                              .build()
                                )
                                .collect(Collectors.toList());
    }
    private List<FoodaOrderProductReq> products(FoodaOrderDto dto) {
        return dto.getProducts().stream()
                .map(p-> FoodaOrderProductReq.builder()
                        .quantity(p.getQuantity())
                        .price(p.getPrice())
                        .productId(p.getProductKey().getProductId())
                        .build()
                )
                .collect(Collectors.toList());
    }
    private List<FoodaOrderPaymentDto> payments(FoodaOrderReq req) {
       return req.getPayments().stream()
                         .map(op-> FoodaOrderPaymentDto.builder()
                                                       .amount(BigDecimal.valueOf(op.getAmount()))
                                                       .build()
                         )
                         .collect(Collectors.toList());


    }
    private List<FoodaOrderPaymentReq> payments(FoodaOrderDto dto) { //TODO
        return dto.getPayments().stream()
                                .map(p-> FoodaOrderPaymentDto.builder()
                                                             .amount(p.getAmount())
                                                             .build()
                                 )
                                .collect(Collectors.toList());
    }

    private FoodaOrderStatusDto status(FoodaOrderReq req) {
        return FoodaOrderStatusDto.builder()
                                  .title(req.getStatus().getTitle())
                                  .parent(FoodaOrderStatusDto.builder().title(req.getStatus().getParent()).build())
                                  .build();
    }

    private FoodaOrderStatusReq status(FoodaOrderDto dto) {
        return FoodaOrderStatusReq.builder()
                .title(dto.getOrderStatus().getTitle())
                .parent(dto.getOrderStatus().getParent().getTitle())
                .build();
    }

    @Override
    public FoodaOrderDto responseToDto(FoodaOrderRes res) {
        return null;
        // FoodaOrderDto naar FoodaOrderRes => niet correct ..
        // FoodaOrderDto naar FoodaSubOrderReq => correct ..
//    return  FoodaOrderDto.builder()
//
//                         .priceTotal(res.getOrders().stream()
//                                                          .map(order-> order.getPriceTotal())
//                                                          .reduce(BigDecimal.ZERO, BigDecimal :: add))
//                         .deliveryTotal(res.getOrders().stream()
//                                                       .map(order-> order.getDeliveryTotal())
//                                                       .reduce(BigDecimal.ZERO, BigDecimal :: add))
//                         .products(products(res))
//                         .payments(payments(res))
//                         .productsTotal(res.getOrders().stream()//TODO amount* price and som
//                                                       .map(order->new BigDecimal(order.getOrderedProducts().size()))
//                                                       .reduce(BigDecimal.ZERO, BigDecimal :: add))
//                        .build();
    }
//    private List<FoodaOrderPaymentDto> payments(final FoodaOrderRes res) {
//        return res.getOrders().stream().map(order -> order.getPayments().stream()
//                                                                        .map(op-> FoodaOrderPaymentDto.builder()
//                                                                                                      .amount(new BigDecimal(op.getAmount()))
//                                                                                                      .build()
//                                                                            )
//                                                                        .collect(Collectors.toList())
//                                            )
//                                        .collect(Collectors.toList())
//                                        .stream().flatMap(List :: stream).collect(Collectors.toList());
//
//    }
//    private List<FoodaOrderPaymentDto> payments(final FoodaOrderReq req) {
//        return null;
//        return req.getOrders().stream().map(order -> order.getPayments().stream()
//                .map(op-> FoodaOrderPaymentDto.builder()
//                        .amount(new BigDecimal(op.getAmount()))
//                        .build()
//                )
//                .collect(Collectors.toList())
//        )
//                .collect(Collectors.toList())
//                .stream().flatMap(List :: stream).collect(Collectors.toList());

   // }
//    private List<FoodaOrderProductDto> products(final FoodaOrderRes res) {
//        return res.getOrders().stream().map(order -> order.getOrderedProducts().stream()
//                                                            .map(op-> FoodaOrderProductDto.builder()
//                                                                                    .quantity(op.getQuantity().intValue())
//                                                                                    .price(op.getPrice())
//                                                                                    .productKey(FoodaOrderProductKeyDto.builder()
//                                                                                                        .productId(op.getProductId())
//                                                                                                        .build()
//                                                                                                )
//                                                                                    .build()
//                                                                )
//                                                            .collect(Collectors.toList()))
//                                        .collect(Collectors.toList())
//                                        .stream().flatMap(List :: stream).collect(Collectors.toList());
//    }
//    private List<FoodaOrderProductDto> products(final FoodaOrderReq req) {
//        return req.getOrders().stream().map(order -> order.getOrderedProducts().stream()
//                .map(op-> FoodaOrderProductDto.builder()
//                        .quantity(op.getQuantity().intValue())
//                        .price(op.getPrice())
//                        .productKey(FoodaOrderProductKeyDto.builder()
//                                .productId(op.getProductId())
//                                .build()
//                        )
//                        .build()
//                )
//                .collect(Collectors.toList()))
//                .collect(Collectors.toList())
//                .stream().flatMap(List :: stream).collect(Collectors.toList());
//    }

    @Override
    public FoodaOrderReq dtoToRequest(FoodaOrderDto dto) {
        return FoodaOrderReq.builder()
                            .deliveryTime(dto.getDeliveryTime())
                            .deliveryTotal(dto.getDeliveryTotal())
                            .note(dto.getNote())
                            .paymentTime(dto.getPaymentTime())
                            .priceTotal(dto.getPriceTotal())
                            .registryTime(dto.getRegisteredAt())
                            .taxTotal(dto.getTaxTotal())
                            .requiredTime(dto.getRequiredTime())
                            .productsTotal(dto.getProductsTotal())
                            .status(status(dto))
                            .store(FoodaOrderStoreReq.builder().storeId(dto.getOrderKey().getStoreId()).build())
                            .orderedProducts(products(dto))
                            .payments(payments(dto))
                            .build();
    }

    @Override
    public FoodaOrderRes dtoToResponse(FoodaOrderDto foodaOrderDto) {
        return null;
    }


}
