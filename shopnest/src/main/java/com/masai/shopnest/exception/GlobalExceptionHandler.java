package com.masai.shopnest.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ShopnestException.class)
	public ResponseEntity<ExceptionDetails> getException(ShopnestException ex,WebRequest wr){
		ExceptionDetails ed=new ExceptionDetails(LocalDateTime.now(),ex.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> getDefaultException(Exception ex,WebRequest wr){
		ExceptionDetails ed=new ExceptionDetails(LocalDateTime.now(),ex.getMessage(),wr.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(ed,HttpStatus.BAD_REQUEST);
	}
	
	
}
