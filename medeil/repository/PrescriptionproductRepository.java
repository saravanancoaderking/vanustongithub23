package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.medeil.domain.PrescriptionProduct;


public interface PrescriptionproductRepository extends JpaRepository<PrescriptionProduct, Long>{

	
	@Query(value = "SELECT pm.mainpresrefid,pm.drugproductid,pro.brandname,pm.totalmedicine,pm.morning,pm.afternoon,pm.evening,pm.night,pm.days,pm.presproid FROM medc_practicemanagement.medc_prescriptionproduct pm\r\n" + 
			"	INNER JOIN medc_productmaster.medc_custproductmaster pro ON pro.productdrugid = pm.drugproductid WHERE delstatus=0 AND mainpresrefid=?1",nativeQuery = true)
	List getprespro(Integer id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE medc_practicemanagement.medc_prescriptionproduct SET delstatus=1 WHERE mainpresrefid =?1 AND drugproductid=?2",nativeQuery = true)
	Void delupdate(Integer id,Integer prodid);
	

	void save(List<PrescriptionProduct> updatePracprod);
}
