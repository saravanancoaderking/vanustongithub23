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
@Table(name ="medc_sac_section" ,catalog = "medc_productmaster")
public class SacSectionCode implements Serializable {
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SacSectionid")
	private Integer id;
	private Integer SectionCode;
	private String SectionName;
	private Integer CountryId;
	private Integer Createdby;
	
	private Integer Status;

	public int getSacsectionid(){
		return id;
	}

	public void setSacsectionid(int SacSectionid){
		this.id=SacSectionid;
	}

	public int getSectioncode(){
		return SectionCode;
	}

	public void setSectioncode(int SectionCode){
		this.SectionCode=SectionCode;
	}

	public String getSectionname(){
		return SectionName;
	}

	public void setSectionname(String SectionName){
		this.SectionName=SectionName;
	}

	public int getCountryid(){
		return CountryId;
	}

	public void setCountryid(int CountryId){
		this.CountryId=CountryId;
	}

	public int getCreatedby(){
		return Createdby;
	}

	public void setCreatedby(int Createdby){
		this.Createdby=Createdby;
	}

	public int getStatus(){
		return Status;
	}

	public void setStatus(int Status){
		this.Status=Status;
	}

}
