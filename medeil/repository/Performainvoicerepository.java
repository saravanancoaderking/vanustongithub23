package com.medeil.repository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Performinvoice;

@SuppressWarnings("rawtypes")
@Repository

public interface Performainvoicerepository extends JpaRepository<Performinvoice, Long> {

	@Query(value = "SELECT IFNULL(max(SalesBillID ),0) from medc_sales.medc_performinvoice", nativeQuery = true)
	Integer getId();

	
	@Modifying
	@Transactional
	@Query(value = "update  medc_sales.medc_performproduct set salesflag=1  where   salesorderrefid=?3 and drugproductid=?4   and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updatesalesorderflag(double locname, double locrefid, int salesorderid, double drugid);

	@Query(value = "SELECT   max(  SalesBillID  )  FROM   medc_sales.medc_performinvoice ", nativeQuery = true)
	int viewSalesDummyId();

	@Query(value = "SELECT   SalesBillID, SalesBillNo , salesorderno, DATE( ClientCDate ) ,TotalDiscount,TotalAmount, TotalItems,TaxableAmt, TotalTaxAmt,GrandTotal,refilldate  FROM medc_sales.medc_performinvoice   where  CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4 and CustomerRefID=?5   order  by  SalesBillID desc",nativeQuery = true)
	List paitentviewPerformInvoice(Integer cid, Integer bid, Integer lname, Integer lrid, Integer patientid);

	@Query(value = "SELECT  pi.SalesBillID, pi.SalesBillNo , pi.salesorderno, DATE(pi.ClientCDate ) ,pi.TotalDiscount,pi.TotalAmount, pi.TotalItems,\r\n" + 
			"pi.TaxableAmt, pi.TotalTaxAmt,pi.GrandTotal,pi.refilldate,pi.customerrefid,concat(pr.patientfirstname,' ',pr.patientlastname) as patientname,\r\n" + 
			"pr.mobile,pr.email FROM medc_sales.medc_performinvoice pi\r\n" + 
			"left join medc_patientreg.medc_patientbasicinfo pr on pr.patientid=pi.customerrefid\r\n" + 
			"where  pi.CompanyRefID=?1  and pi.BranchRefID=?2 and pi.LocName=?3  and  pi.LocRefID=?4  order  by  pi.SalesBillID desc",nativeQuery = true)
	List viewperforminvoiceall(Integer cid, Integer bid, Integer lname, Integer lrid);
	
	@Query(value = "select prd.salesrefid,prd.drugproductid, cpm.brandname,prd.indvqty, prd.unitprice,prd.subtotal, prd.expirydate\r\n" + 
			"from medc_sales.medc_performproduct prd\r\n" + 
			"INNER JOIN medc_sales.medc_performinvoice piv ON piv.SalesBillID=prd.SalesRefID\r\n" + 
			"left join medc_productmaster.medc_custproductmaster cpm on prd.drugproductid = cpm.productdrugid\r\n" + 
			"where prd.SalesRefID=?1",nativeQuery = true)
	List ProformainvoiceViewProducts(Integer invid);
	
	@Query(value = "select concat(patientfirstname,' ',patientlastname) patientname,\r\n" + 
			"piv.salesbillno,piv.billdate,piv.totalitems,piv.totalqty,piv.grandtotal,pt.patientcode from medc_sales.medc_performinvoice piv\r\n" + 
			"INNER JOIN medc_patientreg.medc_patientbasicinfo pt ON pt.PatientID=piv.CustomerRefID\r\n" + 
			"where piv.salesorderno =?1 group by pt.patientcode;",nativeQuery = true)
	Set perinvoicedetails(Integer salesorderid);
	
	@Query(value = "select prd.salesrefid,prd.drugproductid, cpm.brandname,prd.indvqty, prd.unitprice,prd.subtotal, prd.expirydate\r\n" + 
			"from medc_sales.medc_performproduct prd\r\n" + 
			"INNER JOIN medc_sales.medc_performinvoice piv ON piv.SalesBillID=prd.SalesRefID\r\n" + 
			"left join medc_productmaster.medc_custproductmaster cpm on prd.drugproductid = cpm.productdrugid\r\n" + 
			"where piv.salesorderno =?1 group by prd.drugproductid",nativeQuery = true)
	List perinvoiceproducts(Integer salesorderid);


	



}
