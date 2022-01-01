package com.medeil.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.MainGroup;
import com.medeil.repository.MainGroupRepository;

@Service
public class MainGroupService {
	private static Logger logger = LogManager.getLogger();

	@PersistenceContext
	private EntityManager em;

	@Autowired
	MainGroupRepository mainGrouprepo;

	public boolean savemaingroup(MainGroup maingroup)throws Exception {
		boolean saveflag = false;
	//	try {
			System.out.println("abcd"+maingroup.getGroupname());
			mainGrouprepo.save(maingroup);
			System.out.println("abcd");
			saveflag = true;
	//	} catch (Exception E) {
	//		System.out.println("Error" + E);
	//	}

		return saveflag;
	}

	public boolean updatemaingroup(MainGroup maingroup) {
		mainGrouprepo.updatemaingroup(maingroup.getGroupid(),maingroup.getGroupname());
		return true;
	}
	
}
