package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "medc_adduser", catalog = "medc_adminsecurity")
public class MedcAdduser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cuserid;
	private int countryrefid;
	private int productrefid;
	private int domainrefid;
	private int subdomainrefid;
	private int companyrefid;
	private int editionrefid;
	private int rolerefid;
	private Integer suserrefid;
	private String username;
	private String emailid;
	private String phoneno;
	private Integer planid;

	public int getCuserid() {
		return cuserid;
	}

	public void setCuserid(int cuserid) {
		this.cuserid = cuserid;
	}

	public int getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(int countryrefid) {
		this.countryrefid = countryrefid;
	}

	public int getProductrefid() {
		return productrefid;
	}

	public void setProductrefid(int productrefid) {
		this.productrefid = productrefid;
	}

	public int getDomainrefid() {
		return domainrefid;
	}

	public void setDomainrefid(int domainrefid) {
		this.domainrefid = domainrefid;
	}

	public int getSubdomainrefid() {
		return subdomainrefid;
	}

	public void setSubdomainrefid(int subdomainrefid) {
		this.subdomainrefid = subdomainrefid;
	}

	public int getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}

	public int getEditionrefid() {
		return editionrefid;
	}

	public void setEditionrefid(int editionrefid) {
		this.editionrefid = editionrefid;
	}

	public int getRolerefid() {
		return rolerefid;
	}

	public void setRolerefid(int rolerefid) {
		this.rolerefid = rolerefid;
	}

	public Integer getSuserrefid() {
		return suserrefid;
	}

	public void setSuserrefid(Integer suserrefid) {
		this.suserrefid = suserrefid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

}
