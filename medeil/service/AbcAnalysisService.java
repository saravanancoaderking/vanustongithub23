package com.medeil.service;

/*************************************************************************
 * 
 * Vanuston CONFIDENTIAL
 * __________________
 * 
 *  [2009] - [2019] Vanuston Intelligence Pvt.Ltd  
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Vanuston Intelligence Pvt.Ltd and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Vanuston Intelligence Pvt.Ltd
 * and its suppliers and may be covered by Indian and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Vanuston Intelligence Pvt.Ltd.
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medeil.repository.AbcAnalysisRepository;

/**
 * 
 * @author Boopalan Alagesan
 * @Date 03-09-2019
 *
 */
@Service
public class AbcAnalysisService {
	@PersistenceContext
	EntityManager em;

	Query query;

	@Autowired
	AbcAnalysisRepository abcAnalysisRepository;

	/**
	 * This Method(shopslist()) Calls Stored Procedure to get list of shops placed
	 * Sales Invoice
	 */
	public void shopslist() {

		try {
			String q = "Call medc_abcanalysis.medc_salesshops()";
			query = em.createNativeQuery(q);
			query.getResultList();

		} catch (Exception e) {
		}

	}

	/**
	 * This Method(shopsiterator()) Calls Stored Procedure to update ABC value to
	 * Main Stock Table.
	 * 
	 */
	public List shopsiterator() {
		int counts = abcAnalysisRepository.counts();

		for (int i = 1; i <= counts; i++) {
			Integer[][] a = abcAnalysisRepository.shopsiterator(i);
			try {

				String q = "Call medc_abcanalysis.medc_abcprocedure(?,?,?,?)";
				query = em.createNativeQuery(q);
				query.setParameter(1, a[0][0]);
				query.setParameter(2, a[0][1]);
				query.setParameter(3, a[0][2]);
				query.setParameter(4, a[0][3]);
				query.getResultList();

			} catch (Exception e) {
			}
		}
		return null;

	}

}
