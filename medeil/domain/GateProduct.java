package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_gatepassproduct", catalog = "medc_stock")
public class GateProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DpProID")
	private int id;
	private int gprefid;
	private int  drugproductrefid;
	private Double boxqty;
	private Double stripqty;
	private Double tabqty;
	private Double totalqty;
	private int fromlocname;
	private int fromlocrefid;
	private int tolocrefid;
	private int tolocname;
	private int locrefid;
	private int locname;
	private String clientcdate;
	private String clientcdate1;
	private Integer calcflag;
	private int  batchrefid;
	private Integer dcrefid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public int getGprefid() {
		return gprefid;
	}
	public void setGprefid(int gprefid) {
		this.gprefid = gprefid;
	}
	public int getDrugproductrefid() {
		return drugproductrefid;
	}
	public void setDrugproductrefid(int drugproductrefid) {
		this.drugproductrefid = drugproductrefid;
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
	public Double getTabqty() {
		return tabqty;
	}
	public void setTabqty(Double tabqty) {
		this.tabqty = tabqty;
	}
	public Double getTotalqty() {
		return totalqty;
	}
	public void setTotalqty(Double totalqty) {
		this.totalqty = totalqty;
	}
	public int getFromlocname() {
		return fromlocname;
	}
	public void setFromlocname(int fromlocname) {
		this.fromlocname = fromlocname;
	}
	public int getFromlocrefid() {
		return fromlocrefid;
	}
	public void setFromlocrefid(int fromlocrefid) {
		this.fromlocrefid = fromlocrefid;
	}
	public int getTolocrefid() {
		return tolocrefid;
	}
	public void setTolocrefid(int tolocrefid) {
		this.tolocrefid = tolocrefid;
	}
	public int getTolocname() {
		return tolocname;
	}
	public void setTolocname(int tolocname) {
		this.tolocname = tolocname;
	}
	public int getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(int locrefid) {
		this.locrefid = locrefid;
	}
	public int getLocname() {
		return locname;
	}
	public void setLocname(int locname) {
		this.locname = locname;
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
	public int getBatchrefid() {
		return batchrefid;
	}
	public void setBatchrefid(int batchrefid) {
		this.batchrefid = batchrefid;
	}
	public Integer getDcrefid() {
		return dcrefid;
	}
	public void setDcrefid(Integer dcrefid) {
		this.dcrefid = dcrefid;
	}
	
	
}
