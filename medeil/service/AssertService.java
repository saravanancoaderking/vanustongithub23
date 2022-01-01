package com.medeil.service;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.generalAssert;
import com.medeil.repository.AssertRepository;

@SuppressWarnings("rawtypes")
@Service
public class AssertService {
	@Autowired
	private AssertRepository assertRepo;
	EntityManager em;
	private static Logger logger = LogManager.getLogger();
	
	public boolean saveAssert(generalAssert assertService)throws Exception {

		try {
			assertRepo.save(assertService);
			return true;
		} catch (Exception e) {
			logger.error("Exception in (Picking)Method : saveAssert() " + e);
		}
		return false;
	}
}
