package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_srproduct" ,catalog="medc_salesreturn")
public class SReturnProd {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "srproductid") 
    private   int    id;  
  	private  int   srrefid;  
	private  Double   drugproductid;   
	private  Double   batchrefid;  
	private  Double   boxqty;  
	private  Double   stripqty; 
	private  Double   tabletqty; 
	private  Double   totalqty;   
	private  Double   unitprice; 
 
	private    Date   expirydate;  
	private  Double   mrp; 
	
	
	private  Double   unitdiscount;  
	private  Double   unitvat;   
	private  Double   unitgst;   
	private  Double   unitsgst;   
	private  Double   unitcgst; 
	private  Double   unitigst;  
	private  Double   unitutgst;  
	private  Double   vatamt; 
	private  Double   gstamt; 
	private  Double   sgstamt;   
	private  Double   cgstamt;    
	private  Double   igstamt;  
	private  Double   utgstamt; 
	private  Double   subtotal;  
	
	
	private  Double   locrefid;  
	private  Double   locname  ;
	
	private  Double   indvqty;  
	private  Double   discountamt  ;
	
	
	private  Double   siqty ; 
	private  Double   drgtyp;  
	private  Double   gstflag  ;
	private  Double   frgstflag  ;

	
	
	private  Double   convfactor  ;
	
	private   Integer  calcflag=0;
	
	
	private  Boolean   delflag = false  ;
	
	
	private String clientcdate;
	private String clientcdate1;
	
	private Double   status =0.0 ;  
	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	private  Integer   sinvrefid  ;
	
	private  String    batchname    ;
	
	private Double stkmainrefid;
	
	private Double siprodrefid;
	
	
	
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
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
	public Double getTabletqty() {
		return tabletqty;
	}
	public void setTabletqty(Double tabletqty) {
		this.tabletqty = tabletqty;
	}
	public Double getTotalqty() {
		return totalqty;
	}
	public void setTotalqty(Double totalqty) {
		this.totalqty = totalqty;
	}
	public Double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public Double getMrp() {
		return mrp;
	}
	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}
	public Double getUnitdiscount() {
		return unitdiscount;
	}
	public void setUnitdiscount(Double unitdiscount) {
		this.unitdiscount = unitdiscount;
	}
	public Double getUnitvat() {
		return unitvat;
	}
	public void setUnitvat(Double unitvat) {
		this.unitvat = unitvat;
	}
	public Double getUnitgst() {
		return unitgst;
	}
	public void setUnitgst(Double unitgst) {
		this.unitgst = unitgst;
	}
	public Double getUnitsgst() {
		return unitsgst;
	}
	public void setUnitsgst(Double unitsgst) {
		this.unitsgst = unitsgst;
	}
	public Double getUnitcgst() {
		return unitcgst;
	}
	public void setUnitcgst(Double unitcgst) {
		this.unitcgst = unitcgst;
	}
	public Double getUnitigst() {
		return unitigst;
	}
	public void setUnitigst(Double unitigst) {
		this.unitigst = unitigst;
	}
	public Double getUnitutgst() {
		return unitutgst;
	}
	public void setUnitutgst(Double unitutgst) {
		this.unitutgst = unitutgst;
	}
	public Double getVatamt() {
		return vatamt;
	}
	public void setVatamt(Double vatamt) {
		this.vatamt = vatamt;
	}
	public Double getGstamt() {
		return gstamt;
	}
	public void setGstamt(Double gstamt) {
		this.gstamt = gstamt;
	}
	public Double getSgstamt() {
		return sgstamt;
	}
	public void setSgstamt(Double sgstamt) {
		this.sgstamt = sgstamt;
	}
	public Double getCgstamt() {
		return cgstamt;
	}
	public void setCgstamt(Double cgstamt) {
		this.cgstamt = cgstamt;
	}
	public Double getIgstamt() {
		return igstamt;
	}
	public void setIgstamt(Double igstamt) {
		this.igstamt = igstamt;
	}
	public Double getUtgstamt() {
		return utgstamt;
	}
	public void setUtgstamt(Double utgstamt) {
		this.utgstamt = utgstamt;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
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
	public Double getIndvqty() {
		return indvqty;
	}
	public void setIndvqty(Double indvqty) {
		this.indvqty = indvqty;
	}
	public Double getDiscountamt() {
		return discountamt;
	}
	public void setDiscountamt(Double discountamt) {
		this.discountamt = discountamt;
	}
	public Double getDrgtyp() {
		return drgtyp;
	}
	public void setDrgtyp(Double drgtyp) {
		this.drgtyp = drgtyp;
	}
	public Double getGstflag() {
		return gstflag;
	}
	public void setGstflag(Double gstflag) {
		this.gstflag = gstflag;
	}
	public Double getFrgstflag() {
		return frgstflag;
	}
	public void setFrgstflag(Double frgstflag) {
		this.frgstflag = frgstflag;
	}
	public Double getConvfactor() {
		return convfactor;
	}
	public void setConvfactor(Double convfactor) {
		this.convfactor = convfactor;
	}

	
	
	public int getSrrefid() {
		return srrefid;
	}
	public void setSrrefid(int srrefid) {
		this.srrefid = srrefid;
	}
	public Boolean getDelflag() {
		return delflag;
	}
	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
	}
	public Integer getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
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
	public Double getSiqty() {
		return siqty;
	}
	public void setSiqty(Double siqty) {
		this.siqty = siqty;
	}
	public Double getStatus() {
		return status;
	}
	public void setStatus(Double status) {
		this.status = status;
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
	public Integer getSinvrefid() {
		return sinvrefid;
	}
	public void setSinvrefid(Integer sinvrefid) {
		this.sinvrefid = sinvrefid;
	}
	public Double getStkmainrefid() {
		return stkmainrefid;
	}
	public void setStkmainrefid(Double stkmainrefid) {
		this.stkmainrefid = stkmainrefid;
	}
	public Double getSiprodrefid() {
		return siprodrefid;
	}
	public void setSiprodrefid(Double siprodrefid) {
		this.siprodrefid = siprodrefid;
	}
	
	
	
	
	
	
	
	

}
