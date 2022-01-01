package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_sac_main", catalog = "medc_productmaster")
public class SacCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sacmainid")
	private Integer Id;
	private String headingno;
	private String headingname;
	private Integer sectioncode;
	private Integer groupcode;
	private Integer saccode;
	private Integer subcode1code;
	private Integer subcode2code;
	private Integer gstrate;
	private Integer cess;
	private Integer countrycode;
	private String createdby;

	private Integer status;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getHeadingno() {
		return headingno;
	}

	public void setHeadingno(String headingno) {
		this.headingno = headingno;
	}

	public String getHeadingname() {
		return headingname;
	}

	public void setHeadingname(String headingname) {
		this.headingname = headingname;
	}

	public Integer getSectioncode() {
		return sectioncode;
	}

	public void setSectioncode(Integer sectioncode) {
		this.sectioncode = sectioncode;
	}

	public Integer getGroupcode() {
		return groupcode;
	}

	public void setGroupcode(Integer groupcode) {
		this.groupcode = groupcode;
	}

	public Integer getSaccode() {
		return saccode;
	}

	public void setSaccode(Integer saccode) {
		this.saccode = saccode;
	}

	public Integer getSubcode1code() {
		return subcode1code;
	}

	public void setSubcode1code(Integer subcode1code) {
		this.subcode1code = subcode1code;
	}

	public Integer getSubcode2code() {
		return subcode2code;
	}

	public void setSubcode2code(Integer subcode2code) {
		this.subcode2code = subcode2code;
	}

	public Integer getGstrate() {
		return gstrate;
	}

	public void setGstrate(Integer gstrate) {
		this.gstrate = gstrate;
	}

	public Integer getCess() {
		return cess;
	}

	public void setCess(Integer cess) {
		this.cess = cess;
	}

	public Integer getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(Integer countrycode) {
		this.countrycode = countrycode;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
