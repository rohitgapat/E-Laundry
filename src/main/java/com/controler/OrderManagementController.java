package com.controler;

import com.Service.OrderManagementService;
import com.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-management")
public class OrderManagementController {

    @Autowired
    private OrderManagementService orderManagementService;

    @PutMapping("/update/{orderId}")
    public Order updateOrderStatus(@PathVariable Long orderId,
                                   @RequestParam String status) {
        return orderManagementService.updateOrderStatus(orderId, status);
    }

    @PutMapping("/cancel/{orderId}")
    public String cancelOrder(@PathVariable Long orderId) {
        return orderManagementService.cancelOrder(orderId);
    }

    @GetMapping("/total/{orderId}")
    public double calculateTotalCost(@PathVariable Long orderId) {
        return orderManagementService.calculateTotalCost(orderId);
    }

    @GetMapping("/invoice/{orderId}")
    public String viewInvoice(@PathVariable Long orderId) {
        return orderManagementService.viewInvoice(orderId);
    }
}
