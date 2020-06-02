package it.vkod.woo.product.client.pojo.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderResponseShipping {
    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String address_1;
    @Getter
    @Setter
    private String address_2;
    @Getter
    @Setter
    private String postcode;
    @Getter
    @Setter
    private String last_name;
    @Getter
    @Setter
    private String company;
    @Getter
    @Setter
    private String state;
    @Getter
    @Setter
    private String first_name;
}
