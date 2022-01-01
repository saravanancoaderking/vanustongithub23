package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PatientLoginProduct;

@SuppressWarnings("rawtypes")
@Repository
public interface PatientLoginProductrepostitory extends JpaRepository<PatientLoginProduct, Long> {
	@Query(value = "SELECT IFNULL( max(prescription_id),0) FROM medc_prescription.medc_manualprescription WHERE companyrefid =?1 AND branchrefid =?2 AND locname =?3 AND locrefid =?4 AND patient_id=?5", nativeQuery = true)
	int prefid(int comid,int branchid,int locname,int locrefid,int patient_id);

}
