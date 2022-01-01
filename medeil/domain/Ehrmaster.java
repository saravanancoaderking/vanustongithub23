package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_ehrmaster", catalog = "medc_ehr")
public class Ehrmaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ehrmsid")
	private Integer id;

	private Integer ehrreportid;

	private String ehrfiletype;

	private Integer customerid;

	private Integer companyid;

	private Integer branchid;

	private Integer locname;

	private Integer locrefid;

	private String doctype;

	private String docname;
	
	private Integer doctorid;
	
	private Integer hospitalid;

	private byte[] ehrdoc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEhrreportid() {
		return ehrreportid;
	}

	public void setEhrreportid(Integer ehrreportid) {
		this.ehrreportid = ehrreportid;
	}

	public String getEhrfiletype() {
		return ehrfiletype;
	}

	public void setEhrfiletype(String ehrfiletype) {
		this.ehrfiletype = ehrfiletype;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
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

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public byte[] getEhrdoc() {
		return ehrdoc;
	}

	public void setEhrdoc(byte[] ehrdoc) {
		this.ehrdoc = ehrdoc;
	}

	public Integer getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Integer doctorid) {
		this.doctorid = doctorid;
	}

	public Integer getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(Integer hospitalid) {
		this.hospitalid = hospitalid;
	}

}
