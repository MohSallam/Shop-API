package com.shop.Shop.API.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemOrder {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Item item;
    private int quantity;
    private long cartId;

    public ItemOrder() {
    }

    public ItemOrder(Item item, int quantity, long cartId) {
        this.item = item;
        this.quantity = quantity;
        this.cartId = cartId;
    }

    public long getId() {
        return id;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }
}
