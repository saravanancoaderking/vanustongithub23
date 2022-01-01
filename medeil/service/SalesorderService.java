/**
 * 
 */
package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.SalesOrderRecord;
import com.medeil.domain.Salesorder;
import com.medeil.repository.SalesorderRepository;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class SalesorderService {
	static String medc_salesordertrack_statusdate;// Boopalan 210919
	static int compids;
	static int branchids;
	static int locids;
	static int locnameids;

	@Autowired
	private SalesorderRepository salesorderRepository;

	@PersistenceContext
	private EntityManager em;

	Query query;

	@Autowired
	private HttpSession session;

	private static Logger logger = LogManager.getLogger();

	public List searchProduct(String data, Integer cid, Integer bid, Integer locrefid, Integer locname)
			throws Exception {
		return salesorderRepository.searchProduct(data, cid);
	}

	public List patientList(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		return salesorderRepository.patientList(locrefid, locname);
	}

	public List getProductdata(Integer productid) throws Exception {
		return salesorderRepository.getProductdata(productid);
	}

	public Boolean createSalesOrder(Salesorder salesorder) throws Exception {
		boolean flag = false;
		System.out.println("salesorder no");
		salesorder.setSalesorderno(getAutoIncrement(salesorder.getCompanyrefid(), salesorder.getBranchrefid(),
				salesorder.getLocrefid(), salesorder.getLocname()).get(0).toString());
		System.out
				.println("cbl" + salesorder.getCompanyrefid() + salesorder.getBranchrefid() + salesorder.getLocrefid());
		System.out.println("salesorder no" + salesorder.getSalesorderno());
		try {
			if (!salesorder.equals("") || !salesorder.equals(null)) {
				session.setAttribute("comp", salesorder.getCompanyrefid());
				session.setAttribute("branch", salesorder.getBranchrefid());
				session.setAttribute("lcrefid", salesorder.getLocrefid());
				session.setAttribute("lcname", salesorder.getLocname());
				medc_salesordertrack_statusdate = salesorder.getClientcdate();
				compids = salesorder.getCompanyrefid();
				branchids = salesorder.getBranchrefid();
				locids = salesorder.getLocname();
				locnameids = salesorder.getLocrefid();
		
				// Boopalan 200919 - For capturing date and time to
				// medc_status.medc_salesordertrack
				salesorderRepository.save(salesorder);
				salesorderRepository.updateleadsostatus(salesorder.getSalesleadno());
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			logger.error("Exception in Method : createSalesOrder() " + e);
			throw new Exception(e);
		}
		return flag;
	}

	@Transactional
	public Boolean createSalesOrderRecord(List<SalesOrderRecord> salesorder) throws Exception {
		boolean flag = false;
		try {
			int cid = compids;
			int bid = branchids;
			int lid = locids;
			int lname = locnameids;
			Integer maxID = salesorderRepository.getMaID(cid, bid, lid, lname);
			for (int i = 0; i < salesorder.size(); i++) {
				SalesOrderRecord so = salesorder.get(i);
				String value = "CALL medc_sales.medc_salesOrder(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ?)";
				query = em.createNativeQuery(value);
				query.setParameter(1, maxID);
				query.setParameter(2, so.getDrugproductid());
				query.setParameter(3, so.getBoxqty());
				query.setParameter(4, so.getStripqty());
				query.setParameter(5, so.getTotalqty());
				query.setParameter(6, so.getTotalqty());
				query.setParameter(7, "save");
				query.setParameter(8, cid);
				query.setParameter(9, bid);
				query.setParameter(10, lid);
				query.setParameter(11, lname);
				query.setParameter(12,so.getMainstockrefid());
				int reVal = query.executeUpdate();
				if (reVal == 1) {
					flag = true;
				} else {
					flag = false;
				}
			}
			salesorderRepository.save_medc_salesordertrack(maxID, 1, medc_salesordertrack_statusdate);
			// Boopalan 200919 - For saving data
			// medc_status.medc_salesordertrack
		} catch (Exception e) {
			logger.error("Exception in Method : createSalesOrderRecord() " + e);
		} finally {
			session.removeAttribute("comp");
			session.removeAttribute("branch");
			session.removeAttribute("lcrefid");
			session.removeAttribute("lcname");
		}
		return flag;
	}

	public List viewSalesOrder(Integer drugID) throws Exception {
		return salesorderRepository.viewSalesOrder(drugID);
	}

	public List getAll(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		return salesorderRepository.getAll(cid, bid, locrefid, locname);
	}

	public List getomnisalesAll(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		return salesorderRepository.getomnisalesAll(cid, bid, locrefid, locname);
	}

	public List getAutoIncrement(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		List val = null;
		try {
			String value = "CALL medc_sales.pro_solautoincrement(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "salesorder");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locrefid);
			query.setParameter(5, locname);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}
		return val;
	}

	/** EDIT SALES ORDER */
	public Salesorder editSalesOrder(Integer id) throws Exception {
		return salesorderRepository.findById(id);
	}

	public List editSalesRecord(Integer id) throws Exception {
		return salesorderRepository.editSalesRecord(id);
	}

	public Boolean updateSalesorderData(Salesorder salesorder) throws Exception {
		boolean flag = false;
		// try {
		if (!salesorder.equals("") || !salesorder.equals(null)) {
			salesorderRepository.save(salesorder);
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception e) {
		// logger.error("Exception in Method : updateSalesOrder() " + e);
		// }
		return flag;
	}

	@Transactional
	public Boolean updateSalesRecord(List<SalesOrderRecord> salesorder) throws Exception {
		boolean flag = false;
		try {
			for (int i = 0; i < salesorder.size(); i++) {
				SalesOrderRecord so = salesorder.get(i);
				String value = "CALL medc_sales.medc_salesOrder(? , ? , ? , ? , ? , ? , ?, ? , ? , ? , ?)";
				query = em.createNativeQuery(value);
				query.setParameter(1, so.getSalesorderrefid());
				query.setParameter(2, so.getDrugproductid());
				query.setParameter(3, so.getBoxqty());
				query.setParameter(4, so.getStripqty());
				query.setParameter(5, so.getTotalqty());
				query.setParameter(6, so.getTotalqty());
				query.setParameter(7, "update");
				query.setParameter(8, so.getCompanyrefid());
				query.setParameter(9, so.getBranchrefid());
				query.setParameter(10, so.getLocname());
				query.setParameter(11, so.getLocrefid());
				int reVal = query.executeUpdate();
				if (reVal == 1) {
					flag = true;
				} else {
					flag = false;
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Method : updateSalesRecord() " + e);
			throw new Exception(e);
		}
		return flag;
	}

	/* Get sales Order Type */ /* Boo */
	public List getsalesOrderType() throws Exception {

		return salesorderRepository.getsalesOrderType();
	}

	/** DELETE SALES ORDER */ // Boo
	public boolean deleteSalesOrder(int soid) throws Exception {
		boolean ob = false;
//		try {

		int a = salesorderRepository.deleteSalesOrder(soid);
		return ob = true;

		// } catch (Exception e) {
		// logger.error("Exception in Method : deleteSalesOrder() " + e);
		// }
		// return ob;
	}

	public List CustomerSearch(String data, int cid, int bid, int locname, int locrefid) throws Exception {
		return salesorderRepository.CustomerSearch(data, cid, bid, locname, locrefid);
	}

	public List CustsalesOrder(int data, int cid, int bid, int locname, int locrefid) throws Exception {
		return salesorderRepository.CustsalesOrder(data, cid, bid, locname, locrefid);
	}

	public List CustsalesOrderstatus(int data, int cid, int bid, int locname, int locrefid) throws Exception {
		return salesorderRepository.CustsalesOrderstatus(data, cid, bid, locname, locrefid);
	}

	// Kishore 140919
	public List getAllList(int cid, int bid, int locname, int locrefid) throws Exception {
		return salesorderRepository.getAllList(cid, bid, locname, locrefid);
	}

	// Boopalan 210919
	public List getSalesOrderRefIDDetails(int soid) throws Exception {
		return salesorderRepository.getSalesOrderRefIDDetails(soid);
	}

	// getcust track details
	public List getCusttrack(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer orderid)
			throws Exception {

		return salesorderRepository.getCusttrack(cid, bid, locname, locrefid, orderid);
	}

	public List viewsalesorder(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer orderid)
			throws Exception {

		return salesorderRepository.viewsalesorder(cid, bid, locname, locrefid, orderid);
	}

	public List custsalesOrdermobile(int data, int cid, int bid, int locname, int locrefid) throws Exception {
		return salesorderRepository.custsalesOrdermobile(data, cid, bid, locname, locrefid);
	}

	public void salesOrderArchive() throws Exception {
		try {
			String q = "Call medc_sales.pro_salesorder_archive()";
			query = em.createNativeQuery(q);
			query.getResultList();

		} catch (Exception e) {
			throw new Exception(e);
		}

	}

}
