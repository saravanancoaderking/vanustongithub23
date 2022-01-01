package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Hospital;

@SuppressWarnings("rawtypes")
@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {

	@Query(value = "SELECT  hs.HospitalName,hs.Registrationno,sp.SpecialityName,hs.HosHeadQuarters,hs.HosAddress1,co.CountryName,st.StateName,hs.Phoneno,hs.Email,hs.HospitalID FROM medc_hospitalreg.hospitalregistration hs "
			+ "INNER JOIN medc_fixedsettings.medc_country co ON hs.CountryID=co.CountryID "
			+ "INNER JOIN medc_fixedsettings.medc_state st ON hs.StateID=st.stateID "
			+ "INNER JOIN medc_fixedsettings.medc_speciality sp ON hs.SpecialityID=sp.SpecialityID "
			+ "WHERE hs.status=0 and hs.CompanyRefID= :cid and hs.BranchRefID= :bid order by hs.HospitalID desc", nativeQuery = true)
	List getAll(@Param("cid") int cid, @Param("bid") int bid);

	@Query(value = "SELECT SpecialityID, SpecialityName FROM medc_fixedsettings.medc_speciality", nativeQuery = true)
	List getSpecialitys();

	Hospital findByid(int id);

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_state WHERE  CountryID= :id ", nativeQuery = true)
	List geteditState(@Param("id") int id);

	@Query(value = "SELECT DialingCode  FROM medc_fixedsettings.medc_country  WHERE CountryID= :id", nativeQuery = true)
	List geteditCcode(@Param("id") int id);

	@Query(value = "SELECT CityID,CityName FROM medc_fixedsettings.medc_city WHERE StateID= :id", nativeQuery = true)
	List geteditCity(@Param("id") int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE medc_hospitalreg.hospitalregistration SET status=2 WHERE HospitalID= :id", nativeQuery = true)
	Integer deleteHospital(@Param("id") int id);
}