/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Prescdigitalization;

/**
 * @author www
 **/

@SuppressWarnings("rawtypes")
@Repository
public interface PrescdigiRepository extends JpaRepository<Prescdigitalization, Long> {

	@Query(value = "select OrderID,SalesOrderNo FROM medc_sales.medc_salesorderlead where prescription_order=1 and CompanyRefID= :cid and BranchRefID= :bid and LocRefID= :locrefid and LocName= :locname and prescstatus=0", nativeQuery = true)
	List getsalesoder(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("locrefid") Integer locrefid,
			@Param("locname") Integer locname);

	@Query(value = "SELECT pr.ProductDrugID,CONCAT(pr.BrandName, '_', pr.GenericNameDosage,' _ ',coalesce(sum(ms.qty),0)) as BrandNames FROM medc_productmaster.medc_custproductmaster pr\r\n"
			+ "left join medc_stock.medc_mainstock ms on ms.drugproductid = pr.ProductDrugID WHERE pr.BrandName like :val% and pr.companyID= :cid group by ProductDrugID;\r\n", nativeQuery = true)
	List getproduct(@Param("val") String val, @Param("cid") int cid);

	@Query(value = "SELECT pr.ProductDrugID,pr.BrandName FROM medc_productmaster.medc_custproductmaster pr "
			+ "WHERE  pr.companyid= :compid and pr.ProductDrugID= :brandid", nativeQuery = true)
	List getproduct1(@Param("compid") int compid, @Param("brandid") int brandid);

	@Query(value = "select l.pictureurl,concat(p.patientfirstname,'',p.patientlastname)as patientname,p.gender,l.patientid FROM medc_sales.medc_salesorderlead l left join medc_patientreg.medc_patientbasicinfo p on p.patientid=l.patientid\r\n"
			+ "where l.orderid= :orderid", nativeQuery = true)
	List getsalesoderdetail(@Param("orderid") Integer orderid);
	
	@Query(value = "select concat(p.patientfirstname,'',p.patientlastname)as patientname,p.gender,p.mobile, l.patientid, l.salesorderno, l.sotype, l.type FROM medc_sales.medc_salesorderlead l left join medc_patientreg.medc_patientbasicinfo p on p.patientid=l.patientid\r\n"
			+ "where l.orderid= :orderid", nativeQuery = true)
	List getomnisalesoderdetail(@Param("orderid") Integer orderid);


	@Query(value = "SELECT MAX(PdigitalizedID) as PdigitalizedID  FROM medc_sales.medc_prescription_digitization WHERE CompanyRefID= :cid and BranchRefID= :bid and  LocName= :locname and LocRefID= :locrefid", nativeQuery = true)
	int selectmaxpri(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	/** METHOD FOR GETTING LIST OF EMPLOYEES **/
	@Query(value = "SELECT concat(m.`EmpFirstName`,'  -  ', m.`EmployeeCode`), m.`EmployeeID` FROM medc_employee.medc_employeedetails m where m.`CompanyID` =:cid and  m.`BranchID` =:bid and  m.`LocName` =:locname and m.`LocRefID` =:locrefid", nativeQuery = true)
	List getPlEmpdetails(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT PdigitalizedID, PdigitalizedNo FROM medc_sales.medc_prescription_digitization where  CompanyRefID= :cid and BranchRefID= :bid and LocRefID= :locrefid and LocName= :locname and checstatus=0", nativeQuery = true)
	List getprescdigino(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("locname") Integer locname,
			@Param("locrefid") Integer locrefid);

	@Query(value = "SELECT m.Salesorderid, m.Patientname, m.doctorname, m.age, m.gender, m.remarks, m.emprefid,concat(e.EmpFirstName,' ',e.EmpLastName) as employeename,m.imageurl,m.patientid FROM medc_sales.medc_prescription_digitization m left join medc_employee.medc_employeedetails e on e.EmployeeID=m.emprefid  where  m.CompanyRefID= :cid and m.BranchRefID= :bid and m.LocRefID= :locrefid and m.LocName= :locname and m.PdigitalizedID= :prescdigino", nativeQuery = true)
	List getprescdata(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("locname") Integer locname,
			@Param("locrefid") Integer locrefid, @Param("prescdigino") Integer prescdigino);

	@Query(value = "SELECT  m.DrugProductID ,m.qty, m.days, m.morning, m.afternoon, m.evening, m.night, m.food,c.BrandName FROM medc_sales.medc_prescriptiondigiproduct m left join medc_productmaster.medc_custproductmaster c on c.ProductDrugID=m.DrugProductID  where  m.CompanyRefID= :cid and m.BranchRefID= :bid and m.LocRefID= :locrefid and m.LocName= :locname and m.Pdigitalizedrefid= :prescdigino", nativeQuery = true)
	List getprescprod(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("locname") Integer locname,
			@Param("locrefid") Integer locrefid, @Param("prescdigino") Integer prescdigino);

	@Modifying
	@Transactional
	@Query(value = "update medc_sales.medc_prescription_digitization set checstatus=1 , emprefid =?1 , approvsts=?3 where PdigitalizedID =?2", nativeQuery = true)
	void updatefielddata(int emprefid, int packid, int approv);

	@Modifying
	@Transactional
	@Query(value = "delete from medc_sales.medc_prescriptiondigiproduct WHERE Pdigitalizedrefid= :poid and CompanyRefID= :compid and BranchRefID= :branchid and LocName= :locname and LocRefID= :locrefid ", nativeQuery = true)
	void deletePoProduct(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("poid") int poid);

	@Query(value = "SELECT PdigitalizedID, PdigitalizedNo FROM medc_sales.medc_prescription_digitization where  CompanyRefID= :cid and BranchRefID= :bid and LocRefID= :locrefid and LocName= :locname and checstatus=1 and approvsts = 0", nativeQuery = true)
	List getprescdiginoappr(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("locname") Integer locname,
			@Param("locrefid") Integer locrefid);

	// rejection order
	@Modifying
	@Transactional
	@Query(value = "update medc_sales.medc_salesorderlead set prescstatus=2 where CompanyRefID= :cid and BranchRefID= :bid and LocRefID= :locrefid and LocName= :locname and OrderID= :orderid", nativeQuery = true)
	int rejectorder(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("locname") Integer locname,
			@Param("locrefid") Integer locrefid, @Param("orderid") Integer orderid);

	@Modifying
	@Transactional
	@Query(value = "update medc_sales.medc_salesorderlead set prescstatus=1 where CompanyRefID= :cid and BranchRefID= :bid and LocRefID= :locrefid and LocName= :locname and OrderID= :orderid", nativeQuery = true)
	void setstatus(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("locname") Integer locname,
			@Param("locrefid") Integer locrefid, @Param("orderid") Integer orderid);

	@Query("Select coalesce(MAX(pdigitalizedno),'PRS000000000') from Prescdigitalization where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4")
	String lastpdigitalizedno(int cid, int bid, int locname, int locrefid);

	@Query(value = "SELECT DrugProductID,flagid FROM medc_sales.medc_presstockvalidateprd where flagid>0", nativeQuery = true)
	Integer[][] drugidprescvalidate();

	@Query(value = "SELECT DrugProductID FROM medc_sales.medc_presstockvalidateprd where flagid>0", nativeQuery = true)
	List countprescvalidate();

	@Query(value = "select COALESCE(p.PdigitalizedNo,'NA'),COALESCE(s.SalesOrderNo,'NA'),pb.patientfirstname,COALESCE(concat(e.empfirstname,' ',e.emplastname),'NA') as empname,COALESCE(p.checstatus,2),COALESCE(p.approvsts,2),s.prescription_order,COALESCE(p.pdigitalizedid,0),COALESCE(s.orderid,0),pb.patientcode\r\n"
			+ "			from (medc_sales.medc_prescription_digitization p)\r\n"
			+ "			right join medc_sales.medc_salesorderlead s on s.OrderID=p.Salesorderid\r\n"
			+ "			left join medc_employee.medc_employeedetails e on e.employeeID=p.emprefid\r\n"
			+ "      inner join medc_patientreg.medc_patientbasicinfo pb on pb.patientid = s.patientid\r\n"
			+ "			where s.CompanyRefID=:cid and  s.BranchRefID=:bid and s.LocName=:locname and s.LocRefID=:locrefid and s.prescription_order = 1 order by s.SalesOrderNo desc", nativeQuery = true)
	List viewpresc(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("locname") Integer locname,
			@Param("locrefid") Integer locrefid);
	
	@Query(value = "select pg.pdigitalizedid,sol.salesorderno,pb.patientfirstname,concat(emp.empfirstname,'',emp.emplastname) as empname\r\n" + 
			"from Prescdigitalization pg\r\n" + 
			"inner join SalesorderLead sol on sol.id = pg.salesorderid\r\n" + 
			"inner join Patient pb on pb.id = pg.patientid\r\n" + 
			"inner join Employee emp on emp.id  = pg.emprefid\r\n" + 
			"where pg.checstatus = 1 and pg.approvsts = 1 and pg.companyrefid = :cid and pg.branchrefid = :bid and pg.locname = :locname and pg.locrefid = :locrefid")
	Page getprescriptionhistory(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("locname") Integer locname,
			@Param("locrefid") Integer locrefid,@Param("page") Pageable page);
}
