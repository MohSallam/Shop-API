package com.shop.Shop.API.service;

import com.shop.Shop.API.domain.Cart;
import com.shop.Shop.API.domain.Item;
import com.shop.Shop.API.exceptions.CartNotFoundException;
import com.shop.Shop.API.exceptions.ItemNotFoundException;
import com.shop.Shop.API.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepo itemRepo;


    public void save(Item item){
        itemRepo.save(item);
    }

    public List<Item> getAll(){
        return itemRepo.findAll();
    }

    public Item findById(long id){
        return itemRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }
}
