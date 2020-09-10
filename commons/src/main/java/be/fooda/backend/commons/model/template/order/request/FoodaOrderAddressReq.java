// FoodaOrderAddressRes.java

package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderAddressReq {
    private String number;
    private String street;
    private String municipality;
    private String city;
    private String region;
    private String country;
    private String doorNo;
}