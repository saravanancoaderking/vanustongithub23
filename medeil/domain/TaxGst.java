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
 * @author Vanuston
 *
 */
@Entity
@Table(name = "medc_taxgstmaster", catalog = "medc_globalsettings")
public class TaxGst implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gsttaxid")
	private Integer id;

	private Integer countryid;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer shoprefid;
	private Integer warehouserefid;
	private Integer hospitalrefid;
	private Double gst;
	private Integer createdby;
	private Integer modifiedby;
	private String clientcdate;
	private String clientmdate;
	private Integer status;
	private Integer locname;
	private Integer locrefid;

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
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

	public Integer getShoprefid() {
		return shoprefid;
	}

	public void setShoprefid(Integer shoprefid) {
		this.shoprefid = shoprefid;
	}

	public Integer getWarehouserefid() {
		return warehouserefid;
	}

	public void setWarehouserefid(Integer warehouserefid) {
		this.warehouserefid = warehouserefid;
	}

	public Integer getHospitalrefid() {
		return hospitalrefid;
	}

	public void setHospitalrefid(Integer hospitalrefid) {
		this.hospitalrefid = hospitalrefid;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Integer getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getClientmdate() {
		return clientmdate;
	}

	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

}
