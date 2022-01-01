package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_picking_productdetails", catalog = "medc_deliveryprocess")
public class PickingProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "picklistprodid")
	private int id;
	private int picklistrefid;
	private String drugproductrefid;
	private String dosage;
	private String formulation;
	private int batchrefid;
	private int putawayrefid;
	private String shelfno;
	private String blockno;
	private String rackno;
	private int createdby;
	private String createddate;
	private int modifiedby;
	private String modifieddate;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private int calcflag;
	private String brandname;
	private int countryrefid;
	private int boxqty;
	private int stripqty;
	private int tabqty;
	private int qty;
	private int availqty;
	private int pickedqty;
	private int returnqty;
	private int returnid;
	private int invoiceqty;
	private String remarks;
	private String expirydate;

//	//Sivakumar-06/02/2020,For Single API(JPA)
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "picklistrefid")
//	private Picking picking;

//	@JsonBackReference
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id", referencedColumnName = "pickid")
//	private Picking picking;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPicklistrefid() {
		return picklistrefid;
	}

	public void setPicklistrefid(int picklistrefid) {
		this.picklistrefid = picklistrefid;
	}

	public String getDrugproductrefid() {
		return drugproductrefid;
	}

	public void setDrugproductrefid(String drugproductrefid) {
		this.drugproductrefid = drugproductrefid;
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

	public int getPutawayrefid() {
		return putawayrefid;
	}

	public void setPutawayrefid(int putawayrefid) {
		this.putawayrefid = putawayrefid;
	}

	public String getShelfno() {
		return shelfno;
	}

	public void setShelfno(String shelfno) {
		this.shelfno = shelfno;
	}

	public String getBlockno() {
		return blockno;
	}

	public void setBlockno(String blockno) {
		this.blockno = blockno;
	}

	public String getRackno() {
		return rackno;
	}

	public void setRackno(String rackno) {
		this.rackno = rackno;
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

	public int getCalcflag() {
		return calcflag;
	}

	public void setCalcflag(int calcflag) {
		this.calcflag = calcflag;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
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

	public int getAvailqty() {
		return availqty;
	}

	public void setAvailqty(int availqty) {
		this.availqty = availqty;
	}

	public int getPickedqty() {
		return pickedqty;
	}

	public void setPickedqty(int pickedqty) {
		this.pickedqty = pickedqty;
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

	public int getInvoiceqty() {
		return invoiceqty;
	}

	public void setInvoiceqty(int invoiceqty) {
		this.invoiceqty = invoiceqty;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
}
