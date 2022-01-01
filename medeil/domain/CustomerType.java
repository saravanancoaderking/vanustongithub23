package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javassist.SerialVersionUID;

@Entity
@Table(name="medc_cust_type" ,catalog="medc_loyality")
/**
 * 
 * @param DesingRaja
 */
public class CustomerType implements Serializable {
	private static final long SerialVersionUID=1L;	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="cust_type_id")
		private int Id;
		private String cust_type;
		private int min_loyality;
		private int min_amount;
		private String clientcdate;
		private int companyrefid;
		private int branchrefid;
		private int locname;
		private int locrefid;
		private int status;

		public int getCust_type_id(){
			return Id;
		}

		public void setCust_type_id(int cust_type_id){
			this.Id=cust_type_id;
		}

		public String getCust_type(){
			return cust_type;
		}

		public void setCust_type(String cust_type){
			this.cust_type=cust_type;
		}

		public int getMin_loyality(){
			return min_loyality;
		}

		public void setMin_loyality(int min_loyality){
			this.min_loyality=min_loyality;
		}

		public int getMin_amount(){
			return min_amount;
		}

		public void setMin_amount(int min_amount){
			this.min_amount=min_amount;
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
		public String getClientcdate() {
			return clientcdate;
		}

		public void setClientcdate(String clientcdate) {
			this.clientcdate = clientcdate;
		}
	
}
