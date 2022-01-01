package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name = "medc_stkretnproduct"    ,catalog="medc_stock")
public class StockRetProducts {
	
	
	
	
	
	
	
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "stkretnproid") 
     private   int    id   ;
     private Double   stkretnid     ;
     private Double  stktrfrefid     ;
    
    private Double drugproductrefid   ;  
    private Double batchrefid    ;
    private Double transfertotalqty   ;  
    
    private Double retboxqty   ;
    private Double retstripqty   ;
    private Double rettabqty   ;
    private Double returntotalqty   ;
    
    
    
	
	private  Double   locrefid;  
	private  Double   locname  ;
    
	
	private  Double   boxconvstk;  
	private  Double   stripconvstk  ;
	
	
	private  Double   indrefid  ;
	
    private String   stkretnno     ;

    
	private String clientcdate;
	
	private String clientcdate1;
	
	
	private Integer fromlocname;
	private Integer fromlocrefid;
	private Integer tolocname;
	private Integer tolocrefid;
	
	
	private  Integer   calcflag  ;
	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	
	
	private String namefromlocname;
	private String namefromlocrefid;
	private String nametolocname;
	private String nametolocrefid;
	
	
	
	private String remarks;
	
	private  String    batchname    ;
	
	
	
	private    Date   expirydate;  
	
	

	private Double stkmainrefid;
	private Double stktransprodrefid;
	@Transient
	private Integer retstatus;
	
	
	public Integer getRetstatus() {
		return retstatus;
	}

	public void setRetstatus(Integer retstatus) {
		this.retstatus = retstatus;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getBatchname() {
		return batchname;
	}

	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}

	public String getNamefromlocname() {
		return namefromlocname;
	}

	public void setNamefromlocname(String namefromlocname) {
		this.namefromlocname = namefromlocname;
	}

	public String getNamefromlocrefid() {
		return namefromlocrefid;
	}

	public void setNamefromlocrefid(String namefromlocrefid) {
		this.namefromlocrefid = namefromlocrefid;
	}

	public String getNametolocname() {
		return nametolocname;
	}

	public void setNametolocname(String nametolocname) {
		this.nametolocname = nametolocname;
	}

	public String getNametolocrefid() {
		return nametolocrefid;
	}

	public void setNametolocrefid(String nametolocrefid) {
		this.nametolocrefid = nametolocrefid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getStkretnid() {
		return stkretnid;
	}

	public void setStkretnid(Double stkretnid) {
		this.stkretnid = stkretnid;
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

	public Double getTransfertotalqty() {
		return transfertotalqty;
	}

	public void setTransfertotalqty(Double transfertotalqty) {
		this.transfertotalqty = transfertotalqty;
	}

	public Double getRetboxqty() {
		return retboxqty;
	}

	public void setRetboxqty(Double retboxqty) {
		this.retboxqty = retboxqty;
	}

	public Double getRetstripqty() {
		return retstripqty;
	}

	public void setRetstripqty(Double retstripqty) {
		this.retstripqty = retstripqty;
	}

	public Double getRettabqty() {
		return rettabqty;
	}

	public void setRettabqty(Double rettabqty) {
		this.rettabqty = rettabqty;
	}

	public Double getReturntotalqty() {
		return returntotalqty;
	}

	public void setReturntotalqty(Double returntotalqty) {
		this.returntotalqty = returntotalqty;
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



	public Double getIndrefid() {
		return indrefid;
	}

	public void setIndrefid(Double indrefid) {
		this.indrefid = indrefid;
	}

	public String getStkretnno() {
		return stkretnno;
	}

	public void setStkretnno(String stkretnno) {
		this.stkretnno = stkretnno;
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
    
    
    
    
    
    
    

}
