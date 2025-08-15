package com.controler;

import com.entity.Items;
import com.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public String addItem(@RequestBody Items item) {
        return itemService.addItems(item);
    }

    @GetMapping
    public List<Items> getAllItems() {
        return itemService.getAllItemas();
    }
}
