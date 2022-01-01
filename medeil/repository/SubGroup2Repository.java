package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.SubGroup2;

@SuppressWarnings("rawtypes")
@Repository
public interface SubGroup2Repository extends JpaRepository<SubGroup2, Long> {

	@Modifying
	@Transactional
	@Query(value = "update medc_productmaster.medc_subgroup2  set  subgroupname2=?2  where  subgroupid2=?1", nativeQuery = true)
	void updatesubgroup1(int subgroupid2, String subgroupname2);

}
