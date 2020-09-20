package com.shop.domain.dto;

public class ItemDTO {
    private String name;
    private double price;
    private int order_quantity;
    private double price_per_quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public double getPrice_per_quantity() {
        return price_per_quantity;
    }

    public void setPrice_per_quantity(double price_per_quantity) {
        this.price_per_quantity = price_per_quantity;
    }
}
