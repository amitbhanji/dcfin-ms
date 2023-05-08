package com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.userprofileservice.UserProfileNotFoundException;

@ControllerAdvice
public class CustomizedUserProfileResponseEntityException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserProfileNotFoundException.class)
	public  ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception
	{
	     ErrorDetails errorDetails=  new ErrorDetails(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
	     return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
}
