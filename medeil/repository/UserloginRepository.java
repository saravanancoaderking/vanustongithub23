package com.medeil.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Userlogin;

@SuppressWarnings("rawtypes")
@Repository
public interface UserloginRepository extends JpaRepository<Userlogin, Long> {

	
	Userlogin findById(Integer valueOf);
	
	Userlogin findByUsername(String email);
	
	boolean existsByUsername(String email);
	
	List<Userlogin> findByRolerefid(Integer rolerefid);

	@Query(value = "SELECT lo.CUserRefID,lo.UserType,lo.DistributorID FROM medc_adminsecurity.medc_userlogin lo  "
			+ "INNER JOIN medc_adminsecurity.medc_adduser us ON us.CUserID=lo.CUserRefID WHERE us.CompanyRefID= :compid and  BINARY lo.username= :uname and BINARY lo.password= :upass", nativeQuery = true)
	List existsUser(@Param("uname") String uname, @Param("upass") String upass, @Param("compid") int compid);

	@Query(value = "SELECT distinct(lo.IsActive) FROM medc_adminsecurity.medc_userlogin lo  INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid where BINARY lo.username= :username and BINARY lo.password= :password", nativeQuery = true)
	Integer activeuser(@Param("username") String username, @Param("password") String password,
			@Param("compid") int compid);

	// new
	@Query(value = "SELECT distinct(lo.IsActive) FROM medc_adminsecurity.medc_userlogin lo  INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid where BINARY lo.username= :username ", nativeQuery = true)
	Integer activeuser(@Param("username") String username, @Param("compid") int compid);

	@Query(value = "SELECT CONCAT(mm.ModuleName,'_',mm.icon) as modules FROM medc_adminsecurity.medc_userlogin ul "
			+ "INNER JOIN medc_adminsecurity.medc_adduser us ON us.cuserid= ul.CUserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.suserrefid = us.cuserid "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster mm ON mm.moduleid=m.moduleid "
			+ "WHERE BINARY ul.username= :name and BINARY ul.password= :pass and m.status=0 and us.CompanyRefID= :compid order by m.ranking asc", nativeQuery = true)
	List modules(@Param("name") String name, @Param("pass") String pass, @Param("compid") int compid);

	// new
	@Query(value = "SELECT CONCAT(mm.ModuleName,'_',mm.icon) as modules FROM medc_adminsecurity.medc_userlogin ul\r\n"
			+ "			INNER JOIN medc_adminsecurity.medc_adduser us ON us.cuserid= ul.cuserrefid\r\n"
			+ "			INNER JOIN medc_adminsecurity.medc_usermodules m ON m.suserrefid = us.suserrefid\r\n"
			+ "			INNER JOIN medc_adminsecurity.medc_modulesmaster mm ON mm.moduleid=m.moduleid\r\n"
			+ "			WHERE BINARY ul.username=?1  and m.status=0 and us.CompanyRefID=?2 and m.EditionID=us.EditionRefID order by m.ranking asc", nativeQuery = true)
	List modules(@Param("name") String name, @Param("compid") int compid);

	@Query(value = "select CONCAT(smm.SubModuleName,'_',smm.icon)as submodule from medc_adminsecurity.medc_usersubmodule sm,medc_adminsecurity.medc_userlogin ul,"
			+ "medc_adminsecurity.medc_submodulemaster smm,medc_adminsecurity.medc_modulesmaster mm "
			+ "where sm.SUserRefID=ul.suserid and ul.SUserID=sm.SuserRefID and smm.SubModuleID=sm.SubModuleID and mm.ModuleID=smm.ModuleRefID and "
			+ "BINARY ul.username= :name and BINARY ul.password= :pass and mm.modulename=SUBSTRING_INDEX( :mname, '_', 1)", nativeQuery = true)
	List submodules(@Param("name") String name, @Param("pass") String pass, @Param("mname") Object mname);

	// new
	@Query(value = "select CONCAT(smm.SubModuleName,'_',smm.icon)as submodule from medc_adminsecurity.medc_usersubmodule sm,\r\n" + 
			"medc_adminsecurity.medc_userlogin ul,\r\n" + 
			"medc_adminsecurity.medc_submodulemaster smm,\r\n" + 
			"medc_adminsecurity.medc_modulesmaster mm,\r\n" + 
			"medc_adminsecurity.medc_adduser au\r\n" + 
			"where sm.SUserRefID=ul.suserid and smm.SubModuleID=sm.SubModuleID and mm.ModuleID=smm.ModuleRefID and \r\n" + 
			"au.EditionRefID=sm.EditionID and BINARY ul.username= :name and mm.modulename=SUBSTRING_INDEX( :mname, '_', 1)", nativeQuery = true)
	Set submodules(@Param("name") String name, @Param("mname") Object mname);

	@Query(value = "SELECT distinct CONCAT(mm.Label,'_',mm.icon) as labels FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid "
			+ "INNER JOIN medc_adminsecurity.medc_usersubmodule usm on usm.moduleid=m.moduleid "

			+ "WHERE usm.suserrefid=m.suserrefid and  BINARY ul.username= :name and BINARY ul.password= :pass and m.status=0 order by usm.ranking asc", nativeQuery = true)
	List getModulelabels(@Param("name") String name, @Param("pass") String pass, @Param("compid") int compid);

	// new
	@Query(value = "SELECT distinct CONCAT(mm.Label,'_',mm.icon) as labels FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid "
			+ "INNER JOIN medc_adminsecurity.medc_usersubmodule usm on usm.moduleid=m.moduleid "

			+ "WHERE usm.suserrefid=m.suserrefid and  BINARY ul.username= :name  and m.status=0 order by usm.ranking asc", nativeQuery = true)
	List getModulelabels(@Param("name") String name, @Param("compid") int compid);

//old label setting
	@Query(value = "SELECT distinct mm.Label  FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid "

			+ "WHERE BINARY ul.username= :name and BINARY ul.password= :pass and m.status=0 and mm.modulename=SUBSTRING_INDEX( :mname, '_', 1)  ", nativeQuery = true)
	List getModulelabel(@Param("name") String name, @Param("pass") String pass, @Param("mname") Object object,
			@Param("compid") int compid);

	// new
	@Query(value = "SELECT distinct mm.Label  FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid "

			+ "WHERE BINARY ul.username= :name and m.status=0 and mm.modulename=SUBSTRING_INDEX( :mname, '_', 1)  ", nativeQuery = true)
	List getModulelabel(@Param("name") String name, @Param("mname") Object object, @Param("compid") int compid);

	// Ajith Patient Login Authorities

	@Query(value = "SELECT mm.path,mm.title,mm.icon,mm.type,mm.active FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ " WHERE ul.username= :username and m.status=0  LIMIT 1 offset :count", nativeQuery = true)
	Map getPaient(@Param("username") String name, @Param("count") int count);

	@Query(value = "SELECT COUNT(*) FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "WHERE ul.username=:username  and m.status=0 ", nativeQuery = true)
	int getCount(String username);

	@Query(value = "SELECT mm.ModuleID FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID   "
			+ "WHERE ul.username=:username  and m.status=0 LIMIT 1 offset :count ", nativeQuery = true)
	int getmoduleid(String username, Integer count);

	@Query(value = "SELECT mm.path,mm.title,mm.type FROM medc_adminsecurity.medc_submodulemaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.ModuleID = mm.ModuleRefID "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster us ON us.ModuleID= mm.ModuleRefID"
			+ " WHERE ul.username= :username  and m.status=0 and mm.ModuleRefID=:modelueid LIMIT 1 offset :count ", nativeQuery = true)
	Map getSubmodule(String username, int modelueid, Integer count);

	@Query(value = "SELECT COUNT(*) FROM medc_adminsecurity.medc_modulesmaster mm"
			+ " INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "WHERE ul.username=:username  and m.status=0  ", nativeQuery = true)
	int getSubCount(String username);

	// ajith cuurrently work authorities
	@Query(value = "SELECT distinct(lo.IsActive) FROM medc_adminsecurity.medc_userlogin lo  where BINARY lo.username=:username", nativeQuery = true)
	int user(@Param("username") String username);

	@Query(value = "SELECT CONCAT(mm.path,',',mm.title,',',mm.icon,',',mm.type,',',mm.active) as modules FROM medc_adminsecurity.medc_userlogin ul"
			+ " INNER JOIN medc_adminsecurity.medc_adduser us ON us.cuserid= ul.Suserid"
			+ " INNER JOIN medc_adminsecurity.medc_usermodules m ON m.suserrefid = us.cuserid "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster mm ON mm.moduleid=m.moduleid "
			+ "WHERE BINARY ul.username=:username", nativeQuery = true)
	List getModules(@Param("username") String username);

	@Query(value = "select CONCAT(smm.path,',',smm.title,',',smm.type)as submodule from medc_adminsecurity.medc_usersubmodule sm,	"
			+ "medc_adminsecurity.medc_userlogin ul,medc_adminsecurity.medc_submodulemaster smm,"
			+ "	medc_adminsecurity.medc_modulesmaster mm where sm.SUserRefID=ul.suserid and ul.SUserID=sm.SuserRefID "
			+ "and smm.SubModuleID=sm.SubModuleID and mm.ModuleID=smm.ModuleRefID and"
			+ " BINARY ul.username=:username  and mm.modulename=SUBSTRING_INDEX( :object , ',', 13)", nativeQuery = true)
	List getsubmodules(@Param("username") String username, @Param("object") Object object);

	@Query(value = "SELECT distinct mm.title,' ,',mm.type FROM medc_adminsecurity.medc_modulesmaster mm"
			+ " INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ " WHERE BINARY ul.username= :username and m.status=0 and mm.modulename=SUBSTRING_INDEX( :object, ',', 1)", nativeQuery = true)
	List getmainModules(@Param("username") String username, @Param("object") Object object);

	@Query(value = "SELECT mm.title FROM medc_adminsecurity.medc_userlogin ul"
			+ " INNER JOIN medc_adminsecurity.medc_adduser us ON us.cuserid= ul.Suserid"
			+ " INNER JOIN medc_adminsecurity.medc_usermodules m ON m.suserrefid = us.cuserid"
			+ " INNER JOIN medc_adminsecurity.medc_modulesmaster mm ON mm.moduleid=m.moduleid"
			+ " WHERE BINARY ul.username=:username and m.status=0 order by m.ranking asc LIMIT 1 OFFSET :i", nativeQuery = true)
	List getLables(String username, int i);

//padmini 

	/*
	 * @Query(value =
	 * "SELECT distinct mm.Label  FROM medc_adminsecurity.medc_modulesmaster mm " +
	 * "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
	 * +
	 * "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
	 * +
	 * "INNER JOIN medc_adminsecurity.medc_adduser us ON us.CompanyRefID= :compid "
	 * +
	 * "INNER JOIN medc_adminsecurity.medc_usersubmodule usm on usm.moduleid=m.moduleid"
	 * +
	 * "WHERE BINARY ul.username= :name and BINARY ul.password= :pass and m.status=0 and mm.modulename=SUBSTRING_INDEX( :mname, '_', 1)"
	 * , nativeQuery = true) List getModulelabel(@Param("name") String
	 * name, @Param("pass") String pass, @Param("mname") Object object,
	 * 
	 * @Param("compid") int compid);
	 */

	@Query(value = "SELECT max(cuserid) as CUserID FROM medc_adminsecurity.medc_adduser", nativeQuery = true)
	Integer userId();

	@Query(value = "SELECT br.BranchID,br.BranchName FROM medc_branchreg.medc_branchinfomation br "
			+ "INNER JOIN medc_adminsecurity.medc_userbranchaccess ba ON  ba.BranchRefID=br.BranchID "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin lo ON  lo.CUserRefID=ba.SUserRefID  "
			+ "WHERE ba.Status=0 and br.status=0 and br.CompanyRefID= :cid and ba.SUserRefID= :uid", nativeQuery = true)
	List getLoginBranch(@Param("cid") int cid, @Param("uid") int uid);

	@Query(value = "SELECT sh.ShopID,sh.ShopName FROM medc_storereg.medc_shopinformation sh "
			+ "INNER JOIN medc_adminsecurity.medc_userstoreaccess sa ON sa.StoreRefID=sh.ShopID "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin lo ON  lo.CUserRefID=sa.SUserRefID "
			+ "WHERE sh.companyID= :cid and sh.branchID= :bid and sa.Status=0 and sh.status=0 and sa.SUserRefID= :uid", nativeQuery = true)
	List getLoginShop(@Param("cid") int cid, @Param("bid") int bid, @Param("uid") int uid);

	@Query(value = "SELECT hi.HospitalID,hi.HospitalName FROM medc_hospitalreg.hospitalregistration hi "
			+ "INNER JOIN medc_adminsecurity.medc_userhospitalaccess ha ON ha.HospitalRefID=hi.HospitalID "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin lo ON  lo.CUserRefID=ha.SUserRefID "
			+ "WHERE  hi.Status=0 and ha.status=0 and hi.CompanyRefID= :cid and hi.BranchRefID= :bid and ha.SUserRefID= :uid", nativeQuery = true)
	List getLoginhospital(@Param("cid") int cid, @Param("bid") int bid, @Param("uid") int uid);

	@Query(value = "SELECT wi.warehouseID,wi.WarehouseName FROM medc_warehousereg.medc_warehouseinfo wi "
			+ "INNER JOIN medc_adminsecurity.medc_userwhouseaccess wa ON wa.WarehouseRefID=wi.warehouseID "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin lo ON  lo.CUserRefID=wa.SUserRefID "
			+ "WHERE  wi.Status=0 and wa.status=0 and wi.CompanyID= :cid and wi.BranchID= :bid and wa.SUserRefID= :uid", nativeQuery = true)
	List getLoginWarehouse(@Param("cid") int cid, @Param("bid") int bid, @Param("uid") int uid);

	@Query(value = "select * from test", nativeQuery = true)
	List setLocalStorage();

	@Query(value = "select id,LocationName FROM  medc_adminsecurity.medc_locationref where id= :id", nativeQuery = true)
	String getLocRef(@Param("id") String id);

	@Query(value = "SELECT CompanyID,CompanyName FROM medc_companyreg.medc_companyinfomation WHERE status=0", nativeQuery = true)
	List getuserCompany();

	@Query(value = "select rolename from medc_adminsecurity.medc_role where roleid= :id", nativeQuery = true)
	String getUserType(@Param("id") int id);

	// padmini

	@Query(value = "select mm.label  as userlable,ul.suserid,usm.ranking  from medc_adminsecurity.medc_userlogin ul inner join medc_adminsecurity.medc_usermodules um on um.suserrefid=ul.suserid inner join medc_adminsecurity.medc_usersubmodule usm on usm.moduleid=um.moduleid  inner join medc_adminsecurity.medc_modulesmaster mm on mm.moduleid=um.moduleid where ul.suserid =:uid and  um.suserrefid=usm.suserrefid GROUP BY mm.label order by usm.ranking", nativeQuery = true)
	List getloginuserlabel(@Param("uid") int uid);

	@Query(value = "SELECT mm.Label as labels FROM medc_adminsecurity.medc_modulesmaster mm "
			+ "INNER JOIN medc_adminsecurity.medc_usermodules m ON m.moduleid = mm.moduleid "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.SUserID=m.SuserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_usersubmodule usm on usm.moduleid=m.moduleid "
			+ "WHERE usm.suserrefid=m.suserrefid and  m.suserrefid=:id  and  m.status=0 group by mm.label order by usm.ranking asc", nativeQuery = true)
	List getModulelabels1(@Param("id") int id);




	//DesingRaja View User Lock and Unlock Details
	
	@Query(value = "SELECT au.username, pm.productname, ec.editionname, c.countryname, ul.userloginattempt, ul.isaccountnonlocked,ul.suserid FROM medc_adminsecurity.medc_adduser au\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_cproductmaster pm ON pm.productid = au.productrefid\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_editionmaster ec ON ec.editionid = au.editionrefid\r\n" + 
			"INNER JOIN medc_fixedsettings.medc_country c ON c.countryid = au.countryrefid\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_userlogin ul ON ul.suserid = au.suserrefid", nativeQuery = true)
	List getuserlockdetails();
	
	
	@Modifying
	@Transactional
	@Query(value ="UPDATE medc_adminsecurity.medc_userlogin ul SET ul.isaccountnonlocked = 0 WHERE ul.suserid =:userid", nativeQuery = true)
	void updatelock(@Param("userid") Integer userid);


	@Modifying
	@Transactional
	@Query(value ="UPDATE medc_adminsecurity.medc_userlogin ul SET ul.isaccountnonlocked = 1 WHERE ul.suserid =:userid", nativeQuery = true)
	void updateunlock(@Param("userid") Integer userid);

	@Query(value="SELECT lh.userid,lh.username, lh.country,lh.city,date(lh.usertime) as userdate,time(lh.usertime) as usertime, lh.ip, lh.browsertype  FROM medc_adminsecurity.medc_userloginhistory lh", nativeQuery = true)
	List getloginhistory();

	Optional<Userlogin> findByDomainname(String domainname);

}
