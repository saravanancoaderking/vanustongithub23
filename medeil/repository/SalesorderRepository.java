/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Salesorder;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface SalesorderRepository extends JpaRepository<Salesorder, Long> {

	@Query(value = "SELECT ProductDrugID,CONCAT(BrandName, '_', GenericNameDosage) as BrandNames FROM medc_productmaster.medc_custproductmaster "
			+ "WHERE companyID= :cid and BrandName LIKE  :data%  order by ProductDrugID", nativeQuery = true)
	List searchProduct(@Param("data") String data, @Param("cid") int cid);

	@Query(value = "SELECT pi.BrandName,CONCAT(pi.GenericNameDosage,coalesce(UOM,'')) as dosage,fr.FormulationName,pi.ProductDrugID,pi.GenericNameDosage,fr.FormulationID FROM medc_productmaster.medc_custproductmaster pi "
			+ "INNER JOIN medc_productmaster.medc_formulation fr ON fr.FormulationID=pi.FormulationID "
			+ "WHERE pi.ProductDrugID= :productid and fr.Status=0", nativeQuery = true)
	List getProductdata(@Param("productid") int productid);

	@Query(value = "SELECT PatientID,PatientFirstName FROM  medc_patientreg.medc_patientbasicinfo WHERE status=0 and  LocName= :locname and  LocRefID= :locrefid", nativeQuery = true)
	List patientList(@Param("locrefid") int locrefid, @Param("locname") int locname);

	@Query(value = "SELECT pi.BrandName,CONCAT(pi.GenericNameDosage,coalesce(pi.UOM,''))as dosage,fr.FormulationName,pt.PatientFirstName,DATE_FORMAT(so.OrderDate,'%Y-%m-%d')as dates,sr.TotalQty FROM medc_sales.medc_salesorder so "
			+ "INNER JOIN medc_sales.medc_salesordprd sr ON so.OrderID=sr.SalesOrderRefID	"
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pi ON pi.ProductDrugID=sr.DrugProductID	"
			+ "INNER JOIN medc_productmaster.medc_formulation fr ON fr.FormulationID=pi.FormulationID "
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pt ON pt.PatientID=so.PatientID	"
			+ "WHERE fr.Status=0 and so.status=0 and sr.status=0 and so.OrderID= :drugid  order by so.OrderID desc", nativeQuery = true)
	List viewSalesOrder(@Param("drugid") int drugid);

	@Query(value = "SELECT max(OrderID) as id FROM medc_sales.medc_salesorder WHERE status=0 and CompanyRefID= ?1 and  BranchRefID= ?2 and  LocName= ?3 and  LocRefID= ?4", nativeQuery = true)
	Integer getMaID(int cid, int bid, int lname,int lid);

	@Query(value = "SELECT so.SalesOrderNo,pi.PatientFirstName,DATE_FORMAT(so.OrderDate,'%Y-%m-%d') as dates,DeliveryType,so.totalitem,so.OrderID,so.SOOnlineNo,so.SOStatus,so.onlineorderstatus,sotypename,pi.patientcode "
			+ "FROM medc_sales.medc_salesorder so INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.PatientID=so.PatientID "
			+ "INNER JOIN medc_sales.medc_saleordertype sot ON sot.salesordertypeid=so.sotype "
			+ "WHERE pi.status=0 and so.status=0 and so.CompanyRefID= :cid and so.BranchRefID= :bid and so.LocName= :locname and so.LocRefID= :locrefid order by so.orderid desc", nativeQuery = true)
	List getAll(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);
	
	@Query(value = "SELECT so.SalesOrderNo,pi.PatientFirstName,DATE_FORMAT(so.OrderDate,'%Y-%m-%d') as dates,DeliveryType,so.totalitem,so.OrderID,so.SOOnlineNo,so.SOStatus,so.onlineorderstatus,sotypename,pi.patientcode "
			+ "FROM medc_sales.medc_salesorder so INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.PatientID=so.PatientID "
			+ "INNER JOIN medc_sales.medc_saleordertype sot ON sot.salesordertypeid=so.sotype "
			+ "WHERE pi.status=0 and so.status=0 and so.CompanyRefID= :cid and so.BranchRefID= :bid and so.LocName= :locname and so.LocRefID= :locrefid and so.sotype=2 order by so.orderid desc", nativeQuery = true)
	List getomnisalesAll(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname);

	@Modifying
	@Transactional
	@Query(value = "update  medc_sales.medc_salesorder  set   salesstatus=2  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4 and orderid=?5 ", nativeQuery = true)
	int updatestatus(int Companyrefid, int Branchrefid, Double LocName, Double LocRefID, int orderid);

	/** EDIT SALES ORDER */
	Salesorder findById(Integer id);

	@Query(value = "SELECT pi.BrandName,CONCAT(pi.GenericNameDosage,coalesce(pi.UOM,''))as dosage,fr.FormulationName,so.BoxQty,so.StripQty,so.tabletQty,so.TotalQty,so.DrugProductID FROM medc_sales.medc_salesordprd so "
			+ "INNER JOIN medc_sales.medc_salesorder sr ON sr.OrderID=so.SalesOrderRefID "
			+ "INNER JOIN medc_productmaster.medc_custproductmaster pi ON pi.ProductDrugID=so.DrugProductID "
			+ "INNER JOIN medc_productmaster.medc_formulation fr ON fr.FormulationID=pi.FormulationID "
			+ "WHERE  so.SalesOrderRefID= :id and fr.Status=0 and so.Status=0 and sr.status=0", nativeQuery = true)
	List editSalesRecord(@Param("id") int id);

	/* Get sales Order Type */ /* Boo */
	@Query(value = "SELECT SalesOrderTypeID, SOTypeName FROM medc_sales.medc_saleordertype WHERE status=0", nativeQuery = true)
	List getsalesOrderType();

	/** DELETE SALES ORDER */ // Boo
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_sales.medc_salesorder t1 JOIN medc_sales.medc_salesordprd t2 ON t1.orderid =:soid AND t2.salesorderrefid =:soid SET t1.status = 1,t2.status = 1", nativeQuery = true)
	int deleteSalesOrder(@Param("soid") int soid);

	@Query(value = "SELECT Patientid,patientfirstname FROM medc_patientreg.medc_patientbasicinfo where patientfirstname LIKE :data%  and companyrefid =:cid and branchrefid =:bid and locname =:locname and locrefid =:locrefid", nativeQuery = true)
	List CustomerSearch(@Param("data") String data, @Param("cid") int cid, @Param("bid") int bid,
			@Param("locname") int locname, @Param("locrefid") int locrefid);

	@Query(value = "Select pa.Patientid,pa.patientfirstname,pa.mobile,pa.email,sa.salesorderno,sa.orderdate,sa.totalitem,sa.sotype,sa.orderid FROM medc_patientreg.medc_patientbasicinfo pa left join medc_sales.medc_salesorder sa on sa.patientid=pa.Patientid where pa.patientid =:data  and sa.companyrefid =:cid and sa.branchrefid =:bid and sa.locname =:locname and sa.locrefid =:locrefid", nativeQuery = true)
	List CustsalesOrder(@Param("data") int data, @Param("cid") int cid, @Param("bid") int bid,
			@Param("locname") int locname, @Param("locrefid") int locrefid);

	@Query(value = "SELECT salesstatus FROM medc_sales.medc_salesorder where orderid =:data  and companyrefid =:cid and branchrefid =:bid and locname =:locname and locrefid =:locrefid", nativeQuery = true)
	List CustsalesOrderstatus(@Param("data") int data, @Param("cid") int cid, @Param("bid") int bid,
			@Param("locname") int locname, @Param("locrefid") int locrefid);

	// Kishore 140919
	@Query(value = "SELECT m.`OrderID`, m.`PatientID`, m.`OrderDate`, m.`SalesOrderNo`,  m.`Totalitem`, m.`SalesStatus`,concat( pbi.`PatientFirstName`,' ', pbi.`PatientLastName`), pbi.`Mobile`, pbi.`Email`,pbi.patientcode FROM medc_sales.medc_salesorder m\r\n"
			+ "inner join medc_patientreg.medc_patientbasicinfo pbi on pbi.PatientID=m.PatientID where\r\n" + "\r\n"
			+ "m.`CompanyRefID`=?1 and m.`BranchRefID`=?2 and  m.`LocName`=?3 and  m.`LocRefID`=?4", nativeQuery = true)
	List getAllList(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	// Boopalan 200919 - For saving data medc_status.medc_salesordertrack
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_status.medc_salesordertrack (salesorderrefid, statusid, statusdate)VALUES (?1, ?2, ?3);", nativeQuery = true)
	Integer save_medc_salesordertrack(@Param("salesorderrefid") int salesorderrefid, @Param("statusid") int statusid,
			@Param("medc_salesordertrack_statusdate") String medc_salesordertrack_statusdate);

	// Boopalan 210919
	// //cast(concat(time(m.statusdate),TIME_FORMAT(m.statusdate,\"%p\"))as char) as
	// Time
	@Query(value = "SELECT (SELECT max(statusid) FROM medc_status.medc_salesordertrack  where salesorderrefid =?1)as id,so.comment,date(m.statusdate)as Date,cast(concat(TIME_FORMAT(time(m.statusdate),\"%h:%i:%s %p\"))as char) as Time  FROM medc_status.medc_salesordertrack m inner join medc_status.medc_sonline so on so.statusid = m.statusid where m.salesorderrefid =?1 order by m.statusid asc", nativeQuery = true)
	List getSalesOrderRefIDDetails(@Param("soid") int soid);

	@Query(value = "select concat(p.PatientFirstName,' ',p.PatientLastName) as custname,p.mobile,s.salesorderno,s.orderdate from medc_sales.medc_salesorder s left join medc_patientreg.medc_patientbasicinfo p on p.patientid=s.patientid where s.CompanyRefID= :cid and  s.BranchRefID= :bid and  s.LocName= :locname and s.LocRefID= :locrefid and s.orderid= :orderid", nativeQuery = true)
	List getCusttrack(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("orderid") int orderid);

	@Query(value = "select sp.DrugProductID,c.brandname,sp.totalqty from medc_sales.medc_salesordprd sp left join medc_productmaster.medc_custproductmaster c on c.productdrugid=sp.DrugProductID inner join  medc_sales.medc_salesorder so on so.orderid=sp.salesorderrefid  where so.CompanyRefID= :cid and  so.BranchRefID= :bid and  so.LocName= :locname and so.LocRefID= :locrefid and so.orderid= :orderid", nativeQuery = true)
	List viewsalesorder(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("orderid") int orderid);

	@Query(value = "Select pa.Patientid,pa.patientfirstname,pa.mobile,pa.email,sa.salesorderno,sa.orderdate,sa.totalitem,sa.sotype,sa.orderid FROM medc_patientreg.medc_patientbasicinfo pa left join medc_sales.medc_salesorder sa on sa.patientid=pa.Patientid where pa.mobile =:data  and sa.companyrefid =:cid and sa.branchrefid =:bid and sa.locname =:locname and sa.locrefid =:locrefid", nativeQuery = true)
	List custsalesOrdermobile(@Param("data") int data, @Param("cid") int cid, @Param("bid") int bid,
			@Param("locname") int locname, @Param("locrefid") int locrefid);

	@Modifying
	@Transactional
	@Query(value = "update medc_sales.medc_salesorderlead set sostatus=1 where "
			+ " orderid=?1", nativeQuery = true)
	void updateleadsostatus(Integer salesleadno);

}
