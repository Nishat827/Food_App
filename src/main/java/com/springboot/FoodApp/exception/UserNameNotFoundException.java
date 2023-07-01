package com.springboot.FoodApp.exception;

public class UserNameNotFoundException extends RuntimeException{
	
	String msg = "";

	@Override
	public String getMessage() {
		return msg;
	}

	public UserNameNotFoundException(String msg) {
		this.msg = msg;
	}
	
}
