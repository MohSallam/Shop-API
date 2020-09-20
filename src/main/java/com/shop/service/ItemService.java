package com.shop.service;

import com.shop.domain.Item;

import java.util.List;

public interface ItemService {

    void save(Item item);

    List<Item> getAll();

    Item findById(long id);
}
