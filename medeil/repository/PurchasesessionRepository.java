/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Purchasesession;

/**
 * @author Ajith AK
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface PurchasesessionRepository extends JpaRepository<Purchasesession, Long> {

	@Query(value = "SELECT CompanyID,CompanyName FROM medc_companyreg.medc_companyinfomation WHERE CompanyID= :compid", nativeQuery = true)
	List getSessionCompany(@Param("compid") int compid);

	@Query(value = "SELECT BranchID,Branchname FROM medc_branchreg.medc_branchinfomation WHERE  CompanyRefID= :cid", nativeQuery = true)
	List getSessionBranch(@Param("cid") int cid);

	@Query(value = "SELECT ShopID,ShopName FROM medc_storereg.medc_shopinformation WHERE companyrefid= :cid and branchrefid= :bid", nativeQuery = true)
	List getSessionShop(@Param("cid") int cid, @Param("bid") int bid);

	@Query(value = "SELECT warehouseID,Warehousename FROM medc_warehousereg.medc_warehouseinfo WHERE  CompanyID= :cid and BranchID= :bid", nativeQuery = true)
	List getSessionWarehouse(@Param("cid") int cid, @Param("bid") int bid);

	@Query(value = "SELECT HospitalID,HospitalName FROM medc_hospitalreg.hospitalregistration WHERE CompanyRefID= :cid and BranchRefID= :bid", nativeQuery = true)
	List getSessionHospital(@Param("cid") int cid, @Param("bid") int bid);

	@Query(value = "SELECT pm.BrandName,st.WaitingBoxQty,st.WaitingStripQty,st.WaitingTabQty,st.WaitingTotalQty FROM medc_indentmaster.medc_whindentreq  ir RIGHT JOIN  medc_whstock.medc_whstktrfproduct1 st  ON  ir.WHIndentReqID=st.IndentRefID RIGHT JOIN medc_productmaster.medc_custproductmaster pm ON st.DrugProductRefID=pm.ProductDrugID WHERE (ir.FromName='shop' and (ir.FromDept= :ss)) or (ir.FromName='warehouse' and (ir.FromDept= :ww) or (ir.FromName='hosp' and (ir.FromDept= :hh)))", nativeQuery = true)
	List<Object> getpurcSessionTable(@Param("ss") int ss, @Param("ww") int ww, @Param("hh") int hh);

	/*
	 * / Boopalan 030419, ROD 230519
	 * 
	 * @Query(value =
	 * "SELECT inq.IndentNo,DATE_FORMAT(inq.clientcdate,'%Y-%m-%d') as IndentDate,lc.LocationName,inq.IndentReqID,pr.BrandName, st.WaitingBoxQty,st.WaitingStripQty,st.WaitingTabQty,st.WaitingTotalQty,(st.DrugProductRefID * 1) as DrugProductRefID,ShopName FROM medc_indentmaster.medc_indentreq inq "
	 * +
	 * "INNER JOIN medc_stock.medc_stktrfproduct st ON inq.IndentReqID=st.IndentRefID "
	 * +
	 * "INNER JOIN medc_productmaster.medc_custproductmaster pr ON st.DrugProductRefID=pr.ProductDrugID "
	 * +
	 * "INNER JOIN medc_adminsecurity.medc_locationref lc ON lc.id=inq.LocName INNER JOIN medc_storereg.medc_shopinformation si ON si.ShopID=inq.FromLocRefID "
	 * +
	 * "WHERE inq.status=0 and inq.LocName= :locname and inq.ToLocRefID= :locrefid and inq.FromLocRefID= :id"
	 * , nativeQuery = true) List getpurcSessionShop(@Param("id") int
	 * id, @Param("locname") int locname, @Param("locrefid") int locrefid);
	 */

	// Boopalan 030419, ROD 230519, RO 290519
	@Query(value = "SELECT inq.IndentNo,DATE_FORMAT(inq.clientcdate,'%Y-%m-%d') as IndentDate,lc.LocationName,inq.IndentReqID,concat(pr.BrandName,' ',pr.genericnamedosage), st.WaitingBoxQty,st.WaitingStripQty,st.WaitingTabQty,st.WaitingTotalQty,(st.DrugProductRefID * 1) as DrugProductRefID,ShopName,st.boxconvdrg,st.stripconvdrg,irp.packageunit FROM medc_indentmaster.medc_indentreq inq "
			+ " INNER JOIN medc_indentmaster.medc_indentproduct irp ON irp.IndentRefID=inq.IndentReqID INNER JOIN medc_stock.medc_stktrfproduct st ON inq.IndentReqID=st.IndentRefID "
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON st.DrugProductRefID=pr.ProductDrugID "
			+ "INNER JOIN medc_adminsecurity.medc_locationref lc ON lc.id=inq.LocName INNER JOIN medc_storereg.medc_shopinformation si ON si.ShopID=inq.FromLocRefID "
			+ "WHERE irp.stktransflag=0 and irp.DrugPrdRefID=DrugProductRefID and inq.ToLocRefID= :locrefid and inq.FromLocRefID= :id and st.psflag=0 group by IndentPrdID  ", nativeQuery = true)
	List getpurcSessionShop(@Param("id") int id, @Param("locrefid") int locrefid);

	@Query(value = "SELECT inq.IndentNo,DATE_FORMAT(inq.IndentDate,'%Y-%m-%d') as IndentDate,lc.LocationName,inq.IndentReqID,pr.BrandName, st.WaitingBoxQty,st.WaitingStripQty,st.WaitingTabQty,st.WaitingTotalQty,(st.DrugProductRefID * 1) as DrugProductRefID FROM medc_indentmaster.medc_indentreq inq "
			+ "INNER JOIN medc_stock.medc_stktrfproduct st ON inq.IndentReqID=st.IndentRefID "
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON st.DrugProductRefID=pr.ProductDrugID "
			+ "INNER JOIN medc_adminsecurity.medc_locationref lc ON lc.id=inq.LocName "
			+ "WHERE inq.status=2 and inq.CompanyRefID= :cid and inq.LocName= :locname and inq.ToLocRefID= :locrefid and inq.FromLocRefID= :id", nativeQuery = true)
	List getpurcSessionWarehouse(@Param("id") int id, @Param("cid") int cid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT inq.IndentNo,DATE_FORMAT(inq.IndentDate,'%Y-%m-%d') as IndentDate,lc.LocationName,inq.IndentReqID,pr.BrandName, st.WaitingBoxQty,st.WaitingStripQty,st.WaitingTabQty,st.WaitingTotalQty,(st.DrugProductRefID * 1) as DrugProductRefID FROM medc_indentmaster.medc_indentreq inq "
			+ "INNER JOIN medc_stock.medc_stktrfproduct st ON inq.IndentReqID=st.IndentRefID "
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON st.DrugProductRefID=pr.ProductDrugID "
			+ "INNER JOIN medc_adminsecurity.medc_locationref lc ON lc.id=inq.LocName "
			+ "WHERE inq.status=2 and st.psflag=1 and inq.CompanyRefID= :cid and inq.LocName= :locname and inq.ToLocRefID= :locrefid and inq.FromLocRefID= :id", nativeQuery = true)
	List getpurcSessionHosp(@Param("id") int id, @Param("cid") int cid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT pm.BrandName,st.WaitingBoxQty,st.WaitingStripQty,st.WaitingTabQty,st.WaitingTotalQty FROM medc_indentmaster.medc_indentreq ir "
			+ "INNER JOIN medc_stock.medc_stktrfproduct st ON ir.IndentReqID=st.IndentRefID "
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pm ON st.DrugProductRefID=pm.ProductDrugID "
			+ "WHERE ir.Status=0 and  ir.IndentReqID= :id", nativeQuery = true)
	List getpurcSessionView(@Param("id") int id);

	@Query(value = "SELECT MAX(PurcSessionID) as id FROM medc_purchase.medc_purchasesession "
			+ "WHERE status=0 and CompanyRefID= :cid and BranchRefID= :bid and LocName= :locname and LocRefID= :locrefid", nativeQuery = true)
	Integer getmaxSession(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT PurcSessionNo, PucSessionDate,Status,PurcSessionID FROM medc_purchase.medc_purchasesession WHERE CompanyRefID= :cid and  BranchRefID= :bid and  LocName= :locname and  LocRefID= :locrefid", nativeQuery = true)
	List getViewSessiontable(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT pr.BrandName,pi.BoxQty, pi.StripQty, pi.TabletQty, pi.TotalQty FROM medc_purchase.medc_purcsessionproduct pi INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=pi.DrugProductID  INNER JOIN medc_purchase.medc_purchasesession ps ON pi.PurcsessionRefID=ps.PurcSessionID WHERE pi.PurcsessionRefID= :id", nativeQuery = true)
	List getSessionDetails(@Param("id") int id);

	@Query(value = "SELECT COUNT(PurcSessionNo) as totSession,(SELECT COUNT(STATUS) FROM medc_purchase.medc_purchasesession WHERE STATUS=0) as pending,(SELECT COUNT(STATUS) FROM medc_purchase.medc_purchasesession WHERE STATUS=2) as closes FROM medc_purchase.medc_purchasesession", nativeQuery = true)
	List getChartdata();

	@Query(value = "SELECT p.PurcSessionNo,p.PucSessionDate,pr.ProductDrugID,pr.BrandName,ps.BoxQty,ps.StripQty,ps.TabletQty,ps.TotalQty,ps.status FROM medc_purchase.medc_purcsessionproduct ps "
			+ "INNER JOIN medc_purchase.medc_purchasesession p ON p.PurcSessionID=ps.PurcSessionRefID "
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=ps.DrugProductID "
			+ "WHERE pr.DrugStatus=0 and p.status=0 and p.CompanyRefID= :cid and p.BranchRefID= :bid and p.LocName= :locname and p.LocRefID= :locrefid  order by  p.PurcSessionNo desc", nativeQuery = true)
	List getSessionAll(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);
	
	 @Query(value = "SELECT sm.stkminno,DATE_FORMAT(sm.clientcdate1,'%Y-%m-%d') AS stkmindate,lc.LocationName,sm.stkminid ,CONCAT(pr.BrandName,' ',pr.genericnamedosage) AS proname,0,1,2,sm.qty,(sm.drugproductid * 1) AS DrugProductRefID1,si.ShopName\r\n" + 
				"FROM medc_stock.medc_stockminqty sm\r\n" + 
				"LEFT JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID=sm.drugproductid\r\n" + 
				"LEFT JOIN medc_adminsecurity.medc_locationref lc ON lc.id=sm.LocName\r\n" + 
				"LEFT JOIN medc_storereg.medc_shopinformation si ON si.ShopID=sm.LocRefID\r\n" + 
				"WHERE sm.companyrefid = :companyrefid AND sm.branchrefid = :branchrefid AND sm.locname= :locname AND sm.locrefid= :id",nativeQuery = true)
		List getpurcSessionhqShopdata(@Param("id") int id,@Param("locname") int locname,@Param("companyrefid") int companyrefid,@Param("branchrefid") int branchrefid);

	@Query(value = "SELECT inq.IndentNo,DATE_FORMAT(inq.clientcdate,'%Y-%m-%d') as IndentDate,lc.LocationName,inq.IndentReqID,concat(pr.BrandName,' ',pr.genericnamedosage),irp.boxqty,irp.stripqty,irp.tabqty,irp.qty,irp.DrugPrdrefID,shopname,irp.boxconvdrg,irp.stripconvdrg,irp.packageunit FROM medc_indentmaster.medc_indentreq inq inner JOIN\r\n" + 
			"medc_indentmaster.medc_indentproduct irp ON irp.IndentRefID=inq.IndentReqID inner JOIN medc_adminsecurity.medc_locationref lc ON lc.id=inq.LocName INNER JOIN medc_storereg.medc_shopinformation si ON si.ShopID=inq.FromLocRefID left JOIN medc_productmaster.medc_custproductmaster pr ON pr.ProductDrugID = irp.DrugPrdrefID \r\n" + 
			"INNER JOIN medc_stock.medc_mainstock ms ON ms.DrugProductID=pr.ProductDrugID\r\n" + 
			"where inq.ToLocRefID=?1 and inq.FromLocRefID=?2 and irp.stktransflag=0 and ms.Qty<=0 group by IndentPrdID", nativeQuery = true)
	 List getpurcSessionnonwaiting(int sid, int locrefid);
	 

}
