package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_payment", catalog = "medc_accounts")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentid")
	private int id;

	private String paymentno;
	private Date paymentdate;
	private int distid;
	private String invoicetype;
	private String invoiceno;
	private Double invoiceamt;
	private Double invoicebalamt;
	private Double debitaccount;
	private Double creditaccount;
	private Double debitamount;
	private Double creditamount;

	private Double locrefid;
	private Double locname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentno() {
		return paymentno;
	}
	public void setPaymentno(String paymentno) {
		this.paymentno = paymentno;
	}
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}
	public int getDistid() {
		return distid;
	}
	public void setDistid(int distid) {
		this.distid = distid;
	}
	public String getInvoicetype() {
		return invoicetype;
	}
	public void setInvoicetype(String invoicetype) {
		this.invoicetype = invoicetype;
	}
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	public Double getInvoiceamt() {
		return invoiceamt;
	}
	public void setInvoiceamt(Double invoiceamt) {
		this.invoiceamt = invoiceamt;
	}
	public Double getInvoicebalamt() {
		return invoicebalamt;
	}
	public void setInvoicebalamt(Double invoicebalamt) {
		this.invoicebalamt = invoicebalamt;
	}
	public Double getDebitaccount() {
		return debitaccount;
	}
	public void setDebitaccount(Double debitaccount) {
		this.debitaccount = debitaccount;
	}
	public Double getCreditaccount() {
		return creditaccount;
	}
	public void setCreditaccount(Double creditaccount) {
		this.creditaccount = creditaccount;
	}
	public Double getDebitamount() {
		return debitamount;
	}
	public void setDebitamount(Double debitamount) {
		this.debitamount = debitamount;
	}
	public Double getCreditamount() {
		return creditamount;
	}
	public void setCreditamount(Double creditamount) {
		this.creditamount = creditamount;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
