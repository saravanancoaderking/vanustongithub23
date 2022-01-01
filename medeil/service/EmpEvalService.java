package com.medeil.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.EmpEval;
import com.medeil.repository.EmpEvalRepository;

@SuppressWarnings("rawtypes")
@Service
public class EmpEvalService {

	@Autowired
	private EmpEvalRepository empEvalRepository;

	private static Logger logger = LogManager.getLogger();

	public boolean saveEmpEval(EmpEval empEval)throws Exception {
	//	try {
			System.out.println(empEval);
			empEvalRepository.save(empEval);
			return true;
	//	} catch (Exception cause) {
	//		logger.error("Exception in (EmpEval)Method : saveEmpEval() " + cause);
	//	}
	//	return false;
	}
}
