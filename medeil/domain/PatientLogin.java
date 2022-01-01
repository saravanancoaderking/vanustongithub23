package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Raja
 *
 */
@Entity
@Table(name = "medc_manualprescription" , catalog = "medc_prescription")

public class PatientLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prescription_id")
	private Integer id;
	private String presc_no;
	private Integer patient_id;
	private Integer doctor_id;
	private Integer employee_id;
	private byte prescription_img;
	private String created_date;
	private String modified_date;
	private String clientcdate;
	private String clientmdate;
	private Integer companyrefid;
	private Integer branchrefid;
	private Integer locname;
	private Integer locrefid;
	private String remarks;
	private String status;
	private Integer salesordertypeid;
	
	public Integer getSalesordertypeid() {
		return salesordertypeid;
	}
	public void setSalesordertypeid(Integer salesordertypeid) {
		this.salesordertypeid = salesordertypeid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPresc_no() {
		return presc_no;
	}
	public void setPresc_no(String presc_no) {
		this.presc_no = presc_no;
	}
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public Integer getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(Integer doctor_id) {
		this.doctor_id = doctor_id;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public byte getPrescription_img() {
		return prescription_img;
	}
	public void setPrescription_img(byte prescription_img) {
		this.prescription_img = prescription_img;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}
	public String getClientcdate() {
		return clientcdate;
	}
	public void setClientcdate(String clientcdate) {
		this.clientcdate = clientcdate;
	}
	public String getClientmdate() {
		return clientmdate;
	}
	public void setClientmdate(String clientmdate) {
		this.clientmdate = clientmdate;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
