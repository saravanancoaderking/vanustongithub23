package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Userwarehouseaccess;

@SuppressWarnings("rawtypes")
@Repository
public interface UserwarehouseaccessRepository extends JpaRepository<Userwarehouseaccess, Long> {

	@Query(value = "SELECT wr.warehouseID,wr.Warehousename FROM medc_warehousereg.medc_warehouseinfo wr "
			+ "INNER JOIN medc_adminsecurity.medc_userbranchaccess us ON us.BranchRefID=wr.BranchID WHERE us.SUserRefID= :id and wr.status=0", nativeQuery = true)
	List userWarehouselist(@Param("id") int id);

	@Query(value = "SELECT SUserRefID,WarehouseRefID FROM medc_adminsecurity.medc_userwhouseaccess WHERE SUserRefID= :uid and WarehouseRefID= :wid", nativeQuery = true)
	Integer isExistWarehouse(@Param("uid") int uid, @Param("wid") int wid);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM medc_adminsecurity.medc_userwhouseaccess WHERE SUserRefID= :uid and WarehouseRefID= :wid", nativeQuery = true)
	void deleteWarehouse(@Param("uid") int uid, @Param("wid") int wid);
}
