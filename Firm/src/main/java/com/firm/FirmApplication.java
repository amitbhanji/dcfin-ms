package com.firm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.exception.CustomizedFirmResponseEntityException;

@SpringBootApplication
@Import(CustomizedFirmResponseEntityException.class)
public class FirmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirmApplication.class, args);
	}

}
