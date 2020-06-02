package it.vkod.woo.product.client.pojo.auth.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SignUpRequest {

    @NotBlank
    @Size(min = 4, max = 40)
    @Getter
    @Setter
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    @Getter
    @Setter
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    @Getter
    @Setter
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    @Getter
    @Setter
    private String password;
}
