package com.Service;

import com.entity.Price;

public interface PriceService {

    Price setPrice(Long itemId, Long serviceId, double pricePerUnit);

    double getPrice(Long itemId, Long serviceId);
	
}
