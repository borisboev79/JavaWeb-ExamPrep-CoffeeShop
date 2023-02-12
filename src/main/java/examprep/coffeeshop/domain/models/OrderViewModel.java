package examprep.coffeeshop.domain.models;

import examprep.coffeeshop.domain.entities.Category;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderViewModel {
    private String name;
    private BigDecimal price;
    private String category;
    private int neededTime;
    private String employee;
}
