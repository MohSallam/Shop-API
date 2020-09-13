package com.shop.Shop.API.exceptions;

public class QuantityNotEnoughException extends RuntimeException {

    public QuantityNotEnoughException(int quantity) {
        super("The requested quantity : " + quantity + " is more than the stock quantity");
    }
}
