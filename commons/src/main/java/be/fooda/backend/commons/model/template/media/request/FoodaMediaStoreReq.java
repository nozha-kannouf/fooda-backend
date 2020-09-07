package be.fooda.backend.commons.model.template.media.request;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaMediaStoreReq {
    private Long storeMediaId;
    private FoodaMediaStoreInfoReq store;
    private FoodaMediaTypeReq type;
    private String url;
}