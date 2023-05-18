package com.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.userprofileservice.UserProfileNotFoundException;

@ControllerAdvice
public class CustomizedUserProfileResponseEntityException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserProfileNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false),
				LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> handleArgNotValidException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false),
				LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	 @Override
		protected ResponseEntity<Object> handleMissingServletRequestParameter(
				MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	    
			ErrorDetails errorDetails = new ErrorDetails("Request Parameter "+ex.getParameterName()+" is missing",request.getDescription(false),LocalDateTime.now());
			return handleExceptionInternal(ex, errorDetails, headers, status, request);
		}
	public ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails("Can't convert "+ ex.getPropertyName()+" from type string to int ",request.getDescription(false),LocalDateTime.now());
		//Object[] args = {ex.getPropertyName(), ex.getValue()};
		//String defaultDetail = "Failed to convert '" + args[0] + "' with value: '" + args[1] + "'";
		//String messageCode = ErrorResponse.getDefaultDetailMessageCode(TypeMismatchException.class, null);
		//ProblemDetail body = createProblemDetail(ex, status, defaultDetail, messageCode, args, request);

		return handleExceptionInternal(ex, errorDetails, headers, status, request);
	}
			

}
