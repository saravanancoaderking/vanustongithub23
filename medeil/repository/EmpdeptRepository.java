package com.medeil.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Empdept;

@SuppressWarnings("rawtypes")
@Repository
public interface EmpdeptRepository  extends JpaRepository<Empdept, Long>{
	
	@Query(value = "SELECT departmentname FROM medc_employee.medc_empdepartment WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid and departmentname= :name", nativeQuery = true)
	String checkExistdept(@Param("compid") int compid, @Param("branchid") int branchid,@Param("locname") int locname,@Param("locrefid") int locrefid,@Param("name") String name);

}
