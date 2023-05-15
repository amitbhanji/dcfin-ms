package com.entitlementservice;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pagination.response.PaginationImplementation;
import com.pagination.response.PaginationResponse;
import com.repository.data.Entitlement;
import com.repository.service.EntitlementJpaRepository;

import jakarta.validation.Valid;



@RestController
@Validated
public class EntitlementRestController {
	@Autowired
	private EntitlementJpaRepository entitlementJpaRepositoryResource ;
	@Autowired
	private PaginationImplementation paginationImplService;
	/*
	@GetMapping("/entitlements")
	public List<Entitlement> retrieveEntitlements()
	{
		Pageable firstPageWithfiveElements = PageRequest.of(0, 5);
		//Pageable secondPageWithfiveElements = PageRequest.of(1, 5);
		Page<Entitlement> pageObj= entitlementJpaRepositoryResource.findAll(firstPageWithfiveElements);
		List<Entitlement> ents=		pageObj.getContent();
		return ents;
	}
	*/
	@GetMapping("/records")
	public List<Entitlement> getAllEntitlements()
	{
	    //Pageable records = PageRequest.of(pageNo, pageSize);
		Pageable records = PageRequest.of(0, 4);
	    Page<Entitlement> recordsList = entitlementJpaRepositoryResource.findAll(records);
	 //   PaginationResponse<Entitlement> resp=paginationImplService.getAllRecords(pageNo, pageSize,recordsList);
	    List<Entitlement> list =  recordsList.getContent();

	    return entitlementJpaRepositoryResource.findAll();  
	   
	}

	@GetMapping("/entitlements")
	public List<Entitlement> getEntitlements()
	{
		return entitlementJpaRepositoryResource.findAll();
	}
	@GetMapping("/entitlement/{id}")
	public Optional<Entitlement> retrieveEntitlementById(@PathVariable int id)throws Exception
	{
		Optional<Entitlement> entitlement =  entitlementJpaRepositoryResource.findById(id);
		if (!entitlement.isPresent())
			throw new EntitlementNotFoundException("Entitlement not found for id : "+id);
		return entitlement;
	}
	@PostMapping("/entitlement")
	public ResponseEntity<Entitlement> createEntitlement(@RequestBody Entitlement entitlement)
	{
		Entitlement savedEntitlement =entitlementJpaRepositoryResource.save(entitlement);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEntitlement.getEntitlementId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PostMapping("/entitlement/update/{id}")
	public ResponseEntity<Entitlement> updateEntitlement(@RequestBody Entitlement entitlement,@PathVariable int id)
	{
		Optional<Entitlement> oldEntitlement = entitlementJpaRepositoryResource.findById(id);
		Entitlement entitlementObj = oldEntitlement.get();
		entitlementObj.setEntitlementName(entitlement.getEntitlementName());
		entitlementObj.setEntitlementDescription(entitlement.getEntitlementDescription());
		entitlementObj.setCreateDateTime(entitlement.getCreateDateTime());
		Entitlement savedEntitlement =entitlementJpaRepositoryResource.save(entitlementObj);
		return ResponseEntity.ok(savedEntitlement);
	}
	
	@DeleteMapping("/entitlement/{id}")
	public void deleteEntitlementById(@PathVariable int id)
	{
		entitlementJpaRepositoryResource.deleteById(id);
	}
	
	@GetMapping("/params")
	public ResponseEntity<Object> getparam(@RequestParam int id,@RequestParam int id1)
	{
		String obj = Integer.toString(id);
		String obj1 = Integer.toString(id1);
		return ResponseEntity.ok(obj+obj1);
	}
	{
		
	}
}
