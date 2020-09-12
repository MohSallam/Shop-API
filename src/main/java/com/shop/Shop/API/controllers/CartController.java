package com.shop.Shop.API.controllers;


import com.shop.Shop.API.domain.Cart;
import com.shop.Shop.API.domain.Item;
import com.shop.Shop.API.domain.ItemDTO;
import com.shop.Shop.API.domain.ItemOrder;
import com.shop.Shop.API.service.CartService;
import com.shop.Shop.API.service.CartServiceImpl;
import com.shop.Shop.API.service.ItemService;
import com.shop.Shop.API.service.ItemServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ItemService itemService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<String> createCart(){
        Cart cart = new Cart();
        cartService.save(cart);
        return new ResponseEntity<>("Cart created with ID : " + cart.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> order(@PathVariable long id, @RequestBody List<ItemOrder> orders){
        Cart cart = cartService.findById(id);
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for(ItemOrder order : orders){
            Item item = itemService.findById(order.getItem().getid());
            if(order.getQuantity() > item.getStockQuantity()){
                return new ResponseEntity<String>("Quantity : "
                        + order.getQuantity() + " requested for item "
                        + item.getName() + " is more than stock quantity", HttpStatus.NOT_ACCEPTABLE);
            }
            item.setStockQuantity(item.getStockQuantity() - order.getQuantity());
            itemService.save(item);
            ItemOrder itemOrder = new ItemOrder(item, order.getQuantity(), cart.getId());
            cart.addOrder(itemOrder);
            cart.setPrice(cart.getPrice()+(itemOrder.getQuantity() * itemOrder.getItem().getPrice()));
            ItemDTO dto = modelMapper.map(item, ItemDTO.class);
            dto.setOrder_quantity(order.getQuantity());
            dto.setPrice_per_quantity(order.getQuantity() * item.getPrice());
            itemDTOS.add(dto);
        }
        cartService.save(cart);
        Map<String, Object> summary = new HashMap<>();
        summary.put("Total price", cart.getPrice());
        summary.put("Cart Items", itemDTOS);
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCartById(@PathVariable long id){
        return new ResponseEntity<>(cartService.findById(id), HttpStatus.OK);
    }


}
