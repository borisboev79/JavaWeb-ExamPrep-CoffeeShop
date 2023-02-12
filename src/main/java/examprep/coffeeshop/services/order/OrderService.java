package examprep.coffeeshop.services.order;

import examprep.coffeeshop.domain.models.binding.OrderAddModel;

public interface OrderService {
    void saveOrder(OrderAddModel model);
}
