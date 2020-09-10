// FoodaOrderContactRes.java

package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderContactReq {
    private String firstName;
    private String familyName;
    private String company;
    private String phoneNumber;
    private String email;
    private String call;
}