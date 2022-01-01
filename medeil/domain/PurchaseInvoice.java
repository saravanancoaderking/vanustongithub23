/**
 * 
 */
package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author AJITH AK
 *
 */
@Entity
@Table(name = "medc_piproduct", catalog = "medc_purchase")
public class PurchaseInvoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "piproductid")
	private Integer id;
	private Integer pirefid;
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
	private String totalproductprice;
	private String inwardqty;
	private String deliveredqty;
	private String cancelledqty;
	private String damagedqty;
	private String pendingqty;
	private String inwardboxqty;
	private String deliveredboxqty;
	private String cancelledboxqty;
	private String damagedboxqty;
	private String pendingboxqty;
	private String inwardstripqty;
	private String deliveredstripqty;
	private String cancelledstripqty;
	private String damagedstripqty;
	private String pendingstripqty;
	private String inwardtabqty;
	private String deliveredtabqty;
	private String cancelledtabqty;
	private String damagedtabqty;
	private String pendingtabqty;
	private String flagid;
	private Integer createdby;
	private String createddate;
	private Integer modifiedby;
	private String modifieddate;
	private String mfgname;
	private Integer batchno;
	private String dosageid;
	private String purprice;
	private String salesdiscount;
	private String profitmargin;
	private Integer formulationid;
	private String freeboxqty;
	private String freestripqty;
	private String freetabletqty;
	private String freetotalqty;
	private String mrp;
	private String expirydate;
	private String invoicedate;
	private String clientcdate;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer dcrefid;
	private Integer paflag;
	@Transient
	private String batchid;
	@Transient
	private Integer hsnid;
	@Transient
	private Double hsngst;
	private String stripperbox;
	private String quantityperstrip;
	private String packageunit;
	private String sellingprice;
	private Integer prflag;
	

	public String getPackageunit() {
		return packageunit;
	}

	public void setPackageunit(String packageunit) {
		this.packageunit = packageunit;
	}

	public String getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(String sellingprice) {
		this.sellingprice = sellingprice;
	}

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

	public Double getHsngst() {
		return hsngst;
	}

	public void setHsngst(Double hsngst) {
		this.hsngst = hsngst;
	}

	public Integer getHsnid() {
		return hsnid;
	}

	public void setHsnid(Integer hsnid) {
		this.hsnid = hsnid;
	}

	public String getBatchid() {
		return batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	/** Only For Update Invoive **/
	@Transient
	private Integer piproductids;
	@Transient
	private Integer pirefids;
	@Transient
	private Integer refpoid;
	@Transient
	private Integer puapprovalst;

	
	
	//barcode qrcode properties
	private Integer barcodewidth;//Puthiran
	
	private Integer barcodeheight;//Puthiran
	
	private String barcodelabel;//Puthiran
	
	private Integer qrcodewidth;//Puthiran
	
	private Integer qrcodeheight;//Puthiran
	
	private String qrcodelabel;//Puthiran
	
	private byte[] barcodeimage;
	
	private byte[] qrcodeimage;
	public Integer getPirefid() {
		return pirefid;
	}

	public void setPirefid(Integer pirefid) {
		this.pirefid = pirefid;
	}

	public Integer getDrugproductrefid() {
		return drugproductrefid;
	}

	public void setDrugproductrefid(Integer drugproductrefid) {
		this.drugproductrefid = drugproductrefid;
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

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getTotalproductprice() {
		return totalproductprice;
	}

	public void setTotalproductprice(String totalproductprice) {
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

	public String getDamagedqty() {
		return damagedqty;
	}

	public void setDamagedqty(String damagedqty) {
		this.damagedqty = damagedqty;
	}

	public String getPendingqty() {
		return pendingqty;
	}

	public void setPendingqty(String pendingqty) {
		this.pendingqty = pendingqty;
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

	public String getDamagedboxqty() {
		return damagedboxqty;
	}

	public void setDamagedboxqty(String damagedboxqty) {
		this.damagedboxqty = damagedboxqty;
	}

	public String getPendingboxqty() {
		return pendingboxqty;
	}

	public void setPendingboxqty(String pendingboxqty) {
		this.pendingboxqty = pendingboxqty;
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

	public String getDamagedstripqty() {
		return damagedstripqty;
	}

	public void setDamagedstripqty(String damagedstripqty) {
		this.damagedstripqty = damagedstripqty;
	}

	public String getPendingstripqty() {
		return pendingstripqty;
	}

	public void setPendingstripqty(String pendingstripqty) {
		this.pendingstripqty = pendingstripqty;
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

	public String getDamagedtabqty() {
		return damagedtabqty;
	}

	public void setDamagedtabqty(String damagedtabqty) {
		this.damagedtabqty = damagedtabqty;
	}

	public String getPendingtabqty() {
		return pendingtabqty;
	}

	public void setPendingtabqty(String pendingtabqty) {
		this.pendingtabqty = pendingtabqty;
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

	public String getMfgname() {
		return mfgname;
	}

	public void setMfgname(String mfgname) {
		this.mfgname = mfgname;
	}

	public Integer getBatchno() {
		return batchno;
	}

	public void setBatchno(Integer batchno) {
		this.batchno = batchno;
	}

	public String getDosageid() {
		return dosageid;
	}

	public void setDosageid(String dosageid) {
		this.dosageid = dosageid;
	}

	public String getPurprice() {
		return purprice;
	}

	public void setPurprice(String purprice) {
		this.purprice = purprice;
	}

	public String getSalesdiscount() {
		return salesdiscount;
	}

	public void setSalesdiscount(String salesdiscount) {
		this.salesdiscount = salesdiscount;
	}

	public String getProfitmargin() {
		return profitmargin;
	}

	public void setProfitmargin(String profitmargin) {
		this.profitmargin = profitmargin;
	}

	public Integer getFormulationid() {
		return formulationid;
	}

	public void setFormulationid(Integer formulationid) {
		this.formulationid = formulationid;
	}

	public String getFreetotalqty() {
		return freetotalqty;
	}

	public void setFreetotalqty(String freetotalqty) {
		this.freetotalqty = freetotalqty;
	}

	public String getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}

	public Integer getDcrefid() {
		return dcrefid;
	}

	public void setDcrefid(Integer dcrefid) {
		this.dcrefid = dcrefid;
	}

	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getFreeboxqty() {
		return freeboxqty;
	}

	public void setFreeboxqty(String freeboxqty) {
		this.freeboxqty = freeboxqty;
	}

	public String getFreestripqty() {
		return freestripqty;
	}

	public void setFreestripqty(String freestripqty) {
		this.freestripqty = freestripqty;
	}

	public String getFreetabletqty() {
		return freetabletqty;
	}

	public void setFreetabletqty(String freetabletqty) {
		this.freetabletqty = freetabletqty;
	}


	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}


	public String getMrp() {
		return mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}



	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}


	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}


	public String getGstamt() {
		return gstamt;
	}

	public void setGstamt(String gstamt) {
		this.gstamt = gstamt;
	}

	public String getVatamt() {
		return vatamt;
	}

	public void setVatamt(String vatamt) {
		this.vatamt = vatamt;
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

	public String getIgst() {
		return igst;
	}

	public void setIgst(String igst) {
		this.igst = igst;
	}

	public Integer getPiproductids() {
		return piproductids;
	}

	public void setPiproductids(Integer piproductids) {
		this.piproductids = piproductids;
	}

	public Integer getPirefids() {
		return pirefids;
	}

	public void setPirefids(Integer pirefids) {
		this.pirefids = pirefids;
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

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getRefpoid() {
		return refpoid;
	}

	public void setRefpoid(Integer refpoid) {
		this.refpoid = refpoid;
	}

	public Integer getPuapprovalst() {
		return puapprovalst;
	}

	public void setPuapprovalst(Integer puapprovalst) {
		this.puapprovalst = puapprovalst;
	}

	/**
	 * @return the barcodewidth
	 */
	public Integer getBarcodewidth() {
		return barcodewidth;
	}

	/**
	 * @param barcodewidth the barcodewidth to set
	 */
	public void setBarcodewidth(Integer barcodewidth) {
		this.barcodewidth = barcodewidth;
	}

	/**
	 * @return the barcodeheight
	 */
	public Integer getBarcodeheight() {
		return barcodeheight;
	}

	/**
	 * @param barcodeheight the barcodeheight to set
	 */
	public void setBarcodeheight(Integer barcodeheight) {
		this.barcodeheight = barcodeheight;
	}

	/**
	 * @return the barcodelabel
	 */
	public String getBarcodelabel() {
		return barcodelabel;
	}

	/**
	 * @param barcodelabel the barcodelabel to set
	 */
	public void setBarcodelabel(String barcodelabel) {
		this.barcodelabel = barcodelabel;
	}

	/**
	 * @return the qrcodewidth
	 */
	public Integer getQrcodewidth() {
		return qrcodewidth;
	}

	/**
	 * @param qrcodewidth the qrcodewidth to set
	 */
	public void setQrcodewidth(Integer qrcodewidth) {
		this.qrcodewidth = qrcodewidth;
	}

	/**
	 * @return the qrcodeheight
	 */
	public Integer getQrcodeheight() {
		return qrcodeheight;
	}

	/**
	 * @param qrcodeheight the qrcodeheight to set
	 */
	public void setQrcodeheight(Integer qrcodeheight) {
		this.qrcodeheight = qrcodeheight;
	}

	/**
	 * @return the qrcodelabel
	 */
	public String getQrcodelabel() {
		return qrcodelabel;
	}

	/**
	 * @param qrcodelabel the qrcodelabel to set
	 */
	public void setQrcodelabel(String qrcodelabel) {
		this.qrcodelabel = qrcodelabel;
	}

	/**
	 * @return the barcodeimage
	 */
	public byte[] getBarcodeimage() {
		return barcodeimage;
	}

	/**
	 * @param barcodeimage the barcodeimage to set
	 */
	public void setBarcodeimage(byte[] barcodeimage) {
		this.barcodeimage = barcodeimage;
	}

	/**
	 * @return the qrcodeimage
	 */
	public byte[] getQrcodeimage() {
		return qrcodeimage;
	}

	/**
	 * @param qrcodeimage the qrcodeimage to set
	 */
	public void setQrcodeimage(byte[] qrcodeimage) {
		this.qrcodeimage = qrcodeimage;
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

	public Integer getPaflag() {
		return paflag;
	}

	public void setPaflag(Integer paflag) {
		this.paflag = paflag;
	}

	public Integer getPrflag() {
		return prflag;
	}

	public void setPrflag(Integer prflag) {
		this.prflag = prflag;
	}

}
