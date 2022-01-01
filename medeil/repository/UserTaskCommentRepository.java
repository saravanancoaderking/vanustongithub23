package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.UserTask;
import com.medeil.domain.UserTaskComment;

public interface UserTaskCommentRepository extends JpaRepository<UserTaskComment, Long > {
	
	
	
	@Query(value = "SELECT CONCAT(emd.EmpFirstName,' ',emd.EmpLastName)as EmployeeName, Date(tsc.clientcdate) as Date,tsc.comment from medc_taskmanagement.medc_task_comment tsc inner join medc_employee.medc_employeedetails emd on emd.employeeid = tsc.employee_id where tsc.companyrefid =:compid and  tsc.branchrefid = :branchid and  tsc.locname= :locname and tsc.locrefid = :locrefid", nativeQuery = true)
			List getTaskComment(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
					@Param("locrefid") int locrefid);
	
	
	

}
