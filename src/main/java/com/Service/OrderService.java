package com.Service;

import java.util.List;

import com.entity.Order;
import com.entity.OrderItem;

public interface OrderService {

    Order placeOrder(Long userId, List<OrderItem> orderItems);

    List<Order> getOrdersByUser(Long userId);
}
