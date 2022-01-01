package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_hsn_idescription " ,catalog = "medc_productmaster")
public class Hsn_id {
	private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		@Column(name="hsn_id")
		private int id;
		private int mdref_id;
		private String item_description;
		private String hsn_code;
		private int gst;
		

		private int country_id;
		private String year;
		private String business_type;
		private String amendment;
		private int companyrefid;
		private int branchrefid;
		private int locname;
		private int locrefid;

		public int gethsn_id(){
			return id;
		}

		public void sethsn_id(int hsn_id){
			this.id=hsn_id;
		}
		public int getGst() {
			return gst;
		}

		public void setGst(int gst) {
			this.gst = gst;
		}
		public int getmdref_id(){
			return mdref_id;
		}

		public void setmdref_id(int mdref_id){
			this.mdref_id=mdref_id;
		}

		public String getitem_description(){
			return item_description;
		}

		public void setitem_description(String item_description){
			this.item_description=item_description;
		}

		public String gethsn_code(){
			return hsn_code;
		}

		public void sethsn_code(String hsn_code){
			this.hsn_code=hsn_code;
		}

		public int getcountry_id(){
			return country_id;
		}

		public void setcountry_id(int country_id){
			this.country_id=country_id;
		}

		public String getyear(){
			return year;
		}

		public void setyear(String year){
			this.year=year;
		}

		public String getbusiness_type(){
			return business_type;
		}

		public void setbusiness_type(String business_type){
			this.business_type=business_type;
		}

		public String getamendment(){
			return amendment;
		}

		public void setamendment(String amendment){
			this.amendment=amendment;
		}

		public int getcompanyrefid(){
			return companyrefid;
		}

		public void setcompanyrefid(int companyrefid){
			this.companyrefid=companyrefid;
		}

		public int getbranchrefid(){
			return branchrefid;
		}

		public void setbranchrefid(int branchrefid){
			this.branchrefid=branchrefid;
		}

		public int getlocname(){
			return locname;
		}

		public void setlocname(int locname){
			this.locname=locname;
		}

		public int getlocrefid(){
			return locrefid;
		}

		public void setlocrefid(int locrefid){
			this.locrefid=locrefid;
		}
	
}
