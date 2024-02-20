package Sber.test.basket.services;

import Sber.test.basket.models.Order;
import Sber.test.basket.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(long id) {
        return orderRepository.findById(id);
    }

    public Order addOrder(Order orderEntity) {
        return orderRepository.save(orderEntity);
    }
    public void updateOrder(Order orderEntity) {
        orderRepository.save(orderEntity);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
