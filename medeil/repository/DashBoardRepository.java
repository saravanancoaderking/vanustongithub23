package com.medeil.repository;

/**
 * @author Boopalan Alagesan
 *
 */
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Branch;

@SuppressWarnings("rawtypes")
@Repository
public interface DashBoardRepository extends JpaRepository<Branch, Long> {

	@Query(value = "SELECT count(*) FROM medc_purchase.medc_purchaseinvoice where companyrefid=:compid and branchrefid=:branchid and locname=:locname and locrefid=:locrefid ", nativeQuery = true)
	List getPurchaseValue(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "select sum(salm.GrandTotal)  From medc_sales.medc_salesmaintenance salm where salm.CompanyRefID=:compid and salm.BranchRefID=:branchid and salm.Locname = :locname and salm.Locrefid = :locrefid and date(salm.ClientCDate)=:clientcdate1", nativeQuery = true)
	List getsaleschart(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("clientcdate1") String clientcdate1);

	@Query(value = "select sum(pip.itemamt)  From medc_purchase.medc_purchaseinvoice pip where pip.CompanyRefID=:compid and pip.BranchRefID=:branchid and pip.Locname = :locname and pip.Locrefid = :locrefid and date(pip.ClientCDate)=:clientcdate1", nativeQuery = true)
	List getpurchasechart(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("clientcdate1") String clientcdate1);

	@Query(value = "SELECT count(mn.SOType)as SMS,(SELECT count(m.SOType) FROM medc_sales.medc_salesorder m where m.SOType=4 and m.CompanyRefID =:compid and m.BranchRefID=:branchid and m.LocName=:locname and m.LocRefID=:locrefid) as E_mail,"
			+ "(SELECT count(mi.SOType) FROM medc_sales.medc_salesorder mi where mi.SOType=3 and mi.CompanyRefID =:compid and mi.BranchRefID=:branchid and mi.LocName=:locname and mi.LocRefID=:locrefid) as Whatsapp"
			+ ",(SELECT count(mo.SOType) FROM medc_sales.medc_salesorder mo where mo.SOType=2 and mo.CompanyRefID =:compid and mo.BranchRefID=:branchid and mo.LocName=:locname and mo.LocRefID=:locrefid)as Telephone"
			+ ",(SELECT count(mp.SOType) FROM medc_sales.medc_salesorder mp where mp.SOType=1 and mp.CompanyRefID =:compid and mp.BranchRefID=:branchid and mp.LocName=:locname and mp.LocRefID=:locrefid)as Online_Pharmacy"
			+ " FROM medc_sales.medc_salesorder mn where mn.SOType=5 and mn.CompanyRefID =:compid and mn.BranchRefID=:branchid and mn.LocName=:locname and mn.LocRefID=:locrefid", nativeQuery = true)
	List getsalesordertype(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT sm.salesbillno,DATE_FORMAT(sm.clientcdate,'%d/%m/%Y'),sum(sb.indvqty),round(sm.grandtotal,2) AS totalamount,pi.patientfirstname from medc_sales.medc_salesmaintenance sm"
			+ " inner join medc_sales.medc_salesbill sb on sb.salesrefid=sm.salesbillid"
			+ " left join medc_patientreg.medc_patientbasicinfo pi on pi.patientid=sm.customerrefid   where  sm.CompanyRefID =:compid and sm.BranchRefID=:branchid and sm.LocName=:locname and sm.LocRefID=:locrefid and sm.status=0 and sm.salesbilltype=1 group by sm.salesbillno  order by sm.salesbillid desc limit 4", nativeQuery = true)
	List SIDBoard(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);
	
	@Query(value = "SELECT m.drugproductid,m.brandname,m.expirydate,m.minqty,m.qty from medc_stock.medc_mainstock m    where  m.CompanyRefID =:compid and m.BranchRefID=:branchid and m.LocName=:locname and m.LocRefID=:locrefid and m.qty<m.minqty limit 4", nativeQuery = true)
	List getminimunstock(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);
	
	@Query(value = "SELECT m.drugproductid,m.brandname,m.expirydate,m.minqty,m.qty from medc_stock.medc_mainstock m    where  m.CompanyRefID =:compid and m.BranchRefID=:branchid and m.LocName=:locname and m.LocRefID=:locrefid and m.qty<m.minqty limit 4", nativeQuery = true)
	List getsalesdatas(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);
	
	//Dashboard by Puthiran
	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE()) year, IFNULL(sum(GrandTotal),0) as Daytotal FROM medc_sales.medc_salesmaintenance\r\n" + 
			"WHERE Date(clientcdate) = Date(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneDaySaleTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE()) year, IFNULL(sum(GrandTotal),0) as Weektotal FROM medc_sales.medc_salesmaintenance\r\n" + 
			"WHERE Week(clientcdate) = Week(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneWeekSaleTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE())year, IFNULL(sum(GrandTotal),0) as Monthtotal FROM medc_sales.medc_salesmaintenance\r\n" + 
			"WHERE Month(clientcdate) = Month(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneMonthSaleTotal(Integer cid, Integer bid, Integer lname, Integer lrid);
	
	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE())year, IFNULL(sum(GrandTotal),0) as Yeartotal FROM medc_sales.medc_salesmaintenance\r\n" + 
			"WHERE Year(clientcdate) = Year(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneYearSaleTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE())year, IFNULL(sum(GrandTotal),0) as Grandtotal FROM medc_sales.medc_salesmaintenance\r\n" + 
			"WHERE CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneGrandSaleTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value = "SELECT sb.DrugProductID,pm.BrandName,pm.Generic_Name,pm.Manufacturer,IFNULL(sum(sb.SubTotal),0) as Total FROM medc_sales.medc_salesbill sb\r\n" + 
			"INNER JOIN medc_productmaster.medc_custproductmaster pm on pm.ProductDrugID=SB.DrugProductID\r\n" + 
			"WHERE sb.CompanyRefID=?1  and  sb.BranchRefID=?2 and sb.LocName=?3  and   sb.LocRefID=?4 Group By DrugProductID Order By sum(sb.subtotal) desc",nativeQuery = true)
	List getsalesdatasbyproductwise(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE()) year, IFNULL(sum(ItemAmt),0) as Daytotal FROM medc_purchase.medc_purchaseinvoice\r\n" + 
			"WHERE Date(clientcdate) = Date(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneDayPurchaseTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE()) year, IFNULL(sum(ItemAmt),0) as Weektotal FROM medc_purchase.medc_purchaseinvoice\r\n" + 
			"WHERE Week(clientcdate) = Week(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneWeekPurchaseTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE())year, IFNULL(sum(ItemAmt),0) as Monthtotal FROM medc_purchase.medc_purchaseinvoice\r\n" + 
			"WHERE Month(clientcdate) = Month(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneMonthPurchaseTotal(Integer cid, Integer bid, Integer lname, Integer lrid);
	
	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE())year, IFNULL(sum(ItemAmt),0) as Yeartotal FROM medc_purchase.medc_purchaseinvoice\r\n" + 
			"WHERE Year(clientcdate) = Year(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneYearPurchaseTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT DATE(CURRENT_DATE) date, DAYNAME(CURRENT_DATE()) day, MONTHNAME(CURRENT_DATE()) month, YEAR(CURRENT_DATE())year, IFNULL(sum(ItemAmt),0) as Grandtotal FROM medc_purchase.medc_purchaseinvoice\r\n" + 
			"WHERE CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4",nativeQuery = true)
	Object ViewoneGrandPurchaseTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT pi.PINO,pi.VendorID,IFNULL(sum(pi.ItemAmt),0) as Total,di.DistributorName FROM medc_purchase.medc_purchaseinvoice pi \r\n" + 
			"INNER JOIN medc_distributor.medc_distributorinformation di on di.DistributorID=pi.VendorID\r\n" + 
			"WHERE pi.CompanyRefID=?1 and pi.BranchRefID=?2 and pi.LocName=?3 and pi.LocRefID=?4 Group By pi.VendorID Order By sum(pi.ItemAmt) desc",nativeQuery = true)
	List getdistributorwisepurchasedatas(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	//Puthiran Cust Total Counts
	@Query(value ="SELECT count(p.patientid) FROM medc_patientreg.medc_patientbasicinfo p WHERE Date(CreatedDate) = Date(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4", nativeQuery=true)
	Object ViewoneDayCustTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT count(p.patientid) FROM medc_patientreg.medc_patientbasicinfo p WHERE Week(CreatedDate) = Week(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4", nativeQuery=true)
	Object ViewoneWeekCustTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT count(p.patientid) FROM medc_patientreg.medc_patientbasicinfo p WHERE Month(CreatedDate) = Month(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4", nativeQuery=true)
	Object ViewoneMonthCustTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT count(p.patientid) FROM medc_patientreg.medc_patientbasicinfo p WHERE Year(CreatedDate) = Year(CURRENT_DATE) and CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4", nativeQuery=true)
	Object ViewoneYearCustTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT count(p.patientid) FROM medc_patientreg.medc_patientbasicinfo p WHERE CompanyRefID=?1  and  BranchRefID=?2 and LocName=?3  and   LocRefID=?4", nativeQuery=true)
	Object ViewoneGrandCustTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	//Puthiran Product Total Counts
	@Query(value ="SELECT count(pr.productdrugid) FROM medc_productmaster.medc_custproductmaster pr WHERE Date(CreatedDate) = Date(CURRENT_DATE) and pr.CompanyID=?1  and  pr.BranchID=?2 and pr.LocName=?3  and pr.LocRefID=?4", nativeQuery=true)
	Object ViewoneDayProductTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value ="SELECT count(pr.productdrugid) FROM medc_productmaster.medc_custproductmaster pr WHERE Week(CreatedDate) = Week(CURRENT_DATE) and pr.CompanyID=?1  and  pr.BranchID=?2 and pr.LocName=?3  and pr.LocRefID=?4", nativeQuery=true)
	Object ViewoneWeekProductTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value ="SELECT count(pr.productdrugid) FROM medc_productmaster.medc_custproductmaster pr WHERE Month(CreatedDate) = Month(CURRENT_DATE) and pr.CompanyID=?1  and  pr.BranchID=?2 and pr.LocName=?3  and pr.LocRefID=?4", nativeQuery=true)
	Object ViewoneMonthProductTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value ="SELECT count(pr.productdrugid) FROM medc_productmaster.medc_custproductmaster pr WHERE Year(CreatedDate) = Year(CURRENT_DATE) and pr.CompanyID=?1  and  pr.BranchID=?2 and pr.LocName=?3  and pr.LocRefID=?4", nativeQuery=true)
	Object ViewoneYearProductTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value ="SELECT count(pr.productdrugid) FROM medc_productmaster.medc_custproductmaster pr WHERE pr.CompanyID=?1  and  pr.BranchID=?2 and pr.LocName=?3  and pr.LocRefID=?4", nativeQuery=true)
	Object ViewoneGrandProductTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	//Puthiran stock total counts
	@Query(value ="SELECT count(ms.stockid) FROM medc_stock.medc_mainstock ms WHERE Date(clientcdate) = Date(CURRENT_DATE) and ms.companyrefid =?1 AND ms.branchrefid=?2 AND ms.locname=?3 AND ms.locrefid =?4", nativeQuery=true)
	Object ViewoneDayStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT count(ms.stockid) FROM medc_stock.medc_mainstock ms WHERE Week(clientcdate) = Week(CURRENT_DATE) and ms.companyrefid =?1 AND ms.branchrefid=?2 AND ms.locname=?3 AND ms.locrefid =?4", nativeQuery=true)
	Object ViewoneWeekStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT count(ms.stockid) FROM medc_stock.medc_mainstock ms WHERE Month(clientcdate) = Month(CURRENT_DATE) and ms.companyrefid =?1 AND ms.branchrefid=?2 AND ms.locname=?3 AND ms.locrefid =?4", nativeQuery=true)
	Object ViewoneMonthStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT count(ms.stockid) FROM medc_stock.medc_mainstock ms WHERE Year(clientcdate) = Year(CURRENT_DATE) and ms.companyrefid =?1 AND ms.branchrefid=?2 AND ms.locname=?3 AND ms.locrefid =?4", nativeQuery=true)
	Object ViewoneYearStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT count(ms.stockid) FROM medc_stock.medc_mainstock ms WHERE ms.companyrefid =?1 AND ms.branchrefid=?2 AND ms.locname=?3 AND ms.locrefid =?4", nativeQuery=true)
	Object ViewoneGrandStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	//Puthira Out of Stocks Count's
	@Query(value ="SELECT count(stockid) FROM medc_stock.medc_mainstock WHERE Date(clientcdate) = Date(CURRENT_DATE) and qty <=0 AND companyrefid=?1 AND branchrefid=?2 AND locname=?3 AND locrefid=?4", nativeQuery=true)
	Object ViewoneDayOutofStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value ="SELECT count(stockid) FROM medc_stock.medc_mainstock WHERE Week(clientcdate) = Week(CURRENT_DATE) and qty <=0 AND companyrefid=?1 AND branchrefid=?2 AND locname=?3 AND locrefid=?4", nativeQuery=true)
	Object ViewoneWeekOutofStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value ="SELECT count(stockid) FROM medc_stock.medc_mainstock WHERE Month(clientcdate) = Month(CURRENT_DATE) and qty <=0 AND companyrefid=?1 AND branchrefid=?2 AND locname=?3 AND locrefid=?4", nativeQuery=true)
	Object ViewoneMonthOutofStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value ="SELECT count(stockid) FROM medc_stock.medc_mainstock WHERE Year(clientcdate) = Year(CURRENT_DATE) and qty <=0 AND companyrefid=?1 AND branchrefid=?2 AND locname=?3 AND locrefid=?4", nativeQuery=true)
	Object ViewoneYearOutofStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value ="SELECT count(stockid) FROM medc_stock.medc_mainstock WHERE qty <=0 AND companyrefid=?1 AND branchrefid=?2 AND locname=?3 AND locrefid=?4", nativeQuery=true)
	Object ViewoneGrandOutofStockTotal(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	//Puthiran Stock Expiry COunt's
	@Query(value ="SELECT count(ms.drugproductid) secount FROM medc_stock.medc_mainstock ms\r\n" + 
			"			     INNER JOIN medc_productmaster.medc_custproductmaster cpm ON cpm.productdrugid = ms.DrugProductID\r\n" + 
			"			     INNER JOIN medc_productmaster.medc_genericmaster gm ON gm.genericid = cpm.genericid\r\n" + 
			"			     INNER JOIN medc_stock.medc_shortexpsettings se ON se.locrefid = ms.locrefid\r\n" + 
			"			     WHERE ms.CompanyRefID=:compid AND ms.BranchRefID=:branchid AND ms.LocName=:locname AND ms.LocRefID=:locrefid AND ms.ExpiryDate between curdate() and DATE_ADD(curdate(),INTERVAL se.no_days day) and ms.Qty>0 order by cpm.BrandName", nativeQuery=true)
	int getshortexpprod(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,@Param("locrefid") int locrefid);
	
	@Query(value ="SELECT count(stk.stockid) FROM  medc_stock.medc_mainstock  stk left join medc_stock.medc_drugbatch m on stk.Batchno=m.BatchID     where   stk.companyrefid=:compid and stk.branchrefid=:branchid and     stk.LocName=:locname and stk.LocRefID=:locrefid and destroystatus =0 and  Date(ExpiryDate)< Date(now()) and Qty>0 LIMIT 100;", nativeQuery=true)
	int getexpstockcount(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,@Param("locrefid") int locrefid);

	// ABC Analysis
	@Query(value ="SELECT (SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'a' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 DAY)) AS Aday,\r\n" + 
			"(SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'b' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 DAY)) AS Bday,\r\n" + 
			"(SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'c' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 DAY)) AS Cday FROM medc_stock.medc_mainstock mst\r\n" + 
			"WHERE mst.companyrefid =:compid AND mst.branchrefid =:branchid AND mst.locname =:locname AND mst.locrefid=:locrefid GROUP BY mst.abc desc", nativeQuery=true)
	Object getabcday(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT (SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'a' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 DAY)) AS Aday,\r\n" + 
			"(SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'b' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 DAY)) AS Bday,\r\n" + 
			"(SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'c' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 DAY)) AS Cday FROM medc_stock.medc_mainstock mst\r\n" + 
			"WHERE mst.companyrefid =:compid AND mst.branchrefid =:branchid AND mst.locname =:locname AND mst.locrefid=:locrefid GROUP BY mst.abc desc", nativeQuery=true)
	Object getabcweek(Integer compid, Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value ="SELECT (SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'a' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS Aday,\r\n" + 
			"(SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'b' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS Bday,\r\n" + 
			"(SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'c' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 MONTH)) AS Cday FROM medc_stock.medc_mainstock mst\r\n" + 
			"WHERE mst.companyrefid =:compid AND mst.branchrefid =:branchid AND mst.locname =:locname AND mst.locrefid=:locrefid GROUP BY mst.abc DESC", nativeQuery=true)
	Object getabcmonth(Integer compid, Integer branchid, Integer locname, Integer locrefid);

	@Query(value ="SELECT (SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'a' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 YEAR)) AS Aday,\r\n" + 
			"(SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'b' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 YEAR)) AS Bday,\r\n" + 
			"(SELECT count(ms.abc) FROM medc_stock.medc_mainstock ms WHERE ms.abc = 'c' AND MS.STOCKDATE > DATE_SUB(NOW(), INTERVAL 1 YEAR)) AS Cday FROM medc_stock.medc_mainstock mst\r\n" + 
			"WHERE mst.companyrefid =:compid AND mst.branchrefid =:branchid AND mst.locname =:locname AND mst.locrefid=:locrefid GROUP BY mst.abc DESC", nativeQuery=true)
	Object getabcyear(Integer compid, Integer branchid, Integer locname, Integer locrefid);

			
}
