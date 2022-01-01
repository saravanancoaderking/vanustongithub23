package com.medeil.domain;

public class Customerpayment {
	
	private Integer amount;
	
	private String currency;
	
	private String accept_partial;
	
	private Integer first_min_partial_amount;
	
	private Integer expire_by;
	
	private String reference_id;
	
	private String description;

	private String name;
	
	private String contact;
	
	private String email;
	
	private Notify notify;
	
	private String reminder_enable;
	
	private Notes notes;

	private String String;
	
	private String callback_method;

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getAccept_partial() {
		return accept_partial;
	}

	public Integer getFirst_min_partial_amount() {
		return first_min_partial_amount;
	}

	public Integer getExpire_by() {
		return expire_by;
	}

	public String getReference_id() {
		return reference_id;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public String getContact() {
		return contact;
	}

	public String getEmail() {
		return email;
	}

	public Notify getNotify() {
		return notify;
	}

	public String getReminder_enable() {
		return reminder_enable;
	}

	public Notes getNotes() {
		return notes;
	}

	public String getString() {
		return String;
	}

	public String getCallback_method() {
		return callback_method;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setAccept_partial(String accept_partial) {
		this.accept_partial = accept_partial;
	}

	public void setFirst_min_partial_amount(Integer first_min_partial_amount) {
		this.first_min_partial_amount = first_min_partial_amount;
	}

	public void setExpire_by(Integer expire_by) {
		this.expire_by = expire_by;
	}

	public void setReference_id(String reference_id) {
		this.reference_id = reference_id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNotify(Notify notify) {
		this.notify = notify;
	}

	public void setReminder_enable(String reminder_enable) {
		this.reminder_enable = reminder_enable;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public void setString(String string) {
		String = string;
	}

	public void setCallback_method(String callback_method) {
		this.callback_method = callback_method;
	}
	
	
}
