package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.GatePass;
import com.medeil.domain.GateProduct;
import com.medeil.domain.IndCompModel;
import com.medeil.repository.GatePassProductRepository;
import com.medeil.repository.GatePassRepository;

@Service
public class GatePassService {

	@PersistenceContext
	private EntityManager manager;

	@PersistenceContext
	EntityManager em;

	Query query;

	@Autowired
	private HttpSession session;

	private final GatePassRepository gatePassRepository;

	private final GatePassProductRepository gatePassProductRepository;

	private final Logger log = LoggerFactory.getLogger(GatePassService.class);

	@Autowired
	GatePassService(GatePassRepository dc, GatePassProductRepository dp) {

		this.gatePassRepository = dc;

		this.gatePassProductRepository = dp;

	}

	public List getQuantity(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = gatePassRepository.getpurQuantity(id);
		// } catch (Exception ea) {
		// // logger.error("Exception in Method : getQuantity() " + ea);
		// }
		return gatePassRepository.getpurQuantity(id);
	}

	int compid;
	int branchid;
	int locname;
	int locrefid;

	@Transactional
	public List getGatePassAutoincrement(int compid, int branchid, int locname, int locrefid) throws Exception {
		List ls = null;
		String a1 = "gatePass";

		// try {
		String q = "Call medc_stock.pro_autoincrement(?,?,?,?,?)";
		query = em.createNativeQuery(q);
		query.setParameter(1, a1);
		query.setParameter(2, compid);
		query.setParameter(3, branchid);
		query.setParameter(4, locname);
		query.setParameter(5, locrefid);
		ls = query.getResultList();
		System.out.println("SutoIncrement  :" + ls);
		// } catch (Exception e) {
		// System.out.println("getAutoincrements :" + e);
		// }

		return ls;
	}

	@Transactional
	public List getSalesAutoincrement(int compid, int branchid, int locname, int locrefid, int billtyperefids) {
		List ls = null;
		String a1 = "salesGatePass";

		try {
			String q = "Call medc_stock.pro_autoincrement(?,?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, a1);
			query.setParameter(2, compid);
			query.setParameter(3, branchid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			query.setParameter(6, billtyperefids);
			ls = query.getResultList();
			System.out.println("SutoIncrement  :" + ls);
		} catch (Exception e) {
			System.out.println("getAutoincrements  :" + e);
		}

		return ls;
	}

	@Transactional
	public List getPurchaseAutoincrement(int compid, int branchid, int locname, int locrefid, int billtyperefids) {
		List ls = null;
		String a1 = "PurchaseGatePass";

		try {
			String q = "Call medc_stock.pro_autoincrement(?,?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, a1);
			query.setParameter(2, compid);
			query.setParameter(3, branchid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			query.setParameter(6, billtyperefids);
			ls = query.getResultList();
			System.out.println("SutoIncrement  :" + ls);
		} catch (Exception e) {
			System.out.println("getAutoincrements  :" + e);
		}

		return ls;
	}

	@Transactional
	public List getAutoincrement(int compid, int branchid, int locname, int locrefid, int billtyperefids) {
		List ls = null;
		String a1 = "stockgatPass";

		try {
			String q = "Call medc_stock.pro_autoincrement(?,?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, a1);
			query.setParameter(2, compid);
			query.setParameter(3, branchid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			query.setParameter(6, billtyperefids);
			ls = query.getResultList();
			System.out.println("SutoIncrement  :" + ls);
		} catch (Exception e) {
			System.out.println("getAutoincrements  :" + e);
		}

		return ls;
	}

	public List getGatePassShop(int comp, int locname) throws Exception {
		return gatePassRepository.getDeliveryShop(comp, locname);
	}

	public List getSuperAdminStockNO(String searchValue) throws Exception {
		return gatePassRepository.getSuperAdminStockNO(searchValue);
	}

	public List getStockNO(String str, int compid, int brnchid, int loc, int locref) throws Exception {
		return gatePassRepository.getStockNO(str, compid, brnchid, loc, locref);
	}

	public List getSuperAdminStockProduct(String search) throws Exception {
		return gatePassRepository.getSuperAdminProduct(search);
	}

	public List getStockProduct(String str, int compid, int brnchid, int loc, int locref) throws Exception {
		return gatePassRepository.getStockProduct(str, compid, brnchid, loc, locref);
	}

	public boolean saveGatePass(GatePass dc) throws Exception {
		boolean flag = false;

		if (dc.getBilltyperefid() == 1) {
			System.out.println("inside gatepass if");

			List dcid = this.getSalesAutoincrement(dc.getCompanyrefid(), dc.getBranchrefid(), dc.getLocname(),
					dc.getLocrefid(), dc.getBilltyperefid());
			String str = (String) dcid.get(0);
			dc.setGpno(str);
			gatePassRepository.save_medc_salesordertrack(dc.getSalesorderrefid(), 8, dc.getClientcdate());
			// Boopalan 200919 - For saving data
			// medc_status.medc_salesordertrack

		}

		else if (dc.getBilltyperefid() == 2) {
			System.out.println("inside gatepass else if");
			List dcid = this.getPurchaseAutoincrement(dc.getCompanyrefid(), dc.getBranchrefid(), dc.getLocname(),
					dc.getLocrefid(), dc.getBilltyperefid());
			String str = (String) dcid.get(0);
			dc.setGpno(str);

		} else {
			System.out.println("inside gatepass else");
			List dcid = this.getAutoincrement(dc.getCompanyrefid(), dc.getBranchrefid(), dc.getLocname(),
					dc.getLocrefid(), dc.getBilltyperefid());
			String str = (String) dcid.get(0);
			dc.setGpno(str);

		}
		try {

			System.out.println("inside try");
			StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("medc_stock.pro_gatePass");
			storedProcedure.registerStoredProcedureParameter("gatepassno", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("gatepassdate", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("totalboxquantity", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("totalproducts", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("totalquantity", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("totalstripquantity", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("totaltabquantity", Double.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("fromlocationname", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("fromlocationrefid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("tolocationname", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("tolocationrefid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("companyid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("branchid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("locname", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("locrefid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("billtyperefid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("dcrefid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("salesorderrefid", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
			storedProcedure.setParameter("gatepassno", dc.getGpno());
			System.out.println("savegate pass billtyperefid" + dc.getGpno());
			storedProcedure.setParameter("gatepassdate", dc.getGatepassdate());
			System.out.println("savegate pass billtyperefid" + dc.getGatepassdate());
			storedProcedure.setParameter("totalboxquantity", dc.getTotalboxqty());
			System.out.println("savegate pass billtyperefid" + dc.getTotalboxqty());
			storedProcedure.setParameter("totalproducts", dc.getTotalproduct());
			System.out.println("savegate pass billtyperefid" + dc.getTotalproduct());
			storedProcedure.setParameter("totalquantity", dc.getTotalqty());
			storedProcedure.setParameter("totalstripquantity", dc.getTotalstripqty());
			storedProcedure.setParameter("totaltabquantity", dc.getTotaltabqty());
			storedProcedure.setParameter("fromlocationname", dc.getFromlocname());
			System.out.println("savegate pass billtyperefid" + dc.getFromlocname());
			storedProcedure.setParameter("fromlocationrefid", dc.getLocrefid());
			storedProcedure.setParameter("tolocationname", dc.getTolocname());
			storedProcedure.setParameter("tolocationrefid", dc.getTolocrefid());
			storedProcedure.setParameter("companyid", dc.getCompanyrefid());
			storedProcedure.setParameter("branchid", dc.getBranchrefid());
			storedProcedure.setParameter("locname", dc.getLocname());
			storedProcedure.setParameter("locrefid", dc.getLocrefid());
			storedProcedure.setParameter("billtyperefid", dc.getBilltyperefid());
			System.out.println("savegate pass billtyperefid" + dc.getBilltyperefid());
			storedProcedure.setParameter("dcrefid", dc.getDcrefid());
			System.out.println("savegate pass dcrefid" + dc.getDcrefid());
			// Set Session values for companyid and branchid and locid and
			// locrefid
			if (dc.getBilltyperefid() == 1) {
				storedProcedure.setParameter("salesorderrefid", dc.getSalesorderrefid());
			} else {
				storedProcedure.setParameter("salesorderrefid", 0);
			}
			System.out.println("salesorderrefid" + dc.getSalesorderrefid());
			compid = dc.getCompanyrefid();
			branchid = dc.getBranchrefid();
			locname = dc.getLocname();
			locrefid = dc.getLocrefid();
			storedProcedure.setParameter("functionality", "save");
			storedProcedure.execute();
			Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
			if (a == 1) {
				flag = true;

				gatePassRepository.saleupdatestatus(dc.getCompanyrefid(), dc.getBranchrefid(), dc.getLocname(),
						dc.getLocrefid(), dc.getDcrefid());
			}

		} catch (Exception e) {
			System.out.println("SaveGatePass" + e);
			// logger.error("Exception in Method : createPurchaseRecord() " +
			// e);
			throw new Exception(e);
		}
		return flag;
	}

	public boolean saveGatePassProducts(List<GateProduct> ip) throws Exception {
		System.out.println("GatePassProdu");
		boolean flag = false;
		int saveflag = 0;
		GateProduct ipinc = ip.get(0);
		int indp = 0;
		try {
//			int compid = (int) session.getAttribute("compid");
//			int branchid = (int) session.getAttribute("branchid");
//			int locname = (int) session.getAttribute("locname");
//			int locrefid = (int) session.getAttribute("locrefid");
			indp = gatePassRepository.getGatepassID(compid, branchid, locname, locrefid);
			System.out.println("GatePassProdu123" + indp);
			for (int i = 0; i < ip.size(); i++) {
				GateProduct purc = ip.get(i);
				StoredProcedureQuery storedProcedure = manager
						.createStoredProcedureQuery("medc_stock.pro_gatePassProduct");
				storedProcedure.registerStoredProcedureParameter("gatepassrefid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("drugrefid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("batchrefid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("boxquantity", Double.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("stripquantity", Double.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("tabletquantity", Double.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("totalquantity", Double.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("compid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("branchid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("locname", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("locrefid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("dcrefid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
				storedProcedure.setParameter("gatepassrefid", indp);
				storedProcedure.setParameter("drugrefid", purc.getDrugproductrefid());
				// storedProcedure.setParameter("batchrefid", purc.getDrugproductrefid());
				storedProcedure.setParameter("batchrefid", purc.getBatchrefid());
				storedProcedure.setParameter("boxquantity", purc.getBoxqty());
				storedProcedure.setParameter("stripquantity", purc.getStripqty());
				storedProcedure.setParameter("tabletquantity", purc.getTabqty());
				storedProcedure.setParameter("totalquantity", purc.getTotalqty());
				storedProcedure.setParameter("compid", compid);
				storedProcedure.setParameter("branchid", branchid);
				storedProcedure.setParameter("locname", locname);
				storedProcedure.setParameter("locrefid", locrefid);
				storedProcedure.setParameter("dcrefid", purc.getDcrefid());

				storedProcedure.setParameter("functionality", "save");
				storedProcedure.execute();
				Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
				if (a == 1) {
					flag = true;
				}

			}
		} catch (Exception e) {
			System.out.println("GatePassProduct" + e);
			throw new Exception(e);

		} finally {
			session.invalidate();
		}
		return flag;
	}

	public List getStockTransferNO() throws Exception {
		return gatePassRepository.StockTransferNo();
	}

	public List getStockTransProduct() throws Exception {
		return gatePassRepository.StockTransProduct();
	}

	public int updateDeliveryChallan(GatePass ir) throws Exception {
		int saveflag = 0;
		gatePassRepository.save(ir);

		saveflag = 1;
		return saveflag;
	}

	public int updateDeliveryProducts(List<GateProduct> ip) throws Exception {
		int saveflag = 0;
		GateProduct indp = ip.get(0);
		for (GateProduct temp : ip) {
			gatePassProductRepository.save(temp);

		}
		return saveflag;

	}

	public List viewIndentRequests(IndCompModel loc) {

		return gatePassRepository.viewIndentRequests(loc.getLocname(), loc.getLocrefid());
	}

	public List viewIndentRequest(IndCompModel loc) {

		return gatePassRepository.viewIndentRequest(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewshopinformation(IndCompModel loc) {

		return gatePassRepository.viewshopinformation(loc.getLocname(), loc.getLocrefid());
	}

	public List viewWareHouse(IndCompModel loc) {

		return gatePassRepository.viewWareHouse(loc.getLocname(), loc.getLocrefid());
	}

	public List viewHospital(IndCompModel loc) {

		return gatePassRepository.viewHospital(loc.getLocname(), loc.getLocrefid());
	}

	public List viewWhCustProduct(IndCompModel loc) {

		return gatePassRepository.viewCustProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1(),
				loc.getCompanyid());
	}

	public List viewCustProduct(IndCompModel loc) {
		return gatePassRepository.viewCustProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());
	}

	public List viewIndentProduct(IndCompModel loc) {
		return gatePassProductRepository.viewIndentProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());
	}

	public List viewGatePass(int comp, int brnch, int locname, int locrefid, int billtyperefid) throws Exception {
		return gatePassRepository.viewDeliveryChalllan(comp, brnch, locname, locrefid, billtyperefid);
	}

	public int deleteIndReq(IndCompModel loc) throws Exception {
		int saveflag = 0;
		gatePassRepository.deleteIndReq(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;
	}

	// padmini
	public List getGatePassNo(String searchValue, int compid, int brnchid, int loc, int locref, int billtyperefid)
			throws Exception {
		return gatePassRepository.getGatePassNo(searchValue, compid, brnchid, loc, locref, billtyperefid);
	}

	public List getGatePassProduct(int dcid, int compid, int brnchid, int locname, int locrefid) throws Exception {
		return gatePassRepository.getGatePassProduct(dcid, compid, brnchid, locname, locrefid);
	}

	// Raja
	public List getdelchal(int dcid) throws Exception {
		System.out.println("Raja2");
		return gatePassRepository.getdelchalid(dcid);
	}

	public List getcustomerdetail(Integer dcid) throws Exception {
		return gatePassRepository.getcustom(dcid);
	}

}
