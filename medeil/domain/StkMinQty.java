package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medc_stockminqty", catalog = "medc_stock")
public class StkMinQty {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stkminautoid")
	private int id;

	private Double stkminid;
	private Double drugproductid;
	private Double batchrefid;
	private Double receivedqty;
	private Double minqty;
	private Double qty;
	
	private Double locrefid;
	private Double locname;
	
	private String stkminno;

	
	private String clientcdate;
	private String clientcdate1;
	
	private  Integer   calcflag  ;
	
	private  Boolean   selectflag=false  ;
	
	private Double ageingtime;
	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	private  String   remarks  ;
	private  Integer   gridcolor  ;
	private  Integer   updateflag  ;
	private  String   reqqty;
	private  String   boxperstrip;
	private  String   strippertablet;
	private  String   boxqty;
	private  String   stripqty;
	private  String   tabletqty;
	private  String   packageunit;
	
	
	
	public Integer getUpdateflag() {
		return updateflag;
	}
	public void setUpdateflag(Integer updateflag) {
		this.updateflag = updateflag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public Double getMinqty() {
		return minqty;
	}
	public void setMinqty(Double minqty) {
		this.minqty = minqty;
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
	public String getStkminno() {
		return stkminno;
	}
	public void setStkminno(String stkminno) {
		this.stkminno = stkminno;
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
	public Double getStkminid() {
		return stkminid;
	}
	public void setStkminid(Double stkminid) {
		this.stkminid = stkminid;
	}
	public Integer getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
	}
	public Boolean getSelectflag() {
		return selectflag;
	}
	public void setSelectflag(Boolean selectflag) {
		this.selectflag = selectflag;
	}
	public Double getReceivedqty() {
		return receivedqty;
	}
	public void setReceivedqty(Double receivedqty) {
		this.receivedqty = receivedqty;
	}
	public Double getageingtime() {
		return ageingtime;
	}
	public String getBoxperstrip() {
		return boxperstrip;
	}
	public void setBoxperstrip(String boxperstrip) {
		this.boxperstrip = boxperstrip;
	}
	public String getStrippertablet() {
		return strippertablet;
	}
	public void setStrippertablet(String strippertablet) {
		this.strippertablet = strippertablet;
	}
	public String getBoxqty() {
		return boxqty;
	}
	public void setBoxqty(String boxqty) {
		this.boxqty = boxqty;
	}
	public String getStripqty() {
		return stripqty;
	}
	public void setStripqty(String stripqty) {
		this.stripqty = stripqty;
	}
	public String getTabletqty() {
		return tabletqty;
	}
	public void setTabletqty(String tabletqty) {
		this.tabletqty = tabletqty;
	}
	public void setageingtime(Double ageingtime) {
		this.ageingtime = ageingtime;
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
	public Double getQty() {
		return qty;
	}
	public void setQty(Double qty) {
		this.qty = qty;
	}
	public Integer getGridcolor() {
		return gridcolor;
	}
	public void setGridcolor(Integer gridcolor) {
		this.gridcolor = gridcolor;
	}
	public String getReqqty() {
		return reqqty;
	}
	public void setReqqty(String reqqty) {
		this.reqqty = reqqty;
	}
	public String getPackageunit() {
		return packageunit;
	}
	public void setPackageunit(String packageunit) {
		this.packageunit = packageunit;
	}
	
	
	
	
	
	

}
