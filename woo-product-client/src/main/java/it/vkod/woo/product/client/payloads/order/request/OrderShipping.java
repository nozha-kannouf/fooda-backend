package it.vkod.woo.product.client.payloads.order.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderShipping {
    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String address1;
    @Getter
    @Setter
    private String address2;
    @Getter
    @Setter
    private String postcode;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String state;
    @Getter
    @Setter
    private String firstName;
}