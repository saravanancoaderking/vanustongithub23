package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_adduser", catalog = "medc_adminsecurity")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cuserid")
	private Integer id;

	private Integer countryrefid;

	private Integer productrefid;

	private Integer domainrefid;

	private Integer subdomainrefid;

	private Integer companyrefid;

	private Integer rolerefid;

	private String username;

	private Integer editionrefid;

	private String emailid;

	private String phoneno;
	
	private long suserrefid;
	
	private String customername;
	
	private Integer planid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
	}

	public Integer getProductrefid() {
		return productrefid;
	}

	public void setProductrefid(Integer productrefid) {
		this.productrefid = productrefid;
	}

	public Integer getDomainrefid() {
		return domainrefid;
	}

	public void setDomainrefid(Integer domainrefid) {
		this.domainrefid = domainrefid;
	}

	public Integer getSubdomainrefid() {
		return subdomainrefid;
	}

	public void setSubdomainrefid(Integer subdomainrefid) {
		this.subdomainrefid = subdomainrefid;
	}

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public Integer getRolerefid() {
		return rolerefid;
	}

	public void setRolerefid(Integer rolerefid) {
		this.rolerefid = rolerefid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getEditionrefid() {
		return editionrefid;
	}

	public void setEditionrefid(Integer editionrefid) {
		this.editionrefid = editionrefid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public long getSuserrefid() {
		return suserrefid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setSuserrefid(long suserrefid) {
		this.suserrefid = suserrefid;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

}
