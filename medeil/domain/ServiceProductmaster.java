package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_serviceproductmaster", catalog = "medc_productmaster")
public class ServiceProductmaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sacprodid")
	private Integer id;
	private Integer servicecode;
	private String servicename;
	private Integer sacheader;
	private Integer sacsactioncode;
	private Integer sacgroupcode;
	private Integer saccode;
	private Integer sacsubcode;
	private Integer sacsubcode1;
	private String discountamt;
	private String gst;
	private Integer cessrate;
	private Integer countryid;
	private String productname;
	private String productprice;
	private Integer companyid;
	private Integer branchid;
	private Integer locname;
	private Integer locrefid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getServicecode() {
		return servicecode;
	}
	public void setServicecode(Integer servicecode) {
		this.servicecode = servicecode;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public Integer getSacheader() {
		return sacheader;
	}
	public void setSacheader(Integer sacheader) {
		this.sacheader = sacheader;
	}
	public Integer getSacsactioncode() {
		return sacsactioncode;
	}
	public void setSacsactioncode(Integer sacsactioncode) {
		this.sacsactioncode = sacsactioncode;
	}
	public Integer getSacgroupcode() {
		return sacgroupcode;
	}
	public void setSacgroupcode(Integer sacgroupcode) {
		this.sacgroupcode = sacgroupcode;
	}
	public Integer getSaccode() {
		return saccode;
	}
	public void setSaccode(Integer saccode) {
		this.saccode = saccode;
	}
	public Integer getSacsubcode() {
		return sacsubcode;
	}
	public void setSacsubcode(Integer sacsubcode) {
		this.sacsubcode = sacsubcode;
	}
	public Integer getSacsubcode1() {
		return sacsubcode1;
	}
	public void setSacsubcode1(Integer sacsubcode1) {
		this.sacsubcode1 = sacsubcode1;
	}
	public String getDiscountamt() {
		return discountamt;
	}
	public void setDiscountamt(String discountamt) {
		this.discountamt = discountamt;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public Integer getCessrate() {
		return cessrate;
	}
	public void setCessrate(Integer cessrate) {
		this.cessrate = cessrate;
	}
	public Integer getCountryid() {
		return countryid;
	}
	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductprice() {
		return productprice;
	}
	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}
	public Integer getCompanyid() {
		return companyid;
	}
	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}
	public Integer getBranchid() {
		return branchid;
	}
	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
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
}
