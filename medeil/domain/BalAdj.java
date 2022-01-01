package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medc_adjbal", catalog = "medc_accounts")
public class BalAdj {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accadjautid")
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

	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Double getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Double createdby) {
		this.createdby = createdby;
	}

	


	public Double getAccbalflag() {
		return accbalflag;
	}

	public void setAccbalflag(Double accbalflag) {
		this.accbalflag = accbalflag;
	}

	public Double getAccadjid() {
		return accadjid;
	}

	public void setAccadjid(Double accadjid) {
		this.accadjid = accadjid;
	}

	public Double getAcctype() {
		return acctype;
	}

	public void setAcctype(Double acctype) {
		this.acctype = acctype;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
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

	
	
	
	
	
	
	
	
}
