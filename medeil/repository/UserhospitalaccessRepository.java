package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Userhospitalaccess;

@SuppressWarnings("rawtypes")
@Repository
public interface UserhospitalaccessRepository extends JpaRepository<Userhospitalaccess, Long> {

	@Query(value = "SELECT hp.HospitalID,hp.HospitalName FROM medc_hospitalreg.hospitalregistration hp  "
			+ "INNER JOIN medc_adminsecurity.medc_userbranchaccess us ON us.BranchRefID=hp.BranchRefID WHERE us.SUserRefID= :id and hp.status=0", nativeQuery = true)
	List userHospital(@Param("id") int id);

	@Query(value = "SELECT SUserRefID,HospitalRefID FROM medc_adminsecurity.medc_userhospitalaccess WHERE SUserRefID= :uid and  HospitalRefID= :hid", nativeQuery = true)
	Integer isExistHospital(@Param("uid") int uid, @Param("hid") int hid);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM medc_adminsecurity.medc_userhospitalaccess WHERE SUserRefID= :uid and  HospitalRefID= :hid", nativeQuery = true)
	Integer deleteHospital(@Param("uid") int uid, @Param("hid") int hid);

}
