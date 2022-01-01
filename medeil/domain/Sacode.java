package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_saccode", catalog = "medc_productmaster")
public class Sacode implements Serializable {

	public static long serialVersionUIT = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sacid")
	private Integer sacid;
	private Integer grouprefid;
	private Integer saccode;
	private String desc_ofservices;
	private String sacsubcode1;
	private String sac_subcode1_des;
	private String sac_subcode2;
	private String sac_subcode2_desc;
	private Integer countryid;
	public Integer getSacid() {
		return sacid;
	}
	public void setSacid(Integer sacid) {
		this.sacid = sacid;
	}
	public Integer getGrouprefid() {
		return grouprefid;
	}
	public void setGrouprefid(Integer grouprefid) {
		this.grouprefid = grouprefid;
	}
	public Integer getSaccode() {
		return saccode;
	}
	public void setSaccode(Integer saccode) {
		this.saccode = saccode;
	}
	public String getDesc_ofservices() {
		return desc_ofservices;
	}
	public void setDesc_ofservices(String desc_ofservices) {
		this.desc_ofservices = desc_ofservices;
	}
	public String getSacsubcode1() {
		return sacsubcode1;
	}
	public void setSacsubcode1(String sacsubcode1) {
		this.sacsubcode1 = sacsubcode1;
	}
	public String getSac_subcode1_des() {
		return sac_subcode1_des;
	}
	public void setSac_subcode1_des(String sac_subcode1_des) {
		this.sac_subcode1_des = sac_subcode1_des;
	}
	public String getSac_subcode2() {
		return sac_subcode2;
	}
	public void setSac_subcode2(String sac_subcode2) {
		this.sac_subcode2 = sac_subcode2;
	}
	public String getSac_subcode2_desc() {
		return sac_subcode2_desc;
	}
	public void setSac_subcode2_desc(String sac_subcode2_desc) {
		this.sac_subcode2_desc = sac_subcode2_desc;
	}
	public Integer getCountryid() {
		return countryid;
	}
	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}
}
