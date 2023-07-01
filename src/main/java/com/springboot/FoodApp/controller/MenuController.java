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
import com.springboot.FoodApp.dto.Menu;
import com.springboot.FoodApp.service.MenuService;

@RestController
public class MenuController {

	@Autowired
	private MenuService service;
	
	@PostMapping("/savemenu")
	public ResponseEntity<ResponseStruct<Menu>> saveMenu(@RequestBody Menu menu)
	{
		return service.saveMenu(menu);
	}
	
	@PutMapping("/updatemenu")
	public ResponseEntity<ResponseStruct<Menu>> updateMenu(@RequestParam int mid, @RequestBody Menu menu)
	{
		return service.updateMenu(mid, menu);
	}
	
	@DeleteMapping("/deletemenu")
	public ResponseEntity<ResponseStruct<Menu>> deleteMenu(@RequestParam int id)
	{
		return service.deleteMenu(id);
	}
	
	@GetMapping("/getmenubyid")
	public ResponseEntity<ResponseStruct<Menu>> getMenuById(@RequestParam int mid)
	{
		return service.getMenuById(mid);
	}
	
	@GetMapping("/getmenubyname")
	public ResponseEntity<ResponseStruct<Menu>> getMenuByName(@RequestParam String mname)
	{
		return service.getMenuByName(mname);
	}

	
}
