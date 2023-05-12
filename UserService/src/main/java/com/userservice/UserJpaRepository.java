package com.userservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entitlementservice.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User,Integer> {

}
