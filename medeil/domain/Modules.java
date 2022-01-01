/**
 * 
 */
package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Add Modules
 *
 */
@Entity
@Table(name = "medc_modulesmaster", catalog = "medc_adminsecurity")
public class Modules implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long moduleid;

	public String domainrefid;

	public String subdomainrefid;

	public String countryid;

	public String productid;

	public String modulecode;

	public String modulename;

	public String status;

	public String label;

	public String icon;

	protected Modules() {

	}
	// getters and setters

	public Modules(String modulename, String domainrefid, String subdomainrefid, String countryid, String modulecode,
			String productid, String status) {

		this.modulename = modulename;
		this.domainrefid = domainrefid;
		this.countryid = countryid;
		this.productid = productid;
		this.subdomainrefid = subdomainrefid;
		this.modulecode = modulecode;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getModuleid() {
		return moduleid;
	}

	public void setModuleid(long moduleid) {
		this.moduleid = moduleid;
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

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
     
	
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return String.format(
				"Modules[moduleid='%d',modulename='%s',domainrefid='%s',countryid='%s',productid='%s',subdomainrefid='%s',modulecode='%s',status='%s']",
				moduleid, modulename, domainrefid, countryid, productid, subdomainrefid, modulecode, status);
	}

}
