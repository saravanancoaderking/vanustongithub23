/**
 * 
 */
package com.medeil.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.repository.PurcRepository;
import com.medeil.repository.PurchaseRepository;

/**
 * @author Ajith Kumar
 *
 */
public class PurchaseRepositoryImpl implements PurcRepository {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private HttpSession session;

	private static Logger logger = LogManager.getLogger();

	@Override
	public boolean createRecord(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createPurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecord(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/*** CREATE PURCHASE INVOICE ***/
//	@Override
//	public boolean createRecord(Purchase purchase) throws Exception, SQLException {
//		boolean flag = false;
//		try {
//			String function = "SAVE";
//			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("medc_purchase.pro_purchaseInvoice");
//			storedProcedure.registerStoredProcedureParameter("pinos", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("pidates", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("vendorinvoicenos", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("deliverytypes", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("vendorids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("actamounts", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalproducts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalquantitys", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totfreeqtys", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("subtotals", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totaldiscounts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("cashdiscounts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("rounddedoffs", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("invoiceamts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("adjustamts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("prnumbers", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("margins", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalgsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalamts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalsgsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalcgsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totaligsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalvats", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalutgsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("taxableamounts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("piins", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("clientcdates", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("refpoids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
//			storedProcedure.registerStoredProcedureParameter("exception", String.class, ParameterMode.OUT);
//			storedProcedure.setParameter("pinos", purchase.getPino());
//			storedProcedure.setParameter("pidates", purchase.getPidate());
//			storedProcedure.setParameter("vendorinvoicenos", purchase.getVendorinvoiceno());
//			storedProcedure.setParameter("deliverytypes", purchase.getDeliverytype());
//			storedProcedure.setParameter("vendorids", purchase.getVendorid());
//			storedProcedure.setParameter("actamounts", purchase.getActamount());
//			storedProcedure.setParameter("totalproducts", purchase.getTotalproduct());
//			storedProcedure.setParameter("totalquantitys", purchase.getTotalquantity());
//			storedProcedure.setParameter("totfreeqtys", purchase.getTotfreeqty());
//			storedProcedure.setParameter("subtotals", purchase.getSubtotal());
//			storedProcedure.setParameter("totaldiscounts", purchase.getTotaldiscount());
//			storedProcedure.setParameter("cashdiscounts", purchase.getCashdiscount());
//			storedProcedure.setParameter("rounddedoffs", purchase.getRounddedoff());
//			storedProcedure.setParameter("invoiceamts", purchase.getInvoiceamt());
//			storedProcedure.setParameter("adjustamts", purchase.getAdjustamt());
//			storedProcedure.setParameter("prnumbers", purchase.getPrnumber());
//			storedProcedure.setParameter("margins", purchase.getMargin());
//			storedProcedure.setParameter("totalgsts", purchase.getTotalgst());
//			storedProcedure.setParameter("totalamts", purchase.getTotalamt());
//			storedProcedure.setParameter("totalsgsts", purchase.getTotalsgst());
//			storedProcedure.setParameter("totalcgsts", purchase.getTotalcgst());
//			storedProcedure.setParameter("totaligsts", purchase.getTotaligst());
//			storedProcedure.setParameter("totalvats", purchase.getTotalvat());
//			storedProcedure.setParameter("totalutgsts", purchase.getTotalutgst());
//			storedProcedure.setParameter("taxableamounts", purchase.getTaxableamount());
//			storedProcedure.setParameter("piins", 0);
//			storedProcedure.setParameter("companyrefids", purchase.getCompanyrefid());
//			storedProcedure.setParameter("branchrefids", purchase.getBranchrefid());
//			storedProcedure.setParameter("locnames", purchase.getLocname());
//			storedProcedure.setParameter("locrefids", purchase.getLocrefid());
//			storedProcedure.setParameter("clientcdates", purchase.getClientcdate());
//			storedProcedure.setParameter("refpoids", purchase.getRefpoid());
//			storedProcedure.setParameter("functionality", function);
//			/*
//			 * Attribute To set Local Usage
//			 */
//			session.setAttribute("comp", purchase.getCompanyrefid());
//			session.setAttribute("brnch", purchase.getBranchrefid());
//			session.setAttribute("loname", purchase.getLocname());
//			session.setAttribute("lorefid", purchase.getLocrefid());
//			storedProcedure.execute();
//			Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
//			String SqlException = (String) storedProcedure.getOutputParameterValue("exception");			
//			if (a == 1) {
//				flag = true;
//			}
//		} catch (Exception Ex) {
//			logger.error("Exception in Method Purchase: createRecord() " + Ex);
//			Ex.printStackTrace();
//		}
//		return flag;
//	}
//
//	@Override
//	public boolean createPurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception, SQLException {
//		boolean returnFlag = false;
//		try {
//			String function = "SAVE";
//			for (int i = 0; i < purchaseinvoice.size(); i++) {
//				int cid = (Integer) session.getAttribute("comp");
//				int bid = (Integer) session.getAttribute("brnch");
//				int lname = (Integer) session.getAttribute("loname");
//				int lrefid = (Integer) session.getAttribute("lorefid");
//				Integer PIID = purchaseRepository.getPIID(cid, bid, lrefid, lname);
//				int piid = PIID;
//				PurchaseInvoice purc = purchaseinvoice.get(i);
//				StoredProcedureQuery sP = em.createStoredProcedureQuery("medc_purchase.pro_purcInvoice");
//				sP.registerStoredProcedureParameter("productids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("productnames", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("dosages", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("formulations", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("mfgs", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("boxquantitys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("stripquantitys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("tabletquantitys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("freeboxqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("freestripqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("freetabletqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("batchnos", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("expirydates", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("purchaseprices", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("mrps", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("salesdiscs", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("purchasediscs", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("vats", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("gsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("sgsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("cgsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("amounts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("dosageIds", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("formIds", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("mfgIds", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("gstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("vatamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("sgstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("cgstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("igstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("totalqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("totalfreeqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("discamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("igsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("piids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("piproductidss", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("pirefidss", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("utgsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("utgstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("comprefids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("clientcdates", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("refpoids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("returnFlag", Integer.class, ParameterMode.OUT);
//				sP.setParameter("productids", purc.getProductid());
//				sP.setParameter("productnames", purc.getProductname());
//				sP.setParameter("dosages", purc.getDosage());
//				sP.setParameter("formulations", purc.getFormulation());
//				sP.setParameter("mfgs", purc.getMfg());
//				sP.setParameter("boxquantitys", purc.getBoxquantity());
//				sP.setParameter("stripquantitys", purc.getStripquantity());
//				sP.setParameter("tabletquantitys", purc.getTabletquantity());
//				sP.setParameter("freeboxqtys", purc.getFreeboxqty());
//				sP.setParameter("freestripqtys", purc.getFreestripqty());
//				sP.setParameter("freetabletqtys", purc.getFreetabletqty());
//				sP.setParameter("batchnos", purc.getBatchno());
//				sP.setParameter("expirydates", purc.getExpirydate());
//				sP.setParameter("purchaseprices", purc.getPurchaseprice());
//				sP.setParameter("mrps", purc.getMrp());
//				sP.setParameter("salesdiscs", purc.getSalesdisc());
//				sP.setParameter("purchasediscs", purc.getPurchasedisc());
//				sP.setParameter("vats", purc.getVat());
//				sP.setParameter("gsts", purc.getGsts());
//				sP.setParameter("sgsts", purc.getSgst());
//				sP.setParameter("cgsts", purc.getCgst());
//				sP.setParameter("amounts", purc.getAmount());
//				sP.setParameter("dosageIds", purc.getDosageId());
//				sP.setParameter("formIds", purc.getFormId());
//				sP.setParameter("mfgIds", purc.getMfgId());
//				sP.setParameter("gstamts", purc.getGstamt());
//				sP.setParameter("vatamts", purc.getVatamt());
//				sP.setParameter("sgstamts", purc.getSgstamt());
//				sP.setParameter("cgstamts", purc.getCgstamt());
//				sP.setParameter("igstamts", purc.getIgstamt());
//				sP.setParameter("totalqtys", purc.getTotalqty());
//				sP.setParameter("totalfreeqtys", purc.getTotalfreeqty());
//				sP.setParameter("discamts", purc.getDiscamt());
//				sP.setParameter("igsts", purc.getIgst());
//				sP.setParameter("piids", piid);
//				sP.setParameter("piproductidss", 0);
//				sP.setParameter("pirefidss", 0);
//				sP.setParameter("utgsts", purc.getUtgst());
//				sP.setParameter("utgstamts", purc.getUtgstamt());
//				sP.setParameter("comprefids", cid);
//				sP.setParameter("branchrefids", bid);
//				sP.setParameter("locnames", lname);
//				sP.setParameter("locrefids", lrefid);
//				sP.setParameter("clientcdates", purc.getClientcdate());
//				sP.setParameter("refpoids", purc.getRefpoid());
//				sP.setParameter("functionality", function);
//				sP.execute();
//				Integer a = (Integer) sP.getOutputParameterValue("returnFlag");
//				if (a == 1) {
//					returnFlag = true;
//				}
//			}
//		} catch (Exception Ex) {
//			logger.error("Exception in Method Purchase: createPurcinvoice() " + Ex);
//			Ex.printStackTrace();
//		} finally {
//			session.removeAttribute("comp");
//			session.removeAttribute("brnch");
//			session.removeAttribute("loname");
//			session.removeAttribute("lorefid");
//		}
//		return returnFlag;
//	}
//
//	/*** UPDATE PURCHASE INVOICE ***/
//
//	@Override
//	public boolean updateRecord(Purchase purchase) throws Exception {
//		boolean flag = false;
//		try {
//			String function = "UPDATE";
//			StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("medc_purchase.pro_purchaseInvoice");
//			storedProcedure.registerStoredProcedureParameter("pinos", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("pidates", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("vendorinvoicenos", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("deliverytypes", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("vendorids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("actamounts", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalproducts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalquantitys", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totfreeqtys", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("subtotals", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totaldiscounts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("cashdiscounts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("rounddedoffs", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("invoiceamts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("adjustamts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("prnumbers", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("margins", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalgsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalamts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalsgsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalcgsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totaligsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalvats", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("totalutgsts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("taxableamounts", Double.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("piins", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("clientcdates", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("refpoids", Integer.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//			storedProcedure.registerStoredProcedureParameter("flag", Integer.class, ParameterMode.OUT);
//			storedProcedure.registerStoredProcedureParameter("exception", String.class, ParameterMode.OUT);
//			storedProcedure.setParameter("pinos", purchase.getPino());
//			storedProcedure.setParameter("pidates", purchase.getPidate());
//			storedProcedure.setParameter("vendorinvoicenos", purchase.getVendorinvoiceno());
//			storedProcedure.setParameter("deliverytypes", purchase.getDeliverytype());
//			storedProcedure.setParameter("vendorids", purchase.getVendorid());
//			storedProcedure.setParameter("actamounts", purchase.getActamount());
//			storedProcedure.setParameter("totalproducts", purchase.getTotalproduct());
//			storedProcedure.setParameter("totalquantitys", purchase.getTotalquantity());
//			storedProcedure.setParameter("totfreeqtys", purchase.getTotfreeqty());
//			storedProcedure.setParameter("subtotals", purchase.getSubtotal());
//			storedProcedure.setParameter("totaldiscounts", purchase.getTotaldiscount());
//			storedProcedure.setParameter("cashdiscounts", purchase.getCashdiscount());
//			storedProcedure.setParameter("rounddedoffs", purchase.getRounddedoff());
//			storedProcedure.setParameter("invoiceamts", purchase.getInvoiceamt());
//			storedProcedure.setParameter("adjustamts", purchase.getAdjustamt());
//			storedProcedure.setParameter("prnumbers", purchase.getPrnumber());
//			storedProcedure.setParameter("margins", purchase.getMargin());
//			storedProcedure.setParameter("totalgsts", purchase.getTotalgst());
//			storedProcedure.setParameter("totalamts", purchase.getTotalamt());
//			storedProcedure.setParameter("totalsgsts", purchase.getTotalsgst());
//			storedProcedure.setParameter("totalcgsts", purchase.getTotalcgst());
//			storedProcedure.setParameter("totaligsts", purchase.getTotaligst());
//			storedProcedure.setParameter("totalvats", purchase.getTotalvat());
//			storedProcedure.setParameter("totalutgsts", purchase.getTotalutgst());
//			storedProcedure.setParameter("taxableamounts", purchase.getTaxableamount());
//			storedProcedure.setParameter("piins", purchase.getPiids());
//			storedProcedure.setParameter("companyrefids", purchase.getCompanyrefid());
//			storedProcedure.setParameter("branchrefids", purchase.getBranchrefid());
//			storedProcedure.setParameter("locnames", purchase.getLocname());
//			storedProcedure.setParameter("locrefids", purchase.getLocrefid());
//			storedProcedure.setParameter("clientcdates", purchase.getClientcdate());
//			storedProcedure.setParameter("refpoids", purchase.getRefpoid());
//			storedProcedure.setParameter("functionality", function);
//			/*
//			 * Attribute To set Local Usage
//			 */
//			session.setAttribute("comp", purchase.getCompanyrefid());
//			session.setAttribute("brnch", purchase.getBranchrefid());
//			session.setAttribute("loname", purchase.getLocname());
//			session.setAttribute("lorefid", purchase.getLocrefid());
//			storedProcedure.execute();
//			Integer a = (Integer) storedProcedure.getOutputParameterValue("flag");
//			String SqlException = (String) storedProcedure.getOutputParameterValue("exception");
//			if (a == 1) {
//				flag = true;
//			}
//		} catch (Exception Ex) {
//			logger.error("Exception in Method Purchase: updateRecord() " + Ex);
//			Ex.printStackTrace();
//		}
//		return flag;
//	}
//
//	@Override
//	public boolean updatePurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception {
//		boolean returnFlag = false;
//		String function = "UPDATE";
//		try {
//			for (int i = 0; i < purchaseinvoice.size(); i++) {
//				int cid = (Integer) session.getAttribute("comp");
//				int bid = (Integer) session.getAttribute("brnch");
//				int lname = (Integer) session.getAttribute("loname");
//				int lrefid = (Integer) session.getAttribute("lorefid");
//				Integer PIID = purchaseRepository.getPIID(cid, bid, lrefid, lname);
//				int piid = PIID;
//				PurchaseInvoice purc = purchaseinvoice.get(i);
//				StoredProcedureQuery sP = em.createStoredProcedureQuery("medc_purchase.pro_purcInvoice");
//				sP.registerStoredProcedureParameter("productids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("productnames", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("dosages", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("formulations", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("mfgs", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("boxquantitys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("stripquantitys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("tabletquantitys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("freeboxqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("freestripqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("freetabletqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("batchnos", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("expirydates", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("purchaseprices", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("mrps", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("salesdiscs", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("purchasediscs", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("vats", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("gsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("sgsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("cgsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("amounts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("dosageIds", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("formIds", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("mfgIds", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("gstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("vatamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("sgstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("cgstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("igstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("totalqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("totalfreeqtys", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("discamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("igsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("piids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("piproductidss", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("pirefidss", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("utgsts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("utgstamts", Double.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("comprefids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("clientcdates", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("refpoids", Integer.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("functionality", String.class, ParameterMode.IN);
//				sP.registerStoredProcedureParameter("returnFlag", Integer.class, ParameterMode.OUT);
//				sP.setParameter("productids", purc.getProductid());
//				sP.setParameter("productnames", purc.getProductname());
//				sP.setParameter("dosages", purc.getDosage());
//				sP.setParameter("formulations", purc.getFormulation());
//				sP.setParameter("mfgs", purc.getMfg());
//				sP.setParameter("boxquantitys", purc.getBoxquantity());
//				sP.setParameter("stripquantitys", purc.getStripquantity());
//				sP.setParameter("tabletquantitys", purc.getTabletquantity());
//				sP.setParameter("freeboxqtys", purc.getFreeboxqty());
//				sP.setParameter("freestripqtys", purc.getFreestripqty());
//				sP.setParameter("freetabletqtys", purc.getFreetabletqty());
//				sP.setParameter("batchnos", purc.getBatchno());
//				sP.setParameter("expirydates", purc.getExpirydate());
//				sP.setParameter("purchaseprices", purc.getPurchaseprice());
//				sP.setParameter("mrps", purc.getMrp());
//				sP.setParameter("salesdiscs", purc.getSalesdisc());
//				sP.setParameter("purchasediscs", purc.getPurchasedisc());
//				sP.setParameter("vats", purc.getVat());
//				sP.setParameter("gsts", purc.getGsts());
//				sP.setParameter("sgsts", purc.getSgst());
//				sP.setParameter("cgsts", purc.getCgst());
//				sP.setParameter("amounts", purc.getAmount());
//				sP.setParameter("dosageIds", purc.getDosageId());
//				sP.setParameter("formIds", purc.getFormId());
//				sP.setParameter("mfgIds", purc.getMfgId());
//				sP.setParameter("gstamts", purc.getGstamt());
//				sP.setParameter("vatamts", purc.getVatamt());
//				sP.setParameter("sgstamts", purc.getSgstamt());
//				sP.setParameter("cgstamts", purc.getCgstamt());
//				sP.setParameter("igstamts", purc.getIgstamt());
//				sP.setParameter("totalqtys", purc.getTotalqty());
//				sP.setParameter("totalfreeqtys", purc.getTotalfreeqty());
//				sP.setParameter("discamts", purc.getDiscamt());
//				sP.setParameter("igsts", purc.getIgst());
//				sP.setParameter("piids", piid);
//				if (purc.getPiproductids() == null || purc.getPiproductids().equals("")) {
//					purc.setPiproductids(0);
//				}
//				sP.setParameter("piproductidss", purc.getPiproductids());
//				sP.setParameter("pirefidss", purc.getPirefids());
//				sP.setParameter("utgsts", purc.getUtgst());
//				sP.setParameter("utgstamts", purc.getUtgstamt());
//				sP.setParameter("comprefids", cid);
//				sP.setParameter("branchrefids", bid);
//				sP.setParameter("locnames", lname);
//				sP.setParameter("locrefids", lrefid);
//				sP.setParameter("clientcdates", purc.getClientcdate());
//				sP.setParameter("refpoids", purc.getRefpoid());
//				sP.setParameter("functionality", function);
//				sP.execute();
//				Integer a = (Integer) sP.getOutputParameterValue("returnFlag");
//				if (a == 1) {
//					returnFlag = true;
//				}
//			}
//		} catch (Exception Ex) {
//			logger.error("Exception in Method Purchase: updatePurcinvoice() " + Ex);
//			Ex.printStackTrace();
//		} finally {
//			session.removeAttribute("comp");
//			session.removeAttribute("brnch");
//			session.removeAttribute("loname");
//			session.removeAttribute("lorefid");
//		}
//		return returnFlag;
//	}
}
