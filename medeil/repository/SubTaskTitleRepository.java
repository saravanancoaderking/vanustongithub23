package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.SubTaskTitle;


public interface SubTaskTitleRepository extends JpaRepository<SubTaskTitle, Long> {
	
	@Query(value = "SELECT task_id from medc_taskmanagement.medc_task_assignment where Companyrefid=?1 and Branchrefid=?2 and LocName=?3 and LocRefID=?4 ORDER BY task_id DESC LIMIT 1", nativeQuery = true)
	int getTaskID(int Companyrefid, int Branchrefid, int LocName, int LocRefID);
	
	

}
