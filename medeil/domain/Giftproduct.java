package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author DesingRaja
 *
 */
@Entity
@Table(name = "gift_products", catalog = "medc_loyality")
public class Giftproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gift_product_id")
	private int id;
	private String giftproductname;
	private int companyrefid;
	private int branchrefid;
	private int locname;
	private int locrefid;
	private int status;

	public int getGift_product_id() {
		return id;
	}

	public void setGift_product_id(int gift_product_id) {
		this.id = gift_product_id;
	}

	public String getGiftproductname() {
		return giftproductname;
	}

	public void setGift_product_name(String giftproductname) {
		this.giftproductname = giftproductname;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
