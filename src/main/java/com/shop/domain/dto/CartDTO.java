package com.shop.domain.dto;

import java.util.List;

public class CartDTO {
    private double total_price;
    private List<ItemDTO> item_dtos;

    public CartDTO(double total_price, List<ItemDTO> item_dtos) {
        this.total_price = total_price;
        this.item_dtos = item_dtos;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public List<ItemDTO> getItems() {
        return item_dtos;
    }

    public void setItem_dtos(List<ItemDTO> item_dtos) {
        this.item_dtos = item_dtos;
    }
}
