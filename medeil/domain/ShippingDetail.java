package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "medc_shippingdetails", catalog = "medc_deliveryprocess")

public class ShippingDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShippmentID")
	private Integer id;

	
	private Integer shiprefid;

	private String createddate;

	private String clientcdate;

	private Integer status;

	private Integer calcflag;

	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locrefid;

	private Integer locname;

	private String package_description;

	private Integer unitbox;

	private Integer unitweight;

	private Double unitprice;

	private Double unitshipmentcharge;
	
//	//Sivakumar-06/02/2020,For Single API(JPA)
//	@JsonBackReference
//		@ManyToOne(fetch = FetchType.LAZY)
//		@JoinColumn(name = "shiprefid")
//		private Shipping shipping;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShiprefid() {
		return shiprefid;
	}

	public void setShiprefid(Integer shiprefid) {
		this.shiprefid = shiprefid;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCalcflag() {
		return calcflag;
	}

	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
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

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public String getPackage_description() {
		return package_description;
	}

	public void setPackage_description(String package_description) {
		this.package_description = package_description;
	}

	public Integer getUnitbox() {
		return unitbox;
	}

	public void setUnitbox(Integer unitbox) {
		this.unitbox = unitbox;
	}

	public Integer getUnitweight() {
		return unitweight;
	}

	public void setUnitweight(Integer unitweight) {
		this.unitweight = unitweight;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getUnitshipmentcharge() {
		return unitshipmentcharge;
	}

	public void setUnitshipmentcharge(Double unitshipmentcharge) {
		this.unitshipmentcharge = unitshipmentcharge;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
