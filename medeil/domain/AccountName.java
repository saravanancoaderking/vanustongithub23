package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "medc_accountname", catalog = "medc_accounts")
public class AccountName  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accnameautoid")
	private Integer id;
	private String accountname;
	private Integer acctyperefid;
	private Integer accstandardid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public Integer getAcctyperefid() {
		return acctyperefid;
	}
	public void setAcctyperefid(Integer acctyperefid) {
		this.acctyperefid = acctyperefid;
	}
	public Integer getAccstandardid() {
		return accstandardid;
	}
	public void setAccstandardid(Integer accstandardid) {
		this.accstandardid = accstandardid;
	}
}
