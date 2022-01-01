package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_prproduct", catalog = "medc_purchasereturn")
public class DiscountSettings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discid")
	private int id;

	private Double amtmin;
	private Double amtmax;
	private Double loyaltyid;
	private Double discpercent;
	private Double discamt;
	private Double createdby;
	private Double locname;
	private Double locrefid;
	
	private   String discstno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getAmtmin() {
		return amtmin;
	}
	public void setAmtmin(Double amtmin) {
		this.amtmin = amtmin;
	}
	public Double getAmtmax() {
		return amtmax;
	}
	public void setAmtmax(Double amtmax) {
		this.amtmax = amtmax;
	}
	public Double getLoyaltyid() {
		return loyaltyid;
	}
	public void setLoyaltyid(Double loyaltyid) {
		this.loyaltyid = loyaltyid;
	}
	public Double getDiscpercent() {
		return discpercent;
	}
	public void setDiscpercent(Double discpercent) {
		this.discpercent = discpercent;
	}
	public Double getDiscamt() {
		return discamt;
	}
	public void setDiscamt(Double discamt) {
		this.discamt = discamt;
	}
	public Double getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Double createdby) {
		this.createdby = createdby;
	}
	public Double getLocname() {
		return locname;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public Double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}
	public String getDiscstno() {
		return discstno;
	}
	public void setDiscstno(String discstno) {
		this.discstno = discstno;
	}
	
	
	
	

}
