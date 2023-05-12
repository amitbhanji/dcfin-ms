package com.userprofileservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.repository.service.EntitlementJpaRepository;
import com.repository.service.EntitlementToUserProfileJpaRepository;
import com.repository.service.UserProfileJpaRespository;
import com.repository.data.Entitlement;
import com.repository.data.EntitlementToUserProfile;
import com.repository.data.UserProfile;


@RestController
public class UserProfileRestController {
	@Autowired(required = true)
	private UserProfileJpaRespository userProfileJpaRepositoryResource;
/*
	@Autowired(required = true)
	//private UserProfileJpaRespository userProfileJpaRepositoryResource ;
	@Autowired
	//private EntitlementJpaRepository entitlementJpaRepositoryResource ;
	@Autowired
	//private EntitlementToUserProfileJpaRepository mappingJpaResource;
	
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
	//save userProfile
	@PostMapping("/profiles")
	public ResponseEntity<UserProfile> createProfile(@RequestBody UserProfile profile,@RequestBody List<Integer> entitlements)
	{
		UserProfile savedProfile =userProfileJpaRepositoryResource.save(profile);
		List<Integer> ents = entitlements;
		List<Entitlement> entments = new ArrayList<>();
		for(int id:ents)
			entments.add(entitlementJpaRepositoryResource.findById(id).get());
		savedProfile.setEntitlements(entments);
		//EntitlementToUserProfile entToProfile = new EntitlementToUserProfile(); 
		//entToProfile.setEntitlements(entments);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProfile.getUserProfileId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	public void saveMappings(UserProfile savedProfile ) 
	{
		EntitlementToUserProfile mappingEntity = new EntitlementToUserProfile();
		mappingEntity.setUserProfileId(savedProfile.getUserProfileId());
		mappingEntity.setDescription(savedProfile.getDescription());
		List<Entitlement> entitlements = savedProfile.getEntitlements();
		for(Entitlement e : entitlements)
		{
			mappingEntity.setEntitlementId(e.getEntitlementId());
	      	mappingJpaResource.save(mappingEntity);
		}
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
	*/
	@GetMapping("/")
	public String get()
	{
		return "hello world";
	}
	@GetMapping("/profiles")
	public List<UserProfile> retrieveProfiles()
	{
		return userProfileJpaRepositoryResource.findAll();
	}
}
