package be.fooda.backend.commons.model.template.product.response;

import lombok.*;
@NoArgsConstructor
@Data
@Builder
public class FoodaProductTaxesItemRes {
    private Double percentage;
    private String title;
    private Long taxId;
    private Boolean isDefault;
}