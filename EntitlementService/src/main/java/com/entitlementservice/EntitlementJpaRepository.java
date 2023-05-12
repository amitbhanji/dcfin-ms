package com.entitlementservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repositoryservice.Entitlement;

public interface EntitlementJpaRepository extends JpaRepository<Entitlement, Integer>{

}
