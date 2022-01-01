/**
 * 
 */
package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ajith Kumar
 *
 */
@Entity
@Table(name = "medc_appointment", catalog = "medc_clinic")
public class Appointment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AppointmentID")
	private Integer id;

	private String appointno;

	private String appointfromtime;

	private String appointtotime;

	private String appointmentdate;

	private String emergencylevel;

	private Integer doctorrefid;

	private String appointreason;

	private Integer patientrefid;

	private String appointduration;

	private Double appointmentcharge;

	private String clientcdate;

	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locrefid;

	private Integer locname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppointfromtime() {
		return appointfromtime;
	}

	public void setAppointfromtime(String appointfromtime) {
		this.appointfromtime = appointfromtime;
	}

	public String getAppointtotime() {
		return appointtotime;
	}

	public void setAppointtotime(String appointtotime) {
		this.appointtotime = appointtotime;
	}

	public String getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public String getEmergencylevel() {
		return emergencylevel;
	}

	public void setEmergencylevel(String emergencylevel) {
		this.emergencylevel = emergencylevel;
	}

	public Integer getDoctorrefid() {
		return doctorrefid;
	}

	public void setDoctorrefid(Integer doctorrefid) {
		this.doctorrefid = doctorrefid;
	}

	public String getAppointreason() {
		return appointreason;
	}

	public void setAppointreason(String appointreason) {
		this.appointreason = appointreason;
	}

	public Integer getPatientrefid() {
		return patientrefid;
	}

	public void setPatientrefid(Integer patientrefid) {
		this.patientrefid = patientrefid;
	}

	public String getAppointduration() {
		return appointduration;
	}

	public void setAppointduration(String appointduration) {
		this.appointduration = appointduration;
	}

	public Double getAppointmentcharge() {
		return appointmentcharge;
	}

	public void setAppointmentcharge(Double appointmentcharge) {
		this.appointmentcharge = appointmentcharge;
	}

	public String getAppointno() {
		return appointno;
	}

	public void setAppointno(String appointno) {
		this.appointno = appointno;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public Integer getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(Integer branchrefid) {
		this.branchrefid = branchrefid;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

}
