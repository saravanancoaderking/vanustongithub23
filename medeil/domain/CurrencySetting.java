package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_currencysettings", catalog = "medc_globalsettings")

public class CurrencySetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "currencyid")
	private Integer id;

	private int countryrefid;
	private int companyrefid;
	private int shoprefid;
	private int branchrefid;
	private int currencyrefid;
	private int status;
	private String currencysymbol;
	private int createdby;
	private String createddate;
	private int modifiedby;
	private String modifieddate;

	public int getCountryrefid() {
		return countryrefid;
	}

	public int getShoprefid() {
		return shoprefid;
	}

	public void setShoprefid(int shoprefid) {
		this.shoprefid = shoprefid;
	}

	public int getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(int branchrefid) {
		this.branchrefid = branchrefid;
	}

	public void setCountryrefid(int countryrefid) {
		this.countryrefid = countryrefid;
	}

	public int getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}

	public int getCurrencyrefid() {
		return currencyrefid;
	}

	public void setCurrencyrefid(int currencyrefid) {
		this.currencyrefid = currencyrefid;
	}

	public String getCurrencysymbol() {
		return currencysymbol;
	}

	public void setCurrencysymbol(String currencysymbol) {
		this.currencysymbol = currencysymbol;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public int getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
