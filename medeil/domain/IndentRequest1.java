package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_indentreq", catalog = "medc_indentmaster")
public class IndentRequest1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "indentreqid")
	private int id;

	private Integer fromlocname;
	private Integer fromlocrefid;
	private Integer tolocname;
	private Integer tolocrefid;

	

	private String indentno;

	private String clientcdate;
	private String clientcdate1;

	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locrefid;
	private Integer locname;

	private String namefromlocname;
	private String namefromlocrefid;
	private String nametolocname;
	private String nametolocrefid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getFromlocname() {
		return fromlocname;
	}

	public void setFromlocname(Integer fromlocname) {
		this.fromlocname = fromlocname;
	}

	public Integer getFromlocrefid() {
		return fromlocrefid;
	}

	public void setFromlocrefid(Integer fromlocrefid) {
		this.fromlocrefid = fromlocrefid;
	}

	public Integer getTolocname() {
		return tolocname;
	}

	public void setTolocname(Integer tolocname) {
		this.tolocname = tolocname;
	}

	public Integer getTolocrefid() {
		return tolocrefid;
	}

	public void setTolocrefid(Integer tolocrefid) {
		this.tolocrefid = tolocrefid;
	}

	public String getIndentno() {
		return indentno;
	}

	public void setIndentno(String indentno) {
		this.indentno = indentno;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getClientcdate1() {
		return clientcdate1;
	}

	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
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

	public String getNamefromlocname() {
		return namefromlocname;
	}

	public void setNamefromlocname(String namefromlocname) {
		this.namefromlocname = namefromlocname;
	}

	public String getNamefromlocrefid() {
		return namefromlocrefid;
	}

	public void setNamefromlocrefid(String namefromlocrefid) {
		this.namefromlocrefid = namefromlocrefid;
	}

	public String getNametolocname() {
		return nametolocname;
	}

	public void setNametolocname(String nametolocname) {
		this.nametolocname = nametolocname;
	}

	public String getNametolocrefid() {
		return nametolocrefid;
	}

	public void setNametolocrefid(String nametolocrefid) {
		this.nametolocrefid = nametolocrefid;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

}
