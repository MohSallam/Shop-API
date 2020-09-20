package com.shop.controllers;

import com.shop.domain.Item;
import com.shop.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> findAll() {
        return itemService.getAll();
    }


}
