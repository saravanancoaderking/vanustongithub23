
 package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.medeil.domain.UserActivity;



public interface UserActivityRepository extends JpaRepository<UserActivity, Long>{

	UserActivity findById(int id);
	UserActivity save(UserActivity ip);
	
	
	
	
	@Query(value = "SELECT adu.username,fixd.countryname, usa.formevent, usa.description,usa.clientcdate,\r\n" + 
			"usa.formentrytime, usa.formexittime,usa.browsertype,usa.ipaddress FROM medc_adminsecurity.medc_adduser adu\r\n" + 
			"inner join medc_adminsecurity.medc_useractivities usa on usa.userid = adu.cuserid\r\n" + 
			"inner join medc_fixedsettings.medc_country fixd on fixd.countryid = adu.countryrefid\r\n" + 
			"where usa.companyrefid = :cid and usa.branchrefid = :bid and usa.locname = :locid and usa.locrefid = :locreid", nativeQuery = true)
	public List getClientActivity(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid);
	
	
	@Query(value = "SELECT CONCAT (emd.EmpFirstName,' ',emd.EmpLastName) as EmployeeName,asu.usertype, aua.description,\r\n" + 
			"aua.clientcdate,aua.ipaddress, aua.browsertype,aua.ostype,aua.osversion, aua.apiname,  aua.createddate,\r\n" + 
			" aua.formsessiontime,aua.uaid, empd.departmentname ,aua.userid\r\n" + 
			" FROM medc_employee.medc_employeedetails emd\r\n" + 
			" inner join medc_adminsecurity.medc_userlogin asu on asu.EmpRefid = emd.EmployeeID\r\n" + 
			" inner join medc_adminsecurity.medc_useractivities aua on asu.SUserID =  aua.userid\r\n" + 
			" inner join medc_employee.medc_empdepartment empd on empd.deptid = emd.deptrefid\r\n" + 
			" where aua.companyrefid = :cid and aua.branchrefid = :bid and aua.locname = :locid and aua.locrefid = :locreid",  nativeQuery = true)
	public List getClientMonitoring(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid);
	
	
	@Query(value ="SELECT concat(empd.EmpFirstName,' ',empd.EmpLastName) as EmployeeName,  usl.usertype,\r\n" + 
			" usa.formevent,usa.browsertype,\r\n" + 
			"usa.ostype,usa.osversion,usa.description,usa.clientcdate,usa.formentrytime,usa.formexittime,usa.ipaddress,usa.apiname,usa.browserversion,"
			+ "usa.formsessiontime,shi.ownername,usa.userid  FROM medc_employee.medc_employeedetails empd\r\n" + 
			"inner join medc_adminsecurity.medc_useractivities usa on usa.LocRefID = empd.LocRefID\r\n" + 
			"inner join medc_storereg.medc_shopinformation shi on shi.shopid = usa.LocRefID\r\n" + 
			"inner join medc_adminsecurity.medc_userlogin usl on usl.SUserID = usa.userid\r\n" + 
			"where usa.companyrefid = :cid and usa.branchrefid= :bid and  usa.locname= :locid and  usa.locrefid=:locreid", nativeQuery = true)
	public List getuserAudit(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid);
	
	
	
	
	
	
	
	
	
	

	@Query(value = "SELECT egd1.EmployeeCode,CONCAT (egd1.EmpFirstName,' ',egd1.EmpLastName) as EmployeeName ,\r\n" + 
			"dept.departmentname, usa.formevent, usa.description, usa.clientcdate, usa.formentrytime, usa.formexittime,usa.formsessiontime \r\n" + 
			"FROM medc_adminsecurity.medc_useractivities usa\r\n" + 
			"inner join  medc_employee.medc_employeedetails egd1 on egd1.locrefid = usa.locrefid\r\n" + 
			"inner join medc_employee.medc_empdepartment dept on dept.deptid = egd1.deptrefid\r\n" + 
			"where usa.companyrefid =:cid and usa.branchrefid=:bid and  usa.locname=:locid and  usa.locrefid=:locreid",  nativeQuery = true)
	public List getEmployeeTracking(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid);
	
	
	
	
	
	
	
	@Query(value = "SELECT egd.EmployeeCode,CONCAT (egd.EmpFirstName,' ',egd.EmpLastName) as EmployeeName ,dept.departmentname, tsa.task_title, CONCAT(egd. EmpFirstName,' ',egd.EmpLastName) as Taskassignedby, CONCAT(egd1. EmpFirstName,' ',egd1.EmpLastName)as Taskassignedto,Date(tsa.task_start_date) as StartDate,Date(tsa.task_due_date) as EndDate,Date(tsa.completed_date) as CompleteDate,tks.task_status_name as TaskStatus,tsa.task_id	FROM medc_taskmanagement.medc_task_assignment tsa inner join  medc_taskmanagement.medc_task_status tks on tks.task_statusid = tsa.task_status_id inner join medc_employee.medc_employeedetails egd on egd.EmployeeID = tsa.task_assigned_by	inner join medc_employee.medc_employeedetails egd1 on egd1.EmployeeID = tsa.task_assigned_to inner join medc_employee.medc_empdepartment dept on dept.deptid = tsa. deptid inner join medc_employee.medc_employeedetails empd on empd.EmployeeID = tsa.employeeid where tsa.LocName =:locid and tsa.LocRefID  =:locreid and tsa.companyrefid = :cid and tsa.branchrefid  = :bid and tks.task_statusid= :getTaskStatus",  nativeQuery = true)
	public List getTaskStatus(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid, @Param("getTaskStatus") int getTaskStatus);

}

