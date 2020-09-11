package be.fooda.backend.commons.model.template.product.response;

import lombok.*;
@NoArgsConstructor
@Data
@Builder
public class FoodaProductImagesItemRes {
    private Long mediaId;
    private FoodaProductTypeRes type;
    private String url;
    private Boolean isDefault;
}