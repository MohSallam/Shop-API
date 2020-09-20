package com.shop.controllers;

import com.shop.domain.ItemOrder;
import com.shop.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create/{user_id}")
    public ResponseEntity<?> createCart(@PathVariable("user_id") long userId) {
        return new ResponseEntity<>(cartService.createCart(userId), HttpStatus.CREATED);
    }

    @PostMapping("/{cart_id}/order")
    public ResponseEntity<?> order(@PathVariable("cart_id") long id, @RequestBody List<ItemOrder> orders) {
        return new ResponseEntity<>(cartService.addOrder(orders, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCartById(@PathVariable long id) {
        return new ResponseEntity<>(cartService.findById(id), HttpStatus.OK);
    }
}
