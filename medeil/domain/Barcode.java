package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Barcode implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer product;
	public String mfbarcode;
	public String spcode;
	private Integer companyid;
	private Integer branchid;
	private Integer locname;
	private Integer locrefid;

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	public String getMfbarcode() {
		return mfbarcode;
	}

	public void setMfbarcode(String mfbarcode) {
		this.mfbarcode = mfbarcode;
	}

	public String getSpcode() {
		return spcode;
	}

	public void setSpcode(String spcode) {
		this.spcode = spcode;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	

}
