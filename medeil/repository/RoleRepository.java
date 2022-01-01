package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Role;

@SuppressWarnings("rawtypes")
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findById(Integer valueOf);


	@Query(value = "SELECT r.Roleid, r.Rolename, c.Companyname,c.status FROM medc_adminsecurity.medc_role r, medc_companyreg.medc_companyinfomation c where r.companyid = c.companyid and r.status =0 order by  r.Roleid desc", nativeQuery = true)
	List Roleslist();

	@Query(value = "SELECT RoleName FROM medc_adminsecurity.medc_role WHERE CompanyID= :id and RoleName= :name", nativeQuery = true)
	String checkExistRole(@Param("id") int id, @Param("name") String name);

	@Query(value = "SELECT scope FROM medc_adminsecurity.oauth_client_details", nativeQuery = true)
	String getCurrentScope();

	@Modifying
	@Transactional
	@Query(value = "update medc_adminsecurity.oauth_client_details set scope =?1", nativeQuery = true)
	void updateCurrentScope(String updatedScope);

	@Query(value = "SELECT m.CompanyID, m.CompanyName FROM medc_companyreg.medc_companyinfomation m where m.CompanyID =?1", nativeQuery = true)
	List getCompanyName(int id);

}
