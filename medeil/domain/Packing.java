package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_packing", catalog = "medc_deliveryprocess")
public class Packing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PackingAutoID")
	private int id;
	private String packingno;
	private Integer picklistrefid;
	private Integer salesinvoiceno;
	private Integer createdby;
	private String createddate;
	private Integer modifiedby;
	private String modifieddate;
	private String clientcdate;
	private String clientmdate;
	private Integer status;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer calcflag;
	private Integer custrefid;
	private Integer picklistemprefid;
	private Integer emprefid;
	private Integer emprefidwrap;
	private Integer emprefidlabel;
	private Integer pack_materialrefid;
	private Integer packageweight;
	private String package_videoref;
	private Integer countryrefid;
	private String qrcoderefid;
	private String barcoderefid;
	private Integer wrapping_check_status;
	private Integer salesorderrefid;
	private Integer sotypeid;
	private Integer totalprod;

	public Integer getSalesorderrefid() {
		return salesorderrefid;
	}

	public void setSalesorderrefid(Integer salesorderrefid) {
		this.salesorderrefid = salesorderrefid;
	}

	public Integer getSotypeid() {
		return sotypeid;
	}

	public void setSotypeid(Integer sotypeid) {
		this.sotypeid = sotypeid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackingno() {
		return packingno;
	}

	public void setPackingno(String packingno) {
		this.packingno = packingno;
	}

	public Integer getPicklistrefid() {
		return picklistrefid;
	}

	public void setPicklistrefid(Integer picklistrefid) {
		this.picklistrefid = picklistrefid;
	}

	public Integer getSalesinvoiceno() {
		return salesinvoiceno;
	}

	public void setSalesinvoiceno(Integer salesinvoiceno) {
		this.salesinvoiceno = salesinvoiceno;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public Integer getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
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

	public Integer getCalcflag() {
		return calcflag;
	}

	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
	}

	public Integer getCustrefid() {
		return custrefid;
	}

	public void setCustrefid(Integer custrefid) {
		this.custrefid = custrefid;
	}

	public Integer getPicklistemprefid() {
		return picklistemprefid;
	}

	public void setPicklistemprefid(Integer picklistemprefid) {
		this.picklistemprefid = picklistemprefid;
	}

	public Integer getEmprefid() {
		return emprefid;
	}

	public void setEmprefid(Integer emprefid) {
		this.emprefid = emprefid;
	}

	public Integer getEmprefidwrap() {
		return emprefidwrap;
	}

	public void setEmprefidwrap(Integer emprefidwrap) {
		this.emprefidwrap = emprefidwrap;
	}

	public Integer getEmprefidlabel() {
		return emprefidlabel;
	}

	public void setEmprefidlabel(Integer emprefidlabel) {
		this.emprefidlabel = emprefidlabel;
	}

	public Integer getPack_materialrefid() {
		return pack_materialrefid;
	}

	public void setPack_materialrefid(Integer pack_materialrefid) {
		this.pack_materialrefid = pack_materialrefid;
	}

	public Integer getPackageweight() {
		return packageweight;
	}

	public void setPackageweight(Integer packageweight) {
		this.packageweight = packageweight;
	}

	public String getPackage_videoref() {
		return package_videoref;
	}

	public void setPackage_videoref(String package_videoref) {
		this.package_videoref = package_videoref;
	}

	public Integer getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
	}

	public String getQrcoderefid() {
		return qrcoderefid;
	}

	public void setQrcoderefid(String qrcoderefid) {
		this.qrcoderefid = qrcoderefid;
	}

	public String getBarcoderefid() {
		return barcoderefid;
	}

	public void setBarcoderefid(String barcoderefid) {
		this.barcoderefid = barcoderefid;
	}

	public Integer getWrapping_check_status() {
		return wrapping_check_status;
	}

	public void setWrapping_check_status(Integer wrapping_check_status) {
		this.wrapping_check_status = wrapping_check_status;
	}

	public Integer getTotalprod() {
		return totalprod;
	}

	public void setTotalprod(Integer totalprod) {
		this.totalprod = totalprod;
	}
}
