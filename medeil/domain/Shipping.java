package com.medeil.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "medc_shipping", catalog = "medc_deliveryprocess")
public class Shipping implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Shipid")
	private Integer id;

	private String shippmentno;

	private Integer packagerefid;

	private Integer salesinvoiceno;

	private String createddate;

	private String clientcdate;

	private Integer status;

	private Integer salesorderrefid;// Boopalan 240919

	private String billingaddress;
	private String bstreet;

	private String blocation;

	private int bcountry;
	private int bstate;
	private int bcity;
	private String bcontactperson;
	private String bmobile;
	private String bemail;
	// private String shippingaddress;
	private String shstreet;
	private String slocation;
	private int shcountry;
	private int shstate;
	private int shcity;
	// private String shcontactperson;
	private String shmobile;
	// private String shemail;
	private Integer companyrefid;

	private Integer branchrefid;

	private Integer locrefid;

	private Integer locname;

	private Integer custrefid;

	private Integer packageemprefid;

	private Integer emprefid;

	private String shipmentmode;

	private String shipmentname;

	private String transportno;

	private Integer countryrefid;

	private String plannedshipdate;

	private Integer totalbox;

	private Integer totalweight;

	private Double totalshipmentcharge;

	// private Integer qrcoderefid;

	private Integer barcoderefid;

	private Integer calcflag;

	private Integer samebilling;

//	//Sivakumar-08/02/2020,For Single API(JPA)
//	@JsonManagedReference
//		@OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//		private Set<ShippingDetail> shipmentcalculation;

	public String getClientcdate() {
		return clientcdate;
	}

	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}

	public String getBlocation() {
		return blocation;
	}

	public void setBlocation(String blocation) {
		this.blocation = blocation;
	}

	public String getSlocation() {
		return slocation;
	}

	public void setSlocation(String slocation) {
		this.slocation = slocation;
	}

	public Integer getSamebilling() {
		return samebilling;
	}

	public void setSamebilling(Integer samebilling) {
		this.samebilling = samebilling;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShippmentno() {
		return shippmentno;
	}

	public void setShippmentno(String shippmentno) {
		this.shippmentno = shippmentno;
	}

	public Integer getPackagerefid() {
		return packagerefid;
	}

	public void setPackagerefid(Integer packagerefid) {
		this.packagerefid = packagerefid;
	}

	public Integer getSalesinvoiceno() {
		return salesinvoiceno;
	}

	public void setSalesinvoiceno(Integer salesinvoiceno) {
		this.salesinvoiceno = salesinvoiceno;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getBcountry() {
		return bcountry;
	}

	public void setBcountry(int bcountry) {
		this.bcountry = bcountry;
	}

	public int getBstate() {
		return bstate;
	}

	public void setBstate(int bstate) {
		this.bstate = bstate;
	}

	public int getBcity() {
		return bcity;
	}

	public void setBcity(int bcity) {
		this.bcity = bcity;
	}

	public String getBcontactperson() {
		return bcontactperson;
	}

	public void setBcontactperson(String bcontactperson) {
		this.bcontactperson = bcontactperson;
	}

	public String getBmobile() {
		return bmobile;
	}

	public void setBmobile(String bmobile) {
		this.bmobile = bmobile;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	public String getBstreet() {
		return bstreet;
	}

	public void setBstreet(String bstreet) {
		this.bstreet = bstreet;
	}

	public String getShstreet() {
		return shstreet;
	}

	public void setShstreet(String shstreet) {
		this.shstreet = shstreet;
	}

	public int getShcountry() {
		return shcountry;
	}

	public void setShcountry(int shcountry) {
		this.shcountry = shcountry;
	}

	public int getShstate() {
		return shstate;
	}

	public void setShstate(int shstate) {
		this.shstate = shstate;
	}

	public int getShcity() {
		return shcity;
	}

	public void setShcity(int shcity) {
		this.shcity = shcity;
	}

	public String getShmobile() {
		return shmobile;
	}

	public void setShmobile(String shmobile) {
		this.shmobile = shmobile;
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

	public Integer getCustrefid() {
		return custrefid;
	}

	public void setCustrefid(Integer custrefid) {
		this.custrefid = custrefid;
	}

	public Integer getPackageemprefid() {
		return packageemprefid;
	}

	public void setPackageemprefid(Integer packageemprefid) {
		this.packageemprefid = packageemprefid;
	}

	public Integer getEmprefid() {
		return emprefid;
	}

	public void setEmprefid(Integer emprefid) {
		this.emprefid = emprefid;
	}

	public String getShipmentmode() {
		return shipmentmode;
	}

	public void setShipmentmode(String shipmentmode) {
		this.shipmentmode = shipmentmode;
	}

	public String getShipmentname() {
		return shipmentname;
	}

	public void setShipmentname(String shipmentname) {
		this.shipmentname = shipmentname;
	}

	public String getTransportno() {
		return transportno;
	}

	public void setTransportno(String transportno) {
		this.transportno = transportno;
	}

	public Integer getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
	}

	public String getPlannedshipdate() {
		return plannedshipdate;
	}

	public void setPlannedshipdate(String plannedshipdate) {
		this.plannedshipdate = plannedshipdate;
	}

	public Integer getTotalbox() {
		return totalbox;
	}

	public void setTotalbox(Integer totalbox) {
		this.totalbox = totalbox;
	}

	public Integer getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(Integer totalweight) {
		this.totalweight = totalweight;
	}

	public Double getTotalshipmentcharge() {
		return totalshipmentcharge;
	}

	public void setTotalshipmentcharge(Double totalshipmentcharge) {
		this.totalshipmentcharge = totalshipmentcharge;
	}

	public Integer getBarcoderefid() {
		return barcoderefid;
	}

	public void setBarcoderefid(Integer barcoderefid) {
		this.barcoderefid = barcoderefid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getCalcflag() {
		return calcflag;
	}

	public void setCalcflag(Integer calcflag) {
		this.calcflag = calcflag;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getBillingaddress() {
		return billingaddress;
	}

	public void setBillingaddress(String billingaddress) {
		this.billingaddress = billingaddress;
	}

	public Integer getSalesorderrefid() {
		return salesorderrefid;
	}

	public void setSalesorderrefid(Integer salesorderrefid) {
		this.salesorderrefid = salesorderrefid;
	}

}
