package be.fooda.backend.order.service.mapper;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.order.model.dto.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FoodaOrderDtoMapper implements FoodaDtoMapper<FoodaOrderDto , FoodaOrderReq, FoodaOrderRes>{
    @Override
    public FoodaOrderDto requestToDto(FoodaOrderReq foodaOrderReq) {
        return null;
    }

    @Override
    public FoodaOrderDto responseToDto(FoodaOrderRes foodaOrderRes) {
    return  FoodaOrderDto.builder()
                         .priceTotal(foodaOrderRes.getOrders().stream()
                                                          .map(order-> order.getPriceTotal())
                                                          .reduce(BigDecimal.ZERO, BigDecimal :: add))
                        .deliveryTotal(foodaOrderRes.getOrders().stream()
                                                                .map(order-> order.getDeliveryTotal())
                                                                .reduce(BigDecimal.ZERO, BigDecimal :: add))
                        .products(products(foodaOrderRes))
                        .payments(payments(foodaOrderRes))
                        .productsTotal(foodaOrderRes.getOrders().stream()
                                                                .map(order->new BigDecimal(order.getOrderedProducts().size()))
                                                                .reduce(BigDecimal.ZERO, BigDecimal :: add))
                        .build();
    }
    private List<FoodaOrderPaymentDto> payments(final FoodaOrderRes res) {
        return res.getOrders().stream().map(order -> order.getPayments().stream()
                                                                        .map(op-> FoodaOrderPaymentDto.builder()
                                                                                                      .amount(new BigDecimal(op.getAmount()))
                                                                                                      .build()
                                                                            )
                                                                        .collect(Collectors.toList())
                                            )
                                        .collect(Collectors.toList())
                                        .stream().flatMap(List :: stream).collect(Collectors.toList());

    }
    private List<FoodaOrderProductDto> products(final FoodaOrderRes res) {
        return res.getOrders().stream().map(order -> order.getOrderedProducts().stream()
                                                            .map(op-> FoodaOrderProductDto.builder()
                                                                                    .quantity(op.getQuantity().intValue())
                                                                                    .price(op.getPrice())
                                                                                    .productKey(FoodaOrderProductKeyDto.builder()
                                                                                                        .productId(op.getProductId())
                                                                                                        .build()
                                                                                                )
                                                                                    .build()
                                                                )
                                                            .collect(Collectors.toList()))
                                        .collect(Collectors.toList())
                                        .stream().flatMap(List :: stream).collect(Collectors.toList());
    }

    @Override
    public FoodaOrderReq dtoToRequest(FoodaOrderDto foodaOrderDto) {
        return null;
    }

    @Override
    public FoodaOrderRes dtoToResponse(FoodaOrderDto foodaOrderDto) {
        return null;
    }
}
