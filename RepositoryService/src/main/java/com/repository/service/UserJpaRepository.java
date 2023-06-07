package com.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.repository.data.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User,Integer> {

	@Query("select u from User u where u.userEmail = ?1")
	public User findUserByEmail(String email);
	
	@Query("select u from User u where u.username = :username")
	public User getUserByUserName(@Param("username")String username);
}
