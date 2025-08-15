package com.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderItemDTO {
    private Long id;
    private int quantity;
    private ItemDTO item;
    private ServiceTypeDTO service;
    private double totalPrice;
    private OrderDTO order;
}
