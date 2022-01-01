package com.medeil.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.MainGroup;
import com.medeil.repository.MainGroupRepository;
import com.medeil.repository.SubGroup1Repository;
import com.medeil.domain.SubGroup1;

@Service
public class SubGroup1Service {
	private static Logger logger = LogManager.getLogger();

	@PersistenceContext
	private EntityManager em;

	@Autowired
	SubGroup1Repository subGrouprepo;

	public boolean saveSubGroup1(SubGroup1 subgroup1) throws Exception {
		boolean saveflag = false;
		// try {
		System.out.println("abcd" + subgroup1.getSubgroupname1());
		subGrouprepo.save(subgroup1);
		System.out.println("abcd");
		saveflag = true;
		// } catch (Exception E) {
		// System.out.println("Error" + E);
		// }

		return saveflag;
	}

	public boolean updatesubgroup1(SubGroup1 subGroup1) {
		// TODO Auto-generated method stub
		subGrouprepo.updatesubgroup1(subGroup1.getSubgroupid1(),subGroup1.getSubgroupname1());
		return true;
	}
}
