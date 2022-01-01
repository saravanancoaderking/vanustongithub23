package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PatientsRelatives;

@Repository
public interface PatientrelativesRepository extends JpaRepository<PatientsRelatives, Long> {

}
