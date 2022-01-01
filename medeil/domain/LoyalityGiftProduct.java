package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medc_lgiftproduct",catalog = "medc_loyality")
public class LoyalityGiftProduct  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "lgiftprod_id")
	
		private long id;
		private int loyality_typeid;
		private int min_gift_point;
		private String gift_code;
		private int gift_product_id;
		private int gift_Product_qty;
		private int product_value;
		private String remarks;
		private int companyrefid;
		private int branchrefid;
		private int locname;
		private int locrefid;
		private int status;
		private String clientcdate;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public int getLoyality_typeid() {
			return loyality_typeid;
		}
		public void setLoyality_typeid(int loyality_typeid) {
			this.loyality_typeid = loyality_typeid;
		}
		public int getMin_gift_point() {
			return min_gift_point;
		}
		public void setMin_gift_point(int min_gift_point) {
			this.min_gift_point = min_gift_point;
		}
		public String getGift_code() {
			return gift_code;
		}
		public void setGift_code(String gift_code) {
			this.gift_code = gift_code;
		}
		public int getGift_product_name() {
			return gift_product_id;
		}
		public void setGift_product_name(int gift_product_name) {
			this.gift_product_id = gift_product_name;
		}
		public int getGift_Product_qty() {
			return gift_Product_qty;
		}
		public void setGift_Product_qty(int gift_Product_qty) {
			this.gift_Product_qty = gift_Product_qty;
		}
		public int getProduct_value() {
			return product_value;
		}
		public void setProduct_value(int product_value) {
			this.product_value = product_value;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
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
		public String getClientcdate() {
			return clientcdate;
		}
		public void setClientcdate(String clientcdate) {
			this.clientcdate = clientcdate;
		}

		
}
