/**
 * 
 */
package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author www
 *
 */
@Entity
@Table(name = "medc_prescriptiondigiproduct", catalog = "medc_sales")
public class Prescdigiproduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "presproductid")
	private int id;

	private int pdigitalizedrefid;
	// private String pdigirefno;
	private int drugproductid;
	private int qty;
	private double days;
	private double morning;
	private double afternoon;
	private double evening;
	private double night;
	private String food;
	private int createdby;
	private java.util.Date createddate;
	private int modifiedby;
	private java.util.Date modifieddate;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPdigitalizedrefid() {
		return pdigitalizedrefid;
	}

	public void setPdigitalizedrefid(int pdigitalizedrefid) {
		this.pdigitalizedrefid = pdigitalizedrefid;
	}

	public int getDrugproductid() {
		return drugproductid;
	}

	public void setDrugproductid(int drugproductid) {
		this.drugproductid = drugproductid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getDays() {
		return days;
	}

	public void setDays(double days) {
		this.days = days;
	}

	public double getMorning() {
		return morning;
	}

	public void setMorning(double morning) {
		this.morning = morning;
	}

	public double getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(double afternoon) {
		this.afternoon = afternoon;
	}

	public double getEvening() {
		return evening;
	}

	public void setEvening(double evening) {
		this.evening = evening;
	}

	public double getNight() {
		return night;
	}

	public void setNight(double night) {
		this.night = night;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public java.util.Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(java.util.Date createddate) {
		this.createddate = createddate;
	}

	public int getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}

	public java.util.Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(java.util.Date modifieddate) {
		this.modifieddate = modifieddate;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
