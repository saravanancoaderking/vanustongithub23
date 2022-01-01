package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_subdomainmaster", catalog = "medc_adminsecurity")
public class Subdomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Subdomainid;

	private String domainrefid;

	private Integer countryid;

	private String subdomaincode;

	private Integer productid;

	private String subdomainname;

	private String status;

	public Integer getSubdomainid() {
		return Subdomainid;
	}

	public void setSubdomainid(Integer subdomainid) {
		Subdomainid = subdomainid;
	}

	public String getDomainrefid() {
		return domainrefid;
	}

	public void setDomainrefid(String domainrefid) {
		this.domainrefid = domainrefid;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public String getSubdomaincode() {
		return subdomaincode;
	}

	public void setSubdomaincode(String subdomaincode) {
		this.subdomaincode = subdomaincode;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getSubdomainname() {
		return subdomainname;
	}

	public void setSubdomainname(String subdomainname) {
		this.subdomainname = subdomainname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}