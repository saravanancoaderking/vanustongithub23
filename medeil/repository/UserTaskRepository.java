package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.UserTask;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Long> {

//	@Modifying
//	@Transactional
//	@Query(value = "update  medc_taskmanagement.medc_task_assignment  set status=1  where  Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4 and orderid=?5 ", nativeQuery = true)
//	int updatestatus(int Companyrefid, int Branchrefid, int LocName, int LocRefID);

	@Query(value = "SELECT task_type_id, task_type_name FROM medc_taskmanagement.medc_task_type tkt WHERE tkt.companyrefid= :compid and tkt.branchrefid= :branchid  and tkt.locname= :locname  and tkt.locrefid= :locrefid", nativeQuery = true)
	List taskType(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT ta.task_id, ta.task_title FROM medc_taskmanagement.medc_task_assignment ta WHERE ta.companyrefid= :compid and ta.branchrefid= :branchid  and ta.locname= :locname  and ta.locrefid= :locrefid", nativeQuery = true)
	List getTaskTitle(int compid, int branchid, int locname, int locrefid);

	@Query(value = "SELECT EmployeeId, CONCAT(EmpFirstName,' ', EmpLastName)  FROM medc_employee.medc_employeedetails emd inner join medc_employee.medc_empsubdivision ems on ems.subdivisionid = emd.subdivisionid where emd.companyid= :compid and emd.branchid= :branchid  and emd.locname= :locname and emd.locrefid= :locrefid  and emd.subdivisionid = :subdivisionid", nativeQuery = true)
	List getEmployeeDrop(int compid, int branchid, int locname, int locrefid, int subdivisionid);

	@Query(value = "SELECT deptid,departmentname FROM medc_employee.medc_empdepartment WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid ", nativeQuery = true)
	List deptname(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT EmployeeId, CONCAT(EmpFirstName,' ', EmpLastName)  FROM medc_employee.medc_employeedetails emd inner join medc_employee.medc_empsubdivision ems on ems.subdivisionid = emd.subdivisionid where emd.companyid= :compid and emd.branchid= :branchid  and emd.locname= :locname and emd.locrefid= :locrefid  and emd.subdivisionid = :subdivisionid", nativeQuery = true)
	List getAssignEmployee(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("subdivisionid") int subdivisionid);

	@Query(value = "SELECT task_priority_id, task_priority_name FROM medc_taskmanagement.medc_task_priority tkp where tkp.companyrefid = :compid and  tkp.branchrefid = :branchid and  tkp.locname= :locname and tkp.locrefid = :locrefid", nativeQuery = true)
	List getTaskPriority(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT task_statusid,task_status_name   FROM medc_taskmanagement.medc_task_status tks where tks.companyrefid =:compid and  tks.branchrefid =:branchid and  tks.locname=:locname and tks.locrefid = :locrefid", nativeQuery = true)
	List getTaskStatus(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT tsa.task_status_id, Date(tsa.completed_date)as completed_date, tsa.task_id FROM medc_taskmanagement.medc_task_assignment tsa where tsa.companyrefid = ?1 and tsa.branchrefid = ?2 and tsa.locname = ?3 and tsa.locrefid = ?4 ORDER BY Date(tsa.completed_date) DESC LIMIT 50", nativeQuery = true)
	public List getTaskStatusBar(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid);

//	@Query(value = "SELECT tsa.task_status_name, tsa.employeeid FROM medc_taskmanagement.medc_task_assignment tsa where tsa.Companyrefid=:compid and  tsa.branchrefid =:branchid and  tsa.locname=:locname and tsa.locrefid = :locrefid and tsa.employeeid= :empid", nativeQuery = true)
//	List getTaskCount(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
//			@Param("locrefid") int locrefid, @Param("empid") int empid);

	@Query(value = "SELECT tsa.task_status_name, tsa.employeeid FROM medc_taskmanagement.medc_task_assignment tsa inner join medc_adminsecurity.medc_userlogin us on us.suserid = tsa.task_assigned_by where tsa.Companyrefid=:compid and tsa.branchrefid =:branchid and tsa.locname=:locname and tsa.locrefid = :locrefid and us.suserid = :empid", nativeQuery = true)
	List getTaskCount(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("empid") int empid);

	@Query(value = "SELECT tsa.task_priority_name, tsa.employeeid FROM medc_taskmanagement.medc_task_assignment tsa where tsa.Companyrefid=:compid and  tsa.branchrefid =:branchid and  tsa.locname=:locname and tsa.locrefid = :locrefid and tsa.task_assigned_by = :empid", nativeQuery = true)
	List getTaskPriority(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("empid") int empid);

	@Query(value = "SELECT tsa.priority_id, tsa.employeeid FROM medc_taskmanagement.medc_task_assignment tsa where tsa.Companyrefid=:compid and  tsa.branchrefid =:branchid and  tsa.locname=:locname and tsa.locrefid = :locrefid and tsa.employeeid= :empid", nativeQuery = true)
	List getPriorityBar(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("empid") int empid);

	@Query(value = "SELECT tka.task_id, tka.task_status_id, tka.completed_date FROM medc_taskmanagement.medc_task_assignment tka where YEAR(tka.completed_date) =YEAR(CURDATE()) and tka.companyrefid =:compid and tka.branchrefid =:branchid and tka.locname =:locname and tka.locrefid =:locrefid  and tka.employeeid =:empid", nativeQuery = true)
	List getTaskCompletedBar(@Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("empid") int empid);

	@Query(value = "SELECT tsa.task_number, tsa.task_title  FROM medc_taskmanagement.medc_task_assignment tsa where tsa.Companyrefid=:compid and  tsa.branchrefid =:branchid and  tsa.locname=:locname and tsa.locrefid = :locrefid", nativeQuery = true)
	List getNotificationinformation(@Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid);

	@Query(value = "SELECT ed.EmployeeCode,concat(ed.EmpFirstName,' ',ed.EmpLastName)as EmployeeName,ed.Department FROM medc_taskmanagement.medc_task_assignment aa INNER JOIN medc_employee.medc_employeedetails ed on ed.employeeid=aa.task_assigned_to where aa.companyrefid =?1 and aa.branchrefid =?2 and aa.locname =?3 and aa.locrefid =?4 and aa.task_id=?5", nativeQuery = true)
	List getEmpInfo(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("taskId") int taskId);

	@Query(value = "SELECT tsa.task_number,tsa.task_title,tpi.task_priority_name,tss.task_status_name,tsa.task_assigned_by, tsa.task_assigned_to,Date(tsa.task_start_date),Date(tsa.task_due_date),Date(tsa.completed_date) FROM medc_taskmanagement.medc_task_assignment tsa inner join medc_taskmanagement.medc_task_priority tpi on tpi.task_priority_id = tsa.priority_id inner join medc_taskmanagement.medc_task_status tss on tss.task_statusid = tsa.task_status_id inner join medc_employee.medc_employeedetails egd on egd.EmployeeID = tsa.employeeid inner join medc_employee.medc_empdepartment emd on emd.deptid = tsa.deptid where tsa.deptid= ?1 and tsa.EmployeeID = ?2 and tsa.priority_id= ?3  and tsa.task_status_id= ?4 and tsa.task_type_id = ?5 and tsa.companyrefid = ?6 and tsa.branchrefid = ?7  and tsa.locname = ?8 and tsa.locrefid = ?9", nativeQuery = true)
	List getTableValues(int deptid, int employeeid, String task_priority_name, String task_status_name,
			int task_type_id, int companyrefid, int branchrefid, int locname, int locrefid);

//	@Query(value = "SELECT tsa.task_number,tsa.task_title,tsa.task_priority_name,tsa.task_status_name, CONCAT(eds.EmpFirstName,' ', eds.EmpLastName) as task_assigned_by,\r\n" + 
//			"CONCAT(eds1.EmpFirstName,' ', eds1.EmpLastName) as  task_assigned_to, Date(tsa.task_start_date), Date(tsa.task_due_date),Date(tsa.completed_date),\r\n" + 
//			"tsa.colors, tsa.task_id FROM medc_taskmanagement.medc_task_assignment tsa\r\n" + 
//			"inner join medc_employee.medc_employeedetails eds on eds.EmployeeID = tsa.task_assigned_by\r\n" + 
//			"inner join medc_employee.medc_employeedetails eds1 on eds1.EmployeeID = tsa.task_assigned_to\r\n" + 
//			"inner join medc_employee.medc_empdepartment emd on emd.deptid = tsa.deptid\r\n" + 
//			"where  tsa.companyrefid = ?1 and tsa.branchrefid = ?2 and tsa.locname = ?3 and tsa.locrefid = ?4 and tsa.employeeid = ?5", nativeQuery = true)
//	public List viewUserTask(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
//			@Param("locreid") int locreid, @Param("employeeid") int employeeid);

	@Query(value = "SELECT tsa.task_number,tsa.task_title,tsa.task_priority_name,tsa.task_status_name, CONCAT(eds.EmpFirstName,' ', eds.EmpLastName) as task_assigned_by,CONCAT(eds.EmpFirstName,' ', eds.EmpLastName) as  task_assigned_to, Date(tsa.task_start_date), Date(tsa.task_due_date),Date(tsa.completed_date),tsa.colors, tsa.task_id FROM medc_taskmanagement.medc_task_assignment tsa \r\n" + 
			"inner join medc_adminsecurity.medc_userlogin us on us.EmpRefID = tsa.task_assigned_to \r\n" + 
			"inner join medc_employee.medc_employeedetails eds on eds.EmployeeID = tsa.task_assigned_to\r\n" + 
			"inner join medc_employee.medc_empdepartment emd on emd.deptid = tsa.deptid \r\n" + 
			"where us.suserid =?1", nativeQuery = true)
	public List viewUserTask(Integer suserid);

	@Query(value = "SELECT ed.EmployeeCode,concat(ed.EmpFirstName,' ',ed.EmpLastName)as EmployeeName,ed.Department, COUNT(aa.task_title) as taskcout FROM medc_taskmanagement.medc_task_assignment aa INNER JOIN medc_employee.medc_employeedetails ed on ed.employeeid=aa.employeeid where aa.companyrefid =?1 and aa.branchrefid=?2 and aa.locname=?3 and aa.locrefid =?4 GROUP BY ed.EmployeeCode", nativeQuery = true)
	public List ViewTaskPerformance(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid);

//	@Query(value = "SELECT tsa.task_number,tsa.task_title,tpi.task_priority_name,tss.task_status_name, CONCAT(eds.EmpFirstName,' ', eds.EmpLastName) as task_assigned_by, CONCAT(eds1.EmpFirstName,' ', eds1.EmpLastName) as  task_assigned_to, Date(tsa.task_start_date), Date(tsa.task_due_date),Date(tsa.completed_date),tsa.remarks,tsa.task_id FROM medc_taskmanagement.medc_task_assignment tsa inner join medc_taskmanagement.medc_task_priority tpi on tpi.task_priority_id = tsa.priority_id inner join medc_taskmanagement.medc_task_status tss on tss.task_statusid = tsa.task_status_id inner join medc_employee.medc_employeedetails eds on eds.EmployeeID = tsa.task_assigned_by inner join medc_employee.medc_employeedetails eds1 on eds1.EmployeeID = tsa.task_assigned_to inner join medc_employee.medc_empdepartment emd on emd.deptid = tsa.deptid where  tsa.companyrefid = ?1 and tsa.branchrefid = ?2 and tsa.locname = ?3 and tsa.locrefid = ?4 and tsa.employeeid =?5", nativeQuery = true)

	@Query(value = "SELECT   tsk.task_number,tsk.task_title,tsk.task_priority_name,tsk.task_status_name, ad.customername  as task_assigned_by, CONCAT(ed.EmpFirstName,' ', ed.EmpLastName) as  task_assigned_to, Date(tsk.task_start_date), Date(tsk.task_due_date),Date(tsk.completed_date),tsk.remarks,tsk.task_id from medc_adminsecurity.medc_userlogin ul \r\n" + 
			"INNER JOIN medc_adminsecurity.medc_adduser ad on ad.SUserRefId=ul.SUserID\r\n" + 
			"INNER JOIN medc_taskmanagement.medc_task_assignment tsk on tsk.task_assigned_by=ul.SUserID\r\n" + 
			"INNER JOIN medc_employee.medc_employeedetails ed on ed.EmployeeID=tsk.task_assigned_to\r\n" + 
			"where ul.SUserID=?1 ", nativeQuery = true)
	public List viewAssignedTask(Integer suserid);

	@Query(value = "select tsa.task_title,  tsa.task_assigned_by,tsa.task_assigned_to, Date(tsa.task_start_date),Date(tsa.task_due_date),Date(tsa.completed_date),tkp.task_priority_name,Date(tsa.response_date),tsk.task_status_name,description FROM medc_taskmanagement.medc_task_assignment tsa inner join medc_taskmanagement.medc_task_status  tsk on tsk.task_statusid = tsa.task_status_id inner join medc_taskmanagement.medc_task_priority tkp on tkp.task_priority_id = tsa.priority_id where tsa.companyrefid = ?1 and tsa.branchrefid = ?2 and tsa.locname = ?3 and tsa.locrefid = ?4 and tsa.task_id = ?5", nativeQuery = true)
	List getTaskValues(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("id") int id);

	@Query(value = "SELECT ems.employeeid,CONCAT(ems.EmpTitle,'. ',ems.EmpFirstName,' ',ems.EmpLastName) as EmpName  FROM medc_employee.medc_employeedetails ems inner join  medc_employee.medc_empdepartment emd on emd.deptid = ems.deptrefid where ems.companyid= ?1 and ems.branchid= ?2 and ems.locname= ?3 and ems.locrefid= ?4 and ems.deptrefid= ?5", nativeQuery = true)
	List dropdownemployee(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("deptrefid") int deptrefid);

	@Query(value = "SELECT asu.EmpRefID FROM medc_employee.medc_employeedetails emd inner join medc_adminsecurity.medc_userlogin asu on asu.EmpRefid = emd.EmployeeID where asu.SUserID = :userid", nativeQuery = true)
	Integer getUserId(@Param("userid") int userid);

	@Query(value = "SELECT CONCAT(EmployeeCode,'_',emd.EmpFirstName,' ',emd.EmpLastName) FROM medc_employee.medc_employeedetails emd inner join medc_taskmanagement.medc_task_assignment tsk on tsk.task_assigned_by = emd.EmployeeID where tsk.task_id=?1", nativeQuery = true)
	List getAssignedBy(@Param("taskid") int taskid);

	@Query(value = "SELECT CONCAT(EmployeeCode,'_',emd.EmpFirstName,' ',emd.EmpLastName) FROM medc_employee.medc_employeedetails emd inner join medc_taskmanagement.medc_task_assignment tsk on tsk.task_assigned_to = emd.EmployeeID where tsk.task_id=?1", nativeQuery = true)
	List getAssignedTo(@Param("taskid") int taskid);

	@Query(value = "SELECT deptrefid FROM medc_employee.medc_employeedetails WHERE EmployeeID=:userid", nativeQuery = true)
	Integer getAssignbydepart(@Param("userid") Integer userid);

	@Query(value = "SELECT deptrefid FROM medc_employee.medc_employeedetails WHERE EmployeeID=:task_assigned_to", nativeQuery = true)
	Integer getAssigntodepart(@Param("task_assigned_to") Integer task_assigned_to);

	@Query(value = "SELECT  count(EmployeeCode) FROM medc_employee.medc_employeedetails m", nativeQuery = true)
	Integer getEmployeeCount();

//	@Modifying
//	@Transactional
//	@Query(value = "UPDATE medc_taskmanagement.medc_task_assignment uta SET  uta.completed_date =?1,uta.task_status_name =?2, uta.colors =?9, uta.remarks =?10 WHERE uta.employeeid=?3 and uta.Companyrefid=?4 and  uta.Branchrefid=?5 and  uta.LocName=?6 and  uta.LocRefID=?7 and uta.task_number=?8", nativeQuery = true)
//	void updateViewIndividualTask(String completed_date, String status, int employeeid, int companyrefid, int branchrefid,
//			int locname, int locrefid, String task_number, int colors, String remark);
//	@Modifying
//	@Transactional
//	@Query(value = "UPDATE medc_taskmanagement.medc_task_assignment uta SET  uta.completed_date =?1,uta.task_status_name =?2,uta.colors =?9 WHERE uta.employeeid=?3 and uta.Companyrefid=?4 and  uta.Branchrefid=?5 and  uta.LocName=?6 and  uta.LocRefID=?7 and uta.task_number=?8", nativeQuery = true)
//	void updateViewIndividualTaskWithoutRemarks(String completed_date, String status, int employeeid, int companyrefid,
//			int branchrefid, int locname, int locrefid, String task_number, int colors);
//	

	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_taskmanagement.medc_task_assignment uta SET  uta.completed_date =?1,uta.task_status_name =?2, uta.colors =?9, uta.remarks =?10 WHERE uta.task_assigned_by=?3 and uta.Companyrefid=?4 and  uta.Branchrefid=?5 and  uta.LocName=?6 and  uta.LocRefID=?7 and uta.task_number=?8", nativeQuery = true)
	void updateViewIndividualTask(String completed_date, String status, int employeeid, int companyrefid,
			int branchrefid, int locname, int locrefid, String task_number, int colors, String remark);

	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_taskmanagement.medc_task_assignment uta SET  uta.completed_date =?1,uta.task_status_name =?2,uta.colors =?9 WHERE uta.task_assigned_by=?3 and uta.Companyrefid=?4 and  uta.Branchrefid=?5 and  uta.LocName=?6 and  uta.LocRefID=?7 and uta.task_number=?8", nativeQuery = true)
	void updateViewIndividualTaskWithoutRemarks(String completed_date, String status, int employeeid, int companyrefid,
			int branchrefid, int locname, int locrefid, String task_number, int colors);

	@Query(value = "SELECT uta.remarks FROM medc_task_assignment uta WHERE uta.employeeid=?1 and uta.Companyrefid=?2 and  uta.Branchrefid=?3 and  uta.LocName=?4 and  uta.LocRefID=?5 and uta.task_number=?6", nativeQuery = true)
	String gettingRemarks(int employeeid, int companyrefid, int branchrefid, int locname, int locrefid,
			String task_number);

	@Query(value = "SELECT tsa.task_number, tsa.task_title, tsp.task_priority_name,tss.task_status_name,concat(emd1.EmpFirstName,' ',emd1.EmpLastName)as task_assigned_by,concat(emd2.EmpFirstName,' ',emd2.EmpLastName)as task_assigned_to,tsa.task_start_date,tsa.task_due_date, tsa.completed_date FROM medc_taskmanagement.medc_task_assignment tsa inner join medc_taskmanagement.medc_task_status tss on tss.task_statusid = tsa.task_status_id inner join medc_taskmanagement.medc_task_priority tsp on tsp.task_priority_id = tsa.priority_id inner join medc_employee.medc_employeedetails emd1 on emd1.EmployeeID = tsa.task_assigned_by inner join medc_employee.medc_employeedetails emd2 on emd2.EmployeeID = tsa.task_assigned_to where  tsa.companyrefid = ?1 and tsa.branchrefid = ?2 and tsa.locname = ?3 and tsa.locrefid = ?4 and tsa.task_status_name = ?5", nativeQuery = true)
	public List viewPendingTask(@Param("cid") int cid, @Param("bid") int bid, @Param("locid") int locid,
			@Param("locreid") int locreid, @Param("task_status_name") String task_status_name);

	@Query(value = "SELECT ed.EmployeeCode,concat(ed.EmpFirstName,' ',ed.EmpLastName)as EmployeeName,ed.Department, COUNT(aa.task_start_date) as taskcout FROM medc_taskmanagement.medc_task_assignment aa INNER JOIN medc_taskmanagement.medc_task_status ts on ts.task_statusid=aa.task_status_id INNER JOIN medc_employee.medc_employeedetails ed on ed.employeeid=aa.employeeid where aa.companyrefid =?1 and aa.branchrefid =?2 and aa.locname =?3 and aa.locrefid =?4 and WEEK(aa.task_start_date) = Week(now())", nativeQuery = true)
	List revPerWeekly(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT ed.EmployeeCode,concat(ed.EmpFirstName,' ',ed.EmpLastName)as EmployeeName,ed.Department, COUNT(aa.task_start_date) as taskcout FROM medc_taskmanagement.medc_task_assignment aa INNER JOIN medc_taskmanagement.medc_task_status ts on ts.task_statusid=aa.task_status_id INNER JOIN medc_employee.medc_employeedetails ed on ed.employeeid=aa.employeeid where aa.companyrefid =?1 and aa.branchrefid =?2 and aa.locname =?3 and aa.locrefid =?4 and Month(aa.task_start_date) = Month(now())", nativeQuery = true)
	List revPerMonthly(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	@Query(value = "SELECT ed.EmployeeCode,concat(ed.EmpFirstName,' ',ed.EmpLastName)as EmployeeName,ed.Department, COUNT(aa.task_start_date) as taskcout FROM medc_taskmanagement.medc_task_assignment aa INNER JOIN medc_taskmanagement.medc_task_status ts on ts.task_statusid=aa.task_status_id INNER JOIN medc_employee.medc_employeedetails ed on ed.employeeid=aa.employeeid where aa.companyrefid =?1 and aa.branchrefid =?2 and aa.locname =?3 and aa.locrefid =?4 and Year(aa.task_start_date) = Year(now())", nativeQuery = true)
	List revPerAnnually(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

//	UserTask findByEmployeeid(Integer emprefid);

	UserTask findByEmployeeidAndTasknumber(Integer emprefid, String tasknumber);
	
}
