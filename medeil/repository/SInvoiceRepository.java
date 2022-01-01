package com.medeil.repository;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.SalesDummy;

@SuppressWarnings("rawtypes")
@Repository
public interface SInvoiceRepository extends JpaRepository<SalesDummy, Integer> {

	// SalesDummy save(SalesDummy pt);

	@Query(value = " insert into  medc_stock.medc_tempstock( LocName,LocRefID,DrugProductID, Batchno, Qty )   values( ?1,?2,?3,?4,?5 )  ", nativeQuery = true)
	Double saveTempStock(int lcrnm, int lcrid, int drg, int batch, int qty);

	@Transactional
	@Modifying
	@Query(value = " insert into  medc_stock.medc_stocklog( StockID,BrandName,  CurrentQty, ChangedQty, FinalQty,LocName, LocRefID, InvoiceNo,InvoiceType )  select  stockid,BrandName, LogCurrentQty ,LogInterMedQty,qty ,locname,locrefid,?5,1  from  medc_stock.medc_mainstock  where   DrugProductID=?3  and   Batchno=?4     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int saveStockLogs(Double lcrnm, Double lcrid, Double drg, Double batch, int invoiceno);

//	@Query(value = " SELECT   PatientID, PatientFirstName ,LoyaltyFlag ,scitizenflag,phycapflag    , scitizenno,phycapno  FROM  medc_patientreg.medc_patientbasicinfo       where  LocName=?1 and LocRefID=?2  and PatientFirstName like ?3%   ", nativeQuery = true)
//	List viewCustomers(int lcrnm, int lcrid, String searchvalue);

	@Query(value = " SELECT   PatientID, PatientFirstName ,LoyaltyFlag ,scitizenflag,phycapflag    , scitizenno,phycapno  FROM  medc_patientreg.medc_patientbasicinfo       where  LocName=?1 and LocRefID=?2", nativeQuery = true)
	List viewsoCustomers(int lcrnm, int lcrid);

	@Query(value = " SELECT  Distinct(so.PatientID) ,concat(pb.PatientFirstName,'_',coalesce(pb.mobile,'')) as patmobile,pb.mobile,pb.email,pb.LoyaltyFlag ,pb.scitizenflag,pb.phycapflag, pb.scitizenno,pb.phycapno,pb.refillcustomer,pb.previousbalance FROM medc_sales.medc_salesorder so\r\n"
			+ "inner join medc_patientreg.medc_patientbasicinfo pb on pb.PatientID = so.PatientID  inner join medc_sales.medc_salesordprd sop on sop.salesorderrefid=so.orderid  where   sop.salesflag=0 and  so.companyrefid=?1 and so.branchrefid=?2 and so.LocName=?3 and so.LocRefID=?4  and (pb.PatientFirstName like ?5%  or pb.mobile like ?5%)", nativeQuery = true)
	List viewSalesOrderCustomer(int compid, int branchid, int lcrnm, int lcrid, String searchvalue);

	@Query(value = " SELECT  DoctorID , DoctorName  FROM medc_doctorreg.doctorregistration  where companyrefid=?1 and branchrefid=?2 and  LocName=?3 and LocRefID=?4     ", nativeQuery = true)
	List viewDoctors(int compid, int branchid, int lcrnm, int lcrid);

	@Query(value = "SELECT concat(cu.BrandName,' ',ifnull(cu.genericnamedosage,'1mg'),' ',ifnull(fu.formulationname,'Tablet')) as BrandName,stk.DrugProductID , stk.Batchno , stk.Qty , stk.MinQty,DATEDIFF( stk.ExpiryDate,CURDATE(  ) ) , db.batchno as batchnames,Date(stk.ExpiryDate ),\n"
			+ "gm.genericname,cu.subgroupid1,stk.stockid,FORMAT(stk.unitprice, 2),ses.no_days,DATEDIFF(stk.ExpiryDate,CURDATE()) as DateDiff,IF(stk.ExpiryDate<CURDATE(),1, 0) FROM  medc_stock.medc_mainstock  stk\n"
			+ "inner join  medc_productmaster.medc_custproductmaster cu on cu.productdrugid=stk.drugproductid\n"
			+ "inner join medc_productmaster.medc_formulation fu on fu.formulationid=cu.formulationid\n"
			+ "inner join medc_productmaster.medc_genericmaster gm on gm.genericid=cu.genericid\n"
			+ "left join  medc_stock.medc_drugbatch db on stk.batchno=db.batchid\n"
			+ "left join medc_stock.medc_shortexpsettings ses ON ses.locrefid=stk.locrefid\n"
			+ "where stk.companyrefid =?1 and stk.branchrefid =?2  and  stk.LocName=?3 and  stk.LocRefID=?4 and cu.BrandName like  ?5%  and stk.status=0 and stk.Qty>0 ORDER BY  stk.BrandName LIMIT 10", nativeQuery = true)
	List viewProductNames(int comp, int branch, int lcrnm, int lcrid, String searchvalue);

	@Query(value = "SELECT concat(stk.BrandName,' ',ifnull(cu.genericnamedosage,'1mg'),' ',ifnull(fu.formulationname,'Tablet')) as BrandName,stk.DrugProductID , stk.Batchno , stk.Qty , stk.MinQty,DATEDIFF( stk.ExpiryDate,CURDATE(  ) ) , db.batchno as batchnames,Date(stk.ExpiryDate ),\n"
			+ "gm.genericname,cu.subgroupid1,stk.stockid,FORMAT(stk.unitprice, 2),ses.no_days,DATEDIFF(stk.ExpiryDate,CURDATE()) as DateDiff,IF(stk.ExpiryDate<CURDATE(),1, 0) FROM  medc_stock.medc_mainstock  stk\n"
			+ "inner join  medc_productmaster.medc_custproductmaster cu on cu.productdrugid=stk.drugproductid\n"
			+ "inner join medc_productmaster.medc_formulation fu on fu.formulationid=cu.formulationid\n"
			+ "inner join medc_productmaster.medc_genericmaster gm on gm.genericid=cu.genericid\n"
			+ "left join  medc_stock.medc_drugbatch db on stk.batchno=db.batchid\n"
			+ "left join medc_stock.medc_shortexpsettings ses ON ses.locrefid=stk.locrefid\n"
			+ "where stk.companyrefid =?1 and stk.branchrefid =?2  and  stk.LocName=?3 and  stk.LocRefID=?4 and gm.genericname like ?5%  and stk.status=0 and stk.Qty>0 ORDER BY   stk.BrandName LIMIT 10", nativeQuery = true)
	List viewGenericNames(int comp, int branch, int lcrnm, int lcrid, String searchvalue);

	@Query(value = "SELECT concat(stk.BrandName,' ',cu.genericnamedosage,' ',fu.formulationname) as BrandName,stk.DrugProductID , stk.Batchno , stk.Qty , stk.MinQty,\n"
			+ "DATEDIFF( stk.ExpiryDate,CURDATE(  ) ) , db.batchno as batchnames,Date(stk.ExpiryDate ),gm.genericname,cu.subgroupid1, stk.stockid FROM medc_stock.medc_mainstock stk\n"
			+ "inner join  medc_productmaster.medc_custproductmaster cu on cu.productdrugid=stk.drugproductid\n"
			+ "inner join medc_productmaster.medc_formulation fu on fu.formulationid=cu.formulationid\n"
			+ "inner join medc_productmaster.medc_genericmaster gm on gm.genericid=cu.genericid\n"
			+ "left join  medc_stock.medc_drugbatch db on stk.batchno=db.batchid\n"
			+ "where stk.barcodelabel like  ?5%  and stk.companyrefid =?1 and stk.branchrefid = ?2  and  stk.LocName=?3 and  stk.LocRefID=?4  and stk.status=0 and stk.Qty>0 ORDER BY  stk.BrandName  LIMIT 10", nativeQuery = true)
	List viewBarcodeNames(int comp, int branch, int lcrnm, int lcrid, String searchvalue);

	@Query(value = "  SELECT stk.BrandName,stk.DrugProductID , stk.Batchno , stk.Qty , stk.MinQty        ,DATEDIFF( stk.ExpiryDate,CURDATE(  ) ),LEFT(stk.GenericName, 15), stk.batchname ,Date(stk.ExpiryDate ) ,stk.stockid    FROM     medc_stock.medc_mainstock  stk      where     stk.GenericName like  ?3%     and    stk.LocName=?1 and  stk.LocRefID=?2 and stk.Qty>0    ORDER BY     stk.BrandName  LIMIT 10 ", nativeQuery = true)
	List viewPdtNamesGeneric(int lcrnm, int lcrid, String name);

	@Query(value = "SELECT cu. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. SellingPrice,  stk. unitprice, stk.unitsgst, stk.unitcgst, stk.unitigst, stk.unitutgst,     stk.vat , stk. BoxPerStrip*stk. StripPerTablet ,stk. StripPerTablet,0  ,2 ,      stk.sellingprice1 , stk.sellingprice2 , stk.sellingprice3 , stk.sellingprice4 , db.batchno as batchnames ,Date(stk.ExpiryDate ) ,stk.FreeTotalQty,stk.StockID, stk.RetailerSellingPrice ,stk.WholeSellingprice,cu.subgroupid1,stk.unitgst,cu.hsnid,cu.hsnid as hsncode,stk.marginamt,stk.margin,stk.ageingtime  FROM  medc_stock.medc_mainstock stk   inner join  medc_productmaster.medc_custproductmaster cu on cu.productdrugid=stk.drugproductid left join  medc_stock.medc_drugbatch db on stk.batchno=db.batchid  where    stk.DrugProductID=?3   and  stk.Batchno=?4    and  stk.LocName=?1   and  stk.LocRefID=?2  and stk.Qty>0", nativeQuery = true)
	List viewProductName(int lcrnm, int lcrid, int productid, int batchid);

	@Query(value = " SELECT  stk. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. SellingPrice,     stk. MRP, stk.unitsgst, stk.unitcgst, stk.unitigst, stk.unitutgst,     stk.vat , pdt. BoxPerStrip*pdt. StripPerTablet ,pdt. StripPerTablet,0  ,4,       stk.sellingprice1 , stk.sellingprice2 , stk.sellingprice3 , stk.sellingprice4 , stk.batchname,     Date(stk.ExpiryDate ),stk.FreeTotalQty,stk.StockID,stk. RetailerSellingPrice ,stk.WholeSellingprice     FROM medc_productmaster.medc_barcodemapping  br  left join( SELECT brandname, DrugProductID,Batchno ,Qty, batchname   FROM medc_stock.medc_mainstock   where  LocName=?1 and LocRefID=?2  and Qty>0  ) stk   on  br.DrugProductID  =stk.DrugProductID   where   br.barcode=?3  and br.LocName=?1 and br.LocRefID=?2  order by  stk.Qty  limit 1", nativeQuery = true)
	List viewBarCodeProd(int lcrnm, int lcrid, String barcode);

	@Query(value = "  SELECT   IFNULL(  max( SalesBillID ) ,0 )  FROM   medc_sales.medc_salesmaintenance   where    SalesBillType='1' and  LocName=?1 and LocRefID=?2    ", nativeQuery = true)
	int viewSalesInvoiceId(Double lcrnm, Double lcrid);

	@Query(value = "  SELECT    IFNULL( RIGHT( salesbillno, 7 ),0 )    FROM   medc_sales.medc_salesmaintenance   where  SalesBillID=?3      and    LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	String viewSalesInvoiceIncNo(Double lcrnm, Double lcrid, int id);

	@Query(value = "SELECT si.SalesBillNo from medc_sales.medc_salesmaintenance  si  join ( SELECT   max( SalesBillID ) as maxid FROM   medc_sales.medc_salesmaintenance  where LocName=?1 and LocRefID=?2  )  sid  on  sid.maxid=si.SalesBillID  ", nativeQuery = true)
	String viewSalesInvoiceMaxNo(Double lcrnm, Double lcrid);


// Hide Ajith	
//	@Query(value = "SELECT  pm. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. SellingPrice,     stk. unitprice, stk.unitsgst, stk.unitcgst, stk.unitigst, stk.unitutgst,     stk.vat ,\r\n"
//			+ "stk. BoxPerStrip   *stk. StripPerTablet ,stk. StripPerTablet,0  ,2,stk.sellingprice1 , stk.sellingprice2 , stk.sellingprice3 , stk.sellingprice4 ,sp.TotalQty        ,\r\n"
//			+ "IFNULL(stk.consolQty,0)-IFNULL(stk.Qty,0)  as  sormainqty,stk.batchname ,Date(stk.ExpiryDate ),stk.FreeTotalQty,stk.StockID ,\r\n"
//			+ "stk.RetailerSellingPrice ,stk.WholeSellingprice ,stk.unitgst,stk.marginamt,stk.margin,stk.ageingtime FROM medc_sales.medc_salesordprd   sp\r\n"
//			+ "left join (SELECT     brandname,DrugProductID,Batchno,max(Qty)  as  Qty,sum(IFNULL(Qty,0))  as  consolQty , SellingPrice, mrp, unitprice,\r\n"
//			+ "unitsgst, unitcgst, unitigst, unitutgst,     vat ,  BoxPerStrip    , StripPerTablet,   sellingprice1 , sellingprice2 ,sellingprice3 , sellingprice4 ,\r\n"
//			+ "LocName,LocRefID,batchname,ExpiryDate ,FreeTotalQty,StockID ,RetailerSellingPrice , WholeSellingprice,unitgst,marginamt,margin,ageingtime    from   medc_stock.medc_mainstock\r\n"
//			+ "where  status =0 and LocName=?1 and  LocRefID=?2 group  by DrugProductID order by Qty asc  ) stk   on sp.DrugProductID=stk.DrugProductID\r\n"
//			+ "left join medc_productmaster.medc_custproductmaster pm on pm.productdrugid=sp.drugproductid\r\n"
//			+ "where sp.salesflag=0 and  sp.SalesOrderRefID=?3 and stk.qty>0", nativeQuery = true)
//	List viewSalesOrderProd(int lcrnm, int lcrid, int orderid);

	
	@Query(value = "SELECT pm. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. SellingPrice, stk. unitprice, stk.unitsgst, stk.unitcgst, stk.unitigst, stk.unitutgst,stk.vat ,(stk. BoxPerStrip*stk. StripPerTablet),stk. StripPerTablet,0  ,2,stk.sellingprice1 , stk.sellingprice2 , stk.sellingprice3 , stk.sellingprice4 ,sp.TotalQty, SUM(stk.Qty) as sormainqty,stk.batchname ,Date(stk.ExpiryDate ),stk.FreeTotalQty,sp.mainstockrefid,stk.RetailerSellingPrice ,stk.WholeSellingprice ,stk.unitgst,stk.marginamt,stk.margin,stk.ageingtime FROM medc_sales.medc_salesordprd   sp INNER JOIN  medc_stock.medc_mainstock stk ON stk.DrugProductID=sp.DrugProductID left join medc_productmaster.medc_custproductmaster pm on pm.productdrugid=sp.drugproductid where  stk.status =0 and stk.LocName=?1 and  stk.LocRefID=?2 and  sp.SalesOrderRefID=?3 and stk.StockID IN (SELECT MAX(stockid) FROM  medc_stock.medc_mainstock WHERE LocRefID=?2 and DrugProductID=sp.DrugProductID ORDER BY stockID DESC ) ORDER BY sp.SalesOrderPrdID,stk.StockID DESC", nativeQuery = true)
List viewSalesOrderProd(int lcrnm, int lcrid, int orderid);

	
	
	
	
	
	

	// Refill Products
	@Query(value = "SELECT  stk. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. SellingPrice,stk. unitprice, stk.unitsgst, stk.unitcgst,stk.unitigst, stk.unitutgst, stk.vat,\n"
			+ "stk. BoxPerStrip   *stk. StripPerTablet ,stk. StripPerTablet,0  ,2, stk.sellingprice1 ,stk.sellingprice2 , stk.sellingprice3 , stk.sellingprice4 ,sb.IndvQty ,\n"
			+ "IFNULL(stk.consolQty,0)-IFNULL(stk.Qty,0)  as  sormainqty,stk.batchname ,Date(stk.ExpiryDate ),stk.FreeTotalQty,stk.StockID, stk.RetailerSellingPrice ,stk.WholeSellingprice ,stk.unitgst FROM medc_sales.medc_salesbill   sb\n"
			+ "left join (SELECT     brandname,DrugProductID,Batchno,max(Qty)  as  Qty,sum(IFNULL(Qty,0))  as  consolQty , SellingPrice, mrp,unitprice, unitsgst, unitcgst, unitigst, unitutgst,vat ,  BoxPerStrip    , StripPerTablet,\n"
			+ "sellingprice1 , sellingprice2 ,sellingprice3 , sellingprice4 ,LocName,LocRefID,batchname,ExpiryDate ,FreeTotalQty,StockID ,RetailerSellingPrice ,WholeSellingprice,unitgst  from   medc_stock.medc_mainstock\n"
			+ "where  status =0 and LocName=?1 and  LocRefID=?2 group  by DrugProductID order by Qty asc) stk   on  sb.DrugProductID=stk.DrugProductID\n"
			+ "where sb.SalesRefID=?3 and stk.qty>0", nativeQuery = true)
	List viewRefillProd(int lcrnm, int lcrid, int orderid);

	@Query(value = "SELECT sm.SalesBillID, sm.SalesBillNo ,DATE(sm.ClientCDate ) ,sm.TotalDiscount,sm.TotalAmount,sm.TotalItems,sm.TaxableAmt,sm.TotalTaxAmt,sm.GrandTotal,sm.Status,sm.SalesBillType,sm.Salesorderrefid,sr.salesorderno,sm.customerrefid,concat(pi.patientfirstname,' ',pi.patientlastname) as patientname,pi.mobile,pi.email,sm.petname,sm.petbreed,sm.petcolor,sm.petspecies,(IFNULL(di.DoctorName,'No_Doctor')) as Doctor_Name,cust.BrandName,gm.GenericName,cust.GenericNameDosage FROM medc_sales.medc_salesmaintenance sm left join medc_sales.medc_salesorder sr on sr.orderid=sm.salesorderrefid left join medc_patientreg.medc_patientbasicinfo pi on pi.patientid=sm.customerrefid LEFT JOIN medc_doctorreg.doctorregistration di ON di.DoctorID=sm.DoctorRefID INNER JOIN medc_sales.medc_salesbill si ON si.SalesRefID=sm.SalesBillID LEFT JOIN medc_productmaster.medc_custproductmaster cust ON cust.ProductDrugID=si.DrugProductID LEFT JOIN medc_productmaster.medc_genericmaster gm ON gm.GenericID=cust.GenericID where sm.CompanyRefID =?1 and sm.BranchRefID=?2 and sm.LocName=?3 and sm.LocRefID=?4 order  by  sm.SalesBillID  desc", nativeQuery = true)
	List viewSalesInvoiceAll(int cid, int bid, int lname, int lrid);

	// paging all sales invoice view
	@Query(value = "SELECT   SalesBillID, SalesBillNo ,DATE( ClientCDate ) ,TotalDiscount,TotalAmount, TotalItems,TaxableAmt, TotalTaxAmt,GrandTotal  FROM medc_sales.medc_salesmaintenance   where  SalesBillType=1  and   LocName=?1 and LocRefID=?2  and   Status!=5     order  by  SalesBillID  desc \n#page\n", countQuery = "select count(salesbillid) FROM medc_sales.medc_salesmaintenance where SalesBillType=1  and   LocName=?1 and LocRefID=?2  and   Status!=5", nativeQuery = true)
	Page viewPagingSalesInvoiceAll(int lname, int lrid, Pageable page);

	@Query(value = "SELECT    si.salesbillid,si. salesbilltype,si. salesbillno,si. billdate,si. customerrefid,     si. doctorrefid,si. totalamount,si. totalitems,si.  totaldiscount, si. taxableamt,     si. totaltaxamt,si.  totalinclamt,si. totalexclamt,si.grandtotal,si. createdby      , si.prescpath, si.PaymentType,si.PtRefNo ,pt.PatientFirstName , si.ClientCDate1  as  cldate      	,DATE( si.ClientCDate1 )  ,si.custinvoiceno   FROM   medc_sales.medc_salesmaintenance  si	left  join   (  SELECT  PatientID, PatientFirstName   FROM   medc_patientreg.medc_patientbasicinfo  where  locrefid=?2  and  LocName=?1  )  pt  on si.customerrefid=pt.PatientID  where   si.SalesBillID= ?3  and  si.Status!=5 ", nativeQuery = true)
	List viewSalesInvoice(int lcrnm, int lcrid, int name);

	@Query(value = "SELECT * FROM medc_globalsettings.medc_pricemaster where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewPriceSettings(int lcrnm, int lcrid);

	@Query(value = "SELECT * FROM medc_globalsettings.medc_discountmaster  where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewDiscountSettings(int lcrnm, int lcrid);

	@Query(value = "SELECT   *  FROM medc_sales.medc_salesmaintenance     where   CustomerRefID =?3  and   LocName=?1 and LocRefID=?2  and SalesBillType='1'  and   Status!=5     ", nativeQuery = true)
	List viewSalesInvCustAll(int lcrnm, int lcrid, int id);

	@Query(value = "SELECT   *  FROM medc_sales.medc_salesmaintenance     where  CustomerRefID =?3    and   LocName=?1 and LocRefID=?2  and  SalesBillType='2' and   Status!=5 ", nativeQuery = true)
	List viewSalesDumCustAll(int lcrnm, int lcrid, int id);

	@Query(value = "SELECT stk. brandname,stk.DrugProductID,stk.Batchno,stk.Qty,stk. SellingPrice,    stk. MRP, stk.unitsgst, stk.unitcgst, stk.unitigst, stk.unitutgst,     stk.vat , pdt. Stripperbox* pdt. Quantityperstrip ,pdt. Quantityperstrip,gst.GstFlag  ,gst.FrGstFlag,       stk.sellingprice1 , stk.sellingprice2 , stk.sellingprice3 , stk.sellingprice4 ,stk.batchname    FROM  medc_stock.medc_mainstock stk 	left join ( SELECT BrandName,ProductDrugID,Stripperbox  ,Quantityperstrip    from medc_productmaster.medc_custproductmaster   where  ((LocName=?1 and  LocRefID=?2) || (companyID=?4))  )   pdt on stk.DrugProductID=pdt.ProductDrugID   	left join  ( SELECT  GstFlag,FrGstFlag ,LocRefID from medc_globalsettings.medc_gstsettings where  LocName=?1 and  LocRefID=?2   )  gst  on gst.LocRefID=stk.LocRefID     where    stk.DrugProductID=?3   and  stk.LocName=?1   and  stk.LocRefID=?2  order by stk.Qty  asc   limit 3   ", nativeQuery = true)
	List viewProductNameDrug(int lcrnm, int lcrid, int drg, Integer compid);

	@Query(value = "SELECT  sum( IFNULL( inv.GrandTotal ,0 )) -  IFNULL( jr.paidinvamt ,0 )  as 'balamt'     FROM medc_sales.medc_salesmaintenance   inv left join  (  SELECT   InvoiceNo,sum( IFNULL( DebitAmount ,0) ) as 'paidinvamt',personid  FROM medc_accounts.medc_journal  where   personid=?3  and  locrefid=?2  and  LocName=?1  and  persontype =1  ) jr	on  inv.CustomerRefID=jr.personid  where   inv.CustomerRefID= ?3      and    inv.LocName=?1 and  inv.LocRefID=?2  and SalesBillType =1   ", nativeQuery = true)
	List viewCustOutstandingTot(int lcrnm, int lcrid, int custid);

	@Query(value = "SELECT  GstFlag,FrGstFlag from medc_globalsettings.medc_gstsettings where  LocName=?1 and  LocRefID=?2  limit 1", nativeQuery = true)
	List viewTaxSettings(int lcrnm, int lcrid);

	@Query(value = "SELECT   SchemeID , scheme_name, scheme_start_date, scheme_end_date,min_amt_equivalent_point      ,equivalent_point, reward_type, cash_discount,min_reward_point  FROM medc_patientreg.medc_schemesandrewards   where      LocName=?1 and LocRefID=?2  and   scheme_start_date<?3  and     ?3<scheme_end_date   order  by  SchemeID  desc limit 1", nativeQuery = true)
	List viewScheme(int lcrnm, int lcrid, String date);

	@Query(value = "SELECT  scheme_start_date   FROM medc_patientreg.medc_schemesandrewards   where      LocName=?1 and LocRefID=?2  and   scheme_start_date<?3  and     ?3<scheme_end_date   order  by  SchemeID  desc limit 1", nativeQuery = true)
	String viewSchemeStartDate(int lcrnm, int lcrid, String date);

	@Query(value = "SELECT   sum(ifnull(GrandTotal ,0))   FROM medc_sales.medc_salesmaintenance   where      CustomerRefID=?3  and  locrefid=?2  and  LocName=?1  and    ClientCDate>?4  and SalesBillType=1  ", nativeQuery = true)
	Double viewCustAmt(int lcrnm, int lcrid, int custid, String date);

	@Query(value = "SELECT  PatientFirstName   FROM   medc_patientreg.medc_patientbasicinfo   where  PatientID=?1 ", nativeQuery = true)
	String viewCustName(Integer id);

	@Query(value = "update  medc_stock.medc_mainstock   set qty=IFNULL(qty,0)-?5  where   DrugProductID=?3  and   BatchRefID=?4  and LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	Double updateTempStockMain(int lcrnm, int lcrid, int drg, int batch, int qty);

	@Modifying
	@Transactional
	@Query(value = "update  medc_stock.medc_mainstock   set LogCurrentQty=IFNULL(qty,0),LogInterMedQty=0, qty=IFNULL(qty,0)-?5  where   DrugProductID=?3  and   Batchno=?4     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updateMainstockForSave(Double lcrnm, Double lcrid, Double drg, Double bth, Double qty);

	@Modifying
	@Transactional
	@Query(value = "update  medc_stock.medc_mainstock   set LogInterMedQty=IFNULL(qty,0), qty=IFNULL(qty,0)-?5  where   DrugProductID=?3  and   Batchno=?4     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updateMainstockForEdit(Double lcrnm, Double lcrid, Double drg, Double bth, Double qty);

	@Modifying
	@Transactional
	@Query(value = "update  medc_stock.medc_mainstock    stk    join ( SELECT  sum(totalqty) as   salestotqty ,DrugProductID ,BatchRefID   FROM medc_sales.medc_salesbill  where SalesRefID=?3 and LocName=?1 and LocRefID=?2   group  by DrugProductID ,BatchRefID) sd  on sd.DrugProductID=stk.DrugProductID  and    sd.BatchRefID=stk.Batchno   set  stk.LogCurrentQty=ifnull(stk.qty,0), stk.qty= ifnull(stk.qty,0)+ ifnull(sd.salestotqty,0)   where stk.LocName =?1 and stk.LocRefID=?2  ", nativeQuery = true)
	int updateMainstockEdit(Double lcrnm, Double lcrid, int sd);

	@Modifying
	@Transactional
	@Query(value = "update  medc_accounts.medc_sales   set  InvoiceAmt=?3  where   InvoiceNo=?4  and LocName=?1 and LocRefID=?2  and SalesFlag='0' ", nativeQuery = true)
	Integer updateSalesJouirnal(Double lcrnm, Double lcrid, Double amt, int salesid);

	@Modifying
	@Transactional
	@Query(value = "update  medc_sales.medc_salesmaintenance    set  perfomaflag=1      where     SalesBillID=?3   and  LocName=?1 and LocRefID=?2   ", nativeQuery = true)
	void updatePerfomaFlag(double lcrnm, double lcrid, int ind);

	@Modifying
	@Transactional
	@Query(value = "update medc_sales.medc_salesmaintenance     set   Status=5   where   SalesBillID=?3  and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteSalesInvoice(int lcrnm, int lcrid, int id);

	/** SALES INVOICE LIST **/
	// Boopalan 090419
	@Query(value = "SELECT SalesBillID, SalesBillNo FROM medc_sales.medc_salesmaintenance  WHERE Status=0 and CompanyRefID= :cid and BranchRefID= :bid and LocName= :locname and LocRefid= :locrefid", nativeQuery = true)
	List getSalesInvoiceList(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	/** SALES Order flag Update **/
	// Boopalan 250719
	@Modifying
	@Transactional
	@Query(value = "update medc_sales.medc_salesorder set salesinvoiceflag =1 where orderid =?1    ", nativeQuery = true)
	void updateSalesOrderFlag(int orderid);

	// Boopalan 200919 - For saving data medc_status.medc_salesordertrack
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_status.medc_salesordertrack (salesorderrefid, statusid, statusdate)VALUES (?1, ?2, ?3);", nativeQuery = true)
	Integer save_medc_salesordertrack(@Param("salesorderrefid") int salesorderrefid, @Param("statusid") int statusid,
			@Param("medc_salesordertrack_statusdate") String medc_salesordertrack_statusdate);

	// padmini
	@Modifying
	@Transactional
	@Query(value = "update  medc_sales.medc_salesordprd set salesflag=1  where   salesorderrefid=?3 and drugproductid=?4   and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	void updatesalesorderflag(double locname, double locrefid, int salesorderid, double drugid);

	@Modifying
	@Transactional
	@Query(value = "update medc_patientreg.medc_patientbasicinfo set refillcustomer=:refillcust, refilldays=:refilldays, previousbalance=:previosbalance, customertype=:customertype  where companyrefid =:companyrefid  and branchrefid =:branchrefid and locname =:locname and locrefid =:locrefid  and patientid=:patientid  ", nativeQuery = true)
	void updatecus(@Param("companyrefid") int companyrefid, @Param("branchrefid") int branchrefid,
			@Param("locname") double locname, @Param("locrefid") double locrefid,
			@Param("previosbalance") double previosbalance, @Param("patientid") double patientid,
			@Param("refillcust") int refillcust, @Param("refilldays") int refilldays,
			@Param("customertype") String customertype);

	@Query(value = "SELECT   PatientID, concat(PatientFirstName,'_',coalesce(mobile,'')) as patmobile,LoyaltyFlag ,scitizenflag,phycapflag    , scitizenno,phycapno,refillcustomer,previousbalance   FROM  medc_patientreg.medc_patientbasicinfo       where companyrefid=?1 and branchrefid=?2 and  LocName=?3 and LocRefID=?4  and (PatientFirstName like ?5%  or mobile like ?5%)  ", nativeQuery = true)
	List viewallcustomer(int compid, int branchid, int lcrnm, int lcrid, String searchvalue);

	@Query(value = " select distinct(so.orderid),so.salesorderno from medc_sales.medc_salesorder so\n"
			+ "inner join medc_patientreg.medc_patientbasicinfo pa on pa.patientid=so.patientid\n"
			+ "inner join medc_sales.medc_salesordprd sop on sop.salesorderrefid=so.orderid\n"
			+ "where pa.companyrefid=?1 and pa.branchrefid=?2 and pa.locname=?3 and pa.locrefid=?4  and pa.patientid=?5 and sop.salesflag=0 and so.status=0", nativeQuery = true)
	List viewcustsono(int compid, int branchid, int locname, int locrefid, int patientid);

	@Query(value = " SELECT  Distinct(so.OrderID),so.SalesOrderNo   FROM medc_sales.medc_salesorder so inner join medc_sales.medc_salesordprd sop on sop.salesorderrefid=so.orderid  where   sop.salesflag=0 and so.status=0 and  so.companyrefid=?1 and so.branchrefid=?2 and so.LocName=?3 and so.LocRefID=?4 ", nativeQuery = true)
	List viewAllSalesorders(int compid, int branchid, int lcrnm, int lcrid);

	@Query(value = "SELECT PatientID,concat(PatientFirstName,'_',coalesce(mobile,'')) as patmobile,email,LoyaltyFlag ,scitizenflag,phycapflag,scitizenno,\n"
			+ "phycapno,refillcustomer,previousbalance,ifnull(address1,'') address1,ifnull(address2,'') address2,ifnull(countryname,'NA') countryname,\n"
			+ "ifnull(statename,'NA') statename, ifnull(cityname,'NA') cityname, ifnull(pincode,'NA') pincode,ifnull(mobile,'NA') mobile,PatientFirstName,\n"
			+ "state,country,city,refilldays,creditdays,customertype FROM  medc_patientreg.medc_patientbasicinfo pi\n"
			+ "left join medc_fixedsettings.medc_country c on c.countryid=pi.country\n"
			+ "left join medc_fixedsettings.medc_city ci on ci.cityid=pi.city\n"
			+ "left join medc_fixedsettings.medc_state st on st.stateid=pi.state\n"
			+ "where companyrefid=?1 and branchrefid=?2 and  LocName=?3 and LocRefID=?4 and patientid=?5", nativeQuery = true)
	List getparticularcustomer(int compid, int branchid, int locname, int locrefid, int patientid);

	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_sales.medc_salesmaintenance sm,medc_sales.medc_salesbill sb SET sm.status='5',sb.status='5' WHERE sm.salesbillid =:id  and sb.salesrefid =:id", nativeQuery = true)
	void deleteslinvoice(@Param("id") int id);

	@Query(value = "SELECT  Distinct(so.PatientID) ,concat(pb.PatientFirstName,'_',coalesce(pb.mobile,'')) as patmobile,pb.mobile,pb.email,pb.LoyaltyFlag ,pb.scitizenflag,pb.phycapflag, pb.scitizenno,pb.phycapno,pb.refillcustomer,pb.previousbalance FROM medc_sales.medc_salesorder so\r\n"
			+ "			inner join medc_patientreg.medc_patientbasicinfo pb on pb.PatientID = so.PatientID\r\n"
			+ "      inner join medc_sales.medc_salesordprd sop on sop.salesorderrefid=so.orderid\r\n"
			+ "      where   sop.salesflag=0 and  so.companyrefid=:cid and so.branchrefid=:bid and so.LocName=:locname and so.LocRefID= :locrefid and so.orderid = :soid", nativeQuery = true)
	List viewsocustomerlist(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("soid") int soid);

	// credit notes
	@Query(value = "SELECT salesbillno from medc_sales.medc_salesmaintenance\n"
			+ "where companyrefid=?1 and locname=?2 and locrefid=?3 and salesbillid=?4", nativeQuery = true)
	String viewSInvMaxNo(Integer companyrefid, Double locname, Double locrefid, Integer invoiceno);

	@Query(value = "SELECT jr.journalid,jr.journalno,jr.invoiceno,jr.invoicename,jr.creditamount,jr.invoicebalamt FROM medc_accounts.medc_journal jr\r\n"
			+ "where locname=?1 and locrefid=?2 and personid=?3 and jrnltype=5 and SUBSTRING(invoicename,1, 3)='SIV' and invoicebalamt>0", nativeQuery = true)
	List GetPendingPaymentsList(int lcrnm, int lcrid, int name);

	@Query(value = "SELECT previousbalance FROM medc_patientreg.medc_patientbasicinfo where patientid=?1", nativeQuery = true)
	Double getcustpreviousbal(int frmint1);

	@Modifying
	@Transactional
	@Query(value = "update medc_patientreg.medc_patientbasicinfo set previousbalance=?2 where patientid=?1", nativeQuery = true)
	void UpdateCustBalance(Integer custid, double balance);

	@Query(value = "SELECT count(salesbillid) FROM medc_sales.medc_salesmaintenance\r\n"
			+ "where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4", nativeQuery = true)
	List GetSalesInvoicecount(Integer cid, Integer bid, Integer lname, Integer lrid);

	@Query(value = "SELECT journalid,invoiceno,debitamount,invoicename,journalno,personame,createddate FROM medc_accounts.medc_journal\r\n"
			+ "where personid=?2 and jrnltype=6 and locrefid=?1 and substring(invoicename, 1, 7)= 'SLS/RET' and debitamount>0", nativeQuery = true)
	List GetSReturnPaymentsList(Integer compid, Integer custid);
	// SIVAKUMAR - For converting sales order customers

	@Query(value = "select pi.patientid,concat(ifnull(pi.patientfirstname,' '),' ',ifnull(pi.patientlastname,' '),'- ',ifnull(pi.mobile,' ')) as\n"
			+ " patinetname,pi.email,pi.LoyaltyFlag,pi.scitizenflag,pi.phycapflag,pi.scitizenno,pi.phycapno,pi.refillcustomer,\n"
			+ " sm.previousbalance,ifnull(address1,'') address1, ifnull(address2,'') address2,ifnull(countryname,'NA') country,ifnull(statename,'NA') state,ifnull(cityname,'NA') city,ifnull(pincode,'NA')\n"
			+ "pincode,ifnull(mobile,'NA') mobile,PatientFirstName,so.salesorderno,so.OrderID from medc_sales.medc_salesorder so\n"
			+ "inner join medc_patientreg.medc_patientbasicinfo pi on pi.patientid=so.patientid\n"
			+ "inner join medc_sales.medc_salesmaintenance sm\n"
			+ " left join medc_fixedsettings.medc_country c on c.countryid=pi.country\n"
			+ " left join medc_fixedsettings.medc_city ci on ci.cityid=pi.city left join medc_fixedsettings.medc_state st\n"
			+ "  on st.stateid=pi.state where so.companyrefid=?1 and so.branchrefid=?2 and  so.LocName=?3 and so.LocRefID=?4 and so.orderid=?5\n"
			+ "   group by pi.patientid", nativeQuery = true)
	List convertsales(Integer cid, Integer bid, Integer lname, Integer lrid, Integer soid);

	// SIVAKUMAR to get Picking Employees
	@Query(value = " SELECT employeeid,concat(empfirstname,' ',emplastname) as name,employeecode,employeetype from medc_employee.medc_employeedetails where deptrefid=9 and companyid=?1 and branchid=?2 and\r\n"
			+ "locname=?3 and locrefid=?4 ", nativeQuery = true)
	List getPickingEmployees(Integer integer, Integer integer2, Double double1, Double double2);

	// SIVAKUMAR- X-Reading Over view
	@Query(value = "SELECT  billdate,"
			+ "( select ifnull(sum(grandtotal),0) FROM medc_sales.medc_salesmaintenance where billdate = ?1 and companyrefid=?2 and branchrefid=?3 and locname=?4 and locrefid=?5) as todaysales,"
			+ "( select ifnull(sum(grandtotal),0) FROM medc_sales.medc_salesmaintenance where billdate < ?1 and companyrefid=?2 and branchrefid=?3 and locname=?4 and locrefid=?5) as beginingsales,"
			+ "ifnull(min(sm.salesbillno),'NA') as start_sinumber,ifnull(max(sm.salesbillno),'NA') as end_sinumber,( select ifnull(sum(grandtotal),0) FROM medc_sales.medc_salesmaintenance where billdate = ?1 and companyrefid=?2 and branchrefid=?3 and locname=?4 and locrefid=?5) cashamt,"
			+ "ifnull(sum(sm.cardamt),0) cardamt,"
			+ "( select count(salesbillid) FROM medc_sales.medc_salesmaintenance where billdate=?1 and companyrefid=?2 and branchrefid=?3 and locname=?4 and locrefid=?5) as totalbillcount	"
			+ "FROM medc_sales.medc_salesmaintenance sm "
			+ "inner join medc_sales.medc_salesbill sb on sb.salesrefid=sm.salesbillid "
			+ "where billdate=?1 and sm.companyrefid=?2 and sm.branchrefid=?3 and sm.locname=?4 and sm.locrefid=?5 ", nativeQuery = true)
	List xReadOverView(String date, Integer companyrefid, Integer branchrefid, int locname, int locrefid);

	// SIVAKUMAR -X-Reading sales bills details
	@Query(value = "select sm.billdate,salesbillno,TIME_FORMAT(sm.createddate, \"%r\") invoicetime,concat(empfirstname,' ',emplastname) empname,sm.totalitems,sm.totalqty,sm.taxableamt,sm.totaltaxamt as '12%vat',\r\n"
			+ "sm.totaldiscount,sum(sb.subtotal) as subtotal,sm.grandtotal\r\n"
			+ ",salesbillid,ifnull(sm.cardamt,0) cardamt\r\n" + "from medc_sales.medc_salesmaintenance sm\r\n"
			+ "inner join medc_sales.medc_salesbill sb on sb.salesrefid=sm.salesbillid\r\n"
			+ "inner join medc_employee.medc_employeedetails emp on emp.employeeid=sm.employeerefid\r\n"
			+ "where billdate=?1 and\r\n"
			+ " sm.companyrefid=?2 and sm.branchrefid=?3 and sm.locname=?4 and sm.locrefid=?5\r\n"
			+ " and sb.salesrefid=sm.salesbillid group by salesbillno", nativeQuery = true)
	List xReadSalesDetails(String billdate, Integer companyrefid, Integer branchrefid, int locname, int locrefid);

	// SIVAKUMAR- Z-Reading Over view
	@Query(value = "SELECT min(billdate) fromdate,\r\n"
			+ "( select ifnull(sum(grandtotal),0) FROM medc_sales.medc_salesmaintenance where billdate = ?2 and companyrefid=?3 and branchrefid=?4 and locname=?5 and locrefid=?6) as todaysales,\r\n"
			+ "( select ifnull(sum(grandtotal),0) FROM medc_sales.medc_salesmaintenance where billdate < ?1 and companyrefid=?3 and branchrefid=?4 and locname=?5 and locrefid=?6) as beginingsales,\r\n"
			+ "ifnull(min(sm.salesbillno),'NA') as start_sinumber,ifnull(max(sm.salesbillno),'NA') as end_sinumber,\r\n"
			+ "( select ifnull(sum(grandtotal),0) FROM medc_sales.medc_salesmaintenance where billdate between ?1 and ?2  and companyrefid=?3 and branchrefid=?4 and locname=?5 and locrefid=?6) cashamt,\r\n"
			+ "ifnull(sum(sm.cardamt),0) cardamt,\r\n"
			+ "( select count(salesbillid) FROM medc_sales.medc_salesmaintenance where billdate between ?1 and ?2 and companyrefid=?3 and branchrefid=?4 and locname=?5 and locrefid=?6) as totalbillcount,max(billdate) todate	\r\n"
			+ "FROM medc_sales.medc_salesmaintenance sm\r\n"
			+ "inner join medc_sales.medc_salesbill sb on sb.salesrefid=sm.salesbillid\r\n"
			+ "where billdate between ?1 and ?2 and sm.companyrefid=?3 and sm.branchrefid=?4 and sm.locname=?5 and sm.locrefid=?6\r\n"
			+ " ", nativeQuery = true)
	List zReadOverView(String fromdate, String todate, Integer companyrefid, Integer branchrefid, int locname,
			int locrefid);

	// SIVAKUMAR -Z-Reading sales bills details
	@Query(value = "select sm.billdate,salesbillno,TIME_FORMAT(sm.createddate, \"%r\") invoicetime,concat(empfirstname,' ',emplastname) empname,sm.totalitems,sm.totalqty,sm.taxableamt,sm.totaltaxamt as '12%vat',\r\n"
			+ "sm.totaldiscount,sum(sb.subtotal) as subtotal,sm.grandtotal\r\n"
			+ ",salesbillid,ifnull(sm.cardamt,0) cardamt\r\n" + "from medc_sales.medc_salesmaintenance sm\r\n"
			+ "inner join medc_sales.medc_salesbill sb on sb.salesrefid=sm.salesbillid\r\n"
			+ "inner join medc_employee.medc_employeedetails emp on emp.employeeid=sm.employeerefid\r\n"
			+ "where billdate between ?1 and ?2 and\r\n"
			+ " sm.companyrefid=?3 and sm.branchrefid=?4 and sm.locname=?5 and sm.locrefid=?6\r\n"
			+ " and sb.salesrefid=sm.salesbillid group by salesbillno", nativeQuery = true)
	List zReadSalesDetails(String fromdate, String todate, Integer companyrefid, Integer branchrefid, int locname,
			int locrefid);

	@Query(value = "SELECT  IFNULL(count(sm.salesbillid),0) sid FROM medc_sales.medc_salesmaintenance sm  where sm.locrefid=?1", nativeQuery = true)
	Integer lastbillid(Integer locrefid);

	@Query(value = "SELECT drugproductid,batchrefid,indvqty,companyrefid,locrefid FROM medc_sales.medc_salesbill where salesrefid=?1", nativeQuery = true)
	List<Object[]> getproductandbatch(Integer id);

	@Query(value = "SELECT sm.SalesBillID, sm.SalesBillNo ,DATE(sm.ClientCDate ) ,sm.TotalDiscount,sm.TotalAmount,sm.TotalItems,sm.TaxableAmt,sm.TotalTaxAmt,sm.GrandTotal,sm.Status,sm.SalesBillType,sm.Salesorderrefid,sr.salesorderno,sm.customerrefid,concat(pi.patientfirstname,' ',pi.patientlastname) as patientname,pi.mobile,pi.email,sm.petname,sm.petbreed,sm.petcolor,sm.petspecies,(IFNULL(di.DoctorName,'No_Doctor')) as Doctor_Name,cust.BrandName,gm.GenericName,cust.GenericNameDosage,sh.ShopName,(sh.Address1) as shopaddress,sh.OwnerName,(pi.Address1),min.ExpiryDate as patientaddress FROM medc_sales.medc_salesmaintenance sm left join medc_sales.medc_salesorder sr on sr.orderid=sm.salesorderrefid left join medc_patientreg.medc_patientbasicinfo pi on pi.patientid=sm.customerrefid LEFT JOIN medc_doctorreg.doctorregistration di ON di.DoctorID=sm.DoctorRefID INNER JOIN medc_sales.medc_salesbill si ON si.SalesRefID=sm.SalesBillID LEFT JOIN medc_productmaster.medc_custproductmaster cust ON cust.ProductDrugID=si.DrugProductID LEFT JOIN medc_productmaster.medc_genericmaster gm ON gm.GenericID=cust.GenericID LEFT JOIN medc_storereg.medc_shopinformation sh on sh.ShopID=sm.LocRefID LEFT JOIN medc_stock.medc_mainstock min ON min.DrugProductID=cust.ProductDrugID and min.LocRefID=sm.LocRefID where sm.CompanyRefID =?1 and sm.BranchRefID=?2 and sm.LocName=?3 and sm.LocRefID=?4 and sm.SalesBillID=?5 order  by  sm.SalesBillID  desc", nativeQuery = true)
	List viewSalesInvoiceIdBased(Integer cid, Integer bid, Integer lname, Integer lrid, Integer sid);

}
