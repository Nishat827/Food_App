package com.springboot.FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.FoodApp.config.ResponseStruct;
import com.springboot.FoodApp.dto.FoodOrder;
import com.springboot.FoodApp.service.FoodOrderService;

@RestController
public class FoodOrderController {

	@Autowired
	private FoodOrderService service;
	
	@PostMapping("/savefoodorder")
	public ResponseEntity<ResponseStruct<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder)
	{
		return service.saveFoodOrder(foodOrder);
	}
	
	@PutMapping("/updatefoodorder")
	public ResponseEntity<ResponseStruct<FoodOrder>> updateFoodOrder(@RequestParam int id, @RequestBody FoodOrder order)
	{
		return service.updateFoodOrder(id, order);
	}
	
	@GetMapping("/getfoodorderbyid")
	public ResponseEntity<ResponseStruct<FoodOrder>> getFoodOrderById(@RequestParam int id)
	{
		return service.getFoodOrderById(id);
	}
	
	@DeleteMapping("/deletefoodorderbyid")
	public ResponseEntity<ResponseStruct<FoodOrder>> deleteFoodOrderById(@RequestParam int id)
	{
		return service.deleteFoodOrderById(id);
	}
}
