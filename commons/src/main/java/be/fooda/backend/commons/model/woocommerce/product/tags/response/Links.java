package be.fooda.backend.commons.model.woocommerce.product.tags.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Links {

    @JsonProperty("self")
    private List<SelfItem> self;

    @JsonProperty("collection")
    private List<CollectionItem> collection;
}