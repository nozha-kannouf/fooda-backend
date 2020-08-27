package be.fooda.backend.commons.model.template.order.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import be.fooda.backend.commons.model.template.product.dto.FoodaProductKeyDto;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "ORDER_PRODUCT")
public class FoodaOrderProductDto extends FoodaAbstractDto{
    private FoodaProductKeyDto productKey;
    private Integer quantity;
    private BigDecimal price;
}