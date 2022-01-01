package com.medeil.repository;

import java.util.List;

/**
  Raja
 **/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.DrAppointment;

@Repository
public interface DrAppointmentRepository extends JpaRepository<DrAppointment, Integer> {

	List findByDoctorrefid(Integer id);

}
