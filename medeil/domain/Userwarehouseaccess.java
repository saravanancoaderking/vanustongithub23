package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_userwhouseaccess", catalog = "medc_adminsecurity")
public class Userwarehouseaccess implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer suserrefid;

	private Integer warehouserefid;

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

	public Integer getWarehouserefid() {
		return warehouserefid;
	}

	public void setWarehouserefid(Integer warehouserefid) {
		this.warehouserefid = warehouserefid;
	}

}
