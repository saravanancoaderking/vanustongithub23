package com.medeil.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Domainref")
public class Domainname {

	@Id
	@GeneratedValue
	@Column(name = "Submoduleid")
	private long phoneId;

	@Column(name = "Domainname", nullable = false, length = 15)
	private String domainname;

	public String getDomainname() {
		return domainname;
	}

	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

	public Domainname() {
	}

	/*public Domainname(String phoneNumber) {

		this.domainname = phoneNumber;
	} selva*/

	public long getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

}
