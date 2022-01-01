package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medc_generalassert", catalog = "medc_accounts")
public class generalAssert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private Integer accountrefid;
	private String accountname;
	private double cash_inhand;
	private double cash_inbank;
	private double vehicle;
	private double furniture;
	private Integer v_depreciation;
	private Integer f_depreciatuon;
	private String other_description;
	private double others;
	private Integer others_depreciation;
	private double totamount;
	private Integer createdby;

	private Integer modifiedby;

	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private Integer calcflag;
	private Integer patent_depreciation;
	private Integer patent;
	private Integer cash_inhandepreciation;
	private Integer cash_inbankdepreciation;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Integer getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public void setAccountrefid(Integer accountrefid) {
		this.accountrefid = accountrefid;
	}

	public void setV_depreciation(Integer v_depreciation) {
		this.v_depreciation = v_depreciation;
	}

	public void setF_depreciatuon(Integer f_depreciatuon) {
		this.f_depreciatuon = f_depreciatuon;
	}

	public void setOthers_depreciation(Integer others_depreciation) {
		this.others_depreciation = others_depreciation;
	}

	public void setBranchrefid(Integer branchrefid) {
		this.branchrefid = branchrefid;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
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

	public Integer getPatent_depreciation() {
		return patent_depreciation;
	}

	public void setPatent_depreciation(Integer patent_depreciation) {
		this.patent_depreciation = patent_depreciation;
	}

	public Integer getPatent() {
		return patent;
	}

	public void setPatent(Integer patent) {
		this.patent = patent;
	}

	public Integer getCash_inhandepreciation() {
		return cash_inhandepreciation;
	}

	public void setCash_inhandepreciation(Integer cash_inhandepreciation) {
		this.cash_inhandepreciation = cash_inhandepreciation;
	}

	public Integer getCash_inbankdepreciation() {
		return cash_inbankdepreciation;
	}

	public void setCash_inbankdepreciation(Integer cash_inbankdepreciation) {
		this.cash_inbankdepreciation = cash_inbankdepreciation;
	}

}
