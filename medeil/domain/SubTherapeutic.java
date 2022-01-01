package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_subtherapeuticmaster", catalog = "medc_productmaster")
public class SubTherapeutic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subtherapeuticid")
	private Integer id;

	private Integer therapeuticid;

	private String subtherapeuticname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTherapeuticid() {
		return therapeuticid;
	}

	public void setTherapeuticid(Integer therapeuticid) {
		this.therapeuticid = therapeuticid;
	}

	public String getSubtherapeuticname() {
		return subtherapeuticname;
	}

	public void setSubtherapeuticname(String subtherapeuticname) {
		this.subtherapeuticname = subtherapeuticname;
	}
	
	
}
