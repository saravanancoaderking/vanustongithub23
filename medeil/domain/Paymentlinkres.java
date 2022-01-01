package com.medeil.domain;

public class Paymentlinkres {
	
	private String id;
	
	private String entity;
	
	private String receipt;
	
	private String invoice_number;
	
	private String customer_id;
	
	private Customer_details customer_details;

	private String order_id;
	
	private Integer payment_id;
	
	private String paystatus;

	private Integer expire_by;
	
	private Integer issued_at;

	private Integer paid_at;
	
	private Integer cancelled_at;
	
	private String expired_at;
	
	private String sms_status;
	
	private String email_status;
	
	private Integer date;
	
	private String terms;
	
	private String partial_payment;
	
	private Integer gross_amount;
	
	private Integer tax_amount;
	
	private Integer taxable_amount;
	
	private Integer amount;
	
	private Integer amount_paid;
	
	private Integer amount_due;
	
	private String currency;

	private String description;
	
	private String comment;
	
	private String short_url;

	private String view_less;
	
	private String billing_start;
	
	private String billing_end;
	
	private String type;

	private String group_taxes_discounts;
	
	private String created_at;

	public String getId() {
		return id;
	}

	public String getEntity() {
		return entity;
	}

	public String getReceipt() {
		return receipt;
	}

	public String getInvoice_number() {
		return invoice_number;
	}

	public Customer_details getCustomer_details() {
		return customer_details;
	}

	public String getOrder_id() {
		return order_id;
	}

	public Integer getPayment_id() {
		return payment_id;
	}

	public String getPaystatus() {
		return paystatus;
	}

	public Integer getExpire_by() {
		return expire_by;
	}

	public Integer getIssued_at() {
		return issued_at;
	}

	public Integer getPaid_at() {
		return paid_at;
	}

	public Integer getCancelled_at() {
		return cancelled_at;
	}

	public String getExpired_at() {
		return expired_at;
	}

	public String getSms_status() {
		return sms_status;
	}

	public String getEmail_status() {
		return email_status;
	}

	public Integer getDate() {
		return date;
	}

	public String getTerms() {
		return terms;
	}

	public String getPartial_payment() {
		return partial_payment;
	}

	public Integer getGross_amount() {
		return gross_amount;
	}

	public Integer getTax_amount() {
		return tax_amount;
	}

	public Integer getTaxable_amount() {
		return taxable_amount;
	}

	public Integer getAmount() {
		return amount;
	}

	public Integer getAmount_paid() {
		return amount_paid;
	}

	public Integer getAmount_due() {
		return amount_due;
	}

	public String getCurrency() {
		return currency;
	}
	
	public String getDescription() {
		return description;
	}

	public String getComment() {
		return comment;
	}

	public String getShort_url() {
		return short_url;
	}

	public String getView_less() {
		return view_less;
	}

	public String getBilling_start() {
		return billing_start;
	}

	public String getBilling_end() {
		return billing_end;
	}

	public String getType() {
		return type;
	}

	public String getGroup_taxes_discounts() {
		return group_taxes_discounts;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}

	public void setCustomer_details(Customer_details customer_details) {
		this.customer_details = customer_details;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public void setPaystatus(String paystatus) {
		this.paystatus = paystatus;
	}

	public void setExpire_by(Integer expire_by) {
		this.expire_by = expire_by;
	}

	public void setIssued_at(Integer issued_at) {
		this.issued_at = issued_at;
	}

	public void setPaid_at(Integer paid_at) {
		this.paid_at = paid_at;
	}

	public void setCancelled_at(Integer cancelled_at) {
		this.cancelled_at = cancelled_at;
	}

	public void setExpired_at(String expired_at) {
		this.expired_at = expired_at;
	}

	public void setSms_status(String sms_status) {
		this.sms_status = sms_status;
	}

	public void setEmail_status(String email_status) {
		this.email_status = email_status;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public void setPartial_payment(String partial_payment) {
		this.partial_payment = partial_payment;
	}

	public void setGross_amount(Integer gross_amount) {
		this.gross_amount = gross_amount;
	}

	public void setTax_amount(Integer tax_amount) {
		this.tax_amount = tax_amount;
	}

	public void setTaxable_amount(Integer taxable_amount) {
		this.taxable_amount = taxable_amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setAmount_paid(Integer amount_paid) {
		this.amount_paid = amount_paid;
	}

	public void setAmount_due(Integer amount_due) {
		this.amount_due = amount_due;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}

	public void setView_less(String view_less) {
		this.view_less = view_less;
	}

	public void setBilling_start(String billing_start) {
		this.billing_start = billing_start;
	}

	public void setBilling_end(String billing_end) {
		this.billing_end = billing_end;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setGroup_taxes_discounts(String group_taxes_discounts) {
		this.group_taxes_discounts = group_taxes_discounts;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getCustomer_id() {
		return customer_id;
	}

		public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

}
