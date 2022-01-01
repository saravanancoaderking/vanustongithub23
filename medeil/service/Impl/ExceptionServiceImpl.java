package com.medeil.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.ErrorLog;
import com.medeil.exception.ExceptionResponse;
import com.medeil.repository.ErrorLogRepository;

@Service
public class ExceptionServiceImpl {

	@Autowired
	private ErrorLogRepository errorLogRepository;

	/**
	 * @param resp
	 */
	public void saveErrorLog(ExceptionResponse resp) throws Exception {
		ErrorLog log = new ErrorLog();
		log.setExceptionTime(resp.getTimestamp().toString());
		log.setMessage(resp.getMessage());
		log.setException(resp.getException());
		log.setControllerName(resp.getControllerName());
		log.setApiUrl(resp.getApiUrl());
		errorLogRepository.save(log);
	}

}
