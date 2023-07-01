package com.springboot.FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.FoodApp.config.ResponseStruct;
import com.springboot.FoodApp.dto.User;
import com.springboot.FoodApp.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping()
	public ResponseEntity<ResponseStruct<User>>  saveUser(@Valid @PathVariable User user)
	{
		return service.saveUser(user);
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<ResponseStruct<User>> updateUser(@Valid @RequestParam int id, @RequestBody User user)
	{
		return service.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStruct<User>> deleteUser(@Valid @PathVariable int id)
	{
		return service.deleteUser(id);
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<ResponseStruct<User>> getUserById(@Valid @RequestParam int id)
	{
		return service.getUserById(id);
	}
}
