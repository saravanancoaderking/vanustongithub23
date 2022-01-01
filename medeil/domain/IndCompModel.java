package com.medeil.domain;

import java.io.Serializable;

public class IndCompModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer frmint1;
	private Integer frmint2;
	private Integer frmint3;
	private Double frmdbl1;
	private Double frmdbl2;
	private String frmstr1;
	private String frmstr2;
	private String frmstr3;
	private double grandtotal;
	private String custinvoiceno;
	private String email;
	private String url;
	private String customername;
	private Integer createdby ;
	private Integer locrefid;
	private Integer locname;
	private Integer companyid;
	private int salesorderid;
	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;

	private Integer piid; // Boopalan
	private int distributorid;// Boopalan
	private int patientid; // Boopalan
	private int pcompanyid ; // Boopalan
	private int indentreqid;
	private int stkminid;
	private String searchvalue;
	private int searchid;
	private int productid;
	private int batchid;
	private int sorderid;
	// Boopalan
	// SIVAKUMAR for x-read
	private String billdate;
	private String fromdate;
	private String todate;
	private String price;
	// conflict
	public Integer getFrmint1() {
		return frmint1;
	}
	public void setFrmint1(Integer frmint1) {
		this.frmint1 = frmint1;
	}
	public Integer getFrmint2() {
		return frmint2;
	}
	public void setFrmint2(Integer frmint2) {
		this.frmint2 = frmint2;
	}
	public Integer getFrmint3() {
		return frmint3;
	}
	public void setFrmint3(Integer frmint3) {
		this.frmint3 = frmint3;
	}
	public Double getFrmdbl1() {
		return frmdbl1;
	}
	public void setFrmdbl1(Double frmdbl1) {
		this.frmdbl1 = frmdbl1;
	}
	public Double getFrmdbl2() {
		return frmdbl2;
	}
	public void setFrmdbl2(Double frmdbl2) {
		this.frmdbl2 = frmdbl2;
	}
	public String getFrmstr1() {
		return frmstr1;
	}
	public void setFrmstr1(String frmstr1) {
		this.frmstr1 = frmstr1;
	}
	public String getFrmstr2() {
		return frmstr2;
	}
	public void setFrmstr2(String frmstr2) {
		this.frmstr2 = frmstr2;
	}
	public String getFrmstr3() {
		return frmstr3;
	}
	public void setFrmstr3(String frmstr3) {
		this.frmstr3 = frmstr3;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public String getCustinvoiceno() {
		return custinvoiceno;
	}
	public void setCustinvoiceno(String custinvoiceno) {
		this.custinvoiceno = custinvoiceno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public Integer getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}
	public Integer getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}
	public Integer getLocname() {
		return locname;
	}
	public void setLocname(Integer locname) {
		this.locname = locname;
	}
	public Integer getCompanyid() {
		return companyid;
	}
	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}
	public int getSalesorderid() {
		return salesorderid;
	}
	public void setSalesorderid(int salesorderid) {
		this.salesorderid = salesorderid;
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
	public Integer getPiid() {
		return piid;
	}
	public void setPiid(Integer piid) {
		this.piid = piid;
	}
	public int getDistributorid() {
		return distributorid;
	}
	public void setDistributorid(int distributorid) {
		this.distributorid = distributorid;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public int getPcompanyid() {
		return pcompanyid;
	}
	public void setPcompanyid(int pcompanyid) {
		this.pcompanyid = pcompanyid;
	}
	public int getIndentreqid() {
		return indentreqid;
	}
	public void setIndentreqid(int indentreqid) {
		this.indentreqid = indentreqid;
	}
	public int getStkminid() {
		return stkminid;
	}
	public void setStkminid(int stkminid) {
		this.stkminid = stkminid;
	}
	public String getSearchvalue() {
		return searchvalue;
	}
	public void setSearchvalue(String searchvalue) {
		this.searchvalue = searchvalue;
	}
	public int getSearchid() {
		return searchid;
	}
	public void setSearchid(int searchid) {
		this.searchid = searchid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	public int getSorderid() {
		return sorderid;
	}
	public void setSorderid(int sorderid) {
		this.sorderid = sorderid;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
