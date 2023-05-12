package com.repository.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepositoryController {

	@GetMapping("/")
	public String get()
	{
		return "hello";
	}
}
