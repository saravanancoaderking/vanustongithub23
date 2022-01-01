package com.medeil.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "medc_indentreqperm", catalog = "medc_indentmaster")
public class IndentConfirm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "indentreqid")
	private int id;

	private Double indrefid;


	private String clientcdate;
	private String clientcdate1;
	
	private Double createdby;
	private Double locrefid;
	private Double locname;

	private String indapprno;
	
	private Integer fromlocname;
	private Integer fromlocrefid;
	private Integer tolocname;
	private Integer tolocrefid;
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	private String namefromlocname;
	private String namefromlocrefid;
	private String nametolocname;
	private String nametolocrefid;
	
	//Sivakumar-06/02/2020,For Single API(JPA)
//	@JsonManagedReference
//	@OneToMany(mappedBy = "stockTransfer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Set<StockTrnfrProd> stktransfer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getIndrefid() {
		return indrefid;
	}
	public void setIndrefid(Double indrefid) {
		this.indrefid = indrefid;
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
	public Double getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Double createdby) {
		this.createdby = createdby;
	}
	public Double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}
	public Double getLocname() {
		return locname;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public String getIndapprno() {
		return indapprno;
	}
	public void setIndapprno(String indapprno) {
		this.indapprno = indapprno;
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
	
	
	
	
	
	
	
	
	
	
	
	
}
