package com.masai.shopnest.service;

import com.masai.shopnest.entity.Cart;
import com.masai.shopnest.entity.Product;

import java.util.List;

public interface CartService {
    Cart addProductToCart(int cartId, Product product);
    Cart removeProductFromCart(int cartId, int productId);
    Cart removeAllProducts(int cartId);
    List<Product> viewAllProducts(int cartId);
}
