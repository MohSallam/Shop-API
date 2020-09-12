package com.shop.Shop.API.exceptions;

public class CartNotFoundException extends RuntimeException{


    public CartNotFoundException(long id) {
        super("Could not find cart with ID : " + id);
    }
}
