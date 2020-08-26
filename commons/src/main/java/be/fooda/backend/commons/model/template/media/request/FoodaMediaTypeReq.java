package be.fooda.backend.commons.model.template.media.request;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaMediaTypeReq {
    private Long typeId;
    private String title;
    private String extension;
}
