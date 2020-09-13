package com.shop.Shop.API.exceptions;

public class CartNotFoundException extends RuntimeException{


    public CartNotFoundException(long id) {
        super("The requested cart with ID : " + id + " is not found");
    }
}
