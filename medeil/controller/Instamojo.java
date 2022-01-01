package com.medeil.controller;

import com.medeil.domain.*;

import com.medeil.util.*;

/**
 * The Interface Instamojo.
 */
public interface Instamojo {

    /**
     * Initiates a payment order with Instamojo.
     * There can only be one Instamojo payment order for a transaction in your system (transaction in your system being identified by transaction_id)
     *
     * @param paymentOrder the payment order
     * @return the creates the payment order response
     * @throws IneConnectionException          the connection exception
     * @throws IneInvalidPaymentOrderException the invalid payment order exception
     */
    InrCreatePaymentOrderResponse createNewPaymentOrder(InmPaymentOrder paymentOrder) throws IneConnectionException, IneInvalidPaymentOrderException;

    /**
     * Get the details of the specified order (identified by id).
     *
     * @param id the id	
     * @return the payment order details
     * @throws IneConnectionException the connection exception
     */
    InrPaymentOrderDetailsResponse getPaymentOrderDetails(String id) throws IneConnectionException;

    /**
     * Get the details of the specified order (identified by transaction id).
     *
     * @param transactionId the transaction id
     * @return the payment order details by transaction id
     * @throws IneConnectionException the connection exception
     */
    InrPaymentOrderDetailsResponse getPaymentOrderDetailsByTransactionId(String transactionId) throws IneConnectionException;

    /**
     * Gets the payment order list.
     * This endpoint returns paginated results of all your payment orders. This endpoint also supports filtering by some parameters.
     *
     * @param paymentOrderFilter the payment order filter
     * @return the payment order list
     * @throws IneConnectionException the connection exception
     */
    InrPaymentOrderListResponse getPaymentOrderList(InmPaymentOrderFilter paymentOrderFilter) throws IneConnectionException;

	/**
	 * Creates the new refund.
	 *
	 * @param refund the refund
	 * @return the creates the refund response
	 * @throws IneConnectionException the connection exception
	 * @throws IneInvalidRefundException the invalid refund exception
	 */
	InrCreateRefundResponse createNewRefund(InmRefund refund) throws IneConnectionException, IneInvalidRefundException;
}
