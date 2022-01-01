package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_stkrecproduct", catalog = "medc_stock")
public class StockRecProd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stkrecproid")
	private int id;

	private Double stkrecrefid;
	private Double stktrfrefid;

	private Double drugproductrefid;
	private Double batchrefid;

	private Double transferboxqty;
	private Double transferstripqty;
	private Double transfertabqty;
	private Integer transfertotalqty;

	private Integer receivetotalqty;
	private Double indrefid;

	private Double locrefid;
	private Double locname;

	private Double boxconvstk;
	private Double stripconvstk;

	private Integer fromlocname;
	private Integer fromlocrefid;
	private Integer tolocname;
	private Integer tolocrefid;

	private String clientcdate;

	private String clientcdate1;

	private Integer calcflag;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;

	private String remarks;

	private Double prodreqqty;
	private Double apprtotalqty;
	private Double waitingtotalqty;
	private Double rejectqty;

	private String batchname;

	private Date expirydate;

	private Double stkmainrefid;
	private Double stktransprodrefid;
	private String packageunit;
	
	public Double getStkmainrefid() {
		return stkmainrefid;
	}

	public void setStkmainrefid(Double stkmainrefid) {
		this.stkmainrefid = stkmainrefid;
	}

	public Double getStktransprodrefid() {
		return stktransprodrefid;
	}

	public void setStktransprodrefid(Double stktransprodrefid) {
		this.stktransprodrefid = stktransprodrefid;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getBatchname() {
		return batchname;
	}

	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}

	public Double getProdreqqty() {
		return prodreqqty;
	}

	public void setProdreqqty(Double prodreqqty) {
		this.prodreqqty = prodreqqty;
	}

	public Double getApprtotalqty() {
		return apprtotalqty;
	}

	public void setApprtotalqty(Double apprtotalqty) {
		this.apprtotalqty = apprtotalqty;
	}

	public Double getWaitingtotalqty() {
		return waitingtotalqty;
	}

	public void setWaitingtotalqty(Double waitingtotalqty) {
		this.waitingtotalqty = waitingtotalqty;
	}

	public Double getRejectqty() {
		return rejectqty;
	}

	public void setRejectqty(Double rejectqty) {
		this.rejectqty = rejectqty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getStkrecrefid() {
		return stkrecrefid;
	}

	public void setStkrecrefid(Double stkrecrefid) {
		this.stkrecrefid = stkrecrefid;
	}

	public Double getStktrfrefid() {
		return stktrfrefid;
	}

	public void setStktrfrefid(Double stktrfrefid) {
		this.stktrfrefid = stktrfrefid;
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

	public Double getTransferboxqty() {
		return transferboxqty;
	}

	public void setTransferboxqty(Double transferboxqty) {
		this.transferboxqty = transferboxqty;
	}

	public Double getTransferstripqty() {
		return transferstripqty;
	}

	public void setTransferstripqty(Double transferstripqty) {
		this.transferstripqty = transferstripqty;
	}

	public Double getTransfertabqty() {
		return transfertabqty;
	}

	public void setTransfertabqty(Double transfertabqty) {
		this.transfertabqty = transfertabqty;
	}

	public Double getIndrefid() {
		return indrefid;
	}

	public void setIndrefid(Double indrefid) {
		this.indrefid = indrefid;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getTransfertotalqty() {
		return transfertotalqty;
	}

	public void setTransfertotalqty(Integer transfertotalqty) {
		this.transfertotalqty = transfertotalqty;
	}

	public Integer getReceivetotalqty() {
		return receivetotalqty;
	}

	public void setReceivetotalqty(Integer receivetotalqty) {
		this.receivetotalqty = receivetotalqty;
	}

	public String getPackageunit() {
		return packageunit;
	}

	public void setPackageunit(String packageunit) {
		this.packageunit = packageunit;
	}

}
