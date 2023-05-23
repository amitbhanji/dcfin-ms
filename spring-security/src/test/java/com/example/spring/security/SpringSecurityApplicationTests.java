package com.example.spring.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.repository.data.User;
import com.repository.service.UserJpaRepository;

@DataJpaTest
@AutoConfigureTestDatabase
@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private UserJpaRepository userJpaRepository;
	//@Test
	void contextLoads() {
	}

	@Test
	public void createUser()
	{
		User user =new User();
		user.setUserfname("aboli");
		user.setUsername("ab");
		user.setUserEmail("aboli123@gmail.com");
		user.setPassword("aboli");
		
		userJpaRepository.save(user);
	}
}
