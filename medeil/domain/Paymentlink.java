package com.medeil.domain;

public class Paymentlink {
	
	private Customer customer;
	
	private String type;
	
	private Integer view_less;
	
	private Integer amount;
	
	private String currency;
	
	private String description;
	
	private String receipt;
	
	private boolean reminder_enable;
	
	private Integer sms_notify;
	
	private Integer email_notify;
	
	private Integer expire_by;
	
	private String callback_url;

	private String callback_method;
		
	public Customer getCustomer() {
		return customer;
	}

	public String getType() {
		return type;
	}

	public Integer getView_less() {
		return view_less;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getDescription() {
		return description;
	}

	public String getReceipt() {
		return receipt;
	}

	public boolean isReminder_enable() {
		return reminder_enable;
	}

	public Integer getSms_notify() {
		return sms_notify;
	}

	public Integer getEmail_notify() {
		return email_notify;
	}

	public Integer getExpire_by() {
		return expire_by;
	}

	public String getCallback_url() {
		return callback_url;
	}

	public String getCallback_method() {
		return callback_method;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setView_less(Integer view_less) {
		this.view_less = view_less;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public void setReminder_enable(boolean reminder_enable) {
		this.reminder_enable = reminder_enable;
	}

	public void setSms_notify(Integer sms_notify) {
		this.sms_notify = sms_notify;
	}

	public void setEmail_notify(Integer email_notify) {
		this.email_notify = email_notify;
	}

	public void setExpire_by(Integer expire_by) {
		this.expire_by = expire_by;
	}

	public void setCallback_url(String callback_url) {
		this.callback_url = callback_url;
	}

}
