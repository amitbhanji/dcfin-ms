package com.userprofileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exception.CustomizedUserProfileResponseEntityException;


@Import(CustomizedUserProfileResponseEntityException.class)
@SpringBootApplication
@EnableJpaRepositories("com.repository.service")
@EntityScan("com.repository.data")
@ComponentScan(basePackages = "com.pagination")
public class UserProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileServiceApplication.class, args);
	}

}
