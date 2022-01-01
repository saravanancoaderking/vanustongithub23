/**
 * 
 */
package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vanuston
 *
 */
@Entity
@Table(name = "medc_taxtype", catalog = "medc_fixedsettings")
public class Taxtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taxtypeID")
	private Integer id;

	
	private Integer countryrefid;
	private Integer vat_gst;
 
	public Integer getCountryrefid() {
		return countryrefid;
	}

	public void setCountryrefid(Integer countryrefid) {
		this.countryrefid = countryrefid;
	}

	public Integer getVat_gst() {
		return vat_gst;
	}

	public void setVat_gst(Integer vat_gst) {
		this.vat_gst = vat_gst;
	}

}
