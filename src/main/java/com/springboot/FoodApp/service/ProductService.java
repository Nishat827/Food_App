package com.springboot.FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.FoodApp.config.ResponseStruct;
import com.springboot.FoodApp.dao.MenuDao;
import com.springboot.FoodApp.dao.ProductDao;
import com.springboot.FoodApp.dto.Menu;
import com.springboot.FoodApp.dto.Product;
import com.springboot.FoodApp.exception.ProductNotfoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	public ResponseEntity<ResponseStruct<Product>> saveProduct(Product product)
	{
		ResponseStruct<Product> resp = new ResponseStruct<>();
		resp.setStatus(HttpStatus.CREATED.value());
		resp.setMessaga("Product Successufully Saved");
		resp.setData(product);
		return new ResponseEntity<ResponseStruct<Product>>(resp, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStruct<Product>> updateProductById(int id, Product product)
	{
		Product updateProductById = dao.updateProductById(id, product);
		if(updateProductById != null) 
		{
			ResponseStruct<Product> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.OK.value());
			resp.setMessaga("Product updated Successfully");
			return new ResponseEntity<ResponseStruct<Product>>(resp, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStruct<Product>> deleteProduct(int id)
	{
		Product deleteproduct = dao.deleteproduct(id);
		if(deleteproduct != null)
		{
			ResponseStruct<Product> resp = new ResponseStruct<>();
			resp.setData(HttpStatus.OK.value());
			resp.setMessaga("Product Deleted Successufully");
			resp.setData(deleteproduct);
			return new ResponseEntity<ResponseStruct<Product>>(resp, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStruct<Product>> getproductById(int id) {

		Product getproductById = dao.getproductById(id);
		if(getproductById != null)
		{
			ResponseStruct<Product> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.FOUND.value());
			resp.setMessaga("Product Found Successfully");
			resp.setData(getproductById);
			return new ResponseEntity<ResponseStruct<Product>>(resp, HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStruct<List<Product>>> findAllProduct(int mid){
		
		List<Product> findAllProduct = dao.findAllProduct(mid);
		if(findAllProduct != null)
		{
			ResponseStruct<List<Product>> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.FOUND.value());
			resp.setMessaga("All products are found");
			resp.setData(findAllProduct);
			return new ResponseEntity<ResponseStruct<List<Product>>>(resp, HttpStatus.FOUND);
		}
		else {
			throw new ProductNotfoundException("Product by name is not available");
		}
	}
}
