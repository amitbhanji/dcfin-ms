package com.userservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.pagination.response.PaginationImplementation;
import com.pagination.response.PaginationResponse;
import com.repository.data.Entitlement;
import com.repository.data.User;
import com.repository.data.UserProfile;
import com.repository.data.UserProfileToUser;
import com.repository.service.UserJpaRepository;
import com.repository.service.UserProfileJpaRespository;
import com.repository.service.UserProfileToUserJpaRepository;

import jakarta.validation.Valid;

@RestController
@Validated

public class UserServiceController {

	@Autowired
	private UserJpaRepository userJpaRepository;
	@Autowired
	private PaginationImplementation paginationImplService;
	@Autowired
	private UserProfileJpaRespository userProfileRepository;
	@Autowired
	private UserProfileToUserJpaRepository userProfileToUserRepository;

	@GetMapping("/users")
	public PaginationResponse<User> getAllEntitlements(@RequestParam int pageNo,@Valid @RequestParam int pageSize)throws IllegalArgumentException {
		Pageable records = PageRequest.of(pageNo, pageSize);
		Page<User> recordsList = userJpaRepository.findAll(records);
		PaginationResponse<User> resp = paginationImplService.getAllRecords(pageNo, pageSize, recordsList);
		return resp;
	}

	@GetMapping("/users/{id}")
	public Optional<User> retrieveUserById(@PathVariable int id) throws Exception {

		Optional<User> user = userJpaRepository.findById(id);
		if (!user.isPresent())

			throw new UserNotFoundException("id: " + id + " is not found");
		return user;
		// return Arrays.asList(new User("aboli"),new User("smita"));

	}

	@GetMapping("/records")
	public List<User> retrieveUsers() {

		return userJpaRepository.findAll();

		// return Arrays.asList(new User("aboli"),new User("smita"));

	}

	// returns response 201: created
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userJpaRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	@PostMapping("/userToProfile")
	public Object saveUser(@RequestBody UserToUserProfileMapping requestObj)
	{
		User userObj = requestObj.getUser();
		List<UserProfile> userProfiles = new ArrayList<>();
		List<Integer> profiles = requestObj.getProfiles();
		for(int i:profiles)
		userProfiles.add(userProfileRepository.findById(i).get());
		userObj.setUserProfiles(userProfiles);
		User savedUser=userJpaRepository.save(userObj);
		List<UserProfileToUser> mappings = userProfileToUserRepository.findAll();
		for(UserProfileToUser entity:mappings)
		{   if(savedUser.getUserId()==entity.getUserId())
		{
			for(int i:profiles)
			{
				if(i==entity.getUserProfileId())
				{
			entity.setProfileDescription(userProfileRepository.findById(i).get().getDescription());
			userProfileToUserRepository.save(entity);
			break;
				}
			}
		}	
	
	    }
		return savedUser;

	}

	@PostMapping("/users/update/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
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
		User savedUser = userJpaRepository.save(userObj);
		// URI location =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFirm.getFirmId()).toUri();
		return ResponseEntity.ok(savedUser);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) throws Exception {
		Optional<User> userObject = userJpaRepository.findById(id);
		if (!userObject.isPresent())
			throw new UserNotFoundException("User to delete with Id: " + id + " not found");
		else
			userJpaRepository.deleteById(id);

	}
	
	@GetMapping("/")
	public ModelAndView doLogin()
	{

		//List<User> users= userJpaRepository.findAll();
		ModelAndView m = new ModelAndView();
      //  m.addObject("list",users);
        m.setViewName("index");
		return m;
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
	  return new CustomUserDetailsService( userJpaRepository);	
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	   @Bean
	   public DaoAuthenticationProvider authenticationProvider()
	   {
		   DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		   authProvider.setUserDetailsService(userDetailsService());
		   authProvider.setPasswordEncoder(passwordEncoder());
		   return authProvider;
		 
	   }
	   
	   private void Configure(AuthenticationManagerBuilder auth) throws Exception {

		   auth.authenticationProvider(authenticationProvider());
	}
	   private void Configure(HttpSecurity http)throws Exception {
		   http.authorizeHttpRequests()
           .requestMatchers("/").permitAll()
           .requestMatchers("/edit/*", "/delete/*").hasRole("batch")
           .anyRequest().authenticated()
           .and()
           .formLogin()
           .and()
           .logout()
           .and()
           .exceptionHandling().accessDeniedPage("/403")
           ;
	   }

}
