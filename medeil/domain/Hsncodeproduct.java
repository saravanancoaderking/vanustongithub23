package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


public class Hsncodeproduct implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private Integer id;
//		private Integer md_ref_id;
//		private Integer id_ref_id;
//		private Integer company_ref_id;
		private Integer drugproductid;
		private String gst;
		private String vat;
		private String ugst;
		private String cgst;
		private String sgst;
		private String igst;
		private Integer brnch_ref_id;
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getDrugproductid() {
			return drugproductid;
		}

		public void setDrugproductid(Integer drugproductid) {
			this.drugproductid = drugproductid;
		}

		public String getGst() {
			return gst;
		}

		public void setGst(String gst) {
			this.gst = gst;
		}

		public String getVat() {
			return vat;
		}

		public void setVat(String vat) {
			this.vat = vat;
		}

		public String getUgst() {
			return ugst;
		}

		public void setUgst(String ugst) {
			this.ugst = ugst;
		}

		public String getCgst() {
			return cgst;
		}

		public void setCgst(String cgst) {
			this.cgst = cgst;
		}

		public String getSgst() {
			return sgst;
		}

		public void setSgst(String sgst) {
			this.sgst = sgst;
		}

		public String getIgst() {
			return igst;
		}

		public void setIgst(String igst) {
			this.igst = igst;
		}

		public Integer getBrnch_ref_id() {
			return brnch_ref_id;
		}

		public void setBrnch_ref_id(Integer brnch_ref_id) {
			this.brnch_ref_id = brnch_ref_id;
		}


}
