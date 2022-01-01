package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "medc_package_productdetails", catalog = "medc_deliveryprocess")
public class PackingProducts implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "package_prodid")
	private int package_prodid;
	
	private int packagerefid;
	private String packageno;
	private String salesinvoiceno;
	private Integer drugproductrefid;
	private String brandname;
	private String dosage;
	private String formulation;
	private int batchrefid;
	private int createdby;
	private String createddate;
	private int modifiedby;
	private String modifieddate;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private int countryrefid;
	private int boxqty;
	private int stripqty;
	private int tabqty;
	private int qty;
	private int returnqty;
	private int returnid;
	private String remarks;
	private String expirydate;
	
	//Sivakumar-07/02/2020,For Single API(JPA)
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "packagerefid")
//	private Packing packing;

	
	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getPackage_prodid() {
		return package_prodid;
	}

	public void setPackage_prodid(int package_prodid) {
		this.package_prodid = package_prodid;
	}

	public int getPackagerefid() {
		return packagerefid;
	}

	public void setPackagerefid(int packagerefid) {
		this.packagerefid = packagerefid;
	}

	public String getPackageno() {
		return packageno;
	}

	public void setPackageno(String packageno) {
		this.packageno = packageno;
	}

	public String getSalesinvoiceno() {
		return salesinvoiceno;
	}

	public void setSalesinvoiceno(String salesinvoiceno) {
		this.salesinvoiceno = salesinvoiceno;
	}

	public Integer getDrugproductrefid() {
		return drugproductrefid;
	}

	public void setDrugproductrefid(Integer drugproductrefid) {
		this.drugproductrefid = drugproductrefid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getFormulation() {
		return formulation;
	}

	public void setFormulation(String formulation) {
		this.formulation = formulation;
	}

	public int getBatchrefid() {
		return batchrefid;
	}

	public void setBatchrefid(int batchrefid) {
		this.batchrefid = batchrefid;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public int getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public int getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}

	public int getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(int branchrefid) {
		this.branchrefid = branchrefid;
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

	public int getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(int countryrefid) {
		this.countryrefid = countryrefid;
	}

	public int getBoxqty() {
		return boxqty;
	}

	public void setBoxqty(int boxqty) {
		this.boxqty = boxqty;
	}

	public int getStripqty() {
		return stripqty;
	}

	public void setStripqty(int stripqty) {
		this.stripqty = stripqty;
	}

	public int getTabqty() {
		return tabqty;
	}

	public void setTabqty(int tabqty) {
		this.tabqty = tabqty;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getReturnqty() {
		return returnqty;
	}

	public void setReturnqty(int returnqty) {
		this.returnqty = returnqty;
	}

	public int getReturnid() {
		return returnid;
	}

	public void setReturnid(int returnid) {
		this.returnid = returnid;
	}

//	public Packing getPacking() {
//		return packing;
//	}
//
//	public void setPacking(Packing packing) {
//		this.packing = packing;
//	}

}
