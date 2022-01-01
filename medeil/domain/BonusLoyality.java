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
@Table(name="medc_bonus_loyality",catalog = "medc_loyality")
public class BonusLoyality implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bl_id")
		private int id;
		private String bonus_loyality;
		private String bl_reason;
		private int min_purchase_amt;
		private int discount_percent;
		private int discount_amount;
		private int customer_type;
		private String from_date;
		private String to_date;
		private String clientcdate;
		private int expiryflag;
		private int companyrefid;
		private int branchrefid;
		private int locname;
		private int locrefid;
		private int status;

		public int getBl_id(){
			return id;
		}

		public void setBl_id(int bl_id){
			this.id=bl_id;
		}

		public String getBonus_loyality(){
			return bonus_loyality;
		}

		public void setBonus_loyality(String bonus_loyality){
			this.bonus_loyality=bonus_loyality;
		}

		public String getBl_reason(){
			return bl_reason;
		}

		public void setBl_reason(String bl_reason){
			this.bl_reason=bl_reason;
		}

		public int getMin_purchase_amt(){
			return min_purchase_amt;
		}

		public void setMin_purchase_amt(int min_purchase_amt){
			this.min_purchase_amt=min_purchase_amt;
		}

		public int getDiscount_percent(){
			return discount_percent;
		}

		public void setDiscount_percent(int discount_percent){
			this.discount_percent=discount_percent;
		}

		public int getDiscount_amount(){
			return discount_amount;
		}

		public void setDiscount_amount(int discount_amount){
			this.discount_amount=discount_amount;
		}

		public int getCustomer_type(){
			return customer_type;
		}

		public void setCustomer_type(int customer_type){
			this.customer_type=customer_type;
		}

		public int getExpiryflag(){
			return expiryflag;
		}

		public void setExpiryflag(int expiryflag){
			this.expiryflag=expiryflag;
		}

		public int getCompanyrefid(){
			return companyrefid;
		}

		public void setCompanyrefid(int companyrefid){
			this.companyrefid=companyrefid;
		}

		public int getBranchrefid(){
			return branchrefid;
		}

		public void setBranchrefid(int branchrefid){
			this.branchrefid=branchrefid;
		}

		public int getLocname(){
			return locname;
		}

		public void setLocname(int locname){
			this.locname=locname;
		}

		public int getLocrefid(){
			return locrefid;
		}

		public void setLocrefid(int locrefid){
			this.locrefid=locrefid;
		}

		public int getStatus(){
			return status;
		}

		public void setStatus(int status){
			this.status=status;
		}

		public String getFrom_date() {
			return from_date;
		}

		public void setFrom_date(String from_date) {
			this.from_date = from_date;
		}

		public String getTo_date() {
			return to_date;
		}

		public void setTo_date(String to_date) {
			this.to_date = to_date;
		}

		public String getClientcdate() {
			return clientcdate;
		}

		public void setClientcdate(String clientcdate) {
			this.clientcdate = clientcdate;
		}
}
