package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "medc_deliverchallan", catalog = "medc_stock")
public class DeliverChallan {
	//raja
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DcID")
	private int id;
	private String dcno;
	private String deliverydate;
	private Double totalproduct;
	private Double totalqty;
	private Double totalboxqty;
	private Double totalstripqty;
	private Double totaltabqty;
	private int tolocrefid;
	private int tolocname;
	private int fromlocrefid;
	private int fromlocname;
	private int locrefid;
	private int locname;
	private int branchrefid;
	private int companyrefid;
	private int billtyperefid;
	@Transient
	private int stockno;
	private int salesorderrefid;
	private String clientcdate;
	
	//barqr code properties
	private Integer barcodewidth;//Puthiran
	private Integer barcodeheight;//Puthiran
	private String barcodelabel;//Puthiran
	private Integer qrcodewidth;//Puthiran
	private Integer qrcodeheight;//Puthiran
	private String qrcodelabel;//Puthiran
	private Integer barcodeposition;//Puthiran
	private Integer qrcodeposition;//Puthiran
	
	private byte[] barcodeimage;
	private byte[] qrcodeimage;
	
	//Raja
	private Integer poid;
	private String dist_dcno;
	private String dist_invno;


	public int getBilltyperefid() {
		return billtyperefid;
	}

	public void setBilltyperefid(int billtyperefid) {
		this.billtyperefid = billtyperefid;
	}

	public int getStockno() {
		return stockno;
	}

	public void setStockno(int stockno) {
		this.stockno = stockno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDcno() {
		return dcno;
	}

	public void setDcno(String dcno) {
		this.dcno = dcno;
	}

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public Double getTotalproduct() {
		return totalproduct;
	}

	public void setTotalproduct(Double totalproduct) {
		this.totalproduct = totalproduct;
	}

	public Double getTotalqty() {
		return totalqty;
	}

	public void setTotalqty(Double totalqty) {
		this.totalqty = totalqty;
	}

	public Double getTotalboxqty() {
		return totalboxqty;
	}

	public void setTotalboxqty(Double totalboxqty) {
		this.totalboxqty = totalboxqty;
	}

	public Double getTotalstripqty() {
		return totalstripqty;
	}

	public void setTotalstripqty(Double totalstripqty) {
		this.totalstripqty = totalstripqty;
	}

	public Double getTotaltabqty() {
		return totaltabqty;
	}

	public void setTotaltabqty(Double totaltabqty) {
		this.totaltabqty = totaltabqty;
	}

	public int getTolocrefid() {
		return tolocrefid;
	}

	public void setTolocrefid(int tolocrefid) {
		this.tolocrefid = tolocrefid;
	}

	public int getTolocname() {
		return tolocname;
	}

	public void setTolocname(int tolocname) {
		this.tolocname = tolocname;
	}

	public int getFromlocrefid() {
		return fromlocrefid;
	}

	public void setFromlocrefid(int fromlocrefid) {
		this.fromlocrefid = fromlocrefid;
	}

	public int getFromlocname() {
		return fromlocname;
	}

	public void setFromlocname(int fromlocname) {
		this.fromlocname = fromlocname;
	}

	public int getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(int locrefid) {
		this.locrefid = locrefid;
	}

	public int getLocname() {
		return locname;
	}

	public void setLocname(int locname) {
		this.locname = locname;
	}

	public int getBranchrefid() {
		return branchrefid;
	}

	public void setBranchrefid(int branchrefid) {
		this.branchrefid = branchrefid;
	}

	public int getCompanyrefid() {
		return companyrefid;
	}

	public void setCompanyrefid(int companyrefid) {
		this.companyrefid = companyrefid;
	}

	public int getSalesorderrefid() {
		return salesorderrefid;
	}

	public void setSalesorderrefid(int salesorderrefid) {
		this.salesorderrefid = salesorderrefid;
	}

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	/**
	 * @return the barcodewidth
	 */
	public Integer getBarcodewidth() {
		return barcodewidth;
	}

	/**
	 * @param barcodewidth the barcodewidth to set
	 */
	public void setBarcodewidth(Integer barcodewidth) {
		this.barcodewidth = barcodewidth;
	}

	/**
	 * @return the barcodelabel
	 */
	public String getBarcodelabel() {
		return barcodelabel;
	}

	/**
	 * @param barcodelabel the barcodelabel to set
	 */
	public void setBarcodelabel(String barcodelabel) {
		this.barcodelabel = barcodelabel;
	}

	/**
	 * @return the qrcodewidth
	 */
	public Integer getQrcodewidth() {
		return qrcodewidth;
	}

	/**
	 * @param qrcodewidth the qrcodewidth to set
	 */
	public void setQrcodewidth(Integer qrcodewidth) {
		this.qrcodewidth = qrcodewidth;
	}

	/**
	 * @return the qrcodeheight
	 */
	public Integer getQrcodeheight() {
		return qrcodeheight;
	}

	/**
	 * @param qrcodeheight the qrcodeheight to set
	 */
	public void setQrcodeheight(Integer qrcodeheight) {
		this.qrcodeheight = qrcodeheight;
	}

	/**
	 * @return the qrcodelabel
	 */
	public String getQrcodelabel() {
		return qrcodelabel;
	}

	/**
	 * @param qrcodelabel the qrcodelabel to set
	 */
	public void setQrcodelabel(String qrcodelabel) {
		this.qrcodelabel = qrcodelabel;
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

	public Integer getBarcodeheight() {
		return barcodeheight;
	}

	public void setBarcodeheight(Integer barcodeheight) {
		this.barcodeheight = barcodeheight;
	}

	public Integer getBarcodeposition() {
		return barcodeposition;
	}

	public void setBarcodeposition(Integer barcodeposition) {
		this.barcodeposition = barcodeposition;
	}

	public Integer getQrcodeposition() {
		return qrcodeposition;
	}

	public void setQrcodeposition(Integer qrcodeposition) {
		this.qrcodeposition = qrcodeposition;
	}

	public Integer getPoid() {
		return poid;
	}

	public void setPoid(Integer poid) {
		this.poid = poid;
	}

	public String getDist_dcno() {
		return dist_dcno;
	}

	public void setDist_dcno(String dist_dcno) {
		this.dist_dcno = dist_dcno;
	}

	public String getDist_invno() {
		return dist_invno;
	}

	public void setDist_invno(String dist_invno) {
		this.dist_invno = dist_invno;
	}

}