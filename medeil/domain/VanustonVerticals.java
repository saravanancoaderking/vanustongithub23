package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_vanustonvertical", catalog = "medc_productmaster")
public class VanustonVerticals implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer verticalid;
	private String verticalname;
	private Integer countryid;

	public int getVerticalid() {
		return verticalid;
	}

	public void setVerticalid(int verticalid) {
		this.verticalid = verticalid;
	}

	public String getVerticalname() {
		return verticalname;
	}

	public void setVerticalname(String verticalname) {
		this.verticalname = verticalname;
	}

	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
}
