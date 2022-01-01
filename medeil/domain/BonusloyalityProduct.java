package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author DesingRaja
 *
 */
@Entity
@Table(name = "medc_blproduct",catalog = "medc_loyality")
public class BonusloyalityProduct implements Serializable{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="bl_product_id")
		private int id;
		private int blrefid;
		private int produc_code;
		private int dummy1;
		private int companyrefid;
		private int branchrefid;
		private int locname;
		private int locrefid;
		private int status;

		public int getBl_product_id(){
			return id;
		}

		public void setBl_product_id(int bl_product_id){
			this.id=bl_product_id;
		}

		public int getBlrefid(){
			return blrefid;
		}

		public void setBlrefid(int blrefid){
			this.blrefid=blrefid;
		}

		public int getProduc_code(){
			return produc_code;
		}

		public void setProduc_code(int produc_code){
			this.produc_code=produc_code;
		}

		public int getDummy1(){
			return dummy1;
		}

		public void setDummy1(int dummy1){
			this.dummy1=dummy1;
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
	

}
