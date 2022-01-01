package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_bankdetails", catalog = "medc_bank")
public class BankDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BankID")
	private Integer id;
	private String accnumber;
	private String accholder;
	private String acctype;
	private String opendate;
	private Double openingbal;
	private String baltype;
	private String accstatus;
	private String bankname;
	private String branch;
	private String address1;
	private String address2;
	private Integer createdby;
	
	private Integer modifiedby;
	
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer shoprefid;
	private Integer warehouserefid;
	private Integer hospitalrefid;
	private Integer Status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(String accnumber) {
		this.accnumber = accnumber;
	}

	public String getAccholder() {
		return accholder;
	}

	public void setAccholder(String accholder) {
		this.accholder = accholder;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getOpendate() {
		return opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public Double getOpeningbal() {
		return openingbal;
	}

	public void setOpeningbal(Double openingbal) {
		this.openingbal = openingbal;
	}

	public String getBaltype() {
		return baltype;
	}

	public void setBaltype(String baltype) {
		this.baltype = baltype;
	}

	public String getAccstatus() {
		return accstatus;
	}

	public void setAccstatus(String accstatus) {
		this.accstatus = accstatus;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}



	public Integer getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
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

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}
}
