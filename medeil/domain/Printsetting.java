package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "print_settings", catalog = "medc_printsettings")
public class Printsetting  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int printid;
	private int companyid;
	private int branchid;
	private int locname;
	private int locrefid;
	private int formid;
	private int printtypeid;
	private String printtype;
	private int printlabelid;
	private String printlabel;
	public int getPrintid() {
		return printid;
	}
	public void setPrintid(int printid) {
		this.printid = printid;
	}
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	public int getLocname() {
		return locname;
	}
	public void setLocname(int locname) {
		this.locname = locname;
	}
	public int getLocrefid() {
		return locrefid;
	}
	public void setLocrefid(int locrefid) {
		this.locrefid = locrefid;
	}
	public int getFormid() {
		return formid;
	}
	public void setFormid(int formid) {
		this.formid = formid;
	}
	
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public int getPrinttypeid() {
		return printtypeid;
	}
	public void setPrinttypeid(int printtypeid) {
		this.printtypeid = printtypeid;
	}
	public String getPrinttype() {
		return printtype;
	}
	public void setPrinttype(String printtype) {
		this.printtype = printtype;
	}
	public int getPrintlabelid() {
		return printlabelid;
	}
	public void setPrintlabelid(int printlabelid) {
		this.printlabelid = printlabelid;
	}
	public String getPrintlabel() {
		return printlabel;
	}
	public void setPrintlabel(String printlabel) {
		this.printlabel = printlabel;
	}
}
