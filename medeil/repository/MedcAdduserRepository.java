package com.medeil.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.MedcAdduser;

@Repository
public interface MedcAdduserRepository extends JpaRepository<MedcAdduser, Long> {
	MedcAdduser findByUsername(String name);

	boolean existsByPhoneno(String number);

	boolean existsByUsername(String name);

	boolean existsByUsernameAndPhoneno(String name, String mobile);
	
	@Query(value = "SELECT * FROM medc_productmaster.medc_vanustonvertical", nativeQuery = true)
	List Verticallist();  


}
