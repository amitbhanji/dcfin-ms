package com.firm;

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

import com.repository.data.Firm;
import com.repository.service.FirmJpaRepository;



@RestController
public class FirmRestController {
	@Autowired
	private FirmJpaRepository firmJpaRepositoryResource ;
	
	@GetMapping("/firms")
	public List<Firm> retrieveFirms()
	{
		return firmJpaRepositoryResource.findAll();
	}
	@GetMapping("/firms/{id}")
	public Optional<Firm> retrieveFirmById(@PathVariable int id)throws Exception
	{
		Optional<Firm> firm =  firmJpaRepositoryResource.findById(id);
		if (!firm.isPresent())
			throw new FirmNotFoundException("Firm not found for id : "+id);
		return firm;
	}
	@PostMapping("/firms")
	public ResponseEntity<Firm> createFirm(@RequestBody Firm firm)
	{
		Firm savedFirm =firmJpaRepositoryResource.save(firm);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFirm.getFirmId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PostMapping("/firms/update/{id}")
	public ResponseEntity<Firm> updateFirm(@RequestBody Firm firm,@PathVariable int id)
	{
		Optional<Firm> oldfirm = firmJpaRepositoryResource.findById(id);
		Firm firmObj = oldfirm.get();
		firmObj.setFirmName(firm.getFirmName());
		firmObj.setDescription(firm.getDescription());
		firmObj.setCreateDate(firm.getCreateDate());
		Firm savedFirm =firmJpaRepositoryResource.save(firmObj);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFirm.getFirmId()).toUri();
		return ResponseEntity.ok(savedFirm);
	}
	
	
	
	@DeleteMapping("/firm/{id}")
	public void deleteFirmById(@PathVariable int id)
	{
		firmJpaRepositoryResource.deleteById(id);
	}
}
