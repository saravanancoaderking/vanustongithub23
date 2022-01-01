package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.DeliverChallan;
import com.medeil.domain.DeliveryProduct;
import com.medeil.domain.IndCompModel;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.domain.PurchaseOrder;
import com.medeil.repository.DeliveryChallanRepository;
import com.medeil.repository.DeliveryProductRepository;
import com.medeil.util.AutoIncrement;

@Service
public class DeliveryChallanService {
	private Integer ndcid;
	@PersistenceContext
	private EntityManager manager;

	@PersistenceContext
	EntityManager em;

	Query query;

	@Autowired
	private HttpSession session;

	private final DeliveryChallanRepository deliveryChallanRepo;

	private final DeliveryProductRepository deliveryProductRepo;

	private final Logger log = LoggerFactory.getLogger(IndReqService.class);

	@Autowired
	DeliveryChallanService(DeliveryChallanRepository dc, DeliveryProductRepository dp) {

		this.deliveryChallanRepo = dc;

		this.deliveryProductRepo = dp;

	}

	int compid;
	int branchid;
	int locname;
	int locrefid;

	// Stock Transfer Block
	public List getStranferAdminStockNO(String search) throws Exception {
		return deliveryChallanRepo.getStranferAdminStockNO(search);
	}

	public List getStranferStockNO(String str, int compid, int brnchid, int loc, int locref) throws Exception {
		return deliveryChallanRepo.getStranferStockNO(str, compid, brnchid, loc, locref);
	}

	public List getSuperAdminStockProduct(String search) throws Exception {
		return deliveryChallanRepo.getSuperAdminProduct(search);
	}

	// Purchase Block

	public List getDeliveryAdminPurchaseNO(String search) throws Exception {
		return deliveryChallanRepo.getDeliveryAdminPurchaseNO(search);
	}

	public List getDeliveryPurchaseNO(String str, int compid, int brnchid, int loc, int locref) throws Exception {
		return deliveryChallanRepo.getDeliveryPurchaseNO(str, compid, brnchid, loc, locref);
	}

	public List getDeliveryPurchaseInvoiceProduct(String search) throws Exception {
		return deliveryChallanRepo.getDeliveryPurchaseInvoiceProduct(search);
	}

	// Sales Invoice Block

	public List getDeliveryAdminSalesNO(String search) throws Exception {
		return deliveryChallanRepo.getDeliveryAdminSalesNO(search);
	}

	public List getDeliverySalesNO(String str, int compid, int brnchid, int loc, int locref) throws Exception {
		return deliveryChallanRepo.getDeliverySalesNO(str, compid, brnchid, loc, locref);
	}

	public List getDeliverySalesInvoiceProduct(String search) throws Exception {
		return deliveryChallanRepo.getDeliverySalesInvoiceProduct(search);
	}

	//

	public List getQuantity(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = deliveryChallanRepo.getpurQuantity(id);
		// } catch (Exception ea) {
		// logger.error("Exception in Method : getQuantity() " + ea);
		// }
		return deliveryChallanRepo.getpurQuantity(id);
	}

	@Transactional
	public List getAutoincrement(int compid, int branchid, int locname, int locrefid, int billtyperefid)
			throws Exception {
		List ls = null;
		String a1 = "deliveryChallan";

		// try {
		String q = "Call medc_stock.pro_autoincrement(?,?,?,?,?,?)";
		query = em.createNativeQuery(q);
		query.setParameter(1, a1);
		query.setParameter(2, compid);
		query.setParameter(3, branchid);
		query.setParameter(4, locname);
		query.setParameter(5, locrefid);
		query.setParameter(6, billtyperefid);
		ls = query.getResultList();
		System.out.println("SutoIncrement  :" + ls);
		// } catch (Exception e) {
		// System.out.println("getAutoincrements :" + e);
		// }

		return ls;
	}

	@Transactional
	public List getSalesAutoincrement(int compid, int branchid, int locname, int locrefid, int billtyperefid)
			throws Exception {
		List ls = null;
		String a1 = "salesDeliveryChallan";

		// try {
		String q = "Call medc_stock.pro_autoincrement(?,?,?,?,?,?)";
		query = em.createNativeQuery(q);
		query.setParameter(1, a1);
		query.setParameter(2, compid);
		query.setParameter(3, branchid);
		query.setParameter(4, locname);
		query.setParameter(5, locrefid);
		query.setParameter(6, billtyperefid);
		ls = query.getResultList();
		System.out.println("SutoIncrement  :" + ls);
		// } catch (Exception e) {
		// System.out.println("getAutoincrements :" + e);
		// }

		return ls;
	}

	@Transactional
	public List getPurchaseAutoincrement(int compid, int branchid, int locname, int locrefid, int billtyperefid)
			throws Exception {
		List ls = null;
		String a1 = "purchaseDeliveryChallan";

		// try {
		String q = "Call medc_stock.pro_autoincrement(?,?,?,?,?,?)";
		query = em.createNativeQuery(q);
		query.setParameter(1, a1);
		query.setParameter(2, compid);
		query.setParameter(3, branchid);
		query.setParameter(4, locname);
		query.setParameter(5, locrefid);
		query.setParameter(6, billtyperefid);
		ls = query.getResultList();
		System.out.println("SutoIncrement  :" + ls);
		// } catch (Exception e) {
		// System.out.println("getAutoincrements :" + e);
		// }

		return ls;
	}

	public List getDeliveryShop(int comp, int locname) throws Exception {
		return deliveryChallanRepo.getDeliveryShop(comp, locname);
	}

	public List getStockProduct(String str, int compid, int brnchid, int loc, int locref) throws Exception {
		return deliveryChallanRepo.getStockProduct(str, compid, brnchid, loc, locref);
	}

	/*
	 * public boolean saveDeliveryChallan(DeliverChallan dc) { boolean flag = false;
	 * List dcid =
	 * this.getAutoincrement(dc.getCompanyrefid(),dc.getBranchrefid(),dc.getLocname(
	 * ),dc.getLocrefid()); String str=(String)dcid.get(0); dc.setDcno(str);
	 * deliveryChallanRepo.save(dc); session.setAttribute("compid",
	 * dc.getCompanyrefid()); session.setAttribute("branchid", dc.getBranchrefid());
	 * session.setAttribute("locname", dc.getLocname());
	 * session.setAttribute("locrefid", dc.getLocrefid()); flag = true; return flag;
	 * }
	 */

	/*
	 * public int saveDeliveryProducts(List<DeliveryProduct> ip) { int saveflag = 0;
	 * DeliveryProduct ipinc = ip.get(0); int indp = 0;
	 * 
	 * int compid=(int) session.getAttribute("compid"); int branchid=(int)
	 * session.getAttribute("branchid"); int locname= (int)
	 * session.getAttribute("locname"); int locrefid=(int)
	 * session.getAttribute("locrefid"); indp =
	 * deliveryChallanRepo.getDcID(compid,branchid,locname,locrefid); for
	 * (DeliveryProduct temp : ip) { temp.setDcrefid(indp);
	 * deliveryProductRepo.save(temp); } saveflag = 1; return saveflag;
	 * 
	 * }
	 */

	public boolean saveDeliveryChallan(DeliverChallan deli) throws Exception {
		boolean flag = false;

		if (deli.getBilltyperefid() == 1) {

			List dcid = this.getSalesAutoincrement(deli.getCompanyrefid(), deli.getBranchrefid(), deli.getLocname(),
					deli.getLocrefid(), deli.getBilltyperefid());
			String str = (String) dcid.get(0);
			deli.setDcno(str);

			deliveryChallanRepo.saleupdate(deli.getCompanyrefid(), deli.getBranchrefid(), deli.getLocname(),
					deli.getLocrefid(), deli.getStockno());
			deliveryChallanRepo.save_medc_salesordertrack(deli.getSalesorderrefid(), 7, deli.getClientcdate());
			// Boopalan 200919 - For saving data
			// medc_status.medc_salesordertrack
			deliveryChallanRepo.saleproduct(deli.getCompanyrefid(), deli.getBranchrefid(), deli.getLocname(),
					deli.getLocrefid(), deli.getStockno());
		}

		else if (deli.getBilltyperefid() == 2) {
			List dcid = this.getPurchaseAutoincrement(deli.getCompanyrefid(), deli.getBranchrefid(), deli.getLocname(),
					deli.getLocrefid(), deli.getBilltyperefid());
			String str = (String) dcid.get(0);
			deli.setDcno(str);

			deliveryChallanRepo.purcupdate(deli.getCompanyrefid(), deli.getBranchrefid(), deli.getLocname(),
					deli.getLocrefid(), deli.getStockno());

			deliveryChallanRepo.purcproduct(deli.getCompanyrefid(), deli.getBranchrefid(), deli.getLocname(),
					deli.getLocrefid(), deli.getStockno());

		} else {
			List dcid = this.getAutoincrement(deli.getCompanyrefid(), deli.getBranchrefid(), deli.getLocname(),
					deli.getLocrefid(), deli.getBilltyperefid());
			String str = (String) dcid.get(0);
			deli.setDcno(str);

			deliveryChallanRepo.stoctrfupdate(deli.getCompanyrefid(), deli.getBranchrefid(), deli.getLocname(),
					deli.getLocrefid(), deli.getStockno());

			deliveryChallanRepo.stoctrfproduct(deli.getCompanyrefid(), deli.getBranchrefid(), deli.getLocname(),
					deli.getLocrefid(), deli.getStockno());
		}
		try {
			StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("medc_stock.pro_deliverychallan");
			storedProcedure.registerStoredProcedureParameter("delivercno", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("deliverydate", String.class, ParameterMode.IN);

			storedProcedure.registerStoredProcedureParameter("totalproducts", Double.class, ParameterMode.IN);

			storedProcedure.registerStoredProcedureParameter("totalquantity", Double.class, ParameterMode.IN);

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
			storedProcedure.registerStoredProcedureParameter("stockno", Integer.class, ParameterMode.IN);// padmini
			// padmini
			storedProcedure.registerStoredProcedureParameter("salesorderrefid", Integer.class, ParameterMode.IN);

			storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
			storedProcedure.setParameter("delivercno", deli.getDcno());
			storedProcedure.setParameter("deliverydate", deli.getDeliverydate());

			storedProcedure.setParameter("totalproducts", deli.getTotalproduct());
			storedProcedure.setParameter("totalquantity", deli.getTotalqty());

			storedProcedure.setParameter("totaltabquantity", deli.getTotaltabqty());
			storedProcedure.setParameter("fromlocationname", deli.getFromlocname());
			storedProcedure.setParameter("fromlocationrefid", deli.getLocrefid());
			storedProcedure.setParameter("tolocationname", deli.getTolocname());
			storedProcedure.setParameter("tolocationrefid", deli.getTolocrefid());
			storedProcedure.setParameter("companyid", deli.getCompanyrefid());
			storedProcedure.setParameter("branchid", deli.getBranchrefid());
			storedProcedure.setParameter("locname", deli.getLocname());
			storedProcedure.setParameter("locrefid", deli.getLocrefid());
			storedProcedure.setParameter("billtyperefid", deli.getBilltyperefid());
			storedProcedure.setParameter("stockno", deli.getStockno());
			if (deli.getBilltyperefid() == 1) {
				storedProcedure.setParameter("salesorderrefid", deli.getSalesorderrefid());
			} else {
				storedProcedure.setParameter("salesorderrefid", 0);
			}
			System.out.println("salesorderrefid" + deli.getSalesorderrefid());
			// Set Session values for companyid and branchid and locid and locrefid
			compid = deli.getCompanyrefid();
			branchid = deli.getBranchrefid();
			locname = deli.getLocname();
			locrefid = deli.getLocrefid();
			storedProcedure.setParameter("functionality", "save");
			storedProcedure.execute();
			Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
			if (a == 1) {
				flag = true;

			}
		} catch (Exception e) {
			System.out.println("SaveDeliveryChallan" + e);
			// logger.error("Exception in Method : createPurchaseRecord() " + e);
			throw new Exception(e);
		}
		return flag;
	}

	public boolean saveDeliveryProducts(List<DeliveryProduct> dp) throws Exception {
		boolean flag = false;
		System.out.println("createPurchaseOrderProduct");
		try {
			DeliveryProduct ipinc = dp.get(0);
			int indp = 0;
			indp = deliveryChallanRepo.getDcID(compid, branchid, locname, locrefid);
			for (int i = 0; i < dp.size(); i++) {
				DeliveryProduct purc = dp.get(i);
				StoredProcedureQuery storedProcedure = manager
						.createStoredProcedureQuery("medc_stock.pro_deliveryproduct");
				storedProcedure.registerStoredProcedureParameter("deliveryrefid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("drugrefid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("batchrefid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("tabletquantity", Double.class, ParameterMode.IN);

				storedProcedure.registerStoredProcedureParameter("compid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("branchid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("locname", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("locrefid", Integer.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("billtyperefid", Integer.class, ParameterMode.IN);

				storedProcedure.registerStoredProcedureParameter("stockno", Integer.class, ParameterMode.IN);// padmini
				storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
				storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
				storedProcedure.setParameter("deliveryrefid", indp);
				storedProcedure.setParameter("drugrefid", purc.getDrugproductrefid());
				storedProcedure.setParameter("batchrefid", purc.getBatchrefid());
				storedProcedure.setParameter("tabletquantity", purc.getTabqty());

				storedProcedure.setParameter("compid", compid);
				storedProcedure.setParameter("branchid", branchid);
				storedProcedure.setParameter("locname", locname);
				storedProcedure.setParameter("locrefid", locrefid);
				storedProcedure.setParameter("billtyperefid", purc.getBilltyperefid());
				storedProcedure.setParameter("stockno", purc.getStockno());// padmini

				storedProcedure.setParameter("functionality", "save");
				storedProcedure.execute();
				Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
				if (a == 1) {
					flag = true;
				}
			}

		} catch (Exception e) {
			System.out.println("DeliveryProduct" + e);
			// logger.error("Exception in Method : createPurchaseOrderProduct() " + e);
			throw new Exception(e);
		} finally {
			session.invalidate();
		}
		return flag;
	}

	public List getStockTransferNO() throws Exception {
		return deliveryChallanRepo.StockTransferNo();
	}

	public List getStockTransProduct() throws Exception {
		return deliveryChallanRepo.StockTransProduct();
	}

	public int updateDeliveryChallan(DeliverChallan ir) throws Exception {
		int saveflag = 0;
		deliveryChallanRepo.save(ir);

		saveflag = 1;
		return saveflag;
	}

	public int updateDeliveryProducts(List<DeliveryProduct> ip) throws Exception {
		int saveflag = 0;
		DeliveryProduct indp = ip.get(0);
		for (DeliveryProduct temp : ip) {
			deliveryProductRepo.save(temp);

		}
		return saveflag;

	}

	public List viewIndentRequests(IndCompModel loc) throws Exception {

		return deliveryChallanRepo.viewIndentRequests(loc.getLocname(), loc.getLocrefid());
	}

	public List viewIndentRequest(IndCompModel loc) throws Exception {

		return deliveryChallanRepo.viewIndentRequest(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewshopinformation(IndCompModel loc) throws Exception {

		return deliveryChallanRepo.viewshopinformation(loc.getLocname(), loc.getLocrefid());
	}

	public List viewWareHouse(IndCompModel loc) throws Exception {

		return deliveryChallanRepo.viewWareHouse(loc.getLocname(), loc.getLocrefid());
	}

	public List viewHospital(IndCompModel loc) throws Exception {

		return deliveryChallanRepo.viewHospital(loc.getLocname(), loc.getLocrefid());
	}

	public List viewWhCustProduct(IndCompModel loc) throws Exception {

		return deliveryChallanRepo.viewCustProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1(),
				loc.getCompanyid());
	}

	public List viewCustProduct(IndCompModel loc) throws Exception {
		return deliveryChallanRepo.viewCustProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());
	}

	public List viewIndentProduct(IndCompModel loc) throws Exception {
		return deliveryProductRepo.viewIndentProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());
	}

	public List viewDeliveryChalllan(int comp, int brnch, int locname, int locrefid) throws Exception {
		return deliveryChallanRepo.viewDeliveryChalllan(comp, brnch, locname, locrefid);
	}

	public List viewStkMinQtyAll(IndCompModel loc) throws Exception {
		return deliveryChallanRepo.viewStkMinQtyAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewStkMinQty(IndCompModel loc) throws Exception {
		return deliveryChallanRepo.viewStkMinQty(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

	public List getPurchaseOrderNO() throws Exception {
		// System.out.println("locid"+loc.getLocrefid()+"company"+loc.getCompanyid());
		// return indtreqrepo.getPurchaseOrderNO(loc.getLocrefid() ,loc.getCompanyid());
		return deliveryChallanRepo.getPurchaseOrderNO();
	}

	public List adminPurchaseOrder(String loc) throws Exception {
		return deliveryChallanRepo.adminPurchaseOrder(loc);

	}

	public List purchaseOrder(String pono, int compid) throws Exception {
		return deliveryChallanRepo.purchaseOrder(pono, compid);
	}

	public int deleteIndReq(IndCompModel loc) throws Exception {
		int saveflag = 0;
		deliveryChallanRepo.deleteIndReq(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;
	}

	public List<DeliveryProduct> EditDeliveryChallanProduct(int compid, int branchid, int locname, int locrefid, int id)
			throws Exception {
//		return deliveryChallanRepo.EditDeliveryChallanProduct(compid, branchid, locname, locrefid, id);
		return deliveryProductRepo.findByDcrefid(id);
	}

	public DeliverChallan  EditDeliveryChallan(int compid, int branchid, int locname, int locrefid, int id) throws Exception {
		return deliveryChallanRepo.findById(id);
	}

	public List getEditShop(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = deliveryChallanRepo.getEditShop(id);
		// } catch (Exception ea) {
		// // logger.error("Exception in Method : getQuantity() " + ea);
		// }
		return deliveryChallanRepo.getEditShop(id);
	}

	public List getEditWarehouse(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = deliveryChallanRepo.getEditWarehouse(id);
		// } catch (Exception ea) {
		// // logger.error("Exception in Method : getQuantity() " + ea);
		// }
		return deliveryChallanRepo.getEditWarehouse(id);
	}

	public List getEditHospital(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = deliveryChallanRepo.getEditHospital(id);
		// } catch (Exception ea) {
		// // logger.error("Exception in Method : getQuantity() " + ea);
		// }
		return deliveryChallanRepo.getEditHospital(id);
	}

	public List geteditstid(Integer id) throws Exception {
		// List list = null;
		// try {
		// list = deliveryChallanRepo.StocktrnsID(id);
		// } catch (Exception ea) {

		// }
		return deliveryChallanRepo.StocktrnsID(id);
	}

	public List getsidetail(int siid) throws Exception {
		return deliveryChallanRepo.getsinvoice(siid);
	}

	public List getpurchaseorderid(Integer comid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		return deliveryChallanRepo.getporegnumber(comid, branchid, locname, locrefid);
	}

	public List getdistributordetail(Integer poid) throws Exception {
		return deliveryChallanRepo.getdist(poid);
	}

	public List getpodata(Integer poid) throws Exception {
		// List pp = null;
		// try {
		// pp = deliveryChallanRepo.getpro(poid);

		// } catch (Exception e) {
		// System.out.println("error Occure getpodata()");
		// }
		return deliveryChallanRepo.getpro(poid);
	}

	public boolean savepdcform(DeliverChallan dchallChallan) throws Exception {

		boolean flag = false;
		String lastid = deliveryChallanRepo.lastPurchasedc(dchallChallan.getCompanyrefid(),
				dchallChallan.getBranchrefid(), dchallChallan.getLocname(), dchallChallan.getLocrefid());

		String oldInco = lastid.substring(lastid.length() - 9, lastid.length());
		System.out.println(lastid.substring(lastid.length() - 9, lastid.length()));
		Long newInco = Long.parseLong(oldInco) + 1;
		String newid = StringUtils.leftPad(newInco.toString(), 9, "0");
		dchallChallan.setDcno("PDC" + newid);

		try {
			System.out.println("@@@@@@@@@@@@@@@@@@@@");
			deliveryChallanRepo.save(dchallChallan);
			System.out.println("########################");
			flag = true;

		} catch (Exception e) {
			throw new Exception(e);
		}
		return flag;
	}

	public boolean saveDcproduct(List<DeliveryProduct> dcproduct) throws Exception {

		boolean flag = false;
//			for (DeliveryProduct p : dcproduct) {
//				System.out.println(p.getBatchname());
//
//		boolean flag =false;		
//		poid = POrderRepository.getPurchaseOrderID();
//		purpro.get(0).setPorefid(poid);
//		poprorepo.saveAll(purpro);
		for (DeliveryProduct p : dcproduct) {

			try {
				int dcid;
				dcid = deliveryChallanRepo.getDcID();
				System.out.println(dcid);
				p.setDcrefid(dcid);
				deliveryProductRepo.save(p);

				deliveryProductRepo.updateflag(p.getCompanyrefid(), p.getBranchrefid(), p.getLocname(), p.getLocrefid(),
						p.getDrugproductrefid(), p.getPoid());
				flag = true;

			} catch (Exception e) {
//		logger.error("Exception in Method : SavePurchaseOrder() " + e);
				throw new Exception(e);
			}
		}
		return flag;
	}

	public List viewnpdc(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return deliveryChallanRepo.getdeliveychallan(comid, branchid, locname, locrefid);
	}

	public List getsalesinno(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return deliveryChallanRepo.getsino(comid, branchid, locname, locrefid);
	}

	public List getcustdetail(Integer siid) throws Exception {
		return deliveryChallanRepo.getcustomer(siid);
	}

	public List getdcProducts(Integer id) {
		return deliveryChallanRepo.getdcProducts(id);
	}

}
