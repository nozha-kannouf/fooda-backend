package be.fooda.backend.commons.model.template.media.request;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaMediaAppReq {
    private Long appSourceMediaId;
    private FoodaMediaAppSourceReq appSource;
    private FoodaMediaTypeReq type;
    private String url;
}