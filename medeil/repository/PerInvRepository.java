


package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.medeil.domain.SalesDummy;



@Repository
public interface PerInvRepository extends JpaRepository<SalesDummy, Long> {

	SalesDummy save( SalesDummy pt );
	
	@Query( value = " insert into  medc_stock.medc_tempstock( LocName,LocRefID ,DrugProductID, Batchno, Qty)   values( ?1,?2,?3,?4,?5 )  ", nativeQuery = true )
	Double   saveTempStock(  int lcrnm ,int lcrid  , int drg,int batch,int qty);


	@Query( value = " SELECT   PatientID, PatientFirstName ,LoyaltyFlag   FROM  medc_patientreg.medc_patientbasicinfo       where  LocName=?1 and LocRefID=?2     ", nativeQuery = true )
	List viewCustomers( int lcrnm ,int lcrid   );

	
	@Query( value = " SELECT  DoctorID , DoctorName  FROM medc_doctorreg.doctorregistration       where  LocName=?1 and LocRefID=?2     ", nativeQuery = true )
	List viewDoctors( int lcrnm ,int lcrid   );
	
	
	
	
	
	
	
	
	
	
	@Query( value = "  SELECT stk.BrandName,stk.DrugProductID , stk.Batchno , stk.Qty , stk.MinQty ,DATEDIFF( stk.ExpiryDate,CURDATE(  ) )     FROM     medc_stock.medc_mainstock  stk      where     stk.BrandName like  %?3%     and    stk.LocName=?1 and  stk.LocRefID=?2    ORDER BY     stk.BrandName  LIMIT 10 ", nativeQuery = true )
	List viewProductNames( int lcrnm ,int lcrid  ,  String name );

	@Query( value = " 	SELECT stk. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. SellingPrice,      stk. MRP, stk.unitsgst, stk.unitcgst, stk.unitigst, stk.unitutgst,      stk.vat , pdt. Stripperbox ,pdt. Quantityperstrip,gst.GstFlag  ,gst.FrGstFlag,      stk.sellingprice1 , stk.sellingprice2 , stk.sellingprice3 , stk.sellingprice4   FROM  medc_stock.medc_mainstock stk 	left join ( SELECT BrandName,ProductDrugID,Stripperbox  ,Quantityperstrip    from medc_productmaster.medc_custproductmaster   where  LocName=?1 and  LocRefID=?2   ) pdt on stk.DrugProductID=pdt.ProductDrugID    	left join ( SELECT  GstFlag,FrGstFlag,LocRefID  from medc_globalsettings.medc_gstsettings where  LocName=?1 and  LocRefID=?2  ) gst   on gst.LocRefID=stk.LocRefID	where    stk.DrugProductID=?3   and  stk.Batchno=?4    and  stk.LocName=?1   and  stk.LocRefID=?2  ", nativeQuery = true )
	List viewProductName( int lcrnm ,int lcrid  ,  int drg,int batch );

	@Query( value = "  SELECT   IFNULL(  max( SalesBillID ) ,0 )  FROM   medc_sales.medc_salesmaintenance   where    SalesBillType='3' and  LocName=?1 and LocRefID=?2    ", nativeQuery = true )
	int viewSalesInvoiceId(  Double lcrnm ,Double lcrid  );

	@Query( value = "  SELECT    IFNULL( RIGHT( salesbillno, 7 ),0 )    FROM   medc_sales.medc_salesmaintenance   where  SalesBillID=?3     and    LocName=?1 and LocRefID=?2 ", nativeQuery = true )
	String viewSalesInvoiceIncNo(  Double lcrnm ,Double lcrid  ,  int id);

	
	
	
	
	@Query( value = "   SELECT  SalesBillID, SalesBillNo,DATE( ClientCDate1 )  FROM medc_sales.medc_salesmaintenance       where  SalesBillType='3'  and  PerfomaFlag=0  and   LocName=?1 and LocRefID=?2    and   Status!=5   ", nativeQuery = true )
	List viewSalesInvoiceAll( int lcrnm ,int lcrid );
	
	

	@Query( value = "SELECT    si.salesbillid,si. salesbilltype,si. salesbillno,si. billdate,si. customerrefid,     si. doctorrefid,si. totalamount,si. totalitems ,si.  totaldiscount,si. taxableamt,      si. totaltaxamt,si.  totalinclamt,si. totalexclamt,si.grandtotal ,si. createdby   , si.prescpath  , si.PaymentType,si.PtRefNo , pt.PatientFirstName    ,si.ClientCDate1   as  cldate                     ,DATE( si.ClientCDate1 )  FROM   medc_sales.medc_salesmaintenance  si 	left  join  (  SELECT  PatientID, PatientFirstName FROM medc_patientreg.medc_patientbasicinfo where  locrefid=?2  and  LocName=?1  )  pt	on si.customerrefid=pt.PatientID    where   si.SalesBillID= ?3      and    si.LocName=?1   and  si.LocRefID=?2", nativeQuery = true )
	List viewSalesInvoice( int lcrnm ,int lcrid  ,  int name);
	

	@Query( value = "  SELECT * FROM medc_globalsettings.medc_pricemaster where  LocName=?1 and LocRefID=?2  ", nativeQuery = true )
	List viewPriceSettings( int lcrnm ,int lcrid   );
	
	@Query( value = " SELECT * FROM medc_globalsettings.medc_discountmaster  where  LocName=?1 and LocRefID=?2 ", nativeQuery = true )
	List viewDiscountSettings( int lcrnm ,int lcrid   );
	
	
	
	
	
	@Query( value = "   SELECT   *  FROM medc_sales.medc_salesmaintenance     where   CustomerRefID =?3  and   LocName=?1 and LocRefID=?2  and SalesBillType='3'      ", nativeQuery = true )
	List viewSalesInvCustAll( int lcrnm ,int lcrid  ,  int  id);
	
	@Query( value = "   SELECT   *  FROM medc_sales.medc_salesmaintenance     where  CustomerRefID =?3    and   LocName=?1 and LocRefID=?2  and  SalesBillType='3'  ", nativeQuery = true )
	List viewSalesDumCustAll(  int lcrnm ,int lcrid  , int  id );
	
	
	
	@Query( value = " update  medc_stock.medc_mainstock   set qty=IFNULL(qty,0)-?5  where   DrugProductID=?3  and   BatchRefID=?4  and LocName=?1 and LocRefID=?2  ", nativeQuery = true )
	Double   updateTempStockMain( int lcrnm ,int lcrid  ,  int drg,int batch , int qty);
	
	
	
	
	
	@Modifying
	@Transactional
	@Query( value = " update  medc_stock.medc_mainstock   set qty=IFNULL(qty,0)-?5  where   DrugProductID=?3  and   Batchno=?4     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true )
	void updateMainstockSave( Double lcrnm ,Double lcrid  ,  Double drg, Double bth, Double qty );
	
	

	@Modifying
	@Transactional
	@Query( value = " update  medc_stock.medc_mainstock    stk    join ( SELECT  sum(totalqty) as   salestotqty ,DrugProductID ,BatchRefID   FROM medc_sales.medc_salesbill  where SalesRefID=?3 and LocName=?1 and LocRefID=?2   group  by DrugProductID ,BatchRefID) sd  on sd.DrugProductID=stk.DrugProductID  and    sd.BatchRefID=stk.Batchno   set  stk.qty= ifnull(stk.qty,0)+ ifnull(sd.salestotqty,0)   where stk.LocName =?1 and stk.LocRefID=?2   ", nativeQuery = true )
	int  updateMainstockEdit( Double lcrnm ,Double lcrid  ,  int stk  );
	
	
	@Modifying
	@Transactional
	@Query( value = "update   medc_sales.medc_salesmaintenance    set   SalesBillID=?3  where LocName=?1 and LocRefID=?2  ", nativeQuery = true )
	int deleteSalesInvoice( int lcrnm ,int lcrid  ,  int id);


}



