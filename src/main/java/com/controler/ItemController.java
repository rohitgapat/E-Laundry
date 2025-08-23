package com.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.ItemService;
import com.entity.Items;

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
