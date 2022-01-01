package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Damage_stock;
import com.medeil.domain.Damagestock;
import com.medeil.domain.Stocks;
import com.medeil.repository.DamagestockProductRepository;
import com.medeil.repository.DamagestockRepository;
import com.medeil.repository.StocksRepository;

@SuppressWarnings("rawtypes")
@Service
public class DamagestockService {

	private int damageformid;

	@Autowired
	DamagestockRepository damagestockRepository;
	@Autowired
	DamagestockProductRepository damageproductrepository;
	@Autowired
	private StocksRepository stocksRepository;
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private HttpSession session;

	List list;

	Query query;

	private static Logger logger = LogManager.getLogger();

	public List getInvoice(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		list = null;
		// try {

		list = damagestockRepository.getInvoiceinfo(cid, bid, locrefid, locname);
		// } catch (Exception e) {
		// logger.error("Exception in Method :getInvoice() " + e);
		// }
		return list;
	}

	public List getLoc() throws Exception {

		return damagestockRepository.getLocc();
	}

	public List getLocref(Integer locname) throws Exception {
		list = null;
		// try {
		if (locname == 1) {// Shop
			list = damagestockRepository.getshopinfo();
		}
		if (locname == 2) {// Warehouse
			list = damagestockRepository.getwareInfo();
		}
		if (locname == 3) {// Hosp
			list = damagestockRepository.gethospInfo();
		}
		// } catch (Exception e) {
		// logger.error("Exception in Methos: getLocref" + e);
		// }
		return list;
	}

	public List getdamageAutoinc(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		List val = null;
		// try {
		String value = "CALL medc_purchasereturn.pro_damagestkautoinc(?, ?, ?, ?, ?)";
		query = em.createNativeQuery(value);
		query.setParameter(1, "damagestock");
		query.setParameter(2, cid);
		query.setParameter(3, bid);
		query.setParameter(4, locrefid);
		query.setParameter(5, locname);
		val = query.getResultList();
		// } catch (Exception e) {
		// logger.error("Exception in Method : getAutoIncrement() " + e);
		// }
		return val;
	}

	public List getInvoicedetails(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer id)
			throws Exception {

		return damagestockRepository.invoicedtails(cid, bid, locrefid, locname, id);
	}

	public List getPiproduct(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer id) throws Exception {
		return damagestockRepository.pidetails(cid, bid, locrefid, locname, id);
	}

	Integer da;
	Integer editda;
	String clientdate;

	/** CREATE DAMAGE STOCK RECORD **/
	public boolean createDamagestock(Damagestock damagestock) throws Exception {
		boolean flag = true;
		if (flag == true) {
			String lastid = damagestockRepository.lastPurchasedc(damagestock.getCompanyrefid(),
					damagestock.getBranchrefid(), damagestock.getLocname(), damagestock.getLocrefid());

			System.out.println("Lastid****" + lastid);
			String oldInco = lastid.substring(lastid.length() - 9, lastid.length());

			System.out.println("Oldincno***" + oldInco);
			Long newInco = Long.parseLong(oldInco) + 1;
			String newid = StringUtils.leftPad(newInco.toString(), 9, "0");
			damagestock.setDamagestockno("DAM" + newid);
			System.out.println("DESINGRAJA********" + newid);
			damagestockRepository.save(damagestock);

			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	// ** Save Damage Stock Product **//

	public boolean createDamagetable(List<Damage_stock> Damage_stock) throws Exception {
		boolean flag = true;
		if (flag == true) {
			for (Damage_stock dproduct : Damage_stock) {
				dproduct.setDamagestkrefid(damagestockRepository.getdamagestkid());
				damageproductrepository.save(dproduct);
				damageproductrepository.updatemainstock(dproduct.getStkproductrefid(), dproduct.getBatchnumber(),
						dproduct.getDamagedqty(), dproduct.getCompanyrefid(), dproduct.getBranchrefid(),
						dproduct.getLocname(), dproduct.getLocrefid());
				flag = true;
			}

		} else {
			flag = false;
		}
		return flag;
	}

//	public boolean createDamagestock(Damagestock damagestock) throws Exception, SQLException {
//		//System.out.println("inside create");
//		boolean flag = false;
//		try {
//			String function = "SAVE";
//			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("medc_purchasereturn.pro_damagestock");
//			storedProcedure.registerStoredProcedureParameter("damagestockdates", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("invoicedates", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("invoicenos", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("distnames", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("vendorids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("contactnos", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalamounts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("remarkss", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("packings", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("damagestocknos", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("createdbys", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("fromlocnames", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("fromlocrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("tolocnames", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("tolocrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("damagestkids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("clientcdates", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
//			storedProcedure.registerStoredProcedureParameter("damid", Integer.class, ParameterMode.OUT);
//			storedProcedure.registerStoredProcedureParameter("clientdate", String.class, ParameterMode.OUT);
//			storedProcedure.registerStoredProcedureParameter("exception", String.class, ParameterMode.OUT);
//			storedProcedure.setParameter("damagestockdates", damagestock.getDamagestockdate());
//			storedProcedure.setParameter("invoicedates", damagestock.getInvoicedate());
//			storedProcedure.setParameter("invoicenos", damagestock.getInvoiceno());
//			storedProcedure.setParameter("distnames", damagestock.getDistname());
//			storedProcedure.setParameter("vendorids", damagestock.getVendorid());
//			//System.out.println("check0:" + damagestock.getDamagestockno());
//			storedProcedure.setParameter("contactnos", damagestock.getContactno());
//			storedProcedure.setParameter("totalamounts", damagestock.getTotalamount());
//			storedProcedure.setParameter("remarkss", damagestock.getRemarks());
//			storedProcedure.setParameter("packings", damagestock.getPacking());
//			//System.out.println("check1:" + damagestock.getDamagestockno());
//			storedProcedure.setParameter("damagestocknos", damagestock.getDamagestockno());
//			//System.out.println("check2:" + damagestock.getDamagestockno());
//			storedProcedure.setParameter("createdbys", damagestock.getCreatedby());
//			storedProcedure.setParameter("companyrefids", damagestock.getCompanyrefid());
//			storedProcedure.setParameter("branchrefids", damagestock.getBranchrefid());
//			storedProcedure.setParameter("locnames", damagestock.getLocname());
//			storedProcedure.setParameter("locrefids", damagestock.getLocrefid());
//			storedProcedure.setParameter("fromlocnames", damagestock.getFromlocname());
//			storedProcedure.setParameter("fromlocrefids", damagestock.getFromlocrefid());
//			storedProcedure.setParameter("tolocnames", damagestock.getTolocname());
//			storedProcedure.setParameter("tolocrefids", damagestock.getTolocrefid());
//			storedProcedure.setParameter("damagestkids",0);
//			storedProcedure.setParameter("clientcdates", damagestock.getClientcdate());
//
//			storedProcedure.setParameter("functionality", function);
//			/*
//			 * Attribute To set Local Usage
//			 */
//			session.setAttribute("comp", damagestock.getCompanyrefid());
//			session.setAttribute("brnch", damagestock.getBranchrefid());
//			session.setAttribute("loname", damagestock.getLocname());
//			session.setAttribute("lorefid", damagestock.getLocrefid());
//
//			storedProcedure.execute();
//			Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
//			this.da = (Integer) storedProcedure.getOutputParameterValue("damid");
//			this.clientdate = (String) storedProcedure.getOutputParameterValue("clientdate");
//			String SqlException = (String) storedProcedure.getOutputParameterValue("exception");
//			//System.out.println("SqlException :" + SqlException);
//			//System.out.println("flag" + a);
//			if (a == 1) {
//				flag = true;
//			}
//		} catch (Exception Ex) {
//			logger.error("Exception in Method : createDamagestock() " + Ex);
//			Ex.printStackTrace();
//		}
//		return flag;
//	}

//	/** CREATE DAMAGE TABLE RECORD **/
//	public boolean createDamagetable(List<Damage_stock> damage_stock) throws Exception, SQLException {
//		boolean returnFlag = false;
//		try {
//			System.out.println("inside table "+damage_stock );
//			String function = "SAVE";
//			for (int i = 0; i < damage_stock.size(); i++) {
//				System.out.println("inside for " + damage_stock.size());
//				int cid = (Integer) session.getAttribute("comp");
//				System.out.println(cid);
//
//				int bid = (Integer) session.getAttribute("brnch");
//				int lname = (Integer) session.getAttribute("loname");
//				int lrefid = (Integer) session.getAttribute("lorefid");
//				Damage_stock damage = damage_stock.get(i);
//				StoredProcedureQuery storedProcedure = em
//						.createStoredProcedureQuery("medc_purchasereturn.pro_damageTable");
//				storedProcedure.registerStoredProcedureParameter("damagestkrefids", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("stkproductrefids", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("dmgstkprdids", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("expirydates", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("qtys", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("damagedqtys", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("boxqtys", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("damagedboxqtys", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("stripqtys", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("stripdamagedqtys", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("tabqtys", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("tabdamagedqtys", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("unitprices", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("unitvats", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("unitgsts", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("unitsgsts", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("unitcgsts", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("unitigsts", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("unitdiscounts", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("subtotals", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("total_amounts", Double.class, ParameterMode.IN);
//				// storedProcedure.registerStoredProcedureParameter("packings",
//				// Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("batchnos", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("batchnumbers", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("clientcdates", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("returnFlag", Integer.class, ParameterMode.OUT);
//				storedProcedure.setParameter("damagestkrefids", this.da);
//				System.out.println("c:" + this.da);
//				storedProcedure.setParameter("stkproductrefids", damage.getStkproductrefid());
//				System.out.println("p:" + damage.getStkproductrefid());
//				storedProcedure.setParameter("dmgstkprdids",0);
//				storedProcedure.setParameter("expirydates", damage.getExpirydate());
//				storedProcedure.setParameter("qtys", damage.getQty());
//				storedProcedure.setParameter("damagedqtys", damage.getDamagedqty());
//				storedProcedure.setParameter("boxqtys", damage.getBoxqty());
//				storedProcedure.setParameter("damagedboxqtys", damage.getDamagedboxqty());
//				storedProcedure.setParameter("stripqtys", damage.getStripqty());
//				storedProcedure.setParameter("stripdamagedqtys", damage.getStripdamagedqty());
//				storedProcedure.setParameter("tabqtys", damage.getTabqty());
//				storedProcedure.setParameter("tabdamagedqtys", damage.getTabdamagedqty());
//				storedProcedure.setParameter("unitprices", damage.getUnitprice());
//				storedProcedure.setParameter("unitvats", damage.getUnitvat());
//				storedProcedure.setParameter("unitgsts", damage.getUnitgst());
//				storedProcedure.setParameter("unitsgsts", damage.getUnitsgst());
//				storedProcedure.setParameter("unitcgsts", damage.getUnitcgst());
//				storedProcedure.setParameter("unitigsts", damage.getUnitigst());
//				storedProcedure.setParameter("unitdiscounts", damage.getUnitdiscount());
//				storedProcedure.setParameter("subtotals", damage.getSubtotal());
//				storedProcedure.setParameter("total_amounts", damage.getTotal_amount());
//				// storedProcedure.setParameter("packings",damage.getPacking());
//				storedProcedure.setParameter("batchnos", damage.getBatchno());
//				storedProcedure.setParameter("batchnumbers", damage.getBatchnumber());
//				storedProcedure.setParameter("clientcdates", this.clientdate);
//				storedProcedure.setParameter("companyrefids", cid);
//				storedProcedure.setParameter("branchrefids", bid);
//				storedProcedure.setParameter("locnames", lname);
//				storedProcedure.setParameter("locrefids", lrefid);
//				storedProcedure.setParameter("functionality", function);
//				/*
//				 * Attribute To set Local Usage
//				 * 
//				 * session.setAttribute("comp", purchase.getCompanyrefid());
//				 * session.setAttribute("brnch", purchase.getBranchrefid());
//				 * session.setAttribute("loname", purchase.getLocname());
//				 * session.setAttribute("lorefid", purchase.getLocrefid());
//				 */
//				storedProcedure.execute();
//				Integer a = (Integer) storedProcedure.getOutputParameterValue("returnFlag");
//				if (a == 1) {
//					returnFlag = true;
//
//				}
//			}
//			session.removeAttribute("comp");
//			session.removeAttribute("brnch");
//			session.removeAttribute("loname");
//			session.removeAttribute("lorefid");
//		} catch (Exception Ex) {
//			logger.error("Exception in Method : createDamagetable() " + Ex);
//			Ex.printStackTrace();
//		}
//		
//		return returnFlag;
//	}
//	
	public boolean updateDamagestock(Damagestock damagestock) throws Exception {
		// System.out.println("inside Update");
		boolean flag = false;
		// try {
		String function = "UPDATE";
		StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("medc_purchasereturn.pro_damagestock");
		storedProcedure.registerStoredProcedureParameter("damagestockdates", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("invoicedates", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("invoicenos", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("distnames", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("vendorids", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("contactnos", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("totalamounts", Double.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("remarkss", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("packings", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("damagestocknos", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("createdbys", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("fromlocnames", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("fromlocrefids", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("tolocnames", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("tolocrefids", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("damagestkids", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("clientcdates", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("damid", Integer.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("clientdate", String.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("exception", String.class, ParameterMode.OUT);
		storedProcedure.setParameter("damagestockdates", damagestock.getDamagestockdate());
		// System.out.println("date"+ damagestock.getDamagestockdate());
		storedProcedure.setParameter("invoicedates", damagestock.getInvoicedate());
		storedProcedure.setParameter("invoicenos", damagestock.getInvoiceno());
		storedProcedure.setParameter("distnames", damagestock.getDistname());
		storedProcedure.setParameter("vendorids", damagestock.getVendorid());
		// System.out.println("check0:" + damagestock.getDamagestockno());
		storedProcedure.setParameter("contactnos", damagestock.getContactno());
		storedProcedure.setParameter("totalamounts", damagestock.getTotalamount());
		storedProcedure.setParameter("remarkss", damagestock.getRemarks());
		storedProcedure.setParameter("packings", damagestock.getPacking());
		// System.out.println("check1:" + damagestock.getDamagestockno());
		storedProcedure.setParameter("damagestocknos", damagestock.getDamagestockno());
		// System.out.println("check2:" + damagestock.getDamagestockno());
		storedProcedure.setParameter("createdbys", damagestock.getCreatedby());
		storedProcedure.setParameter("companyrefids", damagestock.getCompanyrefid());
		storedProcedure.setParameter("branchrefids", damagestock.getBranchrefid());
		storedProcedure.setParameter("locnames", damagestock.getLocname());
		storedProcedure.setParameter("locrefids", damagestock.getLocrefid());
		storedProcedure.setParameter("fromlocnames", damagestock.getFromlocname());
		storedProcedure.setParameter("fromlocrefids", damagestock.getFromlocrefid());
		storedProcedure.setParameter("tolocnames", damagestock.getTolocname());
		storedProcedure.setParameter("tolocrefids", damagestock.getTolocrefid());
		storedProcedure.setParameter("damagestkids", damagestock.getDamagestkids());
		storedProcedure.setParameter("clientcdates", damagestock.getClientcdate());

		storedProcedure.setParameter("functionality", function);
		/*
		 * Attribute To set Local Usage
		 */
		session.setAttribute("comp", damagestock.getCompanyrefid());
		session.setAttribute("brnch", damagestock.getBranchrefid());
		session.setAttribute("loname", damagestock.getLocname());
		session.setAttribute("lorefid", damagestock.getLocrefid());

		storedProcedure.execute();
		Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
		this.editda = (Integer) storedProcedure.getOutputParameterValue("damid");
		this.clientdate = (String) storedProcedure.getOutputParameterValue("clientdate");
		String SqlException = (String) storedProcedure.getOutputParameterValue("exception");
		// System.out.println("SqlException :" + SqlException);
		// System.out.println("flag" + a);
		if (a == 1) {
			flag = true;
		}
		// } catch (Exception Ex) {
		// logger.error("Exception in Method : updateDamagestock() " + Ex);
		// Ex.printStackTrace();
		// }
		return flag;
	}

	public boolean updateDamagetable(List<Damage_stock> damage_stock) throws Exception {
		// System.out.println("Inside Update Table");
		boolean returnFlag = false;
		// try {
		String function = "UPDATE";
		for (int i = 0; i < damage_stock.size(); i++) {
			// System.out.println("inside for " + damage_stock.size());
			int cid = (Integer) session.getAttribute("comp");
			// System.out.println(cid);

			int bid = (Integer) session.getAttribute("brnch");
			int lname = (Integer) session.getAttribute("loname");
			int lrefid = (Integer) session.getAttribute("lorefid");
			Damage_stock damage = damage_stock.get(i);
			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("medc_purchasereturn.pro_damageTable");
			storedProcedure.registerStoredProcedureParameter("damagestkrefids", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("stkproductrefids", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("dmgstkprdids", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("expirydates", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("qtys", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("damagedqtys", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("boxqtys", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("damagedboxqtys", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("stripqtys", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("stripdamagedqtys", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("tabqtys", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("tabdamagedqtys", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("unitprices", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("unitvats", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("unitgsts", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("unitsgsts", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("unitcgsts", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("unitigsts", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("unitdiscounts", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("subtotals", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("total_amounts", Double.class, ParameterMode.IN);
			// storedProcedure.registerStoredProcedureParameter("packings",
			// Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("batchnos", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("batchnumbers", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("clientcdates", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("returnFlag", Integer.class, ParameterMode.OUT);
			storedProcedure.setParameter("damagestkrefids", this.editda);
			// System.out.println("c:" + this.editda);
			storedProcedure.setParameter("stkproductrefids", damage.getStkproductrefid());
			// System.out.println("p:" + damage.getStkproductrefid());
			if (damage.getDmgstkprdids() == null || damage.getDmgstkprdids().equals("")) {
				damage.setDmgstkprdids(0);
			}
			storedProcedure.setParameter("dmgstkprdids", damage.getDmgstkprdids());

			storedProcedure.setParameter("expirydates", damage.getExpirydate());
			storedProcedure.setParameter("qtys", damage.getQty());
			storedProcedure.setParameter("damagedqtys", damage.getDamagedqty());

			storedProcedure.setParameter("boxqtys", damage.getBoxqty());
			storedProcedure.setParameter("damagedboxqtys", damage.getDamagedboxqty());

			storedProcedure.setParameter("stripqtys", damage.getStripqty());
			storedProcedure.setParameter("stripdamagedqtys", damage.getStripdamagedqty());

			storedProcedure.setParameter("tabqtys", damage.getTabqty());
			storedProcedure.setParameter("tabdamagedqtys", damage.getTabdamagedqty());

			storedProcedure.setParameter("unitprices", damage.getUnitprice());
			storedProcedure.setParameter("unitvats", damage.getUnitvat());
			storedProcedure.setParameter("unitgsts", damage.getUnitgst());
			storedProcedure.setParameter("unitsgsts", damage.getUnitsgst());
			storedProcedure.setParameter("unitcgsts", damage.getUnitcgst());
			storedProcedure.setParameter("unitigsts", damage.getUnitigst());
			storedProcedure.setParameter("unitdiscounts", damage.getUnitdiscount());
			storedProcedure.setParameter("subtotals", damage.getSubtotal());
			storedProcedure.setParameter("total_amounts", damage.getTotal_amount());
			// storedProcedure.setParameter("packings",damage.getPacking());
			storedProcedure.setParameter("batchnos", damage.getBatchno());
			storedProcedure.setParameter("batchnumbers", damage.getBatchnumber());
			storedProcedure.setParameter("clientcdates", this.clientdate);
			storedProcedure.setParameter("companyrefids", cid);
			storedProcedure.setParameter("branchrefids", bid);
			storedProcedure.setParameter("locnames", lname);
			storedProcedure.setParameter("locrefids", lrefid);
			storedProcedure.setParameter("functionality", function);
			/*
			 * Attribute To set Local Usage
			 * 
			 * session.setAttribute("comp", purchase.getCompanyrefid());
			 * session.setAttribute("brnch", purchase.getBranchrefid());
			 * session.setAttribute("loname", purchase.getLocname());
			 * session.setAttribute("lorefid", purchase.getLocrefid());
			 */
			storedProcedure.execute();
			Integer a = (Integer) storedProcedure.getOutputParameterValue("returnFlag");
			if (a == 1) {
				returnFlag = true;

			}
		}
		session.removeAttribute("comp");
		session.removeAttribute("brnch");
		session.removeAttribute("loname");
		session.removeAttribute("lorefid");
		// } catch (Exception Ex) {
		// logger.error("Exception in Method : UpdateDamagetable() " + Ex);
		// Ex.printStackTrace();
		// }
		return returnFlag;
	}

	public List getDamageboxdetails(Integer id) throws Exception {
		return damagestockRepository.damageboxinfo(id);
	}

	public List chechshopTaxmaster(Integer cid, Integer bid, Integer shopid) throws Exception {
		list = null;
		// try {
		list = damagestockRepository.chechshopTaxmaster(cid, bid, shopid);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : chechshopTaxmaster() " + ex);
		// }
		return list;
	}

	public List chechhospitalTaxmaster(Integer cid, Integer bid, Integer hospitalid) throws Exception {
		list = null;
		// try {
		list = damagestockRepository.chechhospitalTaxmaster(cid, bid, hospitalid);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : chechhospitalTaxmaster() " + ex);
		// }
		return list;
	}

	public List chechwarehouseTaxmaster(Integer cid, Integer bid, Integer warehouseid) throws Exception {
		list = null;
		// try {
		list = damagestockRepository.chechwarehouseTaxmaster(cid, bid, warehouseid);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : chechwarehouseTaxmaster() " + ex);
		// }
		return list;
	}

	public List getshopDamTax(Integer cid, Integer bid, Integer shopid) throws Exception {
		list = null;
		// try {
		list = damagestockRepository.getshopDamTax(cid, bid, shopid);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : getshopDamTax() " + ex);
		// }
		return list;
	}

	public List gethospitalDamTax(Integer cid, Integer bid, Integer hospitalid) throws Exception {
		list = null;
		// try {
		list = damagestockRepository.gethospitalDamTax(cid, bid, hospitalid);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : gethospitalDamTax() " + ex);
		// }
		return list;
	}

	public List getwarehouseDamTax(Integer cid, Integer bid, Integer warehouseid) throws Exception {
		list = null;
		// try {
		list = damagestockRepository.getwarehouseDamTax(cid, bid, warehouseid);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : getwarehouseDamTax() " + ex);
		// }
		return list;
	}

	/** VIEW Damage RECORD **/

	public List getViewdamage(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		list = null;
		// try {
		list = damagestockRepository.getViewdamage(cid, bid, locrefid, locname);
		// } catch (Exception ev) {
		// logger.error("Exception in (damage)Method : getViewdamage() " + ev);
		// }
		return list;
	}

	/** VIEW Damage-HQ RECORD **/

	public List getViewhqdamage(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		list = null;
		// try {
		if (locname == 1) {// shop
			list = damagestockRepository.getViewhqshopdamage(cid, bid, locrefid, locname);
		}
		if (locname == 2) {// warehouse
			list = damagestockRepository.getViewhqwarehousedamage(cid, bid, locrefid, locname);
		}
		if (locname == 3) {// hospital
			list = damagestockRepository.getViewhqhospitaldamage(cid, bid, locrefid, locname);
		}
		// } catch (Exception ev) {
		// logger.error("Exception in (damage)Method : getViewdamage() " + ev);
		// }
		return list;
	}

	/**
	 * Edit Damage RECORD
	 * 
	 * @param id2
	 * @param locname
	 * @param locrefid
	 * @param bid
	 **/

	public List getEditdamage(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer id)
			throws Exception {
		list = null;
		// try {
		list = damagestockRepository.getEditdamage(cid, bid, locrefid, locname, id);
		// } catch (Exception ev) {
		// logger.error("Exception in (damage)Method : getEditdamage() " + ev);
		// }
		return list;
	}

	public List getEditdamagetable(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer id)
			throws Exception {
		list = null;
		// try {
		list = damagestockRepository.getEditdamagetable(cid, bid, locrefid, locname, id);
		// } catch (Exception ev) {
		// logger.error("Exception in (damage)Method : getEditdamagetable() " + ev);
		// }
		return list;
	}

	public List getBrandlist(String val, Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		List list = null;
		// try {
		list = damagestockRepository.getBrandlist(val, cid, bid, locname, locrefid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : getBrandlist() " + e);
		// }
		return list;
	}

	public List getproddetails(String val, Integer cid, Integer bid, Integer locrefid, Integer locname)
			throws Exception {
		List list = null;
		// try {
		list = damagestockRepository.getproddetails(val, cid, locrefid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : getBrandlist() " + e);
		// }
		return list;
	}

	public List getDatabledata(Integer data, Integer cid, Integer bid, Integer locrefid, Integer locname)
			throws Exception {
		list = null;
		// try {
		list = damagestockRepository.getDatabledata(data, cid, bid, locrefid, locname);
		// } catch (Exception es) {
		// logger.error("Exception in Method : getPitabledata() " + es);
		// }
		return list;
	}

	public List getHqdamage(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer id) throws Exception {
		list = null;
		// try {
		list = damagestockRepository.getHqdamage(cid, bid, locrefid, locname, id);
		// } catch (Exception ev) {
		// logger.error("Exception in (damage)Method : getHqdamage() " + ev);
		// }
		return list;
	}

	public List getHqdamagetable(Integer cid, Integer bid, Integer locrefid, Integer locname, Integer id)
			throws Exception {
		list = null;
		// try {
		list = damagestockRepository.getHqdamagetable(cid, bid, locrefid, locname, id);
		// } catch (Exception ev) {
		// logger.error("Exception in (damage)Method : getHqdamagetable() " + ev);
		// }
		return list;
	}

	/** DELETE PURCHASE INVOICE **/
	public void deleteDamage(Integer id) throws Exception {
		// try {
		damagestockRepository.deleteDamage(id);
		// } catch (Exception ed) {
		// logger.error("Exception in (Purchase)Method : deleteDamageStock() " + ed);
		// }
	}

// Destroy Main Stock Product
	public boolean destroy(List<Damage_stock> Damage_stock) throws Exception {

		for (Damage_stock dproduct : Damage_stock) {

			Stocks stocks = stocksRepository
					.findByDrugproductidAndBatchnoAndCompanyrefidAndBranchrefidAndLocnameAndLocrefid(
							dproduct.getStkproductrefid(), String.valueOf(dproduct.getBatchnumber()),
							dproduct.getCompanyrefid(), dproduct.getBranchrefid(), dproduct.getLocname(),
							dproduct.getLocrefid());
			System.out.println(stocks);
			stocks.setQty(stocks.getQty() - dproduct.getDamagedqty());
			// stocks.setTabletqty(stocks.getTabletqty().intValue() -
			// dproduct.getDamagedqty());
			stocks.setDamageqty(stocks.getDamageqty() + dproduct.getDamagedqty());
			stocks.setDamagedestroystatus(2);
			stocksRepository.save(stocks);

		}
		return true;
	}

}
