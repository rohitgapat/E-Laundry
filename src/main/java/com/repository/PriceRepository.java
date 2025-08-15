package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Long>{
    @Query("SELECT p FROM Price p WHERE p.item.id = :itemId AND p.service.id = :serviceId")
    Price findByItemIdAndServiceId(Long itemId, Long serviceId);


}
