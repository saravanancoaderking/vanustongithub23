package com.medeil.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_cashmanage", catalog = "medc_open_close_register")
public class CashManage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cashmanageid;
	private String cashform;
	private int cashtype;
	private String paytype;
	private String payamount;
	private String paydetails;
	private int suserrefid;
	private int companyid;
	private int branchid;
	private int locname;
	private int locrefid;
	private String distributorname;
	private String loyaltyamount;
	private String giftamount;
	private String dueamount;
	
	public int getCashmanageid() {
		return cashmanageid;
	}
	public void setCashmanageid(int cashmanageid) {
		this.cashmanageid = cashmanageid;
	}
	public String getCashform() {
		return cashform;
	}
	public void setCashform(String cashform) {
		this.cashform = cashform;
	}
	public int getCashtype() {
		return cashtype;
	}
	public void setCashtype(int cashtype) {
		this.cashtype = cashtype;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getPayamount() {
		return payamount;
	}
	public void setPayamount(String payamount) {
		this.payamount = payamount;
	}
	public String getPaydetails() {
		return paydetails;
	}
	public void setPaydetails(String paydetails) {
		this.paydetails = paydetails;
	}
	public int getSuserrefid() {
		return suserrefid;
	}
	public void setSuserrefid(int suserrefid) {
		this.suserrefid = suserrefid;
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
	public String getDistributorname() {
		return distributorname;
	}
	public void setDistributorname(String distributorname) {
		this.distributorname = distributorname;
	}
	public String getLoyaltyamount() {
		return loyaltyamount;
	}
	public void setLoyaltyamount(String loyaltyamount) {
		this.loyaltyamount = loyaltyamount;
	}
	public String getGiftamount() {
		return giftamount;
	}
	public void setGiftamount(String giftamount) {
		this.giftamount = giftamount;
	}
	public String getDueamount() {
		return dueamount;
	}
	public void setDueamount(String dueamount) {
		this.dueamount = dueamount;
	}
}
