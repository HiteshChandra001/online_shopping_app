package com.masai.shopnest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Product;
import com.masai.shopnest.exception.NotFoundException;
import com.masai.shopnest.exception.ShopnestException;
import com.masai.shopnest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> viewAllProducts() {
		Pageable p= PageRequest.of(0,10,Sort.by("productName").descending());
		Page<Product> pages = productRepository.findAll(p);
		List<Product> list = pages.getContent();
		if(list.size()==0)throw new ShopnestException("No product found");
		return list;
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product prod = productRepository.findById(product.getProductId()).orElseThrow(()->new ShopnestException("No product found for given id: "+product.getProductId()));
		return productRepository.save(prod);
	}

	@Override
	public Product viewProduct(int pid) {
		Optional<Product> find = productRepository.findById(pid);
		if(!find.isPresent())throw new ShopnestException("No product found for given id");
		return find.get();
	}

	@Override
	public List<Product> viewProductByCategory(String cname) {
		List<Product> list=new ArrayList<>();
		List<Product> products = productRepository.findAll();
		
		for(Product p:products) {
			if(p.getCategory().getCategoryName().equalsIgnoreCase(cname))list.add(p);
		}
		
		if(list.size()==0)throw new NotFoundException("no product found for category: "+cname);
		
		return list;
	}

	@Override
	public Product removeProduct(int pid) {
		Product prod = productRepository.findById(pid).orElseThrow(()->new ShopnestException("No product found for given id: "+pid));
		productRepository.delete(prod);
		return prod;
	}
	
}
