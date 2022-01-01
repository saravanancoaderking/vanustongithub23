package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.ManualPrescription;

@SuppressWarnings("rawtypes")
@Repository
public interface ManualPrescriptionRepository extends JpaRepository<ManualPrescription, Long> {

	@Query(value = "SELECT patientid , patientfirstname FROM medc_patientreg.medc_patientbasicinfo where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4 ", nativeQuery = true)
	List getpatientid(int comid, int branchid, int locname, int lorefid);

	@Query(value = "SELECT  mobile,gender FROM medc_patientreg.medc_patientbasicinfo WHERE patientid =?1 AND companyrefid =?2 AND branchrefid =?3 AND locname =?4 AND locrefid =?5 ", nativeQuery = true)
	List padetails(int pid, int comid, int branchid, int locname, int locrefid);

	@Query(value = "SELECT doctorid,doctorname FROM medc_doctorreg.doctorregistration WHERE companyrefid =?1 AND branchrefid =?2 AND locname =?3 AND locrefid =?4", nativeQuery = true)
	List doctorsname(int comid, int branchid, int locname, int locrefid);

	@Query(value = "SELECT employeeid, empfirstname FROM medc_employee.medc_employeedetails WHERE companyid =?1 AND branchid =?2 AND locname=?3 AND locrefid=?4", nativeQuery = true)
	List employees(int comid, int branchid, int locname, int locrefid);

	@Query(value = "SELECT prod.productdrugid,prod.brandname,prod.genericnamedosage,prod.generic_name,form.formulationname FROM medc_productmaster.medc_custproductmaster prod INNER JOIN medc_productmaster.medc_formulation form ON form.formulationid = prod.formulationid WHERE prod.productdrugid =?1", nativeQuery = true)
	List getprescprod(int prodid);

	
	@Query (value = "SELECT salesordertypeid,sotypename FROM medc_sales.medc_saleordertype" ,nativeQuery = true )
	List getordtype();
	
	
	
	
	
	// Boopalan 071119
	@Query(value = "select prescription_image from medc_prescription.medc_manualprescription where prescription_id=?1 ", nativeQuery = true)
	String getsendImage(@Param("id") int id);

	
	// Raja2011
		@Query(value = "SELECT emp_sign FROM medc_employee.medc_employeedetails WHERE employeeid =?1", nativeQuery = true)
		String getempsignImage(@Param("id") int id);

	// Boopalan 071119
	@Modifying
	@Transactional
	@Query(value = "update medc_prescription.medc_manualprescription set prescription_image =?1  where CompanyrefID =?2 and BranchrefID=?3 and LocName=?4 and locrefid =?5 and presc_no =?6  ", nativeQuery = true)
	int prescriptionpath(@Param("file") String file, @Param("companyid") int companyid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("presc_no") String presc_no);

	//Raja1112
//	@Modifying
//	@Transactional
//	@Query(value = "update medc_prescription.medc_manualprescription set sign_image =?1  where CompanyrefID =?2 and BranchrefID=?3 and LocName=?4 and locrefid =?5 and presc_no =?6   ", nativeQuery = true)
//	int signimagepath(@Param("file") String file, @Param("companyid") int companyid, @Param("branchid") int branchid,
//			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("presc_no") String presc_no);

	
	
	
	@Query(value = "SELECT mp.prescription_id,mp.presc_no,pd.patientfirstname,pd.mobile, sot.sotypename,ed.empfirstname FROM medc_prescription.medc_manualprescription mp LEFT JOIN medc_patientreg.medc_patientbasicinfo pd ON pd.patientid = mp.patient_id LEFT JOIN medc_sales.medc_saleordertype sot ON sot.salesordertypeid = mp.salesordertypeid LEFT JOIN medc_employee.medc_employeedetails ed ON ed.employeeid = mp.employee_id  WHERE mp.companyrefid =:comid AND mp.branchrefid =:branchid AND mp.locname =:locname AND mp.locrefid =:locrefid",nativeQuery = true)
	List viewprescdetails( @Param("comid") int comid, @Param("branchid") int branchid, @Param("locname") int locname, @Param("locrefid") int locrefid);
	
}