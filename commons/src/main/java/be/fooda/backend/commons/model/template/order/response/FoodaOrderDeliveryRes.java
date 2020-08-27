// FoodaOrderDeliveryRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaOrderDeliveryRes {
    private Boolean isAddressSameAsBilling;
    private FoodaOrderContactRes contact;
}