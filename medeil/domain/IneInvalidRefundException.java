package com.medeil.domain;
/**
 * The Class InvalidRefundException.
 */
public class IneInvalidRefundException extends IneInstamojoBaseException {

	/**
	 * Instantiates a new invalid refund exception.
	 *
	 * @param message the message
	 * @param cause   the cause
	 */
	public IneInvalidRefundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new invalid refund exception.
	 */
	public IneInvalidRefundException() {
	}

	/**
	 * Instantiates a new invalid refund exception.
	 *
	 * @param message the message
	 */
	public IneInvalidRefundException(String message) {
		super(message);
	}
}
