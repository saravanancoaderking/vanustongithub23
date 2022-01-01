package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_task_comment", catalog = "medc_taskmanagement")
public class UserTaskComment implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	
	
	private int id;
	
	private int task_id;
	private String comment;
	private int employee_id;
	private String clientcdate;
	private int createddate; 	
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	

	
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public int getCreateddate() {
		return createddate;
	}
	public void setCreateddate(int createddate) {
		this.createddate = createddate;
	}
	public int getCompanyrefid() {
		return companyrefid;
	}
	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}
	public int getBranchrefid() {
		return branchrefid;
	}
	public void setBranchrefid(int branchrefid) {
		this.branchrefid = branchrefid;
	}
	public int getLocname() {
		return locname;
	}
	public void setLocname(int locname) {
		this.locname = locname;
	}
	public int getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(int locrefid) {
		this.locrefid = locrefid;
	}
	
	
	
	
	
	
	
	

}
