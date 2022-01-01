package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.medeil.domain.PickingProduct;

@SuppressWarnings("rawtypes")
@Repository
public interface PickingProductRepository extends JpaRepository<PickingProduct, Long> {
	@Query(value = "  SELECT   IFNULL(  max( picklistid ) ,0 )  FROM   medc_deliveryprocess.medc_picking   where    companyrefid=?1 and branchrefid =?2 and  LocName=?3 and LocRefID=?4    ", nativeQuery = true)
	int pRefID(int cid, int bid, int lcrnm, int lcrid);
	
	
}