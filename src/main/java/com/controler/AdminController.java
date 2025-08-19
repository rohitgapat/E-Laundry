package com.controler;

import com.Service.AdminService;
import com.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/orders")
    public List<Order> viewAllOrders() {
        return adminService.viewAllOrders();
    }
}
