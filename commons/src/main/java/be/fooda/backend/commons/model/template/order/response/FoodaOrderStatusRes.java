// FoodaOrderStatusRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderStatusRes {
    private String title;
    private String parent;
}