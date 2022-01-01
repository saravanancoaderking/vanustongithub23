package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_chequebook", catalog = "medc_bank")
public class Cheque implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ChqBookID")
	private Integer id;
	private String chqbookno;
	private String accno;
	private Integer leaves;
	private String startno;
	private String endno;
	private Integer chqstatus;
	private Integer noofcheques;
	private Integer bankrefid;
	private Integer createdby;
	private String issueddate;
	private String bankname;
	private String branch;
	private String remarks;
	private Integer modifiedby;
	private String modifieddate;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer shoprefid;
	private Integer warehouserefid;
	private Integer hospitalrefid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChqbookno() {
		return chqbookno;
	}
	public void setChqbookno(String chqbookno) {
		this.chqbookno = chqbookno;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public Integer getLeaves() {
		return leaves;
	}
	public void setLeaves(Integer leaves) {
		this.leaves = leaves;
	}
	public String getStartno() {
		return startno;
	}
	public void setStartno(String startno) {
		this.startno = startno;
	}
	public String getEndno() {
		return endno;
	}
	public void setEndno(String endno) {
		this.endno = endno;
	}
	public Integer getChqstatus() {
		return chqstatus;
	}
	public void setChqstatus(Integer chqstatus) {
		this.chqstatus = chqstatus;
	}
	public Integer getNoofcheques() {
		return noofcheques;
	}
	public void setNoofcheques(Integer noofcheques) {
		this.noofcheques = noofcheques;
	}
	public Integer getBankrefid() {
		return bankrefid;
	}
	public void setBankrefid(Integer bankrefid) {
		this.bankrefid = bankrefid;
	}
	public Integer getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}
	public String getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(String issueddate) {
		this.issueddate = issueddate;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

}
