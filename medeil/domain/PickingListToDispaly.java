package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_picking_list", catalog = "medc_deliveryprocess")
public class PickingListToDispaly implements Serializable {
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plid")
	private Integer plid;
	private Double siid;
	private Double soid;
	private String sinum;
	private Double no_qty;
	private Integer empid;
	private String empcode;
	private String empname;
	private String empdept;
	private Double assignedby;
	private Double assignedby_id;
	private String assignedbydept;
	private String modifieddate;
	private Integer comprefid;
	private Integer branchrefid;
	private Double locname;
	private Double locrefid;
	private String pickingstatus;

	public Double getSiid(){
		return siid;
	}

	public void setSiid(Double siid){
		this.siid=siid;
	}

	public Double getSoid(){
		return soid;
	}

	public void setSoid(Double soid){
		this.soid=soid;
	}

	public String getSinum(){
		return sinum;
	}

	public void setSinum(String sinum){
		this.sinum=sinum;
	}

	public Double getNo_qty(){
		return no_qty;
	}

	public void setNo_qty(Double no_qty){
		this.no_qty=no_qty;
	}

	public Integer getEmpid(){
		return empid;
	}

	public void setEmpid(Integer empid){
		this.empid=empid;
	}

	public String getEmpcode(){
		return empcode;
	}

	public void setEmpcode(String empcode){
		this.empcode=empcode;
	}

	public String getEmpdept(){
		return empdept;
	}

	public void setEmpdept(String empdept){
		this.empdept=empdept;
	}

	public Double getAssignedby(){
		return assignedby;
	}

	public void setAssignedby(Double assignedby){
		this.assignedby=assignedby;
	}

	public Double getAssignedby_id(){
		return assignedby_id;
	}

	public void setAssignedby_id(Double assignedby_id){
		this.assignedby_id=assignedby_id;
	}

	public String getAssignedbydept(){
		return assignedbydept;
	}

	public void setAssignedbydept(String assignedbydept){
		this.assignedbydept=assignedbydept;
	}

	public String getModifieddate(){
		return modifieddate;
	}

	public void setModifieddate(String modifieddate){
		this.modifieddate=modifieddate;
	}

	public Integer getComprefid(){
		return comprefid;
	}

	public void setComprefid(Integer comprefid){
		this.comprefid=comprefid;
	}

	public Integer getBranchrefid(){
		return branchrefid;
	}

	public void setBranchrefid(Integer branchrefid){
		this.branchrefid=branchrefid;
	}

	public Double getLocname(){
		return locname;
	}

	public void setLocname(Double locname){
		this.locname=locname;
	}

	public Double getLocrefid(){
		return locrefid;
	}

	public void setLocrefid(Double locrefid){
		this.locrefid=locrefid;
	}

	public String getPickingstatus(){
		return pickingstatus;
	}

	public void setPickingstatus(String pickingstatus){
		this.pickingstatus=pickingstatus;
	}

	public Integer getPlid() {
		return plid;
	}

	public void setPlid(Integer plid) {
		this.plid = plid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}
}
