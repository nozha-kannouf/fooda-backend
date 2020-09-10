// FoodaOrderVariantRes.java

package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderVariantReq {
    private String title;
    private String price;
}