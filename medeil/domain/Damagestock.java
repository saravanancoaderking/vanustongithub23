package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Sabarish
 *
 */

@Entity
@Table(name = "medc_damagestocks", catalog = "medc_purchasereturn")
public class Damagestock implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DamageStkID")
	private Integer id;

	private String damagestockdate;
	private String invoiceno;
	private String invoicedate;
	private String distname;
	private String contactno;
	private Double totalamount;
	private String remarks;
	private Integer packing;
	private String damagestockno;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer vendorid;
	private Integer createdby;
	private Integer fromlocname;
	private Integer fromlocrefid;
	private Integer tolocname;
	private Integer tolocrefid;
	private String clientcdate;
	@Transient
	private Integer damagestkids;

	public Integer getDamagestkids() {
		return damagestkids;
	}

	public void setDamagestkids(Integer damagestkids) {
		this.damagestkids = damagestkids;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDamagestockdate() {
		return damagestockdate;
	}

	public void setDamagestockdate(String damagestockdate) {
		this.damagestockdate = damagestockdate;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}

	public String getDistname() {
		return distname;
	}

	public void setDistname(String distname) {
		this.distname = distname;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public Double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getPacking() {
		return packing;
	}

	public void setPacking(Integer packing) {
		this.packing = packing;
	}

	public String getDamagestockno() {
		return damagestockno;
	}

	public void setDamagestockno(String damagestockno) {
		this.damagestockno = damagestockno;
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

	public Integer getVendorid() {
		return vendorid;
	}

	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}

	public Integer getFromlocname() {
		return fromlocname;
	}

	public void setFromlocname(Integer fromlocname) {
		this.fromlocname = fromlocname;
	}

	public Integer getFromlocrefid() {
		return fromlocrefid;
	}

	public void setFromlocrefid(Integer fromlocrefid) {
		this.fromlocrefid = fromlocrefid;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
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

	
}