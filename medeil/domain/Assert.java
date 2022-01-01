/**
 * 
 */
package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author www
 *
 */

@Entity
@Table(name = "medc_generalassert", catalog = "medc_accounts")
public class Assert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private int accountrefid;
	private String accountname;
	private double cash_inhand;
	private double cash_inbank;
	private double vehicle;
	private double furniture;
	private int v_depreciation;
	private int f_depreciatuon;
	private String other_description;
	private double others;
	private int others_depreciation;
	private double totamount;
	private int createdby;
	private java.util.Date createddate;
	private int modifiedby;
	private java.util.Date modifieddate;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private int calcflag;

	public int getAccountrefid() {
		return accountrefid;
	}

	public void setAccountrefid(int accountrefid) {
		this.accountrefid = accountrefid;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public double getCash_inhand() {
		return cash_inhand;
	}

	public void setCash_inhand(double cash_inhand) {
		this.cash_inhand = cash_inhand;
	}

	public double getCash_inbank() {
		return cash_inbank;
	}

	public void setCash_inbank(double cash_inbank) {
		this.cash_inbank = cash_inbank;
	}

	public double getVehicle() {
		return vehicle;
	}

	public void setVehicle(double vehicle) {
		this.vehicle = vehicle;
	}

	public double getFurniture() {
		return furniture;
	}

	public void setFurniture(double furniture) {
		this.furniture = furniture;
	}

	public int getV_depreciation() {
		return v_depreciation;
	}

	public void setV_depreciation(int v_depreciation) {
		this.v_depreciation = v_depreciation;
	}

	public int getF_depreciatuon() {
		return f_depreciatuon;
	}

	public void setF_depreciatuon(int f_depreciatuon) {
		this.f_depreciatuon = f_depreciatuon;
	}

	public String getOther_description() {
		return other_description;
	}

	public void setOther_description(String other_description) {
		this.other_description = other_description;
	}

	public double getOthers() {
		return others;
	}

	public void setOthers(double others) {
		this.others = others;
	}

	public int getOthers_depreciation() {
		return others_depreciation;
	}

	public void setOthers_depreciation(int others_depreciation) {
		this.others_depreciation = others_depreciation;
	}

	public double getTotamount() {
		return totamount;
	}

	public void setTotamount(double totamount) {
		this.totamount = totamount;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public java.util.Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(java.util.Date createddate) {
		this.createddate = createddate;
	}

	public int getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}

	public java.util.Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(java.util.Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public int getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}

	public int getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(int branchrefid) {
		this.branchrefid = branchrefid;
	}

	public int getLocname() {
		return locname;
	}

	public void setLocname(int locname) {
		this.locname = locname;
	}

	public int getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(int locrefid) {
		this.locrefid = locrefid;
	}

	public int getCalcflag() {
		return calcflag;
	}

	public void setCalcflag(int calcflag) {
		this.calcflag = calcflag;
	}

}
