package com.shop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private long id;
    private long userId;
    private double price = 0;
    @OneToMany(mappedBy = "cartId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemOrder> orders = new ArrayList<>();

    public Cart() {
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ItemOrder> getItemOrders() {
        return orders;
    }

    public void setItemOrders(List<ItemOrder> orders) {
        this.orders = orders;
    }

    public void addOrder(ItemOrder order) {
        this.orders.add(order);
    }

    public void removeOrder(ItemOrder order) {
        this.orders.remove(order);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
