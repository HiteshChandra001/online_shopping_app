package com.masai.shopnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.shopnest.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>,PagingAndSortingRepository<Product,Integer> {

}
