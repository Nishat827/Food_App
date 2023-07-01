package com.springboot.FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.FoodApp.config.ResponseStruct;
import com.springboot.FoodApp.dao.FoodOrderDao;
import com.springboot.FoodApp.dto.FoodOrder;
import com.springboot.FoodApp.dto.Item;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao dao;
	
	public ResponseEntity<ResponseStruct<FoodOrder>> saveFoodOrder(FoodOrder foodOrder)
	{
		List<Item> items = foodOrder.getItems();
		double totalPrice = 0;
		for(Item item : items)
		{
			totalPrice += item.getCost() * item.getQuantity();
		}
		foodOrder.setTotalprice(totalPrice);
		ResponseStruct<FoodOrder> resp = new ResponseStruct<>();
		resp.setStatus(HttpStatus.CREATED.value());
		resp.setMessaga("FoodOrder Saved Successufully");
		resp.setData(dao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStruct<FoodOrder>>(resp, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStruct<FoodOrder>> updateFoodOrder(int id, FoodOrder foodOrder)
	{
		FoodOrder foodOrd = dao.getFoodOrderById(id);
		if(foodOrd != null)
		{
			List<Item> items = foodOrder.getItems();
			double totalPrice = 0;
			
			for(Item item : items) {
				totalPrice += item.getCost() * item.getQuantity();
			}
			foodOrder.setTotalprice(totalPrice);
			FoodOrder updateFoodOrder = dao.updateFoodOrder(id, foodOrder);
			ResponseStruct<FoodOrder> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.OK.value());
			resp.setMessaga("FoodOrder Updated Successufully");
			resp.setData(foodOrder);
			return new ResponseEntity<ResponseStruct<FoodOrder>>(resp, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStruct<FoodOrder>> getFoodOrderById(int id)
	{
		FoodOrder foodOrderById = dao.getFoodOrderById(id);
		if(foodOrderById != null)
		{
			ResponseStruct<FoodOrder> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.OK.value());
			resp.setMessaga("FoodOrder Found Successufully");
			resp.setData(foodOrderById);
			return new ResponseEntity<ResponseStruct<FoodOrder>>(resp, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStruct<FoodOrder>> deleteFoodOrderById(int id)
	{
		FoodOrder deleteFoodOrderById = dao.deleteFoodOrderById(id);
		if(deleteFoodOrderById != null)
		{
			ResponseStruct<FoodOrder> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.CREATED.value());
			resp.setMessaga("FoodOrder Deleted Successufully");
			resp.setData(deleteFoodOrderById);
			return new ResponseEntity<ResponseStruct<FoodOrder>>(resp, HttpStatus.CREATED);
		}
		return null;
	}
}
