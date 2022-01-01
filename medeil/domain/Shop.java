package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ajith
 */
@Entity
@Table(name = "medc_shopinformation", catalog = "medc_storereg")
public class Shop implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShopID")
	private Integer id;

	private String shopcode;

	private String shopname;

	private String ownername;

	private String license_holder;

	private String dlno;

	private String gstno;

	private String tinno;

	private String cstno;

	private String panno;

	private String phar_registration_no;

	private String address1;
	
	//Raja
	private String address2;

	private Integer city;

	private Integer state;

	private Integer country;

	private String pincode;

	private String mobileno;

	private String emailid;

	private String pharmacistname;

	private Integer phar_city;

	private Integer phar_state;

	private Integer phar_country;

	private String phar_pincode;

	private String phar_contactno1;

	private String phar_emailid;

	private Integer registerflag;

	private Integer companyid;

	private Integer branchid;

	private String clientcdate;

	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locname;

	private Integer locrefid;
	
	private String bankname;

	private String shoplogo;

	private String branchname;
	
	private String accountno;
	
	private String accounttype;
	
	private String ifsccode;
	
	private Integer bankid;
	
	private Integer bankbranchid;

	private String website;
		
		
	
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

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopcode() {
		return shopcode;
	}

	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getLicense_holder() {
		return license_holder;
	}

	public void setLicense_holder(String license_holder) {
		this.license_holder = license_holder;
	}

	public String getDlno() {
		return dlno;
	}

	public void setDlno(String dlno) {
		this.dlno = dlno;
	}

	public String getGstno() {
		return gstno;
	}

	public void setGstno(String gstno) {
		this.gstno = gstno;
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

	public String getPhar_registration_no() {
		return phar_registration_no;
	}

	public void setPhar_registration_no(String phar_registration_no) {
		this.phar_registration_no = phar_registration_no;
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

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPharmacistname() {
		return pharmacistname;
	}

	public void setPharmacistname(String pharmacistname) {
		this.pharmacistname = pharmacistname;
	}

	public Integer getPhar_city() {
		return phar_city;
	}

	public void setPhar_city(Integer phar_city) {
		this.phar_city = phar_city;
	}

	public Integer getPhar_state() {
		return phar_state;
	}

	public void setPhar_state(Integer phar_state) {
		this.phar_state = phar_state;
	}

	public Integer getPhar_country() {
		return phar_country;
	}

	public void setPhar_country(Integer phar_country) {
		this.phar_country = phar_country;
	}

	public String getPhar_pincode() {
		return phar_pincode;
	}

	public void setPhar_pincode(String phar_pincode) {
		this.phar_pincode = phar_pincode;
	}

	public String getPhar_contactno1() {
		return phar_contactno1;
	}

	public void setPhar_contactno1(String phar_contactno1) {
		this.phar_contactno1 = phar_contactno1;
	}

	public String getPhar_emailid() {
		return phar_emailid;
	}

	public void setPhar_emailid(String phar_emailid) {
		this.phar_emailid = phar_emailid;
	}

	public Integer getRegisterflag() {
		return registerflag;
	}

	public void setRegisterflag(Integer registerflag) {
		this.registerflag = registerflag;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getBankname() {
		return bankname;
	}

	public String getBranchname() {
		return branchname;
	}


	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

		public String getShoplogo() {
		return shoplogo;
	}

	public void setShoplogo(String shoplogo) {
		this.shoplogo = shoplogo;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public Integer getBankid() {
		return bankid;
	}

	public Integer getBankbranchid() {
		return bankbranchid;
	}

	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}

	public void setBankbranchid(Integer bankbranchid) {
		this.bankbranchid = bankbranchid;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
