package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderBillingRes {
    private Long OrderBillingId;
    private FoodaOrderAddressRes address;
    private FoodaOrderContactRes contact;
}