










package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.SalesDummy;

@Repository
public interface SDummyRepository extends JpaRepository<SalesDummy, Long> {

	SalesDummy save(SalesDummy pt);

	@Query(value = " SELECT   PatientID, PatientFirstName ,LoyaltyFlag   FROM  medc_patientreg.medc_patientbasicinfo       where  LocName=?1 and LocRefID=?2     ", nativeQuery = true)
	List viewCustomers(int lcrnm, int lcrid);

	@Query(value = " SELECT  DoctorID , DoctorName  FROM medc_doctorreg.doctorregistration       where  LocName=?1 and LocRefID=?2     ", nativeQuery = true)
	List viewDoctors(int lcrnm, int lcrid);

	@Query(value = " SELECT cst.BrandName , cst.ProductDrugID , cst.Quantity     FROM   medc_productmaster.medc_custproductmaster  cst      where     cst.BrandName like  %?3%     and   ((LocName=?1 and  LocRefID=?2) || (companyID=?4))    ORDER BY     cst.BrandName  LIMIT 10 ", nativeQuery = true)
	List viewProductNames(int lcrnm, int lcrid, String name ,Integer  compid );

	@Query(value = " SELECT cst.BrandName ,cst.ProductDrugID , cst.Quantity ,cst.mrp,cst.VAT ,     cst. SGST ,cst. CGST , cst.IGST , cst.UtGST ,  cst.Stripperbox*cst.Quantityperstrip       , cst.Quantityperstrip  ,0  ,2  FROM   medc_productmaster.medc_custproductmaster  cst 	 	where  cst.ProductDrugID  = ?3      and    ((cst.LocName=?1 and  cst.LocRefID=?2) || (cst.companyID=?4)) ", nativeQuery = true)
	List viewProductName(int lcrnm, int lcrid, int drg ,Integer  compid );

	@Query(value = "SELECT  stk.brandname, stk.ProductDrugID ,stk.Quantity    FROM medc_productmaster.medc_barcodemapping  br  left join(  SELECT brandname, ProductDrugID ,Quantity FROM medc_productmaster.medc_custproductmaster  where  ((LocName=?1 and  LocRefID=?2) || (companyID=?4))    ) stk   on  br.DrugProductID  =stk.ProductDrugID   where   br.barcode=?3  and br.LocName=?1 and br.LocRefID=?2  order by  stk.Quantity  limit 1", nativeQuery = true)
	List viewBarCodeProd(int lcrnm, int lcrid, String barcode ,Integer  compid );

	@Query(value = " SELECT   IFNULL(   max(  SalesBillID  ) ,0  )  FROM   medc_sales.medc_salesmaintenance   where  SalesBillType='2' and   LocName=?1 and LocRefID=?2    ", nativeQuery = true)
	int viewSalesDummyId(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT    IFNULL(   RIGHT(  salesbillno, 7  ) ,0  )  FROM   medc_sales.medc_salesmaintenance   where  SalesBillID=?3      and    LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	String viewSalesDummyIncNo(Double lcrnm, Double lcrid, int id);

	@Query(value = " SELECT    SalesBillID, SalesBillNo ,DATE(  ClientCDate1  ),TotalDiscount,TotalAmount,      TotalItems,TaxableAmt, TotalTaxAmt,GrandTotal    FROM medc_sales.medc_salesmaintenance       where SalesBillType='2' and  LocName=?1 and LocRefID=?2   and   Status!=5   order  by SalesBillID desc", nativeQuery = true)
	List viewSalesDummyAll(int lcrnm, int lcrid);

	@Query(value = " 	SELECT    si.salesbillid,si. salesbilltype,si. salesbillno,si. billdate,si. customerrefid     ,si. doctorrefid,si. totalamount,si. totalitems ,si.  totaldiscount,si. taxableamt,      si. totaltaxamt,si.  totalinclamt,si. totalexclamt,si.grandtotal ,si. createdby     , si.prescpath  , si.PaymentType,si.PtRefNo , pt.PatientFirstName  ,si.ClientCDate1  as  cldate      ,DATE(  si.ClientCDate1  )  FROM   medc_sales.medc_salesmaintenance  si  left  join  (   SELECT  PatientID, PatientFirstName FROM medc_patientreg.medc_patientbasicinfo  where    locrefid=?2  and  LocName=?1   ) pt	on si.customerrefid=pt.PatientID    where   si.SalesBillID= ?3 and  si.Status!=5 ", nativeQuery = true)
	List viewSalesDummy(int lcrnm, int lcrid, int name);

	@Query(value = "  SELECT * FROM medc_globalsettings.medc_pricemaster where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewPriceSettings(int lcrnm, int lcrid);

	@Query(value = " SELECT * FROM medc_globalsettings.medc_discountmaster  where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewDiscountSettings(int lcrnm, int lcrid);
	


	@Modifying
	@Transactional
	@Query(value = "update  medc_sales.medc_salesmaintenance   set   Status=5   where   salesbillid=?3  and   LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteSalesDummy(int lcrnm, int lcrid, int id);
}

















