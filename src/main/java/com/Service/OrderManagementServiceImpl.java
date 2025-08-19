
package com.Service;

import com.entity.Order;
import com.entity.OrderItem;
import com.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManagementServiceImpl implements OrderManagementService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepo.findById(orderId).orElse(null);
        if (order == null) return null;

        order.setStatus(status);
        return orderRepo.save(order);
    }

    @Override
    public String cancelOrder(Long orderId) {
        Order order = orderRepo.findById(orderId).orElse(null);
        if (order == null) return "Order not found";

        order.setStatus("CANCELLED");
        orderRepo.save(order);
        return "Order cancelled successfully";
    }

    @Override
    public double calculateTotalCost(Long orderId) {
        Order order = orderRepo.findById(orderId).orElse(null);
        if (order == null) return 0.0;

        return order.getOrderItems()
                    .stream()
                    .mapToDouble(OrderItem::getTotalPrice)
                    .sum();
    }

    @Override
    public String viewInvoice(Long orderId) {
        Order order = orderRepo.findById(orderId).orElse(null);
        if (order == null) return "Order not found";

        double totalCost = calculateTotalCost(orderId);

        return "Invoice for Order ID: " + orderId +
               "\nStatus: " + order.getStatus() +
               "\nTotal Cost: ₹" + totalCost;
    }
}
