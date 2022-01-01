package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_warehousetax", catalog = "medc_whstock")
public class StockIn implements Serializable {

	private static final long serialVersionUID = 1518718783030229497L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long wtaxID;

	public String unitsgst;

	public String unitcgst;

	public String unitigst;

	public String unitutgst;

	public String unitgst;

	public String sgstamt;

	public String cgstamt;

	public String igstamt;

	public String utgstamt;

	public String gstamt;

	public String vat;

	public String vatamt;

	public String wstockrefID;

	// mapping

	// @ManyToOne(fetch = FetchType.EAGER)
	// private Stocks stocks;
	//

	public long getWtaxID() {
		return wtaxID;
	}

	public void setWtaxID(long wtaxID) {
		this.wtaxID = wtaxID;
	}

	public String getUnitsgst() {
		return unitsgst;
	}

	public void setUnitsgst(String unitsgst) {
		this.unitsgst = unitsgst;
	}

	public String getUnitcgst() {
		return unitcgst;
	}

	public void setUnitcgst(String unitcgst) {
		this.unitcgst = unitcgst;
	}

	public String getUnitigst() {
		return unitigst;
	}

	public void setUnitigst(String unitigst) {
		this.unitigst = unitigst;
	}

	public String getUnitutgst() {
		return unitutgst;
	}

	public void setUnitutgst(String unitutgst) {
		this.unitutgst = unitutgst;
	}

	public String getUnitgst() {
		return unitgst;
	}

	public void setUnitgst(String unitgst) {
		this.unitgst = unitgst;
	}

	public String getSgstamt() {
		return sgstamt;
	}

	public void setSgstamt(String sgstamt) {
		this.sgstamt = sgstamt;
	}

	public String getCgstamt() {
		return cgstamt;
	}

	public void setCgstamt(String cgstamt) {
		this.cgstamt = cgstamt;
	}

	public String getIgstamt() {
		return igstamt;
	}

	public void setIgstamt(String igstamt) {
		this.igstamt = igstamt;
	}

	public String getUtgstamt() {
		return utgstamt;
	}

	public void setUtgstamt(String utgstamt) {
		this.utgstamt = utgstamt;
	}

	public String getGstamt() {
		return gstamt;
	}

	public void setGstamt(String gstamt) {
		this.gstamt = gstamt;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getVatamt() {
		return vatamt;
	}

	public void setVatamt(String vatamt) {
		this.vatamt = vatamt;
	}

	public String getWstockrefID() {
		return wstockrefID;
	}

	public void setWstockrefID(String wstockrefID) {
		this.wstockrefID = wstockrefID;
	}

	protected StockIn() {

	}

	public StockIn(String unitsgst, String unitcgst, String unitigst, String unitutgst, String unitgst, String sgstamt,
			String cgstamt, String igstamt, String utgstamt, String gstamt, String vat, String vatamt,
			String wstockrefID) {
		this.unitsgst = unitsgst;
		this.unitcgst = unitcgst;
		this.unitigst = unitigst;
		this.unitutgst = unitutgst;
		this.unitgst = unitgst;
		this.sgstamt = sgstamt;
		this.cgstamt = cgstamt;
		this.igstamt = igstamt;
		this.utgstamt = utgstamt;
		this.gstamt = gstamt;
		this.vat = vat;
		this.vatamt = vatamt;
		this.wstockrefID = wstockrefID;
	}

	@Override
	public String toString() {
		return String.format(
				"StockIn[wtaxID='%d',unitsgst='%s',unitcgst='%s',unitigst='%s',unitutgst='%s',unitgst='%s',sgstamt='%s',cgstamt='%s',igstamt='%s',utgstamt='%s',gstamt='%s',vat='%s',vatamt='%s',wstockrefID='%d']",
				unitsgst, unitcgst, unitigst, unitutgst, unitgst, sgstamt, cgstamt, igstamt, utgstamt, gstamt, vat,
				vatamt, wstockrefID);
	}

}
