package com.medeil.domain;

/*************************************************************************
 * 
 * Vanuston CONFIDENTIAL
 * __________________
 * 
 *  [2009] - [2019] Vanuston Intelligence Pvt.Ltd  
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Vanuston Intelligence Pvt.Ltd and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Vanuston Intelligence Pvt.Ltd
 * and its suppliers and may be covered by Indian and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Vanuston Intelligence Pvt.Ltd.
 */
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author Boopalan Alagesan
 * @Date 01-12-2019
 *
 */
@Entity
@Table(name = "medc_userlogin", catalog = "medc_adminsecurity")
public class Medc_Userlogin implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "suserid")
	private Integer id;
	private String username;
	private String password;
	private String usertype;
	private Integer emprefid;
	private String isadmin;

	private String isactive;
	private String lastvisitip;

	private Integer roleid;

	private int cuserrefid;
	private Integer companyid;
	private Integer distributorid;
	private Integer companyrefid;
	private long passwordvalidity;
	private int userloginattempt;
	private boolean isaccountnonlocked;
	private long loginstatus;
	private Integer branchid;
	private Integer shopid;
	private Integer planid;
	private Integer custtype;
	private Integer storetype;

	

	// @ManyToMany(cascade = { CascadeType.ALL })
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "medc_adduser", joinColumns = {
			@JoinColumn(name = "CUserID", referencedColumnName = "cuserrefid") }, inverseJoinColumns = {
					@JoinColumn(name = "rolerefid", referencedColumnName = "roleid") })

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
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

	public String getLastvisitip() {
		return lastvisitip;
	}

	public void setLastvisitip(String lastvisitip) {
		this.lastvisitip = lastvisitip;
	}

//	public Integer getRolerefid() {
//		return rolerefid;
//	}
//
//	public void setRolerefid(Integer rolerefid) {
//		this.rolerefid = rolerefid;
//	}

	public int getCuserrefid() {
		return cuserrefid;
	}

	public void setCuserrefid(int cuserrefid) {
		this.cuserrefid = cuserrefid;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getDistributorid() {
		return distributorid;
	}

	public void setDistributorid(Integer distributorid) {
		this.distributorid = distributorid;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub

		return this.isaccountnonlocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public int getUserloginattempt() {
		return userloginattempt;
	}

	public void setUserloginattempt(int userloginattempt) {
		this.userloginattempt = userloginattempt;
	}

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isaccountnonlocked = isAccountNonLocked;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getPasswordvalidity() {
		return passwordvalidity;
	}

	public void setPasswordvalidity(long passwordvalidity) {
		this.passwordvalidity = passwordvalidity;
	}

	public long getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(long loginstatus) {
		this.loginstatus = loginstatus;
	}

	public boolean isIsaccountnonlocked() {
		return isaccountnonlocked;
	}

	public void setIsaccountnonlocked(boolean isaccountnonlocked) {
		this.isaccountnonlocked = isaccountnonlocked;
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

	public Integer getStoretype() {
		return storetype;
	}

	public void setCusttype(Integer custtype) {
		this.custtype = custtype;
	}

	public void setStoretype(Integer storetype) {
		this.storetype = storetype;
	}

}
