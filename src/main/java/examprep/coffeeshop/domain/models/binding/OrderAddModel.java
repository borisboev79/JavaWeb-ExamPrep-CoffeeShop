package examprep.coffeeshop.domain.models.binding;

import examprep.coffeeshop.domain.enums.CategoryType;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderAddModel {

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @PastOrPresent
    private LocalDateTime orderTime;

    @NotNull
    private CategoryType category;

    @NotEmpty
    @Size(min = 5)
    private String description;
}
