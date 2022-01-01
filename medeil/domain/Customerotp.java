package com.medeil.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medc_signupmobileotpverification", catalog = "medc_adminsecurity")
public class Customerotp implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private String mobilenumber;
	private int otp;
	private long expirytime;
	private boolean isexpired;
	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}


	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public long getExpirytime() {
		return expirytime;
	}

	public void setExpirytime(long expirytime) {
		this.expirytime = expirytime;
	}

	public boolean isIsexpired() {
		return isexpired;
	}

	public void setIsexpired(boolean isexpired) {
		this.isexpired = isexpired;
	}
}
