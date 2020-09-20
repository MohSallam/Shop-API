package com.shop.service;

import com.shop.domain.Cart;
import com.shop.domain.ItemOrder;
import com.shop.domain.dto.GeneralDTO;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<Cart> findAll();

    void save(Cart cart);

    Cart findById(long id);

    Cart checkCart(long id);

    GeneralDTO createCart(long userId);

    Map<String, Object> addOrder(List<ItemOrder> orders, long id);
}
