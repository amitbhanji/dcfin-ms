package com.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repository.data.Firm;

@Repository
public interface FirmJpaRepository extends JpaRepository<Firm, Integer> {

}
