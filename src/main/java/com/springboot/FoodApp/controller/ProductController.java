package com.springboot.FoodApp.controller;

import java.util.List;

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
import com.springboot.FoodApp.dto.Product;
import com.springboot.FoodApp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/saveproduct")
	public ResponseEntity<ResponseStruct<Product>> saveProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
	}
	
	@PutMapping("/updateproduct")
	public ResponseEntity<ResponseStruct<Product>> updateProductById(@RequestParam int id, @RequestBody Product product)
	{
		return service.updateProductById(id, product);
	}
	
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<ResponseStruct<Product>> deleteProduct(int id)
	{
		return service.deleteProduct(id);
	}
	
	@GetMapping("/getproductById")
	public ResponseEntity<ResponseStruct<Product>> getProductById(@RequestParam int id)
	{
		return service.getproductById(id);
	}
	
	
	@GetMapping("/getallproductsById")
	public ResponseEntity<ResponseStruct<List<Product>>> getAllProducts(@RequestParam int mid)
	{
		return service.findAllProduct(mid);
	}
	
	
	
	
	
	
}
