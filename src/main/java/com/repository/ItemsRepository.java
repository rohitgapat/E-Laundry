package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Long>{

}
