package com.samueldale.ecommerce.service;

import com.samueldale.ecommerce.model.Order;
import com.samueldale.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public List<Order> getAllOrders(){
        return repo.findAll();
    }
    public Order addOrder(Order order) {
        return repo.save(order);
    }

}
