package be.fooda.backend.commons.model.template.user.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FoodaUserReq {
    private final String login;
    private final String password;
}
