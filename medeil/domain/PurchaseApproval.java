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
 * @author Ajith AK
 *
 */
@Entity
@Table(name = "medc_purchaseapproval", catalog = "medc_stock")
public class PurchaseApproval implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purcapprovalID")
	private Integer id;
	private String purcapprovalno;
	private String purcapprovaldate;
	private Integer purchaseinvrefid;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer shoprefid;
	private Integer warehouserefid;
	private Integer hospitalrefid;
	private Integer locrefid;
	private Integer locname;
	
	@Transient
	private String invoicenumber;
	
	public String getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPurcapprovalno() {
		return purcapprovalno;
	}
	public void setPurcapprovalno(String purcapprovalno) {
		this.purcapprovalno = purcapprovalno;
	}
	public String getPurcapprovaldate() {
		return purcapprovaldate;
	}
	public void setPurcapprovaldate(String purcapprovaldate) {
		this.purcapprovaldate = purcapprovaldate;
	}
	public Integer getPurchaseinvrefid() {
		return purchaseinvrefid;
	}
	public void setPurchaseinvrefid(Integer purchaseinvrefid) {
		this.purchaseinvrefid = purchaseinvrefid;
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
	public Integer getShoprefid() {
		return shoprefid;
	}
	public void setShoprefid(Integer shoprefid) {
		this.shoprefid = shoprefid;
	}
	public Integer getWarehouserefid() {
		return warehouserefid;
	}
	public void setWarehouserefid(Integer warehouserefid) {
		this.warehouserefid = warehouserefid;
	}
	public Integer getHospitalrefid() {
		return hospitalrefid;
	}
	public void setHospitalrefid(Integer hospitalrefid) {
		this.hospitalrefid = hospitalrefid;
	}
	public Integer getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}
	public Integer getLocname() {
		return locname;
	}
	public void setLocname(Integer locname) {
		this.locname = locname;
	}
	
	
//
//	private Integer productid;
//
//	private String brandname;
//
//	private Double boxqty;
//
//	private Double stripqty;
//
//	private Double tabletqty;
//
//	private Double totqty;
//
//	private Double approvalqty;
//
//	private Double damageqty;
//
//	private Double penddingqty;
//
//	private Double unitprice;
//
//	private Double discount;
//
//	private Double vat;
//
//	private Double gst;
//
//	private Double sgst;
//
//	private Double cgst;
//
//	private Double igst;
//
//	private Double utgst;
//
//	private String batchno;
//	
//	private String batchname;
//
//	private Double purprice;
//
//	private Double salesdisc;
//
//	private Double mrp;
//
//	private Integer formulationid;
//
//	private String dosageid;
//
//	private String expirydate;
//
//	private Integer companyrefid;
//
//	private Integer branchrefid;
//
//	private Integer locrefid;
//
//	private Integer locname;
//
//	private String clientcdate;
//
//	private Double freeboxqty;
//
//	private Double freestripqty;
//
//	private Double freetabletqty;
//
//	private Double freetotalqty;
//
//	private Double vatamt;
//
//	private Double gstamt;
//
//	private Double sgstamt;
//
//	private Double cgstamt;
//
//	private Double igstamt;
//
//	private Double utgstamt;
//
//	/** Purchase Approval Maintanance **/
//	private String approvalno;
//
//	private String invoicenumber;
//
//	private String approvaldate;
//
//	private Integer shoprefid;
//
//	private Integer hospitalrefid;
//
//	private Integer warehouserefid;
//

}
