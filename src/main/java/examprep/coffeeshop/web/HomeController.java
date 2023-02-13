package examprep.coffeeshop.web;

import examprep.coffeeshop.domain.models.EmployeeViewModel;
import examprep.coffeeshop.domain.models.OrderViewModel;
import examprep.coffeeshop.services.order.OrderService;
import examprep.coffeeshop.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public HomeController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String getIndex(){
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView model){

        List<OrderViewModel> orders = this.orderService.getAllOrders();
        List<EmployeeViewModel> employees = this.userService.getAllEmployeesAndOrders();

        model.setViewName("home");
        model.addObject("orders", orders);
        model.addObject("totalTime", orders.stream().mapToInt(OrderViewModel::getNeededTime).sum());
        model.addObject("employees", employees);

        return model;
    }

    @GetMapping("/ready/{id}")
    public String readyOrder(@PathVariable Long id){
        this.orderService.deleteOrderById(id);
        return "redirect:/home";
    }
}
