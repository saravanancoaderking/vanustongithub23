package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medc_prproduct" ,catalog="medc_purchasereturn")
public class PrProducts {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prproductid")
    private int id ;
	
	 private int prrefid  ;
	 private String drugproductid ;
	 private String subtotal; // Boopalan 300419
	 private String mfgname  ;
	 private String batchrefid  ;
	 private  String expdate ;
	 private String purcprice ;


	 private String boxquantity ;
	 private String stripquantity  ;
	 private String tabletquantity  ;
	 private String totalquantity  ;

	 private String unitprice ;
	 private String mrp  ;
	 private String discount ;
	 private String discountamt  ;
	 private String unitvat   ;
	 private String vatamt ;
	 private String unitgst  ;
	 private String gstamt ;
	 private String unitsgst  ;
	 private String sgstamt ;
	 private String unitcgst  ;
	 private String cgstamt ;
	 private String unitigst  ;
	 private String igstamt; 
	 private String unitutgst ;
	 private String utgstamt  ;
	 private String totalproductprice  ;
	 
	 
	 private String     pirefid  ;
	 
	 private String    piqty  ;
	 
		
		private  Double   locrefid;  
		private  Double   locname  ;
	 
		private  Boolean   delflag = false  ;
		
		
		private String clientcdate;
		private String clientcdate1;
		private String   status ;  
		
		private  Integer   calcflag  ;

		
		private  Integer   countryrefid;  
		private  Integer   companyrefid  ;
		private  Integer   branchrefid  ;
		
    	private  String   batchname    ;
    	
    	private String stkmainrefid;
    	private String piprodrefid;
    	private String boxconvstk;
    	private String stripconvstk;
    

		public String getBoxconvstk() {
			return boxconvstk;
		}

		public void setBoxconvstk(String boxconvstk) {
			this.boxconvstk = boxconvstk;
		}

		public String getStripconvstk() {
			return stripconvstk;
		}

		public void setStripconvstk(String stripconvstk) {
			this.stripconvstk = stripconvstk;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getPrrefid() {
			return prrefid;
		}

		public void setPrrefid(int prrefid) {
			this.prrefid = prrefid;
		}

		public String getDrugproductid() {
			return drugproductid;
		}

		public void setDrugproductid(String drugproductid) {
			this.drugproductid = drugproductid;
		}

		public String getMfgname() {
			return mfgname;
		}

		public void setMfgname(String mfgname) {
			this.mfgname = mfgname;
		}

		public String getBatchrefid() {
			return batchrefid;
		}

		public void setBatchrefid(String batchrefid) {
			this.batchrefid = batchrefid;
		}

		public String getExpdate() {
			return expdate;
		}

		public void setExpdate(String expdate) {
			this.expdate = expdate;
		}

		public String getPurcprice() {
			return purcprice;
		}

		public void setPurcprice(String purcprice) {
			this.purcprice = purcprice;
		}

		public String getBoxquantity() {
			return boxquantity;
		}

		public void setBoxquantity(String boxquantity) {
			this.boxquantity = boxquantity;
		}

		public String getStripquantity() {
			return stripquantity;
		}

		public void setStripquantity(String stripquantity) {
			this.stripquantity = stripquantity;
		}

		public String getTabletquantity() {
			return tabletquantity;
		}

		public void setTabletquantity(String tabletquantity) {
			this.tabletquantity = tabletquantity;
		}

		public String getTotalquantity() {
			return totalquantity;
		}

		public void setTotalquantity(String totalquantity) {
			this.totalquantity = totalquantity;
		}

		public String getUnitprice() {
			return unitprice;
		}

		public void setUnitprice(String unitprice) {
			this.unitprice = unitprice;
		}

		public String getMrp() {
			return mrp;
		}

		public void setMrp(String mrp) {
			this.mrp = mrp;
		}

		public String getDiscount() {
			return discount;
		}

		public void setDiscount(String discount) {
			this.discount = discount;
		}

		public String getDiscountamt() {
			return discountamt;
		}

		public void setDiscountamt(String discountamt) {
			this.discountamt = discountamt;
		}

		public String getUnitvat() {
			return unitvat;
		}

		public void setUnitvat(String unitvat) {
			this.unitvat = unitvat;
		}

		public String getVatamt() {
			return vatamt;
		}

		public void setVatamt(String vatamt) {
			this.vatamt = vatamt;
		}

		public String getUnitgst() {
			return unitgst;
		}

		public void setUnitgst(String unitgst) {
			this.unitgst = unitgst;
		}

		public String getGstamt() {
			return gstamt;
		}

		public void setGstamt(String gstamt) {
			this.gstamt = gstamt;
		}

		public String getUnitsgst() {
			return unitsgst;
		}

		public void setUnitsgst(String unitsgst) {
			this.unitsgst = unitsgst;
		}

		public String getSgstamt() {
			return sgstamt;
		}

		public void setSgstamt(String sgstamt) {
			this.sgstamt = sgstamt;
		}

		public String getUnitcgst() {
			return unitcgst;
		}

		public void setUnitcgst(String unitcgst) {
			this.unitcgst = unitcgst;
		}

		public String getCgstamt() {
			return cgstamt;
		}

		public void setCgstamt(String cgstamt) {
			this.cgstamt = cgstamt;
		}

		public String getUnitigst() {
			return unitigst;
		}

		public void setUnitigst(String unitigst) {
			this.unitigst = unitigst;
		}

		public String getIgstamt() {
			return igstamt;
		}

		public void setIgstamt(String igstamt) {
			this.igstamt = igstamt;
		}

		public String getUnitutgst() {
			return unitutgst;
		}

		public void setUnitutgst(String unitutgst) {
			this.unitutgst = unitutgst;
		}

		public String getUtgstamt() {
			return utgstamt;
		}

		public void setUtgstamt(String utgstamt) {
			this.utgstamt = utgstamt;
		}

		public String getTotalproductprice() {
			return totalproductprice;
		}

		public void setTotalproductprice(String totalproductprice) {
			this.totalproductprice = totalproductprice;
		}

		public String getPirefid() {
			return pirefid;
		}

		public void setPirefid(String pirefid) {
			this.pirefid = pirefid;
		}

		public String getPiqty() {
			return piqty;
		}

		public void setPiqty(String piqty) {
			this.piqty = piqty;
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
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

		public String getBatchname() {
			return batchname;
		}

		public void setBatchname(String batchname) {
			this.batchname = batchname;
		}

		public String getStkmainrefid() {
			return stkmainrefid;
		}

		public void setStkmainrefid(String stkmainrefid) {
			this.stkmainrefid = stkmainrefid;
		}

		public String getPiprodrefid() {
			return piprodrefid;
		}

		public void setPiprodrefid(String piprodrefid) {
			this.piprodrefid = piprodrefid;
		}

		public String getSubtotal() {
			return subtotal;
		}

		public void setSubtotal(String subtotal) {
			this.subtotal = subtotal;
		}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
		

}
