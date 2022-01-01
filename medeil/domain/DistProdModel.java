package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medc_distproduct" ,catalog="medc_distributor")
public class DistProdModel {
	
	
 	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "distprdid") 
	private int id;
 	 private int distrefid  ;
 	 private int drugprdid ;
 	 private double masterprice ;
 	 private double distprice;
 	 
 	 
 	
 	private  double   locrefid;  
 	private  double   locname  ;
 	 
 	 
	private String   distprodno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDistrefid() {
		return distrefid;
	}
	public void setDistrefid(int distrefid) {
		this.distrefid = distrefid;
	}
	public int getDrugprdid() {
		return drugprdid;
	}
	public void setDrugprdid(int drugprdid) {
		this.drugprdid = drugprdid;
	}
	public double getMasterprice() {
		return masterprice;
	}
	public void setMasterprice(double masterprice) {
		this.masterprice = masterprice;
	}
	public double getDistprice() {
		return distprice;
	}
	public void setDistprice(double distprice) {
		this.distprice = distprice;
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
	public String getDistprodno() {
		return distprodno;
	}
	public void setDistprodno(String distprodno) {
		this.distprodno = distprodno;
	}
 	 
 	 
 	 
 	 
 	 
 	 
 	 

}
