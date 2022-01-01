package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.PatientLoginSalesorder;
import com.medeil.domain.Salesorder;

@SuppressWarnings("rawtypes")
@Repository
public interface PatientLoginSalesorderRepository extends JpaRepository<PatientLoginSalesorder, Long>{
	@Query(value = "SELECT ProductDrugID,CONCAT(BrandName, '_', GenericNameDosage) as BrandNames FROM medc_productmaster.medc_custproductmaster "
			+ "WHERE DrugStatus=0 and companyID= :cid and BrandName LIKE  :data%  order by ProductDrugID", nativeQuery = true)
	List searchProduct(@Param("data") String data, @Param("cid") int cid);
	
	@Query(value = "SELECT PatientID,PatientFirstName FROM  medc_patientreg.medc_patientbasicinfo WHERE status=0 and  LocName= :locname and  LocRefID= :locrefid", nativeQuery = true)
	List patientList(@Param("locrefid") int locrefid, @Param("locname") int locname);
	
	@Query(value = "SELECT pi.BrandName,CONCAT(pi.GenericNameDosage,coalesce(UOM,'')) as dosage,fr.FormulationName,pi.ProductDrugID,pi.GenericNameDosage,fr.FormulationID FROM medc_productmaster.medc_custproductmaster pi "
			+ "INNER JOIN medc_productmaster.medc_formulation fr ON fr.FormulationID=pi.FormulationID "
			+ "WHERE pi.ProductDrugID= :productid and pi.DrugStatus=0 and fr.Status=0", nativeQuery = true)
	List getProductdata(@Param("productid") int productid);
	
	@Query(value = "SELECT so.SalesOrderNo,pi.PatientFirstName,DATE_FORMAT(so.OrderDate,'%Y-%m-%d') as dates,DeliveryType,so.totalitem,so.OrderID,so.SOOnlineNo,so.SOStatus,so.onlineorderstatus,sotypename,pi.patientcode "
			+ "FROM medc_sales.medc_salesorder so INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.PatientID=so.PatientID "
			+ "INNER JOIN medc_sales.medc_saleordertype sot ON sot.salesordertypeid=so.sotype "
			+ "WHERE pi.status=0 and so.status=0 and so.CompanyRefID= :cid and so.BranchRefID= :bid and so.LocName= :locname and so.LocRefID= :locrefid and so.PatientID=:PatientID and  order by so.orderid desc", nativeQuery = true)
	List getAll(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,
			@Param("locname") int locname,@Param("PatientID")int PatientID);
	// Kishore 140919
	@Query(value = "SELECT m.`OrderID`, m.`PatientID`, m.`OrderDate`, m.`SalesOrderNo`,  m.`Totalitem`, m.`SalesStatus`,concat( pbi.`PatientFirstName`,' ', pbi.`PatientLastName`), pbi.`Mobile`, pbi.`Email`,pbi.patientcode FROM medc_sales.medc_salesorder m\r\n"
			+ "inner join medc_patientreg.medc_patientbasicinfo pbi on pbi.PatientID=m.PatientID where\r\n" + "\r\n"
			+ "m.`CompanyRefID`=?1 and m.`BranchRefID`=?2 and  m.`LocName`=?3 and  m.`LocRefID`=?4 and m.PatientID=?5", nativeQuery = true)
	List getAllList(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid,@Param("PatientID")int PatientID);
	
	@Query(value = "select concat(p.PatientFirstName,' ',p.PatientLastName) as custname,p.mobile,s.salesorderno,s.orderdate from medc_sales.medc_salesorder s left join medc_patientreg.medc_patientbasicinfo p on p.patientid=s.patientid where s.CompanyRefID= :cid and  s.BranchRefID= :bid and  s.LocName= :locname and s.LocRefID= :locrefid and s.PatientID= :patientid and s.orderid= :orderid", nativeQuery = true)
	List getCusttrack(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("patientid") int patientid,@Param("orderid") int orderid);

	@Query(value = "select sp.DrugProductID,c.brandname,sp.totalqty from medc_sales.medc_salesordprd sp left join medc_productmaster.medc_custproductmaster c on c.productdrugid=sp.DrugProductID inner join  medc_sales.medc_salesorder so on so.orderid=sp.salesorderrefid  where so.CompanyRefID= :cid and  so.BranchRefID= :bid and  so.LocName= :locname and so.LocRefID= :locrefid and so.PatientID=:patientid and so.orderid= :orderid", nativeQuery = true)
	List viewsalesorder(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid,@Param("patientid") int patientid, @Param("orderid") int orderid);

	/** EDIT SALES ORDER */
	PatientLoginSalesorder findById(Integer id);
	
	

	@Query(value = "SELECT max(OrderID) as id FROM medc_sales.medc_salesorder WHERE status=0 and CompanyRefID= :cid and  BranchRefID= :bid and  LocName= :locname and  LocRefID= :locrefid", nativeQuery = true)
	Integer getMaID(@Param("cid") int cid, @Param("bid") int bid, @Param("locrefid") int locrefid,@Param("locname") int locname);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_status.medc_salesordertrack (salesorderrefid, statusid, statusdate)VALUES (?1, ?2, ?3);", nativeQuery = true)
	Integer save_medc_salesordertrack(@Param("salesorderrefid") int salesorderrefid, @Param("statusid") int statusid,
			@Param("medc_salesordertrack_statusdate") String medc_salesordertrack_statusdate);

	
}
