package com.shop.repos;


import com.shop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    Item findByName(String name);
}
