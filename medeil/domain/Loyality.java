package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DesingRaja
 *
 */

@Entity
@Table(name = "medc_loyalitypoints",catalog = "medc_loyality")
public class Loyality implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="loyality_typeid")
	
		private Integer id;
		private String loyalitytype;
		private Integer price_equivalentto_points;
		private Integer equivalent_points;
		private Integer companyrefid;
		private Integer branchrefid;
		private Integer locname;
		private Integer locarefid;
		private Integer exp_status;
		private Integer minimum_points;
		private String from_date;
		private String to_date;
		private String clientcdate;
		private String clientmdate;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getPrice_equivalentto_points() {
			return price_equivalentto_points;
		}
		public void setPrice_equivalentto_points(Integer price_equivalentto_points) {
			this.price_equivalentto_points = price_equivalentto_points;
		}
		public Integer getEquivalent_points() {
			return equivalent_points;
		}
		public void setEquivalent_points(Integer equivalent_points) {
			this.equivalent_points = equivalent_points;
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
		public Integer getLocarefid() {
			return locarefid;
		}
		public void setLocarefid(Integer locarefid) {
			this.locarefid = locarefid;
		}
		public Integer getExp_status() {
			return exp_status;
		}
		public void setExp_status(Integer exp_status) {
			this.exp_status = exp_status;
		}
		public Integer getMinimum_points() {
			return minimum_points;
		}
		public void setMinimum_points(Integer minimum_points) {
			this.minimum_points = minimum_points;
		}
		public String getFrom_date() {
			return from_date;
		}
		public void setFrom_date(String from_date) {
			this.from_date = from_date;
		}
		public String getTo_date() {
			return to_date;
		}
		public void setTo_date(String to_date) {
			this.to_date = to_date;
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
		public String getLoyalitytype() {
			return loyalitytype;
		}
		public void setLoyalitytype(String loyalitytype) {
			this.loyalitytype = loyalitytype;
		}
}
