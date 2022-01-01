package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_patientbasicinfo", catalog = "medc_patientreg")
public class StockLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StockLogID")
	private int id;

	private Integer stockid;
	private Integer qty;
	private Integer currentqty;
	private Integer changedqty;
	private Integer finalqty;
	private Integer invoiceno;
	private Integer invoicename;
	private Double locrefid;
	private Double locname;
	
	
	public Integer getCurrentqty() {
		return currentqty;
	}

	public void setCurrentqty(Integer currentqty) {
		this.currentqty = currentqty;
	}

	public Integer getChangedqty() {
		return changedqty;
	}

	public void setChangedqty(Integer changedqty) {
		this.changedqty = changedqty;
	}

	public Integer getFinalqty() {
		return finalqty;
	}

	public void setFinalqty(Integer finalqty) {
		this.finalqty = finalqty;
	}

	public Integer getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(Integer invoiceno) {
		this.invoiceno = invoiceno;
	}

	public Integer getInvoicename() {
		return invoicename;
	}

	public void setInvoicename(Integer invoicename) {
		this.invoicename = invoicename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getStockid() {
		return stockid;
	}

	public void setStockid(Integer stockid) {
		this.stockid = stockid;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
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
