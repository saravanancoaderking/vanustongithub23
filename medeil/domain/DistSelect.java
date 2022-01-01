package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "medc_distselect" ,catalog="medc_purchase")
public class DistSelect {
	
	
	

    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distslctproid")
      private int  id ;   
	 private Double distslctid ;  
	 private Double prcenqrefid ; 
	 private Double drugproductrefid ;  
	 private Double batchrefid ;  
	 private Double prodwaitingqty ;  
	 private Double distpreprice ;  
	 private Double distfinalprice ;   
	 private Double vendorid ;    
	 private Boolean vendorslctflag ;
	 
		
	 private  Double   locrefid;  
   	private  Double   locname  ;
	 
		 private String distslctno ;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Double getDistslctid() {
			return distslctid;
		}

		public void setDistslctid(Double distslctid) {
			this.distslctid = distslctid;
		}

		public Double getPrcenqrefid() {
			return prcenqrefid;
		}

		public void setPrcenqrefid(Double prcenqrefid) {
			this.prcenqrefid = prcenqrefid;
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

		public Double getProdwaitingqty() {
			return prodwaitingqty;
		}

		public void setProdwaitingqty(Double prodwaitingqty) {
			this.prodwaitingqty = prodwaitingqty;
		}

		public Double getDistpreprice() {
			return distpreprice;
		}

		public void setDistpreprice(Double distpreprice) {
			this.distpreprice = distpreprice;
		}

		public Double getDistfinalprice() {
			return distfinalprice;
		}

		public void setDistfinalprice(Double distfinalprice) {
			this.distfinalprice = distfinalprice;
		}

		public Double getVendorid() {
			return vendorid;
		}

		public void setVendorid(Double vendorid) {
			this.vendorid = vendorid;
		}

		public boolean isVendorslctflag() {
			return vendorslctflag;
		}

		public void setVendorslctflag(boolean vendorslctflag) {
			this.vendorslctflag = vendorslctflag;
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

		public String getDistslctno() {
			return distslctno;
		}

		public void setDistslctno(String distslctno) {
			this.distslctno = distslctno;
		}  
	 

		 
		 
		 
	 
	 

}
