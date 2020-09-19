// FoodaSubOrderRes.java

package be.fooda.backend.commons.model.template.order.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaSubOrderRes {
    private long subOrderId;
    private FoodaOrderStoreRes store;
    private FoodaOrderStatusRes status;
    private String note;
    private String registry;
    private String required;
    private String delivery;
    private String payment;
    private BigDecimal productsTotal;
    private BigDecimal taxTotal;
    private BigDecimal deliveryTotal;
    private BigDecimal priceTotal;
    private List<FoodaOrderProductRes> orderedProducts;
    private List<FoodaOrderPaymentRes> payments;
    private String registryTime;
    private String requiredTime;
    private String deliveryTime;
    private String paymentTime;
}