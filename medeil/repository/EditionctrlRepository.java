package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Editionctrl;

@SuppressWarnings("rawtypes")
public interface EditionctrlRepository extends JpaRepository<Editionctrl, Long> {

	@Query(value = "SELECT em.EditionName,rl.RoleID FROM medc_adminsecurity.medc_editionmaster em INNER JOIN medc_adminsecurity.medc_role rl on rl.EditionRefID=em.EditionID WHERE em.EditionID=:id ORDER BY rl.RoleID ASC", nativeQuery = true)
	List getEditionname(@Param("id") int id);

	@Query(value = "SELECT SubDomainName FROM medc_adminsecurity.medc_subdomainmaster WHERE SubDomainID= :id", nativeQuery = true)
	List subDomainname(@Param("id") int id);

	@Query(value = "SELECT mo.ModuleId,mo.ModuleName FROM medc_adminsecurity.medc_modulesmaster mo "
			+ "INNER JOIN medc_adminsecurity.medc_editionmaster ed ON mo.DomainRefID=ed.DomainRefID and mo.SubDomainRefID=ed.SubDomainRefID and mo.CountryID=ed.countryID and mo.ProductID=ed.ProductID "
			+ "WHERE ed.EditionID= :id and mo.status!=2 ", nativeQuery = true)
	List getModulelist(@Param("id") int id);

	@Query(value = "SELECT mo.SubModuleID,mo.SubModuleName FROM medc_adminsecurity.medc_submodulemaster mo "
			+ "INNER JOIN medc_adminsecurity.medc_editionmaster ed ON mo.DomainRefID=ed.DomainRefID and mo.SubDomainRefID=ed.SubDomainRefID and mo.CountryID=ed.countryID and mo.ProductID=ed.ProductID "
			+ "WHERE mo.ModuleRefID= :mid and ed.EditionID= :eid and mo.status!=2", nativeQuery = true)
	List getsubModulelist(@Param("eid") int eid, @Param("mid") int mid);

	@Query(value = "SELECT ModuleRefID FROM medc_adminsecurity.medc_submodulemaster WHERE SubModuleID= :id", nativeQuery = true)
	Integer getModuleID(@Param("id") int id);
	
	//Boopalan 260619
	@Query(value = "SELECT distinct m.moduleID,m.ModuleName,sm.SubModuleID,sm.SubModuleName FROM medc_adminsecurity.medc_editionctrl ed "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster m ON ed.ModuleRefID=m.moduleID "
			+ "INNER JOIN medc_adminsecurity.medc_submodulemaster sm ON sm.ModuleRefID=m.moduleID WHERE ed.EditionRefID= :id", nativeQuery = true)
	List getModuleAssign(@Param("id") int id);

	@Query(value = "SELECT distinct EditionRefID FROM medc_adminsecurity.medc_editionctrl WHERE EditionRefID= :id", nativeQuery = true)
	Integer getEditionID(@Param("id") int id);
	
	@Query(value = "SELECT mm.label FROM medc_adminsecurity.medc_editionmaster em"
			+ " INNER JOIN  medc_adminsecurity.medc_modulesmaster mm on mm.ProductID=em.ProductID "
			+ "WHERE em.EditionID=:eid group by mm.label", nativeQuery = true)
	List getlablename(@Param("eid")Integer eid);

	@Query(value = "SELECT mm.ModuleID,mm.ModuleName,mm.label FROM medc_adminsecurity.medc_editionmaster em"
			+ " INNER JOIN  medc_adminsecurity.medc_modulesmaster mm on mm.ProductID=em.ProductID "
			+ "WHERE em.EditionID=:eid and mm.label like :lname% ", nativeQuery = true)
	List getModulename(@Param("eid")Integer eid,@Param("lname") String lname);
	
	@Query(value = "SELECT sm.SubModuleID,sm.SubModuleName,sm.ModuleRefID,ms.modulename FROM medc_adminsecurity.medc_editionmaster em\r\n" + 
			"INNER JOIN  medc_adminsecurity.medc_submodulemaster sm on sm.ProductID=em.ProductID\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_modulesmaster ms on ms.ModuleID=sm.ModuleRefID\r\n" + 
			"WHERE em.EditionID=:eid and sm.ModuleRefID=:mid", nativeQuery = true)
	List getsubModulename(@Param("eid")Integer eid,@Param("mid")Integer mid);
	
	@Query(value = "SELECT el.SubModuleID,sm.submodulename FROM medc_adminsecurity.medc_editionctrl el\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_submodulemaster sm on el.SubModuleID=sm.SubModuleID\r\n" + 
			"WHERE el.EditionID=:eid", nativeQuery = true)
	List getselectedsubmodulename(@Param("eid")Integer eid);

	@Query(value = "SELECT mm.MODULEID,mm.MODULENAME FROM medc_adminsecurity.medc_modulesmaster mm INNER JOIN medc_adminsecurity.medc_rolectrl rc on rc.moduleID=mm.ModuleID\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_role rl on rl.RoleID=rc.RoleID INNER JOIN medc_adminsecurity.medc_editionmaster em on em.EditionID=rl.EditionRefID\r\n" + 
			"Where em.EditionID=:editionid group by rc.moduleid", nativeQuery = true)
	List geteditionmodule(@Param("editionid")Integer editionid);
	
	boolean existsByEditionidAndModuleidAndSubmoduleid(Integer editionid, Integer moduleid, Integer submoduleid);
}
