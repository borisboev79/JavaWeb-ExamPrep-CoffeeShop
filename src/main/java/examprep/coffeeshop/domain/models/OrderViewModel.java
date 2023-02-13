package examprep.coffeeshop.domain.models;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private int neededTime;
    private String employee;
}
