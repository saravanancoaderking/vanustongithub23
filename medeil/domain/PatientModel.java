package com.medeil.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medc_patientbasicinfo",catalog="medc_patientreg")
public class PatientModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "PatientID") 
	private int id;
	
	private int hospitalid;
	private String patientcode;
	private String patienttitle;
	private String patientfirstname ;
	private String patientlastname;
	private String gender;
	private String maritalstatus;
	
	private String patienttype;
	private String address1 ;
	private String address2;
	private int country;
	private int state;
	private int city ;
	private String pincode ;
	private int countrycode;
	private String mobile;
	private String phone;
	private String email;
	private String aadhaarcardno;
	private String language;
	private String description;
	private String ipaddress;
	private String latitude;
	private String longitude;
	
	private int  createdby ;
	  
	private int  status;
	
	
	private  double   locrefid;  
	private  double   locname  ;
	
	  
   private String patientno; 

	
	
	

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(int hospitalid) {
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

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
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

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(int countrycode) {
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






	public double getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(double locrefid) {
		this.locrefid = locrefid;
	}

	public double getLocname() {
		return locname;
	}

	public void setLocname(double locname) {
		this.locname = locname;
	}

	public String getPatientno() {
		return patientno;
	}

	public void setPatientno(String patientno) {
		this.patientno = patientno;
	}


	
	
	

	
	

}
