package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_role", catalog = "medc_adminsecurity")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleid")
	private Integer id;

	private Integer companyid;

	private String rolename;
	
	private Integer shopid;
	
	private Integer countryid;
	
	private Integer productid;
	
	private String clientcdate;
	
	private Integer editionrefid;
	
	private Integer userid;
	
	
	private Integer storetype;
	
	public Integer getEditionrefid() {
		return editionrefid;
	}

	public void setEditionrefid(Integer editionrefid) {
		this.editionrefid = editionrefid;
	}

	public Integer getRoleid() {
		return id;
	}

	public void setRoleid(Integer roleid) {
		this.id = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public Integer getProductid() {
		return productid;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getStoretype() {
		return storetype;
	}

	public void setStoretype(Integer storetype) {
		this.storetype = storetype;
	}

}
