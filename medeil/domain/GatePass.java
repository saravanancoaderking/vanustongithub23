package com.medeil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_gatepass", catalog = "medc_stock")
public class GatePass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DpID")
	private int id;
	private String gpno;
	private String gatepassdate;
	private Double totalproduct;
	private Double totalqty;
	private Double totalboxqty;
	private Double totalstripqty;
	private Double totaltabqty;
	private String billtype;
	private String billno;
	private String billdate;
	private String remarks;
	private int tolocrefid;
	private int tolocname;
	private int fromlocrefid;
	private int fromlocname;
	private int locrefid;
	private int locname;
	private int branchrefid;
	private int companyrefid;
	private int billtyperefid;
	private int dcrefid;
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGpno() {
		return gpno;
	}

	public void setGpno(String gpno) {
		this.gpno = gpno;
	}

	public String getGatepassdate() {
		return gatepassdate;
	}

	public void setGatepassdate(String gatepassdate) {
		this.gatepassdate = gatepassdate;
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

	public String getBilltype() {
		return billtype;
	}

	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getBilldate() {
		return billdate;
	}

	public void setBilldate(String billdate) {
		this.billdate = billdate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public int getBilltyperefid() {
		return billtyperefid;
	}

	public void setBilltyperefid(int billtyperefid) {
		this.billtyperefid = billtyperefid;
	}

	public int getDcrefid() {
		return dcrefid;
	}

	public void setDcrefid(int dcrefid) {
		this.dcrefid = dcrefid;
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
	 * @return the barcodeheight
	 */
	public Integer getBarcodeheight() {
		return barcodeheight;
	}

	/**
	 * @param barcodeheight the barcodeheight to set
	 */
	public void setBarcodeheight(Integer barcodeheight) {
		this.barcodeheight = barcodeheight;
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
	 * @return the barcodeposition
	 */
	public Integer getBarcodeposition() {
		return barcodeposition;
	}

	/**
	 * @param barcodeposition the barcodeposition to set
	 */
	public void setBarcodeposition(Integer barcodeposition) {
		this.barcodeposition = barcodeposition;
	}

	/**
	 * @return the qrcodeposition
	 */
	public Integer getQrcodeposition() {
		return qrcodeposition;
	}

	/**
	 * @param qrcodeposition the qrcodeposition to set
	 */
	public void setQrcodeposition(Integer qrcodeposition) {
		this.qrcodeposition = qrcodeposition;
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

}