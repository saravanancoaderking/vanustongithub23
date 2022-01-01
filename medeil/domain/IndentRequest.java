package com.medeil.domain;

import java.util.Date;
import java.util.List;
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
@Table(name = "medc_indentreq", catalog = "medc_indentmaster")
public class IndentRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "indentreqid")
	private int id;

	private Integer pirority;

	private Double requirementdept;
	private Double totalqty;
	private Double totalboxqty;
	private Double totalstripqty;
	private Double totaltabqty;

	private Integer fromlocname;
	private Integer fromlocrefid;
	private Integer tolocname;
	private Integer tolocrefid;

	private Double locrefid;
	private Double locname;

	private String indentno;

	private Boolean delflag = false;
	private String clientcdate;
	private String clientcdate1;

	private Integer stkminrefid;

	private Integer countryrefid;
	private Integer companyrefid;
	private Integer branchrefid;

	private String namefromlocname;
	private String namefromlocrefid;
	private String nametolocname;
	private String nametolocrefid;
	//private Boolean checkbox;
	
	//Sivakumar-06/02/2020,For Single API(JPA)
//	@JsonManagedReference
//	@OneToMany(mappedBy = "indentrequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Set<IndentProducts> indreq;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPirority() {
		return pirority;
	}

	public void setPirority(Integer pirority) {
		this.pirority = pirority;
	}

	public Double getRequirementdept() {
		return requirementdept;
	}

	public void setRequirementdept(Double requirementdept) {
		this.requirementdept = requirementdept;
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

	public Integer getFromlocname() {
		return fromlocname;
	}

	public void setFromlocname(Integer fromlocname) {
		this.fromlocname = fromlocname;
	}

	public Integer getFromlocrefid() {
		return fromlocrefid;
	}

	public void setFromlocrefid(Integer fromlocrefid) {
		this.fromlocrefid = fromlocrefid;
	}

	public Integer getTolocname() {
		return tolocname;
	}

	public void setTolocname(Integer tolocname) {
		this.tolocname = tolocname;
	}

	public Integer getTolocrefid() {
		return tolocrefid;
	}

	public void setTolocrefid(Integer tolocrefid) {
		this.tolocrefid = tolocrefid;
	}

	public Double getLocrefid() {
		return locrefid;
	}

	public void setLocrefid(Double locrefid) {
		this.locrefid = locrefid;
	}

	public Double getLocname() {
		return locname;
	}

	public void setLocname(Double locname) {
		this.locname = locname;
	}

	public String getIndentno() {
		return indentno;
	}

	public void setIndentno(String indentno) {
		this.indentno = indentno;
	}

	public Boolean getDelflag() {
		return delflag;
	}

	public void setDelflag(Boolean delflag) {
		this.delflag = delflag;
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

	public Integer getStkminrefid() {
		return stkminrefid;
	}

	public void setStkminrefid(Integer stkminrefid) {
		this.stkminrefid = stkminrefid;
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

	public String getNamefromlocname() {
		return namefromlocname;
	}

	public void setNamefromlocname(String namefromlocname) {
		this.namefromlocname = namefromlocname;
	}

	public String getNamefromlocrefid() {
		return namefromlocrefid;
	}

	public void setNamefromlocrefid(String namefromlocrefid) {
		this.namefromlocrefid = namefromlocrefid;
	}

	public String getNametolocname() {
		return nametolocname;
	}

	public void setNametolocname(String nametolocname) {
		this.nametolocname = nametolocname;
	}

	public String getNametolocrefid() {
		return nametolocrefid;
	}

	public void setNametolocrefid(String nametolocrefid) {
		this.nametolocrefid = nametolocrefid;
	}

//	public Boolean getCheckbox() {
//		return checkbox;
//	}
//
//	public void setCheckbox(Boolean checkbox) {
//		this.checkbox = checkbox;
//	}

}
