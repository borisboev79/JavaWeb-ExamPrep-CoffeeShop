package examprep.coffeeshop.services.user;

import examprep.coffeeshop.domain.models.UserModel;

public interface UserService {
    UserModel findByUsername(String username);
}
