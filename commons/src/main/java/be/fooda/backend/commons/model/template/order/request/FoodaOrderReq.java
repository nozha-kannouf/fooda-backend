package be.fooda.backend.commons.model.template.order.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderReq {
    private FoodaOrderBillingReq billing;
    private FoodaOrderDeliveryReq delivery;
    private FoodaOrderStoreReq store;
    private FoodaOrderStatusReq status;
    private String note;
    private BigDecimal productsTotal;
    private BigDecimal taxTotal;
    private BigDecimal deliveryTotal;
    private BigDecimal priceTotal;
    private LocalDateTime registryTime;
    private LocalDateTime requiredTime;
    private LocalDateTime deliveryTime;
    private LocalDateTime paymentTime;
    private List<FoodaOrderProductReq> orderedProducts;
    private List<FoodaOrderPaymentReq> payments;
}