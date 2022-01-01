package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "medc_editionctrl", catalog = "medc_adminsecurity")
public class Editionctrl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EditionctrlID")
	private Integer id;

	private Integer editionid;

	private Integer moduleid;

	private Integer submoduleid;

	
	@Transient
	private Integer roleid;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getEditionid() {
		return editionid;
	}


	public void setEditionid(Integer editionid) {
		this.editionid = editionid;
	}


	public Integer getModuleid() {
		return moduleid;
	}


	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}


	public Integer getSubmoduleid() {
		return submoduleid;
	}


	public void setSubmoduleid(Integer submoduleid) {
		this.submoduleid = submoduleid;
	}


	public Integer getRoleid() {
		return roleid;
	}


	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	
}
