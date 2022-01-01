package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Rolectrl;

@SuppressWarnings("rawtypes")
@Repository
public interface RolectrlRepository extends JpaRepository<Rolectrl, Long> {

	@Query(value = "SELECT distinct mm.ModuleId,mm.ModuleName FROM medc_adminsecurity.medc_role rr "
			+ "INNER JOIN  medc_companyreg.medc_companyinfomation cc ON cc.companyid=rr.companyid "
			+ "INNER JOIN medc_adminsecurity.medc_editionctrl ec ON ec.Editionrefid=cc.editionrefid "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster mm ON mm.moduleid=ec.modulerefid where rr.roleid= :id and rr.status=0 and mm.status=0 and cc.status=0", nativeQuery = true)
	List moduleList(@Param("id") int id);

	@Query(value = "SELECT SubModuleID,SubModuleName FROM medc_adminsecurity.medc_submodulemaster where modulerefid= :id", nativeQuery = true)
	List submoduleList(@Param("id") int id);

	@Query(value = "SELECT RoleName FROM medc_adminsecurity.medc_role WHERE RoleID= :id", nativeQuery = true)
	String setRole(@Param("id") int id);

	@Query(value = "SELECT count(RoleID) as cid FROM medc_adminsecurity.medc_rolectrl WHERE RoleID= :rid and ModuleID= :mid", nativeQuery = true)
	Integer isExistRole(@Param("rid") int rid, @Param("mid") int mid);

	@Modifying
	@Transactional
	@Query(value = "DELETE  FROM medc_adminsecurity.medc_rolectrl WHERE RoleID= :rid and ModuleID= :mid", nativeQuery = true)
	void delisExistRole(@Param("rid") int rid, @Param("mid") int mid);

	@Query(value = "SELECT r.RoleName,m.ModuleName,sm.SubModuleName,rc.RolectrlID FROM medc_adminsecurity.medc_rolectrl rc "
			+ "INNER JOIN medc_adminsecurity.medc_role r ON r.RoleID=rc.RoleID "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster m ON m.ModuleID=rc.ModuleID "
			+ "INNER JOIN medc_adminsecurity.medc_submodulemaster sm ON sm.SubModuleID=rc.SubModuleID "
			+ "WHERE rc.RoleID= :id  order by r.RoleName desc", nativeQuery = true)
	List getAssignRole(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM medc_adminsecurity.medc_rolectrl WHERE RolectrlID= :id", nativeQuery = true)
	void delAssignRole(@Param("id") int id);
	
	@Query( value = "SELECT m.trialplanid FROM medc_adminsecurity.medc_trialplan m  where m.countryid=:cid", nativeQuery = true  )
	List getEditionid(@Param("cid")Integer cid);

	boolean existsByRoleidAndModuleidAndSubmoduleid(Integer roleid, Integer moduleid, Integer submoduleid);
		
}
