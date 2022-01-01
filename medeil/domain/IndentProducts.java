package com.medeil.domain;

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
@Table(name = "medc_indentproduct", catalog = "medc_indentmaster")
public class IndentProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "indentprdid")
	private int id;
	

	private Integer indentrefid;
	private Integer drugprdrefid;

	private Integer batchno;
	private Double boxqty;
	private Double stripqty;

	private Double tabqty;
	private Double qty;

	private Double approvedqty;
	private Double locrefid;
	private Double locname;

	private Double boxconvdrg;
	private Double stripconvdrg;

	private Double minqty;
	private Double maxqty;

	private Boolean delflag = false;

	private String clientcdate;
	private String clientcdate1;

	private Double status = 0.0;

	private Integer calcflag;

	private String remarks;

	private String remarksappr;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;
	//private Boolean checkbox;
	private String drugname;
	private String packageunit;
	
	//Sivakumar-06/02/2020,For Single API(JPA)
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "indentrefid")
//	private IndentRequest indentrequest;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIndentrefid() {
		return indentrefid;
	}

	public void setIndentrefid(Integer indentrefid) {
		this.indentrefid = indentrefid;
	}

	public Integer getDrugprdrefid() {
		return drugprdrefid;
	}

	public void setDrugprdrefid(Integer drugprdrefid) {
		this.drugprdrefid = drugprdrefid;
	}

	public Integer getBatchno() {
		return batchno;
	}

	public void setBatchno(Integer batchno) {
		this.batchno = batchno;
	}

	public Double getBoxqty() {
		return boxqty;
	}

	public void setBoxqty(Double boxqty) {
		this.boxqty = boxqty;
	}

	public Double getStripqty() {
		return stripqty;
	}

	public void setStripqty(Double stripqty) {
		this.stripqty = stripqty;
	}

	public Double getTabqty() {
		return tabqty;
	}

	public void setTabqty(Double tabqty) {
		this.tabqty = tabqty;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getApprovedqty() {
		return approvedqty;
	}

	public void setApprovedqty(Double approvedqty) {
		this.approvedqty = approvedqty;
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

	public Double getBoxconvdrg() {
		return boxconvdrg;
	}

	public void setBoxconvdrg(Double boxconvdrg) {
		this.boxconvdrg = boxconvdrg;
	}

	public Double getStripconvdrg() {
		return stripconvdrg;
	}

	public void setStripconvdrg(Double stripconvdrg) {
		this.stripconvdrg = stripconvdrg;
	}

	public Double getMinqty() {
		return minqty;
	}

	public void setMinqty(Double minqty) {
		this.minqty = minqty;
	}

	public Double getMaxqty() {
		return maxqty;
	}

	public void setMaxqty(Double maxqty) {
		this.maxqty = maxqty;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarksappr() {
		return remarksappr;
	}

	public void setRemarksappr(String remarksappr) {
		this.remarksappr = remarksappr;
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

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public String getPackageunit() {
		return packageunit;
	}

	public void setPackageunit(String packageunit) {
		this.packageunit = packageunit;
	}

//	public Boolean getCheckbox() {
//		return checkbox;
//	}
//
//	public void setCheckbox(Boolean checkbox) {
//		this.checkbox = checkbox;
//	}

}
