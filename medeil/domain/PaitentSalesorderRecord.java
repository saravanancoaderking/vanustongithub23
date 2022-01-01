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
public class PaitentSalesorderRecord implements Serializable {

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
	
	private byte Productimg;
	

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

	public byte getProductimg() {
		return Productimg;
	}

	public void setProductimg(byte productimg) {
		Productimg = productimg;
	}

	
}
