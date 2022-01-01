package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "barqr_settings", catalog = "medc_settings")
public class Barqrsettings implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int barqrid;
	private int barcodeheight;
	private int barcodewidth;
	private int qrcodeheight;
	private int qrcodewidth;
	
	public int getBarqrid() {
		return barqrid;
	}
	public void setBarqrid(int barqrid) {
		this.barqrid = barqrid;
	}
	public int getBarcodeheight() {
		return barcodeheight;
	}
	public void setBarcodeheight(int barcodeheight) {
		this.barcodeheight = barcodeheight;
	}
	public int getBarcodewidth() {
		return barcodewidth;
	}
	public void setBarcodewidth(int barcodewidth) {
		this.barcodewidth = barcodewidth;
	}
	public int getQrcodeheight() {
		return qrcodeheight;
	}
	public void setQrcodeheight(int qrcodeheight) {
		this.qrcodeheight = qrcodeheight;
	}
	public int getQrcodewidth() {
		return qrcodewidth;
	}
	public void setQrcodewidth(int qrcodewidth) {
		this.qrcodewidth = qrcodewidth;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
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
	private int companyid;
	private int branchid;
	private int locname;
	private int locrefid;
	
	
}
