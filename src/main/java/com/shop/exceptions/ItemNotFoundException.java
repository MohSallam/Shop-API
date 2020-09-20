package com.shop.exceptions;

public class ItemNotFoundException extends RuntimeException{


    public ItemNotFoundException(long id) {
        super("Could not find item with ID : " + id);
    }
}
