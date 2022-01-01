 package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_warehouseinfo", catalog = "medc_warehousereg")
public class Warehouse implements Serializable {
	// private static final long serialVersionUID = -8411104924971953257L;
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouseid")
	private Integer id;

	public String warehousename;

	public String warehousecode;

	public String owner_name;

	public String address1;

	public String address2;

	public String address3;

	public Integer city;

	public Integer state;

	public Integer country;

	public String pincode;

	public String contact_no1;

	public String contact_no2;

	public String mobile_no;

	public String email_id;

	public String dlno;

	public String license_holder;

	public String tinno;

	public String cstno;

	public String panno;

	public String gstno;

	public String coldstorage;

	public Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private String clientcdate;

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public Integer getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(Integer branchrefid) {
		this.branchrefid = branchrefid;
	}

	public Integer getLocname() {
		return locname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	protected Warehouse() {
	}

	public String getWarehousename() {
		return warehousename;
	}

	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}

	public String getWarehousecode() {
		return warehousecode;
	}

	public void setWarehousecode(String warehousecode) {
		this.warehousecode = warehousecode;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContact_no1() {
		return contact_no1;
	}

	public void setContact_no1(String contact_no1) {
		this.contact_no1 = contact_no1;
	}

	public String getContact_no2() {
		return contact_no2;
	}

	public void setContact_no2(String contact_no2) {
		this.contact_no2 = contact_no2;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getDlno() {
		return dlno;
	}

	public void setDlno(String dlno) {
		this.dlno = dlno;
	}

	public String getLicense_holder() {
		return license_holder;
	}

	public void setLicense_holder(String license_holder) {
		this.license_holder = license_holder;
	}

	public String getTinno() {
		return tinno;
	}

	public void setTinno(String tinno) {
		this.tinno = tinno;
	}

	public String getCstno() {
		return cstno;
	}

	public void setCstno(String cstno) {
		this.cstno = cstno;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getGstno() {
		return gstno;
	}

	public void setGstno(String gstno) {
		this.gstno = gstno;
	}

	public String getColdstorage() {
		return coldstorage;
	}

	public void setColdstorage(String coldstorage) {
		this.coldstorage = coldstorage;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	/*
	 * public Warehouse(String warehousename, String warehousecode, String
	 * owner_name, String address1, String address2, String address3, String
	 * country, String state, String city, String pincode, String contact_no1,
	 * String contact_no2, String mobile_no, String email_id, String dlno, String
	 * license_holder, String tinno, String panno, String cstno, String gstno,
	 * String coldstorage, String status) { this.warehousename = warehousename;
	 * this.warehousecode = warehousecode; this.owner_name = owner_name;
	 * this.address1 = address1; this.address2 = address2; this.address3 = address3;
	 * this.country = country; this.state = state; this.city = city; this.pincode =
	 * pincode; this.contact_no1 = contact_no1; this.contact_no2 = contact_no2;
	 * this.mobile_no = mobile_no; this.email_id = email_id; this.dlno = dlno;
	 * this.license_holder = license_holder; this.tinno = tinno; this.cstno = cstno;
	 * this.panno = panno; this.gstno = gstno; this.coldstorage = coldstorage;
	 * this.status = status;
	 * 
	 * }
	 * 
	 * @Override public String toString() { return String.format(
	 * "Warehouse[warehouseid='%d',warehousename='%s',warehousecode='%s',owner_name='%s',address1='%s',address2='%s',address3='%s',country='%s',state='%s',city='%s',pincode='%s',contact_no1='%s',contact_no2='%s',mobile_no='%s',email_id='%s',dlno='%s',license_holder='%s',tinno='%s',panno='%s',cstno='%s',gstno='%s',coldstorage='%s',status='%s']",
	 * warehouseid, warehousename, warehousecode, owner_name, address1, address2,
	 * address3, country, state, city, pincode, contact_no1, contact_no2, mobile_no,
	 * email_id, dlno, license_holder, tinno, panno, cstno, gstno, coldstorage,
	 * status); }
	 */

}