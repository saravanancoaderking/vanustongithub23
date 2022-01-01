package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_twilio", catalog = "medc_sms")
public class TwilioAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int twlid;
	private String accountsid;
	private String authtoken;
	private String sendernumber;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private int status;
	private int smsproid;

	public int getTwlid() {
		return twlid;
	}

	public void setTwlid(int twlid) {
		this.twlid = twlid;
	}

	public String getAccountsid() {
		return accountsid;
	}

	public void setAccountsid(String accountsid) {
		this.accountsid = accountsid;
	}

	public String getAuthtoken() {
		return authtoken;
	}

	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}

	public String getSendernumber() {
		return sendernumber;
	}

	public void setSendernumber(String sendernumber) {
		this.sendernumber = sendernumber;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSmsproid() {
		return smsproid;
	}

	public void setSmsproid(int smsproid) {
		this.smsproid = smsproid;
	}

}
