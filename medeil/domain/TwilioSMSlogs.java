package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "twlsms_logs", catalog = "medc_sms")
public class TwilioSMSlogs implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int smslogid;
	private String account_sid;
	private String api_version;
	private String body;
	private String direction;
	private String fromnumber;
	private String sid;
	private String status;
	private String tonumber;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private String createddate;
	private String clientcdate;
	private String messagesegments;
	private int twlid;
	private int formid;

	public int getSmslogid() {
		return smslogid;
	}

	public void setSmslogid(int smslogid) {
		this.smslogid = smslogid;
	}

	public String getAccount_sid() {
		return account_sid;
	}

	public void setAccount_sid(String account_sid) {
		this.account_sid = account_sid;
	}

	public String getApi_version() {
		return api_version;
	}

	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getFromnumber() {
		return fromnumber;
	}

	public void setFromnumber(String fromnumber) {
		this.fromnumber = fromnumber;
	}

	public String getTonumber() {
		return tonumber;
	}

	public void setTonumber(String tonumber) {
		this.tonumber = tonumber;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getMessagesegments() {
		return messagesegments;
	}

	public void setMessagesegments(String messagesegments) {
		this.messagesegments = messagesegments;
	}

	public int getTwlid() {
		return twlid;
	}

	public void setTwlid(int twlid) {
		this.twlid = twlid;
	}

	public int getFormid() {
		return formid;
	}

	public void setFormid(int formid) {
		this.formid = formid;
	}
}
