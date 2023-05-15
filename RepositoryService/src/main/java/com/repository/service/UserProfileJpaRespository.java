package com.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.repository.data.UserProfile;

@Repository
public interface UserProfileJpaRespository extends JpaRepository<UserProfile,Integer>{

	
}
