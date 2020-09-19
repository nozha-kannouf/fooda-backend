// FoodaOrderStoreRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaOrderStoreRes {
    private long orderStoreId;
    private long storeId;
    private String name;
    private String logo;
    private FoodaOrderAddressRes address;
    private FoodaOrderContactRes contact;
}
