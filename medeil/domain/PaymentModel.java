package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_payment" ,catalog="medc_payment")
public class PaymentModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentid")
	private int id;
	
	    private String paymentno;
	    private Date paymentdate;
     	private int distid;
	    private String  invoicetype; 
	   private String  invoiceno;   
	   private double   invoiceamt;  
	   private double   invoicebalamt; 
	   private double   debitaccount;   
	   private double   creditaccount;    
	   private double   debitamount;    
	   private double   creditamount;  

    
		
		private  double   locrefid;  
		private  double   locname  ;
    

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



	public int getDistid() {
		return distid;
	}

	public void setDistid(int distid) {
		this.distid = distid;
	}


	



	

	public Date getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public double getInvoiceamt() {
		return invoiceamt;
	}

	public void setInvoiceamt(double invoiceamt) {
		this.invoiceamt = invoiceamt;
	}

	public double getInvoicebalamt() {
		return invoicebalamt;
	}

	public void setInvoicebalamt(double invoicebalamt) {
		this.invoicebalamt = invoicebalamt;
	}

	public double getDebitaccount() {
		return debitaccount;
	}

	public void setDebitaccount(double debitaccount) {
		this.debitaccount = debitaccount;
	}

	public double getCreditaccount() {
		return creditaccount;
	}

	public void setCreditaccount(double creditaccount) {
		this.creditaccount = creditaccount;
	}

	public double getDebitamount() {
		return debitamount;
	}

	public void setDebitamount(double debitamount) {
		this.debitamount = debitamount;
	}

	public double getCreditamount() {
		return creditamount;
	}

	public void setCreditamount(double creditamount) {
		this.creditamount = creditamount;
	}

	public String getInvoicetype() {
		return invoicetype;
	}

	public void setInvoicetype(String invoicetype) {
		this.invoicetype = invoicetype;
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

	
	
	
	
	
	
}
