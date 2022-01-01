package com.medeil.domain;

import com.google.gson.annotations.SerializedName;


/**
 * The Class CreatePaymentOrderResponse.
 */
public class InrCreatePaymentOrderResponse extends InrResponse {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2402922891686730624L;

    /** The payment order. */
    @SerializedName("order")
	private InmPaymentOrder paymentOrder;
    
    /** The payment options. */
    @SerializedName("payment_options")
    private InmPaymentOptions paymentOptions;

    /**
     * Gets the payment order.
     *
     * @return the payment order
     */
    public InmPaymentOrder getPaymentOrder() {
        return paymentOrder;
    }

    /**
     * Sets the payment order.
     *
     * @param paymentOrder the new payment order
     */
    public void setPaymentOrder(InmPaymentOrder paymentOrder) {
        this.paymentOrder = paymentOrder;
    }

    /**
     * Gets the payment options.
     *
     * @return the payment options
     */
    public InmPaymentOptions getPaymentOptions() {
		return paymentOptions;
	}

	/**
	 * Sets the payment options.
	 *
	 * @param paymentOptions the new payment options
	 */
	public void setPaymentOptions(InmPaymentOptions paymentOptions) {
		this.paymentOptions = paymentOptions;
	}

	/* (non-Javadoc)
	 * @see com.instamojo.wrapper.response.Response#toString()
	 */
	@Override
	public String toString() {
		return "CreatePaymentOrderResponse{" + "paymentOrder=" + paymentOrder +
				", paymentOptions=" + paymentOptions +
				", success=" + success +
				", message='" + message + '\'' +
				", jsonResponse='" + jsonResponse + '\'' +
				'}';
	}
}
