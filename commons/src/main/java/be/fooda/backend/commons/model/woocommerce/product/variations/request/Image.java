package be.fooda.backend.commons.model.woocommerce.product.variations.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Image {

    @JsonProperty("id")
    private Integer id;
}