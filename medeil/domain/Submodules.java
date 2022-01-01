package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_submodulemaster", catalog = "medc_adminsecurity")
public class Submodules implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947603215144840709L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long submoduleid;

	public long modulerefid;

	public String domainrefid;

	public String subdomainrefid;

	public String countryid;

	public String productid;

	public String submodulecode;

	public String submodulename;

	public String foldername;

	public String url;

	public String status;

	public String approvalprocess;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String icon;

	protected Submodules() {

	}

	public long getSubmoduleid() {
		return submoduleid;
	}

	public void setSubmoduleid(long submoduleid) {
		this.submoduleid = submoduleid;
	}

	public long getModulerefid() {
		return modulerefid;
	}

	public void setModulerefid(long modulerefid) {
		this.modulerefid = modulerefid;
	}

	public String getDomainrefid() {
		return domainrefid;
	}

	public void setDomainrefid(String domainrefid) {
		this.domainrefid = domainrefid;
	}

	public String getSubdomainrefid() {
		return subdomainrefid;
	}

	public void setSubdomainrefid(String subdomainrefid) {
		this.subdomainrefid = subdomainrefid;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getSubmodulecode() {
		return submodulecode;
	}

	public void setSubmodulecode(String submodulecode) {
		this.submodulecode = submodulecode;
	}

	public String getSubmodulename() {
		return submodulename;
	}

	public void setSubmodulename(String submodulename) {
		this.submodulename = submodulename;
	}

	public String getFoldername() {
		return foldername;
	}

	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprovalprocess() {
		return approvalprocess;
	}

	public void setApprovalprocess(String approvalprocess) {
		this.approvalprocess = approvalprocess;
	}

	public Submodules(long modulerefid, String domainrefid, String subdomainrefid, String countryid,
			String productid, String submodulecode, String submodulename, String foldername, String url, String status,
			String approvalprocess) {
		this.modulerefid = modulerefid;
		this.domainrefid = domainrefid;
		this.subdomainrefid = subdomainrefid;
		this.countryid = countryid;
		this.productid = productid;
		this.submodulecode = submodulecode;
		this.submodulename = submodulename;
		this.foldername = foldername;
		this.url = url;
		this.status = status;
		this.approvalprocess = approvalprocess;
	}

	@Override
	public String toString() {
		return String.format(
				"Submodules[submoduleid=%d,modulerefid='%s',domainrefid='%s',subdomainrefid='%s',countryid='%s',productid='%s',submodulecode='%s',submodulename='%s',foldername='%s',url='%s',status='%s',approvalprocess='%s']",
				submoduleid, modulerefid, domainrefid, subdomainrefid, countryid, productid, submodulecode,
				submodulename, foldername, url, status, approvalprocess);
	}

}
