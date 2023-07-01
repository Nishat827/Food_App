package com.springboot.FoodApp.exception;

public class ProductNotfoundException extends RuntimeException{

	String msg = "";

	@Override
	public String getMessage() {
		return msg;
	}

	public ProductNotfoundException(String msg) {
		this.msg = msg;
	}
	
	
	
	
}
