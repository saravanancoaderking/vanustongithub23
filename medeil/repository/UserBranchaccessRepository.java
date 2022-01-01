package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.UserBranchaccess;

@SuppressWarnings("rawtypes")
@Repository
public interface UserBranchaccessRepository extends JpaRepository<UserBranchaccess, Long> {

	@Query(value = "SELECT BranchID,Branchname FROM medc_branchreg.medc_branchinfomation where companyrefid= :id and Status=0", nativeQuery = true)
	List userBranch(@Param("id") int id);

	@Query(value = "SELECT SUserrefID,BranchrefID FROM medc_adminsecurity.medc_userbranchaccess WHERE SUserrefID= :uid and BranchrefID= :bid", nativeQuery = true)
	Integer isExistBranch(@Param("uid") int uid, @Param("bid") int bid);

	@Modifying
	@Transactional
	@Query(value = "DELETE  FROM medc_adminsecurity.medc_userbranchaccess WHERE SUserrefID= :uid and BranchrefID= :bid", nativeQuery = true)
	void deleteBranch(@Param("uid") int uid, @Param("bid") int bid);
}
