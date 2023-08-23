package com.masai.shopnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.shopnest.entity.Cart;
import com.masai.shopnest.entity.Product;
import com.masai.shopnest.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{cartId}/add")
    public ResponseEntity<Cart> addProductToCart(@PathVariable int cartId, @RequestBody Product product) {
        return ResponseEntity.ok(cartService.addProductToCart(cartId, product));
    }

    @PostMapping("/{cartId}/remove/{productId}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable int cartId, @PathVariable int productId) {
        return ResponseEntity.ok(cartService.removeProductFromCart(cartId, productId));
    }

    @DeleteMapping("/{cartId}/clear")
    public ResponseEntity<Cart> removeAllProducts(@PathVariable int cartId) {
        return ResponseEntity.ok(cartService.removeAllProducts(cartId));
    }

    @GetMapping("/{cartId}/view")
    public ResponseEntity<List<Product>> viewAllProducts(@PathVariable int cartId) {
        return ResponseEntity.ok(cartService.viewAllProducts(cartId));
    }
}

