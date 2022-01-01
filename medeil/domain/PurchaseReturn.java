
package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_dirpurchasereturn", catalog = "medc_purchasereturn")
public class PurchaseReturn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prid")
	private int id;

	private String invoiceno;
	private Date invoicedate;
	private Integer vendorid;
	private String parcelno;
	private String parceldetails;
	private Integer purchasetype;
	private String totalqty;
	private String totalboxqty;
	private String totalstripqty;
	private String totaltabqty;
	private String totaldiscountamt;
	private String totaltaxamt;
	private String totaltaxableamt;
	private String extratax;
	private String gstamt;
	private String sgstamt;
	private String cgstamt;
	private String igstamt;
	private String utgstamt;
	private String totalincamt;
	private String totalexclamt;
	private String grandtotal;
	private String paidamount;
	private String balanceamount;
	private String adjustmentoperator;
	private String adjustmentamount;

	private Double locrefid;
	private Double locname;

	private String prno;
	private String prdate;
	private Boolean delflag = false;

	private String clientcdate;
	private String clientcdate1;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;
	private String totalsubtotal;
	private String roundedoff;
	private String cashdiscount;
	private Integer cashdiscountpercent;
	private String totalitems;
	
	public String getCashdiscount() {
		return cashdiscount;
	}

	public void setCashdiscount(String cashdiscount) {
		this.cashdiscount = cashdiscount;
	}

	public Integer getCashdiscountpercent() {
		return cashdiscountpercent;
	}

	public void setCashdiscountpercent(Integer cashdiscountpercent) {
		this.cashdiscountpercent = cashdiscountpercent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public Date getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(Date invoicedate) {
		this.invoicedate = invoicedate;
	}

	public Integer getVendorid() {
		return vendorid;
	}

	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}

	public String getParcelno() {
		return parcelno;
	}

	public void setParcelno(String parcelno) {
		this.parcelno = parcelno;
	}

	public String getParceldetails() {
		return parceldetails;
	}

	public void setParceldetails(String parceldetails) {
		this.parceldetails = parceldetails;
	}

	public Integer getPurchasetype() {
		return purchasetype;
	}

	public void setPurchasetype(Integer purchasetype) {
		this.purchasetype = purchasetype;
	}

	public String getTotalqty() {
		return totalqty;
	}

	public void setTotalqty(String totalqty) {
		this.totalqty = totalqty;
	}

	public String getTotalboxqty() {
		return totalboxqty;
	}

	public void setTotalboxqty(String totalboxqty) {
		this.totalboxqty = totalboxqty;
	}

	public String getTotalstripqty() {
		return totalstripqty;
	}

	public void setTotalstripqty(String totalstripqty) {
		this.totalstripqty = totalstripqty;
	}

	public String getTotaltabqty() {
		return totaltabqty;
	}

	public void setTotaltabqty(String totaltabqty) {
		this.totaltabqty = totaltabqty;
	}

	public String getTotaldiscountamt() {
		return totaldiscountamt;
	}

	public void setTotaldiscountamt(String totaldiscountamt) {
		this.totaldiscountamt = totaldiscountamt;
	}

	public String getTotaltaxamt() {
		return totaltaxamt;
	}

	public void setTotaltaxamt(String totaltaxamt) {
		this.totaltaxamt = totaltaxamt;
	}

	public String getTotaltaxableamt() {
		return totaltaxableamt;
	}

	public void setTotaltaxableamt(String totaltaxableamt) {
		this.totaltaxableamt = totaltaxableamt;
	}

	public String getExtratax() {
		return extratax;
	}

	public void setExtratax(String extratax) {
		this.extratax = extratax;
	}

	public String getGstamt() {
		return gstamt;
	}

	public void setGstamt(String gstamt) {
		this.gstamt = gstamt;
	}

	public String getSgstamt() {
		return sgstamt;
	}

	public void setSgstamt(String sgstamt) {
		this.sgstamt = sgstamt;
	}

	public String getCgstamt() {
		return cgstamt;
	}

	public void setCgstamt(String cgstamt) {
		this.cgstamt = cgstamt;
	}

	public String getIgstamt() {
		return igstamt;
	}

	public void setIgstamt(String igstamt) {
		this.igstamt = igstamt;
	}

	public String getUtgstamt() {
		return utgstamt;
	}

	public void setUtgstamt(String utgstamt) {
		this.utgstamt = utgstamt;
	}

	public String getTotalincamt() {
		return totalincamt;
	}

	public void setTotalincamt(String totalincamt) {
		this.totalincamt = totalincamt;
	}

	public String getTotalexclamt() {
		return totalexclamt;
	}

	public void setTotalexclamt(String totalexclamt) {
		this.totalexclamt = totalexclamt;
	}

	public String getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(String grandtotal) {
		this.grandtotal = grandtotal;
	}

	public String getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(String paidamount) {
		this.paidamount = paidamount;
	}

	public String getBalanceamount() {
		return balanceamount;
	}

	public void setBalanceamount(String balanceamount) {
		this.balanceamount = balanceamount;
	}

	public String getAdjustmentoperator() {
		return adjustmentoperator;
	}

	public void setAdjustmentoperator(String adjustmentoperator) {
		this.adjustmentoperator = adjustmentoperator;
	}

	public String getAdjustmentamount() {
		return adjustmentamount;
	}

	public void setAdjustmentamount(String adjustmentamount) {
		this.adjustmentamount = adjustmentamount;
	}

	public Double getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}

	public Double getLocname() {
		return locname;
	}

	public void setLocname(Double locname) {
		this.locname = locname;
	}

	public String getPrno() {
		return prno;
	}

	public void setPrno(String prno) {
		this.prno = prno;
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

	public String getPrdate() {
		return prdate;
	}

	public void setPrdate(String prdate) {
		this.prdate = prdate;
	}

	public String getTotalsubtotal() {
		return totalsubtotal;
	}

	public void setTotalsubtotal(String totalsubtotal) {
		this.totalsubtotal = totalsubtotal;
	}

	public String getRoundedoff() {
		return roundedoff;
	}

	public void setRoundedoff(String roundedoff) {
		this.roundedoff = roundedoff;
	}

	public String getTotalitems() {
		return totalitems;
	}

	public void setTotalitems(String totalitems) {
		this.totalitems = totalitems;
	}

}
