/**
 * 
 */
package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Purchasesession;
import com.medeil.repository.PurchasesessionRepository;

/**
 * @author Ajith Kumar
 */
@SuppressWarnings("rawtypes")
@Service
public class PurchasesessionService {
	static List paautoincr;
	private static Logger logger = LogManager.getLogger();

	@Autowired
	private PurchasesessionRepository purchasesessionrepository;

	List list;

	@PersistenceContext
	private EntityManager em;

	Query query;

	@Autowired
	private HttpSession session;

	Integer comp = 0;

	Integer brnch = 0;

	Integer loname = 0;

	Integer lorefid = 0;

	public List getSessionCompany(Integer compid) throws Exception {
		// list = null;
		// try {
		// list = purchasesessionrepository.getSessionCompany(compid);

		// } catch (Exception ec) {
		// logger.error("Exception in Method : getSessionCompany() " + ec);
		// }
		return purchasesessionrepository.getSessionCompany(compid);
	}

	public List getSessionBranch(Integer cid) throws Exception {
		// list = null;
		// try {
		// list = purchasesessionrepository.getSessionBranch(cid);/
		// } catch (Exception eb) {
		// logger.error("Exception in Method : getSessionBranch() " + eb);
		// }
		return purchasesessionrepository.getSessionBranch(cid);
	}

	public List getSessionShop(Integer cid, List<Integer> brid) throws Exception {
		list = null;
		// try {
		for (int i = 0; i < brid.size(); i++) {
			int bid = brid.get(i);
			list = purchasesessionrepository.getSessionShop(cid, bid);
		}
		// } catch (Exception es) {
		// logger.error("Exception in Method : getSessionShop() " + es);
		// }
		return list;
	}

	public List getSessionWarehouse(Integer cid, List<Integer> brid) throws Exception {
		list = null;
		// try {
		for (int i = 0; i < brid.size(); i++) {
			int bid = brid.get(i);
			list = purchasesessionrepository.getSessionWarehouse(cid, bid);
		}
		// } catch (Exception ew) {
		// logger.error("Exception in Method : getSessionWarehouse() " + ew);
		// }
		return list;
	}

	public List getSessionHospital(Integer cid, List<Integer> brid) throws Exception {
		list = null;
		// try {
		for (int i = 0; i < brid.size(); i++) {
			int bid = brid.get(i);
			list = purchasesessionrepository.getSessionHospital(cid, bid);
		}
		// } catch (Exception eh) {
		// logger.error("Exception in Method : getSessionHospital() " + eh);
		// }
		return list;
	}

	public List getpurcSessionTable(List<Integer> sid, List<Integer> wid, List<Integer> hid) throws Exception {
		list = null;
		List<Object> ls = new ArrayList<Object>();
		List<Object> sublist = new ArrayList<Object>();
		try {
			if (sid.isEmpty()) {
				return sid;
			}
			if (wid.isEmpty()) {
				return wid;
			}
			if (hid.isEmpty()) {
				return hid;
			}
			for (Integer si : sid) {
				ls = purchasesessionrepository.getpurcSessionTable(si, 0, 0);
			}

			for (Integer si : sid) {
				for (Integer wi : wid) {
					for (Integer hi : hid) {
						ls.add(purchasesessionrepository.getpurcSessionTable(si, wi, hi));
					}
				}
			}
			for (int start = 0; start < ls.size(); start += 5) {
				int end = Math.min(start + 5, ls.size());
				sublist = ls.subList(start, end);
			}
		} catch (Exception eh) {
			logger.error("Exception in Method : getpurcSessionTable() " + eh);
			throw new Exception(eh);
		}
		return ls;
	}

	// Boopalan 030419
	public List getpurcSessionShop(List<Integer> sid, Integer cid, Integer bid, Integer locname, Integer locrefid)
			throws Exception {
		list = null;
		// try {
		for (int i = 0; i < sid.size(); i++) {
			int id = sid.get(i);
			list = purchasesessionrepository.getpurcSessionShop(id, locrefid);
		}
		// } catch (Exception eh) {
		// logger.error("Exception in Method : getpurcSessionShop " + eh);
		// }
		return list;
	}

	public List getpurcSessionWarehouse(List<Integer> wid, Integer cid, Integer bid, Integer locname, Integer locrefid)
			throws Exception {
		list = null;
		// try {
		for (int i = 0; i < wid.size(); i++) {
			int id = wid.get(i);
			list = purchasesessionrepository.getpurcSessionWarehouse(id, cid, locname, locrefid);
		}
		// } catch (Exception eh) {
		// logger.error("Exception in Method : getpurcSessionWarehouse() " + eh);
		// }
		return list;
	}

	public List getpurcSessionHosp(List<Integer> hid, Integer cid, Integer bid, Integer locname, Integer locrefid)
			throws Exception {
		list = null;
		// try {
		for (int i = 0; i < hid.size(); i++) {
			int id = hid.get(i);
			list = purchasesessionrepository.getpurcSessionHosp(id, cid, locname, locrefid);
		}
		// } catch (Exception eh) {
		// logger.error("Exception in Method : getpurcSessionHosp() " + eh);
		// }
		return list;
	}

	public List getpurcSessionView(Integer id) throws Exception {
		// list = null;
		// try {
		// list = purchasesessionrepository.getpurcSessionView(id);
		// } catch (Exception ev) {
		// logger.error("Exception in Method : getpurcSessionView() " + ev);
		// }
		return purchasesessionrepository.getpurcSessionView(id);
	}

	/** CREATE PURCHASE SESSION **/
	public boolean savePurchaseSession(Purchasesession purchasesession) throws Exception {
		boolean flag = false;
		getAutoIncrement(purchasesession.getCompanyrefid(), purchasesession.getBranchrefid(),
				purchasesession.getLocname(), purchasesession.getLocrefid());
		System.out.println(purchasesession.getCompanyrefid() + " " + purchasesession.getBranchrefid() + " "
				+ purchasesession.getLocname() + " " + purchasesession.getLocrefid());

		String s = paautoincr.toString();
		purchasesession.setSessionno(s.substring(1, s.length() - 1));// Boopalan 100519
		System.out.println("Boopalan : " + purchasesession.getSessionno());
		try {
			StoredProcedureQuery purcSession = em.createStoredProcedureQuery("medc_purchase.pro_purcSession");
			purcSession.registerStoredProcedureParameter("sessionnos", String.class, ParameterMode.IN);
			purcSession.registerStoredProcedureParameter("sessiondates", String.class, ParameterMode.IN);
			purcSession.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
			purcSession.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
			purcSession.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
			purcSession.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
			purcSession.registerStoredProcedureParameter("clientdates", String.class, ParameterMode.IN);
			purcSession.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
			purcSession.setParameter("sessionnos", purchasesession.getSessionno());
			purcSession.setParameter("sessiondates", purchasesession.getSessiondate());
			purcSession.setParameter("companyrefids", purchasesession.getCompanyrefid());
			purcSession.setParameter("branchrefids", purchasesession.getBranchrefid());
			purcSession.setParameter("locnames", purchasesession.getLocname());
			purcSession.setParameter("locrefids", purchasesession.getLocrefid());
			purcSession.setParameter("clientdates", purchasesession.getClientcdate());
			/** Http Session **/

			comp = purchasesession.getCompanyrefid();
			brnch = purchasesession.getBranchrefid();
			loname = purchasesession.getLocname();
			lorefid = purchasesession.getLocrefid();

//			session.setAttribute("comp", purchasesession.getCompanyrefid());
//			session.setAttribute("brnch", purchasesession.getBranchrefid());
//			session.setAttribute("loname", purchasesession.getLocname());
//			session.setAttribute("lorefid", purchasesession.getLocrefid());
			purcSession.execute();
			Integer a = (Integer) purcSession.getOutputParameterValue("flag");
			if (a == 1) {
				flag = true;
			}
		} catch (Exception ex) {
			logger.error("Exception in Method : savePurchaseSession() " + ex);
			ex.printStackTrace();
			throw new Exception(ex);
		}
		return flag;
	}

	public boolean saveSessionproduct(List<Purchasesession> purchasesession) throws Exception {
		boolean reFlag = false;
		try {
			for (int index = 0; index < purchasesession.size(); index++) {
				Purchasesession ps = purchasesession.get(index);
				int cid = comp;
				int bid = brnch;
				int lname = loname;
				int lrefid = lorefid;
				Integer id = purchasesessionrepository.getmaxSession(cid, bid, lname, lrefid);
				int sid = id;
				StoredProcedureQuery sp = em.createStoredProcedureQuery("medc_purchase.pro_purcSessionproduct");
				sp.registerStoredProcedureParameter("checkboxs", Boolean.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("indentnos", String.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("indentdates", String.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("indentids", Integer.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("brandnames", String.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("waitboxqtys", Double.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("waitstripqtys", Double.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("waittabletqtys", Double.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("waittotqtys", Double.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("drugproids", Integer.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("psids", Integer.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("boxconvdrg", Double.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("stripconvdrg", Double.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("packageunit", String.class, ParameterMode.IN);
				sp.registerStoredProcedureParameter("reFlag", Integer.class, ParameterMode.OUT);
				sp.setParameter("checkboxs", ps.isCheckbox());
				sp.setParameter("indentnos", ps.getIndentno());
				sp.setParameter("indentdates", ps.getIndentdate());
				sp.setParameter("indentids", ps.getIndentid());
				sp.setParameter("brandnames", ps.getBrandname());
				sp.setParameter("waitboxqtys", ps.getWaitboxqty());
				sp.setParameter("waitstripqtys", ps.getWaitstripqty());
				sp.setParameter("waittabletqtys", ps.getWaittabletqty());
				sp.setParameter("waittotqtys", ps.getWaittotqty());
				sp.setParameter("drugproids", ps.getDrugproid());
				sp.setParameter("psids", sid);
				sp.setParameter("companyrefids", cid);
				sp.setParameter("branchrefids", bid);
				sp.setParameter("locnames", lname);
				sp.setParameter("locrefids", lrefid);
				sp.setParameter("boxconvdrg", ps.getBoxconvdrg());
				sp.setParameter("stripconvdrg", ps.getStripconvdrg());
				sp.setParameter("packageunit", ps.getPackageunit());
				sp.execute();
				Integer flag = (Integer) sp.getOutputParameterValue("reFlag");
				if (flag == 1 || flag == 2) {
					reFlag = true;
				}
			}
		} catch (Exception ep) {
			logger.error("Exception in Method : saveSessionproduct() " + ep);
			ep.printStackTrace();
		} finally {
			session.invalidate();
		}
		return reFlag;
	}

	public List getViewSessiontable(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		// list = null;
		// try {
		// list = purchasesessionrepository.getViewSessiontable(cid, bid, locname,
		// locrefid);
		// } catch (Exception Ev) {
		// logger.error("Exception in Method : getViewSessiontable() " + Ev);
		// }
		return purchasesessionrepository.getViewSessiontable(cid, bid, locname, locrefid);
	}

	public List getSessionDetails(Integer id) throws Exception {
		// list = null;
		// try {
		// list = purchasesessionrepository.getSessionDetails(id);
		// } catch (Exception Ed) {
		// logger.error("Exception in Method : getSessionDetails() " + Ed);
		// }
		return purchasesessionrepository.getSessionDetails(id);
	}

	public List getSessionChart() throws Exception {
		return purchasesessionrepository.getChartdata();
	}

	public List getSessionAll(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		// list = null;
		// try {
		// list = purchasesessionrepository.getSessionAll(cid, bid, locname, locrefid);
		// } catch (Exception Ev) {
		// logger.error("Exception in Method : getSessionAll() " + Ev);
		// }
		return purchasesessionrepository.getSessionAll(cid, bid, locname, locrefid);
	}

	/* Boo 280319 */
	public void getAutoIncrement(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		List val = null;
		try {
			String value = "CALL medc_purchase.pro_purcsessautoincrement(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "purchasesession");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}
		paautoincr = val;
	}

	public List getpurcSessionhqShop(List<Integer> sid, Integer cid, Integer bid, Integer locname, Integer locrefid)
			throws Exception {
		list = null;
		// try {
		for (int i = 0; i < sid.size(); i++) {
			int id = sid.get(i);
			System.out.println("suma" + id);
			list = purchasesessionrepository.getpurcSessionhqShopdata(id, locname, cid, bid);
		}
		// } catch (Exception eh) {
		// logger.error("Exception in Method : getpurcSessionShop " + eh);
		// }
		return list;
	}

	public List getpurcSessionnonwaiting(Integer sid, Integer cid, Integer bid, Integer locname, Integer locrefid) {
		list = null;
			list = purchasesessionrepository.getpurcSessionnonwaiting(sid, locrefid);
		// } catch (Exception eh) {
		// logger.error("Exception in Method : getpurcSessionShop " + eh);
		// }
		return list;
	}

}
