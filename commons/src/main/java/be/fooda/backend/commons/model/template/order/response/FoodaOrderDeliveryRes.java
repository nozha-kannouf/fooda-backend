package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderDeliveryRes {
    private Long OrderDeliveryId;
    private Boolean isAddressSameAsBilling;
    private FoodaOrderContactRes contact;
}