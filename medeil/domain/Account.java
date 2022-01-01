package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "medc_acount", catalog = "medc_accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AccID")
	private int id;
	private int accountid;
	private String accountno;
	private String accountname;
	private Double accounttype;
	private String  accbalance  ;
	private String  accbalflag  ;
	private String  balcalcflag  ;
	private Boolean cashflag =false ; 
	private String clientcdate;
	private String clientmdate;
	private String clientcdate1;
	private Double locname;
	private Double locrefid;
	private Integer status;
	private Integer countryrefid;  
	private Integer companyrefid  ;
	private Integer branchrefid  ;
	private Integer custaccflag  ;
	@Transient
	private  Integer accounttypeno;
	private String accdescription;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public Integer getAccounttypeno() {
		return accounttypeno;
	}
	public void setAccounttypeno(Integer accounttypeno) {
		this.accounttypeno = accounttypeno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public double getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(double accounttype) {
		this.accounttype = accounttype;
	}
	public double getLocname() {
		return locname;
	}
	public void setLocname(double locname) {
		this.locname = locname;
	}
	public double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(double locrefid) {
		this.locrefid = locrefid;
	}
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public String getClientcdate1() {
		return clientcdate1;
	}
	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}
	public String getAccbalance() {
		return accbalance;
	}
	public void setAccbalance(String accbalance) {
		this.accbalance = accbalance;
	}
	public String getAccbalflag() {
		return accbalflag;
	}
	public void setAccbalflag(String accbalflag) {
		this.accbalflag = accbalflag;
	}
	public String getBalcalcflag() {
		return balcalcflag;
	}
	public void setBalcalcflag(String balcalcflag) {
		this.balcalcflag = balcalcflag;
	}

	public Boolean getCashflag() {
		return cashflag;
	}
	public void setCashflag(Boolean cashflag) {
		this.cashflag = cashflag;
	}
	public void setAccounttype(Double accounttype) {
		this.accounttype = accounttype;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
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
	public Integer getCustaccflag() {
		return custaccflag;
	}
	public void setCustaccflag(Integer custaccflag) {
		this.custaccflag = custaccflag;
	}
	public String getClientmdate() {
		return clientmdate;
	}
	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
	}
	public String getAccdescription() {
		return accdescription;
	}
	public void setAccdescription(String accdescription) {
		this.accdescription = accdescription;
	}
	
}