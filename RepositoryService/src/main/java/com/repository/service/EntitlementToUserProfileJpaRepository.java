package com.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repository.data.EntitlementToUserProfile;

@Repository
public interface EntitlementToUserProfileJpaRepository extends JpaRepository<EntitlementToUserProfile, Integer> {

}
