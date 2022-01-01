package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Raja
 *
 */
@Entity
@Table(name = "clinicbusinesshour", catalog = "medc_doctorreg")
public class DrAppointment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "businessdaysid")
	private Integer Id;
	private int doctorrefid;
	private int days;
	private String drfromtime;
	private String drtotime;
	private String reason;
	private int status;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;

	public int getBusinessdaysid() {
		return Id;
	}

	public void setBusinessdaysid(int BusinessDaysID) {
		this.Id = BusinessDaysID;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getDrfromtime() {
		return drfromtime;
	}

	public void setDrfromtime(String drfromtime) {
		this.drfromtime = drfromtime;
	}

	public String getDrtotime() {
		return drtotime;
	}

	public void setDrtotime(String drtotime) {
		this.drtotime = drtotime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}

	public int getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(int branchrefid) {
		this.branchrefid = branchrefid;
	}

	public int getLocname() {
		return locname;
	}

	public void setLocname(int locname) {
		this.locname = locname;
	}

	public int getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(int locrefid) {
		this.locrefid = locrefid;
	}

	public int getDoctorrefid() {
		return doctorrefid;
	}

	public void setDoctorrefid(int doctorrefid) {
		this.doctorrefid = doctorrefid;
	}
}
