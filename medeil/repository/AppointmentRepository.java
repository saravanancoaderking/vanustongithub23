/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Appointment;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query(value = "SELECT dr.DoctorID,dr.DoctorName FROM medc_doctorreg.doctorregistration dr WHERE dr.status=0 AND dr.CompanyRefID=:cid AND  dr.BranchRefID=:bid  AND dr.LocName=:lname AND dr.LocRefID=:lref", nativeQuery = true)
	List getDoctor(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("lname") Integer lname,
			@Param("lref") Integer lref);

	@Query(value = "SELECT PatientID,PatientFirstName FROM medc_patientreg.medc_patientbasicinfo WHERE status=0 and "
			+ "CompanyRefID= :cid and BranchRefID= :bid and LocRefID= :lref and LocName= :lname", nativeQuery = true)
	List getPatient(@Param("cid") int cid, @Param("bid") int bid, @Param("lname") int lname, @Param("lref") int lref);

	@Query(value = "SELECT CONCAT(sc.FromTime,'-',sc.ToTime) as times FROM medc_doctorreg.clinicbussinessdays sc "
			+ "INNER JOIN medc_doctorreg.doctorregistration di ON di.DoctorID=sc.DoctorID "
			+ "WHERE sc.DoctorID= :did and sc.FromTime <= :frtime AND sc.ToTime  >= :totime and di.Status=0", nativeQuery = true)
	String checkDocAvailability(@Param("did") int did, @Param("frtime") String frtime, @Param("totime") String totime);

	@Query(value = "SELECT  CONCAT(ap.AppointFromtime,'-',ap.AppointTotime) as Times FROM medc_clinic.medc_appointment ap "
			+ "INNER JOIN medc_doctorreg.doctorregistration di ON di.DoctorID=ap.DoctorRefID "
			+ "WHERE ap.DoctorRefID= :did and ((ap.AppointFromtime between :frtime and :totime) or (ap.AppointTotime  between :frtime and :totime)) and di.Status=0 and ap.AppointmentDate= :date", nativeQuery = true)
	String checkAppointment(@Param("date") String date, @Param("did") int did, @Param("frtime") String frtime,
			@Param("totime") String totime);

	@Query(value = "SELECT Round(ap.AppointNo,0)as AppointNo,pi.PatientFirstName,ap.AppointFromtime, ap.AppointTotime FROM medc_clinic.medc_appointment ap "
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.PatientID=ap.PatientRefID "
			+ "WHERE ap.status=0 and pi.Status=0 and ap.CompanyRefID= :cid and ap.BranchRefID= :bid and ap.LocRefID= :lref and ap.LocName= :lname", nativeQuery = true)
	List viewAppointment(@Param("cid") int cid, @Param("bid") int bid, @Param("lref") int lref,
			@Param("lname") int lname);

	@Query(value = "SELECT ap.AppointNo,pi.PatientFirstName,ap.AppointFromtime, ap.AppointTotime FROM medc_clinic.medc_appointment ap "
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pi ON pi.PatientID=ap.PatientRefID "
			+ "WHERE ap.AppointFromtime >= :frtime and ap.AppointTotime <= :totime and ap.AppointmentDate= :date and pi.status=0 and ap.status=0 "
			+ "and ap.CompanyRefID= :cid and ap.BranchRefID= :bid and ap.LocRefID= :lref and ap.LocName= :lname", nativeQuery = true)
	List searchAppointment(@Param("date") String date, @Param("frtime") String frtime, @Param("totime") String totime,
			@Param("cid") int cid, @Param("bid") int bid, @Param("lref") int lref, @Param("lname") int lname);

	@Query(value = "SELECT coalesce(max((AppointNo+0)),0)+1 as appointNumber FROM medc_clinic.medc_appointment where AppointmentDate= :date and DoctorRefID= :id", nativeQuery = true)
	String getMaxApoointNo(@Param("date") String date, @Param("id") Integer id);

	/** MANAGE APPOINTMENT **/
	@Query(value = "SELECT distinct doc.DoctorID,doc.DoctorName FROM medc_doctorreg.doctorregistration doc "
			+ "INNER JOIN medc_clinic.medc_appointment ap ON ap.DoctorRefID=doc.DoctorID "
			+ "WHERE doc.DoctorName LIKE :docname% and doc.status=0 and ap.status=0 "
			+ "and ap.CompanyRefID= :cid and ap.BranchRefID= :bid and ap.LocRefID= :lref and ap.LocName= :lname", nativeQuery = true)
	List searchDoctor(@Param("docname") String docname, @Param("cid") int cid, @Param("bid") int bid,
			@Param("lref") int lref, @Param("lname") int lname);

	@Query(value = "SELECT distinct pt.PatientID,CONCAT(pt.PatientFirstName,'_',pt.Mobile) as name FROM medc_patientreg.medc_patientbasicinfo pt "
			+ "INNER JOIN medc_clinic.medc_appointment ap ON ap.PatientRefID=pt.PatientID "
			+ "WHERE pt.PatientFirstName LIKE %:data% or pt.Mobile LIKE %:data% and pt.Status=0 and ap.status=0 "
			+ "and ap.CompanyRefID= :cid and ap.BranchRefID= :bid and ap.LocRefID= :lref and ap.LocName= :lname", nativeQuery = true)
	List searchPatient(@Param("data") String data, @Param("cid") int cid, @Param("bid") int bid,
			@Param("lref") int lref, @Param("lname") int lname);

	@Query(value = "SELECT ap.AppointNo,DATE_FORMAT(ap.AppointmentDate,'%Y-%m-%d') as apdate,CONCAT(pt.PatientFirstName,'-',pt.Mobile) as patientname,doc.DoctorName, ap.AppointFromtime,ap.AppointTotime,ap.AppointmentID,ap.CompanyRefID, ap.BranchRefID, ap.LocRefID, ap.LocName "
			+ "FROM medc_clinic.medc_appointment ap "
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pt ON ap.PatientRefID=pt.PatientID "
			+ "INNER JOIN medc_doctorreg.doctorregistration doc ON ap.DoctorRefID=doc.DoctorID "
			+ "WHERE ap.Status=0 and doc.Status=0 and pt.Status=0 and ap.DoctorRefID= :docID", nativeQuery = true)
	List getDoctorWiseAppoint(@Param("docID") int docID);

	@Query(value = "SELECT ap.AppointNo,DATE_FORMAT(ap.AppointmentDate,'%Y-%m-%d') as apdate,CONCAT(pt.PatientFirstName,'-',pt.Mobile) as patientname,doc.DoctorName, ap.AppointFromtime,ap.AppointTotime,ap.AppointmentID,ap.CompanyRefID, ap.BranchRefID, ap.LocRefID, ap.LocName FROM medc_clinic.medc_appointment ap "
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pt ON ap.PatientRefID=pt.PatientID "
			+ "INNER JOIN medc_doctorreg.doctorregistration doc ON ap.DoctorRefID=doc.DoctorID "
			+ "WHERE ap.Status=0 and doc.Status=0 and pt.Status=0 and ap.PatientRefID= :pid", nativeQuery = true)
	List getPatientWiseAppoint(@Param("pid") int pid);

	@Query(value = "SELECT ap.AppointNo,DATE_FORMAT(ap.AppointmentDate,'%Y-%m-%d') as apdate,CONCAT(pt.PatientFirstName,'-',pt.Mobile) as patientname,doc.DoctorName, ap.AppointFromtime,ap.AppointTotime,ap.AppointmentID,ap.CompanyRefID, ap.BranchRefID, ap.LocRefID, ap.LocName FROM medc_clinic.medc_appointment ap "
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pt ON ap.PatientRefID=pt.PatientID "
			+ "INNER JOIN medc_doctorreg.doctorregistration doc ON ap.DoctorRefID=doc.DoctorID "
			+ "WHERE ap.Status=0 and doc.Status=0 and pt.Status=0 and ap.AppointmentDate= :da "
			+ "and ap.CompanyRefID= :cid and ap.BranchRefID= :bid and ap.LocRefID= :lref and ap.LocName= :lname", nativeQuery = true)
	List getDateWiseAppoint(@Param("da") String da, @Param("cid") int cid, @Param("bid") int bid,
			@Param("lref") int lref, @Param("lname") int lname);

	@Query(value = "SELECT ap.AppointNo,DATE_FORMAT(ap.AppointmentDate,'%Y-%m-%d') as apdate,CONCAT(pt.PatientFirstName,'-',pt.Mobile) as patientname,doc.DoctorName, ap.AppointFromtime,ap.AppointTotime,ap.AppointmentID,ap.CompanyRefID, ap.BranchRefID, ap.LocRefID, ap.LocName "
			+ "FROM medc_clinic.medc_appointment ap "
			+ "INNER JOIN medc_patientreg.medc_patientbasicinfo pt ON ap.PatientRefID=pt.PatientID "
			+ "INNER JOIN medc_doctorreg.doctorregistration doc ON ap.DoctorRefID=doc.DoctorID "
			+ "WHERE ap.Status=0 and doc.Status=0 and pt.Status=0 "
			+ "and ap.CompanyRefID= :cid and ap.BranchRefID= :bid and ap.LocRefID= :lref and ap.LocName= :lname", nativeQuery = true)
	List manageAppoint(@Param("cid") int cid, @Param("bid") int bid, @Param("lref") int lref,
			@Param("lname") int lname);

	Appointment findById(int id);

	@Query(value = "SELECT distinct AppointFromtime FROM medc_clinic.medc_appointment WHERE AppointFromtime= :ftime", nativeQuery = true)
	String editFromtime(@Param("ftime") String ftime);

}
