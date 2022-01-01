package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_custpayment", catalog = "medc_checkmymedicine")

public class Customerpayments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payid")
	private Long id;
	
	private Integer customerid;
	
	private String razorpaycustomerid;
	
	private String paymentid;
	
	private String paymettype;
	
	private Integer amtpaid;
	
	private Integer razorpaycal;
	
	private Integer vanustoncal;
	
	private Integer vanustontax;
	
	private Integer shopamt;
	
	private Integer shopbalance;
	
	private String status;
	
	private Integer companyid;
	
	private Integer branchid;
	
	private Integer locname;
	
	private Integer locrefid;

	public Long getId() {
		return id;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public String getPaymettype() {
		return paymettype;
	}

	public Integer getAmtpaid() {
		return amtpaid;
	}

	public Integer getRazorpaycal() {
		return razorpaycal;
	}

	public Integer getVanustoncal() {
		return vanustoncal;
	}

	public Integer getVanustontax() {
		return vanustontax;
	}

	public Integer getShopamt() {
		return shopamt;
	}

	public Integer getShopbalance() {
		return shopbalance;
	}

	public String getStatus() {
		return status;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public Integer getLocname() {
		return locname;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public void setPaymettype(String paymettype) {
		this.paymettype = paymettype;
	}

	public void setAmtpaid(Integer amtpaid) {
		this.amtpaid = amtpaid;
	}

	public void setRazorpaycal(Integer razorpaycal) {
		this.razorpaycal = razorpaycal;
	}

	public void setVanustoncal(Integer vanustoncal) {
		this.vanustoncal = vanustoncal;
	}

	public void setVanustontax(Integer vanustontax) {
		this.vanustontax = vanustontax;
	}

	public void setShopamt(Integer shopamt) {
		this.shopamt = shopamt;
	}

	public void setShopbalance(Integer shopbalance) {
		this.shopbalance = shopbalance;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public String getRazorpaycustomerid() {
		return razorpaycustomerid;
	}

	public void setRazorpaycustomerid(String razorpaycustomerid) {
		this.razorpaycustomerid = razorpaycustomerid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	
}
