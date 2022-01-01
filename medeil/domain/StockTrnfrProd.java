package com.medeil.domain;

import java.util.Date;

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
@Table(name = "medc_stktrfproduct"    ,catalog="medc_stock")
public class StockTrnfrProd {
	
	
	
	      @Id
	       @GeneratedValue(strategy = GenerationType.IDENTITY)
           @Column(name = "stktrfproid") 
	          private   int    id   ;
          		
		       private Integer stktrfrefid     ;
		       private Double drugproductrefid   ;  
		       private Double batchrefid    ;
		  
		       private Double prodreqqty    ;
		       private Double prodavailqty  ;  
		       private Double apprboxqty   ;   
		       private Double apprstripqty ;   
		       private Double apprtabqty    ; 
		       private Double apprtotalqty  ;  
		       private Double waitingboxqty   ;  
		       private Double waitingstripqty;
		       private Double waitingtabqty   ;  
		       private Double waitingtotalqty ;    
		    
		      
	           private Double transferboxqty    ;
		       private Double transferstripqty    ;
		       private Double transfertabqty   ;
		       private Double transfertotalqty   ; 
		       private Double batchavailqty  ;
		       private Double rejectqty    ;
		       private String rejectreason  ;   
		       private Double indentrefid ;
		   
		  
		  
		   	
		     	private  Double   locrefid;  
		    	private  Double   locname  ;
		  
		    	private  Double   boxconvdrg;  
		    	private  Double   stripconvdrg  ;
		  
		    	private  Double   boxconvstk;  
		    	private  Double   stripconvstk  ;
		  
		    	private  Double   uniqueflag  ;
		    	
		  
		    	private String clientcdate;
		    	private String clientcdate1;
		       
		    	private  Integer   calcflag  ;
		       
		    	
		    	private  Integer   countryrefid;  
		    	private  Integer   companyrefid  ;
		    	private  Integer   branchrefid  ;
		    	
		    	private String remarks;
		    	private String   batchname    ;
		    	private  Date   expirydate;  
		    	
		    	private Double stkmainrefid;
		    	private Double indentprodrefid;
		    	private Double unitprice;
		    	private String packageunit;
//		    	//Sivakumar-06/02/2020,For Single API(JPA)
//		    	
//		    	@JsonBackReference
//		    	@ManyToOne(fetch = FetchType.LAZY)
//		    	@JoinColumn(name = "stktrfrefid")
//		    	private StockTransfer stocktransfer;
		    	
		    	
				public Date getExpirydate() {
					return expirydate;
				}
				public void setExpirydate(Date expirydate) {
					this.expirydate = expirydate;
				}
				public int getId() {
					return id;
				}
				public void setId(int id) {
					this.id = id;
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
				public Double getProdreqqty() {
					return prodreqqty;
				}
				public void setProdreqqty(Double prodreqqty) {
					this.prodreqqty = prodreqqty;
				}
				public Double getProdavailqty() {
					return prodavailqty;
				}
				public void setProdavailqty(Double prodavailqty) {
					this.prodavailqty = prodavailqty;
				}
				public Double getApprboxqty() {
					return apprboxqty;
				}
				public void setApprboxqty(Double apprboxqty) {
					this.apprboxqty = apprboxqty;
				}
				public Double getApprstripqty() {
					return apprstripqty;
				}
				public void setApprstripqty(Double apprstripqty) {
					this.apprstripqty = apprstripqty;
				}
				public Double getApprtabqty() {
					return apprtabqty;
				}
				public void setApprtabqty(Double apprtabqty) {
					this.apprtabqty = apprtabqty;
				}
				public Double getApprtotalqty() {
					return apprtotalqty;
				}
				public void setApprtotalqty(Double apprtotalqty) {
					this.apprtotalqty = apprtotalqty;
				}
				public Double getWaitingboxqty() {
					return waitingboxqty;
				}
				public void setWaitingboxqty(Double waitingboxqty) {
					this.waitingboxqty = waitingboxqty;
				}
				public Double getWaitingstripqty() {
					return waitingstripqty;
				}
				public void setWaitingstripqty(Double waitingstripqty) {
					this.waitingstripqty = waitingstripqty;
				}
				public Double getWaitingtabqty() {
					return waitingtabqty;
				}
				public void setWaitingtabqty(Double waitingtabqty) {
					this.waitingtabqty = waitingtabqty;
				}
				public Double getWaitingtotalqty() {
					return waitingtotalqty;
				}
				public void setWaitingtotalqty(Double waitingtotalqty) {
					this.waitingtotalqty = waitingtotalqty;
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
				public Double getTransfertotalqty() {
					return transfertotalqty;
				}
				public void setTransfertotalqty(Double transfertotalqty) {
					this.transfertotalqty = transfertotalqty;
				}
				public Double getBatchavailqty() {
					return batchavailqty;
				}
				public void setBatchavailqty(Double batchavailqty) {
					this.batchavailqty = batchavailqty;
				}
				public Double getRejectqty() {
					return rejectqty;
				}
				public void setRejectqty(Double rejectqty) {
					this.rejectqty = rejectqty;
				}
				public String getRejectreason() {
					return rejectreason;
				}
				public void setRejectreason(String rejectreason) {
					this.rejectreason = rejectreason;
				}
				public Double getIndentrefid() {
					return indentrefid;
				}
				public void setIndentrefid(Double indentrefid) {
					this.indentrefid = indentrefid;
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
				public Double getUniqueflag() {
					return uniqueflag;
				}
				public void setUniqueflag(Double uniqueflag) {
					this.uniqueflag = uniqueflag;
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
				public String getBatchname() {
					return batchname;
				}
				public void setBatchname(String batchname) {
					this.batchname = batchname;
				}
				public Integer getStktrfrefid() {
					return stktrfrefid;
				}
				public void setStktrfrefid(Integer stktrfrefid) {
					this.stktrfrefid = stktrfrefid;
				}
				public Double getStkmainrefid() {
					return stkmainrefid;
				}
				public void setStkmainrefid(Double stkmainrefid) {
					this.stkmainrefid = stkmainrefid;
				}
				public Double getIndentprodrefid() {
					return indentprodrefid;
				}
				public void setIndentprodrefid(Double indentprodrefid) {
					this.indentprodrefid = indentprodrefid;
				}
				public Double getUnitprice() {
					return unitprice;
				}
				public void setUnitprice(Double unitprice) {
					this.unitprice = unitprice;
				}
				public String getPackageunit() {
					return packageunit;
				}
				public void setPackageunit(String packageunit) {
					this.packageunit = packageunit;
				}
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		 
		  
		  

}



















