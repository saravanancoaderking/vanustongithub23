package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Ajith Kumar
 */
@Entity
@Table(name = "medc_mainstock", catalog = "medc_stock")
public class Stocks implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "StockID")
	private Integer id;

	private String rackno;

	private String shelfno;

	private String coldstorage;

	private Integer drugproductid;

	private Integer formulationid;

	private String dosageid;

	private String expirydate;

	private String batchno;
	
	private String batchname;

	private Double minqty;

	private Double boxperstrip;

	private Double strippertablet;

	private Double qty;

	private Double boxqty;

	private Double tabletqty;

	private Double stripqty;

	private Double freeboxqty;

	private Integer damageqty;
	
	private Double freestripqty;

	private Double freetabletqty;

	private Double freetotalqty;

	private Double sellingprice;

	private Double purchaseprice;

	private Double mrp;

	private Double wholesellingprice;

	private Double retailersellingprice;

	private Double unitsgst;

	private Double unitcgst;

	private Double unitigst;

	private Double unitutgst;

	private Double unitgst;

	private Double vat;

	private Double margin;

	private Double marginamt;

	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locrefid;

	private Integer locname;

	private String clientcdate;

	private String brandname;

	private String manufactureddate; // Boopalan 060719

	private Integer lastreceivedqty;// Boopalan 050719
	
	private Double unitprice;//Boopalan 170719
	
	private Integer barcodewidth;//Ajith
	
	private Integer barcodeheight;//Ajith
	
	private String barcodelabel;//Ajith
	
	private Integer qrcodewidth;//Ajith
	
	private Integer qrcodeheight;//Ajith
	
	private String qrcodelabel;//Ajith
	
	private byte[] barcodeimage;
	
	private byte[] qrcodeimage;
	
	@Transient
	private String shopname;
	
	private Double approvalqty;
	
	private Integer penddingqty;
	
	private Integer purcapprovalrefid;
	
	private Double freeqty;
	
	private Integer purchinvrefid;
	
	private Integer reorderlvl;
	
	private String maxqty;
	
	private String stockdate;
	
	private Integer destroystatus;
	
	private Integer damagedestroystatus;
	
	private String packageunit;
	
	private Double closingstock;
	
	public String getClientmdate() {
		return clientmdate;
	}

	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
	}

	private String clientmdate;

	public Double getFreeqty() {
		return freeqty;
	}

	public void setFreeqty(Double freeqty) {
		this.freeqty = freeqty;
	}

	public Integer getPurcapprovalrefid() {
		return purcapprovalrefid;
	}

	public void setPurcapprovalrefid(Integer purcapprovalrefid) {
		this.purcapprovalrefid = purcapprovalrefid;
	}

	public Double getApprovalqty() {
		return approvalqty;
	}

	public void setApprovalqty(Double approvalqty) {
		this.approvalqty = approvalqty;
	}

	public Integer getDamageqty() {
		return damageqty;
	}

	public void setDamageqty(Integer damageqty) {
		this.damageqty = damageqty;
	}

	public Integer getPenddingqty() {
		return penddingqty;
	}

	public void setPenddingqty(Integer penddingqty) {
		this.penddingqty = penddingqty;
	}

	/**
	 * @return the shopname
	 */
	public String getShopname() {
		return shopname;
	}

	/**
	 * @param shopname the shopname to set
	 */
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRackno() {
		return rackno;
	}

	public void setRackno(String rackno) {
		this.rackno = rackno;
	}

	public String getShelfno() {
		return shelfno;
	}

	public void setShelfno(String shelfno) {
		this.shelfno = shelfno;
	}

	public String getColdstorage() {
		return coldstorage;
	}

	public void setColdstorage(String coldstorage) {
		this.coldstorage = coldstorage;
	}

	public Integer getDrugproductid() {
		return drugproductid;
	}

	public void setDrugproductid(Integer drugproductid) {
		this.drugproductid = drugproductid;
	}

	public Integer getFormulationid() {
		return formulationid;
	}

	public void setFormulationid(Integer formulationid) {
		this.formulationid = formulationid;
	}

	public String getDosageid() {
		return dosageid;
	}

	public void setDosageid(String dosageid) {
		this.dosageid = dosageid;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Double getMinqty() {
		return minqty;
	}

	public void setMinqty(Double minqty) {
		this.minqty = minqty;
	}

	public Double getBoxperstrip() {
		return boxperstrip;
	}

	public void setBoxperstrip(Double boxperstrip) {
		this.boxperstrip = boxperstrip;
	}

	public Double getStrippertablet() {
		return strippertablet;
	}

	public void setStrippertablet(Double strippertablet) {
		this.strippertablet = strippertablet;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getBoxqty() {
		return boxqty;
	}

	public void setBoxqty(Double boxqty) {
		this.boxqty = boxqty;
	}

	public Double getTabletqty() {
		return tabletqty;
	}

	public void setTabletqty(Double tabletqty) {
		this.tabletqty = tabletqty;
	}

	public Double getStripqty() {
		return stripqty;
	}

	public void setStripqty(Double stripqty) {
		this.stripqty = stripqty;
	}

	public Double getFreeboxqty() {
		return freeboxqty;
	}

	public void setFreeboxqty(Double freeboxqty) {
		this.freeboxqty = freeboxqty;
	}

	public Double getFreestripqty() {
		return freestripqty;
	}

	public void setFreestripqty(Double freestripqty) {
		this.freestripqty = freestripqty;
	}

	public Double getFreetabletqty() {
		return freetabletqty;
	}

	public void setFreetabletqty(Double freetabletqty) {
		this.freetabletqty = freetabletqty;
	}

	public Double getFreetotalqty() {
		return freetotalqty;
	}

	public void setFreetotalqty(Double freetotalqty) {
		this.freetotalqty = freetotalqty;
	}

	public Double getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(Double sellingprice) {
		this.sellingprice = sellingprice;
	}

	public Double getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(Double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getWholesellingprice() {
		return wholesellingprice;
	}

	public void setWholesellingprice(Double wholesellingprice) {
		this.wholesellingprice = wholesellingprice;
	}

	public Double getRetailersellingprice() {
		return retailersellingprice;
	}

	public void setRetailersellingprice(Double retailersellingprice) {
		this.retailersellingprice = retailersellingprice;
	}

	public Double getUnitsgst() {
		return unitsgst;
	}

	public void setUnitsgst(Double unitsgst) {
		this.unitsgst = unitsgst;
	}

	public Double getUnitcgst() {
		return unitcgst;
	}

	public void setUnitcgst(Double unitcgst) {
		this.unitcgst = unitcgst;
	}

	public Double getUnitigst() {
		return unitigst;
	}

	public void setUnitigst(Double unitigst) {
		this.unitigst = unitigst;
	}

	public Double getUnitutgst() {
		return unitutgst;
	}

	public void setUnitutgst(Double unitutgst) {
		this.unitutgst = unitutgst;
	}

	public Double getUnitgst() {
		return unitgst;
	}

	public void setUnitgst(Double unitgst) {
		this.unitgst = unitgst;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public Double getMargin() {
		return margin;
	}

	public void setMargin(Double margin) {
		this.margin = margin;
	}

	public Double getMarginamt() {
		return marginamt;
	}

	public void setMarginamt(Double marginamt) {
		this.marginamt = marginamt;
	}

	public Integer getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(Integer companyrefid) {
		this.companyrefid = companyrefid;
	}

	public Integer getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(Integer branchrefid) {
		this.branchrefid = branchrefid;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public Integer getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Integer locrefid) {
		this.locrefid = locrefid;
	}

	public Integer getLocname() {
		return locname;
	}

	public void setLocname(Integer locname) {
		this.locname = locname;
	}

	public String getManufactureddate() {
		return manufactureddate;
	}

	public void setManufactureddate(String manufactureddate) {
		this.manufactureddate = manufactureddate;
	}

	public Integer getLastreceivedqty() {
		return lastreceivedqty;
	}

	public void setLastreceivedqty(Integer lastreceivedqty) {
		this.lastreceivedqty = lastreceivedqty;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public Integer getBarcodewidth() {
		return barcodewidth;
	}

	public void setBarcodewidth(Integer barcodewidth) {
		this.barcodewidth = barcodewidth;
	}

	public Integer getBarcodeheight() {
		return barcodeheight;
	}

	public void setBarcodeheight(Integer barcodeheight) {
		this.barcodeheight = barcodeheight;
	}

	public Integer getQrcodewidth() {
		return qrcodewidth;
	}

	public void setQrcodewidth(Integer qrcodewidth) {
		this.qrcodewidth = qrcodewidth;
	}

	public Integer getQrcodeheight() {
		return qrcodeheight;
	}

	public void setQrcodeheight(Integer qrcodeheight) {
		this.qrcodeheight = qrcodeheight;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	/**
	 * @return the barcodeimage
	 */
	public byte[] getBarcodeimage() {
		return barcodeimage;
	}

	/**
	 * @param barcodeimage the barcodeimage to set
	 */
	public void setBarcodeimage(byte[] barcodeimage) {
		this.barcodeimage = barcodeimage;
	}

	/**
	 * @return the qrcodeimage
	 */
	public byte[] getQrcodeimage() {
		return qrcodeimage;
	}

	/**
	 * @param qrcodeimage the qrcodeimage to set
	 */
	public void setQrcodeimage(byte[] qrcodeimage) {
		this.qrcodeimage = qrcodeimage;
	}

	public String getBarcodelabel() {
		return barcodelabel;
	}

	public void setBarcodelabel(String barcodelabel) {
		this.barcodelabel = barcodelabel;
	}

	public String getQrcodelabel() {
		return qrcodelabel;
	}

	public void setQrcodelabel(String qrcodelabel) {
		this.qrcodelabel = qrcodelabel;
	}

	public Integer getPurchinvrefid() {
		return purchinvrefid;
	}

	public void setPurchinvrefid(Integer purchinvrefid) {
		this.purchinvrefid = purchinvrefid;
	}

	public Integer getReorderlvl() {
		return reorderlvl;
	}

	public void setReorderlvl(Integer reorderlvl) {
		this.reorderlvl = reorderlvl;
	}

	public String getMaxqty() {
		return maxqty;
	}

	public void setMaxqty(String maxqty) {
		this.maxqty = maxqty;
	}

	public String getStockdate() {
		return stockdate;
	}

	public void setStockdate(String stockdate) {
		this.stockdate = stockdate;
	}

	public Integer getDamagedestroystatus() {
		return damagedestroystatus;
	}

	public void setDamagedestroystatus(Integer damagedestroystatus) {
		this.damagedestroystatus = damagedestroystatus;
	}

	public String getBatchname() {
		return batchname;
	}

	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}

	public String getPackageunit() {
		return packageunit;
	}

	public void setPackageunit(String packageunit) {
		this.packageunit = packageunit;
	}
	
	public Integer getDestroystatus() {
		return destroystatus;
	}

	public void setDestroystatus(Integer destroystatus) {
		this.destroystatus = destroystatus;
	}

	public Double getClosingstock() {
		return closingstock;
	}

	public void setClosingstock(Double closingstock) {
		this.closingstock = closingstock;
	}


}
