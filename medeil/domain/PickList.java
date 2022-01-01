package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_wrhpicklist", catalog = "medc_stock")
public class PickList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "picklistautoid")
	private int id;

	private Integer picklistid;
	private Double putawayrefid;
	private Double drugproductrefid;
	private Double batchrefid;
	private Double createdby;

	
	private String clientcdate;
	private Double status;
	private Double locname;
	private Double locrefid;
	private Double boxconvstk;
	private Double stripconvstk;
	private String clientcdate1;
	private Double calcflag;
	private Double tolocname;
	private Double tolocrefid;
	private String blockno;
	private String rackno;
	private String picklistno;
	private Double custrefid;
	private Double emprefid;
	private String orderno;
	
	

	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Double getPutawayrefid() {
		return putawayrefid;
	}
	public void setPutawayrefid(Double putawayrefid) {
		this.putawayrefid = putawayrefid;
	}
	public Double getDrugproductrefid() {
		return drugproductrefid;
	}
	public void setDrugproductrefid(Double drugproductrefid) {
		this.drugproductrefid = drugproductrefid;
	}
	public Double getBatchrefid() {
		return batchrefid;
	}
	public void setBatchrefid(Double batchrefid) {
		this.batchrefid = batchrefid;
	}
	public Double getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Double createdby) {
		this.createdby = createdby;
	}
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public Double getStatus() {
		return status;
	}
	public void setStatus(Double status) {
		this.status = status;
	}
	public Double getLocname() {
		return locname;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public Double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}
	public Double getBoxconvstk() {
		return boxconvstk;
	}
	public void setBoxconvstk(Double boxconvstk) {
		this.boxconvstk = boxconvstk;
	}
	public Double getStripconvstk() {
		return stripconvstk;
	}
	public void setStripconvstk(Double stripconvstk) {
		this.stripconvstk = stripconvstk;
	}
	public String getClientcdate1() {
		return clientcdate1;
	}
	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}
	public Double getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Double calcflag) {
		this.calcflag = calcflag;
	}
	public Double getTolocname() {
		return tolocname;
	}
	public void setTolocname(Double tolocname) {
		this.tolocname = tolocname;
	}
	public Double getTolocrefid() {
		return tolocrefid;
	}
	public void setTolocrefid(Double tolocrefid) {
		this.tolocrefid = tolocrefid;
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
	public String getPicklistno() {
		return picklistno;
	}
	public void setPicklistno(String picklistno) {
		this.picklistno = picklistno;
	}
	public Double getCustrefid() {
		return custrefid;
	}
	public void setCustrefid(Double custrefid) {
		this.custrefid = custrefid;
	}
	public Double getEmprefid() {
		return emprefid;
	}
	public void setEmprefid(Double emprefid) {
		this.emprefid = emprefid;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	
	
	

	
	
	public Integer getPicklistid() {
		return picklistid;
	}
	public void setPicklistid(Integer picklistid) {
		this.picklistid = picklistid;
	}
	public Integer getCountryrefid() {
		return countryrefid;
	}
	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
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
	
	
	
	
	
	

}
