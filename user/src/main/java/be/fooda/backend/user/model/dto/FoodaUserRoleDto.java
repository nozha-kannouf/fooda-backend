package be.fooda.backend.user.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Builder(toBuilder = true)
@Table(name = "USER_ROLE")
public class FoodaUserRoleDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;
    private String name;
}

