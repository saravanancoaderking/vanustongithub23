package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Picking;

@SuppressWarnings("rawtypes")
@Repository
public interface PickingRepository extends JpaRepository<Picking, Long> {

	@Query(value = "SELECT so.orderid,so.salesorderno FROM (medc_sales.medc_salesorder so,medc_sales.medc_salesmaintenance sm) where sm.CompanyRefID =:cid and sm.BranchRefID =:bid and sm.LocName=:locname and sm.LocRefID =:locrefid and sm.salesorderrefid = so.orderid and sm.pickingflag = 0  and sm.picflag=0 order by so.orderid desc", nativeQuery = true)
	List getPLsalesorder(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT m.SalesBillID,m.SalesBillNo,sot.salesordertypeid,sot.sotypename,pbi.PatientID, pbi.PatientCode, concat(pbi.PatientFirstName,\"  \",pbi.PatientLastName) as name, coalesce(pbi.Mobile, pbi.Phone,'NA') as contact,so.orderdate, so.salesorderno FROM (medc_sales.medc_salesmaintenance m,medc_sales.medc_salesorder so) "
			+ " inner join medc_sales.medc_saleordertype sot on sot.salesordertypeid = so.sotype "
			+ " inner join medc_patientreg.medc_patientbasicinfo pbi on pbi.PatientID = m.customerrefid "
			+ " where  m.salesorderrefid =:soid and m.salesorderrefid=so.orderid  and m.pickingflag= 0 ", nativeQuery = true)
	List getPLSOdetails(@Param("soid") int soid);

	@Query(value = "SELECT concat(m.`EmpFirstName`,'  -  ', m.`EmployeeCode`), m.`EmployeeID` FROM medc_employee.medc_employeedetails m where m.`CompanyID` =:cid and  m.`BranchID` =:bid and  m.`LocName` =:locname and m.`LocRefID` =:locrefid", nativeQuery = true)
	List getPlEmpdetails(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	/** METHOD FOR LOADING VALUES TO GRID FOR GIVEN SALES INVOICE NUMBER **/
	@Query(value = "SELECT m.`DrugProductID`,cpm.brandname,cpm.genericnamedosage,fm.formulationname,  m.`BatchName`, m.`ExpiryDate`,m.`indvqty`,(ms.qty),m.batchrefid FROM medc_sales.medc_salesbill m  inner join medc_productmaster.medc_custproductmaster cpm on cpm.productdrugid = m.DrugProductID inner join medc_productmaster.medc_formulation fm on fm.formulationid = cpm.formulationid inner join medc_stock.medc_mainstock ms on ms.StockID = m.stkmainrefid where m.salesrefid = ?1 group by m.SalesPrdtID ", nativeQuery = true)
	List getPLSIproducts(Integer sid);

	@Modifying
	@Transactional
	@Query(value = "update  medc_sales.medc_salesorder  set   salesstatus=3  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4 and orderid=?5 ", nativeQuery = true)
	int updatestatus(int Companyrefid, int Branchrefid, int LocName, int LocRefID, int orderid);

	/** METHOD FOR GETTING LIST OF PICKINGPRODUCTS **/
	@Query(value = "SELECT   m.Picklistno, sm.salesbillno, so.salesorderno,date(so.clientcdate), sm.TotalQty,concat(pbi.patientfirstname,' ',pbi.patientlastname) as cutomername,coalesce(pbi.Mobile, pbi.Phone) as custcontact,ed.EmpFirstName, ed.EmployeeCode,m.PicklistID,COALESCE(m.status,0) ,so.orderid,concat(ed.EmpFirstName,'  -  ', ed.EmployeeCode) as empnamesort,concat(ed.EmpFirstName,'  -  ', ed.EmployeeCode) as empnameapproval FROM medc_deliveryprocess.medc_picking m INNER join medc_sales.medc_salesmaintenance sm on sm.salesbillid = m.salesinvoiceno \r\n" + 
			"inner join medc_sales.medc_salesorder so on so.orderid = sm.salesorderrefid left join medc_patientreg.medc_patientbasicinfo pbi on pbi.PatientID = sm.CustomerRefID left join medc_employee.medc_employeedetails ed on ed.EmployeeID = m.emprefid where  m.CompanyRefID = :cid and m.BranchRefID= :bid and  m.LocName= :locname and m.LocRefID= :locrefid order by m.PicklistID desc;", nativeQuery = true)
	List getPickListAll(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Modifying
	@Transactional
	@Query(value = "update medc_deliveryprocess.medc_picking set emprefidsort =?1,status =?2 where picklistid =?3", nativeQuery = true)
	void updatefielddata(int emprefid, int status, int pickid);

	@Modifying
	@Transactional
	@Query(value = "update medc_deliveryprocess.medc_picking set emprefidapproval =?1,status =?2 where picklistid =?3", nativeQuery = true)
	void updatefielddata1(int emprefid, int status, int pickid);

	// Boopalan 200919 - For saving data medc_status.medc_salesordertrack
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_status.medc_salesordertrack (salesorderrefid, statusid, statusdate)VALUES (?1, ?2, ?3);", nativeQuery = true)
	Integer save_medc_salesordertrack(@Param("salesorderrefid") int salesorderrefid, @Param("statusid") int statusid,
			@Param("medc_salesordertrack_statusdate") String medc_salesordertrack_statusdate);

	@Modifying
	@Transactional
	@Query(value = "update medc_sales.medc_salesmaintenance  set   picflag=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4 and salesbillid=?5 ", nativeQuery = true)
	int updatepicstatus(int Companyrefid, int Branchrefid, int LocName, int LocRefID, int billid);

	@Query(value = "SELECT (IFNULL(COUNT(PicklistID),0)+1) as pickid FROM medc_deliveryprocess.medc_picking WHERE CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID=?4", nativeQuery = true)
	Integer getLastPickid(Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid);
}
