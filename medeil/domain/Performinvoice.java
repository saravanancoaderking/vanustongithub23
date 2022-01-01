package com.medeil.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "medc_performinvoice", catalog = "medc_sales")


public class Performinvoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salesbillid")
	private int id;
	private String salesbilltype;

	private String salesbillno;
	private Integer salesorderno;
  
	private String billdate;
	private Double customerrefid;
	private Double doctorrefid;
	private Double paymentmode;
	private Double paidamount;
	private Double balanceamount;
	private Double totalamount;
	private Double totalitems;
	private Double totalboxqty;
	private Double totalstripqty;
	private Double totaltabletqty;
	private Double totalqty;
	private Double employeerefid;
	private Double prescriptiondays;
	private Double totaldiscount;
	private Double taxableamt;
	private Double totaltaxamt;
	private Double packingcharge;
	private Double shippingtaxamt;
	private Double educationcess;
	private Double execiseduty;
	private Double vatamt;
	private Double gstamt;
	private Double sgstamt;
	private Double cgstamt;
	private Double igstamt;
	private Double utgstamt;
	private Double totalinclamt;

	private Double totalexclamt;
	private Double adjoperator;
	private Double adjustamt;
	private Double extracharges;
	private Double grandtotal;
	private Double locrefid;
	private Double locname;
	private Boolean delflag = false;
	private String prescpath;
	private String paymenttype;
	private String ptrefno;
	private String clientcdate;
	private String clientcdate1;
	private Integer perfomaflag = 0;
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

	@Transient
	private int refillcust;
	@Transient
	private int billtype;
	private String txnno;
	private double previousbalance;
	private int salestyperefid;

	public int getRefillcust() {
		return refillcust;
	}

	public void setRefillcust(int refillcust) {
		this.refillcust = refillcust;
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

	public Double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}

	public Double getTotalitems() {
		return totalitems;
	}

	public void setTotalitems(Double totalitems) {
		this.totalitems = totalitems;
	}

	public Double getTotalboxqty() {
		return totalboxqty;
	}

	public void setTotalboxqty(Double totalboxqty) {
		this.totalboxqty = totalboxqty;
	}

	public Double getTotalstripqty() {
		return totalstripqty;
	}

	public void setTotalstripqty(Double totalstripqty) {
		this.totalstripqty = totalstripqty;
	}

	public Double getTotaltabletqty() {
		return totaltabletqty;
	}

	public void setTotaltabletqty(Double totaltabletqty) {
		this.totaltabletqty = totaltabletqty;
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

	public Double getPackingcharge() {
		return packingcharge;
	}

	public void setPackingcharge(Double packingcharge) {
		this.packingcharge = packingcharge;
	}

	public Double getShippingtaxamt() {
		return shippingtaxamt;
	}

	public void setShippingtaxamt(Double shippingtaxamt) {
		this.shippingtaxamt = shippingtaxamt;
	}

	public Double getEducationcess() {
		return educationcess;
	}

	public void setEducationcess(Double educationcess) {
		this.educationcess = educationcess;
	}

	public Double getExeciseduty() {
		return execiseduty;
	}

	public void setExeciseduty(Double execiseduty) {
		this.execiseduty = execiseduty;
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

	public Double getTotalinclamt() {
		return totalinclamt;
	}

	public void setTotalinclamt(Double totalinclamt) {
		this.totalinclamt = totalinclamt;
	}

	public Double getTotalexclamt() {
		return totalexclamt;
	}

	public void setTotalexclamt(Double totalexclamt) {
		this.totalexclamt = totalexclamt;
	}

	public Double getAdjoperator() {
		return adjoperator;
	}

	public void setAdjoperator(Double adjoperator) {
		this.adjoperator = adjoperator;
	}

	public Double getAdjustamt() {
		return adjustamt;
	}

	public void setAdjustamt(Double adjustamt) {
		this.adjustamt = adjustamt;
	}

	public Double getExtracharges() {
		return extracharges;
	}

	public void setExtracharges(Double extracharges) {
		this.extracharges = extracharges;
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

	public String getPrescpath() {
		return prescpath;
	}

	public void setPrescpath(String prescpath) {
		this.prescpath = prescpath;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getPtrefno() {
		return ptrefno;
	}

	public void setPtrefno(String ptrefno) {
		this.ptrefno = ptrefno;
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

	public Integer getPerfomaflag() {
		return perfomaflag;
	}

	public void setPerfomaflag(Integer perfomaflag) {
		this.perfomaflag = perfomaflag;
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

	public Integer getSalesorderrefid() {
		return salesorderrefid;
	}

	public void setSalesorderrefid(Integer salesorderrefid) {
		this.salesorderrefid = salesorderrefid;
	}

	public Integer getRefilldays() {
		return refilldays;
	}

	public void setRefilldays(Integer refilldays) {
		this.refilldays = refilldays;
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

	public String getRefilldate() {
		return refilldate;
	}

	public void setRefilldate(String refilldate) {
		this.refilldate = refilldate;
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

	public Integer getSalesorderno() {
		return salesorderno;
	}

	public void setSalesorderno(Integer salesorderno) {
		this.salesorderno = salesorderno;
	}


}
