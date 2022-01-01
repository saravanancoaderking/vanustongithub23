package com.medeil.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mrs.Padmini
 * @author Boopalan Alagesan
 *
 */

@Entity
@Table(name = "medc_newprodqty", catalog = "medc_stock")
public class NewProductQty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nproductid")
	private int nproductid;

	private int nprefid;
	private String newprodno;
	private String newproductname;
	private int reqqty;
	private String remarks;
	private int status;
	private String createddate;
	private String clientcdate;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private int stockentryflag;
	private int salesbillid;
	private int gridcolor;
	private int updateflag;

	public int getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(int updateflag) {
		this.updateflag = updateflag;
	}

	public String getNewprodno() {
		return newprodno;
	}

	public void setNewprodno(String newprodno) {
		this.newprodno = newprodno;
	}

	public String getNewproductname() {
		return newproductname;
	}

	public void setNewproductname(String newproductname) {
		this.newproductname = newproductname;
	}

	public int getReqqty() {
		return reqqty;
	}

	public void setReqqty(int reqqty) {
		this.reqqty = reqqty;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}

	public int getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(int branchrefid) {
		this.branchrefid = branchrefid;
	}

	public int getLocname() {
		return locname;
	}

	public void setLocname(int locname) {
		this.locname = locname;
	}

	public int getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(int locrefid) {
		this.locrefid = locrefid;
	}

	public int getStockentryflag() {
		return stockentryflag;
	}

	public void setStockentryflag(int stockentryflag) {
		this.stockentryflag = stockentryflag;
	}

	public int getSalesbillid() {
		return salesbillid;
	}

	public void setSalesbillid(int salesbillid) {
		this.salesbillid = salesbillid;
	}

	public int getGridcolor() {
		return gridcolor;
	}

	public void setGridcolor(int gridcolor) {
		this.gridcolor = gridcolor;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public int getNprefid() {
		return nprefid;
	}

	public void setNprefid(int nprefid) {
		this.nprefid = nprefid;
	}

	public int getNproductid() {
		return nproductid;
	}

	public void setNproductid(int nproductid) {
		this.nproductid = nproductid;
	}

}
