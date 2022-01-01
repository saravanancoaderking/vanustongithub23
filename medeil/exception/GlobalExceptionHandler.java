package com.medeil.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.NoSuchFileException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.medeil.domain.IneConnectionException;
import com.medeil.domain.IneInvalidPaymentOrderException;
import com.medeil.domain.IneInvalidRefundException;
import com.medeil.service.Impl.ExceptionServiceImpl;
import com.paypal.base.rest.PayPalRESTException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ExceptionServiceImpl impl;

	/**
	 * @param ex
	 * @param reqest
	 * @param handlerMethod
	 * @param httpRequest
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = { Exception.class, DataIntegrityViolationException.class, MessagingException.class,
			IOException.class, IneConnectionException.class, IneInvalidPaymentOrderException.class,
			IneInvalidRefundException.class, InterruptedException.class, PayPalRESTException.class,
			FileNotFoundException.class, RemoteException.class, ParserConfigurationException.class,
			TransformerException.class, UnknownHostException.class, SocketException.class, SQLException.class,
			GenericJDBCException.class, Throwable.class, NoSuchFileException.class })
	private ResponseEntity<?> handleAnyException(Exception ex, HandlerMethod handlerMethod,
			HttpServletRequest httpRequest) throws Exception {
		ExceptionResponse resp = new ExceptionResponse();

		String[] exp = ExceptionUtils.getStackFrames(ex);
		resp.setControllerName(handlerMethod.getMethod().getName().toString());
		resp.setApiUrl(httpRequest.getRequestURL().toString());
		resp.setTimestamp(new Date());
		resp.setMessage(ex.getMessage());
		resp.setException(exp.toString());
		impl.saveErrorLog(resp);
		HashMap<String, String> errorMessage = new HashMap<String, String>();
		errorMessage.put("message", ex.toString());
		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

	}

}
