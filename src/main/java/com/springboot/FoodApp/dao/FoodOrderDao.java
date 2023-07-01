package com.springboot.FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.FoodApp.dto.FoodOrder;
import com.springboot.FoodApp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepo repo;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder)
	{
		return repo.save(foodOrder);
	}
	
	public FoodOrder updateFoodOrder(int id, FoodOrder foodOrder)
	{
		FoodOrder foodOrder2 = repo.findById(id).get();
		if(foodOrder2 != null)
		{
			foodOrder.setFid(id); 
			return repo.save(foodOrder);
		}
		return null;
	}
	
	public FoodOrder getFoodOrderById(int id)
	{
		FoodOrder foodOrder = repo.findById(id).get();
		if(foodOrder != null)
		{
			return foodOrder;
		}
		return null;
	}
	
	public FoodOrder deleteFoodOrderById(int id)
	{
		Optional<FoodOrder> findById = repo.findById(id);
		if(findById.isPresent())
		{
			repo.deleteById(id);
			return findById.get();
		}
		return null;
	}
	
}
