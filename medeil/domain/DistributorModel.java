package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_distributorinformation", catalog = "medc_distributor")
public class DistributorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distributorid")
	private int id;

	private String distributorname;
	private String dshortname;

	@Column(name = "dcompanytype")
	private String dcompnaytype;

	@Column(name = "dcompanysubtype")
	private String dcompnaysubtype;

	private String estdyear;

	private String email;
	private String address1;
	private String address2;

	private String pincode;
	private int country;
	private int state;
	private int city;
	private String countrycode;
	private String contactperson;
	private String designationid;

	private String mobileno;
	private String phoneno;
	private String panno;

	private String tinno;
	private String gstno;
	private String ieccode;
	private String termsandconditions;
	private String dipaddress;
	private String aadharno;
	private String paymenttype;
	private int creditdays;
	private String bankname;
	private String bankbranch;

	private String accountnumber;
	private String ifsccode;
	private String swiftcode;
	private String misccode;

	private String ipaddress;
	private String macid;
	private String ostype;
	private String browsertype;
	private String rating;
	private String comments;

	private int createdby;

	private int modifiedby;

	private int status;
	private int distributortypeid;

	private double locrefid;
	private double locname;

	private String distno;

	public String getDistributorname() {
		return distributorname;
	}

	public void setDistributorname(String distributorname) {
		this.distributorname = distributorname;
	}

	public String getDshortname() {
		return dshortname;
	}

	public void setDshortname(String dshortname) {
		this.dshortname = dshortname;
	}

	public String getDcompnaytype() {
		return dcompnaytype;
	}

	public void setDcompnaytype(String dcompnaytype) {
		this.dcompnaytype = dcompnaytype;
	}

	public String getDcompnaysubtype() {
		return dcompnaysubtype;
	}

	public void setDcompnaysubtype(String dcompnaysubtype) {
		this.dcompnaysubtype = dcompnaysubtype;
	}

	public String getEstdyear() {
		return estdyear;
	}

	public void setEstdyear(String estdyear) {
		this.estdyear = estdyear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getDesignationid() {
		return designationid;
	}

	public void setDesignationid(String designationid) {
		this.designationid = designationid;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getTinno() {
		return tinno;
	}

	public void setTinno(String tinno) {
		this.tinno = tinno;
	}

	public String getGstno() {
		return gstno;
	}

	public void setGstno(String gstno) {
		this.gstno = gstno;
	}

	public String getIeccode() {
		return ieccode;
	}

	public void setIeccode(String ieccode) {
		this.ieccode = ieccode;
	}

	public String getTermsandconditions() {
		return termsandconditions;
	}

	public void setTermsandconditions(String termsandconditions) {
		this.termsandconditions = termsandconditions;
	}

	public String getDipaddress() {
		return dipaddress;
	}

	public void setDipaddress(String dipaddress) {
		this.dipaddress = dipaddress;
	}

	public String getAadharno() {
		return aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public int getCreditdays() {
		return creditdays;
	}

	public void setCreditdays(int creditdays) {
		this.creditdays = creditdays;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankbranch() {
		return bankbranch;
	}

	public void setBankbranch(String bankbranch) {
		this.bankbranch = bankbranch;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getSwiftcode() {
		return swiftcode;
	}

	public void setSwiftcode(String swiftcode) {
		this.swiftcode = swiftcode;
	}

	public String getMisccode() {
		return misccode;
	}

	public void setMisccode(String misccode) {
		this.misccode = misccode;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getMacid() {
		return macid;
	}

	public void setMacid(String macid) {
		this.macid = macid;
	}

	public String getOstype() {
		return ostype;
	}

	public void setOstype(String ostype) {
		this.ostype = ostype;
	}

	public String getBrowsertype() {
		return browsertype;
	}

	public void setBrowsertype(String browsertype) {
		this.browsertype = browsertype;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public int getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDistributortypeid() {
		return distributortypeid;
	}

	public void setDistributortypeid(int distributortypeid) {
		this.distributortypeid = distributortypeid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(double locrefid) {
		this.locrefid = locrefid;
	}

	public double getLocname() {
		return locname;
	}

	public void setLocname(double locname) {
		this.locname = locname;
	}

	public String getDistno() {
		return distno;
	}

	public void setDistno(String distno) {
		this.distno = distno;
	}

}
