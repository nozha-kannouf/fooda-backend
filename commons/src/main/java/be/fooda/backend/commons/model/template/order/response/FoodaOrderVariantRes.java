// FoodaOrderVariantRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderVariantRes {
    private String title;
    private String price;
}