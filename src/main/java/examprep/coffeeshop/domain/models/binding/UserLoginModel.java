package examprep.coffeeshop.domain.models.binding;

import examprep.coffeeshop.validations.validateLoginForm.ValidateLoginForm;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ValidateLoginForm
public class UserLoginModel {

    @Size(min = 5, max = 20)
    @NotNull
    private String username;

    @Size(min = 3)
    @NotNull
    private String password;


}
