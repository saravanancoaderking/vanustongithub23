package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "medc_perinvprod"  ,catalog="medc_sales")
public class PerInvProduct {
	
	

	 
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "perprodid") 
	   private   int    id;    
	   private    Double    perinvrefid;    
	   private    Double    drugproductrefid;    
	   private    Double    boxquantity;  
	   private    Double    stripquantity;   
	   private    Double    tabletquantity;    
	   

		
		private   Double   locrefid;  
		private   Double   locname  ;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Double getPerinvrefid() {
			return perinvrefid;
		}
		public void setPerinvrefid(Double perinvrefid) {
			this.perinvrefid = perinvrefid;
		}
		public Double getDrugproductrefid() {
			return drugproductrefid;
		}
		public void setDrugproductrefid(Double drugproductrefid) {
			this.drugproductrefid = drugproductrefid;
		}
		public Double getBoxquantity() {
			return boxquantity;
		}
		public void setBoxquantity(Double boxquantity) {
			this.boxquantity = boxquantity;
		}
		public Double getStripquantity() {
			return stripquantity;
		}
		public void setStripquantity(Double stripquantity) {
			this.stripquantity = stripquantity;
		}
		public Double getTabletquantity() {
			return tabletquantity;
		}
		public void setTabletquantity(Double tabletquantity) {
			this.tabletquantity = tabletquantity;
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
	   
	   
	   


		
		
		
	

}
