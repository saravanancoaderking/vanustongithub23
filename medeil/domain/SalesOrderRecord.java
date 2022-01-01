/**
 * 
 */
package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ajith Kumar
 *
 */
@Entity
public class SalesOrderRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer salesorderrefid;

	private Integer drugproductid;

	private Double boxqty;

	private Double stripqty;

	private Double tabletqty;

	private Double totalqty;
	
	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locname;

	private Integer locrefid;

	private Integer mainstockrefid;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalesorderrefid() {
		return salesorderrefid;
	}

	public void setSalesorderrefid(Integer salesorderrefid) {
		this.salesorderrefid = salesorderrefid;
	}

	public Integer getDrugproductid() {
		return drugproductid;
	}

	public void setDrugproductid(Integer drugproductid) {
		this.drugproductid = drugproductid;
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

	public Double getTabletqty() {
		return tabletqty;
	}

	public void setTabletqty(Double tabletqty) {
		this.tabletqty = tabletqty;
	}

	public Double getTotalqty() {
		return totalqty;
	}

	public void setTotalqty(Double totalqty) {
		this.totalqty = totalqty;
	}

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public Integer getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(Integer branchrefid) {
		this.branchrefid = branchrefid;
	}

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getMainstockrefid() {
		return mainstockrefid;
	}

	public void setMainstockrefid(Integer mainstockrefid) {
		this.mainstockrefid = mainstockrefid;
	}

}
