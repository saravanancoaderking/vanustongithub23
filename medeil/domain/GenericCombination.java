/**
 * 
 */
package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ajith Kumar
 *
 */
@Entity
public class GenericCombination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer combinationid;

	private Integer genericid;

	private String dosage;

	private String uom;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCombinationid() {
		return combinationid;
	}

	public void setCombinationid(Integer combinationid) {
		this.combinationid = combinationid;
	}

	public Integer getGenericid() {
		return genericid;
	}

	public void setGenericid(Integer genericid) {
		this.genericid = genericid;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

}
