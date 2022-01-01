package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_cust_loyalitypoints", catalog = "medc_loyality")
public class Customerloyaltypoints implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custpointid")
	private Long id;
	
	private Integer loyalitypointrefid;

	private Integer custrefid;

	private Integer currentprice;
	
	private Integer currentloyalpoints;

	private Integer totalpurchaseprice;

	private Integer totalloyalpoints;

	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locname;

	private Integer locrefid;
	
	private Integer status;
	
	private Integer availloyalpoints;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLoyalitypointrefid() {
		return loyalitypointrefid;
	}

	public void setLoyalitypointrefid(Integer loyalitypointrefid) {
		this.loyalitypointrefid = loyalitypointrefid;
	}

	public Integer getCustrefid() {
		return custrefid;
	}

	public void setCustrefid(Integer custrefid) {
		this.custrefid = custrefid;
	}

	public Integer getCurrentprice() {
		return currentprice;
	}

	public void setCurrentprice(Integer currentprice) {
		this.currentprice = currentprice;
	}

	public Integer getCurrentloyalpoints() {
		return currentloyalpoints;
	}

	public void setCurrentloyalpoints(Integer currentloyalpoints) {
		this.currentloyalpoints = currentloyalpoints;
	}

	public Integer getTotalpurchaseprice() {
		return totalpurchaseprice;
	}

	public void setTotalpurchaseprice(Integer totalpurchaseprice) {
		this.totalpurchaseprice = totalpurchaseprice;
	}

	public Integer getTotalloyalpoints() {
		return totalloyalpoints;
	}

	public void setTotalloyalpoints(Integer totalloyalpoints) {
		this.totalloyalpoints = totalloyalpoints;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAvailloyalpoints() {
		return availloyalpoints;
	}

	public void setAvailloyalpoints(Integer availloyalpoints) {
		this.availloyalpoints = availloyalpoints;
	}

	
	
}
