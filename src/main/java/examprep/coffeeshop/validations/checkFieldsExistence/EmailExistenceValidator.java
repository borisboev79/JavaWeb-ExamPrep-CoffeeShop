package examprep.coffeeshop.validations.checkFieldsExistence;

import examprep.coffeeshop.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailExistenceValidator implements ConstraintValidator<ValidateEmailExistence, String> {
    private final UserRepository userRepository;

    @Autowired
    public EmailExistenceValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(ValidateEmailExistence constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return this.userRepository.findByEmail(email).isEmpty();
    }
}
