package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_useractivities" , catalog = "medc_adminsecurity")
public class UserActivity  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uaid")
	private Integer id;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer modulerefid;
	private Integer submodulerefid;
	
	private String createddate;
	private String ipaddress;
	private String browsertype;
	private String browserversion;
	private String macaddress;
	private String ostype;
	private String osversion;
	
	private Integer userid;

	private String formevent;
	private String apiname;
	private String description;
	
	private String clientcdate;
	private String formentrytime;
	private String formexittime;
	private String formsessiontime;
	private Integer companyrefid;
	private String pstarttime;
	private String pendtime;
	
	
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
	public Integer getModulerefid() {
		return modulerefid;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setModulerefid(Integer modulerefid) {
		this.modulerefid = modulerefid;
	}
	public Integer getSubmodulerefid() {
		return submodulerefid;
	}
	public void setSubmodulerefid(Integer submodulerefid) {
		this.submodulerefid = submodulerefid;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getBrowsertype() {
		return browsertype;
	}
	public void setBrowsertype(String browsertype) {
		this.browsertype = browsertype;
	}
	public String getBrowserversion() {
		return browserversion;
	}
	public void setBrowserversion(String browserversion) {
		this.browserversion = browserversion;
	}
	public String getMacaddress() {
		return macaddress;
	}
	public void setMacaddress(String macaddress) {
		this.macaddress = macaddress;
	}
	public String getOstype() {
		return ostype;
	}
	public void setOstype(String ostype) {
		this.ostype = ostype;
	}
	public String getOsversion() {
		return osversion;
	}
	public void setOsversion(String osversion) {
		this.osversion = osversion;
	}
	public String getFormevent() {
		return formevent;
	}
	public void setFormevent(String formevent) {
		this.formevent = formevent;
	}
	public String getApiname() {
		return apiname;
	}
	public void setApiname(String apiname) {
		this.apiname = apiname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public String getFormentrytime() {
		return formentrytime;
	}
	public void setFormentrytime(String formentrytime) {
		this.formentrytime = formentrytime;
	}
	public String getFormexittime() {
		return formexittime;
	}
	public void setFormexittime(String formexittime) {
		this.formexittime = formexittime;
	}
	public String getFormsessiontime() {
		return formsessiontime;
	}
	public void setFormsessiontime(String formsessiontime) {
		this.formsessiontime = formsessiontime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getCompanyrefid() {
		return companyrefid;
	}
	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getPstarttime() {
		return pstarttime;
	}
	public void setPstarttime(String pstarttime) {
		this.pstarttime = pstarttime;
	}
	public String getPendtime() {
		return pendtime;
	}
	public void setPendtime(String pendtime) {
		this.pendtime = pendtime;
	}
	
	

	
}
