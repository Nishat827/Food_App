package com.springboot.FoodApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.FoodApp.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Query("select p From Menu p WHERE p.mid=?1")
	public List<Product> findAllProduct(int mid);
	
}
