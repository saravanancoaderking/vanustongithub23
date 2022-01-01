package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Usersubmodule;

@SuppressWarnings("rawtypes")
public interface UsersubmoduleRepository extends JpaRepository<Usersubmodule, Long> {

	@Query(value = "SELECT smo.SubModuleID, smo.Submodulename,smo.modulerefid FROM medc_adminsecurity.medc_submodulemaster smo,medc_adminsecurity.medc_userlogin lo, medc_adminsecurity.medc_rolectrl ro "
			+ "WHERE smo.SubModuleID=ro.SubModuleID and lo.RoleRefID=ro.RoleID and smo.Status=0 and smo.ModuleRefID= :mid and lo.SUserID= :uid", nativeQuery = true)
	List subModulelist(@Param("mid") int mid, @Param("uid") int uid);

	@Query(value = "SELECT distinct SubModuleID,SUserRefID FROM medc_adminsecurity.medc_usersubmodule WHERE SUserRefID= :uid and SubModuleID= :mid", nativeQuery = true)
	Integer isExistsubModule(@Param("uid") int uid, @Param("mid") int mid);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM medc_adminsecurity.medc_usersubmodule WHERE SUserRefID= :uid and SubModuleID= :mid", nativeQuery = true)
	void deleteSubModule(@Param("uid") int uid, @Param("mid") int mid);

	@Query(value = "SELECT suserrefid  from medc_adminsecurity.medc_usersubmodule where moduleid =:moduleid and submoduleid =:submoduleid and is_approver=1 and companyrefid IN (select companyrefid from medc_adminsecurity.medc_usersubmodule where suserrefid =:userrefid)", nativeQuery = true)
	Integer getapproverid(@Param("moduleid") int moduleid, @Param("submoduleid") int submoduleid,
			@Param("userrefid") int userrefid);

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO medc_adminsecurity.medc_approval (userid, moduleid, submoduleid, approverid1, approvelevel) values ( ?1,?2,?3,?4,1 )", nativeQuery = true)
	void saveapproval(int suserrefid, int moduleid, int submoduleid, int approver);
	
	//padmini
	@Modifying
	@Transactional
	@Query(value = "update medc_adminsecurity.medc_usersubmodule s left join medc_adminsecurity.medc_modulesmaster m on m.moduleid=s.moduleid set s.ranking=?2 where m.`label`=?3 and s.suserrefid=?1 ", nativeQuery = true)
	void updateusermodulelabel(Integer userid, Integer ranking,String label);

	boolean existsBySuserrefidAndSubmoduleid(Integer id, Integer valueOf);
	
	

	
}
