package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_counter", catalog = "medc_open_close_register")
public class Salescounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "counterid")
	private int counterid;
	
	private Integer companyid;
	
	private Integer locrefid;

	private Integer locaname;

	private Integer barnchid;

	private Integer countryid;

	public int getCounterid() {
		return counterid;
	}

	public void setCounterid(int counterid) {
		this.counterid = counterid;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getLocaname() {
		return locaname;
	}

	public void setLocaname(Integer locaname) {
		this.locaname = locaname;
	}

	public Integer getBarnchid() {
		return barnchid;
	}

	public void setBarnchid(Integer barnchid) {
		this.barnchid = barnchid;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}
	

	
	
}
