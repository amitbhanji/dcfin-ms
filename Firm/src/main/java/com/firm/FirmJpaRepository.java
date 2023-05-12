package com.firm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repositoryservice.Firm;

@Repository
public interface FirmJpaRepository extends JpaRepository<Firm, Integer> {

}
