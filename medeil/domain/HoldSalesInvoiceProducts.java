package com.medeil.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "medc_holdproducts", catalog = "medc_sales")
public class HoldSalesInvoiceProducts implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "holdprdid")
	private int id;
	private Integer salesrefid;
	private Double drugproductid;
	private String productname;
	private Double mfrrefid;
	private Double formulation;
	private Double batchrefid;
	private Double boxqty;
	private Double stripqty;
	private Double tabletqty;
	private Double totalqty;
	private Double unitprice;
	private Date expirydate;
	private Double mrp;
	private Double unitdiscount;
	private Double unitvat;
	private Double unitgst;
	private Double unitsgst;
	private Double unitcgst;
	private Double unitigst;
	private Double unitutgst;
	private Double vatamt;
	private Double gstamt;
	private Double sgstamt;
	private Double cgstamt;
	private Double igstamt;
	private Double utgstamt;
	private Double subtotal;
	private Double indvqty;
	private Double indvfreeqty;
	private Double discountamt;
	private Double drgtyp;
	private Double gstflag;
	private Double frgstflag;
	private Double freeflag;
	private Double convfactor;
	private Boolean delflag = false;
	private Integer calcflag = 0;
	private String clientcdate;
	private String clientcdate1;
	private Double status = 0.0;
	private Integer perfomaflag = 0;
	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;
	private Double locname;
	private Double locrefid;
	private String batchname;
	private Double stkmainrefid;
	private Integer salesorderrefid;
	private Integer hsnid;
	private String hsncode;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getSalesrefid() {
		return salesrefid;
	}
	public void setSalesrefid(Integer salesrefid) {
		this.salesrefid = salesrefid;
	}
	public Double getMfrrefid() {
		return mfrrefid;
	}
	public void setMfrrefid(Double mfrrefid) {
		this.mfrrefid = mfrrefid;
	}
	public Double getFormulation() {
		return formulation;
	}
	public void setFormulation(Double formulation) {
		this.formulation = formulation;
	}
	public Double getBatchrefid() {
		return batchrefid;
	}
	public void setBatchrefid(Double batchrefid) {
		this.batchrefid = batchrefid;
	}
	public Double getBoxqty() {
		return boxqty;
	}
	public void setBoxqty(Double boxqty) {
		this.boxqty = boxqty;
	}
	public Double getStripqty() {
		return stripqty;
	}
	public void setStripqty(Double stripqty) {
		this.stripqty = stripqty;
	}
	public Double getTabletqty() {
		return tabletqty;
	}
	public void setTabletqty(Double tabletqty) {
		this.tabletqty = tabletqty;
	}
	public Double getTotalqty() {
		return totalqty;
	}
	public void setTotalqty(Double totalqty) {
		this.totalqty = totalqty;
	}
	public Double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public Double getMrp() {
		return mrp;
	}
	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}
	public Double getUnitdiscount() {
		return unitdiscount;
	}
	public void setUnitdiscount(Double unitdiscount) {
		this.unitdiscount = unitdiscount;
	}
	public Double getUnitvat() {
		return unitvat;
	}
	public void setUnitvat(Double unitvat) {
		this.unitvat = unitvat;
	}
	public Double getUnitgst() {
		return unitgst;
	}
	public void setUnitgst(Double unitgst) {
		this.unitgst = unitgst;
	}
	public Double getUnitsgst() {
		return unitsgst;
	}
	public void setUnitsgst(Double unitsgst) {
		this.unitsgst = unitsgst;
	}
	public Double getUnitcgst() {
		return unitcgst;
	}
	public void setUnitcgst(Double unitcgst) {
		this.unitcgst = unitcgst;
	}
	public Double getUnitigst() {
		return unitigst;
	}
	public void setUnitigst(Double unitigst) {
		this.unitigst = unitigst;
	}
	public Double getUnitutgst() {
		return unitutgst;
	}
	public void setUnitutgst(Double unitutgst) {
		this.unitutgst = unitutgst;
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
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Double getIndvqty() {
		return indvqty;
	}
	public void setIndvqty(Double indvqty) {
		this.indvqty = indvqty;
	}
	public Double getIndvfreeqty() {
		return indvfreeqty;
	}
	public void setIndvfreeqty(Double indvfreeqty) {
		this.indvfreeqty = indvfreeqty;
	}
	public Double getDiscountamt() {
		return discountamt;
	}
	public void setDiscountamt(Double discountamt) {
		this.discountamt = discountamt;
	}
	public Double getDrgtyp() {
		return drgtyp;
	}
	public void setDrgtyp(Double drgtyp) {
		this.drgtyp = drgtyp;
	}
	public Double getGstflag() {
		return gstflag;
	}
	public void setGstflag(Double gstflag) {
		this.gstflag = gstflag;
	}
	public Double getFrgstflag() {
		return frgstflag;
	}
	public void setFrgstflag(Double frgstflag) {
		this.frgstflag = frgstflag;
	}
	public Double getFreeflag() {
		return freeflag;
	}
	public void setFreeflag(Double freeflag) {
		this.freeflag = freeflag;
	}
	public Double getConvfactor() {
		return convfactor;
	}
	public void setConvfactor(Double convfactor) {
		this.convfactor = convfactor;
	}
	public Boolean getDelflag() {
		return delflag;
	}
	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
	}
	public Integer getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
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
	public Double getStatus() {
		return status;
	}
	public void setStatus(Double status) {
		this.status = status;
	}
	public Integer getPerfomaflag() {
		return perfomaflag;
	}
	public void setPerfomaflag(Integer perfomaflag) {
		this.perfomaflag = perfomaflag;
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
	public Double getLocname() {
		return locname;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public Double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}
	public Double getStkmainrefid() {
		return stkmainrefid;
	}
	public void setStkmainrefid(Double stkmainrefid) {
		this.stkmainrefid = stkmainrefid;
	}
	public Integer getSalesorderrefid() {
		return salesorderrefid;
	}
	public void setSalesorderrefid(Integer salesorderrefid) {
		this.salesorderrefid = salesorderrefid;
	}
	public Double getDrugproductid() {
		return drugproductid;
	}
	public void setDrugproductid(Double drugproductid) {
		this.drugproductid = drugproductid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getHsnid() {
		return hsnid;
	}
	public void setHsnid(Integer hsnid) {
		this.hsnid = hsnid;
	}
	public String getHsncode() {
		return hsncode;
	}
	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}
	

}
