/**
 * 
 */
package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "medc_damagestkproduct", catalog = "medc_purchasereturn")

/**
 * @author Sabarish
 *
 */
public class Damage_stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "DmgStkPrdID")
	private Integer id;

	private Integer damagestkrefid;
	private Integer stkproductrefid;
	private String expirydate;
	private Double qty;
	private Integer damagedqty;
	private Double boxqty;
	private Double damagedboxqty;
	private Double stripqty;
	private Double stripdamagedqty;
	private Double tabqty;
	private Double tabdamagedqty;
	private Double unitprice;
	private Double unitvat;
	private Double unitgst;
	private Double unitsgst;
	private Double unitcgst;
	private Double unitigst;
	private Double unitutgst;
	private Double unitdiscount;
	private Double subtotal;
	private Double total_amount;
	private Integer packing;
	private String clientcdate;
	private String batchno;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer dosageid;
	private Integer batchnumber;
	@Transient
	private Integer dmgstkprdids;

	

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Integer getBatchnumber() {
		return batchnumber;
	}

	public void setBatchnumber(Integer batchnumber) {
		this.batchnumber = batchnumber;
	}

	public Integer getDmgstkprdids() {
		return dmgstkprdids;
	}

	public void setDmgstkprdids(Integer dmgstkprdids) {
		this.dmgstkprdids = dmgstkprdids;
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

	public Integer getDamagestkrefid() {
		return damagestkrefid;
	}

	public void setDamagestkrefid(Integer damagestkrefid) {
		this.damagestkrefid = damagestkrefid;
	}

	public Integer getStkproductrefid() {
		return stkproductrefid;
	}

	public void setStkproductrefid(Integer stkproductrefid) {
		this.stkproductrefid = stkproductrefid;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Integer getDamagedqty() {
		return damagedqty;
	}

	public void setDamagedqty(Integer damagedqty) {
		this.damagedqty = damagedqty;
	}

	public Double getBoxqty() {
		return boxqty;
	}

	public void setBoxqty(Double boxqty) {
		this.boxqty = boxqty;
	}

	public Double getDamagedboxqty() {
		return damagedboxqty;
	}

	public void setDamagedboxqty(Double damagedboxqty) {
		this.damagedboxqty = damagedboxqty;
	}

	public Double getStripqty() {
		return stripqty;
	}

	public void setStripqty(Double stripqty) {
		this.stripqty = stripqty;
	}

	public Double getStripdamagedqty() {
		return stripdamagedqty;
	}

	public void setStripdamagedqty(Double stripdamagedqty) {
		this.stripdamagedqty = stripdamagedqty;
	}

	public Double getTabqty() {
		return tabqty;
	}

	public void setTabqty(Double tabqty) {
		this.tabqty = tabqty;
	}

	public Double getTabdamagedqty() {
		return tabdamagedqty;
	}

	public void setTabdamagedqty(Double tabdamagedqty) {
		this.tabdamagedqty = tabdamagedqty;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getUnitvat() {
		return unitvat;
	}

	public void setUnitvat(Double unitvat) {
		this.unitvat = unitvat;
	}

	public Double getUnitgst() {
		return unitgst;
	}

	public void setUnitgst(Double unitgst) {
		this.unitgst = unitgst;
	}

	public Double getUnitsgst() {
		return unitsgst;
	}

	public void setUnitsgst(Double unitsgst) {
		this.unitsgst = unitsgst;
	}

	public Double getUnitcgst() {
		return unitcgst;
	}

	public void setUnitcgst(Double unitcgst) {
		this.unitcgst = unitcgst;
	}

	public Double getUnitigst() {
		return unitigst;
	}

	public void setUnitigst(Double unitigst) {
		this.unitigst = unitigst;
	}

	public Double getUnitutgst() {
		return unitutgst;
	}

	public void setUnitutgst(Double unitutgst) {
		this.unitutgst = unitutgst;
	}

	public Double getUnitdiscount() {
		return unitdiscount;
	}

	public void setUnitdiscount(Double unitdiscount) {
		this.unitdiscount = unitdiscount;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public Integer getPacking() {
		return packing;
	}

	public void setPacking(Integer packing) {
		this.packing = packing;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getDosageid() {
		return dosageid;
	}

	public void setDosageid(Integer dosageid) {
		this.dosageid = dosageid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
