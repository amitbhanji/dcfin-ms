package com.userprofileservice;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class UserProfileRestController {

	@Autowired
	private UserProfileJpaRespository userProfileJpaRepositoryResource ;
	
	@GetMapping("/profiles")
	public List<UserProfile> retrieveProfiles()
	{
		return userProfileJpaRepositoryResource.findAll();
	}
	@GetMapping("/profiles/{id}")
	public Optional<UserProfile> retrieveProfileById(@PathVariable int id)throws Exception
	{
		Optional<UserProfile> profile =  userProfileJpaRepositoryResource.findById(id);
		if (!profile.isPresent())
			throw new UserProfileNotFoundException("UserProfile not found for id : "+id);
		return profile;
	}
	@PostMapping("/profiles")
	public ResponseEntity<UserProfile> createProfile(@RequestBody UserProfile profile)
	{
		UserProfile savedProfile =userProfileJpaRepositoryResource.save(profile);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProfile.getUserProfileId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PostMapping("/profiles/update/{id}")
	public ResponseEntity<UserProfile> updateFirm(@RequestBody UserProfile profile,@PathVariable int id)
	{
		Optional<UserProfile> oldprofile = userProfileJpaRepositoryResource.findById(id);
		UserProfile profileObj = oldprofile.get();
		profileObj.setProfileName(profile.getProfileName());
		profileObj.setDescription(profile.getDescription());
		profileObj.setCreateDate(profile.getCreateDate());
		UserProfile savedProfile =userProfileJpaRepositoryResource.save(profileObj);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFirm.getFirmId()).toUri();
		return ResponseEntity.ok(savedProfile);
	}
	
	@DeleteMapping("/profile/{id}")
	public void deleteProfileById(@PathVariable int id)
	{
		userProfileJpaRepositoryResource.deleteById(id);
	}
}
