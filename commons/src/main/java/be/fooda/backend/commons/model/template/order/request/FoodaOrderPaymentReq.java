// FoodaOrderPaymentRes.java

package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaOrderPaymentReq {
    private String title;
    private String method;
    private double amount;
}