package com.shop.Shop.API.repos;

import com.shop.Shop.API.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
}
