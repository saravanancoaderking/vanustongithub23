package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Hsn_id;

public interface HsnidRepository extends JpaRepository<Hsn_id,Double> {
		
	@Query(value="SELECT IFNULL(MAX(mdescid),0) FROM medc_productmaster.medc_hsn_mdescription WHERE companyrefid=:Companyrefid",nativeQuery=true)
	int gethsnrefid(@Param("Companyrefid") int Companyrefid);

}
