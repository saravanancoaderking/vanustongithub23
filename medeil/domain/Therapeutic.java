package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_therapeuticmaster", catalog="medc_productmaster")
public class Therapeutic{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TherapeuticID")
	private Integer id;
	private String therapeuticname;
	public Integer getId() {
		return id;
	}
	public String getTherapeuticname() {
		return therapeuticname;
	}
	public void setTherapeuticname(String therapeuticname) {
		this.therapeuticname = therapeuticname;
	}
	
	
	
}
