package com.medeil.repository;

import java.util.List;

/*************************************************************************
 * 
 * Vanuston CONFIDENTIAL
 * __________________
 * 
 *  [2009] - [2019] Vanuston Intelligence Pvt.Ltd  
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Vanuston Intelligence Pvt.Ltd and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Vanuston Intelligence Pvt.Ltd
 * and its suppliers and may be covered by Indian and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Vanuston Intelligence Pvt.Ltd.
 */
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Medc_Userlogin;

/**
 * 
 * @author Boopalan Alagesan
 * @Date 01-12-2019
 *
 */
@Repository
@Transactional
public interface Medc_UserLoginRepository extends JpaRepository<Medc_Userlogin, Long> {
	Medc_Userlogin findByUsername(String username);

	Medc_Userlogin findByUsernameAndCompanyrefid(String username, int Companyrefid);

	@Query(value = "SELECT distinct(lo.IsActive) FROM medc_adminsecurity.medc_userlogin lo  INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid where BINARY lo.username= :username ", nativeQuery = true)
	Integer activeuser(@Param("username") String username, @Param("compid") int compid);

	@Query(value = "SELECT CONCAT(mm.ModuleName,'_',mm.icon) as modules FROM medc_adminsecurity.medc_userlogin ul "
			+ "INNER JOIN medc_adminsecurity.medc_adduser us ON us.cuserid= ul.Suserid "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.suserrefid = us.cuserid "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster mm ON mm.moduleid=m.moduleid "
			+ "WHERE BINARY ul.username= :name  and m.status=0 and us.CompanyRefID= :compid order by m.ranking asc", nativeQuery = true)
	List modules(@Param("name") String name, @Param("compid") int compid);

	@Query(value = "select CONCAT(smm.SubModuleName,'_',smm.icon)as submodule from medc_adminsecurity.medc_usersubmodule sm,medc_adminsecurity.medc_userlogin ul,"
			+ " medc_adminsecurity.medc_submodulemaster smm,medc_adminsecurity.medc_modulesmaster mm "
			+ "where sm.SUserRefID=ul.suserid and ul.SUserID=sm.SuserRefID and smm.SubModuleID=sm.SubModuleID and mm.ModuleID=smm.ModuleRefID and "
			+ "BINARY ul.username= :name  and mm.modulename=SUBSTRING_INDEX( :mname, '_', 1)", nativeQuery = true)
	List submodules(@Param("name") String name, @Param("mname") Object mname);

	@Query(value = "SELECT distinct mm.Label  FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid "

			+ "WHERE BINARY ul.username= :name and m.status=0 and mm.modulename=SUBSTRING_INDEX( :mname, '_', 1)  ", nativeQuery = true)
	List getModulelabel(@Param("name") String name, @Param("mname") Object object, @Param("compid") int compid);

	@Query(value = "SELECT distinct CONCAT(mm.Label,'_',mm.icon) as labels FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid "
			+ "INNER JOIN medc_adminsecurity.medc_usersubmodule usm on usm.moduleid=m.moduleid "

			+ "WHERE usm.suserrefid=m.suserrefid and  BINARY ul.username= :name  and m.status=0 order by usm.ranking asc", nativeQuery = true)
	List getModulelabels(@Param("name") String name, @Param("compid") int compid);

	boolean existsByUsername(String username);

	boolean existsByUsernameAndLoginstatus(String username, Long issuedAtTimeStamp);

}
