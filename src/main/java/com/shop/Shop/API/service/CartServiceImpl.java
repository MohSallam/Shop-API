package com.shop.Shop.API.service;

import com.shop.Shop.API.domain.Cart;
import com.shop.Shop.API.exceptions.CartNotFoundException;
import com.shop.Shop.API.repos.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepo cartRepo;

    public List<Cart> findAll(){
        return cartRepo.findAll();
    }
    public void save(Cart cart){
        cartRepo.save(cart);
    }
    public Cart findById(long id){
        return cartRepo.findById(id).orElseThrow(() -> new CartNotFoundException(id));
    }

}
