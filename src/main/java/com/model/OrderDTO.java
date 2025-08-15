package com.model;

import lombok.*;
import java.sql.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDTO {
    private Long id;
    private Date orderDate;
    private String status;
    private String pickupDate;
    private String deliveryDate;
    private UserDTO user;
    private List<OrderItemDTO> orderItems;
}
