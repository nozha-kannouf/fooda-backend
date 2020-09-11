package be.fooda.backend.commons.model.template.user.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
public class FoodaUserRoleRes {
    private String title;
    private Boolean hasAccessToFooda;
    private Boolean hasAccessToResta;
    private Boolean hasAccessToDella;
}
