package Sber.test.basket.services;

import Sber.test.basket.models.Order;
import Sber.test.basket.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Сервис для управления заказами.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Получить список всех заказов.
     *
     * @return список всех заказов
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Получить заказ по его идентификатору.
     *
     * @param id идентификатор заказа
     * @return заказ, если он существует, или пустой Optional, если заказ не найден
     */
    public Optional<Order> getOrderById(long id) {
        return orderRepository.findById(id);
    }

    /**
     * Добавить новый заказ.
     *
     * @param orderEntity новый заказ
     * @return сохраненный заказ
     */
    public Order addOrder(Order orderEntity) {
        return orderRepository.save(orderEntity);
    }

    /**
     * Обновить существующий заказ.
     *
     * @param orderEntity заказ для обновления
     */
    public void updateOrder(Order orderEntity) {
        orderRepository.save(orderEntity);
    }

    /**
     * Удалить заказ по его идентификатору.
     *
     * @param id идентификатор заказа для удаления
     */
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
