/**
 * 
 */
package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ajith
 *
 */
@Entity
@Table(name = "medc_custproductmaster", catalog = "medc_productmaster")
public class Drug implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productdrugid")
	private Integer id;

	private String brandname;

	private Integer genericid;

	private String uniformproductcode;

	private Integer genericcombinationid;

	private String genericnamedosage;

	private String uom;

	private Integer therapeuticid;

	private Integer subtherapeuticid;

	private String vat;

	private String gst;

	private String sgst;

	private String cgst;

	private String igst;
	private String utgst;

	private Integer formulationid;

	private Integer schudletype;

	private Double mrp;

	private Double minqty;

	private Double maxqty;

	private Double boxpercartoon;

	private Double stripperbox;

	private Double quantityperstrip;

	private String banneddrug;

	private byte[] photos;

	private String productregno;

	private Integer distimporterid;

	private String banneddrugreason;

	private Integer custflag;

	private String drugbannedfrom;
	
	private Integer companyid;
	private Integer branchid;
	private Integer locname;
	private Integer locrefid;
	private Integer hsnid;
	private Integer groupid;
	private Integer subgroupid1;
	private Integer subgroupid2;
	private String generic_name;
	private Integer vanustonproductdrugid;
	private String temperature;
	private String emergency_type;
	private String production_sunlight;
	private String sanitizing;
	private String stock_available;
	private String narcoticdrug;
	private String hanzoration_drug;
	private String coldstorage;
	private Integer pharmacompanyid;
	private Integer verticalid;
	private Integer drugstatus;
	private Integer countryid;
	private String skucode;

	public Integer getDrugstatus() {
		return drugstatus;
	}

	public void setDrugstatus(Integer drugstatus) {
		this.drugstatus = drugstatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getGenericcombinationid() {
		return genericcombinationid;
	}

	public void setGenericcombinationid(Integer genericcombinationid) {
		this.genericcombinationid = genericcombinationid;
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

	public Integer getFormulationid() {
		return formulationid;
	}

	public void setFormulationid(Integer formulationid) {
		this.formulationid = formulationid;
	}

	public Integer getSchudletype() {
		return schudletype;
	}

	public void setSchudletype(Integer schudletype) {
		this.schudletype = schudletype;
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

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
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

	public String getGeneric_name() {
		return generic_name;
	}

	public void setGeneric_name(String generic_name) {
		this.generic_name = generic_name;
	}

	public String getUniformproductcode() {
		return uniformproductcode;
	}

	public void setUniformproductcode(String uniformproductcode) {
		this.uniformproductcode = uniformproductcode;
	}
	public String getDrugbannedfrom() {
		return drugbannedfrom;
	}

	public void setDrugbannedfrom(String drugbannedfrom) {
		this.drugbannedfrom = drugbannedfrom;
	}
	public Integer getVanustonproductdrugid() {
		return vanustonproductdrugid;
	}

	public void setVanustonproductdrugid(Integer vanustonproductdrugid) {
		this.vanustonproductdrugid = vanustonproductdrugid;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public String getIgst() {
		return igst;
	}

	public void setIgst(String igst) {
		this.igst = igst;
	}

	public String getUtgst() {
		return utgst;
	}

	public void setUtgst(String utgst) {
		this.utgst = utgst;
	}

	public Integer getHsnid() {
		return hsnid;
	}

	public void setHsnid(Integer hsnid) {
		this.hsnid = hsnid;
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

	public String getSanitizing() {
		return sanitizing;
	}

	public void setSanitizing(String sanitizing) {
		this.sanitizing = sanitizing;
	}

	public String getStock_available() {
		return stock_available;
	}

	public void setStock_available(String stock_available) {
		this.stock_available = stock_available;
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

	public String getColdstorage() {
		return coldstorage;
	}

	public void setColdstorage(String coldstorage) {
		this.coldstorage = coldstorage;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getSubgroupid1() {
		return subgroupid1;
	}

	public void setSubgroupid1(Integer subgroupid1) {
		this.subgroupid1 = subgroupid1;
	}

	public Integer getSubgroupid2() {
		return subgroupid2;
	}

	public void setSubgroupid2(Integer subgroupid2) {
		this.subgroupid2 = subgroupid2;
	}

	public String getSkucode() {
		return skucode;
	}

	public void setSkucode(String skucode) {
		this.skucode = skucode;
	}


}
