package com.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price_per_unit")
    private double pricePerUnit;

    @ManyToOne
    @JoinColumn(name = "item_id") // FK to items.id
    private Items item;

    @ManyToOne
    @JoinColumn(name = "service_id") // FK to service_type.id
    private ServiceType service;
}
