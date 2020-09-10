// FoodaOrderContactRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderContactRes {
    private String firstName;
    private String familyName;
    private String company;
    private String phoneNumber;
    private String email;
    private String call;
}