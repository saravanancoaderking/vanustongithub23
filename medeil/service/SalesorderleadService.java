package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.repository.SalesorderleadRespository;

@SuppressWarnings("rawtypes")
@Service
public class SalesorderleadService {

	@Autowired
	private SalesorderleadRespository salesorderleadRepository;

	@Autowired
	private SalesorderleadRespository salesorderRepository;

	@PersistenceContext
	EntityManager em;
	Query query;
	private static Logger logger = LogManager.getLogger();

	public List soleadlist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname)
			throws Exception {
		return salesorderleadRepository.soleadlist(companyrefid, branchrefid, locrefid, locname);
	}

	public List omnisoleadlist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname)
			throws Exception {
		return salesorderleadRepository.omnisoleadlist(companyrefid, branchrefid, locrefid, locname);
	}

	public List soleadtypelist(Integer salesleadid) throws Exception {
		return salesorderleadRepository.soleadtypelist(salesleadid);
	}

	public List soleadpatientlist(Integer salesleadid) throws Exception {
		return salesorderleadRepository.soleadpatientlist(salesleadid);
	}

	public List soleadrecordlist(Integer salesleadid) throws Exception {
		return salesorderleadRepository.soleadrecordlist(salesleadid);
	}

	public List getsolproducts(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer soid)
			throws Exception {
		List val = null;
		try {
			String value = "CALL medc_sales.medc_addstocksol(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, cid);
			query.setParameter(2, bid);
			query.setParameter(3, locname);
			query.setParameter(4, locrefid);
			query.setParameter(5, soid);
			val = query.getResultList();

		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}
		return val;
	}

	public List fetchsoleadlist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname,
			Integer soid) throws Exception {
		return salesorderleadRepository.fetchsoleadlist(companyrefid, branchrefid, locrefid, locname, soid);
	}

	// Boopalan Alagesan 180919 10:24AM
	public List getProductdata(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer productid,
			Double qty) throws Exception {
		int flag;
		try {
			System.out.println("  " + " Boopalan");
			String q = "Call medc_sales.medc_checksalesorderproduct(?,?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, cid);
			query.setParameter(2, bid);
			query.setParameter(3, locname);
			query.setParameter(4, locrefid);
			query.setParameter(5, productid);
			query.setParameter(6, qty);
			query.getResultList();

		} catch (Exception e) {
			throw new Exception(e);
		}
		/**
		 * NOTE : TAKE CARE ON RESULT SET: 0 for active product, 1 for active product
		 * but insufficient quantity, 2 for product not available.
		 */
		flag = salesorderRepository.flagid(productid);
		if (flag == 2) {
			return salesorderRepository.getProductdata2(productid);
		} else if (flag == 1) {
			return salesorderRepository.getProductdata1(productid);
		}
		return salesorderRepository.getProductdata0(productid);
	}

//	public List fetchsoleadrecord(Integer salesleadid) {
//		return salesorderleadRepository.fetchsoleadrecord(salesleadid);
//	}

	public List addsoproduct(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname, Integer data)
			throws Exception {
		return salesorderleadRepository.addsoproduct(companyrefid, data);
	}

	public List stockcheck(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname, Integer data)
			throws Exception {
		return salesorderleadRepository.stockcheck(companyrefid, data);
	}

	// Boopalan Alagesan 160919 04:55PM
	public List fetchsoleadrecord(Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid,
			Integer salesleadid) throws Exception {
		try {

			String q = "Call medc_sales.medc_stockvalidate(?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, companyrefid);
			query.setParameter(2, branchrefid);
			query.setParameter(3, locname);
			query.setParameter(4, locrefid);
			query.setParameter(5, salesleadid);
			query.getResultList();

		} catch (Exception e) {
			throw new Exception(e);
		}
		/**
		 * NOTE : TAKE CARE ON [fetchsoleadrecord] RESULT SET: [sp.flagid as flag] 0 for
		 * active product, 1 for active product but insufficient quantity, 2 for product
		 * not available.
		 */
		return salesorderleadRepository.fetchsoleadrecord(salesleadid);
	}

	public byte[] getsendImage(Integer orderid) throws Exception {
		return salesorderRepository.getsendImage(orderid);
	}

}
