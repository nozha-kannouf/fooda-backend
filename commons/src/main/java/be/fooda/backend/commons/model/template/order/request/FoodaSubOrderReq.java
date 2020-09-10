// FoodaSubOrderRes.java

package be.fooda.backend.commons.model.template.order.request;

import java.math.BigDecimal;
import java.util.List;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaSubOrderReq {
    private FoodaOrderStoreReq store;
    private FoodaOrderStatusReq status;
    private String note;
    private String registry;
    private String required;
    private String delivery;
    private String payment;
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