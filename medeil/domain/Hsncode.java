package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "medc_hsncodemaster", catalog = "medc_productmaster")
public class Hsncode implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "hsnid")
		private Integer id;
		
		private Integer chapter;
		
		private String hsncode;
		
		private String hsndescription;
		
		private Double gst;
		
		private Integer year;
			
	
		@Transient
		private Integer md_ref_id;
		@Transient
		private Integer id_ref_id;
		@Transient
		private Integer company_ref_id;
		@Transient
		private Integer drugproductid;
		@Transient
		private Integer vat;
		@Transient
		private Double ugst;
		@Transient
		private Double cgst;
		@Transient
		private Double sgst;
		@Transient
		private Double igst;
		@Transient
		private Integer brnch_ref_id;
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getMd_ref_id() {
			return md_ref_id;
		}

		public void setMd_ref_id(Integer md_ref_id) {
			this.md_ref_id = md_ref_id;
		}

		public Integer getId_ref_id() {
			return id_ref_id;
		}

		public void setId_ref_id(Integer id_ref_id) {
			this.id_ref_id = id_ref_id;
		}

		public Integer getCompany_ref_id() {
			return company_ref_id;
		}

		public void setCompany_ref_id(Integer company_ref_id) {
			this.company_ref_id = company_ref_id;
		}

		public Integer getBrnch_ref_id() {
			return brnch_ref_id;
		}

		public void setBrnch_ref_id(Integer brnch_ref_id) {
			this.brnch_ref_id = brnch_ref_id;
		}

		public Double getGst() {
			return gst;
		}

		public void setGst(Double gst) {
			this.gst = gst;
		}

		public Double getCgst() {
			return cgst;
		}

		public void setCgst(Double cgst) {
			this.cgst = cgst;
		}

		

		
		public Integer getVat() {
			return vat;
		}

		public void setVat(Integer vat) {
			this.vat = vat;
		}

		public Double getUgst() {
			return ugst;
		}

		public void setUgst(Double ugst) {
			this.ugst = ugst;
		}

		public Double getSgst() {
			return sgst;
		}

		public void setSgst(Double sgst) {
			this.sgst = sgst;
		}

		public Integer gethsn_assign_id(){
			return id;
		}

		public void sethsn_assign_id(Integer hsn_assign_id){
			this.id=hsn_assign_id;
		}

		public Integer getmd_ref_id(){
			return md_ref_id;
		}

		public void setmd_ref_id(Integer md_ref_id){
			this.md_ref_id=md_ref_id;
		}

		public Integer getid_ref_id(){
			return id_ref_id;
		}

		public void setid_ref_id(Integer id_ref_id){
			this.id_ref_id=id_ref_id;
		}

		public Integer getcompany_ref_id(){
			return company_ref_id;
		}

		public void setcompany_ref_id(Integer company_ref_id){
			this.company_ref_id=company_ref_id;
		}

		public Integer getbrnch_ref_id(){
			return brnch_ref_id;
		}

		public void setbrnch_ref_id(Integer brnch_ref_id){
			this.brnch_ref_id=brnch_ref_id;
		}

		public Integer getDrugproductid() {
			return drugproductid;
		}

		public void setDrugproductid(Integer drugproductid) {
			this.drugproductid = drugproductid;
		}

		public Double getIgst() {
			return igst;
		}

		public void setIgst(Double igst) {
			this.igst = igst;
		}

		public Integer getYear() {
			return year;
		}

		public void setYear(Integer year) {
			this.year = year;
		}

		public Integer getChapter() {
			return chapter;
		}

		public void setChapter(Integer chapter) {
			this.chapter = chapter;
		}

		public String getHsncode() {
			return hsncode;
		}

		public void setHsncode(String hsncode) {
			this.hsncode = hsncode;
		}

		public String getHsndescription() {
			return hsndescription;
		}

		public void setHsndescription(String hsndescription) {
			this.hsndescription = hsndescription;
		}

		
	
}
