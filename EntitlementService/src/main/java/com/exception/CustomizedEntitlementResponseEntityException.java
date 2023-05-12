package com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.entitlementservice.EntitlementNotFoundException;


@ControllerAdvice
public class CustomizedEntitlementResponseEntityException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntitlementNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> handleArgExceptions(Exception ex,WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
	
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"Error"+ex.getFieldError().getDefaultMessage(),request.getDescription(false));
		
		return handleExceptionInternal(ex,errorDetails,headers, HttpStatus.BAD_REQUEST, request);
	}
}
