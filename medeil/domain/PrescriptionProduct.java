package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_prescriptionproduct", catalog = "medc_practicemanagement")
public class PrescriptionProduct implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "presproid")
	private Integer id;
	private int drugproductid;
	private int morning;
	private int afternoon;
	private int evening;
	private int night;
	private int beforeafterfood;
	private int days;
	private int totalmedicine;
	private int mainpresrefid;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getDrugproductid() {
		return drugproductid;
	}
	public void setDrugproductid(int drugproductid) {
		this.drugproductid = drugproductid;
	}
	public int getMorning() {
		return morning;
	}
	public void setMorning(int morning) {
		this.morning = morning;
	}
	public int getAfternoon() {
		return afternoon;
	}
	public void setAfternoon(int afternoon) {
		this.afternoon = afternoon;
	}
	public int getEvening() {
		return evening;
	}
	public void setEvening(int evening) {
		this.evening = evening;
	}
	public int getNight() {
		return night;
	}
	public void setNight(int night) {
		this.night = night;
	}
	public int getBeforeafterfood() {
		return beforeafterfood;
	}
	public void setBeforeafterfood(int beforeafterfood) {
		this.beforeafterfood = beforeafterfood;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getTotalmedicine() {
		return totalmedicine;
	}
	public void setTotalmedicine(int totalmedicine) {
		this.totalmedicine = totalmedicine;
	}
	public int getMainpresrefid() {
		return mainpresrefid;
	}
	public void setMainpresrefid(int mainpresrefid) {
		this.mainpresrefid = mainpresrefid;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	
	public String toString() {
		return "PrescriptionProduct [id=" + id + ", drugproductid=" + drugproductid + ", morning=" + morning
				+ ", afternoon=" + afternoon + ", evening=" + evening + ", night=" + night + ", beforeafterfood="
				+ beforeafterfood + ", days=" + days + ", totalmedicine=" + totalmedicine + ", mainpresrefid="
				+ mainpresrefid + ", companyrefid=" + companyrefid + ", branchrefid=" + branchrefid + ", locname="
				+ locname + ", locrefid=" + locrefid + "]";
	}
	

	
	
}
