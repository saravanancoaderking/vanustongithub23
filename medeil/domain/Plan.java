package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_plan", catalog="medc_adminsecurity")
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "planid")
	private long id;
	
	private Integer countryid;

	private Integer productid;
	
	private Integer domainrefid;

	private Integer subdomainrefid;
	
	private Integer editionid;
	
	private String planname;
	
	private Integer amount;
	
	private Integer	intervalid;
	
	private String periodname;
	
	private String createddate;
	
	private String razorplanid;
	
	private Integer editiontype;
	
	private Integer storetype;

	public Integer getCountryid() {
		return countryid;
	}

	public Integer getDomainrefid() {
		return domainrefid;
	}

	public Integer getSubdomainrefid() {
		return subdomainrefid;
	}

	public Integer getEditionid() {
		return editionid;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public void setDomainrefid(Integer domainrefid) {
		this.domainrefid = domainrefid;
	}

	public void setSubdomainrefid(Integer subdomainrefid) {
		this.subdomainrefid = subdomainrefid;
	}

	public void setEditionid(Integer editionid) {
		this.editionid = editionid;
	}


	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public Integer getIntervalid() {
		return intervalid;
	}

	public String getPeriodname() {
		return periodname;
	}

	public void setIntervalid(Integer intervalid) {
		this.intervalid = intervalid;
	}

	public void setPeriodname(String periodname) {
		this.periodname = periodname;
	}

	public String getPlanname() {
		return planname;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getRazorplanid() {
		return razorplanid;
	}

	public void setRazorplanid(String razorplanid) {
		this.razorplanid = razorplanid;
	}

	public Integer getEditiontype() {
		return editiontype;
	}

	public void setEditiontype(Integer editiontype) {
		this.editiontype = editiontype;
	}

	public Integer getStoretype() {
		return storetype;
	}

	public void setStoretype(Integer storetype) {
		this.storetype = storetype;
	}
	
	
}
