package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.PatientLogin;
import com.medeil.domain.PatientLoginSalesorder;


@SuppressWarnings("rawtypes")
@Repository
public interface PatientLoginRepository extends JpaRepository<PatientLogin,Long> {
	public static final PatientLoginSalesorder salesorder = new PatientLoginSalesorder();
	@Modifying
	@Transactional
	@Query(value = "update medc_prescription.medc_manualprescription set prescription_image =?1  where CompanyrefID =?2 and BranchrefID=?3 and LocName=?4 and locrefid =?5 and presc_no =?6  ", nativeQuery = true)
	int prescriptionpath(@Param("file") String file, @Param("companyid") int companyid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("presc_no") String presc_no);

	@Query(value = "SELECT mp.prescription_id,mp.presc_no,pd.patientfirstname,pd.mobile, sot.sotypename,ed.empfirstname FROM medc_prescription.medc_manualprescription mp LEFT JOIN medc_patientreg.medc_patientbasicinfo pd ON pd.patientid = mp.patient_id LEFT JOIN medc_sales.medc_saleordertype sot ON sot.salesordertypeid = mp.salesordertypeid LEFT JOIN medc_employee.medc_employeedetails ed ON ed.employeeid = mp.employee_id  WHERE mp.companyrefid =:comid AND mp.branchrefid =:branchid AND mp.locname =:locname AND mp.locrefid =:locrefid AND mp.patient_id =:patient_id",nativeQuery = true)
	List viewprescdetails( @Param("comid") int comid, @Param("branchid") int branchid, @Param("locname") int locname, @Param("locrefid") int locrefid,@Param("patient_id")int patient_id);

	@Query(value = "select b.patientfirstname,b.mobile,b.gender,b.address1 from medc_patientreg.medc_patientbasicinfo b inner join\r\n" + 
			"medc_prescription.medc_manualprescription a on a.patient_id=b.PatientID WHERE a.CompanyRefID=:cid and a.BranchRefID=:bid and  a.LocName=:locname and a.LocRefID=:locrefid and a.patient_id=:patientid LIMIT 1",nativeQuery = true)
	List paitentdetails(@Param("cid")Integer cid,@Param("bid") Integer bid,@Param("locname") Integer locname,@Param("locrefid") Integer locrefid, @Param("patientid")Integer patientid);

	@Query(value = "SELECT createddate  FROM medc_adminsecurity.medc_plan WHERE planid=?1", nativeQuery = true)
	String getdate(Integer trialplanid);
	
	@Query(value = "SELECT intervalid FROM medc_adminsecurity.medc_plan WHERE planid=?1", nativeQuery = true)
	Integer getinterval(Integer trialplanid);

	@Query(value = "SELECT periodname FROM medc_adminsecurity.medc_plan WHERE planid=?1", nativeQuery = true)
	String getplandays(Integer trialplanid);

	@Query(value = "SELECT rl.RoleID FROM medc_adminsecurity.medc_plan fp "
			+ "INNER JOIN medc_adminsecurity.medc_role rl on rl.editionrefid=fp.editionid "
			+ "WHERE fp.planid=?1 GROUP BY rl.RoleID", nativeQuery = true)
	Integer getroleid(Integer trialplanid);
	
	@Query(value = "SELECT editionid FROM medc_adminsecurity.medc_plan  WHERE planid=?1 GROUP BY editionid", nativeQuery = true)
	Integer geteditionid(Integer trialplanid);

	@Query(value = "SELECT ModuleID from medc_adminsecurity.medc_rolectrl WHERE Roleid=:eid group by ModuleID", nativeQuery = true)
	List getmodulelist(@Param("eid") Integer eid);

	@Query(value = "SELECT SubModuleID from medc_adminsecurity.medc_rolectrl WHERE Roleid=:eid group by SubModuleID", nativeQuery = true)
	List getsubmoduleref(@Param("eid") Integer eid);
	
	@Query(value = "SELECT ModuleID  from medc_adminsecurity.medc_rolectrl  WHERE SubModuleID=:sm group by SubModuleID", nativeQuery = true)
	Integer getmoduleid(@Param("sm") Object sm);
	
	@Query(value = "SELECT COUNT(PatientID) FROM medc_patientreg.medc_patientbasicinfo WHERE CompanyRefID=?1", nativeQuery = true)
		Integer getId(Integer companyrefid);

	@Query( value = "SELECT keyid FROM medc_razorpay.razor_apikey WHERE keymode=1", nativeQuery = true )
	String getusername();

	@Query( value = "SELECT keysecret FROM medc_razorpay.razor_apikey WHERE keymode=1", nativeQuery = true )
	String getpassword();

	
	@Modifying
	@Transactional
	@Query( value = "INSERT INTO medc_checkmymedicine.medc_payment_link(paymentcustid,entity,receipt,invoice_number,customer_id,custpayid,custname,custemail,custcontact,gstin,billing_address,shipping_address,customer_name,customer_email,customer_contact,order_id,payment_id,paystatus,expire_by,issued_at,paid_at,cancelled_at,expired_at,sms_status,email_status,date,terms,partial_payment,gross_amount,tax_amount,taxable_amount,amount,amount_paid,amount_due,currency,description,commentdes,short_url,view_less,billing_start,billing_end,type,group_taxes_discounts,created_at,companyid,branchid,locname,locrefid,customerid) "
			+ " VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20,?21,?22,?23,?24,?25,?26,?27,?28,?29,?30,?31,?32,?33,?34,?35,?36,?37,?38,?39,?40,?41,?42,?43,?44,?45,?46,?47,?48,?49)", nativeQuery = true )
	void paymentlink(String id, String entity, String receipt, String invoice_number, String custid, String custpayid,
			String name, String email, String contact, String gstin, String billing_address, String shipping_address,
			String customer_name, String customer_email, String customer_contact, String order_id, Integer payment_id,
			String paystatus, Integer expire_by, Integer issued_at, Integer paid_at, Integer cancelled_at,
			String expired_at, String sms_status, String email_status, Integer date, String terms,
			String partial_payment, Integer gross_amount, Integer tax_amount, Integer taxable_amount, Integer amount,
			Integer amount_paid, Integer amount_due, String currency, String description, String comment,
			String short_url, String view_less, String billing_start, String billing_end, String type,
			String group_taxes_discounts, String created_at, Integer companyid, Integer branchid, Integer locname,
			Integer locrefid, Integer customerid);

	@Query( value = "SELECT companyid FROM medc_adminsecurity.medc_userlogin WHERE UserName=:email", nativeQuery = true )
	Integer getcompanyid(@Param("email")String email);
	
	@Query( value = "SELECT Customerid FROM medc_adminsecurity.medc_userlogin WHERE UserName=:email", nativeQuery = true )
		Integer getcustomerid(@Param("email")String email);

	@Query( value = "SELECT IFNULL(0,sum(vancalculationamt)) as crite FROM  medc_sales.medc_salesmaintenance WHERE CustomerRefID=:custid", nativeQuery = true )
	Integer getcriteamount(@Param("custid")String custid);

	@Modifying
	@Transactional
	@Query( value = "INSERT INTO medc_checkmymedicine.medc_custpayment(customerid,razorpaycustomerid,paymentid,amtpaid,razorpaycal,vanustoncal,vanustontax,shopamt,shopbalance,status,companyid,branchid,locname,locrefid)"
			+ " VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14)", nativeQuery = true )
	void updatecustomerpay(Integer customerid, String custid, Integer payment_id, Double amounts, Double razorpaycal,
			Double vanustoncal, Double vanusttax, Double shopamt, Integer shopbalance, String paystatus,
			Integer companyid, Integer branchid, Integer locname, Integer locrefid);

	
	@Query( value = "SELECT short_url FROM medc_checkmymedicine.medc_payment_link WHERE customerid=:cusid ORDER BY paymentid DESC LIMIT 1", nativeQuery = true )
	List getcustomerpaylink(@Param("cusid")Integer cusid);

		
}
