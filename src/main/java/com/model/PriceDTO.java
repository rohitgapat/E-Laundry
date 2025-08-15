package com.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PriceDTO {
    private Long id;
    private double pricePerUnit;
    private ItemDTO item;
    private ServiceTypeDTO service;
}
