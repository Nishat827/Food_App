package com.springboot.FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.FoodApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer> {

}
