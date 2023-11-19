package com.masai.shopnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.shopnest.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}