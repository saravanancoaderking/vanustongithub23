package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_vanustonproductmaster", catalog = "medc_productmaster")
public class VanustonProductMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productdrugid;
	private String productsource;
	private Integer countryid;
	private String brandname;
	private String uniformproductcode;
	private String drugtype;

	private String patterntype;
	private Integer categoryid;
	private Integer subcategoryid;
	private Integer genericid;
	private Integer genericcombinationid;
	private String genericnamedosage;
	private String uom;
	private Integer therapeuticid;
	private Integer subtherapeuticid;
	private String dbccode;
	private String hsnid;
	private String scccode;
	private String sccdesc;
	private String vat;
	private String cgst;
	private String utgst;
	private String igst;
	private String sgst;
	private Integer formulationid;
	private Integer pharmacompanyid;
	private String divisionid;
	private String allergiccondition;
	private String pharmclass;
	private String schudletype;
	private String quantity;
	private String perpackage;
	private String perbox;
	private Double mrp;
	private Double srp_w_vat;
	private Double srp_wout_vat;
	private Double arp;
	private Double awp;
	private Double mac;
	private Double ger;
	private Double oger;
	private Integer drugstatus;
	private String banneddrug;
	private String banneddrugreason;
	private String drugstandard;
	private String shortform;
	private String verified;
	private String rootofadministration;
	private Integer createdby;
	private Integer modifiedby;
	private Double minqty;
	private Double maxqty;
	private Integer insuranceid;
	private Double boxpercartoon;
	private Double stripperbox;
	private Double quantityperstrip;
	private String gst;
	private Integer dummy4;
	private Integer dummy5;
	private Integer dummy6;
	private String diseases;
	private String productregno;
	private Integer distimporterid;
	private String packaging_description;
	private String validity;
	private String product;
	private String interchangeability;
	private String pfdaregistration;
	private String priceper;
	private Double srp;
	private String vhelpcode;
	private Integer subcategory2;
	private String formaulationshort;
	private String manufactureshort;
	private Integer countryrefid;
	private String remarks;
	private Integer group_id;
	private Integer sub_group_id_1;
	private Integer sub_group_id_2;
	private String vatidentity;
	private Integer lastupdatedtimetick;
	private String image_filename;
	private String generic_name;
	private Integer verticalid;
	private String temperature;
	private String emergency_type;
	private String production_sunlight;
	private String sanitizing;
	private String stock_available;
	private String narcoticdrug;
	private String hanzoration_drug;
	
	public Integer getProductdrugid() {
		return productdrugid;
	}

	public void setProductdrugid(Integer productdrugid) {
		this.productdrugid = productdrugid;
	}
	
	public String getProductsource() {
		return productsource;
	}

	public void setProductsource(String productsource) {
		this.productsource = productsource;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getUniformproductcode() {
		return uniformproductcode;
	}

	public void setUniformproductcode(String uniformproductcode) {
		this.uniformproductcode = uniformproductcode;
	}

	public String getDrugtype() {
		return drugtype;
	}

	public void setDrugtype(String drugtype) {
		this.drugtype = drugtype;
	}

	public String getPatterntype() {
		return patterntype;
	}

	public void setPatterntype(String patterntype) {
		this.patterntype = patterntype;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(Integer subcategoryid) {
		this.subcategoryid = subcategoryid;
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

	public String getDbccode() {
		return dbccode;
	}

	public void setDbccode(String dbccode) {
		this.dbccode = dbccode;
	}

	public String getHsnid() {
		return hsnid;
	}

	public void setHsnid(String hsnid) {
		this.hsnid = hsnid;
	}

	public String getScccode() {
		return scccode;
	}

	public void setScccode(String scccode) {
		this.scccode = scccode;
	}

	public String getSccdesc() {
		return sccdesc;
	}

	public void setSccdesc(String sccdesc) {
		this.sccdesc = sccdesc;
	}

	public Integer getFormulationid() {
		return formulationid;
	}

	public void setFormulationid(Integer formulationid) {
		this.formulationid = formulationid;
	}

	public Integer getPharmacompanyid() {
		return pharmacompanyid;
	}

	public void setPharmacompanyid(Integer pharmacompanyid) {
		this.pharmacompanyid = pharmacompanyid;
	}

	public String getDivisionid() {
		return divisionid;
	}

	public void setDivisionid(String divisionid) {
		this.divisionid = divisionid;
	}

	public String getAllergiccondition() {
		return allergiccondition;
	}

	public void setAllergiccondition(String allergiccondition) {
		this.allergiccondition = allergiccondition;
	}

	public String getPharmclass() {
		return pharmclass;
	}

	public void setPharmclass(String pharmclass) {
		this.pharmclass = pharmclass;
	}

	public String getSchudletype() {
		return schudletype;
	}

	public void setSchudletype(String schudletype) {
		this.schudletype = schudletype;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPerpackage() {
		return perpackage;
	}

	public void setPerpackage(String perpackage) {
		this.perpackage = perpackage;
	}

	public String getPerbox() {
		return perbox;
	}

	public void setPerbox(String perbox) {
		this.perbox = perbox;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getSrp_w_vat() {
		return srp_w_vat;
	}

	public void setSrp_w_vat(Double srp_w_vat) {
		this.srp_w_vat = srp_w_vat;
	}

	public Double getSrp_wout_vat() {
		return srp_wout_vat;
	}

	public void setSrp_wout_vat(Double srp_wout_vat) {
		this.srp_wout_vat = srp_wout_vat;
	}

	public Double getArp() {
		return arp;
	}

	public void setArp(Double arp) {
		this.arp = arp;
	}

	public Double getAwp() {
		return awp;
	}

	public void setAwp(Double awp) {
		this.awp = awp;
	}

	public Double getMac() {
		return mac;
	}

	public void setMac(Double mac) {
		this.mac = mac;
	}

	public Double getGer() {
		return ger;
	}

	public void setGer(Double ger) {
		this.ger = ger;
	}

	public Double getOger() {
		return oger;
	}

	public void setOger(Double oger) {
		this.oger = oger;
	}

	public Integer getDrugstatus() {
		return drugstatus;
	}

	public void setDrugstatus(Integer drugstatus) {
		this.drugstatus = drugstatus;
	}

	public String getBanneddrug() {
		return banneddrug;
	}

	public void setBanneddrug(String banneddrug) {
		this.banneddrug = banneddrug;
	}

	public String getBanneddrugreason() {
		return banneddrugreason;
	}

	public void setBanneddrugreason(String banneddrugreason) {
		this.banneddrugreason = banneddrugreason;
	}

	public String getDrugstandard() {
		return drugstandard;
	}

	public void setDrugstandard(String drugstandard) {
		this.drugstandard = drugstandard;
	}

	public String getShortform() {
		return shortform;
	}

	public void setShortform(String shortform) {
		this.shortform = shortform;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getRootofadministration() {
		return rootofadministration;
	}

	public void setRootofadministration(String rootofadministration) {
		this.rootofadministration = rootofadministration;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public Integer getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
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

	public Integer getInsuranceid() {
		return insuranceid;
	}

	public void setInsuranceid(Integer insuranceid) {
		this.insuranceid = insuranceid;
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

	public String getGst() {
		return gst;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public String getUtgst() {
		return utgst;
	}

	public void setUtgst(String utgst) {
		this.utgst = utgst;
	}

	public String getIgst() {
		return igst;
	}

	public void setIgst(String igst) {
		this.igst = igst;
	}

	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public Integer getDummy4() {
		return dummy4;
	}

	public void setDummy4(Integer dummy4) {
		this.dummy4 = dummy4;
	}

	public Integer getDummy5() {
		return dummy5;
	}

	public void setDummy5(Integer dummy5) {
		this.dummy5 = dummy5;
	}

	public Integer getDummy6() {
		return dummy6;
	}

	public void setDummy6(Integer dummy6) {
		this.dummy6 = dummy6;
	}

	public String getDiseases() {
		return diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
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

	public String getPackaging_description() {
		return packaging_description;
	}

	public void setPackaging_description(String packaging_description) {
		this.packaging_description = packaging_description;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getInterchangeability() {
		return interchangeability;
	}

	public void setInterchangeability(String interchangeability) {
		this.interchangeability = interchangeability;
	}

	public String getPfdaregistration() {
		return pfdaregistration;
	}

	public void setPfdaregistration(String pfdaregistration) {
		this.pfdaregistration = pfdaregistration;
	}

	public String getPriceper() {
		return priceper;
	}

	public void setPriceper(String priceper) {
		this.priceper = priceper;
	}

	public Double getSrp() {
		return srp;
	}

	public void setSrp(Double srp) {
		this.srp = srp;
	}

	public String getVhelpcode() {
		return vhelpcode;
	}

	public void setVhelpcode(String vhelpcode) {
		this.vhelpcode = vhelpcode;
	}

	public Integer getSubcategory2() {
		return subcategory2;
	}

	public void setSubcategory2(Integer subcategory2) {
		this.subcategory2 = subcategory2;
	}

	public String getFormaulationshort() {
		return formaulationshort;
	}

	public void setFormaulationshort(String formaulationshort) {
		this.formaulationshort = formaulationshort;
	}

	public String getManufactureshort() {
		return manufactureshort;
	}

	public void setManufactureshort(String manufactureshort) {
		this.manufactureshort = manufactureshort;
	}

	public Integer getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Integer getSub_group_id_1() {
		return sub_group_id_1;
	}

	public void setSub_group_id_1(Integer sub_group_id_1) {
		this.sub_group_id_1 = sub_group_id_1;
	}

	public Integer getSub_group_id_2() {
		return sub_group_id_2;
	}

	public void setSub_group_id_2(Integer sub_group_id_2) {
		this.sub_group_id_2 = sub_group_id_2;
	}

	public String getVatidentity() {
		return vatidentity;
	}

	public void setVatidentity(String vatidentity) {
		this.vatidentity = vatidentity;
	}

	public Integer getLastupdatedtimetick() {
		return lastupdatedtimetick;
	}

	public void setLastupdatedtimetick(Integer lastupdatedtimetick) {
		this.lastupdatedtimetick = lastupdatedtimetick;
	}

	public String getImage_filename() {
		return image_filename;
	}

	public void setImage_filename(String image_filename) {
		this.image_filename = image_filename;
	}

	public String getGeneric_name() {
		return generic_name;
	}

	public void setGeneric_name(String generic_name) {
		this.generic_name = generic_name;
	}
	
	public Integer getVerticalid() {
		return verticalid;
	}

	public void setVerticalid(Integer verticalid) {
		this.verticalid = verticalid;
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



}
