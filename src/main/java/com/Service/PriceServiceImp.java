package com.Service;

import com.entity.Price;
import com.entity.Items;
import com.entity.ServiceType;
import com.repository.PriceRepository;
import com.repository.ItemsRepository;
import com.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImp implements PriceService {

    @Autowired
    private PriceRepository priceRepo;

    @Autowired
    private ItemsRepository itemsRepo;

    @Autowired
    private ServiceTypeRepository serviceTypeRepo;

    @Override
    public Price setPrice(Long itemId, Long serviceId, double pricePerUnit) {
        Items item = itemsRepo.findById(itemId).orElse(null);
        ServiceType service = serviceTypeRepo.findById(serviceId).orElse(null);

        if (item == null || service == null) {
            return null; // invalid IDs
        }

        Price price = new Price();
        price.setItem(item);
        price.setService(service);
        price.setPricePerUnit(pricePerUnit);

        return priceRepo.save(price);
    }

    @Override
    public double getPrice(Long itemId, Long serviceId) {
        Price price = priceRepo.findByItemIdAndServiceId(itemId, serviceId);
        return (price != null) ? price.getPricePerUnit() : 0.0;
    }
}
