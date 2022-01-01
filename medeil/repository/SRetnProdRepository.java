package com.medeil.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.SReturnProd;

@Transactional
@Repository
public interface SRetnProdRepository extends JpaRepository<SReturnProd, Long> {

	SReturnProd save(SReturnProd pr);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_mainstock   set LogCurrentQty=IFNULL(qty,0),LogInterMedQty=0, qty=ifnull(qty,0)+?5  where   DrugProductID=?3  and   Batchno=?4  and LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	void updateMainstockForSave(Double lcrnm, Double lcrid, Double drg,
			Double bth, Double qty);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_mainstock   set LogInterMedQty=IFNULL(qty,0), qty=ifnull(qty,0)+?5  where   DrugProductID=?3  and   Batchno=?4  and LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	void updateMainstockForEdit(Double lcrnm, Double lcrid, Double drg,
			Double bth, Double qty);

	@Modifying
	@Transactional
	@Query(value = " update  medc_stock.medc_mainstock    stk    join ( SELECT  sum(TotalQty) as   salestotqty ,DrugProductID ,BatchRefID   FROM medc_salesreturn.medc_srproduct  where SRRefID=?3 and LocName=?1 and LocRefID=?2   group  by DrugProductID ,BatchRefID) sd    on sd.DrugProductID=stk.DrugProductID  and    sd.BatchRefID=stk.Batchno   set  stk.LogCurrentQty=ifnull(stk.qty,0),  stk.qty= ifnull(stk.qty,0)- ifnull(sd.salestotqty,0)   where stk.LocName =?1 and stk.LocRefID=?2 ", nativeQuery = true)
	void updateMainstockEdit(Double lcrnm, Double lcrid, int sd);

}
