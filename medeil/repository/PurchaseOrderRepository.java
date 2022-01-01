/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Branch;
import com.medeil.domain.PurchaseOrder;

/**
 * @author Manik
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

	@Query(value = "Select coalesce(MAX(pono),'PSO000000000') from medc_purchase.medc_purchaseorder where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4", nativeQuery = true)
	String lastPurchaseOrder(int cid, int bid, int locname, int locrefid);

	@Query(value = "SELECT distinct ps.Purcsessionid,ps.purcsessionno from medc_purchase.medc_purchasesession ps inner join medc_purchase.medc_purcsessionproduct psp on psp.purcsessionrefid=ps.purcsessionid left join medc_purchase.medc_distselect  ds on ds.purcsessionrefid=ps.purcsessionid inner join medc_purchase.medc_priceenquiry pe on pe.prcencid=ds.prcenqrefid  WHERE  psp.drugproductid=pe.drugproductrefid and ds.vendorid=pe.vendorid and  psp.poflag=0 and  ds.Vendorid= :bid order by  ps.Purcsessionid desc", nativeQuery = true)
	public List getSessionHospital(@Param("bid") int bid);

	@Query(value = "SELECT companyid,companyname from medc_companyreg.medc_companyinfomation", nativeQuery = true)
	List getCompanies();

	@Query(value = "SELECT mc.companyid,mc.companyname from medc_companyreg.medc_companyinfomation mc left join medc_purchase.medc_purchaseorder po on po.companyrefid=mc.companyid where po.companyrefid=:poid", nativeQuery = true)
	List getEditCompany(@Param("poid") int poid);

	@Query(value = "SELECT branchid,branchname from  medc_branchreg.medc_branchinfomation WHERE  CompanyRefID= :id ", nativeQuery = true)
	List getBranches(@Param("id") int id);

	@Query(value = "SELECT warehouseid,warehousename from medc_warehousereg.medc_warehouseinfo WHERE  BranchID= :id ", nativeQuery = true)
	List getWareHouse(@Param("id") int id);

	@Query(value = "Select HospitalID,HospitalName from medc_hospitalreg.hospitalregistration WHERE BranchRefID=:id ", nativeQuery = true)
	List getHospitals(@Param("id") int id);

	@Query(value = "SELECT ShopID,ShopName from medc_storereg.medc_shopinformation WHERE  Branch_id= :id ", nativeQuery = true)
	List getShops(@Param("id") int id);

	@Query(value = "SELECT DistributorID,DistributorName from medc_distributor.medc_distributorinformation WHERE DistributorName  like :search% ", nativeQuery = true)
	List getSuperAdminDistributor(@Param("search") String search);

	@Query(value = "SELECT DistributorID,DistributorName from medc_distributor.medc_distributorinformation WHERE DistributorName  like :str% and companyrefid=:compid and branchrefid=:brnchid and locname=:loc and locrefid=:locref and status=0", nativeQuery = true)
	List getDistributor(@Param("str") String str, @Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("loc") int loc, @Param("locref") int locref);

	@Query(value = "SELECT DistributorID,DistributorName from medc_distributor.medc_distributorinformation WHERE distributorID=:poid ", nativeQuery = true)
	List getDistributorEdit(@Param("poid") String poid);

	@Query(value = "SELECT productdrugid,brandname FROM medc_productmaster.medc_custproductmaster WHERE brandname like :str%", nativeQuery = true)
	List getSuperDrug(@Param("str") String str);

	@Query(value = "SELECT productdrugid,CONCAT(BrandName, '_', GenericNameDosage) as BrandNames FROM medc_productmaster.medc_custproductmaster WHERE brandname like :str% and  companyid=:compid", nativeQuery = true)
	List getDrug(@Param("str") String str, @Param("compid") int compid);

	// Boopalan 170419//padmini
	@Query(value ="SELECT purs.purcsessionno,pr.productdrugid,pr.brandname,pr.genericnamedosage,ds.prodwaitingqty,ds.distfinalprice,coalesce(ds.abc,'NA') as abc,coalesce(ds.distprodrank,'NA') as distprodrank,coalesce(ds.distremarks,'NA') as distremarks,purs.purcsessionid,ps.boxqty,ps.boxconvstk,ps.stripconvstk,ps.packageunit FROM medc_productmaster.medc_custproductmaster pr left join medc_purchase.medc_purcsessionproduct ps on ps.drugproductid=pr.productdrugid left join  medc_purchase.medc_distselect ds on ds.drugproductrefid=pr.productdrugid left join medc_purchase.medc_purchasesession purs on purs.purcsessionid=ds.purcsessionrefid \r\n" + 
			"where ps.poflag=0 and ds.purcsessionrefid=:prsid and ds.vendorid=:distID and  VendorSlctFlag='1' group by pr.brandname", nativeQuery = true)
	List getSuperDistributorProducts(@Param("prsid") int prsid, @Param("distID") int distID);

	@Query(value = "SELECT pp.drugproductrefid,pr.brandname,pr.genericnamedosage,pp.boxquantity,pp.stripquantity,"
			+ "pp.tabletquantity,pp.uom,pp.equalto,ds.distfinalprice,pp.totalproductprice,ds.abc,ds.distprodrank,ds.distremarks "
			+ "FROM medc_purchase.medc_poproduct pp "
			+ "left join medc_purchase.medc_purchaseorder po on po.poid=pp.porefid "
			+ "left join  medc_productmaster.medc_custproductmaster pr on pr.productdrugid=pp.drugproductrefid "
			+ "left join  medc_purchase.medc_distselect ds on ds.drugproductrefid=pr.productdrugid "
			+ "where ds.CompanyRefID=:compid and ds.BranchRefID=:brnchid and ds.LocName=:locname and ds.LocRefID=:locrefid and ds.vendorid=:id and  VendorSlctFlag='1' group by pr.brandname", nativeQuery = true)
	List getDistributorProducts(@Param("compid") int compid, @Param("brnchid") int brnchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("id") int id);

	/*
	 * @Query(value =
	 * "SELECT pm.productdrugid,pm.brandname,pm.genericnamedosage FROM medc_productmaster.medc_custproductmaster pm   WHERE ProductDrugID= :drugid"
	 * , nativeQuery = true) List getDrugData(@Param("drugid") int drugid);
	 */

	/*
	 * @Query(value =
	 * "SELECT pm.productdrugid,pm.brandname,pm.genericnamedosage,COALESCE((SELECT ms.abc  FROM  medc_stock.medc_mainstock ms WHERE pm.ProductDrugID=:drugid  and  ms.companyrefid=:compid and ms.branchrefid=:branchid  and ms.locname=:locname and ms.locrefid=:locrefid AND ms.drugproductid=pm.ProductDrugID  GROUP BY ms.drugproductid),'C') AS ABC FROM medc_productmaster.medc_custproductmaster pm WHERE pm.ProductDrugID=:drugid"
	 * , nativeQuery = true) List getDrugData(@Param("drugid") int
	 * drugid, @Param("compid") int compid, @Param("branchid") int branchid,
	 * 
	 * @Param("locname") int locname, @Param("locrefid") int locrefid);
	 */

	@Query(value = "SELECT pm.productdrugid,pm.brandname,pm.genericnamedosage,coalesce(ms.abc,'C') as abc,coalesce(SUM(ms.minqty),0) as minqty,coalesce(sum(ms.reorderlvl),0) as reorderlvl,\r\n"
			+ "(select IFNULL(min(indvqty),0) as minqty FROM medc_sales.medc_salesbill where drugproductid =:drugid and ADDDATE(curdate(), INTERVAL -7 DAY) and companyrefid = :compid and branchrefid = :branchid and locname = :locname and locrefid =:locrefid) as consumpminqty,coalesce(dist.minleadtime,0) as minleadtime,coalesce(SUM(ms.maxqty),0) as maxqty,coalesce(distpro.distprice,0)\r\n"
			+ "FROM (medc_productmaster.medc_custproductmaster pm,medc_distributor.medc_distributorinformation dist)\r\n"
			+ "left join  medc_stock.medc_mainstock ms on ms.drugproductid=pm.ProductDrugID\r\n"
			+ "left join medc_distributor.medc_distproduct distpro on distpro.distrefid = dist.distributorid and distpro.drugprdid = pm.productdrugid\r\n"
			+ "where pm.companyid=:compid and pm.branchid=:branchid  and pm.locname=:locname and pm.locrefid=:locrefid and productdrugid = :drugid and distributorid = :vendorid", nativeQuery = true)
	List getDrugData(@Param("drugid") int drugid, @Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("vendorid") int vendorid);

	public static final String view = "SELECT   po.POID,di.distributorname,po.pono,DATE_FORMAT(po.PODate,'%Y-%m-%d') as PODate,po.totalproduct,po.totalboxquantiy,po.totalstripquantity,"
			+ "po.totalquantity,po.poid,po.totaltabletquantity from medc_purchase.medc_purchaseorder po "
			+ "left join medc_distributor.medc_distributorinformation di on po.vendorid=di.distributorid WHERE po.companyrefid=:compid and po.branchrefid=:brnchid and po.locname=:loc and po.locrefid=:locref and po.Status!=5  order by po.POID desc";

	@Query(value = view, nativeQuery = true)
	public List viewPurchaseOrder(@Param("compid") int compid, @Param("brnchid") int brnchid, @Param("loc") int loc,
			@Param("locref") int locref);

	@Query(value = "SELECT pp.drugproductrefid,pr.brandname,pr.genericnamedosage,pp.boxquantity,pp.stripquantity,pp.tabletquantity,"
			+ "pp.uom,pp.equalto,pp.Unitprice,pp.totalproductprice,pp.abc,pp.distprodrank,pp.distremarks,pp.pursessionid,pp.pursessionno,pp.poproductid,coalesce(pp.reorderlvl,0),coalesce(pp.consumpminqty,0),coalesce(pp.minleadtime,0),coalesce(pp.maxqty,0),pp.stripperbox,pp.quantityperstrip,pp.totalquantity,pp.packageunit "
			+ "FROM medc_purchase.medc_poproduct pp "
			+ "left join medc_purchase.medc_purchaseorder po on po.poid=pp.porefid "
			+ "left join  medc_productmaster.medc_custproductmaster pr on pr.productdrugid=pp.drugproductrefid "
			+ "where po.companyrefid=:compid and po.branchrefid=:brnchid and po.locname=:loc and po.locrefid=:locref and po.poid=:poid AND po.Status!=2", nativeQuery = true)
	List getPurchaseOrder(@Param("compid") int compid, @Param("brnchid") int brnchid, @Param("loc") int loc,
			@Param("locref") int locref, @Param("poid") int poid);

	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_purchaseorder SET status='5' WHERE POID = :poid", nativeQuery = true)
	Integer deletePurchaseOrder(@Param("poid") int poid);

	/*
	 * @Procedure(name = "medc_purchase.pro_add") boolean
	 * createPurchaseOrder(PurchaseOrder purc) throws Exception;
	 */

	@Query(value = "SELECT di.distributorname,po.pono,DATE_FORMAT(po.PODate,'%Y-%m-%d') as PODate,po.totalproduct,po.totalboxquantiy,po.totalstripquantity,"
			+ "po.totaltabletquantity,po.totalquantity,po.grandtotal,di.distributorid,po.poid,po.quantitytype FROM medc_purchase.medc_purchaseorder po "
			+ "left join medc_distributor.medc_distributorinformation  di on di.distributorid=po.vendorid "
			+ "where po.companyrefid=:compid and po.branchrefid=:brnchid and po.locname=:loc and po.locrefid=:locref and po.poid=:poid AND po.status!=2", nativeQuery = true)
	List getEditPurchaseOrder(@Param("compid") int compid, @Param("brnchid") int brnchid, @Param("loc") int loc,
			@Param("locref") int locref, @Param("poid") int poid);

	@Query(value = "SELECT POID FROM medc_purchase.medc_purchaseorder WHERE poid=:id ", nativeQuery = true)
	String distID(@Param("id") int id);

	@Query(value = "SELECT MAX(POID) FROM medc_purchase.medc_purchaseorder", nativeQuery = true)
	Integer getPurchaseOrderID();

	@Modifying
	@Transactional
	@Query(value = "delete from medc_purchase.medc_poproduct WHERE  CompanyRefID=:compid and BranchRefID=:branchid and LocName=:locname and LocRefID=:locrefid and PORefID=:poid", nativeQuery = true)
	void deletePoProduct(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("poid") int poid);

	@Query(value = "SELECT cmp.companyname,brn.branchname,loc.locationname,COALESCE(IFNULL(shp.shopname,''),IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name,loc1.locationname as Flocationame,COALESCE(IFNULL(shp1.shopname,''),IFNULL(whr1.warehousename,''),IFNULL(hsp1.hospitalname,''))AS Flocationname,loc2.locationname as Tlocation,COALESCE(IFNULL(shp2.shopname,''),IFNULL(whr2.warehousename,''),IFNULL(hsp2.hospitalname,''))AS Tlocationname,indentno,date(ind.clientcdate),ind.Status from medc_indentmaster.medc_indentreq ind left join medc_adminsecurity.medc_locationref loc on loc.id=ind.locname left join medc_storereg.medc_shopinformation shp on shp.shopid=ind.locrefid and ind.locname=loc.id"
			+ "	left join medc_warehousereg.medc_warehouseinfo whr on whr.warehouseid=ind.locrefid and ind.locname=loc.id  left join medc_hospitalreg.hospitalregistration hsp on hsp.hospitalid=ind.locrefid and ind.locname=loc.id left join medc_adminsecurity.medc_locationref loc1 on loc1.id=ind.fromlocname left join medc_storereg.medc_shopinformation shp1 on shp1.shopid=ind.fromlocrefid and ind.fromlocname=loc1.id left join medc_warehousereg.medc_warehouseinfo whr1 on whr1.warehouseid=ind.fromlocrefid and ind.fromlocname=loc1.id left join medc_hospitalreg.hospitalregistration hsp1 on hsp1.hospitalid=ind.fromlocrefid and ind.fromlocname=loc1.id left join medc_adminsecurity.medc_locationref loc2 on loc2.id=ind.tolocname left join medc_storereg.medc_shopinformation shp2 on shp2.shopid=ind.tolocrefid and ind.tolocname=loc2.id left join medc_warehousereg.medc_warehouseinfo whr2 on whr2.warehouseid=ind.tolocrefid and ind.tolocname=loc2.id left join medc_hospitalreg.hospitalregistration hsp2 on hsp2.hospitalid=ind.tolocrefid and ind.tolocname=loc2.id left join medc_companyreg.medc_companyinfomation cmp on cmp.companyid=ind.companyrefid"
			+ " left join medc_branchreg.medc_branchinfomation brn on brn.branchid=ind.branchrefid "
			+ "where ind.tolocname=:loc and ind.tolocrefid=:locref order by ind.IndentReqID desc", nativeQuery = true)
	List viewIndentStatus(@Param("loc") int locname,@Param("locref") int locref);
	
	@Query(value = "SELECT cmp.companyname,brn.branchname,loc.locationname,COALESCE(IFNULL(shp.shopname,''),IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name,loc1.locationname as Flocationame,COALESCE(IFNULL(shp1.shopname,''),IFNULL(whr1.warehousename,''),IFNULL(hsp1.hospitalname,''))AS Flocationname,loc2.locationname as Tlocation,COALESCE(IFNULL(shp2.shopname,''),IFNULL(whr2.warehousename,''),IFNULL(hsp2.hospitalname,''))AS Tlocationname,indentno,indentdate,ind.Status from medc_indentmaster.medc_indentreq ind left join medc_adminsecurity.medc_locationref loc on loc.id=ind.locname "
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
			+ "left join medc_branchreg.medc_branchinfomation brn on brn.branchid=ind.branchrefid", nativeQuery = true)
	List superAdminViewIndentStatus();

	@Query(value = "select ProductUOMID,UOMName FROM medc_purchase.medc_productuom", nativeQuery = true)
	public List getPurchaseuom();

	@Query(value = "SELECT m.DistributorID, m.Email FROM medc_distributor.medc_distributorinformation m where m.DistributorID=?1", nativeQuery = true)
	public List PurchaseOrderEmailDistributor(@Param("did") int did);

	@Query(value = "SELECT stk.BrandName,cu.genericnamedosage,fu.formulationname,stk.DrugProductID ,coalesce(stk.lastreceivedqty,0),stk.MinQty ,sum(stk.Qty),\r\n"
			+ "stk.minstockid,stk.gridcolor,stk.ageingtime,stk.abc,stk.reqqty,stk.maxqty,stks.packageunit,COALESCE(stks.boxqty,0),COALESCE(stks.stripqty,0),COALESCE(stks.tabletqty,0),COALESCE(stks.boxperstrip,0),COALESCE(stks.strippertablet,1)\r\n"
			+ "FROM medc_stock.medc_minimumstock  stk\r\n"
			+ "inner join  medc_productmaster.medc_custproductmaster cu on cu.productdrugid=stk.drugproductid\r\n"
			+ "inner join medc_productmaster.medc_formulation fu on fu.formulationid=cu.formulationid left join medc_stock.medc_mainstock stks on stks.drugproductid = stk.drugproductid\r\n"
			+ "where  stk.CompanyRefID=?1 and stk.BranchRefID =?2 and    stk. LocName =?3 and   stk.LocRefID=?4  and stk.status=0\r\n"
			+ "group  by   stk.DrugProductID HAVING SUM(stk.Qty) < stk.MinQty", nativeQuery = true)
	List GetMinQty(Integer cid, Integer bid, Integer lname, Integer lrefid);

	@Query(value = "SELECT  pr.productdrugid,pr.brandname,coalesce(stk.packageunit,''),COALESCE(stk.boxqty,0),COALESCE(stk.stripqty,0),COALESCE(stk.tabletqty,0),COALESCE(stk.boxperstrip,0),COALESCE(stk.strippertablet,1)\r\n"
			+ "FROM medc_productmaster.medc_custproductmaster pr left join medc_stock.medc_mainstock stk on stk.drugproductid = pr.productdrugid\r\n"
			+ "where  pr.companyid =?1 and pr.branchid =?2 and pr.locname =?3 and pr.locrefid=?4 and drugstatus = 1  ", nativeQuery = true)
	List GetNewproduct(Integer cid, Integer bid, Integer lname, Integer lrefid);

	@Query(value = "SELECT pm.brandname,st.drugproductid,st.abc,st.minqty,st.maxqty,st.qty,st.packageunit,COALESCE(st.boxqty,0),COALESCE(st.stripqty,0),COALESCE(st.tabletqty,0),COALESCE(st.boxperstrip,0),COALESCE(st.strippertablet,1) FROM medc_stock.medc_mainstock st\r\n"
			+ "inner join medc_productmaster.medc_custproductmaster pm on pm.productdrugid=st.drugproductid where st.companyrefid = ?1 and st.branchrefid = ?2 and st.locname = ?3 and st.locrefid = ?4 having qty = 0", nativeQuery = true)
	List GetZerostockproduct(Integer cid, Integer bid, Integer lname, Integer lrefid);

	@Query(value = "SELECT s.shopname,brn.branchname,loc.locationname,cmp.companyname FROM medc_storereg.medc_shopinformation s\r\n"
			+ "left join medc_adminsecurity.medc_locationref loc on loc.id=s.locname\r\n"
			+ "left join medc_branchreg.medc_branchinfomation brn on brn.branchid=s.branchrefid\r\n"
			+ "left join medc_companyreg.medc_companyinfomation cmp on cmp.companyid=s.companyrefid\r\n"
			+ "where s.companyrefid=?1 and s.branchrefid=?2 and s.locname=?3 and s.locrefid=?4", nativeQuery = true)
	List veiwnamedetails(Integer comp, Integer brnch, Integer locname, Integer locrefid);

}
