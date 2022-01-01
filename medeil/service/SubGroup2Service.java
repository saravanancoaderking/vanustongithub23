package com.medeil.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.SubGroup2;
import com.medeil.repository.SubGroup2Repository;

@Service

public class SubGroup2Service {
	private static Logger logger = LogManager.getLogger();

	@PersistenceContext
	private EntityManager em;

	@Autowired
	SubGroup2Repository subGroup2repo;

	public boolean saveSubGroup2(SubGroup2 subgroup2) throws Exception {
		boolean saveflag = false;
		// try {
		System.out.println("abcd" + subgroup2.getSubgroupname2());
		subGroup2repo.save(subgroup2);
		System.out.println("abcd");
		saveflag = true;
		// } catch (Exception E) {
		// System.out.println("Error" + E);
		// }

		return saveflag;
	}

	public boolean updatesubgroup2(SubGroup2 subgroup2) {
		// TODO Auto-generated method stub
		subGroup2repo.updatesubgroup1(subgroup2.getSubgroupid2(),subgroup2.getSubgroupname2());
		return true;
	}

}
