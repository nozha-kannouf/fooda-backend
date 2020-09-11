package be.fooda.backend.user.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import be.fooda.backend.commons.service.validator.PhoneNumber;
import be.fooda.backend.commons.service.validator.UniqueLogin;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class FoodaUserDto extends FoodaAbstractDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @UniqueLogin
    @NotNull
    @PhoneNumber
    private String login;
    private char[] password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE_DETAIL",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<FoodaUserRoleDto> roles;

}
