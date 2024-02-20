package Sber.test.basket.controllers;

import Sber.test.basket.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

}
