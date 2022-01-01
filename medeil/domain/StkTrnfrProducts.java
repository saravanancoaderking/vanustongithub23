package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;







@Entity
@Table(name = "medc_stktrfproduct"    ,catalog="medc_stock")
public class StkTrnfrProducts {
	
	
	
	      @Id
	       @GeneratedValue(strategy = GenerationType.IDENTITY)
           @Column(name = "stktrfproid") 
	          private   int    id   ;
          
		       private double stktrfrefid     ;
		       private double drugproductrefid   ;  
		       private double batchrefid    ;
		  
		       private double prodreqqty    ;
		       private double prodavailqty  ;  
		       private double apprboxqty   ;   
		       private double apprstripqty ;   
		       private double apprtabqty    ; 
		       private double apprtotalqty  ;  
		       private double waitingboxqty   ;  
		       private double waitingstripqty;
		       private double waitingtabqty   ;  
		       private double waitingtotalqty ;    
		    
		      
	           private double transferboxqty    ;
		       private double transferstripqty    ;
		       private double transfertabqty   ;
		       private double transfertotalqty   ; 
		       private double batchavailqty  ;
		       private double rejectqty    ;
		       private String rejectreason  ;   
		       private double indentrefid ;
		   
		  
		  
		   	
		     	private  double   locrefid;  
		    	private  double   locname  ;
		  
		    	private  double   boxconvdrg;  
		    	private  double   stripconvdrg  ;
		  
		    	private  double   boxconvstk;  
		    	private  double   stripconvstk  ;
		  
		    	private  double   uniqueflag  ;
		    	
		  
		  
	
		       
		       
		       
		public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			
			
	
		public double getDrugproductrefid() {
			return drugproductrefid;
		}
		public void setDrugproductrefid(double drugproductrefid) {
			this.drugproductrefid = drugproductrefid;
		}
		public double getBatchrefid() {
			return batchrefid;
		}
		public void setBatchrefid(double batchrefid) {
			this.batchrefid = batchrefid;
		}
		public double getProdreqqty() {
			return prodreqqty;
		}
		public void setProdreqqty(double prodreqqty) {
			this.prodreqqty = prodreqqty;
		}
		public double getProdavailqty() {
			return prodavailqty;
		}
		public void setProdavailqty(double prodavailqty) {
			this.prodavailqty = prodavailqty;
		}
		public double getApprboxqty() {
			return apprboxqty;
		}
		public void setApprboxqty(double apprboxqty) {
			this.apprboxqty = apprboxqty;
		}
		public double getApprstripqty() {
			return apprstripqty;
		}
		public void setApprstripqty(double apprstripqty) {
			this.apprstripqty = apprstripqty;
		}
		public double getApprtabqty() {
			return apprtabqty;
		}
		public void setApprtabqty(double apprtabqty) {
			this.apprtabqty = apprtabqty;
		}
		public double getApprtotalqty() {
			return apprtotalqty;
		}
		public void setApprtotalqty(double apprtotalqty) {
			this.apprtotalqty = apprtotalqty;
		}
		public double getWaitingboxqty() {
			return waitingboxqty;
		}
		public void setWaitingboxqty(double waitingboxqty) {
			this.waitingboxqty = waitingboxqty;
		}
		public double getWaitingstripqty() {
			return waitingstripqty;
		}
		public void setWaitingstripqty(double waitingstripqty) {
			this.waitingstripqty = waitingstripqty;
		}
		public double getWaitingtabqty() {
			return waitingtabqty;
		}
		public void setWaitingtabqty(double waitingtabqty) {
			this.waitingtabqty = waitingtabqty;
		}
		public double getWaitingtotalqty() {
			return waitingtotalqty;
		}
		public void setWaitingtotalqty(double waitingtotalqty) {
			this.waitingtotalqty = waitingtotalqty;
		}
		public double getTransferboxqty() {
			return transferboxqty;
		}
		public void setTransferboxqty(double transferboxqty) {
			this.transferboxqty = transferboxqty;
		}
		public double getTransferstripqty() {
			return transferstripqty;
		}
		public void setTransferstripqty(double transferstripqty) {
			this.transferstripqty = transferstripqty;
		}
		public double getTransfertabqty() {
			return transfertabqty;
		}
		public void setTransfertabqty(double transfertabqty) {
			this.transfertabqty = transfertabqty;
		}
		public double getTransfertotalqty() {
			return transfertotalqty;
		}
		public void setTransfertotalqty(double transfertotalqty) {
			this.transfertotalqty = transfertotalqty;
		}
		public double getBatchavailqty() {
			return batchavailqty;
		}
		public void setBatchavailqty(double batchavailqty) {
			this.batchavailqty = batchavailqty;
		}
		public double getRejectqty() {
			return rejectqty;
		}
		public void setRejectqty(double rejectqty) {
			this.rejectqty = rejectqty;
		}
		public String getRejectreason() {
			return rejectreason;
		}
		public void setRejectreason(String rejectreason) {
			this.rejectreason = rejectreason;
		}
		public double getIndentrefid() {
			return indentrefid;
		}
		public void setIndentrefid(double indentrefid) {
			this.indentrefid = indentrefid;
		}
		public double getLocrefid() {
			return locrefid;
		}
		public void setLocrefid(double locrefid) {
			this.locrefid = locrefid;
		}
		public double getLocname() {
			return locname;
		}
		public void setLocname(double locname) {
			this.locname = locname;
		}
		public double getStktrfrefid() {
			return stktrfrefid;
		}
		public void setStktrfrefid(double stktrfrefid) {
			this.stktrfrefid = stktrfrefid;
		}
		public double getBoxconvdrg() {
			return boxconvdrg;
		}
		public void setBoxconvdrg(double boxconvdrg) {
			this.boxconvdrg = boxconvdrg;
		}
		public double getStripconvdrg() {
			return stripconvdrg;
		}
		public void setStripconvdrg(double stripconvdrg) {
			this.stripconvdrg = stripconvdrg;
		}
		public double getBoxconvstk() {
			return boxconvstk;
		}
		public void setBoxconvstk(double boxconvstk) {
			this.boxconvstk = boxconvstk;
		}
		public double getStripconvstk() {
			return stripconvstk;
		}
		public void setStripconvstk(double stripconvstk) {
			this.stripconvstk = stripconvstk;
		}
		public double getUniqueflag() {
			return uniqueflag;
		}
		public void setUniqueflag(double uniqueflag) {
			this.uniqueflag = uniqueflag;
		}
		
		
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

}



















