package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_genericmaster", catalog = "medc_productmaster")
public class GenericMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genericid")
	private Integer genericid;
	/*private String genericcode;
	private String drugbankid;*/
	private String genericname;
	/*private String group;
	private String sector;
	private String subsector;
	private int createdby;

	private int modifiedby;

	private int groupid;
	private int subgroup1id;
	private int subgroup2id;
	private int dummy1;
	private int dummy2;
	private int dummy3;
	private String dummy4;
	private String dummy5;
	private String dummy6; */
	public Integer getGenericid() {
		return genericid;
	}
	public void setGenericid(Integer genericid) {
		this.genericid = genericid;
	}
	public String getGenericname() {
		return genericname;
	}
	public void setGenericname(String genericname) {
		this.genericname = genericname;
	}

	
}
