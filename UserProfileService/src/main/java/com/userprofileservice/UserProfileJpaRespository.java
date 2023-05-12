package com.userprofileservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entitlementservice.UserProfile;

@Repository
public interface UserProfileJpaRespository extends JpaRepository<UserProfile,Integer>{

}
