package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_setupcostsettings", catalog = "medc_globalsettings")
public class Setupcostsetting implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "setupcostid")
	private Integer id;
	
	private Integer opencashbalance;
	private Integer buildingcost;
	private Integer advleadsedeposit;
	private Integer regfee;
	private Integer electriclighting;
	private Integer furnishcarpentry;
	private Integer fridge;
	private Integer aircondition;
	private Integer displayboard;
	private Integer computerperipherals;
	private Integer others1;
	private Integer others2;
	private Integer others3;
	private Integer others4;
	private Integer others5;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private String createddate;
	private Integer status;
	private String modifieddate;
	private String clientcdate;
	private String clientmdate;
	private Integer totalsetupcost;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOpencashbalance() {
		return opencashbalance;
	}
	public void setOpencashbalance(Integer opencashbalance) {
		this.opencashbalance = opencashbalance;
	}
	public Integer getBuildingcost() {
		return buildingcost;
	}
	public void setBuildingcost(Integer buildingcost) {
		this.buildingcost = buildingcost;
	}
	public Integer getAdvleadsedeposit() {
		return advleadsedeposit;
	}
	public void setAdvleadsedeposit(Integer advleadsedeposit) {
		this.advleadsedeposit = advleadsedeposit;
	}
	public Integer getRegfee() {
		return regfee;
	}
	public void setRegfee(Integer regfee) {
		this.regfee = regfee;
	}
	public Integer getElectriclighting() {
		return electriclighting;
	}
	public void setElectriclighting(Integer electriclighting) {
		this.electriclighting = electriclighting;
	}
	public Integer getFurnishcarpentry() {
		return furnishcarpentry;
	}
	public void setFurnishcarpentry(Integer furnishcarpentry) {
		this.furnishcarpentry = furnishcarpentry;
	}
	public Integer getFridge() {
		return fridge;
	}
	public void setFridge(Integer fridge) {
		this.fridge = fridge;
	}
	public Integer getAircondition() {
		return aircondition;
	}
	public void setAircondition(Integer aircondition) {
		this.aircondition = aircondition;
	}
	public Integer getDisplayboard() {
		return displayboard;
	}
	public void setDisplayboard(Integer displayboard) {
		this.displayboard = displayboard;
	}
	public Integer getComputerperipherals() {
		return computerperipherals;
	}
	public void setComputerperipherals(Integer computerperipherals) {
		this.computerperipherals = computerperipherals;
	}
	public Integer getOthers1() {
		return others1;
	}
	public void setOthers1(Integer others1) {
		this.others1 = others1;
	}
	public Integer getOthers2() {
		return others2;
	}
	public void setOthers2(Integer others2) {
		this.others2 = others2;
	}
	public Integer getOthers3() {
		return others3;
	}
	public void setOthers3(Integer others3) {
		this.others3 = others3;
	}
	public Integer getOthers4() {
		return others4;
	}
	public void setOthers4(Integer others4) {
		this.others4 = others4;
	}
	public Integer getOthers5() {
		return others5;
	}
	public void setOthers5(Integer others5) {
		this.others5 = others5;
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
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public String getClientmdate() {
		return clientmdate;
	}
	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTotalsetupcost() {
		return totalsetupcost;
	}
	public void setTotalsetupcost(Integer totalsetupcost) {
		this.totalsetupcost = totalsetupcost;
	}
	
}
