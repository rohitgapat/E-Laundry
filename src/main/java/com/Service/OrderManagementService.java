package com.Service;

import com.entity.Order;

public interface OrderManagementService {

    Order updateOrderStatus(Long orderId, String status);

    String cancelOrder(Long orderId);

    double calculateTotalCost(Long orderId);

    String viewInvoice(Long orderId);
}