// FoodaOrderRes.java

package be.fooda.backend.commons.model.template.order.request;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private LocalDate registryDate;
    private LocalDate requiredDate;
    private LocalDate deliveryDate;
    private LocalDate paymentDate;
    private BigDecimal productsTotal;
    private BigDecimal taxTotal;
    private BigDecimal deliveryTotal;
    private BigDecimal priceTotal;
    private List<FoodaOrderProductReq> orderedProducts;
    private List<FoodaOrderPaymentReq> payments;
    private String registryTime;
    private String requiredTime;
    private String deliveryTime;
    private String paymentTime;
}