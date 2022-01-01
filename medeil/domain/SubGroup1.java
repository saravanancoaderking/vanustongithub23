package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_subgroup1", catalog = "medc_productmaster")
public class SubGroup1 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subgroupid1")
	private int subgroupid1;
	private String subgroupname1;
	private int grouprefid;
	private int verticalid;
	private int createdby;
	private String createddate;
	private int modifiedby;
	private String modifieddate;
	private String clientcdate;
	private String clientmdate;
	public int getSubgroupid1() {
		return subgroupid1;
	}
	public void setSubgroupid1(int subgroupid1) {
		this.subgroupid1 = subgroupid1;
	}
	public String getSubgroupname1() {
		return subgroupname1;
	}
	public void setSubgroupname1(String subgroupname1) {
		this.subgroupname1 = subgroupname1;
	}
	public int getGrouprefid() {
		return grouprefid;
	}
	public void setGrouprefid(int grouprefid) {
		this.grouprefid = grouprefid;
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
