package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "medc_editionmaster", catalog = "medc_adminsecurity")
public class Edition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EditionID")
	private int id;

	private Integer editiontype;

	private String countryid;

	private String productid;

	private String domainrefid;

	private String subdomainrefid;

	private String editioncode;

	private String editionname;

	private String version;

	private String releasedate;

	private Integer status;
	
	private String description;
	
	private Integer storetype;
	
private Integer ranking;

	@Transient
	private String clientrole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getEditiontype() {
		return editiontype;
	}

	public void setEditiontype(Integer editiontype) {
		this.editiontype = editiontype;
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

	public String getEditioncode() {
		return editioncode;
	}

	public void setEditioncode(String editioncode) {
		this.editioncode = editioncode;
	}

	public String getEditionname() {
		return editionname;
	}

	public void setEditionname(String editionname) {
		this.editionname = editionname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getClientrole() {
		return clientrole;
	}

	public void setClientrole(String clientrole) {
		this.clientrole = clientrole;
	}

	public Integer getStoretype() {
		return storetype;
	}

	public void setStoretype(Integer storetype) {
		this.storetype = storetype;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

}
