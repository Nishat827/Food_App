package com.springboot.FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.FoodApp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
