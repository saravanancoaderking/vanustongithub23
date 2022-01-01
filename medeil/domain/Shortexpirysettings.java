package com.medeil.domain;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="medc_shortexpsettings", catalog ="medc_stock" )
public class Shortexpirysettings implements Serializable{
	private static final long serialVersionUID =1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="shortexpsetid")
		private int id;
		private int userid;
		private int no_days;
		private int no_month;
		private int no_year;
		private int expiryflag;
		private int companyrefid;
		private int branchrefid;
		private int locname;
		private int locrefid;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public int getNo_days() {
			return no_days;
		}
		public void setNo_days(int no_days) {
			this.no_days = no_days;
		}
		public int getNo_month() {
			return no_month;
		}
		public void setNo_month(int no_month) {
			this.no_month = no_month;
		}
		public int getNo_year() {
			return no_year;
		}
		public void setNo_year(int no_year) {
			this.no_year = no_year;
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
		public int getExpiryflag() {
			return expiryflag;
		}
		public void setExpiryflag(int expiryflag) {
			this.expiryflag = expiryflag;
		}

		
	}

