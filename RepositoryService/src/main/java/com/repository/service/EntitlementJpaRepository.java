package com.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repository.data.Entitlement;

@Repository
public interface EntitlementJpaRepository extends JpaRepository<Entitlement, Integer>{

}
