package com.userprofileservice;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserProfileNotFoundException extends Exception{

	private String message;
	
	public UserProfileNotFoundException(String message)
	{
		super(message);
		
	}

	
}
