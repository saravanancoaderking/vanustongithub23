package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_ehrreport", catalog = "medc_ehr")
public class Ehr {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ehrreportid")
	private Integer id;
	
	private String ehrreportname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEhrreportname() {
		return ehrreportname;
	}

	public void setEhrreportname(String ehrreportname) {
		this.ehrreportname = ehrreportname;
	}


}
