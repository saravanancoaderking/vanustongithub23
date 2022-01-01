/**
 * 
 */
package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author www
 *
 */

@Entity
@Table(name = "medc_prescription_digitization", catalog = "medc_sales")
public class Prescdigitalization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pdigitalizedid;

	private String pdigitalizedno;
	private int salesorderid;
	private String salesorderno;
	private String patientname;
	private int patientid;
	private String doctorname;
	private int age;
	private String gender;
	private int createdby;
	// private String createddate;
	// private int modifiedby;
	// private String modifieddate;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private int employeeid;
	private String remarks;
	private int status;
	private int emprefid;
	private String imageurl;

	private int totalprod;

	public int getTotalprod() {
		return totalprod;
	}

	public void setTotalprod(int totalprod) {
		this.totalprod = totalprod;
	}

	public int getPdigitalizedid() {
		return pdigitalizedid;
	}

	public void setPdigitalizedid(int pdigitalizedid) {
		this.pdigitalizedid = pdigitalizedid;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	private int checstatus;
	private int approvsts;

	public int getChecstatus() {
		return checstatus;
	}

	public void setChecstatus(int checstatus) {
		this.checstatus = checstatus;
	}

	public int getApprovsts() {
		return approvsts;
	}

	public void setApprovsts(int approvsts) {
		this.approvsts = approvsts;
	}

	public int getEmprefid() {
		return emprefid;
	}

	public void setEmprefid(int emprefid) {
		this.emprefid = emprefid;
	}

	public String getPdigitalizedno() {
		return pdigitalizedno;
	}

	public void setPdigitalizedno(String pdigitalizedno) {
		this.pdigitalizedno = pdigitalizedno;
	}

	public int getSalesorderid() {
		return salesorderid;
	}

	public void setSalesorderid(int salesorderid) {
		this.salesorderid = salesorderid;
	}

	public String getSalesorderno() {
		return salesorderno;
	}

	public void setSalesorderno(String salesorderno) {
		this.salesorderno = salesorderno;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
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

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
