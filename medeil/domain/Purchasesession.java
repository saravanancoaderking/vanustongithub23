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
 * @author Ajith AK
 *
 */
@Entity
public class Purchasesession implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/** PURCHASE SESSION INPUT VALUES **/
	private String sessionno;

	private String sessiondate;

	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locname;

	private Integer locrefid;

	private String clientcdate;
	/** End **/
	private boolean checkbox;

	private String indentno;

	private String indentdate;

	private String formname;

	private Integer indentid;

	private String brandname;

	private double waitboxqty;

	private double waitstripqty;

	private double waittabletqty;

	private double waittotqty;

	private Integer drugproid;
	private Integer indentrefid;
	private Double boxconvdrg;
	private Double stripconvdrg;
	private String packageunit;	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isCheckbox() {
		return checkbox;
	}

	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}

	public String getIndentno() {
		return indentno;
	}

	public void setIndentno(String indentno) {
		this.indentno = indentno;
	}

	public String getIndentdate() {
		return indentdate;
	}

	public void setIndentdate(String indentdate) {
		this.indentdate = indentdate;
	}

	public String getFormname() {
		return formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	public Integer getIndentid() {
		return indentid;
	}

	public void setIndentid(Integer indentid) {
		this.indentid = indentid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public double getWaitboxqty() {
		return waitboxqty;
	}

	public void setWaitboxqty(double waitboxqty) {
		this.waitboxqty = waitboxqty;
	}

	public double getWaitstripqty() {
		return waitstripqty;
	}

	public void setWaitstripqty(double waitstripqty) {
		this.waitstripqty = waitstripqty;
	}

	public double getWaittabletqty() {
		return waittabletqty;
	}

	public void setWaittabletqty(double waittabletqty) {
		this.waittabletqty = waittabletqty;
	}

	public double getWaittotqty() {
		return waittotqty;
	}

	public void setWaittotqty(double waittotqty) {
		this.waittotqty = waittotqty;
	}

	public Integer getDrugproid() {
		return drugproid;
	}

	public void setDrugproid(Integer drugproid) {
		this.drugproid = drugproid;
	}

	public String getSessionno() {
		return sessionno;
	}

	public void setSessionno(String sessionno) {
		this.sessionno = sessionno;
	}

	public String getSessiondate() {
		return sessiondate;
	}

	public void setSessiondate(String sessiondate) {
		this.sessiondate = sessiondate;
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

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getIndentrefid() {
		return indentrefid;
	}

	public void setIndentrefid(Integer indentrefid) {
		this.indentrefid = indentrefid;
	}

	public Double getBoxconvdrg() {
		return boxconvdrg;
	}

	public void setBoxconvdrg(Double boxconvdrg) {
		this.boxconvdrg = boxconvdrg;
	}

	public Double getStripconvdrg() {
		return stripconvdrg;
	}

	public void setStripconvdrg(Double stripconvdrg) {
		this.stripconvdrg = stripconvdrg;
	}

	public String getPackageunit() {
		return packageunit;
	}

	public void setPackageunit(String packageunit) {
		this.packageunit = packageunit;
	}
}
