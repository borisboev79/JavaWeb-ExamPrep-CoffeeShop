package examprep.coffeeshop.domain.entities;

import examprep.coffeeshop.domain.enums.CategoryType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryType name;

    @Column(name="needed_time", nullable = false)
    private int neededTime;


}
