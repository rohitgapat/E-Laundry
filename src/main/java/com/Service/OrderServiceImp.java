package com.Service;

import com.entity.Order;
import com.entity.OrderItem;
import com.entity.User;
import com.repository.OrderRepository;
import com.repository.OrderItemRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Order placeOrder(Long userId, List<OrderItem> orderItems) {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) return null;

        Order order = new Order();
        order.setUser(user);
        order.setStatus("PLACED");
        order = orderRepo.save(order);

        for (OrderItem item : orderItems) {
            item.setOrder(order);
            orderItemRepo.save(item);
        }

        order.setOrderItems(orderItems);
        return order;
    }

    @Override
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepo.findByUserId(userId);
    }
}
