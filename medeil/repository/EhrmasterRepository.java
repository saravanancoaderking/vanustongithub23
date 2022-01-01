package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Ehrmaster;

@Repository
public interface EhrmasterRepository extends JpaRepository<Ehrmaster, Integer> {

	@Query(value = "SELECT ehm.ehrmsid,ehm.ehrfiletype,ehm.doctype,date(ehm.createddate)as recdate,ehr.ehrreportname,pi.PatientID,pi.PatientFirstName,pi.mobile,pi.email,ehm.ehrdoc FROM  medc_ehr.medc_ehrmaster ehm\r\n"
			+ "inner join medc_patientreg.medc_patientbasicinfo pi on pi.PatientID=ehm.customerid\r\n"
			+ "left join medc_ehr.medc_ehrreport ehr on ehr.ehrreportid=ehm.ehrreportid\r\n"
			+ "WHERE ehm.companyid=?1 and ehm.branchid=?2 and ehm.locname=?3 and ehm.locrefid=?4 order by ehm.ehrmsid desc", nativeQuery = true)
	List ViewMasterList(Integer cid, Integer bid, Integer locname, Integer locrefid);

}
