package com.medeil.domain;

public class Customerpaymetstatus {

	private String account_id;
	
	private Contains contains;
	
	private Integer created_at;
	
	private String entity;
	
	private String event;
	
	private Payload payload;
	
	private CstPayment payment;
	
	private Paymentlinks payment_link;

	public String getAccount_id() {
		return account_id;
	}

	public Contains getContains() {
		return contains;
	}

	public Integer getCreated_at() {
		return created_at;
	}

	public String getEntity() {
		return entity;
	}

	public String getEvent() {
		return event;
	}

	public Payload getPayload() {
		return payload;
	}

	public CstPayment getPayment() {
		return payment;
	}

	public Paymentlinks getPayment_link() {
		return payment_link;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public void setContains(Contains contains) {
		this.contains = contains;
	}

	public void setCreated_at(Integer created_at) {
		this.created_at = created_at;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public void setPayment(CstPayment payment) {
		this.payment = payment;
	}

	public void setPayment_link(Paymentlinks payment_link) {
		this.payment_link = payment_link;
	}
	
}
