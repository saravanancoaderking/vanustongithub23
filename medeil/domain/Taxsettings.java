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
 * @author Sabarish
 *
 */
@Entity
@Table(name = "medc_taxsettings", catalog = "medc_fixedsettings")
public class Taxsettings implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taxsetID")
	private Integer id;

	private Integer companyrefid;
	private Integer branchrefid;
	private Integer shoprefid;
	private Integer hospitalrefid;
	private Integer warehouserefid;
	private Integer purchasetax;
	private Integer salestax;
	private Integer vat_gst;
	private Integer locname;
	private Integer locrefid;
	private Integer countryrefid;
	private Integer stateid;
	private Integer status;
	private Integer createdby;
	private Integer modifiedby;
	private String clientcdate;
	private String clientmdate;
	private String remarks;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSgst() {
		return sgst;
	}

	public void setSgst(Integer sgst) {
		this.sgst = sgst;
	}

	public Integer getIgst() {
		return igst;
	}

	public void setIgst(Integer igst) {
		this.igst = igst;
	}

	public Integer getCgst() {
		return cgst;
	}

	public void setCgst(Integer cgst) {
		this.cgst = cgst;
	}

	public Integer getUgst() {
		return ugst;
	}

	public void setUgst(Integer ugst) {
		this.ugst = ugst;
	}

	private Integer acompanyrefid;
	private Integer abranchrefid;
	private Integer alocname;
	private Integer alocrefid;
	private Integer sgst;
	private Integer igst;
	private Integer cgst;
	private Integer ugst;

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

	public Integer getHospitalrefid() {
		return hospitalrefid;
	}

	public void setHospitalrefid(Integer hospitalrefid) {
		this.hospitalrefid = hospitalrefid;
	}

	public Integer getWarehouserefid() {
		return warehouserefid;
	}

	public void setWarehouserefid(Integer warehouserefid) {
		this.warehouserefid = warehouserefid;
	}

	public Integer getPurchasetax() {
		return purchasetax;
	}

	public void setPurchasetax(Integer purchasetax) {
		this.purchasetax = purchasetax;
	}

	public Integer getSalestax() {
		return salestax;
	}

	public void setSalestax(Integer salestax) {
		this.salestax = salestax;
	}

	public Integer getVat_gst() {
		return vat_gst;
	}

	public void setVat_gst(Integer vat_gst) {
		this.vat_gst = vat_gst;
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

	public Integer getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getAcompanyrefid() {
		return acompanyrefid;
	}

	public void setAcompanyrefid(Integer acompanyrefid) {
		this.acompanyrefid = acompanyrefid;
	}

	public Integer getAbranchrefid() {
		return abranchrefid;
	}

	public void setAbranchrefid(Integer abranchrefid) {
		this.abranchrefid = abranchrefid;
	}

	public Integer getAlocname() {
		return alocname;
	}

	public void setAlocname(Integer alocname) {
		this.alocname = alocname;
	}

	public Integer getAlocrefid() {
		return alocrefid;
	}

	public void setAlocrefid(Integer alocrefid) {
		this.alocrefid = alocrefid;
	}

	public Integer getStateid() {
		return stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
