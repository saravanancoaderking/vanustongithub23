package com.medeil.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_picking", catalog = "medc_deliveryprocess")
public class Picking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "picklistid")
	private Integer id;
	private String picklistno;
	private Integer salesinvoiceno;
	private Integer createdby;
	private String createddate;
	private String clientcdate;
	private String clientmdate;
	private Integer modifiedby;
	private String modifieddate;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer calcflag;
	private Integer custrefid;
	private Integer emprefid;
	private Integer emprefidsort;
	private Integer emprefidapproval;
	private Integer picktypeno;
	private Integer picktyperefid;
	private Integer countryrefid;
	private Integer returnqty;
	private Integer returnid;
	private String qrcoderefid;
	private String barcoderefid;
	private Integer approverstatus;
	private Integer sotype;
	private Integer salesorderrefid;
	private Integer totalprod;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPicklistno() {
		return picklistno;
	}
	public void setPicklistno(String picklistno) {
		this.picklistno = picklistno;
	}
	public Integer getSalesinvoiceno() {
		return salesinvoiceno;
	}
	public void setSalesinvoiceno(Integer salesinvoiceno) {
		this.salesinvoiceno = salesinvoiceno;
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
	public Integer getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
	}
	public Integer getCustrefid() {
		return custrefid;
	}
	public void setCustrefid(Integer custrefid) {
		this.custrefid = custrefid;
	}
	public Integer getEmprefid() {
		return emprefid;
	}
	public void setEmprefid(Integer emprefid) {
		this.emprefid = emprefid;
	}
	public Integer getEmprefidsort() {
		return emprefidsort;
	}
	public void setEmprefidsort(Integer emprefidsort) {
		this.emprefidsort = emprefidsort;
	}
	public Integer getEmprefidapproval() {
		return emprefidapproval;
	}
	public void setEmprefidapproval(Integer emprefidapproval) {
		this.emprefidapproval = emprefidapproval;
	}
	public Integer getPicktypeno() {
		return picktypeno;
	}
	public void setPicktypeno(Integer picktypeno) {
		this.picktypeno = picktypeno;
	}
	public Integer getPicktyperefid() {
		return picktyperefid;
	}
	public void setPicktyperefid(Integer picktyperefid) {
		this.picktyperefid = picktyperefid;
	}
	public Integer getCountryrefid() {
		return countryrefid;
	}
	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
	}
	public Integer getReturnqty() {
		return returnqty;
	}
	public void setReturnqty(Integer returnqty) {
		this.returnqty = returnqty;
	}
	public Integer getReturnid() {
		return returnid;
	}
	public void setReturnid(Integer returnid) {
		this.returnid = returnid;
	}
	public String getQrcoderefid() {
		return qrcoderefid;
	}
	public void setQrcoderefid(String qrcoderefid) {
		this.qrcoderefid = qrcoderefid;
	}
	public String getBarcoderefid() {
		return barcoderefid;
	}
	public void setBarcoderefid(String barcoderefid) {
		this.barcoderefid = barcoderefid;
	}
	public Integer getApproverstatus() {
		return approverstatus;
	}
	public void setApproverstatus(Integer approverstatus) {
		this.approverstatus = approverstatus;
	}
	public Integer getSotype() {
		return sotype;
	}
	public void setSotype(Integer sotype) {
		this.sotype = sotype;
	}
	public Integer getSalesorderrefid() {
		return salesorderrefid;
	}
	public void setSalesorderrefid(Integer salesorderrefid) {
		this.salesorderrefid = salesorderrefid;
	}
	public Integer getTotalprod() {
		return totalprod;
	}
	public void setTotalprod(Integer totalprod) {
		this.totalprod = totalprod;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
