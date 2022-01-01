package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_taskmanager", catalog = "medc_globalsettings")
public class TaskManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tskmgautoid")
	private int id;


	
	private Integer tskmgid;
	private String tskmgno;
	private Double employeerefid;
	private Double managerrefid;
	private Double tasktype;
	private String taskdesc;
	private String startdate;
	private String endate;
	private String priority;
	private String createddate;
	private Double status;

	private Double locname;
	private Double locrefid;
	private String clientcdate1;
	private Double calcflag;
	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Double getEmployeerefid() {
		return employeerefid;
	}
	public void setEmployeerefid(Double employeerefid) {
		this.employeerefid = employeerefid;
	}
	public Double getManagerrefid() {
		return managerrefid;
	}
	public void setManagerrefid(Double managerrefid) {
		this.managerrefid = managerrefid;
	}
	public Double getTasktype() {
		return tasktype;
	}
	public void setTasktype(Double tasktype) {
		this.tasktype = tasktype;
	}
	public String getTaskdesc() {
		return taskdesc;
	}
	public void setTaskdesc(String taskdesc) {
		this.taskdesc = taskdesc;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEndate() {
		return endate;
	}
	public void setEndate(String endate) {
		this.endate = endate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public Double getStatus() {
		return status;
	}
	public void setStatus(Double status) {
		this.status = status;
	}
	public Double getLocname() {
		return locname;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public Double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}
	public String getClientcdate1() {
		return clientcdate1;
	}
	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}
	public Double getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Double calcflag) {
		this.calcflag = calcflag;
	}
	public Integer getTskmgid() {
		return tskmgid;
	}
	public void setTskmgid(Integer tskmgid) {
		this.tskmgid = tskmgid;
	}
	public String getTskmgno() {
		return tskmgno;
	}
	public void setTskmgno(String tskmgno) {
		this.tskmgno = tskmgno;
	}
	public Integer getCountryrefid() {
		return countryrefid;
	}
	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
