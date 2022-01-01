package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_perinv", catalog = "medc_sales")
public class PerInv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "perinvid")
	private int id;
	private Double perinvno;
	private  Date perinvdate;
	private Double customerid;
	private Double from;
	private Double to;
	private String fromaddr;
	private String toaddr;

	private Double locrefid;
	private Double locname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getPerinvno() {
		return perinvno;
	}
	public void setPerinvno(Double perinvno) {
		this.perinvno = perinvno;
	}
	public Date getPerinvdate() {
		return perinvdate;
	}
	public void setPerinvdate(Date perinvdate) {
		this.perinvdate = perinvdate;
	}
	public Double getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Double customerid) {
		this.customerid = customerid;
	}
	public Double getFrom() {
		return from;
	}
	public void setFrom(Double from) {
		this.from = from;
	}
	public Double getTo() {
		return to;
	}
	public void setTo(Double to) {
		this.to = to;
	}
	public String getFromaddr() {
		return fromaddr;
	}
	public void setFromaddr(String fromaddr) {
		this.fromaddr = fromaddr;
	}
	public String getToaddr() {
		return toaddr;
	}
	public void setToaddr(String toaddr) {
		this.toaddr = toaddr;
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
