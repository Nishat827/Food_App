package com.springboot.FoodApp.config;

import lombok.Data;

@Data
public class ResponseStruct<T> {

	private int status;
	private String messaga;
	private Object data;
}
