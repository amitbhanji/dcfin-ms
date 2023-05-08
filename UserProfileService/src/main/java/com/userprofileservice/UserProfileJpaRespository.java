package com.userprofileservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileJpaRespository extends JpaRepository<UserProfile,Integer>{

}
