package com.medeil.repository;
/**
 * 
 * 
 * Desing Raja
 * 
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.BonusLoyality;
import com.medeil.domain.BonusloyalityProduct;

public interface BonusLoyalityProductRepository extends JpaRepository<BonusloyalityProduct, Long> {
	
	
	@Query(value="SELECT ms.drugproductid,CONCAT(cpm.brandname,' ',cpm.genericnamedosage) productname FROM medc_stock.medc_mainstock ms\r\n" + 
			"INNER JOIN medc_productmaster.medc_custproductmaster cpm ON cpm.productdrugid = ms.drugproductid\r\n" + 
			"WHERE ms.companyrefid =:comid AND ms.branchrefid =:branchid AND ms.locname =:locname AND ms.locrefid=:locrefid",nativeQuery = true)
	List getproducts(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);

	@Query(value= "SELECT blp.produc_code,CONCAT(pm.brandname,' ',genericnamedosage) FROM medc_loyality.medc_blproduct blp\r\n" + 
			"INNER JOIN medc_productmaster.medc_custproductmaster pm ON pm.productdrugid = blp.produc_code\r\n" + 
			"WHERE blp.blrefid =?1" , nativeQuery = true)
	List getblproduct(int blid);
}
