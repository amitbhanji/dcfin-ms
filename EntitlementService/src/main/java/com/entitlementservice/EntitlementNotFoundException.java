package com.entitlementservice;

import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus
public class EntitlementNotFoundException extends Exception{

	public EntitlementNotFoundException(String message)
	{
		super(message);
	}
}
