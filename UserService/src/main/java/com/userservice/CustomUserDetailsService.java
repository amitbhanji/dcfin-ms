
package com.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.repository.data.User;
import com.repository.service.UserJpaRepository;


public class CustomUserDetailsService implements UserDetailsService {

	private UserJpaRepository userJpaRepository;
	public CustomUserDetailsService(UserJpaRepository userJpaRepository)
	{
	this.userJpaRepository=userJpaRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//User user = userJpaRepository.findUserByEmail(username);
		User user = userJpaRepository.getUserByUserName(username);
		if(user==null)
			throw new UsernameNotFoundException("User Not Found");
		return new CustomUserDetails(user);
				
	}

}
