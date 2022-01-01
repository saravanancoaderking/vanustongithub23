package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PatientType;

@Repository
public interface PatientTypeRepository extends JpaRepository<PatientType, Integer> {

}
