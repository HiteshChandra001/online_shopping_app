package com.masai.shopnest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.shopnest.entity.Product;
import com.masai.shopnest.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> viewAllProducts(){
		return new ResponseEntity<List<Product>> (productService.viewAllProducts(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product> (productService.addProduct(product),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		return new ResponseEntity<Product> (productService.updateProduct(product),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> viewProduct(@PathVariable Integer pid){
		return new ResponseEntity<Product> (productService.viewProduct(pid),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products/byCategory/{cname}")
	public ResponseEntity<List<Product>> viewAllProductsByCategory(@PathVariable String cname){
//		------ 
		return new ResponseEntity<List<Product>> (productService.viewProductByCategory(cname),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer pid){
		return new ResponseEntity<Product> (productService.removeProduct(pid),HttpStatus.ACCEPTED);
	}
	
}
