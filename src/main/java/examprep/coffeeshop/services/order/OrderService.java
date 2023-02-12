package examprep.coffeeshop.services.order;

import examprep.coffeeshop.domain.models.OrderViewModel;
import examprep.coffeeshop.domain.models.binding.OrderAddModel;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderAddModel model);

    List<OrderViewModel> getAllOrders();
}
