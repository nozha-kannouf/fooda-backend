package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderDeliveryReq {
    private Boolean isAddressSameAsBilling;
    private FoodaOrderContactReq contact;
}