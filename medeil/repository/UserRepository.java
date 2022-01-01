package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.User;

@SuppressWarnings("rawtypes")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//Boopalan 200219
	
	User findByUsername(String email);

	
	@Query(value = "SELECT CompanyID,CompanyName FROM medc_companyreg.medc_companyinfomation where status = 0", nativeQuery = true)
	List companyList();

	@Query(value = "SELECT RoleID,RoleName FROM medc_adminsecurity.medc_role where companyid= :id and status = 0", nativeQuery = true)
	List roleList(@Param("id") int id);

	@Query(value = "SELECT co.countryID,co.CountryName FROM medc_companyreg.medc_companyinfomation com "
			+ "INNER JOIN medc_fixedsettings.medc_country co ON com.country=co.countryID WHERE com.companyid= :id", nativeQuery = true)
	List userconData(@Param("id") int id);

	@Query(value = "SELECT pro.productID,pro.productname FROM medc_companyreg.medc_companyinfomation com "
			+ "INNER JOIN medc_adminsecurity.medc_cproductmaster pro ON com.productrefID=pro.productID WHERE com.companyid= :id", nativeQuery = true)
	List userproData(@Param("id") int id);

	@Query(value = "SELECT dom.domainID,dom.Domainname FROM medc_companyreg.medc_companyinfomation com "
			+ "INNER JOIN medc_adminsecurity.medc_domainmaster dom ON com.DomainRefID=dom.DomainID WHERE com.companyid= :id", nativeQuery = true)
	List userdomData(@Param("id") int id);

	@Query(value = "SELECT sd.SubDomainID,sd.subdomainname FROM medc_companyreg.medc_companyinfomation com "
			+ "INNER JOIN medc_adminsecurity.medc_subdomainmaster sd ON com.Subdomainrefid=sd.SubDomainID WHERE com.companyid= :id", nativeQuery = true)
	List usersdomData(@Param("id") int id);

	@Query(value = "SELECT ed.EditionID,ed.editionname FROM medc_companyreg.medc_companyinfomation com "
			+ "INNER JOIN medc_adminsecurity.medc_editionmaster ed ON com.editionrefid=ed.EditionID WHERE com.companyid= :id", nativeQuery = true)
	List userEditionData(@Param("id") int id);

	@Query(value = "SELECT EmployeeID,EmpFirstName FROM medc_employee.medc_employeedetails  WHERE CompanyID= :id", nativeQuery = true)
	List employeeList(@Param("id") int id);

	@Query(value = "SELECT lo.UserName,lo.UserType,lo.SUserID FROM medc_adminsecurity.medc_userlogin lo "
			+ "INNER JOIN medc_adminsecurity.medc_adduser au ON au.CUserID=CUserRefID WHERE lo.IsActive=0  order by  lo.SUserID  desc", nativeQuery = true)
	List viewUserList();

	@Query(value = "SELECT au.Username,m.ModuleName,sm.SubModuleName,um.usersubmoduleid FROM medc_adminsecurity.medc_userlogin au "
			+ "INNER JOIN medc_adminsecurity.medc_usersubmodule um ON um.SUserRefID=au.CUserRefID "
			+ "INNER JOIN medc_adminsecurity.medc_submodulemaster sm ON sm.SubModuleID=um.SubModuleID "
			+ "INNER JOIN medc_adminsecurity.medc_modulesmaster m ON m.ModuleID=sm.ModulerefID "
			+ "WHERE m.status=0 and sm.status=0 and au.isActive=0", nativeQuery = true)
	List viewUserModulelist();

	@Query(value = "SELECT au.Username,bi.BranchName FROM medc_adminsecurity.medc_adduser au "
			+ "INNER JOIN medc_adminsecurity.medc_userbranchaccess br ON br.SUserRefID=au.CUserID "
			+ "INNER JOIN medc_branchreg.medc_branchinfomation bi ON bi.BranchID=br.BranchRefID WHERE br.status=0 and bi.status=0", nativeQuery = true)
	List viewBrancAccess();

	@Query(value = "SELECT au.Username,si.ShopName FROM medc_adminsecurity.medc_adduser au "
			+ "INNER JOIN medc_adminsecurity.medc_userstoreaccess sh ON sh.SUserRefID=au.CUserID "
			+ "INNER JOIN medc_storereg.medc_shopinformation si ON si.ShopID=sh.StoreRefID WHERE si.status=0 and sh.Status=0", nativeQuery = true)
	List viewShopAccess();

	@Query(value = "SELECT au.Username,wi.Warehousename FROM medc_adminsecurity.medc_adduser au "
			+ "INNER JOIN medc_adminsecurity.medc_userwhouseaccess wr ON  wr.SUserRefID=au.CUserID "
			+ "INNER JOIN medc_warehousereg.medc_warehouseinfo wi ON wi.WarehouseID=wr.WarehouseRefID WHERE wr.Status=0 and wi.Status=0", nativeQuery = true)
	List viewWareAccess();

	@Query(value = "SELECT au.Username,HospitalName FROM medc_adminsecurity.medc_adduser au "
			+ "INNER JOIN medc_adminsecurity.medc_userhospitalaccess hs ON hs.SUserRefID=au.CUserID "
			+ "INNER JOIN medc_hospitalreg.hospitalregistration hi ON hi.HospitalID=UserHospID WHERE hi.status=0 and hs.status=0", nativeQuery = true)
	List viewHospitalAccess();

	@Modifying
	@Transactional
	@Query(value = "delete FROM medc_adminsecurity.medc_usersubmodule WHERE UserSubModuleID= :id", nativeQuery = true)
	int delAssignUser(@Param("id") int id);

	@Query(value = "SELECT moduleid FROM medc_adminsecurity.medc_usersubmodule WHERE UserSubModuleID= :id", nativeQuery = true)
	int getmoduleno(@Param("id") int id);

	@Query(value = "SELECT Suserrefid FROM medc_adminsecurity.medc_usersubmodule WHERE UserSubModuleID= :id", nativeQuery = true)
	int getuserno(@Param("id") int id);

	@Query(value = "select count(*) FROM medc_adminsecurity.medc_usersubmodule WHERE ModuleID= :moduleno and Suserrefid= :userid", nativeQuery = true)
	int getmodulecount(@Param("moduleno") int moduleno, @Param("userid") int userid);

	@Modifying
	@Transactional
	@Query(value = "delete FROM medc_adminsecurity.medc_usermodules WHERE ModuleID= :moduleno and Suserrefid= :userid", nativeQuery = true)
	int deleteAssignmodule(@Param("moduleno") int moduleno, @Param("userid") int userid);


}
