package com.repository.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.repository.service")
public class RepositoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryServiceApplication.class, args);
	}

}
