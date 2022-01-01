package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author Sankar
 *
 */
@Entity
@Table(name = "medc_salesorderlead", catalog = "medc_sales")
public class PatientLoginSalesorderLead implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private Integer id;

	private String orderdate;

	private String deliverytype;
	
	private Integer patientid;

	private String salesorderno;

	private Double totalitem;

	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locname;

	private Integer locrefid;

	private String clientcdate;
	
	private Integer employeeid;
	
	private Integer sotype;
	
	private String   soinfo;

	private Integer tolocname;

	private Integer tolocrefid;
	
	private String type;
	
	private String shipmentaddress;
	
	@Lob
	 private byte[] prescription_images;
		
	private Boolean prescription_order;
	 
	 private String pictureurl;
	 
	 private String Picturetype;
	 
	 
	
	public PatientLoginSalesorderLead(String contentType, String originalFilename, byte[] compressBytes) {
		this.Picturetype=contentType ;
		this.pictureurl = originalFilename;
		this.prescription_images = compressBytes;
		
	}

	public byte[] getPrescription_images() {
		return prescription_images;
	}

	public void setPrescription_images(byte[] prescription_images) {
		this.prescription_images = prescription_images;
	}

	public Boolean getPrescription_order() {
		return prescription_order;
	}

	public void setPrescription_order(Boolean prescription_order) {
		this.prescription_order = prescription_order;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype;
	}

	public Integer getPatientid() {
		return patientid;
	}

	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}

	public String getSalesorderno() {
		return salesorderno;
	}

	public void setSalesorderno(String salesorderno) {
		this.salesorderno = salesorderno;
	}

	public Double getTotalitem() {
		return totalitem;
	}

	public void setTotalitem(Double totalitem) {
		this.totalitem = totalitem;
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

	public String getPicturetype() {
		return Picturetype;
	}

	public void setPicturetype(String picturetype) {
		Picturetype = picturetype;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getSotype() {
		return sotype;
	}

	public void setSotype(Integer sotype) {
		this.sotype = sotype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSoinfo() {
		return soinfo;
	}

	public void setSoinfo(String soinfo) {
		this.soinfo = soinfo;
	}

	public Integer getTolocname() {
		return tolocname;
	}

	public void setTolocname(Integer tolocname) {
		this.tolocname = tolocname;
	}

	public Integer getTolocrefid() {
		return tolocrefid;
	}

	public void setTolocrefid(Integer tolocrefid) {
		this.tolocrefid = tolocrefid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getShipmentaddress() {
		return shipmentaddress;
	}

	public void setShipmentaddress(String shipmentaddress) {
		this.shipmentaddress = shipmentaddress;
	}

}
