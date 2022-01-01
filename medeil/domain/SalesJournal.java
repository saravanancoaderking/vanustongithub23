package com.medeil.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_sales", catalog = "medc_accounts")
public class SalesJournal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salesid")
	private int id;

	private String salesno;

	private Integer personid;
	private Integer persontype;
	private String jrnlname;
	private Double invoicetype;
	private Integer invoiceno;
	private Double invoiceamt;
	private Double invoicebalamt;
	private Double debitaccount;
	private Double creditaccount;
	private Double debitamount;
	private Double creditamount;

	private Double locrefid;
	private Double locname;
	

	private String draccname;
	private String craccname;
	

	private  Boolean   delflag = false  ;
	
	private String clientcdate;
	private String clientcdate1;
	
	
	private  String   paymenttype;  
	private  String   ptrefno ;  
	
	private Integer salesflag ;
	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalesno() {
		return salesno;
	}

	public void setSalesno(String salesno) {
		this.salesno = salesno;
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

	public String getDraccname() {
		return draccname;
	}

	public void setDraccname(String draccname) {
		this.draccname = draccname;
	}

	public String getCraccname() {
		return craccname;
	}

	public void setCraccname(String craccname) {
		this.craccname = craccname;
	}

	public Integer getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(Integer invoiceno) {
		this.invoiceno = invoiceno;
	}

	public Boolean getDelflag() {
		return delflag;
	}

	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
	}

	public Integer getPersonid() {
		return personid;
	}

	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	public Integer getPersontype() {
		return persontype;
	}

	public void setPersontype(Integer persontype) {
		this.persontype = persontype;
	}

	public String getJrnlname() {
		return jrnlname;
	}

	public void setJrnlname(String jrnlname) {
		this.jrnlname = jrnlname;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Double getInvoicetype() {
		return invoicetype;
	}

	public void setInvoicetype(Double invoicetype) {
		this.invoicetype = invoicetype;
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

	public String getClientcdate1() {
		return clientcdate1;
	}

	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}

	public Integer getSalesflag() {
		return salesflag;
	}

	public void setSalesflag(Integer salesflag) {
		this.salesflag = salesflag;
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
	
	
	

	
	
}
