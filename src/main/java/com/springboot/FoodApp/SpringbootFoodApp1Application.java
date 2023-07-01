package com.springboot.FoodApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class SpringbootFoodApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFoodApp1Application.class, args);
	}

}
