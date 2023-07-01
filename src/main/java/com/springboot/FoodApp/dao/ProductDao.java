package com.springboot.FoodApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.springboot.FoodApp.config.ResponseStruct;
import com.springboot.FoodApp.dto.Menu;
import com.springboot.FoodApp.dto.Product;
import com.springboot.FoodApp.exception.ProductNotfoundException;
import com.springboot.FoodApp.repo.ProductRepo;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private MenuDao menuDao;
	
	public Product saveProduct(Product product)
	{
		return repo.save(product);
	}
	
	public Product updateProductById(int id, Product product)
	{
		Product product2 = repo.findById(id).get();
		
		if(product2 != null) {
			product.setPid(id);
			return repo.save(product);
		}
		else {
			return null;
		}
	}
	
	public Product deleteproduct(int id)
	{
		Product product = repo.findById(id).get();
		if(product != null)
		{
			repo.deleteById(id);
			return product;
		}
		else {
			return null;
		}
	}

	public Product getproductById(int id) 
	{
	    Product product = repo.findById(id).get();	
	    if(product != null)
	    {
	    	return product;
	    }
	    else {
	    	return null;
	    }
	}
	
   public List<Product> findAllProduct(int mid){
		
		Menu menuById = menuDao.getMenuById(mid);
		if(menuById != null)
		{
            return repo.findAllProduct(mid);
		}
		else {
			return null;
		}
	}
	
	
	
	
	
}
