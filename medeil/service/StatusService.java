package com.medeil.service;

import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.repository.StatusRepository;

@SuppressWarnings("rawtypes")
@Service
public class StatusService {

	@Autowired
	private StatusRepository statusrepo;
	Query query;
	private static Logger logger = LogManager.getLogger();

	public List stsaleservice(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname,
			Integer soid) throws Exception {
		return statusrepo.stsalesropo(companyrefid, branchrefid, locrefid, locname, soid);

	}

	public List salessatus(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname, Integer soid)
			throws Exception {
		return statusrepo.salessatus(companyrefid, branchrefid, locrefid, locname, soid);
	}
}
