package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_stockadjust", catalog = "medc_stock")
public class StockAdjust {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stkadjautid")
	private int id;

	private int stkadjid;
	private Double drugproductid;
	private Double batchrefid;
	private Double actualstock;
	
	private Double physicalboxstock;
	private Double physicalstripstock;
	private Double physicaltabstock;
	private Double unitstkvalue;
	private Double physicalstock;
	private Double adjustedstock;
	private Double actualstkvalue;
	private Double physicalstkvalue;
	private Double adjustedstkvalue;
	private String remarks;

	private Double locrefid;
	private Double locname;
	
	private Double boxconvstk;
	private Double stripconvstk;
	
	
	private String stkadjno;
	
	private  Boolean   delflag = false  ;
	
	private String clientcdate;
	private String clientcdate1;
	
	private Double   status =0.0 ; 
	
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

	
	
	public int getStkadjid() {
		return stkadjid;
	}
	public void setStkadjid(int stkadjid) {
		this.stkadjid = stkadjid;
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
	public Double getActualstock() {
		return actualstock;
	}
	public void setActualstock(Double actualstock) {
		this.actualstock = actualstock;
	}
	public Double getPhysicalstock() {
		return physicalstock;
	}
	public void setPhysicalstock(Double physicalstock) {
		this.physicalstock = physicalstock;
	}
	public Double getAdjustedstock() {
		return adjustedstock;
	}
	public void setAdjustedstock(Double adjustedstock) {
		this.adjustedstock = adjustedstock;
	}
	public Double getActualstkvalue() {
		return actualstkvalue;
	}
	public void setActualstkvalue(Double actualstkvalue) {
		this.actualstkvalue = actualstkvalue;
	}
	public Double getPhysicalstkvalue() {
		return physicalstkvalue;
	}
	public void setPhysicalstkvalue(Double physicalstkvalue) {
		this.physicalstkvalue = physicalstkvalue;
	}
	public Double getAdjustedstkvalue() {
		return adjustedstkvalue;
	}
	public void setAdjustedstkvalue(Double adjustedstkvalue) {
		this.adjustedstkvalue = adjustedstkvalue;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getStkadjno() {
		return stkadjno;
	}
	public void setStkadjno(String stkadjno) {
		this.stkadjno = stkadjno;
	}
	public Double getPhysicalboxstock() {
		return physicalboxstock;
	}
	public void setPhysicalboxstock(Double physicalboxstock) {
		this.physicalboxstock = physicalboxstock;
	}
	public Double getPhysicalstripstock() {
		return physicalstripstock;
	}
	public void setPhysicalstripstock(Double physicalstripstock) {
		this.physicalstripstock = physicalstripstock;
	}
	public Double getPhysicaltabstock() {
		return physicaltabstock;
	}
	public void setPhysicaltabstock(Double physicaltabstock) {
		this.physicaltabstock = physicaltabstock;
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
	public Double getUnitstkvalue() {
		return unitstkvalue;
	}
	public void setUnitstkvalue(Double unitstkvalue) {
		this.unitstkvalue = unitstkvalue;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
