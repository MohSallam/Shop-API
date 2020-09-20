package com.shop.configurations;

import com.shop.domain.Item;
import com.shop.service.ItemServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoadDB {
    @Bean
    CommandLineRunner initialize(ItemServiceImpl itemService) {
        return args -> {
            Item item1 = new Item("Macbook pro laptop", 10, 1500);
            Item item2 = new Item("HP laptop", 20, 1000);
            itemService.save(item1);
            itemService.save(item2);

        };
    }
}
