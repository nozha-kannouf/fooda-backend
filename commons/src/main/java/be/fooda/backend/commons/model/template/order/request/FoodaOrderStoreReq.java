// FoodaOrderStoreRes.java

package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderStoreReq {
    private Long storeId;
    private String name;
    private String logo;
    private FoodaOrderAddressReq address;
    private FoodaOrderContactReq contact;
}
