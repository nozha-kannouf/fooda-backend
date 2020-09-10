// OrderedProduct.java

package be.fooda.backend.commons.model.template.order.request;

import java.math.BigDecimal;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderProductReq {
    private Long productId;
    private String name;
    private Long quantity;
    private BigDecimal price;
    private FoodaOrderVariantReq variant;
    private String type;
}