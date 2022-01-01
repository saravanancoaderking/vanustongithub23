package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "medc_usersessiontime" ,catalog="medc_adminsecurity")
public class Usersession  implements Serializable {
         private static final long serialVersionUID=1L;
       
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="usid")
     private Integer id;
     private Integer userid;
     private String logintime;
     private String logouttime;
     private String sessiontime;
     private Integer companyrefid;
     private Integer branchrefid;
     private Integer locname;
     private Integer locrefid;
     private String clientcdate;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public String getLogouttime() {
		return logouttime;
	}
	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}
	public String getSessiontime() {
		return sessiontime;
	}
	public void setSessiontime(String sessiontime) {
		this.sessiontime = sessiontime;
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
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
}
 