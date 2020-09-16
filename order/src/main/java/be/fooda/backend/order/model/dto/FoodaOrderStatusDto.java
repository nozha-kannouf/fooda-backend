package be.fooda.backend.order.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDER_STATUS")
public class FoodaOrderStatusDto extends FoodaAbstractDto {
    @Id
    private Long statusId;
    private String title;
    @OneToOne
    private FoodaOrderStatusDto parent;
}