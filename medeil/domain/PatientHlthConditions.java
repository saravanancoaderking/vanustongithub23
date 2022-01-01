package com.medeil.domain;

public class PatientHlthConditions {
	

	
	
	private int id;
	
	private String cust_code;
	
	

	private String cust_name  ;
	
	private String patient_allergies    ;
	
	private String patient_health_conditions    ;
	
	
	private  double   locrefid;  
	private  double   locname  ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCust_code() {
		return cust_code;
	}

	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getPatient_allergies() {
		return patient_allergies;
	}

	public void setPatient_allergies(String patient_allergies) {
		this.patient_allergies = patient_allergies;
	}

	public String getPatient_health_conditions() {
		return patient_health_conditions;
	}

	public void setPatient_health_conditions(String patient_health_conditions) {
		this.patient_health_conditions = patient_health_conditions;
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
	
	
	
}
