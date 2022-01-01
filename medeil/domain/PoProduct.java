package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "medc_poproduct", catalog = "medc_purchase")
public class PoProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poproductid")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer porefid;
	private Integer drugproductrefid;
	private String boxquantity;
	private String stripquantity;
	private String tabletquantity;
	private String totalquantity;
	private String unitprice;
	private String discount;
	private String discountamt;
	private String vat;
	private String vatamt;
	private String gst;
	private String gstamt;
	private String sgst;
	private String sgstamt;
	private String cgst;
	private String cgstamt;
	private String igst;
	private String igstamt;
	private String utgst;
	private String utgstamt;
	private Double totalproductprice;
	private String inwardqty;
	private String deliveredqty;
	private String cancelledqty;
	private String inwardboxqty;
	private String deliveredboxqty;
	private String cancelledboxqty;
	private String inwardstripqty;
	private String deliveredstripqty;
	private String cancelledstripqty;
	private String inwardtabqty;
	private String deliveredtabqty;
	private String cancelledtabqty;
	private String flagid;
	private Integer createdby;
	private String createddate;
	private Integer modifiedby;
	private String modifieddate;
	private String dosageid;
	private Integer indentrefid;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer uom;
	private String equalto;
	private String maxqty;
	private String minleadtime;
	private String consumpminqty;
	private String reorderlvl;

	// add some fields
	private String distprodrank;
	private String pursessionno;
	private Integer pursessionid;
	private Integer piflag;
	private String abc;
	private String stripperbox;
	private String quantityperstrip;
	private String packageunit;

	public String getStripperbox() {
		return stripperbox;
	}

	public void setStripperbox(String stripperbox) {
		this.stripperbox = stripperbox;
	}

	public String getQuantityperstrip() {
		return quantityperstrip;
	}

	public void setQuantityperstrip(String quantityperstrip) {
		this.quantityperstrip = quantityperstrip;
	}

	public Integer getPorefid() {
		return porefid;
	}

	public void setPorefid(Integer porefid) {
		this.porefid = porefid;
	}

	public Integer getDrugproductrefid() {
		return drugproductrefid;
	}

	public void setDrugproductrefid(Integer drugproductrefid) {
		this.drugproductrefid = drugproductrefid;
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

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getVatamt() {
		return vatamt;
	}

	public void setVatamt(String vatamt) {
		this.vatamt = vatamt;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getGstamt() {
		return gstamt;
	}

	public void setGstamt(String gstamt) {
		this.gstamt = gstamt;
	}

	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

	public String getSgstamt() {
		return sgstamt;
	}

	public void setSgstamt(String sgstamt) {
		this.sgstamt = sgstamt;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public String getCgstamt() {
		return cgstamt;
	}

	public void setCgstamt(String cgstamt) {
		this.cgstamt = cgstamt;
	}

	public String getIgst() {
		return igst;
	}

	public void setIgst(String igst) {
		this.igst = igst;
	}

	public String getIgstamt() {
		return igstamt;
	}

	public void setIgstamt(String igstamt) {
		this.igstamt = igstamt;
	}

	public String getUtgst() {
		return utgst;
	}

	public void setUtgst(String utgst) {
		this.utgst = utgst;
	}

	public String getUtgstamt() {
		return utgstamt;
	}

	public void setUtgstamt(String utgstamt) {
		this.utgstamt = utgstamt;
	}

	public Double getTotalproductprice() {
		return totalproductprice;
	}

	public void setTotalproductprice(Double totalproductprice) {
		this.totalproductprice = totalproductprice;
	}

	public String getInwardqty() {
		return inwardqty;
	}

	public void setInwardqty(String inwardqty) {
		this.inwardqty = inwardqty;
	}

	public String getDeliveredqty() {
		return deliveredqty;
	}

	public void setDeliveredqty(String deliveredqty) {
		this.deliveredqty = deliveredqty;
	}

	public String getCancelledqty() {
		return cancelledqty;
	}

	public void setCancelledqty(String cancelledqty) {
		this.cancelledqty = cancelledqty;
	}

	public String getInwardboxqty() {
		return inwardboxqty;
	}

	public void setInwardboxqty(String inwardboxqty) {
		this.inwardboxqty = inwardboxqty;
	}

	public String getDeliveredboxqty() {
		return deliveredboxqty;
	}

	public void setDeliveredboxqty(String deliveredboxqty) {
		this.deliveredboxqty = deliveredboxqty;
	}

	public String getCancelledboxqty() {
		return cancelledboxqty;
	}

	public void setCancelledboxqty(String cancelledboxqty) {
		this.cancelledboxqty = cancelledboxqty;
	}

	public String getInwardstripqty() {
		return inwardstripqty;
	}

	public void setInwardstripqty(String inwardstripqty) {
		this.inwardstripqty = inwardstripqty;
	}

	public String getDeliveredstripqty() {
		return deliveredstripqty;
	}

	public void setDeliveredstripqty(String deliveredstripqty) {
		this.deliveredstripqty = deliveredstripqty;
	}

	public String getCancelledstripqty() {
		return cancelledstripqty;
	}

	public void setCancelledstripqty(String cancelledstripqty) {
		this.cancelledstripqty = cancelledstripqty;
	}

	public String getInwardtabqty() {
		return inwardtabqty;
	}

	public void setInwardtabqty(String inwardtabqty) {
		this.inwardtabqty = inwardtabqty;
	}

	public String getDeliveredtabqty() {
		return deliveredtabqty;
	}

	public void setDeliveredtabqty(String deliveredtabqty) {
		this.deliveredtabqty = deliveredtabqty;
	}

	public String getCancelledtabqty() {
		return cancelledtabqty;
	}

	public void setCancelledtabqty(String cancelledtabqty) {
		this.cancelledtabqty = cancelledtabqty;
	}

	public String getFlagid() {
		return flagid;
	}

	public void setFlagid(String flagid) {
		this.flagid = flagid;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public Integer getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getDosageid() {
		return dosageid;
	}

	public void setDosageid(String dosageid) {
		this.dosageid = dosageid;
	}

	public Integer getIndentrefid() {
		return indentrefid;
	}

	public void setIndentrefid(Integer indentrefid) {
		this.indentrefid = indentrefid;
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

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getUom() {
		return uom;
	}

	public void setUom(Integer uom) {
		this.uom = uom;
	}

	public String getEqualto() {
		return equalto;
	}

	public void setEqualto(String equalto) {
		this.equalto = equalto;
	}

	public String getMaxqty() {
		return maxqty;
	}

	public void setMaxqty(String maxqty) {
		this.maxqty = maxqty;
	}

	public String getMinleadtime() {
		return minleadtime;
	}

	public void setMinleadtime(String minleadtime) {
		this.minleadtime = minleadtime;
	}

	public String getConsumpminqty() {
		return consumpminqty;
	}

	public void setConsumpminqty(String consumpminqty) {
		this.consumpminqty = consumpminqty;
	}

	public String getReorderlvl() {
		return reorderlvl;
	}

	public void setReorderlvl(String reorderlvl) {
		this.reorderlvl = reorderlvl;
	}

	public String getDistprodrank() {
		return distprodrank;
	}

	public void setDistprodrank(String distprodrank) {
		this.distprodrank = distprodrank;
	}

	public String getPursessionno() {
		return pursessionno;
	}

	public void setPursessionno(String pursessionno) {
		this.pursessionno = pursessionno;
	}

	public Integer getPursessionid() {
		return pursessionid;
	}

	public void setPursessionid(Integer pursessionid) {
		this.pursessionid = pursessionid;
	}

	public Integer getPiflag() {
		return piflag;
	}

	public void setPiflag(Integer piflag) {
		this.piflag = piflag;
	}

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}

	public String getPackageunit() {
		return packageunit;
	}

	public void setPackageunit(String packageunit) {
		this.packageunit = packageunit;
	}

}
