package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AccountBalance {


	private int id;

	private Double accadjid;
	private String accadjno;



	private Double accid;
	private String accname;

	private Double orginalbal;
	private Double changedbal;
	
	
	private String clientcdate;
	private Double createdby;
	
	private Integer locrefid;
	private Integer locname;
	
	private Double accbalflag;
	
	
	private Double acctype;
	private Date  fromdate;
	private Date  todate;
	private Date  nexto;
	private Double openingbal;
	private Double closingbal;
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getAccadjid() {
		return accadjid;
	}
	public void setAccadjid(Double accadjid) {
		this.accadjid = accadjid;
	}
	public String getAccadjno() {
		return accadjno;
	}
	public void setAccadjno(String accadjno) {
		this.accadjno = accadjno;
	}
	public Double getAccid() {
		return accid;
	}
	public void setAccid(Double accid) {
		this.accid = accid;
	}
	public String getAccname() {
		return accname;
	}
	public void setAccname(String accname) {
		this.accname = accname;
	}
	public Double getOrginalbal() {
		return orginalbal;
	}
	public void setOrginalbal(Double orginalbal) {
		this.orginalbal = orginalbal;
	}
	public Double getChangedbal() {
		return changedbal;
	}
	public void setChangedbal(Double changedbal) {
		this.changedbal = changedbal;
	}
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public Double getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Double createdby) {
		this.createdby = createdby;
	}
	public Integer getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}
	public Integer getLocname() {
		return locname;
	}
	public void setLocname(Integer locname) {
		this.locname = locname;
	}
	public Double getAccbalflag() {
		return accbalflag;
	}
	public void setAccbalflag(Double accbalflag) {
		this.accbalflag = accbalflag;
	}
	public Double getAcctype() {
		return acctype;
	}
	public void setAcctype(Double acctype) {
		this.acctype = acctype;
	}

	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public Date getNexto() {
		return nexto;
	}
	public void setNexto(Date nexto) {
		this.nexto = nexto;
	}
	public Double getOpeningbal() {
		return openingbal;
	}
	public void setOpeningbal(Double openingbal) {
		this.openingbal = openingbal;
	}
	public Double getClosingbal() {
		return closingbal;
	}
	public void setClosingbal(Double closingbal) {
		this.closingbal = closingbal;
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
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	
	
	
}
