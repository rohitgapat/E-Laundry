package com.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_date")
    private java.sql.Date orderDate;

    @Column(name = "status")
    private String status;

    @Column(name = "pickup_date")
    private String pickupDate;

    @Column(name = "delivery_date")
    private String deliveryDate;

    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();
}
