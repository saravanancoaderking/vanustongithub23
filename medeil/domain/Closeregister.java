package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_closeregister", catalog = "medc_open_close_register")
public class Closeregister{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "closeregid")
	private int closeregid;
	
	private Integer openregid;
	
	private Integer employeeid;
	
	private Integer suserid;

	private String logintime;
	
	private String logouttime;
	
	private Integer counterid;
	
	private Integer openbalance;
	
	private Integer closedbalance;
	
	private Integer transactamt;
	
	private Integer differenceamt;
	
	private Integer inwards;
	
	private Integer outwards;
	
	private String closeregdetails;
	
	private Integer companyid;
	
	private Integer locname;

	private Integer locrefid;
	
	private Integer branchid;
	
	private Integer status;
	
	private Integer countryid;
	
	private String clientcdate;

	public int getCloseregid() {
		return closeregid;
	}

	public void setCloseregid(int closeregid) {
		this.closeregid = closeregid;
	}

	public Integer getOpenregid() {
		return openregid;
	}

	public void setOpenregid(Integer openregid) {
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

	public Integer getClosedbalance() {
		return closedbalance;
	}

	public void setClosedbalance(Integer closedbalance) {
		this.closedbalance = closedbalance;
	}

		public Integer getTransactamt() {
		return transactamt;
	}

	public void setTransactamt(Integer transactamt) {
		this.transactamt = transactamt;
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

	public Integer getDifferenceamt() {
		return differenceamt;
	}

	public void setDifferenceamt(Integer differenceamt) {
		this.differenceamt = differenceamt;
	}

	public Integer getInwards() {
		return inwards;
	}

	public void setInwards(Integer inwards) {
		this.inwards = inwards;
	}

	public Integer getOutwards() {
		return outwards;
	}

	public void setOutwards(Integer outwards) {
		this.outwards = outwards;
	}

	public String getCloseregdetails() {
		return closeregdetails;
	}

	public void setCloseregdetails(String closeregdetails) {
		this.closeregdetails = closeregdetails;
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

	public String getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	
	

}
