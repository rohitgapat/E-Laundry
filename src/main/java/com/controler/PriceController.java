package com.controler;

import com.entity.Price;
import com.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/set")
    public Price setPrice(@RequestParam Long itemId,
                          @RequestParam Long serviceId,
                          @RequestParam double pricePerUnit) {
        return priceService.setPrice(itemId, serviceId, pricePerUnit);
    }

    @GetMapping("/get")
    public double getPrice(@RequestParam Long itemId,
                           @RequestParam Long serviceId) {
        return priceService.getPrice(itemId, serviceId);
    }
}
