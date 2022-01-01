package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_stkrecproduct", catalog = "medc_stock")
public class StkRecProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stkrecproid")
	private int id;

	private double stkrecrefid;
	private double stktrfrefid;

	private double drugproductrefid;
	private double batchrefid;

	private double transferboxqty;
	private double transferstripqty;
	private double transfertabqty;
	private double transfertotalqty;

	private double receivetotalqty;
	private double indrefid;

	private double locrefid;
	private double locname;

	private double boxconvstk;
	private double stripconvstk;

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

	public double getReceivetotalqty() {
		return receivetotalqty;
	}

	public void setReceivetotalqty(double receivetotalqty) {
		this.receivetotalqty = receivetotalqty;
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

	public double getStkrecrefid() {
		return stkrecrefid;
	}

	public void setStkrecrefid(double stkrecrefid) {
		this.stkrecrefid = stkrecrefid;
	}

	public double getStktrfrefid() {
		return stktrfrefid;
	}

	public void setStktrfrefid(double stktrfrefid) {
		this.stktrfrefid = stktrfrefid;
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

	public double getIndrefid() {
		return indrefid;
	}

	public void setIndrefid(double indrefid) {
		this.indrefid = indrefid;
	}

}
