
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
 *
 */
@Entity
@Table(name = "medc_companyinfomation", catalog = "medc_companyreg")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CompanyID")
	private Integer id;

	private String companyname;

	private String shortname;

	private String contactperson;

	private String desgination;

	private String gstno;

	private String tinno;

	private String cstno;

	private String panno;

	private String mobileno;

	private String address1;

	private String address2;

	private Integer state;

	private Integer country;

	private Integer city;

	private String pincode;

	private String phoneno;

	private String email;

	private Integer productrefid;

	private Integer domainrefid;

	private Integer subdomainrefid;

	private Integer editionrefid;

	private String username;

	private String password;

	private String countrycode;

	private Integer registerflag;

	private String clientcdate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getDesgination() {
		return desgination;
	}

	public void setDesgination(String desgination) {
		this.desgination = desgination;
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

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getEditionrefid() {
		return editionrefid;
	}

	public void setEditionrefid(Integer editionrefid) {
		this.editionrefid = editionrefid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public Integer getRegisterflag() {
		return registerflag;
	}

	public void setRegisterflag(Integer registerflag) {
		this.registerflag = registerflag;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

}
