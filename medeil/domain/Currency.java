/**
 * 
 */
package com.medeil.domain;

/**
 * @author Vanuston
 *
 */
public class Currency {
	
	private int countryrefid;
	private int companyrefid;
	private int currencyrefid;
	private String currencysymbol;
	private int createdby;
	private String createddate;
	private int modifiedby;
	private String modifieddate;

	public int getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(int countryrefid) {
		this.countryrefid = countryrefid;
	}

	public int getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}

	public int getCurrencyrefid() {
		return currencyrefid;
	}

	public void setCurrencyrefid(int currencyrefid) {
		this.currencyrefid = currencyrefid;
	}

	public String getCurrencysymbol() {
		return currencysymbol;
	}

	public void setCurrencysymbol(String currencysymbol) {
		this.currencysymbol = currencysymbol;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public int getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(int modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

}
