package com.masai.shopnest.service;

import java.util.List;

import com.masai.shopnest.entity.Product;

public interface ProductService {
	List<Product> viewAllProducts();
	
	Product addProduct(Product product);
	
	Product updateProduct(Product product);
	
	Product viewProduct(int pid);
	
	List<Product> viewProductByCategory(String cname);
	
	Product removeProduct(int pid);
	
	
}
