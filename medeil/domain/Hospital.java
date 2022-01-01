package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospitalregistration", catalog = "medc_hospitalreg")
public class Hospital implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HospitalID")
	private Integer id;

	private String hospitalname;

	private String registrationno;

	private Integer specialityid;

	private String hosheadquarters;

	private String hosaddress1;

	private String hosaddress2;

	private String hospincode;

	private Integer countryid;

	private Integer stateid;

	private Integer city;

	private String countrycode;

	private String phoneno;

	private String helpline;

	private String email;

	private Integer status;

	private Integer companyrefid;

	private Integer branchrefid;
	
	private Integer locname;

	private Integer locrefid;

	private String clientcdate;

	private Integer registerflag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}

	public String getRegistrationno() {
		return registrationno;
	}

	public void setRegistrationno(String registrationno) {
		this.registrationno = registrationno;
	}

	public Integer getSpecialityid() {
		return specialityid;
	}

	public void setSpecialityid(Integer specialityid) {
		this.specialityid = specialityid;
	}

	public String getHosheadquarters() {
		return hosheadquarters;
	}

	public void setHosheadquarters(String hosheadquarters) {
		this.hosheadquarters = hosheadquarters;
	}

	public String getHosaddress1() {
		return hosaddress1;
	}

	public void setHosaddress1(String hosaddress1) {
		this.hosaddress1 = hosaddress1;
	}

	public String getHosaddress2() {
		return hosaddress2;
	}

	public void setHosaddress2(String hosaddress2) {
		this.hosaddress2 = hosaddress2;
	}

	public String getHospincode() {
		return hospincode;
	}

	public void setHospincode(String hospincode) {
		this.hospincode = hospincode;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public Integer getStateid() {
		return stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getHelpline() {
		return helpline;
	}

	public void setHelpline(String helpline) {
		this.helpline = helpline;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getRegisterflag() {
		return registerflag;
	}

	public void setRegisterflag(Integer registerflag) {
		this.registerflag = registerflag;
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

}