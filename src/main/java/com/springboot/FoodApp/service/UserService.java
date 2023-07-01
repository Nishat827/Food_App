package com.springboot.FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.FoodApp.config.ResponseStruct;
import com.springboot.FoodApp.dao.UserDao;
import com.springboot.FoodApp.dto.User;
import com.springboot.FoodApp.exception.UserIdNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public ResponseEntity<ResponseStruct<User>> saveUser(User user)
	{
		ResponseStruct<User> responseStructure = new ResponseStruct<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessaga("User Successfully Saved");
		responseStructure.setData(dao.saveUser(user));
		return new ResponseEntity<ResponseStruct<User>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStruct<User>> updateUser(int id, User user)
	{
		ResponseStruct<User> responseStructure = new ResponseStruct<>();

		if(dao.updateUser(id, user) != null)
		{
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessaga("User successfully Updated");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStruct<User>>(responseStructure, HttpStatus.OK);
		}
		throw new UserIdNotFoundException("Entered Id is not Present");
	}
	
	public ResponseEntity<ResponseStruct<User>> deleteUser(int id)
	{
		User deleteUser = dao.deleteUser(id);
		if(deleteUser != null)
		{
			ResponseStruct<User> resStruct = new ResponseStruct<>();
			resStruct.setStatus(HttpStatus.OK.value());
			resStruct.setMessaga("User Successufully Deleted");
			resStruct.setData(deleteUser);
			return new ResponseEntity<ResponseStruct<User>>(resStruct, HttpStatus.OK);
		}
		else {
			throw new UserIdNotFoundException("Entered Id is not Present");
		}
	}
	
	public ResponseEntity<ResponseStruct<User>> getUserById(int id)
	{
		User userById = dao.getUserById(id);
		if(userById != null)
		{
			ResponseStruct<User> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.FOUND.value());
			resp.setMessaga("User Successufully Found");
			resp.setData(userById);
			return new ResponseEntity<ResponseStruct<User>>(resp, HttpStatus.FOUND);
		}
		else {
			throw new UserIdNotFoundException("Entered Id is not Present");
		}
		
	}
	
}
