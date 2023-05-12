package com.entitlementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.exception.CustomizedEntitlementResponseEntityException;

@SpringBootApplication
@Import(CustomizedEntitlementResponseEntityException.class)
public class EntitlementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntitlementServiceApplication.class, args);
	}

}
