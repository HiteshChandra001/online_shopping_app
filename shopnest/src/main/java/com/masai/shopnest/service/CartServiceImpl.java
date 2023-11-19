package com.masai.shopnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Cart;
import com.masai.shopnest.entity.Product;
import com.masai.shopnest.exception.NotFoundException;
import com.masai.shopnest.exception.ShopnestException;
import com.masai.shopnest.repository.CartRepository;
import com.masai.shopnest.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    

    @Override
    public Cart addProductToCart(int cartId, int productid) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(()->new ShopnestException("no cart found with cart id: "+cartId));
        Product product = productRepository.findById(productid).orElseThrow(()->new ShopnestException("no product found with product id: "+productid));
        
            cart.getProducts().add(product);
            return cartRepository.save(cart);
    }

    @Override
    public Cart removeProductFromCart(int cartId, int productid) {
    	 Cart cart = cartRepository.findById(cartId).orElseThrow(()->new ShopnestException("no cart found with cart id: "+cartId));
         Product product = productRepository.findById(productid).orElseThrow(()->new ShopnestException("no product found with product id: "+productid));
        
         cart.getProducts().remove(product);
       return cartRepository.save(cart);
    }

    @Override
    public Cart removeAllProducts(int cartId) {
    	 Cart cart = cartRepository.findById(cartId).orElseThrow(()->new ShopnestException("no cart found with cart id: "+cartId));
         cart.getProducts().removeIf(c->true);
         cartRepository.save(cart);
         return cart;
    }

    @Override
    public List<Product> viewAllProducts(int cartId) {
    	Cart cart = cartRepository.findById(cartId).orElseThrow(()->new ShopnestException("no cart found with cart id: "+cartId));
        List<Product> list = cart.getProducts();
        if(list.size()==0)new NotFoundException("no product found with cart id: "+cartId);
        return list;
    }
}
