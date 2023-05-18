package com.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repository.data.UserProfileToUser;

@Repository
public interface UserProfileToUserJpaRepository extends JpaRepository<UserProfileToUser, Integer>{

}
