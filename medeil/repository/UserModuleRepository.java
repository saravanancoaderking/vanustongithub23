package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.UserModule;

@SuppressWarnings("rawtypes")
@Repository
public interface UserModuleRepository extends JpaRepository<UserModule, Long> {

	@Query(value = "SELECT distinct mo.ModuleID, mo.modulename FROM medc_adminsecurity.medc_userlogin lo "
			+ "INNER JOIN medc_adminsecurity.medc_rolectrl ro ON ro.RoleID=lo.RoleRefID "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster mo ON mo.ModuleID=ro.ModuleID "
			+ "WHERE mo.Status=0 and lo.SUserID=:id", nativeQuery = true)
	List moduleList(@Param("id") int id);

	@Query(value = "SELECT lo.suserid, lo.username FROM medc_adminsecurity.medc_userlogin lo "
			+ "INNER JOIN medc_adminsecurity.medc_adduser ad ON lo.CUserRefID=ad.CUserID WHERE CompanyRefID= :id", nativeQuery = true)
	List userList(@Param("id") int id);

	@Query(value = "SELECT distinct SUserRefID,ModuleID FROM medc_adminsecurity.medc_usermodules WHERE SUserRefID= :uid and ModuleID= :mid", nativeQuery = true)
	Integer isExistModule(@Param("uid") int uid, @Param("mid") int mid);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM medc_adminsecurity.medc_usermodules WHERE SUserRefID= :uid and ModuleID= :mid", nativeQuery = true)
	void deleteModule(@Param("uid") int uid, @Param("mid") int mid);
	
	//padmini
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_adminsecurity.medc_usermodules um INNER JOIN medc_adminsecurity.medc_modulesmaster mm ON mm.moduleid = um.moduleid SET um.labelname = mm.label WHERE um.SUserRefID= :uid and um.ModuleID= :mid", nativeQuery = true)
	void updatelabel(@Param("uid") int uid, @Param("mid") int mid);
	
	//padmini

	/*@Query(value = "select distinct( um.moduleid),mm.modulename,um.labelname  from medc_adminsecurity.medc_usermodules um "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster mm ON mm.moduleid = um.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_usersubmodule us ON us.moduleid = um.moduleid WHERE um.SUserRefID= :id and um.SUserRefID=us.SUserRefID and us.moduleid=mm.moduleid order by us.ranking asc", nativeQuery = true)
	List selectmodulenames(@Param("id") int id,@Param("label") String label);*/
	
	@Query(value = "SELECT m.suserrefid,mm.moduleid, mm.ModuleName as modules,m.ranking FROM medc_adminsecurity.medc_userlogin ul\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_usermodules m ON m.suserrefid = ul.suserid\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_modulesmaster mm ON mm.moduleid=m.moduleid\r\n" + 
			"WHERE m.status=0 and m.suserrefid =:id and mm.label=SUBSTRING_INDEX( :label, '_', 1)", nativeQuery = true)
	List selectmodulenames( @Param("id") int id,@Param("label") String label);
	
	
	//padmini
		@Modifying
		@Transactional
		@Query(value = "update medc_adminsecurity.medc_usermodules s  set s.ranking=?2 where s.moduleid=?3 and s.suserrefid=?1 ", nativeQuery = true)
		void updateuserlabelmoduleranking(Integer userid, Integer ranking,Integer moduleid);

		boolean existsBySuserrefidAndModuleid(Integer id, Integer moduleid);

}
