package com.example.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pagination.response.PaginationImplementation;

@SpringBootApplication
@EnableJpaRepositories("com.repository.service")
@EntityScan("com.repository.data")
@ComponentScan(basePackageClasses = { PaginationImplementation.class })
@ComponentScan(basePackages = "com.pagination.response")
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}
