package examprep.coffeeshop.domain.models;

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
    private String employee;
}
