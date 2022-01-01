package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "medc_stockchecking" ,catalog="medc_sales")
public class MedcStockchecking implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer dgid;  
	 private String uniformproductcode;
	 private Integer requiredquantity;
	 private int availablequantity;
	 private String drugname;
	/**
	 * @return the dgid
	 */
	public Integer getDgid() {
		return dgid;
	}
	/**
	 * @param dgid the dgid to set
	 */
	public void setDgid(Integer dgid) {
		this.dgid = dgid;
	}
	/**
	 * @return the uniformproductcode
	 */
	public String getUniformproductcode() {
		return uniformproductcode;
	}
	/**
	 * @param uniformproductcode the uniformproductcode to set
	 */
	public void setUniformproductcode(String uniformproductcode) {
		this.uniformproductcode = uniformproductcode;
	}
	/**
	 * @return the requiredquantity
	 */
	public Integer getRequiredquantity() {
		return requiredquantity;
	}
	/**
	 * @param requiredquantity the requiredquantity to set
	 */
	public void setRequiredquantity(Integer requiredquantity) {
		this.requiredquantity = requiredquantity;
	}
	/**
	 * @return the availablequantity
	 */
	public int getAvailablequantity() {
		return availablequantity;
	}
	/**
	 * @param availablequantity the availablequantity to set
	 */
	public void setAvailablequantity(int availablequantity) {
		this.availablequantity = availablequantity;
	}
	/**
	 * @return the drugname
	 */
	public String getDrugname() {
		return drugname;
	}
	/**
	 * @param drugname the drugname to set
	 */
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	@Override
	public String toString() {
		return "MedcStockchecking [dgid=" + dgid + ", uniformproductcode=" + uniformproductcode + ", requiredquantity="
				+ requiredquantity + ", availablequantity=" + availablequantity + ", drugname=" + drugname + "]";
	}
	
}	
	