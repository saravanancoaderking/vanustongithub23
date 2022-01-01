package com.medeil.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PurchaseInvoice;


@Repository
public interface PurchasenvoiceproRepository extends JpaRepository<PurchaseInvoice, Long>{

	@Query(value = "SELECT BatchID  from medc_stock.medc_drugbatch WHERE CompanyRefID=?1 and DrugProductRefID=?2 and Batchno=?3", nativeQuery = true)
	Integer getbatchid(Integer companyrefid, Integer drugproductrefid, String batchno);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_stock.medc_drugbatch(CompanyRefID,DrugProductRefID,BatchNo) values (?1,?2,?3)", nativeQuery = true)
	void insertbatchid(Integer companyrefid, Integer drugproductrefid, String batchid);
	
	@Modifying
	@Transactional
	@Query(value = "update medc_purchase.medc_poproduct set piflag=1 where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4 and porefid=?5 and drugproductrefid=?6", nativeQuery = true)
	void getupdateflag(Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid, Integer refpoid,Integer drugproductrefid);

	PurchaseInvoice findByPirefidAndDrugproductrefid(Integer valueOf, Integer valueOf2);

	

}
