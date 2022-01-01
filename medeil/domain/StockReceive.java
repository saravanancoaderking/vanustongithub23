package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "medc_stockreceive"    ,catalog="medc_stock")
public class StockReceive {
	
	
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stkrecid")
    private int  id    ;
	

	private Date receivedate  ;
	private Integer totalproduct ;
	private Integer totalqty ;
	private Integer totalboxqty  ;
	private Integer totalstripqty ;
	private Integer totaltabqty  ;
	
	
	
	
	private  Double   locrefid;  
	private  Double   locname  ;
	
	private  Double   indrefid  ;
	private  Double   stktransrefid  ;
	
	private   String   stkrecno  ;
	
	private String clientcdate;
	
	private String clientcdate1;
	
	
	private Integer fromlocname;
	private Integer fromlocrefid;
	private Integer tolocname;
	private Integer tolocrefid;
	
	private  Integer   calcflag  ;	
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	
	
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
	public Date getReceivedate() {
		return receivedate;
	}
	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}
	public Integer getTotalproduct() {
		return totalproduct;
	}
	public void setTotalproduct(Integer totalproduct) {
		this.totalproduct = totalproduct;
	}
	public Integer getTotalqty() {
		return totalqty;
	}
	public void setTotalqty(Integer totalqty) {
		this.totalqty = totalqty;
	}
	public Integer getTotalboxqty() {
		return totalboxqty;
	}
	public void setTotalboxqty(Integer totalboxqty) {
		this.totalboxqty = totalboxqty;
	}
	public Integer getTotalstripqty() {
		return totalstripqty;
	}
	public void setTotalstripqty(Integer totalstripqty) {
		this.totalstripqty = totalstripqty;
	}
	public Integer getTotaltabqty() {
		return totaltabqty;
	}
	public void setTotaltabqty(Integer totaltabqty) {
		this.totaltabqty = totaltabqty;
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
	public Double getIndrefid() {
		return indrefid;
	}
	public void setIndrefid(Double indrefid) {
		this.indrefid = indrefid;
	}
	public Double getStktransrefid() {
		return stktransrefid;
	}
	public void setStktransrefid(Double stktransrefid) {
		this.stktransrefid = stktransrefid;
	}
	public String getStkrecno() {
		return stkrecno;
	}
	public void setStkrecno(String stkrecno) {
		this.stkrecno = stkrecno;
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
	public Integer getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
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
