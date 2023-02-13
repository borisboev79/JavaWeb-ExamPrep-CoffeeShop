package examprep.coffeeshop.services.order;

import examprep.coffeeshop.domain.entities.Order;
import examprep.coffeeshop.domain.entities.User;
import examprep.coffeeshop.domain.helpers.LoggedUser;
import examprep.coffeeshop.domain.models.OrderViewModel;
import examprep.coffeeshop.domain.models.binding.OrderAddModel;
import examprep.coffeeshop.repositories.CategoryRepository;
import examprep.coffeeshop.repositories.OrderRepository;
import examprep.coffeeshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper mapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    private final LoggedUser loggedUser;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper mapper, UserRepository userRepository, CategoryRepository categoryRepository, LoggedUser loggedUser) {
        this.orderRepository = orderRepository;
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
    }


    @Override
    public void saveOrder(OrderAddModel model) {
        Order order = new Order();
        mapper.map(model, order);
        order.setCategory(this.categoryRepository.findByName(model.getCategory()).orElseThrow(NoSuchElementException::new));
        order.setEmployee(this.userRepository.findById(loggedUser.getId()).orElse(new User()));

        this.orderRepository.saveAndFlush(order);
    }

    @Override
    public List<OrderViewModel> getAllOrders() {

        return this.orderRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Order::getPrice).reversed())
                .map(order -> OrderViewModel.builder()
                        .id(order.getId())
                        .name(order.getName())
                        .price(order.getPrice())
                        .category(order.getCategory().getName().name())
                        .neededTime(order.getCategory().getNeededTime())
                        .employee(order.getEmployee().getUsername())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrderById(Long id) {
        this.orderRepository.delete(this.orderRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }


}
