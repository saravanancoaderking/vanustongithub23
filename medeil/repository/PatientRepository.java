package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	//Patient save(Patient cust);

	Patient findById(int id);
	
	Patient findByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = "insert into  medc_patientreg.medc_patienthealthcodn  (  LocName,LocRefID , PatientRefID, HealthCodnID  ) values ( ?1,?2,?3,?4   )", nativeQuery = true)
	int savehealthcds(int lcrnm, int lcrid, int cust_code, int patient_health_conditions);

	@Transactional
	@Modifying
	@Query(value = "insert into medc_patientreg.medc_patientallergies  ( LocName,LocRefID , PatientRefID, AllergicRefID  ) values ( ?1,?2,?3,?4 )", nativeQuery = true)
	int saveallergies(int lcrnm, int lcrid, int cust_code, int patient_allergies);

	@Transactional
	@Modifying
	@Query(value = "insert into medc_patientreg.medc_allergieslist  ( LocName,LocRefID , AllergicName  ) values ( ?1,?2,?3  )", nativeQuery = true)
	int saveIndvAllergies(int lcrnm, int lcrid, String allrgy);

	@Transactional
	@Modifying
	@Query(value = "insert into medc_patientreg.medc_healthcondlist (  LocName,LocRefID , HealthConditionName ) values ( ?1,?2,?3 )", nativeQuery = true)
	int saveIndvHealthcds(int lcrnm, int lcrid, String hlth);

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_country  ", nativeQuery = true)
	List viewCountry();

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_state  where CountryId=?1  ", nativeQuery = true)
	List viewState(int name);

	@Query(value = "SELECT * FROM  medc_fixedsettings.medc_city  where StateID=?1 ", nativeQuery = true)
	List viewCity(int name);

	@Query(value = "  SELECT * FROM medc_patientreg.medc_patientbasicinfo      where  LocName=?1 and LocRefID=?2  and   Status=0  order by  PatientID desc", nativeQuery = true)
	List viewPatients(int lcrnm, int lcrid);

	@Query(value = "  SELECT * FROM medc_patientreg.medc_patientbasicinfo where PatientID=?3  and  LocName=?1 and LocRefID=?2 and status=1  ", nativeQuery = true)
	List viewPatient(int lcrnm, int lcrid, int pt);

	@Query(value = "SELECT   doctorid,doctorname FROM medc_doctorreg.doctorregistration     where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	List viewDoctor(int lcrnm, int lcrid);

	@Query(value = "SELECT   DISTINCT country FROM state   ", nativeQuery = true)
	List viewDepartment(int lcrnm, int lcrid);

	@Query(value = "SELECT * FROM medc_patientreg.medc_allergieslist     where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewAllergies(int lcrnm, int lcrid);

	@Query(value = "SELECT * FROM medc_patientreg.medc_healthcondlist     where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	List viewHealthcds(int lcrnm, int lcrid);

	@Query(value = "SELECT     IFNULL( MAX( PatientID ),0 )  FROM medc_patientreg.medc_patientbasicinfo     where  LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	Double viewPatientId(Double lcrnm, Integer lcrid);

	@Query(value = " SELECT       IFNULL( RIGHT( patientno, 7 ),0 )   FROM   medc_patientreg.medc_patientbasicinfo   where  PatientID=?3  and     LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewPatientIncNo(Double lcrnm, Integer lcrid, Double id);

	@Query(value = "SELECT  IFNULL( MAX( InPatientID ),0 )  FROM medc_patientreg.medc_inpatienteeg     where  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int viewPatientInOutId(int lcrnm, int lcrid);

	@Query(value = "  SELECT     IFNULL( RIGHT( doctor_id, 7 ),0 )   FROM   medc_whstock.medc_whstockreceive   where  WhStkRecID=?1   and    LocName=?1 and LocRefID=?2 ", nativeQuery = true)
	Double viewPatientInOutIncNo(int lcrnm, int lcrid);

	@Query(value = "SELECT cust_code FROM cust_information where   cust_name=?3  and     LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewCustcode(int lcrnm, int lcrid, String name);

	@Modifying
	@Transactional
	@Query(value = "update    medc_patientreg.medc_patientbasicinfo  set   Status=5  where  PatientID=?3 and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deletePatient(int lcrnm, int lcrid, int id);

	@Modifying
	@Transactional
	@Query(value = "update    medc_accounts.medc_sales  set   Status=5  where  SalesID=?3 and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deletePtDetails(int lcrnm, int lcrid, int id);

	// selva
	@Query(value = "SELECT patientid,concat(PatientFirstName,'_',mobile)as patientname FROM medc_patientreg.medc_patientbasicinfo WHERE companyrefid=:compid and branchrefid=:branchid and locname=:locname and locrefid=:locrefid and status=0 ", nativeQuery = true)
	List Customerinfo(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	/********* Edit State **************/
	// Boopalan 020419
	@Query(value = "SELECT stateid,statename FROM medc_fixedsettings.medc_state  where stateid = :id ", nativeQuery = true)
	public List editCusState(@Param("id") Integer id);

	/********* Edit City **************/
	// Boopalan 020419
	@Query(value = "SELECT m.CityID, m.CityName FROM medc_fixedsettings.medc_city m where m.CityID =:id ", nativeQuery = true)
	public List editCusCity(@Param("id") Integer id);

	@Query(value = "SELECT m.`PatientID`, concat(m.`PatientFirstName`,' ', m.`PatientLastName`), m.`Email`,m.refillcus FROM medc_patientreg.medc_patientbasicinfo m where m.`PatientID` =?1 ", nativeQuery = true)
	public List getcustemail(@Param("id") Integer id);

	@Query(value = "SELECT pt.patientfirstname ,pt.patientid FROM medc_patientbasicinfo pt group by pt.patientfirstname" ,nativeQuery = true)
	public List getcustdetail();
	
	//SIVAKUMAR  For Patient Code
		 @Query(value="Select coalesce(MAX(patientcode),'CUST000000000') from medc_patientreg.medc_patientbasicinfo where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4",nativeQuery = true)
			String lastPatientCode(int cid, int bid, Double double1, Integer double2);
	
	
	@Query(value = "SELECT pt.patientfirstname ,pt.patientid ,pt.mobile FROM medc_patientreg.medc_patientbasicinfo pt where pt.companyrefid = :cid and pt.branchrefid = :bid\r\n" + 
			"and locname = :lcname and locrefid = :lcrefid group by pt.patientfirstname" ,nativeQuery = true)
	public List getcustdetail(@Param("cid") Integer cid,@Param("bid") Integer bid,@Param("lcname") Integer lcname,@Param("lcrefid") Integer lcrefid);
	
	@Query(value = "SELECT pt.patientid ,pt.mobile,pt.patientfirstname FROM medc_patientreg.medc_patientbasicinfo pt WHERE pt.patientid = :patid", nativeQuery = true)
	public List getpatcontact(@Param("patid") Integer patid);

	
	@Query(value = "select b.patientfirstname,b.mobile,b.gender,b.address1,b.patientlastname,b.dob,b.email from medc_patientreg.medc_patientbasicinfo b "
			+"WHERE b.CompanyRefID=:cid and b.BranchRefID=:bid and  b.LocName=:locname and b.LocRefID=:locrefid and b.PatientID=:patientid LIMIT 1",nativeQuery = true)
	List paitentdetails(@Param("cid")Integer cid,@Param("bid") Integer bid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid, @Param("patientid")Integer patientid);

	@Query(value = "SELECT sm.salesbillid,sm.salesbillno,sm.billdate,sm.customerrefid,sm.refilldays,pr.patientfirstname FROM medc_sales.medc_salesmaintenance sm\r\n" + 
			"Inner Join medc_patientreg.medc_patientbasicinfo pr on pr.PatientID=sm.Customerrefid\r\n" + 
			"where sm.companyrefid=:cid and sm.branchrefid=:bid and sm.locname=:lname and sm.locrefid=:lid and sm.refillcust=1 and Date(ADDDATE(sm.createddate,INTERVAL sm.refilldays Day))=CURDATE()",nativeQuery = true)
	List RefillAlerts(int cid, int bid, int lname, int lid);

	@Query(value = "SELECT PatientID,PatientCode,PatientFirstName,Gender,DOB,age,Mobile,Phone,Email,Address1,Address2,country,state,city,pincode,previousbalance FROM medc_patientreg.medc_patientbasicinfo\r\n" + 
			"where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4 and refillcustomer=1",nativeQuery = true)
	List GetAllRefillCustomers(int cid, int bid, int lname, int lid);

	//Customer Membership Raja
	void findByIdAndCompanyrefidAndBranchrefidAndLocnameAndLocrefid(int id, Integer companyrefid, Integer branchrefid,
			Double locname, Integer locrefid);

	@Query(value = "SELECT patienttypetid,customercategory  FROM medc_patientreg.medc_patientcategorytype  WHERE CompanyRefID=?1 and BranchRefID=?2 and LocName=?3 and LocRefID=?4", nativeQuery = true)
	List getCustomerCategory(Integer cid, Integer bid, Integer lname, Integer lrefid);

}
