package com.samueldale.ecommerce.controller;

import com.samueldale.ecommerce.model.Order;
import com.samueldale.ecommerce.model.UserEntity;
import com.samueldale.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return service.getAllOrders();
    }

    @PostMapping("/orders/add")
    public Order addOrder(@RequestBody Order order){
        return service.addOrder(order);
    }

}
