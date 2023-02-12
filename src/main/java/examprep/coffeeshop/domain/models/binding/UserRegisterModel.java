package examprep.coffeeshop.domain.models.binding;

import examprep.coffeeshop.validations.checkFieldsExistence.ValidateEmailExistence;
import examprep.coffeeshop.validations.checkFieldsExistence.ValidateUserExistence;
import examprep.coffeeshop.validations.passwordMatcher.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@PasswordMatch
public class UserRegisterModel {

    @Size(min = 5, max = 20)
    @NotNull
    @ValidateUserExistence
    private String username;

    private String firstName;

    @Size(min = 5, max = 20)
    @NotNull
    private String lastName;

    @Size(min = 3)
    @NotNull
    private String password;

    @Size(min = 3)

    @NotNull
    private String confirmPassword;

    @Email
    @ValidateEmailExistence
    @NotEmpty
    private String email;
}
