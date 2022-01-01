package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PatientDetails;

@Repository
public interface PatientDetailRepository extends
		JpaRepository<PatientDetails, Long> {

	PatientDetails save(PatientDetails pt);

}
