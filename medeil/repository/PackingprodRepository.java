package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.medeil.domain.PackingProducts;


public interface PackingprodRepository extends JpaRepository<PackingProducts, Long>{
	@Query(value = "  SELECT   IFNULL(  max( PackingAutoID ) ,0 )  FROM   medc_deliveryprocess.medc_packing   where    companyrefid=?1 and branchrefid =?2 and  LocName=?3 and LocRefID=?4    ", nativeQuery = true)
	int pRefID(int cid, int bid, int lcrnm, int lcrid);
	
	
}
