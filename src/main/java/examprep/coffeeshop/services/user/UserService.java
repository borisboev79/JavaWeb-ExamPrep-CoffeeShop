package examprep.coffeeshop.services.user;

import examprep.coffeeshop.domain.models.EmployeeViewModel;
import examprep.coffeeshop.domain.models.UserModel;

import java.util.List;


public interface UserService {
    UserModel findByUsername(String username);

    List<EmployeeViewModel> getAllEmployeesAndOrders();

}
