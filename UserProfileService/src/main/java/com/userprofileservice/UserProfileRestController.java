package com.userprofileservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.PaginationImplementation;
import com.pagination.PaginationResponse;
import com.repository.data.Entitlement;
import com.repository.data.EntitlementToUserProfile;
import com.repository.data.UserProfile;
import com.repository.service.EntitlementJpaRepository;
import com.repository.service.EntitlementToUserProfileJpaRepository;
import com.repository.service.UserProfileJpaRespository;

import jakarta.validation.Valid;


@RestController
@Validated
public class UserProfileRestController {
	@Autowired(required = true)
	private UserProfileJpaRespository userProfileJpaRepositoryResource;
	@Autowired
	private PaginationImplementation paginationImplService;
	
	
	@Autowired
	private EntitlementJpaRepository entitlementJpaRepositoryResource ;
	@Autowired(required = true)
	private EntitlementToUserProfileJpaRepository mappingJpaResource;
	
	@GetMapping("/profiles")
	public PaginationResponse retrieveProfiles(@RequestParam int pageNo,@Valid @RequestParam int pageSize)throws IllegalArgumentException
	{
		Pageable records = PageRequest.of(pageNo, pageSize);
		Page<UserProfile> recordsList=userProfileJpaRepositoryResource.findAll(records);
		PaginationResponse resp = paginationImplService.getAllRecords(pageNo, pageSize, recordsList);
		return resp;
	}

	@GetMapping("/list")
	public ResponseEntity<List<UserProfile>> retrieveProfiles()
	{
		
				
		List<UserProfile> a=userProfileJpaRepositoryResource.findAll();
				return ResponseEntity.ok(a);

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
	public ResponseEntity<UserProfile> createProfile(@RequestBody UserProfileToEntitlementMapping requestObj)throws Exception
	{
		UserProfile profileObj = new UserProfile();
		profileObj.setDescription(requestObj.getDescription());
		profileObj.setProfileName(requestObj.getProfileName());
		profileObj.setCreateDate(requestObj.getCreateDate());
		List<Integer> ents = requestObj.getEntIds();
		List<Entitlement> entments = new ArrayList<>();
		//List<UserProfile> profiles= new ArrayList<>();
		for(int id:ents)
		entments.add(entitlementJpaRepositoryResource.findById(id).get());
       // profileObj.setEntitlements(entments);
		UserProfile savedProfile = userProfileJpaRepositoryResource.save(profileObj);
		for(Entitlement e : entments)
		{
		EntitlementToUserProfile mappingEntity = new EntitlementToUserProfile();
		mappingEntity.setUserProfileId(savedProfile.getUserProfileId());
		mappingEntity.setDescription(savedProfile.getDescription());
		mappingEntity.setEntitlementId(e.getEntitlementId());	
		mappingJpaResource.save(mappingEntity);
		}
		return ResponseEntity.ok(savedProfile);
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
