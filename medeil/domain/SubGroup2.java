package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_subgroup2", catalog = "medc_productmaster")
public class SubGroup2 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subgroupid2")
	private int subgroupid2;
	private String subgroupname2;
	private int subgrouprefid1;
	private int verticalid;
	private int createdby;
	private String createddate;
	private int modifiedby;
	private String modifieddate;
	private String clientcdate;
	private String clientmdate;

	public int getSubgroupid2() {
		return subgroupid2;
	}

	public void setSubgroupid2(int subgroupid2) {
		this.subgroupid2 = subgroupid2;
	}

	public String getSubgroupname2() {
		return subgroupname2;
	}

	public void setSubgroupname2(String subgroupname2) {
		this.subgroupname2 = subgroupname2;
	}

	public int getSubgrouprefid1() {
		return subgrouprefid1;
	}

	public void setSubgrouprefid1(int subgrouprefid1) {
		this.subgrouprefid1 = subgrouprefid1;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public int getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getClientmdate() {
		return clientmdate;
	}

	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
	}

	public int getVerticalid() {
		return verticalid;
	}

	public void setVerticalid(int verticalid) {
		this.verticalid = verticalid;
	}

}
