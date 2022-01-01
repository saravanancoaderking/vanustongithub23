package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.BonusLoyality;

public interface BonusLoyalityRepository extends JpaRepository<BonusLoyality,Long> {
	
	BonusLoyality save(BonusLoyality bonusLoyality);

	
	@Query(value="SELECT bl_id FROM medc_loyality.medc_bonus_loyality WHERE companyrefid =?1 AND  branchrefid = ?2 AND locname =?3 AND locrefid=?4 GROUP BY bl_id DESC LIMIT 1",nativeQuery = true)
	int getblid(int companyrefid, int branchrefid, int locname, int locrefid);
	
	@Query(value="SELECT bl.bl_id, bl.bonus_loyality,bl.min_purchase_amt,DATE(bl.from_date),DATE(bl.to_date),bl.discount_percent, bl.discount_amount,\r\n" + 
			"(SELECT COUNT(produc_code) FROM medc_loyality.medc_blproduct WHERE blrefid =bl.bl_id) totproduct FROM medc_loyality.medc_bonus_loyality bl\r\n" + 
			"WHERE bl.companyrefid =:comid AND bl.branchrefid =:branchid AND bl.locname =:locname AND bl.locrefid =:locrefid ORDER BY bl.bl_id DESC",nativeQuery = true)
	List getbonuslist(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);
	
	
	@Query(value = "SELECT cust_type_id,cust_type,min_loyality,min_amount,date(clientcdate) FROM medc_loyality.medc_cust_type m WHERE companyrefid =:comid AND branchrefid =:branchid AND locname =:locname AND locrefid =:locrefid ORDER BY min_amount asc;" , nativeQuery = true)
	List getloyalcusttype(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);

	@Query(value = "SELECT * FROM medc_loyality.medc_cust_loyalitypoints cl WHERE  cl.custrefid=?1" , nativeQuery = true)
	List getCustLoyaltyDetails(Integer custid);
}
