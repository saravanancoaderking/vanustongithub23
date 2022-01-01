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
 * @author Manikbaasha
 *
 */
@Entity
@Table(name = "medc_purchaseorder", catalog = "medc_purchase")
public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poid")
	private Integer id;
	private String pono;
	private String podate;
	public String getPodate() {
		return podate;
	}
	public void setPodate(String podate) {
		this.podate = podate;
	}
	private Integer refpesid;
	private Integer vendorid;
	private Integer taxtype;
	private Double itemamt;
	private Double totalproduct;
	private Double totaldiscount;
	private Double taxableamt;
	private Double totaltaxamt;
	private Double packingcharge;
	private Double servicecharge;
	private Double shippingtax;
	private Double shippingtaxamt;
	private Double educationcess;
	private Double execiseduty;
	private Double pretaxtotal;
	private Double vatamt;
	private Double gstamt;
	private Double cgstamt;
	private Double sgstamt;
	private Double igstamt;
	private Double utgstamt;
	private Double totalinctaxamt;
	private Double totalexctaxamt;
	private String adjoperator;
	private Double adjustamt;
	public String getAbc() {
		return abc;
	}
	public void setAbc(String abc) {
		this.abc = abc;
	}
	public String getDistprodrank() {
		return distprodrank;
	}
	public void setDistprodrank(String distprodrank) {
		this.distprodrank = distprodrank;
	}
	public String getDistremarks() {
		return distremarks;
	}
	public void setDistremarks(String distremarks) {
		this.distremarks = distremarks;
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
	private Double grandtotal;
	private Integer tcid;
	private Integer initialapproval;
	private Integer finalapproval;
	private Integer postatus;
	private String baddress1;
	private String baddress2;
	private String bcountry;
	private String bstate;
	private String bcity;
	private String bpincode;
	private String bcontactno;
	private String saddress1;
	private String saddress2;
	private String scountry;
	private String sstate;
	private String scity;
	private String spincode;
	private String scontactno;
	private String assignedto;
	private Integer taskstatus;
	private Integer accountby;
	private Integer createdby;
	private String createddate;
	private Integer modifiedby;
	private String modifieddate;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private String deliverytype;
	private Double totalboxquantiy;
	private Integer rejectid;
	private Double totalstripquantity;
	private Double totaltabletquantity;
	private Double totalquantity;
	private String ordertype;

	private String abc;
	private String distprodrank;
	private String distremarks;
	private String pursessionno;
	private Integer pursessionid;// Boopalan 240519
	private Integer quantitytype;
	//barqr code properties
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
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public Integer getRefpesid() {
		return refpesid;
	}
	public void setRefpesid(Integer refpesid) {
		this.refpesid = refpesid;
	}
	public Integer getVendorid() {
		return vendorid;
	}
	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}
	public Integer getTaxtype() {
		return taxtype;
	}
	public void setTaxtype(Integer taxtype) {
		this.taxtype = taxtype;
	}
	public Double getItemamt() {
		return itemamt;
	}
	public void setItemamt(Double itemamt) {
		this.itemamt = itemamt;
	}
	public Double getTotalproduct() {
		return totalproduct;
	}
	public void setTotalproduct(Double totalproduct) {
		this.totalproduct = totalproduct;
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
	public Double getServicecharge() {
		return servicecharge;
	}
	public void setServicecharge(Double servicecharge) {
		this.servicecharge = servicecharge;
	}
	public Double getShippingtax() {
		return shippingtax;
	}
	public void setShippingtax(Double shippingtax) {
		this.shippingtax = shippingtax;
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
	public Double getPretaxtotal() {
		return pretaxtotal;
	}
	public void setPretaxtotal(Double pretaxtotal) {
		this.pretaxtotal = pretaxtotal;
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
	public Double getCgstamt() {
		return cgstamt;
	}
	public void setCgstamt(Double cgstamt) {
		this.cgstamt = cgstamt;
	}
	public Double getSgstamt() {
		return sgstamt;
	}
	public void setSgstamt(Double sgstamt) {
		this.sgstamt = sgstamt;
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
	public Double getTotalinctaxamt() {
		return totalinctaxamt;
	}
	public void setTotalinctaxamt(Double totalinctaxamt) {
		this.totalinctaxamt = totalinctaxamt;
	}
	public Double getTotalexctaxamt() {
		return totalexctaxamt;
	}
	public void setTotalexctaxamt(Double totalexctaxamt) {
		this.totalexctaxamt = totalexctaxamt;
	}
	public String getAdjoperator() {
		return adjoperator;
	}
	public void setAdjoperator(String adjoperator) {
		this.adjoperator = adjoperator;
	}
	public Double getAdjustamt() {
		return adjustamt;
	}
	public void setAdjustamt(Double adjustamt) {
		this.adjustamt = adjustamt;
	}
	public Double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(Double grandtotal) {
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
	public Integer getPostatus() {
		return postatus;
	}
	public void setPostatus(Integer postatus) {
		this.postatus = postatus;
	}
	public String getBaddress1() {
		return baddress1;
	}
	public void setBaddress1(String baddress1) {
		this.baddress1 = baddress1;
	}
	public String getBaddress2() {
		return baddress2;
	}
	public void setBaddress2(String baddress2) {
		this.baddress2 = baddress2;
	}
	public String getBcountry() {
		return bcountry;
	}
	public void setBcountry(String bcountry) {
		this.bcountry = bcountry;
	}
	public String getBstate() {
		return bstate;
	}
	public void setBstate(String bstate) {
		this.bstate = bstate;
	}
	public String getBcity() {
		return bcity;
	}
	public void setBcity(String bcity) {
		this.bcity = bcity;
	}

	public String getBpincode() {
		return bpincode;
	}
	public void setBpincode(String bpincode) {
		this.bpincode = bpincode;
	}
	public String getBcontactno() {
		return bcontactno;
	}
	public void setBcontactno(String bcontactno) {
		this.bcontactno = bcontactno;
	}
	public String getSaddress1() {
		return saddress1;
	}
	public void setSaddress1(String saddress1) {
		this.saddress1 = saddress1;
	}
	public String getSaddress2() {
		return saddress2;
	}
	public void setSaddress2(String saddress2) {
		this.saddress2 = saddress2;
	}
	public String getScountry() {
		return scountry;
	}
	public void setScountry(String scountry) {
		this.scountry = scountry;
	}
	public String getSstate() {
		return sstate;
	}
	public void setSstate(String sstate) {
		this.sstate = sstate;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
	public String getSpincode() {
		return spincode;
	}
	public void setSpincode(String spincode) {
		this.spincode = spincode;
	}
	public String getScontactno() {
		return scontactno;
	}
	public void setScontactno(String scontactno) {
		this.scontactno = scontactno;
	}
	public String getAssignedto() {
		return assignedto;
	}
	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}
	public Integer getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(Integer taskstatus) {
		this.taskstatus = taskstatus;
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
	public Double getTotalboxquantiy() {
		return totalboxquantiy;
	}
	public void setTotalboxquantiy(Double totalboxquantiy) {
		this.totalboxquantiy = totalboxquantiy;
	}
	public Integer getRejectid() {
		return rejectid;
	}
	public void setRejectid(Integer rejectid) {
		this.rejectid = rejectid;
	}
	public Double getTotalstripquantity() {
		return totalstripquantity;
	}
	public void setTotalstripquantity(Double totalstripquantity) {
		this.totalstripquantity = totalstripquantity;
	}
	public Double getTotaltabletquantity() {
		return totaltabletquantity;
	}
	public void setTotaltabletquantity(Double totaltabletquantity) {
		this.totaltabletquantity = totaltabletquantity;
	}
	public Double getTotalquantity() {
		return totalquantity;
	}
	public void setTotalquantity(Double totalquantity) {
		this.totalquantity = totalquantity;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	


	public Integer getBarcodewidth() {
		return barcodewidth;
	}

	public void setBarcodewidth(Integer barcodewidth) {
		this.barcodewidth = barcodewidth;
	}

	public Integer getBarcodeheight() {
		return barcodeheight;
	}

	public void setBarcodeheight(Integer barcodeheight) {
		this.barcodeheight = barcodeheight;
	}

	public String getBarcodelabel() {
		return barcodelabel;
	}

	public void setBarcodelabel(String barcodelabel) {
		this.barcodelabel = barcodelabel;
	}

	public Integer getQrcodewidth() {
		return qrcodewidth;
	}

	public void setQrcodewidth(Integer qrcodewidth) {
		this.qrcodewidth = qrcodewidth;
	}

	public Integer getQrcodeheight() {
		return qrcodeheight;
	}

	public void setQrcodeheight(Integer qrcodeheight) {
		this.qrcodeheight = qrcodeheight;
	}

	public String getQrcodelabel() {
		return qrcodelabel;
	}

	public void setQrcodelabel(String qrcodelabel) {
		this.qrcodelabel = qrcodelabel;
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

	public byte[] getBarcodeimage() {
		return barcodeimage;
	}

	public void setBarcodeimage(byte[] barcodeimage) {
		this.barcodeimage = barcodeimage;
	}

	public byte[] getQrcodeimage() {
		return qrcodeimage;
	}

	public void setQrcodeimage(byte[] qrcodeimage) {
		this.qrcodeimage = qrcodeimage;
	}
	public Integer getQuantitytype() {
		return quantitytype;
	}
	public void setQuantitytype(Integer quantitytype) {
		this.quantitytype = quantitytype;
	}

}
