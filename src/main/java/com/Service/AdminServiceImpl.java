package com.Service;

import com.entity.Order;
import com.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public List<Order> viewAllOrders() {
        return orderRepo.findAll();
    }
}
