package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Packing;

@SuppressWarnings("rawtypes")
@Repository
public interface PackingRepository extends JpaRepository<Packing, Long> {
	@Query(value = "select dpp.salesinvoiceno,sm.salesbillno,dpp.salesorderrefid,so.salesorderno,pm.patientid,concat(pm.patientfirstname,' ',pm.patientlastname) as custname,so.orderdate,dpp.sotype,sot.sotypename,dpp.picklistno,coalesce(pm.Mobile, pm.Phone,'NA') as contact,pm.patientcode "
			+ "from medc_deliveryprocess.medc_picking dpp inner join medc_sales.medc_salesorder so on so.orderid = dpp.salesorderrefid "
			+ "inner join medc_sales.medc_salesmaintenance sm on sm.salesbillid = dpp.salesinvoiceno inner join medc_sales.medc_saleordertype sot on sot.salesordertypeid = dpp.sotype "
			+ "inner join medc_patientreg.medc_patientbasicinfo pm on pm.patientid = dpp.custrefid where dpp.companyrefid =?1 and dpp.branchrefid =?2 and dpp.locname =?3 and dpp.locrefid =?4 and dpp.picklistid =?5", nativeQuery = true)
	List packingdata(int Companyrefid, int Branchrefid, int LocName, int LocRefID, int pickid);

	@Query(value = "select dpps.drugproductrefid,pr.brandname,fr.FormulationName,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue,db.batchno,dpps.qty,date(dpps.expirydate) as expirydate,dpps.batchrefid,dpps.shelfno,dpps.blockno,dpps.rackno,dpps.availqty,dpps.pickedqty,dpps.returnqty,dpps.invoiceqty,dpps.remarks "
			+ "from medc_deliveryprocess.medc_picking_productdetails dpps "
			+ "inner join medc_productmaster.medc_custproductmaster pr on dpps.drugproductrefid = pr.productdrugid "
			+ "inner join medc_productmaster.medc_formulation fr on pr.formulationid = fr.formulationid "
			+ "inner join medc_stock.medc_drugbatch db on db.batchid = dpps.batchrefid "
			+ "where dpps.companyrefid =?1 and dpps.branchrefid =?2 and dpps.locname =?3 and dpps.locrefid =?4 and dpps.picklistrefid =?5", nativeQuery = true)
	List packingfielddata(int Companyrefid, int Branchrefid, int LocName, int LocRefID, int pickid);

	@Query(value = "select picklistid,picklistno from medc_deliveryprocess.medc_picking where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4  and pacflag=0 order by picklistid desc", nativeQuery = true)
	List picklist(int Companyrefid, int Branchrefid, int LocName, int LocRefID);

	@Query(value = "select Pack_materila,Package_size from medc_deliveryprocess.medc_packagematerial where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4 and Pack_materila =?5 and Package_size =?6", nativeQuery = true)
	List exitpackmaterial(int Companyrefid, int Branchrefid, int LocName, int LocRefID, String packmat, Double size);

	@Query(value = "delete from medc_deliveryprocess.medc_packagematerial where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4 and Pack_materila =?5 and Package_size =?6", nativeQuery = true)
	void deletepackmaterial(int Companyrefid, int Branchrefid, int LocName, int LocRefID, String packmat, Double size);

	@Modifying
	@Transactional
	@Query(value = "update  medc_sales.medc_salesorder  set   salesstatus=4  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4 and orderid=?5 ", nativeQuery = true)
	void updatestatus(int Companyrefid, int Branchrefid, int LocName, int LocRefID, int orderid);

	@Query(value = "SELECT   m.`packingno`, sm.`salesbillno`, so.salesorderno,date(so.clientcdate), pic.`totalprod`, concat(pbi.patientfirstname,' ',\r\n" + 
			"			pbi.patientlastname) as cutomername,coalesce(pbi.`Mobile`, pbi.`Phone`) as custcontact, ed.`EmpFirstName`, ed.`EmployeeCode`,\r\n" + 
			"			 m.`packingautoid`,pic.`picklistid`,COALESCE(m.status,0), concat(ed1.`EmpFirstName`,'  -  ', ed1.`EmployeeCode`) as empname1, concat(ed2.`EmpFirstName`,'  -  ', ed2.`EmployeeCode`) as empname2,pic.status\r\n" + 
			"			FROM medc_deliveryprocess.medc_packing m\r\n" + 
			"			right join medc_sales.medc_salesmaintenance sm on sm.salesbillid = m.salesinvoiceno\r\n" + 
			"			inner join medc_sales.medc_salesorder so on so.orderid = sm.salesorderrefid\r\n" + 
			"			left join medc_patientreg.medc_patientbasicinfo pbi on pbi.PatientID = m.custrefid\r\n" + 
			"			inner join medc_deliveryprocess.medc_picking pic on pic.salesorderrefid = so.orderid\r\n" + 
			"			left join medc_employee.medc_employeedetails ed on ed.EmployeeID = m.emprefid\r\n" + 
			"			left join medc_employee.medc_employeedetails ed1 on ed1.EmployeeID = m.emprefidwrap\r\n" + 
			"			left join medc_employee.medc_employeedetails ed2 on ed2.EmployeeID = m.emprefidlabel\r\n" + 
			"			where  pic.`CompanyRefID` =?1 and pic.`BranchRefID`=?2 and  pic.`LocName`=?3 and pic.`LocRefID`=?4 and pic.status=3 order by picklistid desc;", nativeQuery = true)
	List packlist(int Companyrefid, int Branchrefid, int LocName, int LocRefID);

	@Query(value = "select dpp.salesinvoiceno,sm.salesbillno,dpp.salesorderrefid,so.salesorderno,pm.patientid,concat(pm.patientfirstname,' ',pm.patientlastname) as custname,so.orderdate,dpp.sotypeid,sot.sotypename,dpp.packingno "
			+ "from medc_deliveryprocess.medc_packing dpp "
			+ "inner join medc_sales.medc_salesorder so on so.orderid = dpp.salesorderrefid "
			+ "inner join medc_sales.medc_salesmaintenance sm on sm.salesbillid = dpp.salesinvoiceno "
			+ "inner join medc_sales.medc_saleordertype sot on sot.salesordertypeid = dpp.sotypeid "
			+ "inner join medc_patientreg.medc_patientbasicinfo pm on pm.patientid = dpp.custrefid "
			+ "where dpp.companyrefid =?1 and dpp.branchrefid =?2 and dpp.locname =?3 and dpp.locrefid =?4 and dpp.packingautoid =?5", nativeQuery = true)
	List checkpackingdata(int Companyrefid, int Branchrefid, int LocName, int LocRefID, int packid);

	@Query(value = "select dpps.drugproductrefid,pr.brandname,fr.FormulationName,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue,db.batchno,dpps.qty,date(dpps.expirydate),dpps.batchrefid,dpps.returnqty,dpps.remarks "
			+ "from medc_deliveryprocess.medc_package_productdetails dpps "
			+ "inner join medc_productmaster.medc_custproductmaster pr on dpps.drugproductrefid = pr.productdrugid "
			+ "inner join medc_productmaster.medc_formulation fr on pr.formulationid = fr.formulationid "
			+ "inner join medc_stock.medc_drugbatch db on db.batchid = dpps.batchrefid "
			+ "where dpps.companyrefid =?1 and dpps.branchrefid =?2 and dpps.locname =?3 and dpps.locrefid =?4 and dpps.packagerefid =?5", nativeQuery = true)
	List checkpackingfielddata(int Companyrefid, int Branchrefid, int LocName, int LocRefID, int packid);

	@Query(value = "select packingautoid,packingno from medc_deliveryprocess.medc_packing where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4", nativeQuery = true)
	List getpacklist(int Companyrefid, int Branchrefid, int LocName, int LocRefID);

	@Modifying
	@Transactional
	@Query(value = "update medc_deliveryprocess.medc_packing set emprefidwrap =?1,status =?2 where packingautoid =?3", nativeQuery = true)
	void updatefielddata(int emprefid, int status, int packid);

	@Modifying
	@Transactional
	@Query(value = "update medc_deliveryprocess.medc_packing set emprefidlabel =?1,status =?2 where packingautoid =?3", nativeQuery = true)
	void updatefielddata1(int emprefid, int status, int packid);

	@Query(value = "select picklistid,picklistno from medc_deliveryprocess.medc_picking where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4 and status =1 order by picklistid desc", nativeQuery = true)
	List checkedpicklist(int Companyrefid, int Branchrefid, int LocName, int LocRefID);

	@Query(value = "select packingautoid,packingno from medc_deliveryprocess.medc_packing where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4 and status =1", nativeQuery = true)
	List getapprovepacklist(int Companyrefid, int Branchrefid, int LocName, int LocRefID);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_status.medc_salesordertrack (salesorderrefid, statusid, statusdate)VALUES (?1, ?2, ?3)", nativeQuery = true)
	Integer save_medc_salesordertrack(@Param("salesorderrefid") int salesorderrefid, @Param("statusid") int statusid,
			@Param("medc_salesordertrack_statusdate") String medc_salesordertrack_statusdate);

	@Modifying
	@Transactional
	@Query(value = "update  medc_deliveryprocess.medc_picking  set   pacflag=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4 and salesinvoiceno=?5 ", nativeQuery = true)
	void updatepacstatus(int Companyrefid, int Branchrefid, int LocName, int LocRefID, int sino);

}
