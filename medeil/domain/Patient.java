package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_patientbasicinfo", catalog = "medc_patientreg")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PatientID")
	private int id;

	private Integer hospitalid;
	private String patientcode;
	private String patienttitle;
	private String patientfirstname;
	private String patientlastname;
	private String gender;
	private String maritalstatus;
	private String dob;
	private String patienttype;
	private String address1;
	private String address2;
	private String  shipmentaddress;
	private Integer country;
	private Integer state;
	private Integer city;
	private String pincode;
	private Integer countrycode;
	private String mobile;
	private String phone;
	private String email;
	private String aadhaarcardno;
	private String language;
	private String description;
	private String ipaddress;
	private String latitude;
	private String longitude;
	private Integer productid;
	private Integer createdby;

	private Integer status = 0;

	private Integer locrefid;
	private Double locname;

	private String patientno;

	private Boolean delflag = false;

	private String clientcdate;
	private String clientcdate1;

	private String tinno;
	private String gstno;
	private String vatno;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;

	private Boolean scitizenflag = false;
	private Boolean phycapflag = false;

	private String scitizenno;
	private String phycapno;
	private Integer age;
	private String custmemberid;
	private Integer patientcattypeid;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(Integer hospitalid) {
		this.hospitalid = hospitalid;
	}

	public String getPatientcode() {
		return patientcode;
	}

	public void setPatientcode(String patientcode) {
		this.patientcode = patientcode;
	}

	public String getPatienttitle() {
		return patienttitle;
	}

	public void setPatienttitle(String patienttitle) {
		this.patienttitle = patienttitle;
	}

	public String getPatientfirstname() {
		return patientfirstname;
	}

	public void setPatientfirstname(String patientfirstname) {
		this.patientfirstname = patientfirstname;
	}

	public String getPatientlastname() {
		return patientlastname;
	}

	public void setPatientlastname(String patientlastname) {
		this.patientlastname = patientlastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getShipmentaddress() {
		return shipmentaddress;
	}

	public void setShipmentaddress(String shipmentaddress) {
		this.shipmentaddress = shipmentaddress;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPatienttype() {
		return patienttype;
	}

	public void setPatienttype(String patienttype) {
		this.patienttype = patienttype;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Integer getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(Integer countrycode) {
		this.countrycode = countrycode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadhaarcardno() {
		return aadhaarcardno;
	}

	public void setAadhaarcardno(String aadhaarcardno) {
		this.aadhaarcardno = aadhaarcardno;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getLocname() {
		return locname;
	}

	public void setLocname(Double locname) {
		this.locname = locname;
	}

	public String getPatientno() {
		return patientno;
	}

	public void setPatientno(String patientno) {
		this.patientno = patientno;
	}

	public Boolean getDelflag() {
		return delflag;
	}

	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getClientcdate1() {
		return clientcdate1;
	}

	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}

	public String getTinno() {
		return tinno;
	}

	public void setTinno(String tinno) {
		this.tinno = tinno;
	}

	public String getGstno() {
		return gstno;
	}

	public void setGstno(String gstno) {
		this.gstno = gstno;
	}

	public String getVatno() {
		return vatno;
	}

	public void setVatno(String vatno) {
		this.vatno = vatno;
	}

	public Integer getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
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

	public Boolean getScitizenflag() {
		return scitizenflag;
	}

	public void setScitizenflag(Boolean scitizenflag) {
		this.scitizenflag = scitizenflag;
	}

	public Boolean getPhycapflag() {
		return phycapflag;
	}

	public void setPhycapflag(Boolean phycapflag) {
		this.phycapflag = phycapflag;
	}

	public String getScitizenno() {
		return scitizenno;
	}

	public void setScitizenno(String scitizenno) {
		this.scitizenno = scitizenno;
	}

	public String getPhycapno() {
		return phycapno;
	}

	public void setPhycapno(String phycapno) {
		this.phycapno = phycapno;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getCustmemberid() {
		return custmemberid;
	}

	public void setCustmemberid(String custmemberid) {
		this.custmemberid = custmemberid;
	}

	public Integer getPatientcattypeid() {
		return patientcattypeid;
	}

	public void setPatientcattypeid(Integer patientcattypeid) {
		this.patientcattypeid = patientcattypeid;
	}

}
