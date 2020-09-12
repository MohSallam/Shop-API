package com.shop.Shop.API.configurations;

import com.shop.Shop.API.domain.Item;
import com.shop.Shop.API.service.CartServiceImpl;
import com.shop.Shop.API.service.ItemServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {
    @Bean
    CommandLineRunner initialize(ItemServiceImpl itemService, CartServiceImpl cartService){
        return args -> {
            Item item1 = new Item("Macbook pro laptop", 10, 1500);
            Item item2 = new Item("HP laptop", 20, 1000);
            itemService.save(item1);
            itemService.save(item2);

        };
    }
}
