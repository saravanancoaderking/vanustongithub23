package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_usermodules", catalog = "medc_adminsecurity")
public class UserModule implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserModuleID")
	private Long id;

	private Integer suserrefid;

	private Integer moduleid;
	
	private Boolean is_approver;

	private Integer companyrefid;
	
	private Integer editionid;
	
	//padmini
	private String label;
	private Integer ranking;

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public Boolean getIs_approver() {
		return is_approver;
	}

	public void setIs_approver(Boolean is_approver) {
		this.is_approver = is_approver;
	}

	public Integer getSuserrefid() {
		return suserrefid;
	}

	public void setSuserrefid(Integer suserrefid) {
		this.suserrefid = suserrefid;
	}

	public Integer getModuleid() {
		return moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Integer getEditionid() {
		return editionid;
	}

	public void setEditionid(Integer editionid) {
		this.editionid = editionid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
