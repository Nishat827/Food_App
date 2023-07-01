package com.springboot.FoodApp.exception;

public class UserIdNotFoundException extends RuntimeException {
	
	String msg = "";
	
	@Override
	public String getMessage()
	{
		return msg;
	}
	
	public UserIdNotFoundException(String msg)
	{
		this.msg = msg;
	}

}
