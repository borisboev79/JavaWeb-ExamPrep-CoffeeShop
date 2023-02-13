package examprep.coffeeshop.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeViewModel {
    private String firstName;
    private int orders;
}
