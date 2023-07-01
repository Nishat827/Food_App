package com.springboot.FoodApp.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.FoodApp.config.ResponseStruct;

@ControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler{
	
	

	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ResponseStruct<String>> userIdNotFound(UserIdNotFoundException e)
	{
		ResponseStruct<String> resp = new ResponseStruct<>();
		
		resp.setStatus(HttpStatus.NOT_FOUND.value());
		resp.setMessaga(e.getMessage());
		resp.setData("User id not found");
		return new ResponseEntity<ResponseStruct<String>>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNameNotFoundException.class)
	public ResponseEntity<ResponseStruct<String>> userNameNotFound(UserNameNotFoundException e)
	{
		ResponseStruct<String> resp = new ResponseStruct<>();
		
		resp.setStatus(HttpStatus.NOT_FOUND.value());
		resp.setMessaga(e.getMessage());
		resp.setData("User Name not found");
		return new ResponseEntity<ResponseStruct<String>>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotfoundException.class)
	public ResponseEntity<ResponseStruct<String>> productNotFound(ProductNotfoundException e)
	{
		ResponseStruct<String> resp = new ResponseStruct<>();
		resp.setStatus(HttpStatus.NOT_FOUND.value());
		resp.setMessaga(e.getMessage());
		resp.setData("Product By Name Is Not available");
		
		return new ResponseEntity<ResponseStruct<String>>(resp, HttpStatus.NOT_FOUND);
	}
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		
//		List<ObjectError> allErrors = ex.getAllErrors();
//		HashMap<String, String> hashMap = new HashMap<>();
//		
//		for(ObjectError error : allErrors) {
//			String defaultMessage = error.getDefaultMessage();
//			String field = ((FieldError) error).getField();
//			hashMap.put(field, defaultMessage);
//		}
//		
//		return new ResponseEntity<Object>(hashMap, HttpStatus.BAD_REQUEST);
//	}
}
