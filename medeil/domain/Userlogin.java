package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_userlogin", catalog = "medc_adminsecurity")
public class Userlogin implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUserID")
	private Integer id;

	private String username;

	private String password;

	private Integer emprefid;

	private String isadmin;

	private String isactive;

	private Integer rolerefid;

	private Integer companyid;

	private Integer companyrefid;
	private Integer cuserrefid;

	private String usertype;

	private Integer distributorid;
	
	private long passwordvalidity;
	
	private int userloginattempt;
	
	private boolean isaccountnonlocked;
	
	private Long accountexpiry;
	
	private Integer customerid;
	
	private Integer branchid;
	
	private Integer shopid;

	private Integer planid;
	
	private Integer custtype;
	
	private String domainname;
	
	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public Integer getDistributorid() {
		return distributorid;
	}

	public void setDistributorid(Integer distributorid) {
		this.distributorid = distributorid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEmprefid() {
		return emprefid;
	}

	public void setEmprefid(Integer emprefid) {
		this.emprefid = emprefid;
	}

	public String getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public Integer getRolerefid() {
		return rolerefid;
	}

	public void setRolerefid(Integer rolerefid) {
		this.rolerefid = rolerefid;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getCuserrefid() {
		return cuserrefid;
	}

	public void setCuserrefid(Integer cuserrefid) {
		this.cuserrefid = cuserrefid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public long getPasswordvalidity() {
		return passwordvalidity;
	}

	public void setPasswordvalidity(long passwordvalidity) {
		this.passwordvalidity = passwordvalidity;
	}

	public int getUserloginattempt() {
		return userloginattempt;
	}

	public void setUserloginattempt(int userloginattempt) {
		this.userloginattempt = userloginattempt;
	}

	public boolean isIsaccountnonlocked() {
		return isaccountnonlocked;
	}

	public void setIsaccountnonlocked(boolean isaccountnonlocked) {
		this.isaccountnonlocked = isaccountnonlocked;
	}

	public Long getAccountexpiry() {
		return accountexpiry;
	}

	public void setAccountexpiry(Long accountexpiry) {
		this.accountexpiry = accountexpiry;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public Integer getPlanid() {
		return planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	public Integer getCusttype() {
		return custtype;
	}

	public void setCusttype(Integer custtype) {
		this.custtype = custtype;
	}

	public String getDomainname() {
		return domainname;
	}

	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

}
