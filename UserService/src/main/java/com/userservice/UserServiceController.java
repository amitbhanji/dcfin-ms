package com.userservice;


import java.net.URI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.repository.data.User;
import com.repository.service.UserJpaRepository;

import jakarta.validation.Valid;

@RestController
@Validated
public class UserServiceController {

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@GetMapping("/users/{id}")
	public Optional<User> retrieveUserById(@PathVariable int id) throws Exception
	{
		
			 Optional<User> user =userJpaRepository.findById(id);
			 if (!user.isPresent())
				 
				 throw new UserNotFoundException("id: "+id+" is not found");
		return user;
	//return Arrays.asList(new User("aboli"),new User("smita"));
		
	}
	@GetMapping("/users")
	public List<User> retrieveUsers()
	{
		
				 return userJpaRepository.findAll();
	
	//return Arrays.asList(new User("aboli"),new User("smita"));
		
	}
	//returns response 201: created
	@PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
    	 User savedUser = userJpaRepository.save(user);
    	URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getUserId()).toUri();
    	return ResponseEntity.created(location).build();
    	
    }
	
	@PostMapping("/users/update/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id)
	{
		Optional<User> olduser = userJpaRepository.findById(id);
		User userObj = olduser.get();
		userObj.setUsername(user.getUsername());
		userObj.setUserfname(user.getUserfname());
		userObj.setUsermname(user.getUsermname());
		userObj.setUserlname(user.getUserlname());
		userObj.setUserEmail(user.getUserEmail());
		userObj.setAddress(user.getAddress());
		userObj.setUpdateTime(user.getUpdateTime());
		userObj.setPassword(user.getPassword());
		User savedUser =userJpaRepository.save(userObj);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFirm.getFirmId()).toUri();
		return ResponseEntity.ok(savedUser);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) throws Exception
	{
		Optional<User> userObject = userJpaRepository.findById(id);
		if(!userObject.isPresent())
			throw new UserNotFoundException("User to delete with Id: "+id+" not found");
		else
			userJpaRepository.deleteById(id);

	}
	
}
