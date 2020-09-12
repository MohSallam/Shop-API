package com.shop.Shop.API.service;

import com.shop.Shop.API.domain.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
    void save(Cart cart);
    Cart findById(long id);
}
