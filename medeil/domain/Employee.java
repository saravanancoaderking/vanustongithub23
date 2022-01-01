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
 * @author Manik
 *
 */
@Entity
@Table(name = "medc_employeedetails", catalog = "medc_employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeID")
	private Integer id;
	private Integer companyid;
	private Integer branchid;
	private String emptitle;
	private String empfirstname;
	private String emplastname;
	private String employeecode;
	private String employeetype;
	private String employeemode;
	// private String department;
	// private String division;
	// private String desgination;
	private String joiningdate;
	private String empsalary;
	private String dob;
	private String countryid;
	private String bloodgroup;
	private String gender;
	private String email;
	private String compemail;
	private String pancard;
	private String aadharcard;
	private String allowlogin;
	private String passport;
	private Integer locname;
	private Integer locrefid;
	private Integer modifiedby;
	private String clientmdate;
	private Integer age;
	private String mobileno;
	// padmini

	private Integer deptrefid;
	private Integer subdeptrefid;
	private Integer divisionid;
	private Integer subdivisionid;
	private String desgination;
	private String empaddress1;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public String getEmptitle() {
		return emptitle;
	}

	public void setEmptitle(String emptitle) {
		this.emptitle = emptitle;
	}

	public String getEmpfirstname() {
		return empfirstname;
	}

	public void setEmpfirstname(String empfirstname) {
		this.empfirstname = empfirstname;
	}

	public String getEmplastname() {
		return emplastname;
	}

	public void setEmplastname(String emplastname) {
		this.emplastname = emplastname;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getEmployeetype() {
		return employeetype;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}

	public String getEmployeemode() {
		return employeemode;
	}

	public void setEmployeemode(String employeemode) {
		this.employeemode = employeemode;
	}

	public String getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getEmpsalary() {
		return empsalary;
	}

	public void setEmpsalary(String empsalary) {
		this.empsalary = empsalary;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompemail() {
		return compemail;
	}

	public void setCompemail(String compemail) {
		this.compemail = compemail;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getAadharcard() {
		return aadharcard;
	}

	public void setAadharcard(String aadharcard) {
		this.aadharcard = aadharcard;
	}

	public String getAllowlogin() {
		return allowlogin;
	}

	public void setAllowlogin(String allowlogin) {
		this.allowlogin = allowlogin;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getClientmdate() {
		return clientmdate;
	}

	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Integer getDeptrefid() {
		return deptrefid;
	}

	public void setDeptrefid(Integer deptrefid) {
		this.deptrefid = deptrefid;
	}

	public Integer getSubdeptrefid() {
		return subdeptrefid;
	}

	public void setSubdeptrefid(Integer subdeptrefid) {
		this.subdeptrefid = subdeptrefid;
	}

	public Integer getDivisionid() {
		return divisionid;
	}

	public void setDivisionid(Integer divisionid) {
		this.divisionid = divisionid;
	}

	public Integer getSubdivisionid() {
		return subdivisionid;
	}

	public void setSubdivisionid(Integer subdivisionid) {
		this.subdivisionid = subdivisionid;
	}

	public String getEmpaddress1() {
		return empaddress1;
	}

	public void setEmpaddress1(String empaddress1) {
		this.empaddress1 = empaddress1;
	}

	public String getDesgination() {
		return desgination;
	}

	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

}
