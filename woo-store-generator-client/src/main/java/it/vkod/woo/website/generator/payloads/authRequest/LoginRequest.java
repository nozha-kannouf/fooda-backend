package it.vkod.woo.website.generator.payloads.authRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    @JsonProperty
    private String usernameOrEmail;

    @NotBlank
    @JsonProperty
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(@NotBlank String usernameOrEmail, @NotBlank String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
