/**
 * 
 */
package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vanuston
 *
 */
@Entity
@Table(name = "medc_gstsettings", catalog = "medc_globalsettings")
public class Gstsetting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GstID")
	private int id;

	public Integer locname;
	public Integer locrefid;
	public Integer createdby;
	public Integer gstflag;
	public Integer frgstflag;
	public Integer countryrefid;
	public Integer companyrefid;
	public Integer branchrefid;
	public String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Integer getGstflag() {
		return gstflag;
	}

	public void setGstflag(Integer gstflag) {
		this.gstflag = gstflag;
	}

	public Integer getFrgstflag() {
		return frgstflag;
	}

	public void setFrgstflag(Integer frgstflag) {
		this.frgstflag = frgstflag;
	}

	public Integer getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
