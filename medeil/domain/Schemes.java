package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_schemesandrewards", catalog = "medc_patientreg")
public class Schemes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schemeid")
	private int id;
	private String scheme_name;
	private String scheme_start_date;
	private String scheme_end_date;
	private Double min_amt_equivalent_point;
	private Double equivalent_point;
	private Double reward_type;
	private Double cash_discount;
	private Double min_reward_point;
	private Double level1_reward_point;
	private Double level1_gift_name;

	private Double is_active;

	private String clientcdate;
	private String clientcdate1;


	private Double locname;
	private Double locrefid;
	private String  schemeno;


	private Double calcflag;

	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getScheme_name() {
		return scheme_name;
	}


	public void setScheme_name(String scheme_name) {
		this.scheme_name = scheme_name;
	}




	public Double getMin_amt_equivalent_point() {
		return min_amt_equivalent_point;
	}


	public void setMin_amt_equivalent_point(Double min_amt_equivalent_point) {
		this.min_amt_equivalent_point = min_amt_equivalent_point;
	}


	public Double getEquivalent_point() {
		return equivalent_point;
	}


	public void setEquivalent_point(Double equivalent_point) {
		this.equivalent_point = equivalent_point;
	}


	public Double getReward_type() {
		return reward_type;
	}


	public void setReward_type(Double reward_type) {
		this.reward_type = reward_type;
	}


	public Double getCash_discount() {
		return cash_discount;
	}


	public void setCash_discount(Double cash_discount) {
		this.cash_discount = cash_discount;
	}


	public Double getMin_reward_point() {
		return min_reward_point;
	}


	public void setMin_reward_point(Double min_reward_point) {
		this.min_reward_point = min_reward_point;
	}


	public Double getLevel1_reward_point() {
		return level1_reward_point;
	}


	public void setLevel1_reward_point(Double level1_reward_point) {
		this.level1_reward_point = level1_reward_point;
	}


	public Double getLevel1_gift_name() {
		return level1_gift_name;
	}


	public void setLevel1_gift_name(Double level1_gift_name) {
		this.level1_gift_name = level1_gift_name;
	}


	public Double getIs_active() {
		return is_active;
	}


	public void setIs_active(Double is_active) {
		this.is_active = is_active;
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


	public Double getLocname() {
		return locname;
	}


	public void setLocname(Double locname) {
		this.locname = locname;
	}


	public Double getLocrefid() {
		return locrefid;
	}


	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}





	public Double getCalcflag() {
		return calcflag;
	}


	public void setCalcflag(Double calcflag) {
		this.calcflag = calcflag;
	}


	public String getSchemeno() {
		return schemeno;
	}


	public void setSchemeno(String schemeno) {
		this.schemeno = schemeno;
	}


	public String getScheme_start_date() {
		return scheme_start_date;
	}


	public void setScheme_start_date(String scheme_start_date) {
		this.scheme_start_date = scheme_start_date;
	}


	public String getScheme_end_date() {
		return scheme_end_date;
	}


	public void setScheme_end_date(String scheme_end_date) {
		this.scheme_end_date = scheme_end_date;
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
	
	
	
	
	
	
	
	
	
	
	

}
