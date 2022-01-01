package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_prescprod", catalog = "medc_clinic")
public class PrescProd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prcprodid")
	private int id;

	private Double prsrefid;
	private Double drugproductid;


	private Double morning;
	private Double afternoon;
	private Double evening;
	private Double night;
	private Double days;
	private Double food;
	private Double dose;
	private Double total_medications;
	private Double pres_key;
	private Double createdby;

	private Double locname;
	private Double locrefid;
	
	private  Boolean   delflag = false  ;
	
	
	private String clientcdate;
	private String clientcdate1;
	private Double   status =0.0 ;  ;
	
	
	private  Integer   calcflag  ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getPrsrefid() {
		return prsrefid;
	}
	public void setPrsrefid(Double prsrefid) {
		this.prsrefid = prsrefid;
	}
	public Double getDrugproductid() {
		return drugproductid;
	}
	public void setDrugproductid(Double drugproductid) {
		this.drugproductid = drugproductid;
	}
	public Double getMorning() {
		return morning;
	}
	public void setMorning(Double morning) {
		this.morning = morning;
	}
	public Double getAfternoon() {
		return afternoon;
	}
	public void setAfternoon(Double afternoon) {
		this.afternoon = afternoon;
	}
	public Double getEvening() {
		return evening;
	}
	public void setEvening(Double evening) {
		this.evening = evening;
	}
	public Double getNight() {
		return night;
	}
	public void setNight(Double night) {
		this.night = night;
	}
	public Double getDays() {
		return days;
	}
	public void setDays(Double days) {
		this.days = days;
	}
	public Double getFood() {
		return food;
	}
	public void setFood(Double food) {
		this.food = food;
	}
	public Double getDose() {
		return dose;
	}
	public void setDose(Double dose) {
		this.dose = dose;
	}
	public Double getTotal_medications() {
		return total_medications;
	}
	public void setTotal_medications(Double total_medications) {
		this.total_medications = total_medications;
	}
	public Double getPres_key() {
		return pres_key;
	}
	public void setPres_key(Double pres_key) {
		this.pres_key = pres_key;
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
	public Double getStatus() {
		return status;
	}
	public void setStatus(Double status) {
		this.status = status;
	}
	public Integer getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
	}
	



	
	
	

}
