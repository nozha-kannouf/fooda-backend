package be.fooda.backend.commons.model.template.media.request;

import lombok.NoArgsConstructor;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaMediaStoreInfoReq {
    private Long storeId;
    private String name;
}
