package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Diractcustomer;

@SuppressWarnings("rawtypes")
@Repository

public interface DiractcustomerRepository extends JpaRepository<Diractcustomer, Long>{

}
