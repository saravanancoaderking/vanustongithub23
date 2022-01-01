package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.SubGroup1;

@SuppressWarnings("rawtypes")
@Repository
public interface SubGroup1Repository extends JpaRepository<SubGroup1, Long> {

	@Modifying
	@Transactional
	@Query(value = "update medc_productmaster.medc_subgroup1  set  subgroupname1=?2  where  subgroupid1=?1", nativeQuery = true)
	void updatesubgroup1(int subgroupid1, String subgroupname1);

}
