package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_priceenquiry", catalog = "medc_purchase")
public class PriceEnquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prcencproid")
	private int id;

	private Double prcencid;
	private Double purchsessionid;

	private Double drugproductrefid;

	private Double prodwaitingqty;
	private Double vendorid;

	private Double locrefid;
	private Double locname;

	private String prcencno;

	private String clientcdate;	
	private String clientcdate1;

	private  Integer   calcflag  ;
	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	
	private  Boolean   priceupdateflag = false  ;
	
	
	 private  Double   creditdays;  
	   	private  Double   leadtime  ;
	    private  Double   exppoqty;  
	   	private  Double   exppoprice  ;
	   	
	    private  Double   indreqqty;  
	   	private  Double   stktransapprqty  ;
		private  Double   stktransrejqty  ;
	   	
		private  Boolean   delflag=false  ;
		
		private  Double   distfinalprice  ;
		
		private String remarks;
		
		private String distremarks;
		
		private Double previouspoprice;
		
	    private String abc;
		
		private Double distprodrank;
		private String clientmdate;	//padmini

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Double getPrcencid() {
			return prcencid;
		}

		public void setPrcencid(Double prcencid) {
			this.prcencid = prcencid;
		}

		public Double getPurchsessionid() {
			return purchsessionid;
		}

		public void setPurchsessionid(Double purchsessionid) {
			this.purchsessionid = purchsessionid;
		}

		public Double getDrugproductrefid() {
			return drugproductrefid;
		}

		public void setDrugproductrefid(Double drugproductrefid) {
			this.drugproductrefid = drugproductrefid;
		}

		public Double getProdwaitingqty() {
			return prodwaitingqty;
		}

		public void setProdwaitingqty(Double prodwaitingqty) {
			this.prodwaitingqty = prodwaitingqty;
		}

		public Double getVendorid() {
			return vendorid;
		}

		public void setVendorid(Double vendorid) {
			this.vendorid = vendorid;
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

		public String getPrcencno() {
			return prcencno;
		}

		public void setPrcencno(String prcencno) {
			this.prcencno = prcencno;
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

		public Integer getCalcflag() {
			return calcflag;
		}

		public void setCalcflag(Integer calcflag) {
			this.calcflag = calcflag;
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

		public Boolean getPriceupdateflag() {
			return priceupdateflag;
		}

		public void setPriceupdateflag(Boolean priceupdateflag) {
			this.priceupdateflag = priceupdateflag;
		}

		public Double getCreditdays() {
			return creditdays;
		}

		public void setCreditdays(Double creditdays) {
			this.creditdays = creditdays;
		}

		public Double getLeadtime() {
			return leadtime;
		}

		public void setLeadtime(Double leadtime) {
			this.leadtime = leadtime;
		}

		public Double getExppoqty() {
			return exppoqty;
		}

		public void setExppoqty(Double exppoqty) {
			this.exppoqty = exppoqty;
		}

		public Double getExppoprice() {
			return exppoprice;
		}

		public void setExppoprice(Double exppoprice) {
			this.exppoprice = exppoprice;
		}

		public Double getIndreqqty() {
			return indreqqty;
		}

		public void setIndreqqty(Double indreqqty) {
			this.indreqqty = indreqqty;
		}

		public Double getStktransapprqty() {
			return stktransapprqty;
		}

		public void setStktransapprqty(Double stktransapprqty) {
			this.stktransapprqty = stktransapprqty;
		}

		public Double getStktransrejqty() {
			return stktransrejqty;
		}

		public void setStktransrejqty(Double stktransrejqty) {
			this.stktransrejqty = stktransrejqty;
		}

		public Boolean getDelflag() {
			return delflag;
		}

		public void setDelflag(Boolean delflag) {
			this.delflag = delflag;
		}

		public Double getDistfinalprice() {
			return distfinalprice;
		}

		public void setDistfinalprice(Double distfinalprice) {
			this.distfinalprice = distfinalprice;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public String getDistremarks() {
			return distremarks;
		}

		public void setDistremarks(String distremarks) {
			this.distremarks = distremarks;
		}

		public Double getPreviouspoprice() {
			return previouspoprice;
		}

		public void setPreviouspoprice(Double previouspoprice) {
			this.previouspoprice = previouspoprice;
		}

		public String getAbc() {
			return abc;
		}

		public void setAbc(String abc) {
			this.abc = abc;
		}

		public Double getDistprodrank() {
			return distprodrank;
		}

		public void setDistprodrank(Double distprodrank) {
			this.distprodrank = distprodrank;
		}

		public String getClientmdate() {
			return clientmdate;
		}

		public void setClientmdate(String clientmdate) {
			this.clientmdate = clientmdate;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
