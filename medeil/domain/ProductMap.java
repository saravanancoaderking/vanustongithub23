package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_productmapping", catalog = "medc_productmaster")
public class ProductMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prodmapautoid")
	private int id;

	private Double productdrugid;
	private String brandname;
	private Double createdby;
	private Double locname;
	private Double locrefid;
	private Double prodmapid;
	private Double productdrugid1;
	private String brandname1;
	
	
	private String prodmapno;
	
	private String clientcdate;
	
	private String clientcdate1;
	
	private  Integer   calcflag  ;
	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getProductdrugid() {
		return productdrugid;
	}
	public void setProductdrugid(Double productdrugid) {
		this.productdrugid = productdrugid;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public Double getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Double createdby) {
		this.createdby = createdby;
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
	public Double getProdmapid() {
		return prodmapid;
	}
	public void setProdmapid(Double prodmapid) {
		this.prodmapid = prodmapid;
	}
	public Double getProductdrugid1() {
		return productdrugid1;
	}
	public void setProductdrugid1(Double productdrugid1) {
		this.productdrugid1 = productdrugid1;
	}
	public String getBrandname1() {
		return brandname1;
	}
	public void setBrandname1(String brandname1) {
		this.brandname1 = brandname1;
	}
	public String getProdmapno() {
		return prodmapno;
	}
	public void setProdmapno(String prodmapno) {
		this.prodmapno = prodmapno;
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
	
	
	

}
