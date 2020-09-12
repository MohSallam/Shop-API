package com.shop.Shop.API.service;

import com.shop.Shop.API.domain.Item;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {

    public void save(Item item);
    public List<Item> getAll();
    Item findById(long id);
}
