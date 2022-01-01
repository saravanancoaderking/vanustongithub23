package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_domainmaster", catalog = "medc_adminsecurity")
public class Domain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Domainid;

	private String countryid;

	private String domainname;

	private String domaincode;

	private String productid;

	private boolean removeflag;

	public long getDomainid() {
		return Domainid;
	}

	public void setDomainid(long domainid) {
		Domainid = domainid;
	}

	public String getCountryid() {
		return countryid;
	}

	public void setCountryid(String countryid) {
		this.countryid = countryid;
	}

	public String getDomainname() {
		return domainname;
	}

	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

	public String getDomaincode() {
		return domaincode;
	}

	public void setDomaincode(String domaincode) {
		this.domaincode = domaincode;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public boolean isRemoveflag() {
		return removeflag;
	}

	public void setRemoveflag(boolean removeflag) {
		this.removeflag = removeflag;
	}

}
