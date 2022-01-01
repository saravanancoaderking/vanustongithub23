package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_empsubdivision", catalog = "medc_employee")

public class Empsubdivision   implements Serializable{
	

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "subdivisionid")
	private Integer id;
	private Integer deptrefid;
	private Integer subdeptrefid;
	private Integer divisionrefid;
	private String subdivisionname;
	private Integer status;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private String description;
	private String clientcdate;
	private String clientmdate;
	private String createddate;
	private String modifieddate;
	public Integer getDeptrefid() {
		return deptrefid;
	}
	public void setDeptrefid(Integer deptrefid) {
		this.deptrefid = deptrefid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSubdeptrefid() {
		return subdeptrefid;
	}
	public void setSubdeptrefid(Integer subdeptrefid) {
		this.subdeptrefid = subdeptrefid;
	}
	public Integer getDivisionrefid() {
		return divisionrefid;
	}
	public void setDivisionrefid(Integer divisionrefid) {
		this.divisionrefid = divisionrefid;
	}
	public String getSubdivisionname() {
		return subdivisionname;
	}
	public void setSubdivisionname(String subdivisionname) {
		this.subdivisionname = subdivisionname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
