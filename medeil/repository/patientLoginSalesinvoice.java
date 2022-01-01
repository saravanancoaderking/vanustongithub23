
package com.medeil.repository;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.patientLoginSales;

@SuppressWarnings("rawtypes")
@Repository
public interface patientLoginSalesinvoice extends JpaRepository<patientLoginSales, Long> {

	@Query(value = "SELECT   SalesBillID, SalesBillNo ,DATE( ClientCDate ) ,TotalDiscount,TotalAmount, TotalItems,TaxableAmt, TotalTaxAmt,GrandTotal,refilldate  FROM medc_sales.medc_salesmaintenance   where  CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4 and CustomerRefID=?5     order  by  SalesBillID desc",nativeQuery = true)
	List paitentviewSalesInvoice(Integer cid, Integer bid,Integer lname,Integer lrid,Integer csrefid);
	
	@Query(value = "SELECT   SalesBillID, SalesBillNo ,DATE( ClientCDate ) ,TotalDiscount,TotalAmount, TotalItems,TaxableAmt, TotalTaxAmt,GrandTotal,refilldate  FROM medc_sales.medc_salesmaintenance   where  CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4 and CustomerRefID=?5     order  by  SalesBillID desc limit 5",nativeQuery = true)
	List paitentdashinvoice(Integer cid, Integer bid,Integer lname,Integer lrid,Integer csrefid);
	
	@Query(value = "SELECT  MONTHNAME(CURRENT_DATE()) month,YEAR(CURRENT_DATE())year, IFNULL(sum(GrandTotal),0) as Yeartotal FROM medc_sales.medc_salesmaintenance WHERE  YEAR(clientcdate) = YEAR(CURRENT_DATE)\r\n" + 
			"and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4 and CustomerRefID=?5",nativeQuery = true)
	Map ViewoneYeartotal(Integer cid, Integer bid, Integer lname, Integer lrid, Integer csrefid);

	@Query(value = "SELECT  MONTHNAME(CURRENT_DATE()) month,YEAR(CURRENT_DATE())year,IFNULL(sum(GrandTotal),0) as Monthtotal FROM medc_sales.medc_salesmaintenance WHERE MONTH(CURRENT_DATE()) = MONTH(clientcdate) AND YEAR(clientcdate) = YEAR(CURRENT_DATE)\r\n" + 
			"and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4 and CustomerRefID=?5",nativeQuery = true)
	Map ViewoneMonthtotal(Integer cid, Integer bid, Integer lname, Integer lrid, Integer csrefid);

	@Query(value = "SELECt IFNULL(sum(GrandTotal),0) as Grandtotal FROM medc_sales.medc_salesmaintenance where  CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4 and CustomerRefID=?5",nativeQuery = true)
	Map ViewoneGrandtotal(Integer cid, Integer bid, Integer lname, Integer lrid, Integer csrefid);

}
