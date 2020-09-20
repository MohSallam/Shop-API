package com.shop.service;

import com.shop.domain.Item;
import com.shop.exceptions.ItemNotFoundException;
import com.shop.repos.ItemRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;

    ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public void save(Item item) {
        itemRepo.save(item);
    }

    public List<Item> getAll() {
        return itemRepo.findAll();
    }

    public Item findById(long id) {
        return itemRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }
}
