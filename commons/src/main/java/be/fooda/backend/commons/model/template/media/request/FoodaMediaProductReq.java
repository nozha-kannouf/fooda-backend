package be.fooda.backend.commons.model.template.media.request;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaMediaProductReq {
    private Long productMediaId;
    private FoodaMediaStoreReq store;
    private FoodaMediaProductInfoReq product;
    private FoodaMediaTypeReq type;
    private String url;
}