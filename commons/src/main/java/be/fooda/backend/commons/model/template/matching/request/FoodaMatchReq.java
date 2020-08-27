package be.fooda.backend.commons.model.template.matching.request;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class FoodaMatchReq {
    private Long userId;
    private String session;
    private Set<String> keywordSet;
}