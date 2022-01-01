package com.medeil.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "medc_task_assignment", catalog = "medc_taskmanagement")
public class UserTask implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")

	private Integer id;
	private Integer task_type_id;
    @Column(name = "task_number")
	private String tasknumber;
	private String task_title;
	private String sub_task_title;
	private Integer deptid;
	private Integer subdeptid;
	private Integer divisionid;
	private Integer subdivisionid;
	private Integer employeeid;
	private String task_priority_name;
	private String task_status_name;
	// private int priority_id;
	// private int task_status_id;
	private String task_start_date;
	private String task_start_time;
	private String task_due_time;
	private String task_due_date;
	private Integer createdby;
	private Integer modifiedby;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer status;
	private String createddate;
	private String modifieddate;
	private Integer userid;
	private Integer task_assigned_by;
	private Integer task_assigned_to;
	private Integer task_modified_by;
	private String description;
	private Integer group_task_flag;
	private String completed_date;
	private String remarks;
	private Integer colors;
	@Transient
	private Integer suserid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTask_type_id() {
		return task_type_id;
	}
	public void setTask_type_id(Integer task_type_id) {
		this.task_type_id = task_type_id;
	}
	public String getTask_title() {
		return task_title;
	}
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}
	public String getSub_task_title() {
		return sub_task_title;
	}
	public void setSub_task_title(String sub_task_title) {
		this.sub_task_title = sub_task_title;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public Integer getSubdeptid() {
		return subdeptid;
	}
	public void setSubdeptid(Integer subdeptid) {
		this.subdeptid = subdeptid;
	}
	public Integer getDivisionid() {
		return divisionid;
	}
	public void setDivisionid(Integer divisionid) {
		this.divisionid = divisionid;
	}
	public Integer getSubdivisionid() {
		return subdivisionid;
	}
	public void setSubdivisionid(Integer subdivisionid) {
		this.subdivisionid = subdivisionid;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public String getTask_priority_name() {
		return task_priority_name;
	}
	public void setTask_priority_name(String task_priority_name) {
		this.task_priority_name = task_priority_name;
	}
	public String getTask_status_name() {
		return task_status_name;
	}
	public void setTask_status_name(String task_status_name) {
		this.task_status_name = task_status_name;
	}
	public String getTask_start_date() {
		return task_start_date;
	}
	public void setTask_start_date(String task_start_date) {
		this.task_start_date = task_start_date;
	}
	public String getTask_start_time() {
		return task_start_time;
	}
	public void setTask_start_time(String task_start_time) {
		this.task_start_time = task_start_time;
	}
	public String getTask_due_time() {
		return task_due_time;
	}
	public void setTask_due_time(String task_due_time) {
		this.task_due_time = task_due_time;
	}
	public String getTask_due_date() {
		return task_due_date;
	}
	public void setTask_due_date(String task_due_date) {
		this.task_due_date = task_due_date;
	}
	public Integer getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}
	public Integer getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}
	public Integer getCompanyrefid() {
		return companyrefid;
	}
	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}
	public Integer getBranchrefid() {
		return branchrefid;
	}
	public void setBranchrefid(Integer branchrefid) {
		this.branchrefid = branchrefid;
	}
	public Integer getLocname() {
		return locname;
	}
	public void setLocname(Integer locname) {
		this.locname = locname;
	}
	public Integer getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getTask_modified_by() {
		return task_modified_by;
	}
	public void setTask_modified_by(Integer task_modified_by) {
		this.task_modified_by = task_modified_by;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getGroup_task_flag() {
		return group_task_flag;
	}
	public void setGroup_task_flag(Integer group_task_flag) {
		this.group_task_flag = group_task_flag;
	}
	public String getCompleted_date() {
		return completed_date;
	}
	public void setCompleted_date(String completed_date) {
		this.completed_date = completed_date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getColors() {
		return colors;
	}
	public void setColors(Integer colors) {
		this.colors = colors;
	}
	public Integer getSuserid() {
		return suserid;
	}
	public void setSuserid(Integer suserid) {
		this.suserid = suserid;
	}
	public Integer getTask_assigned_by() {
		return task_assigned_by;
	}
	public void setTask_assigned_by(Integer task_assigned_by) {
		this.task_assigned_by = task_assigned_by;
	}
	public Integer getTask_assigned_to() {
		return task_assigned_to;
	}
	public void setTask_assigned_to(Integer task_assigned_to) {
		this.task_assigned_to = task_assigned_to;
	}
	public String getTasknumber() {
		return tasknumber;
	}
	public void setTasknumber(String tasknumber) {
		this.tasknumber = tasknumber;
	}

//	private String document_title;
//	private String related_document;


}
