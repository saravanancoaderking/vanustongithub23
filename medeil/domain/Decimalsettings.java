package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medc_decimalsettings", catalog = "medc_globalsettings")
public class Decimalsettings implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "decimalid")
	private Integer id;
	private Integer decimaltwo;
	private Integer decimalthree;
	private Integer roundedabove;
	private Integer roundedbelow;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer status;
	private String createddate;
	private String clientcdate;
	private String modifieddate;
	private String clientmdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDecimalthree() {
		return decimalthree;
	}
	public void setDecimalthree(Integer decimalthree) {
		this.decimalthree = decimalthree;
	}
	public Integer getRoundedabove() {
		return roundedabove;
	}
	public void setRoundedabove(Integer roundedabove) {
		this.roundedabove = roundedabove;
	}
	public Integer getRoundedbelow() {
		return roundedbelow;
	}
	public void setRoundedbelow(Integer roundedbelow) {
		this.roundedbelow = roundedbelow;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getClientmdate() {
		return clientmdate;
	}
	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
	}
	public Integer getDecimaltwo() {
		return decimaltwo;
	}
	public void setDecimaltwo(Integer decimaltwo) {
		this.decimaltwo = decimaltwo;
	}
}
