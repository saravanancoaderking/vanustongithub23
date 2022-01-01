package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_subtasktitle", catalog = "medc_taskmanagement")
public class SubTaskTitle implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "subtask_id")
	private int id;
	
	private String sub_task_title;
	private int employeeid;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private int task_id;
	
	
	
	public String getSub_task_title() {
		return sub_task_title;
	}
	public void setSub_task_title(String sub_task_title) {
		this.sub_task_title = sub_task_title;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
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
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	
	

}
