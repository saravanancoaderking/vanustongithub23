package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_usersubmodule", catalog = "medc_adminsecurity")
public class Usersubmodule implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserSubModuleID")
	private Long id;

	private Integer suserrefid;

	private Integer submoduleid;

	private Integer moduleid;
	// padmini
	private String label;

	private Integer ranking;

	private Boolean is_approver;

	private Integer companyrefid;
	
	private Integer editionid;
	


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

	public Integer getModuleid() {
		return moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	public Integer getSuserrefid() {
		return suserrefid;
	}

	public void setSuserrefid(Integer suserrefid) {
		this.suserrefid = suserrefid;
	}

	public Integer getSubmoduleid() {
		return submoduleid;
	}

	public void setSubmoduleid(Integer submoduleid) {
		this.submoduleid = submoduleid;
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
