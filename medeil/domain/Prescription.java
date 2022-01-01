package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_prescription", catalog = "medc_clinic")
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prescid")
	private int id;


	private Double docrefid;
	private Double custrefid;
	private Double age;
	private Double gender;
	private Double weight;
	private Double temperature;
	private Double blood_sugar;
	private Double blood_pressure;
	private Double diagnosis;
	private String remarks;
	private Double consultation_fee;
	private Double next_visit;
	private Double del_flag;
	private Double createdby;

	private Double locname;
	private Double locrefid;
	
	
	private String prcno;
	
	
	private  Boolean   delflag = false  ;
	
	
	private String clientcdate;
	private String clientcdate1;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public Double getDocrefid() {
		return docrefid;
	}
	public void setDocrefid(Double docrefid) {
		this.docrefid = docrefid;
	}
	public Double getCustrefid() {
		return custrefid;
	}
	public void setCustrefid(Double custrefid) {
		this.custrefid = custrefid;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public Double getGender() {
		return gender;
	}
	public void setGender(Double gender) {
		this.gender = gender;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getBlood_sugar() {
		return blood_sugar;
	}
	public void setBlood_sugar(Double blood_sugar) {
		this.blood_sugar = blood_sugar;
	}
	public Double getBlood_pressure() {
		return blood_pressure;
	}
	public void setBlood_pressure(Double blood_pressure) {
		this.blood_pressure = blood_pressure;
	}
	public Double getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(Double diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Double getConsultation_fee() {
		return consultation_fee;
	}
	public void setConsultation_fee(Double consultation_fee) {
		this.consultation_fee = consultation_fee;
	}
	public Double getNext_visit() {
		return next_visit;
	}
	public void setNext_visit(Double next_visit) {
		this.next_visit = next_visit;
	}
	public Double getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Double del_flag) {
		this.del_flag = del_flag;
	}
	public Double getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Double createdby) {
		this.createdby = createdby;
	}

	public Double getLocname() {
		return locname;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public Double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}
	public String getPrcno() {
		return prcno;
	}
	public void setPrcno(String prcno) {
		this.prcno = prcno;
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





	
	


}
