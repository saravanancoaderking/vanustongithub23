package com.medeil.domain;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_sac_group",catalog = "medc_productmaster")
public class SacGroup implements Serializable{
	
	public static final long serialVersionUIT=1L;	
	
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
@Column(name="SACGroupId")

		private Integer id;
		private Integer GroupCode;
		private String GroupName;
		private Integer sectionid;
		private Integer CountryId;
		private String createdby;
		private int Status;

		public int getSacgroupid(){
			return id;
		}

		public void setSacgroupid(int SACGroupId){
			this.id=SACGroupId;
		}

		public int getGroupcode(){
			return GroupCode;
		}

		public void setGroupcode(int GroupCode){
			this.GroupCode=GroupCode;
		}

		public String getGroupname(){
			return GroupName;
		}

		public void setGroupname(String GroupName){
			this.GroupName=GroupName;
		}

		public int getSectionid(){
			return sectionid;
		}

		public void setSectionid(int sectionid){
			this.sectionid=sectionid;
		}

		public int getCountryid(){
			return CountryId;
		}

		public void setCountryid(int CountryId){
			this.CountryId=CountryId;
		}

		public String getCreatedby(){
			return createdby;
		}

		public void setCreatedby(String createdby){
			this.createdby=createdby;
		}

		public int getStatus(){
			return Status;
		}

		public void setStatus(int Status){
			this.Status=Status;
		}
	
}
