package com.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.exception.CustomizedResponseEntityExceptionHandler;

@SpringBootApplication
@Import(CustomizedResponseEntityExceptionHandler.class)
public class UserServiceApplication{


	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
