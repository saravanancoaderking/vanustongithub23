package com.medeil.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_openregister", catalog = "medc_open_close_register")
public class Openregister{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int openregid;
	
	private Integer employeeid;
	
	private Integer suserid;
	
	private String logintime;
	
	private Integer counterid;
	
	private Integer openbalance;
	
	private Integer additionalamount;
	
	private String paymenttype;
	
	private String openregdetails;
	
	private Integer companyid;
	
	private Integer locname;

	private Integer locrefid;
	
	private Integer branchid;
	
	private Integer status;
	
	private Integer countryid;

	public int getOpenregid() {
		return openregid;
	}

	public void setOpenregid(int openregid) {
		this.openregid = openregid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getCounterid() {
		return counterid;
	}

	public void setCounterid(Integer counterid) {
		this.counterid = counterid;
	}

	public Integer getOpenbalance() {
		return openbalance;
	}

	public void setOpenbalance(Integer openbalance) {
		this.openbalance = openbalance;
	}

	public Integer getAdditionalamount() {
		return additionalamount;
	}

	public void setAdditionalamount(Integer additionalamount) {
		this.additionalamount = additionalamount;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getOpenregdetails() {
		return openregdetails;
	}

	public void setOpenregdetails(String openregdetails) {
		this.openregdetails = openregdetails;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
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

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public Integer getSuserid() {
		return suserid;
	}

	public void setSuserid(Integer suserid) {
		this.suserid = suserid;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	
	

}
