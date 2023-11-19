package com.masai.shopnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @PostMapping("/add/{cartId}/{proId}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable int cartId, @PathVariable int proId) {
        return ResponseEntity.ok(cartService.addProductToCart(cartId, proId));
    }

    @PostMapping("/remove/{cartId}/{proId}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable int cartId, @PathVariable int proId) {
        return ResponseEntity.ok(cartService.removeProductFromCart(cartId, proId));
    }

    @DeleteMapping("/clear/{cartId}")
    public ResponseEntity<Cart> removeAllProducts(@PathVariable int cartId) {
        return ResponseEntity.ok(cartService.removeAllProducts(cartId));
    }

    @GetMapping("/view/{cartId}")
    public ResponseEntity<List<Product>> viewAllProducts(@PathVariable int cartId) {
        return ResponseEntity.ok(cartService.viewAllProducts(cartId));
    }
}

