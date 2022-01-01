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

/**
 * @author Ajith
 *
 */
@Entity
@Table(name = "medc_purchaseinvoice", catalog = "medc_purchase")
public class Purchase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "piid")
	private Integer id;
	private String pino;
	private String pidate;
	private Integer refpoid;
	private Integer refgrid;
	private Integer vendorid;
	private String vendorinvoiceno;
	private Integer taxtype;
	private String itemamt;
	private String totalproduct;
	private String totaldiscount;
	private String taxableamt;
	private String totaltaxamt;
	private String packingcharge;
	private String servicecharge;
	private String shippingtax;
	private String shippingtaxamt;
	private String educationcess;
	private String execiseduty;
	private String pretaxtotal;
	private String vatamt;
	private String gstamt;
	private String cgstamt;
	private String sgstamt;
	private String igstamt;
	private String utgstamt;
	private String totalinctaxamt;
	private String totalexctaxamt;
	private String adjoperator;
	private String adjustamt;
	private String grandtotal;
	private Integer tcid;
	private Integer initialapproval;
	private Integer finalapproval;
	private Integer rejectid;
	private Integer pistatus;
	private Integer taskstatus;
	private String paymentstatus;
	private Integer accountby;
	private Integer createdby;
	private String createddate;
	private String clientcdate;
	private String clientmdate;
	private Integer status;
	private Integer modifiedby;
	private String modifieddate;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private String deliverytype;
	private String totalboxquantiy;
	private String totalstripquantity;
	private String totaltabletquantity;
	private String totalquantity;
	private String invoicetype;
	private String roundoff;
	private String cashdiscount;
	private String totalmargin;
	private String totalfreeboxqty;
	private String totalfreestripqty;
	private String totalfreetabletqty;
	private String totalfreeqty;
	private Integer dcrefid;
	private Integer puapprovalst;
	private Integer cashdiscountpercent;
	
	//barcode qrcode properties
	private Integer barcodewidth;//Puthiran
	
	private Integer barcodeheight;//Puthiran
	
	private String barcodelabel;//Puthiran
	
	private Integer qrcodewidth;//Puthiran
	
	private Integer qrcodeheight;//Puthiran
	
	private String qrcodelabel;//Puthiran
	
	private Integer barcodeposition;//Puthiran
	
	private Integer qrcodeposition;//Puthiran
	
	private byte[] barcodeimage;
	
	private byte[] qrcodeimage;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPino() {
		return pino;
	}

	public void setPino(String pino) {
		this.pino = pino;
	}

	public String getPidate() {
		return pidate;
	}

	public void setPidate(String pidate) {
		this.pidate = pidate;
	}

	public Integer getRefpoid() {
		return refpoid;
	}

	public void setRefpoid(Integer refpoid) {
		this.refpoid = refpoid;
	}

	public Integer getRefgrid() {
		return refgrid;
	}

	public void setRefgrid(Integer refgrid) {
		this.refgrid = refgrid;
	}

	public Integer getVendorid() {
		return vendorid;
	}

	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}

	public String getVendorinvoiceno() {
		return vendorinvoiceno;
	}

	public void setVendorinvoiceno(String vendorinvoiceno) {
		this.vendorinvoiceno = vendorinvoiceno;
	}

	public Integer getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(Integer taxtype) {
		this.taxtype = taxtype;
	}

	public String getItemamt() {
		return itemamt;
	}

	public void setItemamt(String itemamt) {
		this.itemamt = itemamt;
	}

	public String getTotalproduct() {
		return totalproduct;
	}

	public void setTotalproduct(String totalproduct) {
		this.totalproduct = totalproduct;
	}

	public String getTotaldiscount() {
		return totaldiscount;
	}

	public void setTotaldiscount(String totaldiscount) {
		this.totaldiscount = totaldiscount;
	}

	public String getTaxableamt() {
		return taxableamt;
	}

	public void setTaxableamt(String taxableamt) {
		this.taxableamt = taxableamt;
	}

	public String getTotaltaxamt() {
		return totaltaxamt;
	}

	public void setTotaltaxamt(String totaltaxamt) {
		this.totaltaxamt = totaltaxamt;
	}

	public String getPackingcharge() {
		return packingcharge;
	}

	public void setPackingcharge(String packingcharge) {
		this.packingcharge = packingcharge;
	}

	public String getServicecharge() {
		return servicecharge;
	}

	public void setServicecharge(String servicecharge) {
		this.servicecharge = servicecharge;
	}

	public String getShippingtax() {
		return shippingtax;
	}

	public void setShippingtax(String shippingtax) {
		this.shippingtax = shippingtax;
	}

	public String getShippingtaxamt() {
		return shippingtaxamt;
	}

	public void setShippingtaxamt(String shippingtaxamt) {
		this.shippingtaxamt = shippingtaxamt;
	}

	public String getEducationcess() {
		return educationcess;
	}

	public void setEducationcess(String educationcess) {
		this.educationcess = educationcess;
	}

	public String getExeciseduty() {
		return execiseduty;
	}

	public void setExeciseduty(String execiseduty) {
		this.execiseduty = execiseduty;
	}

	public String getPretaxtotal() {
		return pretaxtotal;
	}

	public void setPretaxtotal(String pretaxtotal) {
		this.pretaxtotal = pretaxtotal;
	}

	public String getVatamt() {
		return vatamt;
	}

	public void setVatamt(String vatamt) {
		this.vatamt = vatamt;
	}

	public String getGstamt() {
		return gstamt;
	}

	public void setGstamt(String gstamt) {
		this.gstamt = gstamt;
	}

	public String getCgstamt() {
		return cgstamt;
	}

	public void setCgstamt(String cgstamt) {
		this.cgstamt = cgstamt;
	}

	public String getSgstamt() {
		return sgstamt;
	}

	public void setSgstamt(String sgstamt) {
		this.sgstamt = sgstamt;
	}

	public String getIgstamt() {
		return igstamt;
	}

	public void setIgstamt(String igstamt) {
		this.igstamt = igstamt;
	}

	public String getUtgstamt() {
		return utgstamt;
	}

	public void setUtgstamt(String utgstamt) {
		this.utgstamt = utgstamt;
	}

	public String getTotalinctaxamt() {
		return totalinctaxamt;
	}

	public void setTotalinctaxamt(String totalinctaxamt) {
		this.totalinctaxamt = totalinctaxamt;
	}

	public String getTotalexctaxamt() {
		return totalexctaxamt;
	}

	public void setTotalexctaxamt(String totalexctaxamt) {
		this.totalexctaxamt = totalexctaxamt;
	}

	public String getAdjoperator() {
		return adjoperator;
	}

	public void setAdjoperator(String adjoperator) {
		this.adjoperator = adjoperator;
	}

	public String getAdjustamt() {
		return adjustamt;
	}

	public void setAdjustamt(String adjustamt) {
		this.adjustamt = adjustamt;
	}

	public String getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(String grandtotal) {
		this.grandtotal = grandtotal;
	}

	public Integer getTcid() {
		return tcid;
	}

	public void setTcid(Integer tcid) {
		this.tcid = tcid;
	}

	public Integer getInitialapproval() {
		return initialapproval;
	}

	public void setInitialapproval(Integer initialapproval) {
		this.initialapproval = initialapproval;
	}

	public Integer getFinalapproval() {
		return finalapproval;
	}

	public void setFinalapproval(Integer finalapproval) {
		this.finalapproval = finalapproval;
	}

	public Integer getRejectid() {
		return rejectid;
	}

	public void setRejectid(Integer rejectid) {
		this.rejectid = rejectid;
	}

	public Integer getPistatus() {
		return pistatus;
	}

	public void setPistatus(Integer pistatus) {
		this.pistatus = pistatus;
	}

	public Integer getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(Integer taskstatus) {
		this.taskstatus = taskstatus;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public Integer getAccountby() {
		return accountby;
	}

	public void setAccountby(Integer accountby) {
		this.accountby = accountby;
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

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getClientmdate() {
		return clientmdate;
	}

	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype;
	}

	public String getTotalboxquantiy() {
		return totalboxquantiy;
	}

	public void setTotalboxquantiy(String totalboxquantiy) {
		this.totalboxquantiy = totalboxquantiy;
	}

	public String getTotalstripquantity() {
		return totalstripquantity;
	}

	public void setTotalstripquantity(String totalstripquantity) {
		this.totalstripquantity = totalstripquantity;
	}

	public String getTotaltabletquantity() {
		return totaltabletquantity;
	}

	public void setTotaltabletquantity(String totaltabletquantity) {
		this.totaltabletquantity = totaltabletquantity;
	}

	public String getTotalquantity() {
		return totalquantity;
	}

	public void setTotalquantity(String totalquantity) {
		this.totalquantity = totalquantity;
	}

	public String getInvoicetype() {
		return invoicetype;
	}

	public void setInvoicetype(String invoicetype) {
		this.invoicetype = invoicetype;
	}

	public String getRoundoff() {
		return roundoff;
	}

	public void setRoundoff(String roundoff) {
		this.roundoff = roundoff;
	}

	public String getCashdiscount() {
		return cashdiscount;
	}

	public void setCashdiscount(String cashdiscount) {
		this.cashdiscount = cashdiscount;
	}

	public String getTotalmargin() {
		return totalmargin;
	}

	public void setTotalmargin(String totalmargin) {
		this.totalmargin = totalmargin;
	}

	public String getTotalfreeboxqty() {
		return totalfreeboxqty;
	}

	public void setTotalfreeboxqty(String totalfreeboxqty) {
		this.totalfreeboxqty = totalfreeboxqty;
	}

	public String getTotalfreestripqty() {
		return totalfreestripqty;
	}

	public void setTotalfreestripqty(String totalfreestripqty) {
		this.totalfreestripqty = totalfreestripqty;
	}

	public String getTotalfreetabletqty() {
		return totalfreetabletqty;
	}

	public void setTotalfreetabletqty(String totalfreetabletqty) {
		this.totalfreetabletqty = totalfreetabletqty;
	}

	public String getTotalfreeqty() {
		return totalfreeqty;
	}

	public void setTotalfreeqty(String totalfreeqty) {
		this.totalfreeqty = totalfreeqty;
	}

	public Integer getDcrefid() {
		return dcrefid;
	}

	public void setDcrefid(Integer dcrefid) {
		this.dcrefid = dcrefid;
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

	public Integer getBarcodeposition() {
		return barcodeposition;
	}

	public void setBarcodeposition(Integer barcodeposition) {
		this.barcodeposition = barcodeposition;
	}

	public Integer getQrcodeposition() {
		return qrcodeposition;
	}

	public void setQrcodeposition(Integer qrcodeposition) {
		this.qrcodeposition = qrcodeposition;
	}

	public Integer getCashdiscountpercent() {
		return cashdiscountpercent;
	}

	public void setCashdiscountpercent(Integer cashdiscountpercent) {
		this.cashdiscountpercent = cashdiscountpercent;
	}

}
