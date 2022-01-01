/**
 * 
 */
package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ajith Kumar
 *
 */
@Entity
@Table(name = "medc_salesorder", catalog = "medc_sales")
public class PatientLoginSalesorder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private Integer id;

	private String orderdate;

	private String deliverytype;
	
	private Integer patientid;

	private String salesorderno;

	private Double totalitem;

	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locname;

	private Integer locrefid;

	private String clientcdate;
	
	private Integer employeeid;
	
	private Integer sotype;
	
	private String   soinfo;

	private Integer tolocname;

	private Integer tolocrefid;
	
	private Integer salesstatus;

	private byte Productimg;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype;
	}

	public Integer getPatientid() {
		return patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

	public String getSalesorderno() {
		return salesorderno;
	}

	public void setSalesorderno(String salesorderno) {
		this.salesorderno = salesorderno;
	}

	public Double getTotalitem() {
		return totalitem;
	}

	public void setTotalitem(Double totalitem) {
		this.totalitem = totalitem;
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

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getSotype() {
		return sotype;
	}

	public void setSotype(Integer sotype) {
		this.sotype = sotype;
	}

	public String getSoinfo() {
		return soinfo;
	}

	public void setSoinfo(String soinfo) {
		this.soinfo = soinfo;
	}

	public Integer getTolocname() {
		return tolocname;
	}

	public void setTolocname(Integer tolocname) {
		this.tolocname = tolocname;
	}

	public Integer getTolocrefid() {
		return tolocrefid;
	}

	public void setTolocrefid(Integer tolocrefid) {
		this.tolocrefid = tolocrefid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getSalesstatus() {
		return salesstatus;
	}

	public void setSalesstatus(Integer salesstatus) {
		this.salesstatus = salesstatus;
	}

	public byte getProductimg() {
		return Productimg;
	}

	public void setProductimg(byte productimg) {
		Productimg = productimg;
	}

	
	
	
}
