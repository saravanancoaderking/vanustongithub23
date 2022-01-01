package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PrProducts;

@Repository
public interface PrProductsRepository extends JpaRepository<PrProducts, Long> {

	PrProducts save(PrProducts pr);
	
	
	
	
	
	
	
	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_mainstock   set qty=qty-?5  where   DrugProductID=?3  and   Batchname=?4  and LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int  updateMainstockSave( Double lcrnm ,Double lcrid,String drg, String batch, String qty );

	@Modifying
	@Transactional
	@Query(value = "  update  medc_stock.medc_mainstock   stk  join ( SELECT  sum(TotalQuantity) as   purctotqty ,DrugproductId ,BatchRefId   FROM medc_purchasereturn.medc_prproduct  where PRRefID=?3 and LocName=?1 and LocRefID=?2  group  by DrugproductId ,BatchRefId) pr    on pr.DrugproductId=stk.DrugProductID  and  pr.BatchRefId=stk.Batchno    set  stk.qty= ifnull(stk.qty,0)+ ifnull(pr.purctotqty,0)   where stk.LocName =?1 and stk.LocRefID=?2   ", nativeQuery = true)
	int updateMainstockEdit(Double lcrnm ,Double lcrid,int id);

	
	
	
	
	
}
