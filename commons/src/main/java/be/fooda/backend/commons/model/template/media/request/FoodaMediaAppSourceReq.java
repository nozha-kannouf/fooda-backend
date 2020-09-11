package be.fooda.backend.commons.model.template.media.request;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaMediaAppSourceReq {
    private Long appSourceId;
    private String title;
    private String url;
    private String resolution;
    private Boolean mustBeCached;
}
