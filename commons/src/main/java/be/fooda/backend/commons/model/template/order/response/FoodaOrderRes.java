// FoodaOrderRes.java

package be.fooda.backend.commons.model.template.order.response;

import java.util.List;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderRes {
    private long customerId;
    private FoodaOrderBillingRes billing;
    private FoodaOrderDeliveryRes delivery;
    private List<FoodaSubOrderRes> orders;
}