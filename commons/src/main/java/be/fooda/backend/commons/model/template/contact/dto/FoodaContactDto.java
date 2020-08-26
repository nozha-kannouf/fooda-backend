package be.fooda.backend.commons.model.template.contact.dto;

import be.fooda.backend.commons.service.validator.PhoneNumber;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "CONTACT")
public class FoodaContactDto {
    @Id
    private Integer contactId;
    @NotNull
    private Integer userId;
    @NotNull
    private String firstName;
    @NotNull
    private String familyName;
    private String companyName;
    @PhoneNumber
    private String phoneNumber;
    @Email
    private String email;
    private Boolean canCall;
}