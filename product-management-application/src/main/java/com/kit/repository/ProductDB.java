package com.kit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kit.entity.Product;

public interface ProductDB extends  JpaRepository<Product, Integer>{
	Product findByName(String name);

}
