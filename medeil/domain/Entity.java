package com.medeil.domain;

public class Entity {

	private Integer amount;
	
	private Integer amount_due;
	
	private Integer amount_paid;
	
	private Integer attempts;
	
	private Integer created_at;
	
	private String currency;
	
	private String entity;
	
	private String id;
	
	private Notes notes;
	
	private String offer_id;
	
	private Offers offers;
	
	private String receipt;
	
	private String paid;

	public Integer getAmount() {
		return amount;
	}

	public Integer getAmount_due() {
		return amount_due;
	}

	public Integer getAmount_paid() {
		return amount_paid;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public Integer getCreated_at() {
		return created_at;
	}

	public String getCurrency() {
		return currency;
	}

	public String getEntity() {
		return entity;
	}

	public String getId() {
		return id;
	}

	public Notes getNotes() {
		return notes;
	}

	public String getOffer_id() {
		return offer_id;
	}

	public Offers getOffers() {
		return offers;
	}

	public String getReceipt() {
		return receipt;
	}

	public String getPaid() {
		return paid;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setAmount_due(Integer amount_due) {
		this.amount_due = amount_due;
	}

	public void setAmount_paid(Integer amount_paid) {
		this.amount_paid = amount_paid;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public void setCreated_at(Integer created_at) {
		this.created_at = created_at;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public void setOffer_id(String offer_id) {
		this.offer_id = offer_id;
	}

	public void setOffers(Offers offers) {
		this.offers = offers;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}
	
	
}
