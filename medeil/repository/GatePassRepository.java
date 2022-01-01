package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.medeil.domain.GatePass;
import com.medeil.domain.IndentRequest;

@Repository
public interface GatePassRepository extends JpaRepository<GatePass, Long> {

	@Query(value = "SELECT ShopID,ShopName from medc_storereg.medc_shopinformation WHERE  companyrefid= :compid and locname=:locname", nativeQuery = true)
	List getDeliveryShop(@Param("compid") int compid, @Param("locname") int locname);

	@Query(value = "SELECT Stripperbox,Quantityperstrip FROM medc_productmaster.medc_custproductmaster WHERE ProductDrugID= :id", nativeQuery = true)
	List getpurQuantity(@Param("id") int id);

	@Query(value = "SELECT StkTrfID, StkTrfNo  from medc_stock.medc_stocktransfer WHERE StkTrfNo  like :str% and companyrefid=:compid and branchrefid=:brnchid and locname=:loc and locrefid=:locref", nativeQuery = true)
	List getStockNO(@Param("str") String str, @Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("loc") int loc, @Param("locref") int locref);

	@Query(value = "SELECT StkTrfID, StkTrfNo from medc_stock.medc_stocktransfer WHERE StkTrfNo  like :searchValue% ", nativeQuery = true)
	List getSuperAdminStockNO(@Param("searchValue") String searchValue);
	
	@Query(value = "SELECT StkTrfID, StkTrfNo  from medc_stock.medc_stocktransfer WHERE StkTrfNo  like :str% and dcrefid=0 and companyrefid=:compid and branchrefid=:brnchid and locname=:loc and locrefid=:locref", nativeQuery = true)
	List getStockProduct(@Param("str") String str, @Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("loc") int loc, @Param("locref") int locref);

	@Query(value = "SELECT drugproductrefid,p.brandname,transferboxqty,transferstripqty,transfertabqty,sellingprice from medc_stock.medc_stktrfproduct s left join medc_productmaster.medc_custproductmaster p  on p.productdrugid=s.drugproductrefid WHERE StkTrfRefID= :search", nativeQuery = true)
	List getSuperAdminProduct(@Param("search") String search);

	@Query(value = "SELECT StkTrfNo FROM medc_stock.medc_stocktransfer", nativeQuery = true)
	List StockTransferNo();

	@Query(value = "SELECT stktrfrefid,drugproductrefid,p.brandname,transferboxqty,transferstripqty,transfertabqty,sellingprice from medc_stock.medc_stktrfproduct s left join medc_productmaster.medc_custproductmaster p  on p.productdrugid=s.drugproductrefid", nativeQuery = true)
	List StockTransProduct();

	GatePass save(GatePass ip);

	@Query(value = " SELECT IndentReqID ,indentno,fromlocrefid,fromlocname,tolocrefid,tolocname,DATE(ClientCDate1)  FROM medc_indentmaster.medc_indentreq   where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewIndentRequests(int lcrnm, int lcrid);

	@Query(value = "SELECT    ir. indentreqid , ir. indentno,  DATE(ir.ClientCDate1) , ir.  ToLocRefID, ir. tolocname ,       ir.ClientCDate1  as  cldate ,ir.indapprflag ,ir.fromlocname ,ir.fromlocrefid   FROM medc_indentmaster.medc_indentreq ir   where  ir. indentreqid=?3     and    ir.LocName=?1 and  ir.LocRefID=?2  ", nativeQuery = true)
	List viewIndentRequest(int lcrnm, int lcrid, int ind);

	@Query(value = " SELECT ShopID,ShopName  FROM medc_storereg.medc_shopinformation        where  LocName=?1 and LocRefID=?2   ", nativeQuery = true)
	List viewshopinformation(int lcrnm, int lcrid);

	@Query(value = " SELECT warehouseID,Warehousename  FROM medc_warehousereg.medc_warehouseinfo       where  LocName=?1 and LocRefID=?2    ", nativeQuery = true)
	List viewWareHouse(int lcrnm, int lcrid);

	@Query(value = "   SELECT HospitalID , HospitalName  FROM medc_hospitalreg.hospitalregistration       where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewHospital(int lcrnm, int lcrid);

	@Query(value = "  SELECT IFNULL(MAX(DcID),0)   FROM medc_stock.medc_deliverchallan where CompanyRefID=?1 and BranchRefID=?2 and  LocName=?3 and LocRefID=?4  ", nativeQuery = true)
	int getDcID(int compid, int branchid, int locname, int locrefid);

	@Query(value = "  SELECT   IFNULL(RIGHT(indentno, 7),0)   FROM   medc_indentmaster.medc_indentreq   where  indentreqid=?3     and    LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	String viewIndReqIncNo(int lcrnm, int lcrid, int id);

	@Query(value = "select ProductDrugID, BrandName  from medc_productmaster.medc_custproductmaster	where   BrandName like  ?3%    and    ((LocName=?1 and  LocRefID=?2) || (companyID=?4))   ORDER BY BrandName LIMIT 10", nativeQuery = true)
	List viewCustProducts(int lcrnm, int lcrid, String name, int compid);

	@Query(value = "SELECT cst.BrandName ,  cst.ProductDrugID  ,  cst.Stripperbox , cst.Quantityperstrip  , cst.MinQty,      cst.MaxQty     FROM  medc_productmaster.medc_custproductmaster  cst  where    cst.ProductDrugID = ?3    and   ((LocName=?1 and  LocRefID=?2) || (companyID=?4)) ", nativeQuery = true)
	List viewCustProduct(int lcrnm, int lcrid, int name, int compid);

	@Modifying
	@Transactional
	@Query(value = "update  medc_stock.medc_deliverchallan  set   gprefid=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4  and dcid=?5 ", nativeQuery = true)
	void saleupdatestatus(int compid, int branchid, int locname, int locrefid, int dcid);

	@Query(value = "SELECT cmp.companyname,brn.branchname,loc.locationname,COALESCE(IFNULL(shp.shopname,''),IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name,loc1.locationname as Flocationame,COALESCE(IFNULL(shp1.shopname,''),IFNULL(whr1.warehousename,''),IFNULL(hsp1.hospitalname,''))AS Flocationname,loc2.locationname as Tlocation,COALESCE(IFNULL(shp2.shopname,''),IFNULL(whr2.warehousename,''),IFNULL(hsp2.hospitalname,''))AS Tlocationname,gpno,gatepassdate from medc_stock.medc_gatepass ind left join medc_adminsecurity.medc_locationref loc on loc.id=ind.locname "
			+ "left join medc_storereg.medc_shopinformation shp on shp.shopid=ind.locrefid and ind.locname=loc.id	"
			+ "left join medc_warehousereg.medc_warehouseinfo whr on whr.warehouseid=ind.locrefid and ind.locname=loc.id  "
			+ "left join medc_hospitalreg.hospitalregistration hsp on hsp.hospitalid=ind.locrefid and ind.locname=loc.id "
			+ "left join medc_adminsecurity.medc_locationref loc1 on loc1.id=ind.fromlocname "
			+ "left join medc_storereg.medc_shopinformation shp1 on shp1.shopid=ind.fromlocrefid and ind.fromlocname=loc1.id "
			+ "left join medc_warehousereg.medc_warehouseinfo whr1 on whr1.warehouseid=ind.fromlocrefid and ind.fromlocname=loc1.id  "
			+ "left join medc_hospitalreg.hospitalregistration hsp1 on hsp1.hospitalid=ind.fromlocrefid and ind.fromlocname=loc1.id "
			+ "left join medc_adminsecurity.medc_locationref loc2 on loc2.id=ind.tolocname "
			+ "left join medc_storereg.medc_shopinformation shp2 on shp2.shopid=ind.tolocrefid and ind.tolocname=loc2.id "
			+ "left join medc_warehousereg.medc_warehouseinfo whr2 on whr2.warehouseid=ind.tolocrefid and ind.tolocname=loc2.id "
			+ "left join medc_hospitalreg.hospitalregistration hsp2 on hsp2.hospitalid=ind.tolocrefid and ind.tolocname=loc2.id "
			+ "left join medc_companyreg.medc_companyinfomation cmp on cmp.companyid=ind.companyrefid "
			+ "left join medc_branchreg.medc_branchinfomation brn on brn.branchid=ind.branchrefid where ind.companyrefid=:comp and ind.branchrefid=:brnch and ind.locname=:locname and ind.locrefid=:locrefid and ind.billtype=:billtyperefid", nativeQuery = true)
	List viewDeliveryChalllan(@Param("comp") int comp, @Param("brnch") int brnch, @Param("locname") int loc,
			@Param("locrefid") int locrefid,@Param("billtyperefid") int billtyperefid);

	@Query(value = "  SELECT  stkminid ,stkminno,DATE(ClientCDate1)   FROM    medc_stock.medc_stockminqty     where LocName=?1 and LocRefID=?2   and Status!=5 and IndReqflag=0    group by   stkminid   ", nativeQuery = true)
	List viewStkMinQtyAll(int lcrnm, int lcrid);

	@Query(value = "  SELECT  id ,pur_order_no   FROM   syn_table.purchase_order group by pur_order_no", nativeQuery = true)
	List getPurchaseOrderNO();

	@Query(value = " SELECT  stm. stkminno as stockminno ,DATE(ClientCDate1), cust.BrandName  ,stm.stkminautoid,stm. stkminid     ,stm. drugproductid ,stm. batchrefid ,stm. receivedqty,stm. minqty,stm. ClientCDate1      ,  cust.Stripperbox , cust.Quantityperstrip  , cust.MinQty, cust.MaxQty      FROM   medc_stock.medc_stockminqty  stm	left join (SELECT BrandName,ProductDrugID,Stripperbox,Quantityperstrip,MinQty,MaxQty    from  medc_productmaster.medc_custproductmaster  where  ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))  cust     on   cust.ProductDrugID = stm. drugproductid     where   stm.stkminid= ?3      and    stm.LocName=?1 and  stm.LocRefID=?2 ", nativeQuery = true)
	List viewStkMinQty(int lcrnm, int lcrid, int id, int compid);

	@Query(value = " SELECT '0' AS col0,  '0'AS col1, cust.BrandName, ''AS col3,  ''AS col4, po.item_code, ''AS col6,  po.qty,  po.qty as  qty2, po.pur_order_date, cust.Stripperbox , cust.Quantityperstrip  , cust.MinQty, cust.MaxQty FROM syn_table.purchase_order po left join  medc_productmaster.medc_custproductmaster   cust  on  cust.ProductDrugID = po.item_code where  po.pur_order_no= :pono", nativeQuery = true)
	List adminPurchaseOrder(@Param("pono") String pono);

	@Modifying
	@Transactional
	@Query(value = "update    medc_indentmaster.medc_indentreq  set   Status=5  where  indentreqid=?3 and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteIndReq(int lcrnm, int lcrid, int id);

	@Modifying
	@Transactional
	@Query(value = "  update medc_stock.medc_stockminqty  stk set stk.IndReqflag=1      where     stk.stkminid=?3   and  stk.LocName=?1 and stk.LocRefID=?2   ", nativeQuery = true)
	void updateIndReqFlag(double lcrnm, double lcrid, int ind);

	@Query(value = "  SELECT IFNULL(MAX(GpID),0)   FROM medc_stock.medc_gatepass where CompanyRefID=?1 and BranchRefID=?2 and  LocName=?3 and LocRefID=?4  ", nativeQuery = true)
	int getGatepassID(int compid, int branchid, int locname, int locrefid);

	// padmini
	@Query(value = "SELECT DcID, DcNo from medc_stock.medc_deliverchallan WHERE DcNo  like :searchValue% and gprefid=0 and companyrefid=:compid and branchrefid=:brnchid and locname=:loc and locrefid=:locref and billtyperefid=:billtyperefid", nativeQuery = true)
	List getGatePassNo(@Param("searchValue") String searchValue, @Param("compid") int compid,
			@Param("brnchid") int brnchid, @Param("loc") int loc, @Param("locref") int locref,
			@Param("billtyperefid") int billtyperefid);

	@Query(value = "Select dp.DrugProductRefid,pm.brandname,COALESCE(dp.boxqty,0) boxqty,COALESCE(dp.stripqty,0) stripqty,dp.totalqty,dp.sellingprice,COALESCE(db.batchno,0),COALESCE(dp.tabqty,0) tabqty,dp.Batchrefid as batchid,COALESCE(dm.salesorderrefid,0) salsorefid from medc_stock.medc_dchallanproduct dp left join medc_productmaster.medc_custproductmaster pm  on pm.productdrugid=dp.DrugProductRefid left join medc_stock.medc_drugbatch db   on db.batchid=dp.batchrefid left join medc_stock.medc_deliverchallan dm on dm.dcid=dp.dcrefid  where dp.dcrefid=:dcid and dp.companyrefid=:compid and dp.branchrefid=:brnchid and dp.locname=:locname and dp.locrefid=:locref", nativeQuery = true)
	List getGatePassProduct(@Param("dcid") int dcid, @Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("locname") int locname, @Param("locref") int locref);

	// Boopalan 200919 - For saving data medc_status.medc_salesordertrack
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_status.medc_salesordertrack (salesorderrefid, statusid, statusdate)VALUES (?1, ?2, ?3);", nativeQuery = true)
	Integer save_medc_salesordertrack(@Param("salesorderrefid") int salesorderrefid, @Param("statusid") int statusid,
			@Param("medc_salesordertrack_statusdate") String medc_salesordertrack_statusdate);
//Raja Get the Delivery Challan Number 
	
	@Query(value = "SELECT dc.dcid,dc.dcno FROM  medc_stock.medc_deliverchallan dc WHERE dc.dcid=:dcid",nativeQuery =true)
	List getdelchalid(@Param("dcid") int dcid);
	
	  @Query(value="SELECT sm.customerrefid,p.patientfirstname,p.mobile FROM medc_stock.medc_deliverchallan dc\r\n" + 
	    		"INNER JOIN medc_sales.medc_salesmaintenance sm ON sm.salesbillid=dc.invoicerefid\r\n" + 
	    		"INNER JOIN medc_patientreg.medc_patientbasicinfo p ON p.patientid = sm.customerrefid\r\n" + 
	    		"WHERE dcid=:dcid",nativeQuery = true)
	    List getcustom(@Param("dcid") int dcid);
}
