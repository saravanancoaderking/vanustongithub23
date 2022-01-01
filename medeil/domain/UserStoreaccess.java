package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_userstoreaccess", catalog = "medc_adminsecurity")
public class UserStoreaccess implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserStoreID")
	private Integer id;

	private Integer suserrefid;

	private Integer storerefid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSuserrefid() {
		return suserrefid;
	}

	public void setSuserrefid(Integer suserrefid) {
		this.suserrefid = suserrefid;
	}

	public Integer getStorerefid() {
		return storerefid;
	}

	public void setStorerefid(Integer storerefid) {
		this.storerefid = storerefid;
	}

}
