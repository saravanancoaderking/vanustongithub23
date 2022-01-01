package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Doctor;

/** @Author Ajith Kumar **/
@SuppressWarnings("rawtypes")
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query(value = "SELECT CONCAT(doc.Title,'.',doc.DoctorName) as DoctorName,doc.RegistrationNo,doc.Gender,co.CountryName,st.StateName,"
			+ "CONCAT(doc.DocAddress1,',',doc.DocAddress2) as address,doc.Mobile,doc.Email,doc.Website,doc.AadhaarCardNo,doc.DoctorID FROM medc_doctorreg.doctorregistration doc "
			+ "INNER JOIN medc_fixedsettings.medc_country co ON doc.Country=co.CountryID "
			+ "INNER JOIN medc_fixedsettings.medc_state st ON doc.state=st.stateID "
			+ "WHERE doc.status=0 and doc.CompanyRefID= :cid and doc.BranchRefID= :bid order by doc.doctorid desc ", nativeQuery = true)
	List viewDoctors(@Param("cid") int cid, @Param("bid") int bid);

	Doctor findById(int id);

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_state WHERE  CountryID= :id ", nativeQuery = true)
	List geteditState(@Param("id") int id);

	@Query(value = "SELECT DialingCode  FROM medc_fixedsettings.medc_country  WHERE CountryID= :id", nativeQuery = true)
	List geteditCcode(@Param("id") int id);

	@Query(value = "SELECT CityID,CityName FROM medc_fixedsettings.medc_city WHERE StateID= :id", nativeQuery = true)
	List geteditCity(@Param("id") int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE medc_doctorreg.doctorregistration SET Status=2 WHERE DoctorID= :id", nativeQuery = true)
	Integer deleteDoctor(@Param("id") int id);
	
	/*** DOCTOR LIST ***/ //Boopalan 010519
	@Query(value = "SELECT d.DoctorID, d.DoctorName FROM medc_doctorreg.doctorregistration d where d.CompanyRefID =?1  and d.BranchRefID =?2 and d.LocName =?3 and d.LocRefID =?4 ", nativeQuery = true)
	List doctorlist(Integer compid,Integer branchid,Integer locname,Integer locrefid);
	
//	DesingRaja Search Doctor List
	@Query(value = "SELECT d.DoctorID, d.DoctorName FROM medc_doctorreg.doctorregistration d WHERE d.CompanyRefID =?1  AND d.BranchRefID =?2 AND d.LocName =?3 AND d.LocRefID =?4 AND d.doctorname LIKE ?5%", nativeQuery = true)
	List searchdoctorlist(Integer compid,Integer branchid,Integer locname,Integer locrefid,String searchkey);
	
	
}