package examprep.coffeeshop.services.user;

import examprep.coffeeshop.domain.models.binding.UserLoginModel;
import examprep.coffeeshop.domain.models.binding.UserRegisterModel;

public interface AuthService {

    default void registerUser(UserRegisterModel userRegisterModel) {
    }

    default void loginUser(UserLoginModel userLoginModel) {
    }

    default void logoutUser() {
    }
}
