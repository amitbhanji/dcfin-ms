package com.entitlementservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.repository.data.Entitlement;
import com.repository.service.EntitlementJpaRepository;

//@EnableJpaRepositories("com.repository.service")
//@EntityScan("com.repository.data")

//@DataJpaTest
@SpringBootTest
public class EntitlementServiceApplicationTests {

	@Autowired
	private EntitlementJpaRepository jparepo;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getEntitlement()
	{

		//jparepo.findById(5);
		Entitlement ent = new Entitlement();
		ent.setEntitlementName("Tester 14");
		ent.setEntitlementDescription("Tester level 14");
		ent.setCreateDateTime(LocalDateTime.now());
		Entitlement savedEnt=jparepo.save(ent);
		Optional<Entitlement> ent1 = jparepo.findById(savedEnt.getEntitlementId());
		Entitlement ent2 =  ent1.get();
		assertTrue(ent.getEntitlementId()==ent2.getEntitlementId());

	
	}
}
