package com.userservice;

import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus
public class UserNotFoundException extends Exception{

	public UserNotFoundException(String message)
	{
		super(message);
	}
}
