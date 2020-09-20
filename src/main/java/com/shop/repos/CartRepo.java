package com.shop.repos;

import com.shop.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
