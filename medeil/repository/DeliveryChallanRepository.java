package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.medeil.domain.DeliverChallan;
import com.medeil.domain.IndentRequest;

@Repository
public interface DeliveryChallanRepository extends JpaRepository<DeliverChallan, Long> {

	// Stock Transfer Block
	@Query(value = "SELECT StkTrfID, StkTrfNo  from medc_stock.medc_stocktransfer WHERE StkTrfNo  like :str% and companyrefid=:compid and branchrefid=:brnchid and locname=:loc and locrefid=:locref and dcrefid=0", nativeQuery = true)
	List getStranferStockNO(@Param("str") String str, @Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("loc") int loc, @Param("locref") int locref);

	@Query(value = "SELECT StkTrfID, StkTrfNo from medc_stock.medc_stocktransfer WHERE StkTrfNo  like :search%  ", nativeQuery = true)
	List getStranferAdminStockNO(@Param("search") String search);

	/*@Query(value = "SELECT s.drugproductrefid,p.brandname,COALESCE(s.transferboxqty,0) transferboxqty,COALESCE(s.transferstripqty,0) transferstripqty,s.transfertotalqty,s.sellingprice,db.batchno,COALESCE(s.transfertabqty,0) transfertabqty from medc_stock.medc_stktrfproduct s inner join medc_stock.medc_drugbatch db on db.batchid = s.batchrefid left join medc_productmaster.medc_custproductmaster p  on p.productdrugid=s.drugproductrefid WHERE StkTrfRefID= :search", nativeQuery = true)
	List getSuperAdminProduct(@Param("search") String search);*/
	

	
	@Query(value = "SELECT s.drugproductrefid,p.brandname,COALESCE(s.transferboxqty,0) transferboxqty,COALESCE(s.transferstripqty,0) transferstripqty,s.transfertotalqty,s.sellingprice,db.batchno,COALESCE(s.transfertabqty,0) transfertabqty,s.Batchrefid as batchid from medc_stock.medc_stktrfproduct s inner join medc_stock.medc_drugbatch db on db.batchid = s.batchrefid left join medc_productmaster.medc_custproductmaster p  on p.productdrugid=s.drugproductrefid WHERE StkTrfRefID= :search", nativeQuery = true)
	List getSuperAdminProduct(@Param("search") String search);

	// purchase Invoice Block

	@Query(value = "SELECT PIID, PINO  from medc_purchase.medc_purchaseinvoice WHERE PINO  like :str% and dcrefid=0 and companyrefid=:compid and branchrefid=:brnchid and locname=:loc and locrefid=:locref", nativeQuery = true)
	List getDeliveryPurchaseNO(@Param("str") String str, @Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("loc") int loc, @Param("locref") int locref);

	@Query(value = "SELECT PIID, PINO  from medc_purchase.medc_purchaseinvoice WHERE PINO   like :search% ", nativeQuery = true)
	List getDeliveryAdminPurchaseNO(@Param("search") String search);

	/*@Query(value = "SELECT p.drugproductrefid,c.brandname,p.boxquantity,p.stripquantity,p.totalquantity,p.unitprice,db.batchno,p.tabletquantity from medc_purchase.medc_piproduct p left join medc_productmaster.medc_custproductmaster c  on c.productdrugid=p.drugproductrefid  left join medc_stock.medc_drugbatch db   on db.batchid=p.batchno  WHERE PIRefID= :search", nativeQuery = true)
	List getDeliveryPurchaseInvoiceProduct(@Param("search") String search);*/
	
	@Query(value = "SELECT p.drugproductrefid,c.brandname,p.boxquantity,p.stripquantity,p.totalquantity,p.unitprice,db.batchno,p.tabletquantity,p.Batchno as batchid from medc_purchase.medc_piproduct p left join medc_productmaster.medc_custproductmaster c  on c.productdrugid=p.drugproductrefid  left join medc_stock.medc_drugbatch db   on db.batchid=p.batchno  WHERE PIRefID= :search", nativeQuery = true)
	List getDeliveryPurchaseInvoiceProduct(@Param("search") String search);

	// Sales invoice Block

	@Query(value = "SELECT SalesBillID, SalesBillNo  from medc_sales.medc_salesmaintenance WHERE SalesBillNo  like :str% and dcrefid=0 and companyrefid=:compid and branchrefid=:brnchid and locname=:loc and locrefid=:locref", nativeQuery = true)
	List getDeliverySalesNO(@Param("str") String str, @Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("loc") int loc, @Param("locref") int locref);


	@Query(value = "SELECT SalesBillID, SalesBillNo  from medc_sales.medc_salesmaintenance WHERE SalesBillNo   like :search% ", nativeQuery = true)
	List getDeliveryAdminSalesNO(@Param("search") String search);
//server old
	@Query(value = "SELECT s.drugproductid,p.brandname,COALESCE(s.boxqty,0) boxqty,s.batchrefid,COALESCE(s.stripqty,0) stripqty,s.indvqty,s.unitprice,db.batchno,COALESCE(s.tabletqty,0) tabqty,sm.salesbillno from medc_sales.medc_salesbill s\r\n" + 
			"left join medc_productmaster.medc_custproductmaster p  on p.productdrugid=s.drugproductid\r\n" + 
			"left join medc_stock.medc_drugbatch db   on db.batchid=s.batchrefid\r\n" + 
			"left join medc_sales.medc_salesmaintenance sm on sm.salesbillid = s.salesrefid\r\n" + 
			"WHERE salesrefid= :search", nativeQuery = true)
	List getDeliverySalesInvoiceProduct(@Param("search") String search);
	

	/*@Query(value = "SELECT s.drugproductid,p.brandname,COALESCE(s.boxqty,0) boxqty,COALESCE(s.stripqty,0) stripqty,s.totalqty,s.unitprice,db.batchno,COALESCE(s.tabletqty,0) tabqty,s.Batchrefid,COALESCE(sm.salesorderrefid,0) salesorderid from (medc_sales.medc_salesbill s,medc_sales.medc_salesorder so) left join medc_productmaster.medc_custproductmaster p  on p.productdrugid=s.drugproductid left join medc_stock.medc_drugbatch db   on db.batchid=s.batchrefid  left join medc_sales.medc_salesmaintenance sm on sm.salesorderrefid=so.orderid WHERE sm.salesbillid=s.salesrefid and salesrefid= :search", nativeQuery = true)
	List getDeliverySalesInvoiceProduct(@Param("search") String search);*/


	///

	@Query(value = "SELECT ShopID,ShopName from medc_storereg.medc_shopinformation WHERE  companyrefid= :compid and locname=:locname", nativeQuery = true)
	List getDeliveryShop(@Param("compid") int compid, @Param("locname") int locname);

	@Query(value = "SELECT Stripperbox,Quantityperstrip FROM medc_productmaster.medc_custproductmaster WHERE ProductDrugID= :id", nativeQuery = true)
	List getpurQuantity(@Param("id") int id);

	@Query(value = "SELECT StkTrfID, StkTrfNo  from medc_stock.medc_stocktransfer WHERE StkTrfNo  like :str% and companyrefid=:compid and branchrefid=:brnchid and locname=:loc and locrefid=:locref", nativeQuery = true)
	List getStockProduct(@Param("str") String str, @Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("loc") int loc, @Param("locref") int locref);

	@Query(value = "SELECT StkTrfNo FROM medc_stock.medc_stocktransfer", nativeQuery = true)
	List StockTransferNo();

	@Query(value = "SELECT stktrfrefid,drugproductrefid,p.brandname,transferboxqty,transferstripqty,transfertabqty,sellingprice from medc_stock.medc_stktrfproduct s left join medc_productmaster.medc_custproductmaster p  on p.productdrugid=s.drugproductrefid", nativeQuery = true)
	List StockTransProduct();

	DeliverChallan save(DeliverChallan ip);

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

	@Query(value = "SELECT ind.dcid,cmp.companyname,brn.branchname,loc.locationname,COALESCE(IFNULL(shp.shopname,''),IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name,loc1.locationname as Flocationame,COALESCE(IFNULL(shp1.shopname,''),IFNULL(whr1.warehousename,''),IFNULL(hsp1.hospitalname,''))AS Flocationname,loc2.locationname as Tlocation,COALESCE(IFNULL(shp2.shopname,''),IFNULL(whr2.warehousename,''),IFNULL(hsp2.hospitalname,''))AS Tlocationname,dcno, DATE_FORMAT(deliverydate,'%Y-%m-%d') as deliverydate,ind.status from medc_stock.medc_deliverchallan ind left join medc_adminsecurity.medc_locationref loc on loc.id=ind.locname "
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
			+ "left join medc_branchreg.medc_branchinfomation brn on brn.branchid=ind.branchrefid where ind.companyrefid=:comp and ind.branchrefid=:brnch and ind.locname=:locname and ind.locrefid=:locrefid", nativeQuery = true)
	List viewDeliveryChalllan(@Param("comp") int comp, @Param("brnch") int brnch, @Param("locname") int loc,
			@Param("locrefid") int locrefid);


	@Query(value = "  SELECT  stkminid ,stkminno,DATE(ClientCDate1)   FROM    medc_stock.medc_stockminqty     where LocName=?1 and LocRefID=?2   and Status!=5 and IndReqflag=0    group by   stkminid   ", nativeQuery = true)
	List viewStkMinQtyAll(int lcrnm, int lcrid);

	@Query(value = "  SELECT  id ,pur_order_no   FROM   syn_table.purchase_order group by pur_order_no", nativeQuery = true)
	List getPurchaseOrderNO();

	@Query(value = " SELECT  stm. stkminno as stockminno ,DATE(ClientCDate1), cust.BrandName  ,stm.stkminautoid,stm. stkminid     ,stm. drugproductid ,stm. batchrefid ,stm. receivedqty,stm. minqty,stm. ClientCDate1      ,  cust.Stripperbox , cust.Quantityperstrip  , cust.MinQty, cust.MaxQty      FROM   medc_stock.medc_stockminqty  stm	left join (SELECT BrandName,ProductDrugID,Stripperbox,Quantityperstrip,MinQty,MaxQty    from  medc_productmaster.medc_custproductmaster  where  ((LocName=?1 and  LocRefID=?2) || (companyID=?4)))  cust     on   cust.ProductDrugID = stm. drugproductid     where   stm.stkminid= ?3      and    stm.LocName=?1 and  stm.LocRefID=?2 ", nativeQuery = true)
	List viewStkMinQty(int lcrnm, int lcrid, int id, int compid);

	@Query(value = " SELECT '0' AS col0,  '0'AS col1, cust.BrandName, ''AS col3,  ''AS col4, po.item_code, ''AS col6,  po.qty,  po.qty as  qty2, po.pur_order_date, cust.Stripperbox , cust.Quantityperstrip  , cust.MinQty, cust.MaxQty FROM syn_table.purchase_order po left join  medc_productmaster.medc_custproductmaster   cust  on  cust.ProductDrugID = po.item_code where  po.pur_order_no= :pono", nativeQuery = true)
	List adminPurchaseOrder(@Param("pono") String pono);

	@Query(value = " SELECT '0' AS col0,  '0'AS col1, cust.BrandName, ''AS col3,  ''AS col4, po.item_code, ''AS col6,  po.qty,  po.qty as  qty2, po.pur_order_date, cust.Stripperbox , cust.Quantityperstrip  , cust.MinQty, cust.MaxQty FROM syn_table.purchase_order po left join  medc_productmaster.medc_custproductmaster    cust on   cust.ProductDrugID = po.item_code   and  po.comp_id=:compid and  po.pur_order_no=:pono", nativeQuery = true)
	List purchaseOrder(@Param("pono") String pono, @Param("compid") int compid);

	@Modifying
	@Transactional
	@Query(value = "update    medc_indentmaster.medc_indentreq  set   Status=5  where  indentreqid=?3 and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteIndReq(int lcrnm, int lcrid, int id);

	@Modifying
	@Transactional
	@Query(value = "  update medc_stock.medc_stockminqty  stk set stk.IndReqflag=1      where     stk.stkminid=?3   and  stk.LocName=?1 and stk.LocRefID=?2   ", nativeQuery = true)
	void updateIndReqFlag(double lcrnm, double lcrid, int ind);

	@Query(value = " SELECT pp.drugproductrefid,pr.brandname,pr.genericnamedosage,pp.boxqty,pp.stripqty,pp.tabqty FROM medc_stock.medc_dchallanproduct pp "
			+ "left join medc_stock.medc_deliverchallan po on po.dcid=pp.dcrefid "
			+ "left join  medc_productmaster.medc_custproductmaster pr on pr.productdrugid=pp.drugproductrefid "
			+ "where po.companyrefid=:compid and po.branchrefid=:branchid and po.locname=:locname and po.locrefid=:locrefid and po.dcid=:id", nativeQuery = true)
	List EditDeliveryChallanProduct(@Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("id") int id);

	@Query(value = "SELECT dc.dcid,dc.dcno,DATE_FORMAT(dc.deliverydate,'%Y-%m-%d') as deliverydate,dc.totalproduct,dc.totalqty,dc.totalboxqty,dc.totalstripqty,dc.totaltabqty,dc.tolocname,dc.tolocrefid,ls.locationname,sh.shopname from medc_stock.medc_deliverchallan dc inner join medc_storereg.medc_shopinformation sh on sh.shopid=dc.tolocrefid  inner join medc_adminsecurity.medc_locationref ls on ls.id= dc.tolocname WHERE dc.companyrefid=:compid and dc.branchrefid=:branchid and dc.locname=:locname and dc.locrefid=:locrefid and dc.dcid=:id", nativeQuery = true)
	List EditDeliveryChallan(@Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("id") int id);

	@Query(value = "SELECT shopid,shopname FROM medc_storereg.medc_shopinformation  WHERE shopid=:id", nativeQuery = true)
	List getEditShop(@Param("id") int id);

	@Query(value = "SELECT warehouseid,warehousename FROM medc_warehousereg.medc_warehouseinfo where warehouseid=:id", nativeQuery = true)
	List getEditWarehouse(@Param("id") int id);

	@Query(value = "SELECT hospitalid,hospitalname FROM medc_hospitalreg.hospitalregistration where hospitalid=:id", nativeQuery = true)
	List getEditHospital(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "update    medc_purchase.medc_purchaseinvoice  set   dcrefid=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4  and PIId=?5 ", nativeQuery = true)
	int purcupdate(int compid, int branchid, int locname, int locrefid, int piid);

	@Modifying
	@Transactional
	@Query(value = "update    medc_purchase.medc_piproduct  set   dcrefid=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4  and PIRefid=?5 ", nativeQuery = true)
	int purcproduct(int compid, int branchid, int locname, int locrefid, int pirefid);

	@Modifying
	@Transactional
	@Query(value = "update    medc_sales.medc_salesmaintenance  set   dcrefid=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4  and salesbillid=?5 ", nativeQuery = true)
	int saleupdate(int compid, int branchid, int locname, int locrefid, int siid);

	@Modifying
	@Transactional
	@Query(value = "update    medc_sales.medc_salesbill  set   dcrefid=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4  and salesrefid=?5 ", nativeQuery = true)
	int saleproduct(int compid, int branchid, int locname, int locrefid, int sirefid);

	@Modifying
	@Transactional
	@Query(value = "update    medc_stock.medc_stocktransfer  set   dcrefid=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4  and stktrfid=?5 ", nativeQuery = true)
	int stoctrfupdate(int compid, int branchid, int locname, int locrefid, int stktrfid);

	@Modifying
	@Transactional
	@Query(value = "update    medc_stock.medc_stktrfproduct  set   dcrefid=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4  and stktrfrefid=?5 ", nativeQuery = true)
	int stoctrfproduct(int compid, int branchid, int locname, int locrefid, int stkrefid);

	@Query(value = "SELECT stktrfid , stktrfno FROM medc_stock.medc_stocktransfer st\r\n"
			+ "INNER JOIN medc_stock.medc_deliverchallan dc ON dc.invoicerefid = st.stktrfid\r\n"
			+ "WHERE dc.dcid =:id", nativeQuery = true)
	List StocktrnsID(@Param("id") int id);

	// Boopalan 200919 - For saving data medc_status.medc_salesordertrack
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_status.medc_salesordertrack (salesorderrefid, statusid, statusdate)VALUES (?1, ?2, ?3);", nativeQuery = true)
	Integer save_medc_salesordertrack(@Param("salesorderrefid") int salesorderrefid, @Param("statusid") int statusid,
			@Param("medc_salesordertrack_statusdate") String medc_salesordertrack_statusdate);
	
	
    @Query(value="SELECT salesbillid,salesbillno FROM medc_sales.medc_salesmaintenance where salesbillid= :siid",nativeQuery =true)
    List getsinvoice(@Param("siid") int siid);
    
    //Raja Delivery Challan Get POID
    @Query(value="SELECT distinct po.poid,po.pono FROM medc_purchase.medc_purchaseorder po\r\n" + 
    		"INNER JOIN medc_purchase.medc_poproduct pop ON pop.porefid = po.poid\r\n" + 
    		"WHERE po.status=0 AND pop.dcflag =0 AND pop.piflag = 0 AND po.companyrefid=:comid AND po.branchrefid=:branchid AND po.locname =:locname AND po.locrefid=:locrefid order by poid desc ",nativeQuery =true)
    List getporegnumber(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid);

    @Query(value="SELECT di.distributorid,di.distributorname FROM medc_distributor.medc_distributorinformation di\r\n" + 
    		"INNER JOIN medc_purchase.medc_purchaseorder po ON po.vendorid = di.distributorid\r\n" + 
    		"WHERE po.poid =:poid ",nativeQuery =true)
    List getdist(@Param("poid") Integer poid);
    
   
    @Query(value="SELECT pp.drugproductrefid ,CONCAT(pr.brandname,' ',pr.genericnamedosage) AS productname,pp.totalquantity,pp.boxquantity,pp.stripquantity,pp.tabletquantity,pp.stripperbox,pp.quantityperstrip,pp.packageunit FROM medc_purchase.medc_poproduct pp INNER JOIN medc_productmaster.medc_custproductmaster pr on pr.productdrugid=pp.drugproductrefid WHERE pp.dcflag = 0 AND pp.porefid =:poid",nativeQuery = true)
    List getpro(@Param("poid") Integer poid);
    
    @Query(value="SELECT COALESCE(MAX(dcno),'PDC000000000') FROM medc_stock.medc_deliverchallan WHERE companyrefid=?1 AND branchrefid=?2 AND locname=?3 AND locrefid=?4 and billtyperefid = 0",nativeQuery = true)
    String lastPurchasedc(int companyrefid, int branchrfid, int locname , int locrefid);
    
    @Query(value="SELECT MAX(dcid) FROM medc_stock.medc_deliverchallan", nativeQuery = true)
    Integer getDcID();
    
    @Query(value="SELECT dc.dcid,dc.dcno,dist.distributorname,po.pono,date(dc.deliverydate) deliverydate,dc.dist_dcno  FROM medc_stock.medc_deliverchallan dc\r\n" + 
    		"INNER JOIN medc_purchase.medc_purchaseorder po ON po.poid = dc.poid\r\n" + 
    		"INNER JOIN medc_distributor.medc_distributorinformation dist ON dist.distributorid = po.vendorid\r\n" + 
    		"WHERE dc.companyrefid=:comid AND dc.branchrefid=:branchid AND dc.locname =:locname AND dc.locrefid =:locrefid order by dc.dcid desc", nativeQuery =true)
    List getdeliveychallan(@Param("comid") int comid,@Param("branchid")  int branchid ,@Param("locname") int locname ,@Param("locrefid") int locrefid);
    
    @Query(value="SELECT sm.customerrefid,p.patientfirstname,p.mobile FROM medc_sales.medc_salesmaintenance sm\r\n" + 
    		"  INNER JOIN medc_patientreg.medc_patientbasicinfo p ON p.patientid = sm.customerrefid\r\n" + 
    		"  Where sm.salesbillid =:siid",nativeQuery = true)
    List getcustomer(@Param("siid") int siid);
    
    @Query(value="SELECT salesbillid ,salesbillno FROM medc_sales.medc_salesmaintenance WHERE companyrefid=:comid AND Branchrefid =:branchid AND locname =:locname AND locrefid =:locrefid",nativeQuery = true)
    List getsino(@Param("comid") int comid,@Param("branchid") int branchid,@Param("locname") int locname,@Param("locrefid") int locrefid);

	DeliverChallan findById(int id);

	@Query(value="SELECT pr.brandname,dcp.batchname,dcp.boxqty,dcp.stripperbox,dcp.totalqty,dcp.packageunit,dcp.drugproductrefid FROM medc_stock.medc_dchallanproduct dcp\r\n" + 
			"INNER JOIN medc_productmaster.medc_custproductmaster pr on pr.ProductDrugID=dcp.DrugProductRefID where dcrefid =?1",nativeQuery = true)
	List getdcProducts(Integer id);
	




}
