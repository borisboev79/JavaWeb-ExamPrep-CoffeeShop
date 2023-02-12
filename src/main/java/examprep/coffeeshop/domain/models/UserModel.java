package examprep.coffeeshop.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {

    private Long id;

    private String username;

    private String password;
}
