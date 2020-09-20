package com.shop.service;

import com.shop.domain.Cart;
import com.shop.domain.Item;
import com.shop.domain.ItemOrder;
import com.shop.domain.dto.GeneralDTO;
import com.shop.domain.dto.ItemDTO;
import com.shop.exceptions.CartNotFoundException;
import com.shop.exceptions.QuantityNotEnoughException;
import com.shop.repos.CartRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepo cartRepo;
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    CartServiceImpl(CartRepo cartRepo, ItemService itemService, ModelMapper modelMapper) {
        this.cartRepo = cartRepo;
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    public Cart checkCart(long id) {
        return findById(id);
    }

    public GeneralDTO createCart(long userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        save(cart);
        GeneralDTO generalDTO = new GeneralDTO();
        generalDTO.setHttpStatus(HttpStatus.CREATED);
        generalDTO.setMessage("Cart created with ID : " + cart.getId() + " for user with user id : " + cart.getUserId());
        return generalDTO;
    }

    public Map<String, Object> addOrder(List<ItemOrder> orders, long id) {
        Cart cart = checkCart(id);
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (ItemOrder order : orders) {
            Item item = itemService.findById(order.getItem().getid());
            if (order.getQuantity() > item.getStockQuantity())
                throw new QuantityNotEnoughException(order.getQuantity());
            item.setStockQuantity(item.getStockQuantity() - order.getQuantity());
            itemService.save(item);
            ItemOrder itemOrder = new ItemOrder(item, order.getQuantity(), cart.getId());
            cart.addOrder(itemOrder);
            cart.setPrice(cart.getPrice() + (itemOrder.getQuantity() * itemOrder.getItem().getPrice()));
            ItemDTO itemDto = modelMapper.map(item, ItemDTO.class);
            itemDto.setOrder_quantity(order.getQuantity());
            itemDto.setPrice_per_quantity(order.getQuantity() * item.getPrice());
            itemDTOS.add(itemDto);
        }
        save(cart);
        Map<String, Object> summary = new HashMap<>();
        summary.put("Total price", cart.getPrice());
        summary.put("Cart Items", itemDTOS);
        return summary;
    }

    public List<Cart> findAll() {
        return cartRepo.findAll();
    }

    public void save(Cart cart) {
        cartRepo.save(cart);
    }

    public Cart findById(long id) {
        return cartRepo.findById(id).orElseThrow(() -> new CartNotFoundException(id));
    }

}
