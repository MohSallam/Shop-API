package com.shop.Shop.API.controllers;

import com.shop.Shop.API.domain.Item;
import com.shop.Shop.API.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;



    @GetMapping("/items")
    public List<Item> findAll(){
        return itemService.getAll();
    }




}
