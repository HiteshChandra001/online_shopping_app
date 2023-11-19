package com.masai.shopnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.shopnest.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
