package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_packagematerial", catalog = "medc_deliveryprocess")
public class PackingMaterial implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pack_materialid;
	private String pack_materila;
	private double package_size;
	private double qty;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;

	public String getPack_materila() {
		return pack_materila;
	}

	public void setPack_materila(String pack_materila) {
		this.pack_materila = pack_materila;
	}

	public double getPackage_size() {
		return package_size;
	}

	public void setPackage_size(double package_size) {
		this.package_size = package_size;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
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
}
