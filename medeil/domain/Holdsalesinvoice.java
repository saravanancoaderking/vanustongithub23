package com.medeil.domain;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "medc_holdsalesbill", catalog = "medc_sales")
public class Holdsalesinvoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "holdbillid")
	private int id;
	private String salesbilltype;
	private String salesbillno;
	private String billdate;
	private Double customerrefid;
	private Double doctorrefid;
	private Double paymentmode;
	private Double paidamount;
	private Double balanceamount;
	private Double totalitems;
	private Double totalqty;
	private Double employeerefid;
	private Double prescriptiondays;
	private Double totaldiscount;
	private Double taxableamt;
	private Double totaltaxamt;
	private Double vatamt;
	private Double gstamt;
	private Double sgstamt;
	private Double cgstamt;
	private Double igstamt;
	private Double utgstamt;
	private Double grandtotal;
	private Double locrefid;
	private Double locname;
	private Boolean delflag = false;
	private String paymenttype;
	private String clientcdate;
	private String clientcdate1;
	private Double cashamt;
	private Double cardamt;
	private Double paidamt;
	private String custinvoiceno;
	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;
	private Double creditcardamt;
	private Double debitcardamt;
	private Integer salesorderrefid;
	private int phycapflag;
	private int scitizenflag;
	private Integer refilldays;
	private String refilldate;
	private String roundoff;
	
	//@Transient
	private int refillcust;
	@Transient
	private int billtype;
	private String txnno;
	private double previousbalance;
	private int salestyperefid;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSalesbilltype() {
		return salesbilltype;
	}
	public void setSalesbilltype(String salesbilltype) {
		this.salesbilltype = salesbilltype;
	}
	public String getSalesbillno() {
		return salesbillno;
	}
	public void setSalesbillno(String salesbillno) {
		this.salesbillno = salesbillno;
	}
	public String getBilldate() {
		return billdate;
	}
	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}
	public Double getCustomerrefid() {
		return customerrefid;
	}
	public void setCustomerrefid(Double customerrefid) {
		this.customerrefid = customerrefid;
	}
	public Double getDoctorrefid() {
		return doctorrefid;
	}
	public void setDoctorrefid(Double doctorrefid) {
		this.doctorrefid = doctorrefid;
	}
	public Double getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(Double paymentmode) {
		this.paymentmode = paymentmode;
	}
	public Double getPaidamount() {
		return paidamount;
	}
	public void setPaidamount(Double paidamount) {
		this.paidamount = paidamount;
	}
	public Double getBalanceamount() {
		return balanceamount;
	}
	public void setBalanceamount(Double balanceamount) {
		this.balanceamount = balanceamount;
	}
	public Double getTotalitems() {
		return totalitems;
	}
	public void setTotalitems(Double totalitems) {
		this.totalitems = totalitems;
	}
	public Double getTotalqty() {
		return totalqty;
	}
	public void setTotalqty(Double totalqty) {
		this.totalqty = totalqty;
	}
	public Double getEmployeerefid() {
		return employeerefid;
	}
	public void setEmployeerefid(Double employeerefid) {
		this.employeerefid = employeerefid;
	}
	public Double getPrescriptiondays() {
		return prescriptiondays;
	}
	public void setPrescriptiondays(Double prescriptiondays) {
		this.prescriptiondays = prescriptiondays;
	}
	public Double getTotaldiscount() {
		return totaldiscount;
	}
	public void setTotaldiscount(Double totaldiscount) {
		this.totaldiscount = totaldiscount;
	}
	public Double getTaxableamt() {
		return taxableamt;
	}
	public void setTaxableamt(Double taxableamt) {
		this.taxableamt = taxableamt;
	}
	public Double getTotaltaxamt() {
		return totaltaxamt;
	}
	public void setTotaltaxamt(Double totaltaxamt) {
		this.totaltaxamt = totaltaxamt;
	}
	public Double getVatamt() {
		return vatamt;
	}
	public void setVatamt(Double vatamt) {
		this.vatamt = vatamt;
	}
	public Double getGstamt() {
		return gstamt;
	}
	public void setGstamt(Double gstamt) {
		this.gstamt = gstamt;
	}
	public Double getSgstamt() {
		return sgstamt;
	}
	public void setSgstamt(Double sgstamt) {
		this.sgstamt = sgstamt;
	}
	public Double getCgstamt() {
		return cgstamt;
	}
	public void setCgstamt(Double cgstamt) {
		this.cgstamt = cgstamt;
	}
	public Double getIgstamt() {
		return igstamt;
	}
	public void setIgstamt(Double igstamt) {
		this.igstamt = igstamt;
	}
	public Double getUtgstamt() {
		return utgstamt;
	}
	public void setUtgstamt(Double utgstamt) {
		this.utgstamt = utgstamt;
	}
	
	public Double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(Double grandtotal) {
		this.grandtotal = grandtotal;
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
	public Boolean getDelflag() {
		return delflag;
	}
	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
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
	public Double getCashamt() {
		return cashamt;
	}
	public void setCashamt(Double cashamt) {
		this.cashamt = cashamt;
	}
	public Double getCardamt() {
		return cardamt;
	}
	public void setCardamt(Double cardamt) {
		this.cardamt = cardamt;
	}
	public Double getPaidamt() {
		return paidamt;
	}
	public void setPaidamt(Double paidamt) {
		this.paidamt = paidamt;
	}
	public String getCustinvoiceno() {
		return custinvoiceno;
	}
	public void setCustinvoiceno(String custinvoiceno) {
		this.custinvoiceno = custinvoiceno;
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
	public Double getCreditcardamt() {
		return creditcardamt;
	}
	public void setCreditcardamt(Double creditcardamt) {
		this.creditcardamt = creditcardamt;
	}
	public Double getDebitcardamt() {
		return debitcardamt;
	}
	public void setDebitcardamt(Double debitcardamt) {
		this.debitcardamt = debitcardamt;
	}
	public Integer getSalesorderrefid() {
		return salesorderrefid;
	}
	public void setSalesorderrefid(Integer salesorderrefid) {
		this.salesorderrefid = salesorderrefid;
	}
	public int getPhycapflag() {
		return phycapflag;
	}
	public void setPhycapflag(int phycapflag) {
		this.phycapflag = phycapflag;
	}
	public int getScitizenflag() {
		return scitizenflag;
	}
	public void setScitizenflag(int scitizenflag) {
		this.scitizenflag = scitizenflag;
	}
	public Integer getRefilldays() {
		return refilldays;
	}
	public void setRefilldays(Integer refilldays) {
		this.refilldays = refilldays;
	}
	public String getRefilldate() {
		return refilldate;
	}
	public void setRefilldate(String refilldate) {
		this.refilldate = refilldate;
	}
	public int getRefillcust() {
		return refillcust;
	}
	public void setRefillcust(int refillcust) {
		this.refillcust = refillcust;
	}
	public int getBilltype() {
		return billtype;
	}
	public void setBilltype(int billtype) {
		this.billtype = billtype;
	}
	public String getTxnno() {
		return txnno;
	}
	public void setTxnno(String txnno) {
		this.txnno = txnno;
	}
	public double getPreviousbalance() {
		return previousbalance;
	}
	public void setPreviousbalance(double previousbalance) {
		this.previousbalance = previousbalance;
	}
	public int getSalestyperefid() {
		return salestyperefid;
	}
	public void setSalestyperefid(int salestyperefid) {
		this.salestyperefid = salestyperefid;
	}
	public String getRoundoff() {
		return roundoff;
	}
	public void setRoundoff(String roundoff) {
		this.roundoff = roundoff;
	}
	
}
