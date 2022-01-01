package com.medeil.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.GenericMaster;
import com.medeil.repository.GenericMasterRepository;

@Service
public class GenericMasterService {
	private static Logger logger = LogManager.getLogger();

	@PersistenceContext
	private EntityManager em;

	
	@Autowired
	GenericMasterRepository genericmasterrepo;

	

	public boolean saveGenericName(GenericMaster genericname)throws Exception  {
		
		boolean saveflag = false;
	//	try {
			System.out.println("Inside save Tax service try"+genericname.getGenericname());
			genericmasterrepo.save(genericname);
			System.out.println("abcd");
			saveflag = true;
	//	} catch (Exception E) {
	//		System.out.println("Error"+ E);
	//	}
		
		return saveflag;
	}

}
