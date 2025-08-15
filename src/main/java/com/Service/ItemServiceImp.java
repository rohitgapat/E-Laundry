package com.Service;

import com.entity.Items;
import com.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemsRepository itemRepo;

    @Override
    public String addItems(Items item) {
        itemRepo.save(item);
        return "Item added successfully";
    }

    @Override
    public List<Items> getAllItemas() {
        return itemRepo.findAll();
    }
}
