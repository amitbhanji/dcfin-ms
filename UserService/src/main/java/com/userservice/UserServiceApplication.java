package com.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exception.CustomizedResponseEntityExceptionHandler;
import com.pagination.response.PaginationImplementation;

@ComponentScan(basePackages = "com.pagination.response")
@SpringBootApplication
@Import(CustomizedResponseEntityExceptionHandler.class)
@ComponentScan(basePackageClasses = { PaginationImplementation.class })
@EntityScan("com.repository.data")
@EnableJpaRepositories("com.repository.service")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
