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
@Table(name = "medc_rolectrl", catalog = "medc_adminsecurity")
public class Rolectrl implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RolectrlID")
	private Integer id;

	private Integer moduleid;

	private Integer submoduleid;

	private Integer roleid;
	
	@Transient
	
	private Integer editionid;

	public Integer getEditionid() {
		return editionid;
	}

	public void setEditionid(Integer editionid) {
		this.editionid = editionid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
