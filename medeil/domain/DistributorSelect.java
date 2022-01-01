package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_distselect", catalog = "medc_purchase")
public class DistributorSelect {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distslctproid")
	private int id;
	private Double distslctid;
	private Double prcenqrefid;
	private Double drugproductrefid;
	private Double batchrefid;
	private Double prodwaitingqty;
	private Double distpreprice;
	private Double distfinalprice;
	private Double vendorid;
	private Boolean vendorslctflag;

	private String clientcdate;
	private String clientcdate1;
	private Double locrefid;
	private Double locname;
	private Integer calcflag;

	private String distslctno;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;

	private Double creditdays;
	private Double leadtime;
	private Double exppoqty;
	private Double exppoprice;

	private String remarks;
	private String distremarks;

	private Double purcsessionrefid;
	private String pudate;

	public Double getPurcsessionrefid() {
		return purcsessionrefid;
	}

	public void setPurcsessionrefid(Double purcsessionrefid) {
		this.purcsessionrefid = purcsessionrefid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getDistslctid() {
		return distslctid;
	}

	public void setDistslctid(Double distslctid) {
		this.distslctid = distslctid;
	}

	public Double getPrcenqrefid() {
		return prcenqrefid;
	}

	public void setPrcenqrefid(Double prcenqrefid) {
		this.prcenqrefid = prcenqrefid;
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

	public Double getProdwaitingqty() {
		return prodwaitingqty;
	}

	public void setProdwaitingqty(Double prodwaitingqty) {
		this.prodwaitingqty = prodwaitingqty;
	}

	public Double getDistpreprice() {
		return distpreprice;
	}

	public void setDistpreprice(Double distpreprice) {
		this.distpreprice = distpreprice;
	}

	public Double getDistfinalprice() {
		return distfinalprice;
	}

	public void setDistfinalprice(Double distfinalprice) {
		this.distfinalprice = distfinalprice;
	}

	public Double getVendorid() {
		return vendorid;
	}

	public void setVendorid(Double vendorid) {
		this.vendorid = vendorid;
	}

	public Boolean getVendorslctflag() {
		return vendorslctflag;
	}

	public void setVendorslctflag(Boolean vendorslctflag) {
		this.vendorslctflag = vendorslctflag;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getClientcdate1() {
		return clientcdate1;
	}

	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}

	public Double getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}

	public Double getLocname() {
		return locname;
	}

	public void setLocname(Double locname) {
		this.locname = locname;
	}

	public Integer getCalcflag() {
		return calcflag;
	}

	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
	}

	public String getDistslctno() {
		return distslctno;
	}

	public void setDistslctno(String distslctno) {
		this.distslctno = distslctno;
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

	public Double getCreditdays() {
		return creditdays;
	}

	public void setCreditdays(Double creditdays) {
		this.creditdays = creditdays;
	}

	public Double getLeadtime() {
		return leadtime;
	}

	public void setLeadtime(Double leadtime) {
		this.leadtime = leadtime;
	}

	public Double getExppoqty() {
		return exppoqty;
	}

	public void setExppoqty(Double exppoqty) {
		this.exppoqty = exppoqty;
	}

	public Double getExppoprice() {
		return exppoprice;
	}

	public void setExppoprice(Double exppoprice) {
		this.exppoprice = exppoprice;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDistremarks() {
		return distremarks;
	}

	public void setDistremarks(String distremarks) {
		this.distremarks = distremarks;
	}

	public String getPudate() {
		return pudate;
	}

	public void setPudate(String pudate) {
		this.pudate = pudate;
	}

}
