package com.entitlementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exception.CustomizedEntitlementResponseEntityException;
import com.pagination.response.PaginationImplementation;

@SpringBootApplication
@Import(CustomizedEntitlementResponseEntityException.class)
@EnableJpaRepositories("com.repository.service")
@EntityScan("com.repository.data")
@ComponentScan(basePackageClasses = { PaginationImplementation.class })
@ComponentScan(basePackages = "com.pagination.response")
public class EntitlementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntitlementServiceApplication.class, args);
	}

}
