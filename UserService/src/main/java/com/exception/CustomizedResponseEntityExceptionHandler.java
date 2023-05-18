package com.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.userservice.UserNotFoundException;

import ch.qos.logback.core.spi.ErrorCodes;
import jakarta.annotation.Nullable;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<ErrorDetails> handleArgNotValidException(Exception ex,WebRequest request)
	
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}

    @Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    
    	
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"Request Parameter "+ex.getParameterName()+" is missing",request.getDescription(false));
		return handleExceptionInternal(ex, errorDetails, headers, status, request);
	}
  
   
    public ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"Can't convert "+ ex.getPropertyName()+" from type string to int ",request.getDescription(false));
		//Object[] args = {ex.getPropertyName(), ex.getValue()};
		//String defaultDetail = "Failed to convert '" + args[0] + "' with value: '" + args[1] + "'";
		//String messageCode = ErrorResponse.getDefaultDetailMessageCode(TypeMismatchException.class, null);
		//ProblemDetail body = createProblemDetail(ex, status, defaultDetail, messageCode, args, request);

		return handleExceptionInternal(ex, errorDetails, headers, status, request);
	}
				
}
