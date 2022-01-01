package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_delivery_status", catalog = "medc_checkmymedicine")

public class CustomerDelivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deliveryid")
	private Long id;

	private Integer companyid;
	
	private Integer emplyoeeid;
	
	private Integer customerid;
	
	private String custpaymenttpe;
	
	private Integer salesorderid;
	
	private String orderdate;
	
	private Double totalitem;
	
	private Double totalamt;
	
	private Double paymentamt;
	
	private Double creditamt;
	
	private String customeraddress;
	
	private String paymentdate;
	
	private String paymentstatus;
	
	private String description;
	
	private Integer status;
	
	private Integer branchid;
	
	private Integer localname;

	private Integer locrefid;

	public Long getId() {
		return id;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public Integer getEmplyoeeid() {
		return emplyoeeid;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public String getCustpaymenttpe() {
		return custpaymenttpe;
	}

	public Integer getSalesorderid() {
		return salesorderid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public Double getTotalitem() {
		return totalitem;
	}

	public Double getTotalamt() {
		return totalamt;
	}

	public Double getPaymentamt() {
		return paymentamt;
	}

	public Double getCreditamt() {
		return creditamt;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public String getPaymentdate() {
		return paymentdate;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public String getDescription() {
		return description;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public Integer getLocalname() {
		return localname;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public void setEmplyoeeid(Integer emplyoeeid) {
		this.emplyoeeid = emplyoeeid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public void setCustpaymenttpe(String custpaymenttpe) {
		this.custpaymenttpe = custpaymenttpe;
	}

	public void setSalesorderid(Integer salesorderid) {
		this.salesorderid = salesorderid;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public void setTotalitem(Double totalitem) {
		this.totalitem = totalitem;
	}

	public void setTotalamt(Double totalamt) {
		this.totalamt = totalamt;
	}

	public void setPaymentamt(Double paymentamt) {
		this.paymentamt = paymentamt;
	}

	public void setCreditamt(Double creditamt) {
		this.creditamt = creditamt;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public void setLocalname(Integer localname) {
		this.localname = localname;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}
	

}
