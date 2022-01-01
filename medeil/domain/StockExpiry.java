package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_stockexpiry", catalog = "medc_stock")
public class StockExpiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stkexpautid")
	private int id;

	private Double stkexpid;
	private Double drugproductid;
	private Double batchrefid;
	private String batchnumber;
	private String expirydate;
	private Double actualstockqty;

	private Double expboxqty;
	private Double expstripqty;
	private Double exptabqty;

	private Double expstockqty;

	private Double locrefid;
	private Double locname;

	private Double boxconvstk;
	private Double stripconvstk;

	private String stkexpno;

	private Boolean delflag = false;

	private String clientcdate;
	private String clientcdate1;

	private Double status = 0.0;
	private Integer calcflag;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer tolocname;
	private Integer tolocrefid;
	private Double totalamt;
	private Integer vendorid;

	public Integer getVendorid() {
		return vendorid;
	}

	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTotalamt() {
		return totalamt;
	}

	public void setTotalamt(Double totalamt) {
		this.totalamt = totalamt;
	}

	public Double getStkexpid() {
		return stkexpid;
	}

	public void setStkexpid(Double stkexpid) {
		this.stkexpid = stkexpid;
	}

	public Double getDrugproductid() {
		return drugproductid;
	}

	public void setDrugproductid(Double drugproductid) {
		this.drugproductid = drugproductid;
	}

	public Double getBatchrefid() {
		return batchrefid;
	}

	public void setBatchrefid(Double batchrefid) {
		this.batchrefid = batchrefid;
	}

	public String getBatchnumber() {
		return batchnumber;
	}

	public void setBatchnumber(String batchnumber) {
		this.batchnumber = batchnumber;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public Double getActualstockqty() {
		return actualstockqty;
	}

	public void setActualstockqty(Double actualstockqty) {
		this.actualstockqty = actualstockqty;
	}

	public Double getExpstockqty() {
		return expstockqty;
	}

	public void setExpstockqty(Double expstockqty) {
		this.expstockqty = expstockqty;
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

	public String getStkexpno() {
		return stkexpno;
	}

	public void setStkexpno(String stkexpno) {
		this.stkexpno = stkexpno;
	}

	public Double getExpboxqty() {
		return expboxqty;
	}

	public void setExpboxqty(Double expboxqty) {
		this.expboxqty = expboxqty;
	}

	public Double getExpstripqty() {
		return expstripqty;
	}

	public void setExpstripqty(Double expstripqty) {
		this.expstripqty = expstripqty;
	}

	public Double getExptabqty() {
		return exptabqty;
	}

	public void setExptabqty(Double exptabqty) {
		this.exptabqty = exptabqty;
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

	public Boolean getDelflag() {
		return delflag;
	}

	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
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

	public Double getStatus() {
		return status;
	}

	public void setStatus(Double status) {
		this.status = status;
	}

	public Integer getCalcflag() {
		return calcflag;
	}

	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
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
