package com.shop.Shop.API.repos;


import com.shop.Shop.API.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
}
