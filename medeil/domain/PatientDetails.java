package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_inpatienteeg", catalog = "medc_patientreg")
public class PatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inpatientid")
	private int id;

	private String  cust_date ;

	@Column(name = "patientid")
	private Integer cust_code;

	@Column(name = "doctorid")
	private Integer doctor_name;

	private Integer hospitalid;

	@Column(name = "custtype")
	private String cust_type;

	@Column(name = "department")
	private String department;

	@Column(name = "wardno")
	private String ward_number;

	@Column(name = "roomno")
	private String room_number;

	
	
	
	
	
	
	
	private Double locrefid;
	private Double locname;

	
	  
	private String  patientdetno; 
		
	private String clientcdate;
	private String clientcdate1;
	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCust_date() {
		return cust_date;
	}
	public void setCust_date(String cust_date) {
		this.cust_date = cust_date;
	}
	public Integer getCust_code() {
		return cust_code;
	}
	public void setCust_code(Integer cust_code) {
		this.cust_code = cust_code;
	}
	public Integer getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(Integer doctor_name) {
		this.doctor_name = doctor_name;
	}
	public Integer getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(Integer hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getCust_type() {
		return cust_type;
	}
	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getWard_number() {
		return ward_number;
	}
	public void setWard_number(String ward_number) {
		this.ward_number = ward_number;
	}
	public String getRoom_number() {
		return room_number;
	}
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	public Double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}
	public Double getLocname() {
		return locname;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public String getPatientdetno() {
		return patientdetno;
	}
	public void setPatientdetno(String patientdetno) {
		this.patientdetno = patientdetno;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
