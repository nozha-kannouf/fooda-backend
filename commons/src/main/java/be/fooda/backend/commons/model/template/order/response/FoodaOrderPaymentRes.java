// FoodaOrderPaymentRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaOrderPaymentRes {
    private String title;
    private String method;
    private double amount;
}