package com.example.spring.security;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.repository.data.User;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Test
	void contextLoads() {
	}

	
	@Test
	public void createUser()
	{
		User user = new User();
		user.setUsername("aboli");
		user.setUserEmail("ab@gmail.com");
		user.setPassword("ab123");
		user.setCreateTime(LocalDate.now());
	}
}
