package com.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.repository.data.UserProfile;

import jakarta.annotation.Resource;

@Repository
public interface UserProfileJpaRespository extends JpaRepository<UserProfile,Integer>{

	
}
