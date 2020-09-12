package com.shop.Shop.API.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int stockQty;
    private double price;

    public Item() {
    }

    public Item(String name, int stockQty, double price) {
        this.name = name;
        this.stockQty = stockQty;
        this.price = price;
    }

    public long getid() {
        return id;
    }

    private void setid(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stockQty;
    }

    public void setStockQuantity(int stockQty) {
        this.stockQty = stockQty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
