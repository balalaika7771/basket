package Sber.test.basket.controllers;

import Sber.test.basket.DTO.OrderDTO;
import Sber.test.basket.models.Order;
import Sber.test.basket.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для управления заказами.
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Получить все заказы.
     *
     * @param model модель для передачи данных в представление
     * @return представление списка заказов
     */
    @GetMapping("/")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }
    /**
     * Показать форму для добавления нового заказа.
     *
     * @param model модель для передачи данных в представление
     * @return представление формы добавления заказа
     */
    @GetMapping("/add")
    public String showAddOrderForm(Model model) {
        model.addAttribute("order", new OrderDTO());
        return "add-order";
    }

    /**
     * Добавить новый заказ.
     *
     * @param order данные нового заказа
     * @return перенаправление на список заказов после добавления
     */
    @PostMapping("/add")
    public String addOrder(@ModelAttribute OrderDTO order) {

        orderService.addOrder(order.replace(new Order()));
        return "redirect:/orders/";
    }

    /**
     * Показать форму для редактирования заказа.
     *
     * @param id    идентификатор заказа для редактирования
     * @param model модель для передачи данных в представление
     * @return представление формы редактирования заказа
     */
    @GetMapping("/edit/{id}")
    public String showEditOrderForm(@PathVariable("id") long id, Model model) {
        Optional<Order> order = orderService.getOrderById(id);
        if (order.isPresent()) {
            model.addAttribute("order", new OrderDTO(order.get()));
            return "edit-order";
        } else {
            model.addAttribute("errorMessage", "Order not found!");
            return "error";
        }
    }

    /**
     * Обновить существующий заказ.
     *
     * @param id    идентификатор заказа для обновления
     * @param order данные заказа для обновления
     * @return перенаправление на список заказов после обновления
     */
    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable("id") long id, @ModelAttribute OrderDTO order) {
        order.setId(id);
        orderService.updateOrder(order.replace(new Order()));
        return "redirect:/orders/";
    }

    /**
     * Удалить заказ.
     *
     * @param id идентификатор заказа для удаления
     * @return перенаправление на список заказов после удаления
     */
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders/";
    }
}