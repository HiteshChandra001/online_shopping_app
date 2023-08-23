package com.masai.shopnest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.shopnest.entity.Product;
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
		Optional<Product> find = productRepository.findById(product.getProductId());
		if(!find.isPresent())throw new ShopnestException("No product found for given id");
		Product myProduct = find.get();
		myProduct=product;
		return productRepository.save(myProduct);
	}

	@Override
	public Product viewProduct(int pid) {
		Optional<Product> find = productRepository.findById(pid);
		if(!find.isPresent())throw new ShopnestException("No product found for given id");
		return find.get();
	}

	@Override
	public List<Product> viewProductByCategory(String cname) {
		return null;
	}

	@Override
	public Product removeProduct(int pid) {
		Optional<Product> find = productRepository.findById(pid);
		if(!find.isPresent())throw new ShopnestException("No product found for given id");
		Product product = find.get();
		productRepository.delete(product);
		return product;
	}
	
}
