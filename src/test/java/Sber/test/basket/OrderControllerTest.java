package Sber.test.basket;

import Sber.test.basket.controllers.OrderController;
import Sber.test.basket.models.Order;
import Sber.test.basket.services.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;

import java.util.Optional;
import java.util.Collections;

import static org.mockito.Mockito.*;

/**
 * Тесты для контроллера OrderController.
 */
@WebMvcTest(OrderController.class)
public class OrderControllerTest {


    @MockBean
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Autowired
    private MockMvc mockMvc;

    /**
     * Тест для метода получения всех заказов.
     */
    @Test
    public void testGetAllOrders() throws Exception {
        when(orderService.getAllOrders()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/orders/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("orders"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("orders"));
    }

    /**
     * Тест для метода отображения формы добавления нового заказа.
     */
    @Test
    public void testShowAddOrderForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("add-order"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("order"));
    }

    /**
     * Тест для метода добавления нового заказа.
     */
    @Test
    public void testAddOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/orders/add")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Test Order")
                        .param("price", "100"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/orders/"));

        verify(orderService, times(1)).addOrder(any());
    }

    /**
     * Тест для метода отображения формы редактирования заказа.
     */
    @Test
    public void testShowEditOrderForm() throws Exception {
        long orderId = 1;
        when(orderService.getOrderById(orderId)).thenReturn(Optional.of(new Order()));

        mockMvc.perform(MockMvcRequestBuilders.get("/orders/edit/" + orderId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("edit-order"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("order"));
    }

    /**
     * Тест для метода обновления заказа.
     */
    @Test
    public void testUpdateOrder() throws Exception {
        long orderId = 1;
        mockMvc.perform(MockMvcRequestBuilders.post("/orders/edit/" + orderId)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Updated Test Order")
                        .param("price", "150"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/orders/"));

        verify(orderService, times(1)).updateOrder(any());
    }

    /**
     * Тест для метода удаления заказа.
     */
    @Test
    public void testDeleteOrder() throws Exception {
        long orderId = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/delete/" + orderId))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/orders/"));

        verify(orderService, times(1)).deleteOrder(orderId);
    }
}
