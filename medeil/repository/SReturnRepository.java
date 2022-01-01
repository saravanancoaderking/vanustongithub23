package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.SalesReturn;

@Repository
public interface SReturnRepository extends JpaRepository<SalesReturn, Long> {

	SalesReturn save(SalesReturn pr);

	@Transactional
	@Modifying
	@Query(value = " insert into  medc_stock.medc_stocklog( StockID,BrandName,  CurrentQty, ChangedQty, FinalQty,LocName, LocRefID, InvoiceNo,InvoiceType )  select  stockid,BrandName, LogCurrentQty ,LogInterMedQty,qty ,locname,locrefid,?5,2  from  medc_stock.medc_mainstock  where   DrugProductID=?3  and   Batchno=?4     and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int saveStockLogs(Double lcrnm, Double lcrid, Double drg, Double batch, int invoiceno);

	@Query(value = " SELECT SalesBillID,SalesBillNo  FROM medc_sales.medc_salesmaintenance     where  LocName=?1 and LocRefID=?2  and   Status!=5  order by SalesBillID desc", nativeQuery = true)
	List viewSalesInvoiceNo(int lcrnm, int lcrid);

	@Query(value = "SELECT si.salesbillid,si. salesbilltype,si. salesbillno,si. billdate,si. customerrefid, si. doctorrefid,si. totalamount,si. totalitems,si. totalqty,si.  totaldiscount,si. taxableamt,si. totaltaxamt,\r\n" + 
			"si.  totalinclamt,si. totalexclamt,si.grandtotal,si. createdby,si.  locname,si. LocRefID  , pt.PatientFirstName, pt.country , pt.state, pt.city FROM   medc_sales.medc_salesmaintenance  si\r\n" + 
			"left  join  medc_patientreg.medc_patientbasicinfo pt	on si.customerrefid=pt.PatientID where si.SalesBillID=?3  and  si.LocName=?1   and  si.LocRefID=?2", nativeQuery = true)
	List viewSalesInvoice(int lcrnm, int lcrid, int name);

	@Query(value = "SELECT  pm.BrandName,sip. salesrefid,sip. drugproductid,sip. batchrefid ,0,sip. unitprice,sip. mrp ,sip. expirydate,sip. unitdiscount,sip. unitvat,\r\n" + 
			"sip. unitsgst,sip. unitcgst,sip. unitigst, sip. discountamt,sip. vatamt,sip. sgstamt,sip. cgstamt,sip. igstamt ,sip. subtotal, sip.drgtyp  ,\r\n" + 
			"sip.gstflag  ,sip.frgstflag , sip.convfactor, IFNULL( sip.TotalQty,0 )  - IFNULL(  srp.srtotqty ,0 )   as  'crntsiqty',  ws.Qty  as 'crntstkqty' ,\r\n" + 
			"sip. salesrefid   as 'slsrefid' ,IFNULL( sip.indvqty,0 )  - IFNULL( srp.srtotqty ,0 )   as  'siqty' , db.batchno as batchnames,sip.stkmainrefid , sip.SalesPrdtID,\r\n" + 
			"sip.unitutgst,sip.utgstamt, sip.unitgst,sip.gstamt,IFNULL( sip.indvqty,0 ),IFNULL( srp.srtotqty ,0 ) FROM  medc_sales.medc_salesbill  sip\r\n" +
			"left join medc_stock.medc_drugbatch db on sip.batchrefid=db.batchid\r\n" +
			"left join ( SELECT DrugProductID,BatchRefID ,SiRefid , IFNULL( sum( TotalQty ),0 )  as  srtotqty,DrgTyp ,siprodrefid\r\n" + 
			"from medc_salesreturn.medc_srproduct where  LocName=?1 and  LocRefID=?2  group  by   siprodrefid  )  srp on   sip.SalesPrdtID=srp.siprodrefid\r\n" + 
			"left join  ( SELECT BrandName,DrugProductID,BatchNo,Qty,batchname  ,StockID  from medc_stock.medc_mainstock\r\n" + 
			"where  LocName=?1 and  LocRefID=?2) ws on   sip.stkmainrefid=ws.StockID\r\n" + 
			"left join medc_productmaster.medc_custproductmaster pm on pm.productdrugid=sip. drugproductid\r\n" + 
			"where sip.SalesRefID =?3 and sip.Status!=5   group by    sip.SalesPrdtID;", nativeQuery = true)
	List viewSIProduct(int lcrnm, int lcrid, int name);

	@Query(value = "  SELECT    coalesce(max( SRID ),0)   FROM medc_salesreturn.medc_dirsalesreturn    where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	Integer viewSRetnId(Double lcrnm, Double lcrid);

	@Query(value = " SELECT    IFNULL( RIGHT( srno, 7 ),0 )   FROM   medc_salesreturn.medc_dirsalesreturn    where    SRID=?3    and    LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewSRetnIncNo(Double lcrnm, Double lcrid, int id);

	@Query(value = "SELECT sr.srno from   medc_salesreturn.medc_dirsalesreturn  sr  join ( SELECT   max( SRID ) as maxid FROM   medc_salesreturn.medc_dirsalesreturn  where   LocName=?1 and LocRefID=?2  )  srd  on  srd.maxid=sr.SRID  ", nativeQuery = true)
	String viewSRetnMaxNo(Double lcrnm, Double lcrid);

	@Query(value = "SELECT sr.srid,sr. srno,DATE( sr.ClientCDate1 ),sr.TotalAmount, sr.TotalItems,sr.TaxableAmt,sr.TotalTaxAmt,sr.GrandTotal,\r\n" + 
			"si.salesbillno,pi.patientfirstname,pi.mobile,pi.email,sr.invoiceno,sr.customerrefid,sr.Status\r\n" + 
			"FROM medc_salesreturn.medc_dirsalesreturn sr\r\n" + 
			"LEFT JOIN medc_sales.medc_salesmaintenance si on si.salesbillid=sr.invoiceno\r\n" + 
			"LEFT JOIN medc_patientreg.medc_patientbasicinfo pi on pi.patientid=sr.customerrefid\r\n" + 
			"where  sr.LocName=?1 and sr.LocRefID=?2 and sr.Status!=5 order  by sr.srid  desc", nativeQuery = true)
	List viewSalesReturnAll(int lcrnm, int lcrid);

	@Query(value = " 	SELECT   si.srid,si. srno ,DATE( si.ClientCDate1 ),si. invoiceno,si. customerrefid,      si. doctorrefid,si. totalamount,si. totalitems ,si.  totaldiscount,si. taxableamt     ,si. totaltaxamt,si.  totalinclamt,si. totalexclamt,si.grandtotal ,si. createdby       , pt.patientfirstname , si.ClientCDate1  as  cldate   	FROM    medc_salesreturn.medc_dirsalesreturn  si 	left  join   (  SELECT  PatientID, PatientFirstName FROM medc_patientreg.medc_patientbasicinfo   where  locrefid=?2  and  LocName=?1  )  pt	on si.customerrefid=pt.PatientID   where   si.srid= ?3   ", nativeQuery = true)
	List viewSalesReturn(int lcrnm, int lcrid, int name);

	@Query(value ="SELECT pm.brandname,srp.srproductid,srp. srrefid,srp.drugproductid,db.batchno,srp.siqty,srp. totalqty,srp.indvqty,\r\n" + 
			"srp. unitprice ,srp. subtotal FROM medc_salesreturn.medc_srproduct  srp\r\n" + 
			"left join medc_productmaster.medc_custproductmaster pm on pm.productdrugid=srp.drugproductid\r\n" + 
			"left join medc_stock.medc_drugbatch db on srp.batchrefid=db.batchid\r\n" +
			"where  srp.SRRefID =?1  and  srp.Status!=5", nativeQuery = true)
	List viewSalesReturnProducts(int lcrnm);
	
	@Query(value = "   SELECT   ws.BrandName , srp.srproductid,srp. srrefid,srp. drugproductid,         srp. batchrefid ,srp. totalqty, srp. unitprice ,srp. mrp ,srp. expirydate,     srp. unitdiscount, srp. unitvat,srp. unitsgst,srp. unitcgst,srp. unitigst,         srp. discountamt,srp. vatamt ,srp. sgstamt,srp. cgstamt,srp. igstamt,          srp. subtotal ,srp.drgtyp ,srp.gstflag ,srp.frgstflag ,srp.indvqty ,            srp.convfactor,IFNULL( sip.TotalQty,0 ) -  IFNULL(srp2.totqty,0 ) + IFNULL( srp.TotalQty,0 )   as    crntsiqty  ,ws.Qty+srp.TotalQty  as 'crntstkqty' ,srp. sirefid  as 'slsrefid' ,srp. siqty       ,srp.ClientCDate1  as  cldate, srp.batchname  ,srp.stkmainrefid ,srp.siprodrefid    FROM medc_salesreturn.medc_srproduct  srp  left join   ( SELECT DrugProductID,BatchRefID ,SalesRefID,TotalQty ,SalesPrdtID   from medc_sales.medc_salesbill  where  LocName=?1 and  LocRefID=?2  ) sip on   srp.siprodrefid= sip.SalesPrdtID    left join     ( SELECT DrugProductID,BatchRefID ,SiRefid ,sum(TotalQty)  as totqty,siprodrefid from medc_salesreturn.medc_srproduct  where  LocName=?1 and  LocRefID=?2  group  by  siprodrefid  )    srp2  on   srp.siprodrefid=srp2.siprodrefid    left join   ( SELECT BrandName,DrugProductID,BatchNo,Qty,stockid     from  medc_stock.medc_mainstock  where  LocName=?1 and  LocRefID=?2 )  ws on  ws.stockid=srp.stkmainrefid    where     srp.SRRefID = ?3   and  srp.Status!=5  group   by    srp.SRProductID  ", nativeQuery = true)
	List viewSrProduct(int lcrnm, int lcrid, int name);

	@Query(value = "  SELECT  ws.BrandName,sip. salesrefid,sip. drugproductid,       sip. batchrefid  ,sip. unitprice,sip. mrp,0 ,sip. expirydate,      sip. unitdiscount,sip. unitvat,sip. unitsgst,sip. unitcgst,sip. unitigst,       sip. discountamt,sip. vatamt,sip. sgstamt,sip. cgstamt,sip. igstamt        ,sip. subtotal, sip.drgtyp  ,sip.gstflag  ,sip.frgstflag , sip.convfactor      ,IFNULL( sip.TotalQty,0 )  - IFNULL(  srp.srtotqty ,0 )   as  'crntsiqty'  ,  ws.Qty  as 'crntstkqty' ,sip. salesrefid  as  'slsrefid' ,IFNULL( sip.TotalQty,0 )  - IFNULL( srp.srtotqty ,0 )   as  'siqty'   ,sip.ClientCDate1  as  cldate  , sip.batchname    ,sip.stkmainrefid ,sip.SalesPrdtID    FROM  medc_sales.medc_salesbill  sip  left join ( SELECT DrugProductID,BatchRefID ,SiRefid , IFNULL( sum( TotalQty ),0 )  as  srtotqty ,DrgTyp,TotalQty,siprodrefid    from medc_salesreturn.medc_srproduct  where  LocName=?1 and  LocRefID=?2  group  by  siprodrefid  )  srp on    sip.SalesPrdtID=srp.siprodrefid   left join  ( SELECT BrandName,DrugProductID,BatchNo,Qty,batchname ,StockID   from  medc_stock.medc_mainstock  where  LocName=?1 and  LocRefID=?2 ) ws on  sip.stkmainrefid=ws.StockID where sip.SalesRefID =?3   and   sip.Status!=5  group by    sip.SalesPrdtID ", nativeQuery = true)
	List viewSrProductRemain(int lcrnm, int lcrid, int name);

	@Query(value = " SELECT  PatientFirstName   FROM   medc_patientreg.medc_patientbasicinfo   where  PatientID=?1 ", nativeQuery = true)
	String viewCustName(Integer id);

	@Modifying
	@Transactional
	@Query(value = " update  medc_accounts.medc_sales   set  InvoiceAmt=?3  where   InvoiceNo=?4  and LocName=?1 and LocRefID=?2 and SalesFlag='1' ", nativeQuery = true)
	Integer updateSalesJouirnal(Double lcrnm, Double lcrid, Double amt, int salesid);

	@Query(value = "SELECT drugproductid,batchrefid,indvqty,companyrefid,locrefid FROM medc_salesreturn.medc_srproduct where srrefid=?1", nativeQuery = true)
	List<Object[]> getproductandbatch(int frmint1);

	@Modifying
	@Transactional
	@Query(value = "delete from medc_salesreturn.medc_dirsalesreturn where srid=?3 and LocName=?1 and LocRefID=?2", nativeQuery = true)
	int deleteSalesRetn(int lcrnm, int lcrid, int id);

	@Modifying
	@Transactional
	@Query(value = "delete from medc_accounts.medc_journal where invoiceno=?3 and LocName=?1 and LocRefID=?2 and jrnltype=6", nativeQuery = true)
	void deleteJournal(int locname, int locrefid, int frmint1);
	
}
