package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.MainGroup;

@SuppressWarnings("rawtypes")
@Repository
public interface MainGroupRepository extends JpaRepository<MainGroup, Long> {

	@Modifying
	@Transactional
	@Query(value = "update medc_productmaster.medc_group  set  groupname=?2  where  groupid=?1", nativeQuery = true)
	void updatemaingroup(int groupid, String groupname);

}
