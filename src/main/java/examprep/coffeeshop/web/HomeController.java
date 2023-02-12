package examprep.coffeeshop.web;

import examprep.coffeeshop.domain.models.OrderViewModel;
import examprep.coffeeshop.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final OrderService orderService;

    @Autowired
    public HomeController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getIndex(){
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView model){

        List<OrderViewModel> orders = this.orderService.getAllOrders();
        int totalNeededTime = orders.stream().mapToInt(OrderViewModel::getNeededTime).sum();

        model.setViewName("home");
        model.addObject("orders", orders);
        model.addObject("totalTime", totalNeededTime);

        return model;
    }
}
