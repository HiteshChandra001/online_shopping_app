package com.masai.shopnest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Cart;
import com.masai.shopnest.entity.Product;
import com.masai.shopnest.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addProductToCart(int cartId, Product product) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        
        if(optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.getProduct().put(product.getProductId(), product);
            return cartRepository.save(cart);
        }
        
        return null;
    }

    @Override
    public Cart removeProductFromCart(int cartId, int productId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        
        if(optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.getProduct().remove(productId);
            return cartRepository.save(cart);
        }
       
        return null;
    }

    @Override
    public Cart removeAllProducts(int cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        
        if(optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.getProduct().clear();
            return cartRepository.save(cart);
        }
        
        return null;
    }

    @Override
    public List<Product> viewAllProducts(int cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        
        if(optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            return new ArrayList<>(cart.getProduct().values());
        }
        
        return new ArrayList<>();
    }
}
