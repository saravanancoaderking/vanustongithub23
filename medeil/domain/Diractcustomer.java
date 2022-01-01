package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_customerinfo", catalog = "medc_checkmymedicine")

public class Diractcustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PatientID")
	private Long id;
	
	private Integer hospitalid;
	private String patientcode;
	private String patienttitle;
	private String patientfirstname;
	private String patientlastname;
	private String gender;
	private String maritalstatus;
	private String dob;
	private String patienttype;
	private String currentlocation;
	private String address1;
	private String address2;
	private String shipmentaddress;
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
	private Integer productid;
	public Long getId() {
		return id;
	}
	public Integer getHospitalid() {
		return hospitalid;
	}
	public String getPatientcode() {
		return patientcode;
	}
	public String getPatienttitle() {
		return patienttitle;
	}
	public String getPatientfirstname() {
		return patientfirstname;
	}
	public String getPatientlastname() {
		return patientlastname;
	}
	public String getGender() {
		return gender;
	}
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public String getDob() {
		return dob;
	}
	public String getPatienttype() {
		return patienttype;
	}
	public String getCurrentlocation() {
		return currentlocation;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getShipmentaddress() {
		return shipmentaddress;
	}
	public Integer getCountry() {
		return country;
	}
	public Integer getState() {
		return state;
	}
	public Integer getCity() {
		return city;
	}
	public String getPincode() {
		return pincode;
	}
	public Integer getCountrycode() {
		return countrycode;
	}
	public String getMobile() {
		return mobile;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getAadhaarcardno() {
		return aadhaarcardno;
	}
	public String getLanguage() {
		return language;
	}
	public String getDescription() {
		return description;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public Integer getCreatedby() {
		return createdby;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getLocrefid() {
		return locrefid;
	}
	public Double getLocname() {
		return locname;
	}
	public String getPatientno() {
		return patientno;
	}
	public Boolean getDelflag() {
		return delflag;
	}
	public String getClientcdate() {
		return clientcdate;
	}
	public String getClientcdate1() {
		return clientcdate1;
	}
	public String getTinno() {
		return tinno;
	}
	public String getGstno() {
		return gstno;
	}
	public String getVatno() {
		return vatno;
	}
	public Integer getCountryrefid() {
		return countryrefid;
	}
	public Integer getCompanyrefid() {
		return companyrefid;
	}
	public Integer getBranchrefid() {
		return branchrefid;
	}
	public Boolean getScitizenflag() {
		return scitizenflag;
	}
	public Boolean getPhycapflag() {
		return phycapflag;
	}
	public String getScitizenno() {
		return scitizenno;
	}
	public String getPhycapno() {
		return phycapno;
	}
	public Integer getAge() {
		return age;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setHospitalid(Integer hospitalid) {
		this.hospitalid = hospitalid;
	}
	public void setPatientcode(String patientcode) {
		this.patientcode = patientcode;
	}
	public void setPatienttitle(String patienttitle) {
		this.patienttitle = patienttitle;
	}
	public void setPatientfirstname(String patientfirstname) {
		this.patientfirstname = patientfirstname;
	}
	public void setPatientlastname(String patientlastname) {
		this.patientlastname = patientlastname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setPatienttype(String patienttype) {
		this.patienttype = patienttype;
	}
	public void setCurrentlocation(String currentlocation) {
		this.currentlocation = currentlocation;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setShipmentaddress(String shipmentaddress) {
		this.shipmentaddress = shipmentaddress;
	}
	public void setCountry(Integer country) {
		this.country = country;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public void setCountrycode(Integer countrycode) {
		this.countrycode = countrycode;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAadhaarcardno(String aadhaarcardno) {
		this.aadhaarcardno = aadhaarcardno;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public void setPatientno(String patientno) {
		this.patientno = patientno;
	}
	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}
	public void setTinno(String tinno) {
		this.tinno = tinno;
	}
	public void setGstno(String gstno) {
		this.gstno = gstno;
	}
	public void setVatno(String vatno) {
		this.vatno = vatno;
	}
	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
	}
	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}
	public void setBranchrefid(Integer branchrefid) {
		this.branchrefid = branchrefid;
	}
	public void setScitizenflag(Boolean scitizenflag) {
		this.scitizenflag = scitizenflag;
	}
	public void setPhycapflag(Boolean phycapflag) {
		this.phycapflag = phycapflag;
	}
	public void setScitizenno(String scitizenno) {
		this.scitizenno = scitizenno;
	}
	public void setPhycapno(String phycapno) {
		this.phycapno = phycapno;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}


}
