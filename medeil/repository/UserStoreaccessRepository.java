package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.UserStoreaccess;

@SuppressWarnings("rawtypes")
@Repository
public interface UserStoreaccessRepository extends JpaRepository<UserStoreaccess, Long> {

	@Query(value = "SELECT sh.ShopID, sh.ShopName  FROM medc_storereg.medc_shopinformation sh "
			+ "INNER JOIN medc_adminsecurity.medc_userbranchaccess us ON us.BranchRefID=sh.branchID WHERE us.SUserRefID= :id and sh.status=0", nativeQuery = true)
	List userShoplist(@Param("id") int id);

	@Query(value = "SELECT SUserRefID,StoreRefID FROM medc_adminsecurity.medc_userstoreaccess WHERE SUserRefID= :uid and StoreRefID= :sid", nativeQuery = true)
	Integer isExistShop(@Param("uid") int uid, @Param("sid") int sid);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM medc_adminsecurity.medc_userstoreaccess WHERE SUserRefID= :uid and StoreRefID= :sid", nativeQuery = true)
	Integer deleteShop(@Param("uid") int uid, @Param("sid") int sid);
}
