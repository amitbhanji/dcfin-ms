package com.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repository.data.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User,Integer> {

}
