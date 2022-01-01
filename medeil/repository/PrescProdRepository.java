package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.PrescProd;


public interface PrescProdRepository   extends
JpaRepository<PrescProd, Long> {
	
	PrescProd save(PrescProd pt);
	
	

	@Query(value = " SELECT   pm.BrandName, pr. PrcProdId, pr. PrsRefId,pr.drugproductid, pr. morning, pr. afternoon, pr. evening, pr. night, pr. days, pr. food, pr. dose, pr. total_medications , pr. bfaf, pr. fdinteraction ,pr.drgtyp,pr.convfactor,pr.genericid, pr.  CreatedBy  ,pr.ClientCDate1  as  cldate  FROM medc_clinic.medc_prescprod pr       left join ( SELECT ProductDrugID,BrandName FROM medc_productmaster.medc_custproductmaster  where   LocName=?2 and  LocRefID=?3 )  pm  on  pm.ProductDrugID=pr.DrugproductId    where   pr.PrsRefId=?1    and    pr.LocName=?2 and    pr.LocRefID=?3   and   Status!=5  ", nativeQuery = true)
	List viewPrescProducts(int name,int lcrid ,int lcrnm);
	
	
	

}
