package com.entitlementservice;

import java.time.LocalDateTime;

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
		ent.setEntitlementName("Tester 13");
		ent.setEntitlementDescription("Tester level 13");
		ent.setCreateDateTime(LocalDateTime.now());
		jparepo.save(ent);
	}
}
