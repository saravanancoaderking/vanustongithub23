package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.PoProduct;
import com.medeil.domain.PurchaseOrder;
import com.medeil.domain.Stocks;
import com.medeil.repository.PoproductRepository;
import com.medeil.repository.PurchaseOrderRepository;
import com.medeil.repository.StocksRepository;

@SuppressWarnings("rawtypes")
@Service
public class PurchaseOrderService {
	static List poautoincr;

	private static Logger logger = LogManager.getLogger();
	@PersistenceContext
	private EntityManager manager;

	@PersistenceContext
	EntityManager em;

	Query query;

	@Autowired
	PurchaseOrderRepository POrderRepository;

	@Autowired
	StocksRepository stkrepo;

	@Autowired
	PoproductRepository poprorepo;

	@Autowired
	private HttpSession session;

	public List getSessionHospital(Integer cid, Integer bid) throws Exception {
		// List list = null;
		// try {

		// list = POrderRepository.getSessionHospital(bid);

		// } catch (Exception eh) {
		// logger.error("Exception in Method : getSessionHospital() " + eh);
		// }
		return POrderRepository.getSessionHospital(bid);
	}

	public List getCompanies() throws Exception {
		return POrderRepository.getCompanies();
	}

	public List getEditPurchaseOrder(int compid, int brnchid, int loc, int locref, int poid) throws Exception {
		return POrderRepository.getEditPurchaseOrder(compid, brnchid, loc, locref, poid);
	}

	public List getBranches(int compId) throws Exception {
		return POrderRepository.getBranches(compId);
	}

	public List getWareHouse(int compId) throws Exception {
		return POrderRepository.getWareHouse(compId);
	}

	public List getHospitals(int compId) throws Exception {
		return POrderRepository.getHospitals(compId);
	}

	public List getShops(int shopId) throws Exception {
		return POrderRepository.getShops(shopId);
	}

	public List getSuperAdminDistributor(String search) throws Exception {
		return POrderRepository.getSuperAdminDistributor(search);
	}

	public List getDistributor(String str, int compid, int brnchid, int loc, int locref) throws Exception {
		return POrderRepository.getDistributor(str, compid, brnchid, loc, locref);
	}

	public List getDistributorEdit(int id) throws Exception {
		String poid = POrderRepository.distID(id);
		return POrderRepository.getDistributorEdit(poid);
	}

	public List getSuperDrug(String str) throws Exception {
		return POrderRepository.getSuperDrug(str);
	}

	public List getDrug(String str, int compid, int brnchid, int loc, int locref) {
		return POrderRepository.getDrug(str, compid);
	}

	// Boopalan 170419
	public List getSuperDistributorProducts(int prsid, int distID) throws Exception {
		return POrderRepository.getSuperDistributorProducts(prsid, distID);
	}

	public List getDistributorProducts(int compid, int brnchid, int locname, int locrefid, int id) throws Exception {
		return POrderRepository.getDistributorProducts(compid, brnchid, locname, locrefid, id);
	}

	/*
	 * public List getDrugData(int drugid) { return
	 * POrderRepository.getDrugData(drugid); }
	 */

	public List getDrugData(int drugid, int compid, int branchid, int locname, int locrefid, int vendorid)
			throws Exception {
		return POrderRepository.getDrugData(drugid, compid, branchid, locname, locrefid, vendorid);
	}

	public List viewPurchaseOrder(int compid, int brnchid, int loc, int locref) throws Exception {
		return POrderRepository.viewPurchaseOrder(compid, brnchid, loc, locref);
	}

	public List getPurchaseOrder(int compid, int brnchid, int loc, int locref, int poid) throws Exception {
		return POrderRepository.getPurchaseOrder(compid, brnchid, loc, locref, poid);
	}

	public Integer deletePurchaseOrder(int poid) throws Exception {
		// Integer ob = null;
		// try {
		// ob = POrderRepository.deletePurchaseOrder(poid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : deletePurchaseOrder() " + e);
		// }
		return POrderRepository.deletePurchaseOrder(poid);
	}

//	public boolean createPurchaseOrder(PurchaseOrder purc) throws Exception {
//		boolean flag = false;
//		getAutoincrement(purc.getCompanyid(), purc.getBranchid(), purc.getLocname(), purc.getLocref());// Boopalan
//		// 040419
//		String s = poautoincr.toString();// Boopalan 040419
//		System.out.println(">>>>>>>>>>>>>>"+s);
//		purc.setPoautoincr(s.substring(1, s.length() - 1));// Boopalan 040419
//		try {
//			StoredProcedureQuery storedProcedure = manager
//					.createStoredProcedureQuery("medc_purchase.pro_purchase_order");
//			storedProcedure.registerStoredProcedureParameter("distributor", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("poautoincr", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("podate", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalProduct", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalBoxQuantity", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalStpQuantity", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalTabQuantity", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalQuantity", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("compid", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("branchid", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locname", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locrefid", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("grandtotal1", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
//			storedProcedure.setParameter("distributor", purc.getDistributor());
//			storedProcedure.setParameter("poautoincr", purc.getPoautoincr());
//			storedProcedure.setParameter("podate", purc.getPodate());
//			storedProcedure.setParameter("totalProduct", purc.getTotalproduct());
//			storedProcedure.setParameter("totalBoxQuantity", purc.getTotalboxquantity());
//			storedProcedure.setParameter("totalStpQuantity", purc.getTotalstpquantity());
//			storedProcedure.setParameter("totalTabQuantity", purc.getTotaltabquantity());
//			storedProcedure.setParameter("totalQuantity", purc.getTotalquantity());
//			storedProcedure.setParameter("compid", purc.getCompanyid());
//			storedProcedure.setParameter("branchid", purc.getBranchid());
//			storedProcedure.setParameter("locname", purc.getLocname());
//			storedProcedure.setParameter("locrefid", purc.getLocref());
//
//			storedProcedure.setParameter("grandtotal1", purc.getGrandtotal());
//			// Set Session values for companyid and branchid and locid and locrefid
//			session.setAttribute("compid", purc.getCompanyid());
//			session.setAttribute("branchid", purc.getBranchid());
//			session.setAttribute("locname", purc.getLocname());
//			session.setAttribute("locrefid", purc.getLocref()); // selva
//			storedProcedure.setParameter("functionality", "save");
//			storedProcedure.execute();
//			Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
//			System.out.println("::::::::::::::::::::::::::::::::::Flag"+a);
//			if (a == 1) {
//				flag = true;
//			}
//		} catch (Exception e) {
//			logger.error("Exception in Method : createPurchaseRecord() " + e);
//		}
//		return flag;
//	}

	public boolean createPurchaseOrder(PurchaseOrder purc) throws Exception {
		System.out.println(purc.getCompanyrefid() + "  " + purc.getBranchrefid() + "  " + purc.getLocname() + "  "
				+ purc.getLocrefid());
		String lastid = POrderRepository.lastPurchaseOrder(purc.getCompanyrefid(), purc.getBranchrefid(),
				purc.getLocname(), purc.getLocrefid());

		System.out.println(">>>>>>>>>>>lastid" + lastid);
		String oldInco = lastid.substring(lastid.length() - 9, lastid.length());
		Long newInco = Long.parseLong(oldInco) + 1;
		String newid = StringUtils.leftPad(newInco.toString(), 9, "0");

		purc.setPono("PSO" + newid);
		// try {
		System.out.println("above###################");
		POrderRepository.save(purc);
		System.out.println("below###################");
		return true;
		// } catch (Exception e) {
		// logger.error("Exception in Method : SavePurchaseOrder() " + e);
		// return false;
		// }

	}

	public List createPurchaseOrderProduct(List<PoProduct> purpro) throws Exception {
		List returndata = new ArrayList();
		for (PoProduct p : purpro) {
			try {
//			Integer poid = 0;
//			poid = POrderRepository.getPurchaseOrderID();
				p.setPorefid(POrderRepository.getPurchaseOrderID());
				List<Stocks> stk = stkrepo.findByDrugproductidAndCompanyrefidAndBranchrefidAndLocnameAndLocrefid(
						p.getDrugproductrefid(), p.getCompanyrefid(), p.getBranchrefid(), p.getLocname(),
						p.getLocrefid());
				for (Stocks st : stk) {
					if (st == null) {
						System.out.println("No Stock");
					} else {
						st.setMaxqty(p.getMaxqty());
						stkrepo.save(st);
					}
				}
//			System.out.println(">>>>>>>>>>>>>>>>>>poid"+purpro.get(1).getPorefid());
				poprorepo.save(p);
				returndata.add(1);
				returndata.add(POrderRepository.getPurchaseOrderID());
			}

			catch (Exception e) {
				System.out.println("Exception" + e);
				logger.error("Exception in Method : createPurchaseOrderProduct() " + e);
				returndata.add(0);
				returndata.add(POrderRepository.getPurchaseOrderID());
			}
		}
		return returndata;
	}

//	public List createPurchaseOrderProduct(List<PoProduct> pur) throws Exception {
//		boolean flag = false;
//		List returndata = new ArrayList();
//		Integer poid = 0;
//		System.out.println("createPurchaseOrderProduct");
//		try {
//			for (int i = 0; i < pur.size(); i++) {
//
//				poid = POrderRepository.getPurchaseOrderID();
//				PoProduct purc = pur.get(i);
//				StoredProcedureQuery storedProcedure = manager
//						.createStoredProcedureQuery("medc_purchase.pro_purchase_order_product");
//				storedProcedure.registerStoredProcedureParameter("PORefID", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("itemcode", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("boxqty", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("stripqty", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("tabletqty", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("totalqty", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("compid", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("branchid", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("locname", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("locrefid", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("uom1", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("equalto1", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("totalproductprice1", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("unitprice1", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("abc1", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("distprodrank1", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("distremarks1", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("pursessionno", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("pursessionid", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
//				storedProcedure.setParameter("PORefID", poid);
//				storedProcedure.setParameter("itemcode", purc.getItemcode());
//				storedProcedure.setParameter("boxqty", purc.getBoxquantity());
//				storedProcedure.setParameter("stripqty", purc.getStripquantity()());
//				storedProcedure.setParameter("tabletqty", purc.getTabletqty());
//				storedProcedure.setParameter("totalqty", purc.getTotalqty());
//				int compid = (int) session.getAttribute("compid");
//				int branchid = (int) session.getAttribute("branchid");
//				int locname = (int) session.getAttribute("locname");
//				int locrefid = (int) session.getAttribute("locrefid");
//				storedProcedure.setParameter("compid", compid);
//				storedProcedure.setParameter("branchid", branchid);
//				storedProcedure.setParameter("locname", locname);
//				storedProcedure.setParameter("locrefid", locrefid);
//				storedProcedure.setParameter("uom1", purc.getUom());
//				System.out.println("Boopalan1989          " + purc.getUom());
//				storedProcedure.setParameter("equalto1", purc.getEqualto());
//				System.out.println("Boopalan1989   " + purc.getEqualto());
//				storedProcedure.setParameter("totalproductprice1", purc.getTotalproductprice());
//				System.out.println("tppvalue...   " + purc.getTotalproductprice());
//				storedProcedure.setParameter("unitprice1", purc.getUnitprice());
//				System.out.println("upvalue...   " + purc.getUnitprice());
//				storedProcedure.setParameter("abc1", purc.getAbc());
//				System.out.println("abc...   " + purc.getAbc());
//				storedProcedure.setParameter("distprodrank1", purc.getDistprodrank());
//				System.out.println("distranks...   " + purc.getDistprodrank());
//				storedProcedure.setParameter("distremarks1", purc.getDistremarks());
//				System.out.println("distremarks...   " + purc.getDistremarks());
//				storedProcedure.setParameter("pursessionno", purc.getPursessionno());
//				System.out.println("pursessionno...   " + purc.getPursessionno());
//				storedProcedure.setParameter("pursessionid", purc.getPursessionid());
//				storedProcedure.setParameter("functionality", "save");
//				storedProcedure.execute();
//				Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
//				if (a == 1) {
//					flag = true;
//					// returndata.add(flag);
//					// returndata.add(poid);
//
//				}
//			}
//
//		} catch (Exception e) {
//			System.out.println("Exception" + e);
//			logger.error("Exception in Method : createPurchaseOrderProduct() " + e);
//		} finally {
//			session.invalidate();
//		}
//		System.out.println("1" + flag);
//		System.out.println("out2" + poid);
//		returndata.add(flag);
//		returndata.add(poid);
//		System.out.println("out" + returndata);
//		return returndata;
//	}

	public boolean updatePurchaseOrder(PurchaseOrder purc) throws Exception {
		// try {

		POrderRepository.save(purc);
		System.out.println("below###################");
		return true;
		// } catch (Exception e) {
		// logger.error("Exception in Method : SavePurchaseOrder() " + e);
		// return false;
		// }
	}

	public boolean updatePurchaseOrderProduct(List<PoProduct> purpro) throws Exception {
//		List returndata = new ArrayList();
//		Integer poid = 0;
		// try {
		poprorepo.saveAll(purpro);
		return true;

		// } catch (Exception e) {
		// System.out.println("Exception" + e);
		// logger.error("Exception in Method : createPurchaseOrderProduct() " + e);
		// return false;
		// }

	}

//	public boolean updatePurchaseOrder(PurchaseOrder purc) throws Exception {
//		boolean flag = false;
//		try {
//			System.out.println("Inside service");
//			StoredProcedureQuery storedProcedure = manager
//					.createStoredProcedureQuery("medc_purchase.pro_purchase_order");
//			storedProcedure.registerStoredProcedureParameter("distributor", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("poautoincr", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("podate", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalProduct", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalBoxQuantity", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalStpQuantity", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalTabQuantity", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalQuantity", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("compid", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("branchid", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locname", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locrefid", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("grandtotal1", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
//			storedProcedure.setParameter("distributor", purc.getDistributor());
//			storedProcedure.setParameter("poautoincr", purc.getPoautoincr());
//			storedProcedure.setParameter("podate", purc.getPodate());
//			storedProcedure.setParameter("totalProduct", purc.getTotalproduct());
//			storedProcedure.setParameter("totalBoxQuantity", purc.getTotalboxquantity());
//			storedProcedure.setParameter("totalStpQuantity", purc.getTotalstpquantity());
//			storedProcedure.setParameter("totalTabQuantity", purc.getTotaltabquantity());
//			storedProcedure.setParameter("totalQuantity", purc.getTotalquantity());
//			storedProcedure.setParameter("compid", purc.getCompanyrefid());
//			storedProcedure.setParameter("branchid", purc.getBranchrefid());
//			storedProcedure.setParameter("locname", purc.getLocname());
//			storedProcedure.setParameter("locrefid", purc.getLocrefid());
//			storedProcedure.setParameter("grandtotal1", purc.getGrandtotal());
//			// Set Session values for companyid and branchid and locid and locrefid
//			session.setAttribute("compid", purc.getCompanyrefid());
//			session.setAttribute("branchid", purc.getBranchrefid());
//			session.setAttribute("locname", purc.getLocname());
//			session.setAttribute("locrefid", purc.getLocrefid());
//			storedProcedure.setParameter("functionality", "update");
//			storedProcedure.execute();
//			Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
//			if (a == 1) {
//				flag = true;
//
//			}
//		} catch (Exception e) {
//			logger.error("Exception in Method : updatePurchaseOrder() " + e);
//		}
//		return flag;
//	}

	public void deletePoProduct(List<PurchaseOrder> pur) throws Exception {
		int compid = (int) session.getAttribute("compid");
		int branchid = (int) session.getAttribute("branchid");
		int locname = (int) session.getAttribute("locname");
		int locrefid = (int) session.getAttribute("locrefid");
		PurchaseOrder purc = pur.get(0);
		int poid = purc.getId();
		POrderRepository.deletePoProduct(compid, branchid, locname, locrefid, poid);
	}

//	public boolean updatePurchaseOrderProduct(List<PurchaseOrder> pur) throws Exception {
//		boolean flag = false;
//		try {
//			this.deletePoProduct(pur);
//			int compid = (int) session.getAttribute("compid");
//			int branchid = (int) session.getAttribute("branchid");
//			int locname = (int) session.getAttribute("locname");
//			int locrefid = (int) session.getAttribute("locrefid");
//
//			for (int i = 0; i < pur.size(); i++) {
//				PurchaseOrder purc = pur.get(i);
//				StoredProcedureQuery storedProcedure = manager
//						.createStoredProcedureQuery("medc_purchase.pro_purchase_order_product");
//				storedProcedure.registerStoredProcedureParameter("PORefID", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("itemcode", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("boxqty", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("stripqty", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("tabletqty", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("totalqty", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("compid", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("branchid", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("locname", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("locrefid", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("uom1", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("equalto1", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("totalproductprice1", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("unitprice1", Double.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("abc1", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("distprodrank1", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("distremarks1", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("pursessionno", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("pursessionid", Integer.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//				storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
//				storedProcedure.setParameter("PORefID", purc.getPoid());
//				storedProcedure.setParameter("itemcode", purc.getItemcode());
//				storedProcedure.setParameter("boxqty", purc.getBoxqty());
//				storedProcedure.setParameter("stripqty", purc.getStripqty());
//				storedProcedure.setParameter("tabletqty", purc.getTabletqty());
//				storedProcedure.setParameter("totalqty", purc.getTotalqty());
//				storedProcedure.setParameter("compid", compid);
//				storedProcedure.setParameter("branchid", branchid);
//				storedProcedure.setParameter("locname", locname);
//				storedProcedure.setParameter("locrefid", locrefid);
//				storedProcedure.setParameter("uom1", purc.getUom());
//				System.out.println("Boopalan1989          " + purc.getUom());
//				storedProcedure.setParameter("equalto1", purc.getEqualto());
//				System.out.println("Boopalan1989   " + purc.getEqualto());
//				storedProcedure.setParameter("totalproductprice1", purc.getTotalproductprice());
//				System.out.println("tppvalue...   " + purc.getTotalproductprice());
//				storedProcedure.setParameter("unitprice1", purc.getUnitprice());
//				System.out.println("upvalue...   " + purc.getUnitprice());
//				storedProcedure.setParameter("abc1", purc.getAbc());
//				storedProcedure.setParameter("distprodrank1", purc.getDistprodrank());
//				storedProcedure.setParameter("distremarks1", purc.getDistremarks());
//				storedProcedure.setParameter("pursessionno", purc.getPursessionno());
//				storedProcedure.setParameter("pursessionid", purc.getPursessionid());
//				storedProcedure.setParameter("functionality", "update");
//				storedProcedure.execute();
//				Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
//				if (a == 1) {
//					flag = true;
//				}
//			}
//		} catch (Exception e) {
//			logger.error("Exception in Method : updatePurchaseOrderProduct() " + e);
//			e.printStackTrace();
//		} finally {
//			session.invalidate();
//		}
//		return flag;
//	}
	public List viewIndentStatus(int comp, int brnch, int loc, int locref) throws Exception {
		// System.out.println("1comp"+"\t"+comp+"\t"+"brnch"+"\t"+brnch+"\t"+"loc"+"\t"+loc+"\t"+"locref"+"\t"+locref);
		return POrderRepository.viewIndentStatus(loc, locref);
	}

	public List superAdminViewIndentStatus() throws Exception {
		return POrderRepository.superAdminViewIndentStatus();
	}

	@Transactional
	public void getAutoincrement(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		List val = null;
		try {
			String value = "CALL medc_purchase.pro_getPOAutoIncrement(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "PurchaseOrder");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}

		poautoincr = val;

	}

	public List getPurchaseuom(Integer companyid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {

		return POrderRepository.getPurchaseuom();

	}

	public List PurchaseOrderEmailDistributor(int did) {
		return POrderRepository.PurchaseOrderEmailDistributor(did);

	}

	public List GetMinQty(Integer cid, Integer bid, Integer lname, Integer lrefid) {
		return POrderRepository.GetMinQty(cid, bid, lname, lrefid);
	}

	public List GetNewproduct(Integer cid, Integer bid, Integer lname, Integer lrefid) {
		return POrderRepository.GetNewproduct(cid, bid, lname, lrefid);
	}

	public List GetZerostockproduct(Integer cid, Integer bid, Integer lname, Integer lrefid) {
		return POrderRepository.GetZerostockproduct(cid, bid, lname, lrefid);
	}

	public List namedetails(Integer comp, Integer brnch, Integer locname, Integer locrefid) {
		return POrderRepository.veiwnamedetails(comp, brnch,locname, locrefid);
	}

}
