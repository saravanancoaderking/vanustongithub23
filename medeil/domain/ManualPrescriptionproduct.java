package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medc_manualpresc_product" , catalog = "medc_prescription")
public class ManualPrescriptionproduct implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prescproductid")
	private Integer id;

	private Integer prescriptionrefid;
	private Integer drugproductid;
	private Integer qty;
	private Integer days;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer status;

	public int getPrescriptionrefid() {
		return prescriptionrefid;
	}

	public void setPrescriptionrefid(int prescriptionrefid) {
		this.prescriptionrefid = prescriptionrefid;
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

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
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
