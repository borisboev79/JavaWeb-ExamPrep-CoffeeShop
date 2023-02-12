package examprep.coffeeshop.web;

import examprep.coffeeshop.domain.models.binding.OrderAddModel;
import examprep.coffeeshop.services.order.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/add")
    public String getAddOrder(){
        return "order-add";
    }

    @PostMapping("/add")
    public String postAddOrder(@Valid @ModelAttribute(name="orderAddModel") OrderAddModel orderAddModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("orderAddModel", orderAddModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddModel", bindingResult);

            return "redirect:add";
        }


        this.orderService.saveOrder(orderAddModel);
        return "redirect:/home";
    }

    @ModelAttribute(name="orderAddModel")
    public OrderAddModel orderAddModel(){
        return new OrderAddModel();
    }
}
