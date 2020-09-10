// OrderedProduct.java

package be.fooda.backend.commons.model.template.order.response;

import java.math.BigDecimal;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderProductRes {
    private Long productId;
    private String name;
    private Long quantity;
    private BigDecimal price;
    private FoodaOrderVariantRes variant;
    private String type;
}