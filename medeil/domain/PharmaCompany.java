package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_pharmacompanies", catalog = "medc_pharmacompany")
public class PharmaCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pcompanyid")
	private int id;

	private String pcompanyname;

	private String pshortname;

	@Column(name = "pcompanytype")
	private String pcompnaytype;

	@Column(name = "pcompanysubtype")
	private String phdivision;// Boopalan 120419

	public String getPhdivision() {
		return phdivision;
	}

	public void setPhdivision(String phdivision) {
		this.phdivision = phdivision;
	}

	private String estdyear;

	private String dlno;// Boopalan 120419

	private String pemail;

	private String paddress1;

	private String paddress2;

	private String ppincode;

	private Integer pcountry;

	private Integer pstate;

	private Integer pcity;

	private String pcountrycode;

	private String pcontactperson;

	private String pdesignationid;

	private String pmobileno;

	private String pphoneno;

	private String ppanno;

	private String ptinno;

	private String pgstno;

	private String pieccode;

	private String termsandconditions;

	private String pipaddress;

	private String panno;

	private String paymenttype;

	private Integer creditdays;

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

	private int locrefid;
	private int locname;

	private String phcompanyno;

	private Boolean delflag = false;

	private String clientcdate;
	private String clientcdate1;

	private Integer countryoforigin;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPcompanyname() {
		return pcompanyname;
	}

	public void setPcompanyname(String pcompanyname) {
		this.pcompanyname = pcompanyname;
	}

	public String getPshortname() {
		return pshortname;
	}

	public void setPshortname(String pshortname) {
		this.pshortname = pshortname;
	}

	public String getPcompnaytype() {
		return pcompnaytype;
	}

	public void setPcompnaytype(String pcompnaytype) {
		this.pcompnaytype = pcompnaytype;
	}
/*
	public String getPcompnaysubtype() {
		return pcompnaysubtype;
	}

	public void setPcompnaysubtype(String pcompnaysubtype) {
		this.pcompnaysubtype = pcompnaysubtype;
	} */

	public String getEstdyear() {
		return estdyear;
	}

	public void setEstdyear(String estdyear) {
		this.estdyear = estdyear;
	}

	public String getPemail() {
		return pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	public String getPaddress1() {
		return paddress1;
	}

	public void setPaddress1(String paddress1) {
		this.paddress1 = paddress1;
	}

	public String getPaddress2() {
		return paddress2;
	}

	public void setPaddress2(String paddress2) {
		this.paddress2 = paddress2;
	}

	public String getPpincode() {
		return ppincode;
	}

	public void setPpincode(String ppincode) {
		this.ppincode = ppincode;
	}

	public Integer getPcountry() {
		return pcountry;
	}

	public void setPcountry(Integer pcountry) {
		this.pcountry = pcountry;
	}

	public Integer getPstate() {
		return pstate;
	}

	public void setPstate(Integer pstate) {
		this.pstate = pstate;
	}

	public Integer getPcity() {
		return pcity;
	}

	public void setPcity(Integer pcity) {
		this.pcity = pcity;
	}

	public String getPcountrycode() {
		return pcountrycode;
	}

	public void setPcountrycode(String pcountrycode) {
		this.pcountrycode = pcountrycode;
	}

	public String getPcontactperson() {
		return pcontactperson;
	}

	public void setPcontactperson(String pcontactperson) {
		this.pcontactperson = pcontactperson;
	}

	public String getPdesignationid() {
		return pdesignationid;
	}

	public void setPdesignationid(String pdesignationid) {
		this.pdesignationid = pdesignationid;
	}

	public String getPmobileno() {
		return pmobileno;
	}

	public void setPmobileno(String pmobileno) {
		this.pmobileno = pmobileno;
	}

	public String getPphoneno() {
		return pphoneno;
	}

	public void setPphoneno(String pphoneno) {
		this.pphoneno = pphoneno;
	}

	public String getPpanno() {
		return ppanno;
	}

	public void setPpanno(String ppanno) {
		this.ppanno = ppanno;
	}

	public String getPtinno() {
		return ptinno;
	}

	public void setPtinno(String ptinno) {
		this.ptinno = ptinno;
	}

	public String getPgstno() {
		return pgstno;
	}

	public void setPgstno(String pgstno) {
		this.pgstno = pgstno;
	}

	public String getPieccode() {
		return pieccode;
	}

	public void setPieccode(String pieccode) {
		this.pieccode = pieccode;
	}

	public String getTermsandconditions() {
		return termsandconditions;
	}

	public void setTermsandconditions(String termsandconditions) {
		this.termsandconditions = termsandconditions;
	}

	public String getPipaddress() {
		return pipaddress;
	}

	public void setPipaddress(String pipaddress) {
		this.pipaddress = pipaddress;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public Integer getCreditdays() {
		return creditdays;
	}

	public void setCreditdays(Integer creditdays) {
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

	public int getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(int locrefid) {
		this.locrefid = locrefid;
	}

	public int getLocname() {
		return locname;
	}

	public void setLocname(int locname) {
		this.locname = locname;
	}

	public String getPhcompanyno() {
		return phcompanyno;
	}

	public void setPhcompanyno(String phcompanyno) {
		this.phcompanyno = phcompanyno;
	}

	public Boolean getDelflag() {
		return delflag;
	}

	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getClientcdate1() {
		return clientcdate1;
	}

	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}

	public Integer getCountryoforigin() {
		return countryoforigin;
	}

	public void setCountryoforigin(Integer countryoforigin) {
		this.countryoforigin = countryoforigin;
	}

	public Integer getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
	}

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

	public String getDlno() {
		return dlno;
	}

	public void setDlno(String dlno) {
		this.dlno = dlno;
	}

}
