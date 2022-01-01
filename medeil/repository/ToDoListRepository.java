package com.medeil.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Therapeutic;
import com.medeil.domain.ToDoList;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

	@Query(value = "SELECT td.topicname, td.description, td.start_date_time, td.end_date_time FROM medc_taskmanagement.medc_todolist td where td.companyrefid = :companyrefid and td.branchrefid = :branchrefid  and td.locname = :locname and td.locrefid = :locrefid and td.status !=1", nativeQuery = true)
	List getData(int companyrefid, int branchrefid, int locname, int locrefid);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE medc_taskmanagement.medc_todolist SET status = 1 WHERE companyrefid = ?1 and branchrefid = ?2 and locname = ?3 and locrefid =?4", nativeQuery = true)
	void deleteAllToDos(int companyrefid, int branchrefid, int locname, int locrefid);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE medc_taskmanagement.medc_todolist SET status = 1 WHERE companyrefid = ?1 and branchrefid = ?2 and locname = ?3 and locrefid =?4 and topicname= ?5", nativeQuery = true)
	void deleteOneToDos(int companyrefid, int branchrefid, int locname, int locrefid, String topicname);

}
