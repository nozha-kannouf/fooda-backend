// FoodaOrderRes.java

package be.fooda.backend.commons.model.template.order.request;

import java.util.List;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderReq {
    private long customerId;
    private FoodaOrderBillingReq billing;
    private FoodaOrderDeliveryReq delivery;
    private List<FoodaSubOrderReq> orders;
}