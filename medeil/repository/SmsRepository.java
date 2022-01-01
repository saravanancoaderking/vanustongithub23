/**
 * 
 */
package com.medeil.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Utility;

/**
 * @author Ajith Kumar
 *
 */
@Repository
public interface SmsRepository extends JpaRepository<Utility, Long> {

	@Query(value = "SELECT ad.PhoneNo FROM  medc_adminsecurity.medc_adduser ad "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin  lo ON ad.SUserRefID=lo.SUserID "
			+ "WHERE ad.CompanyRefID= :id and lo.UserName= :uname", nativeQuery = true)
	String checkPhonenumber(@Param("id") int id, @Param("uname") String uname);

	@Query(value = "SELECT ad.EmailID FROM  medc_adminsecurity.medc_adduser ad "
			+ "INNER JOIN medc_adminsecurity.medc_userlogin  lo ON ad.SUserRefID=lo.SUserID "
			+ "WHERE ad.CompanyRefID= :id and lo.UserName= :uname", nativeQuery = true)
	String checkEmailaddress(@Param("id") int id, @Param("uname") String uname);

	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_adminsecurity.medc_userlogin  lo "
			+ "INNER JOIN medc_adminsecurity.medc_adduser ad ON ad.SUserRefID=lo.SUserID SET lo.password= :password "
			+ "WHERE ad.CompanyRefID= :cid and lo.UserName= :uname", nativeQuery = true)
	Integer updatePassword(@Param("cid") int cid, @Param("uname") String uname, @Param("password") String password);
}
