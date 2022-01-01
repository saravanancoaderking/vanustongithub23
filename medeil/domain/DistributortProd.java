package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_distproduct", catalog = "medc_distributor")
public class DistributortProd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distprdid")
	private Integer id;
	private Double distrefid;
	private Integer drugprdid;
	private Double masterprice;
	private String distprice;

	private Double locrefid;
	private Double locname;

	private Double distprdlocid;

	private Boolean proddelflag = false;
	private String distprodno;

	private Boolean delflag = false;

	private String clientcdate;
	private String clientcdate1;
	private String remarks;
	private Double status = 0.0;
	private Integer calcflag = 0;

	private Double creditdays;
	private Double leadtime;
	private Boolean selectflag = false;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getDistrefid() {
		return distrefid;
	}
	public void setDistrefid(Double distrefid) {
		this.distrefid = distrefid;
	}
	public Integer getDrugprdid() {
		return drugprdid;
	}
	public void setDrugprdid(Integer drugprdid) {
		this.drugprdid = drugprdid;
	}
	public Double getMasterprice() {
		return masterprice;
	}
	public void setMasterprice(Double masterprice) {
		this.masterprice = masterprice;
	}
	public String getDistprice() {
		return distprice;
	}
	public void setDistprice(String distprice) {
		this.distprice = distprice;
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
	public Double getDistprdlocid() {
		return distprdlocid;
	}
	public void setDistprdlocid(Double distprdlocid) {
		this.distprdlocid = distprdlocid;
	}
	public Boolean getProddelflag() {
		return proddelflag;
	}
	public void setProddelflag(Boolean proddelflag) {
		this.proddelflag = proddelflag;
	}
	public String getDistprodno() {
		return distprodno;
	}
	public void setDistprodno(String distprodno) {
		this.distprodno = distprodno;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public Boolean getSelectflag() {
		return selectflag;
	}
	public void setSelectflag(Boolean selectflag) {
		this.selectflag = selectflag;
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
