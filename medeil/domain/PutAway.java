package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_wrhputaway", catalog = "medc_stock")
public class PutAway {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "putawayautoid")
	private int id;

	private Integer putawayid;
	private Double drugproductrefid;
	private Double batchrefid;

	private Double status;
	private Double locname;
	private Double locrefid;
	private Double boxconvstk;
	private Double stripconvstk;
	private String clientcdate;
	private String clientcdate1;
	private Double calcflag;
	private Double fromlocname;
	private Double fromlocrefid;

	private String storagetype;
	private String blocktype;
	private String blockno;
	private String rackno;
	private String putawayno;
	
	private Double  putawaydispflag;
	private Double picktyperefid;
	
	private  Integer   countryrefid;  
	private  Integer   companyrefid  ;
	private  Integer   branchrefid  ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Double getDrugproductrefid() {
		return drugproductrefid;
	}
	public void setDrugproductrefid(Double drugproductrefid) {
		this.drugproductrefid = drugproductrefid;
	}
	public Double getBatchrefid() {
		return batchrefid;
	}
	public void setBatchrefid(Double batchrefid) {
		this.batchrefid = batchrefid;
	}
	public Double getStatus() {
		return status;
	}
	public void setStatus(Double status) {
		this.status = status;
	}
	public Double getLocname() {
		return locname;
	}
	public void setLocname(Double locname) {
		this.locname = locname;
	}
	public Double getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}
	public Double getBoxconvstk() {
		return boxconvstk;
	}
	public void setBoxconvstk(Double boxconvstk) {
		this.boxconvstk = boxconvstk;
	}
	public Double getStripconvstk() {
		return stripconvstk;
	}
	public void setStripconvstk(Double stripconvstk) {
		this.stripconvstk = stripconvstk;
	}
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public String getClientcdate1() {
		return clientcdate1;
	}
	public void setClientcdate1(String clientcdate1) {
		this.clientcdate1 = clientcdate1;
	}
	public Double getCalcflag() {
		return calcflag;
	}
	public void setCalcflag(Double calcflag) {
		this.calcflag = calcflag;
	}
	public Double getFromlocname() {
		return fromlocname;
	}
	public void setFromlocname(Double fromlocname) {
		this.fromlocname = fromlocname;
	}
	public Double getFromlocrefid() {
		return fromlocrefid;
	}
	public void setFromlocrefid(Double fromlocrefid) {
		this.fromlocrefid = fromlocrefid;
	}
	public String getStoragetype() {
		return storagetype;
	}
	public void setStoragetype(String storagetype) {
		this.storagetype = storagetype;
	}
	public String getBlocktype() {
		return blocktype;
	}
	public void setBlocktype(String blocktype) {
		this.blocktype = blocktype;
	}
	public String getBlockno() {
		return blockno;
	}
	public void setBlockno(String blockno) {
		this.blockno = blockno;
	}
	public String getRackno() {
		return rackno;
	}
	public void setRackno(String rackno) {
		this.rackno = rackno;
	}
	public String getPutawayno() {
		return putawayno;
	}
	public void setPutawayno(String putawayno) {
		this.putawayno = putawayno;
	}
	public Integer getPutawayid() {
		return putawayid;
	}
	public void setPutawayid(Integer putawayid) {
		this.putawayid = putawayid;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Double getPicktyperefid() {
		return picktyperefid;
	}
	public void setPicktyperefid(Double picktyperefid) {
		this.picktyperefid = picktyperefid;
	}
	public Double getPutawaydispflag() {
		return putawaydispflag;
	}
	public void setPutawaydispflag(Double putawaydispflag) {
		this.putawaydispflag = putawaydispflag;
	}
	public Integer getCountryrefid() {
		return countryrefid;
	}
	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
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

	
	
	
	
	
	
	
	
	
	
	
}
