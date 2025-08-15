package com.controler;

import com.entity.Order;
import com.entity.OrderItem;
import com.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public Order placeOrder(@PathVariable Long userId, @RequestBody List<OrderItem> orderItems) {
        return orderService.placeOrder(userId, orderItems);
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }
}
