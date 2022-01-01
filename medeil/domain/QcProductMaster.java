package com.medeil.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_qc_custproductmaster", catalog = "medc_productmaster")
public class QcProductMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qcproductdrugid;
	private String brandname;
	private Integer genericid;
	private String uniformproductcode;
	private Integer genericcombinationid;
	private String genericnamedosage;
	private String uom;
	private Integer therapeuticid;
	private Integer subtherapeuticid;
	private Double vat;
	private Double gst;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private Double utgst;
	private Integer formulationid;
	private String schudletype;
	private Double mrp;
	private Double minqty;
	private Double maxqty;
	private Double boxpercartoon;
	private Double stripperbox;
	private Double quantityperstrip;
	private String banneddrug;
	private String productregno;
	private Integer distimporterid;
	private String banneddrugreason;
	private Integer companyid;
	private Integer branchid;
	private Integer locname;
	private String hsnid;
	private Integer vanustonproductdrugid;
	private Integer pharmacompanyid;
	private Integer verticalid;
	private Integer drugstatus;
	private Integer countryid;

	// drug entity attr
	private byte[] photos;
	private Integer custflag;
	private String drugbannedfrom;
	private String temperature;
	private String emergency_type;
	private String production_sunlight;
	private String stock_available;
	private String sanitizing;
	private String narcoticdrug;
	private String hanzoration_drug;
	private String coldstorage;

	private String generic_name;
	private Integer locrefid;
	private Integer qcStatus;

	private Date CreatedDate;
	private Date ModifiedDate;
	private Integer ModifiedBy;
	private Integer CreatedBy;

//	private String productsource;
//	private String drugtype;
//	private String patterntype;
//	private Integer categoryid;
//	private Integer subcategoryid;
//	private String dbccode;
//	private String scccode;
//	private String sccdesc;
//	private String divisionid;
//	private String allergiccondition;
//	private String pharmclass;
//	private String quantity;
//	private String perpackage;
//	private String perbox;
//	private Double srp_w_vat;
//	private Double srp_wout_vat;
//	private Double arp;
//	private Double awp;
//	private Double mac;
//	private Double ger;
//	private Double oger;
//	private String drugstandard;
//	private String shortform;
//	private String verified;
//	private String rootofadministration;
//	private Integer createdby;
//	private Integer modifiedby;
//	private Integer insuranceid;
//	private Integer dummy4;
//	private Integer dummy5;
//	private Integer dummy6;
//	private String diseases;
//	private Integer locrefid;
//	private String packaging_description;
//	private String validity;
//	private String product;
//	private String interchangeability;
//	private String pfdaregistration;
//	private String priceper;
//	private Double srp;
//	private String vhelpcode;
//	private Integer subcategory2;
//	private String formaulationshort;
//	private String manufactureshort;
//	private Integer countryrefid;
//	private String remarks;
//	private Integer group_id;
//	private Integer sub_group_1;
//	private Integer sub_group_2;
//	private String vatidentity;
//	private Integer lastupdatedtimetick;
//	private String image_filename;
//	private Integer sub_group_id_1;
//	private Integer productdrugid;
//	private Integer qaflag;
//	private Integer qaproductdrugid;

	public Integer getQcproductdrugid() {
		return qcproductdrugid;
	}

	public void setQcproductdrugid(Integer qcproductdrugid) {
		this.qcproductdrugid = qcproductdrugid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Integer getGenericid() {
		return genericid;
	}

	public void setGenericid(Integer genericid) {
		this.genericid = genericid;
	}

	public String getUniformproductcode() {
		return uniformproductcode;
	}

	public void setUniformproductcode(String uniformproductcode) {
		this.uniformproductcode = uniformproductcode;
	}

	public Integer getGenericcombinationid() {
		return genericcombinationid;
	}

	public void setGenericcombinationid(Integer genericcombinationid) {
		this.genericcombinationid = genericcombinationid;
	}

	public String getGenericnamedosage() {
		return genericnamedosage;
	}

	public void setGenericnamedosage(String genericnamedosage) {
		this.genericnamedosage = genericnamedosage;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Integer getTherapeuticid() {
		return therapeuticid;
	}

	public void setTherapeuticid(Integer therapeuticid) {
		this.therapeuticid = therapeuticid;
	}

	public Integer getSubtherapeuticid() {
		return subtherapeuticid;
	}

	public void setSubtherapeuticid(Integer subtherapeuticid) {
		this.subtherapeuticid = subtherapeuticid;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getIgst() {
		return igst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}

	public Double getUtgst() {
		return utgst;
	}

	public void setUtgst(Double utgst) {
		this.utgst = utgst;
	}

	public Integer getFormulationid() {
		return formulationid;
	}

	public void setFormulationid(Integer formulationid) {
		this.formulationid = formulationid;
	}

	public String getSchudletype() {
		return schudletype;
	}

	public void setSchudletype(String schudletype) {
		this.schudletype = schudletype;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getMinqty() {
		return minqty;
	}

	public void setMinqty(Double minqty) {
		this.minqty = minqty;
	}

	public Double getMaxqty() {
		return maxqty;
	}

	public void setMaxqty(Double maxqty) {
		this.maxqty = maxqty;
	}

	public Double getBoxpercartoon() {
		return boxpercartoon;
	}

	public void setBoxpercartoon(Double boxpercartoon) {
		this.boxpercartoon = boxpercartoon;
	}

	public Double getStripperbox() {
		return stripperbox;
	}

	public void setStripperbox(Double stripperbox) {
		this.stripperbox = stripperbox;
	}

	public Double getQuantityperstrip() {
		return quantityperstrip;
	}

	public void setQuantityperstrip(Double quantityperstrip) {
		this.quantityperstrip = quantityperstrip;
	}

	public String getBanneddrug() {
		return banneddrug;
	}

	public void setBanneddrug(String banneddrug) {
		this.banneddrug = banneddrug;
	}

	public String getProductregno() {
		return productregno;
	}

	public void setProductregno(String productregno) {
		this.productregno = productregno;
	}

	public Integer getDistimporterid() {
		return distimporterid;
	}

	public void setDistimporterid(Integer distimporterid) {
		this.distimporterid = distimporterid;
	}

	public String getBanneddrugreason() {
		return banneddrugreason;
	}

	public void setBanneddrugreason(String banneddrugreason) {
		this.banneddrugreason = banneddrugreason;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public String getHsnid() {
		return hsnid;
	}

	public void setHsnid(String hsnid) {
		this.hsnid = hsnid;
	}

	public Integer getVanustonproductdrugid() {
		return vanustonproductdrugid;
	}

	public void setVanustonproductdrugid(Integer vanustonproductdrugid) {
		this.vanustonproductdrugid = vanustonproductdrugid;
	}

	public Integer getPharmacompanyid() {
		return pharmacompanyid;
	}

	public void setPharmacompanyid(Integer pharmacompanyid) {
		this.pharmacompanyid = pharmacompanyid;
	}

	public Integer getVerticalid() {
		return verticalid;
	}

	public void setVerticalid(Integer verticalid) {
		this.verticalid = verticalid;
	}

	public Integer getDrugstatus() {
		return drugstatus;
	}

	public void setDrugstatus(Integer drugstatus) {
		this.drugstatus = drugstatus;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public byte[] getPhotos() {
		return photos;
	}

	public void setPhotos(byte[] photos) {
		this.photos = photos;
	}

	public Integer getCustflag() {
		return custflag;
	}

	public void setCustflag(Integer custflag) {
		this.custflag = custflag;
	}

	public String getDrugbannedfrom() {
		return drugbannedfrom;
	}

	public void setDrugbannedfrom(String drugbannedfrom) {
		this.drugbannedfrom = drugbannedfrom;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getEmergency_type() {
		return emergency_type;
	}

	public void setEmergency_type(String emergency_type) {
		this.emergency_type = emergency_type;
	}

	public String getProduction_sunlight() {
		return production_sunlight;
	}

	public void setProduction_sunlight(String production_sunlight) {
		this.production_sunlight = production_sunlight;
	}

	public String getStock_available() {
		return stock_available;
	}

	public void setStock_available(String stock_available) {
		this.stock_available = stock_available;
	}

	public String getSanitizing() {
		return sanitizing;
	}

	public void setSanitizing(String sanitizing) {
		this.sanitizing = sanitizing;
	}

	public String getNarcoticdrug() {
		return narcoticdrug;
	}

	public void setNarcoticdrug(String narcoticdrug) {
		this.narcoticdrug = narcoticdrug;
	}

	public String getHanzoration_drug() {
		return hanzoration_drug;
	}

	public void setHanzoration_drug(String hanzoration_drug) {
		this.hanzoration_drug = hanzoration_drug;
	}

	public String getColdstorage() {
		return coldstorage;
	}

	public void setColdstorage(String coldstorage) {
		this.coldstorage = coldstorage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGeneric_name() {
		return generic_name;
	}

	public void setGeneric_name(String generic_name) {
		this.generic_name = generic_name;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}



	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public Integer getModifiedBy() {
		return ModifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		ModifiedBy = modifiedBy;
	}

	public Integer getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(Integer createdBy) {
		CreatedBy = createdBy;
	}

	public Integer getQcStatus() {
		return qcStatus;
	}

	public void setQcStatus(Integer qcStatus) {
		this.qcStatus = qcStatus;
	}

}
