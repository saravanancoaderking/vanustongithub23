/**
 * 
 */
package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Journal;
import com.medeil.domain.PurchaseApproval;
import com.medeil.domain.Stocks;
import com.medeil.repository.PJournalRepository;
import com.medeil.repository.PurchaseApprovalRepository;
import com.medeil.repository.StocksRepository;
import com.medeil.util.AutoIncrement;

/**
 * @author AjithKumar
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class PurchaseApprovalService {
	static List paautoincr;
	@Autowired
	private PurchaseApprovalRepository purchaseApprovalRepository;

	@Autowired
	StocksRepository stockrepo;

	@Autowired
	private PJournalRepository PjournalRepo;

	List list = null;

	@PersistenceContext
	private EntityManager em;

	Query query;

	private static Logger logger = LogManager.getLogger();

	public List getPurcinvoiceno(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		// list = null;
		// try {
		// list = purchaseApprovalRepository.getPurcinvoiceno(cid, bid, locrefid,
		// locname);
		// } catch (Exception Ep) {
		// logger.error("Exception in Method : getPurcinvoiceno() " + Ep);
		// }
		return purchaseApprovalRepository.getPurcinvoiceno(cid, bid, locrefid, locname);
	}

	public List getPurcApprovaldata(Integer id) throws Exception {
		// list = null;
		// try {
		// list = purchaseApprovalRepository.getPurcApprovaldata(id);
		// } catch (Exception Ed) {
		// logger.error("Exception in Method : getPurcApprovaldata() " + Ed);
		// }
		return purchaseApprovalRepository.getPurcApprovaldata(id);
	}

//	public boolean savepurchaseApproval(List<PurchaseApproval> purchaseApproval) {
//		boolean flag = false;
//		try {
//			for (int index = 0; index < purchaseApproval.size(); index++) {
//				PurchaseApproval purcApproval = purchaseApproval.get(index);
//				StoredProcedureQuery spQuery = em.createStoredProcedureQuery("medc_stock.pro_stockDetails");
//				spQuery.registerStoredProcedureParameter("productids", Integer.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("brandnames", String.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("boxqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("stripqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("tabletqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("totqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("approvalqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("damageqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("penddingqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("unitprices", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("discounts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("vats", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("gsts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("sgsts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("cgsts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("igsts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("utgsts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("batchnos", String.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("purprices", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("salesdiscs", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("mrps", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("formulationids", Integer.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("dosageids", String.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("expirydates", String.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("companyrefids", Integer.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("branchrefids", Integer.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("locrefids", Integer.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("locnames", Integer.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("freeboxqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("freestripqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("freetabletqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("freetotalqtys", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("vatamts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("gstamts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("sgstamts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("cgstamts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("igstamts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("utgstamts", Double.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("clientdates", String.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("batchnames", String.class, ParameterMode.IN);
//				spQuery.registerStoredProcedureParameter("returnFlag", Integer.class, ParameterMode.OUT);
//				spQuery.setParameter("productids", purcApproval.getProductid());
//				spQuery.setParameter("brandnames", purcApproval.getBrandname());
//				spQuery.setParameter("boxqtys", purcApproval.getBoxqty());
//				spQuery.setParameter("stripqtys", purcApproval.getStripqty());
//				spQuery.setParameter("tabletqtys", purcApproval.getTabletqty());
//				spQuery.setParameter("totqtys", purcApproval.getTotqty());
//				spQuery.setParameter("approvalqtys", purcApproval.getApprovalqty());
//				spQuery.setParameter("damageqtys", purcApproval.getDamageqty());
//				spQuery.setParameter("penddingqtys", purcApproval.getPenddingqty());
//				spQuery.setParameter("unitprices", purcApproval.getUnitprice());
//				spQuery.setParameter("discounts", purcApproval.getDiscount());
//				spQuery.setParameter("vats", purcApproval.getVat());
//				spQuery.setParameter("gsts", purcApproval.getGst());
//				spQuery.setParameter("sgsts", purcApproval.getSgst());
//				spQuery.setParameter("cgsts", purcApproval.getCgst());
//				spQuery.setParameter("igsts", purcApproval.getIgst());
//				spQuery.setParameter("utgsts", purcApproval.getUtgst());
//				spQuery.setParameter("batchnos", purcApproval.getBatchno());
//				spQuery.setParameter("purprices", purcApproval.getPurprice());
//				spQuery.setParameter("salesdiscs", purcApproval.getSalesdisc());
//				spQuery.setParameter("mrps", purcApproval.getMrp());
//				spQuery.setParameter("formulationids", purcApproval.getFormulationid());
//				spQuery.setParameter("dosageids", purcApproval.getDosageid());
//				spQuery.setParameter("expirydates", purcApproval.getExpirydate());
//				spQuery.setParameter("companyrefids", purcApproval.getCompanyrefid());
//				spQuery.setParameter("branchrefids", purcApproval.getBranchrefid());
//				spQuery.setParameter("locrefids", purcApproval.getLocrefid());
//				spQuery.setParameter("locnames", purcApproval.getLocname());
//				spQuery.setParameter("freeboxqtys", purcApproval.getFreeboxqty());
//				spQuery.setParameter("freestripqtys", purcApproval.getFreestripqty());
//				spQuery.setParameter("freetabletqtys", purcApproval.getFreetabletqty());
//				spQuery.setParameter("freetotalqtys", purcApproval.getFreetotalqty());
//				spQuery.setParameter("vatamts", purcApproval.getVatamt());
//				spQuery.setParameter("gstamts", purcApproval.getGstamt());
//				spQuery.setParameter("sgstamts", purcApproval.getSgstamt());
//				spQuery.setParameter("cgstamts", purcApproval.getCgstamt());
//				spQuery.setParameter("igstamts", purcApproval.getIgstamt());
//				spQuery.setParameter("utgstamts", purcApproval.getUtgstamt());
//				spQuery.setParameter("clientdates", purcApproval.getClientcdate());
//				spQuery.setParameter("batchnames", purcApproval.getBatchname());
//				spQuery.execute();
//				Integer a = (Integer) spQuery.getOutputParameterValue("returnFlag");
//				if (a == 2 || a == 5) {
//					flag = true;
//				}
//			}
//		} catch (Exception Ex) {
//			logger.error("Exception in Method : savepurchaseApproval() " + Ex);
//			Ex.printStackTrace();
//		}
//		return flag;
//	}

	public boolean savepurchaseApproval(List<Stocks> stock) throws Exception{
		boolean result = true;
		try {

			if (result == true) {
				for (Stocks stk : stock) {
					Integer stkid = purchaseApprovalRepository.getStockid(stk.getDrugproductid(), stk.getBatchno());
					stk.setPurcapprovalrefid(purchaseApprovalRepository.getPurchasAppID());
					System.out.println(">>>>>>stokid" + stkid);
					if (stkid != null) {
						stk.setId(stkid);
						Stocks stockupdate = stockrepo.findById(stk.getId());

						stockupdate.setQty((stk.getApprovalqty() + stockupdate.getQty()));
						stockupdate.setFreeboxqty((stk.getFreeboxqty() + stockupdate.getFreeboxqty()));
//						stockupdate.setFreestripqty((stk.getFreestripqty() + stockupdate.getFreestripqty()));
//						stockupdate.setFreetabletqty((stk.getFreetabletqty() + stockupdate.getFreetabletqty()));
						stockupdate.setBoxqty((stk.getBoxqty() + stockupdate.getBoxqty()));
						stockupdate.setStripqty((stk.getStripqty() + stockupdate.getStripqty()));
						stockupdate.setTabletqty((stk.getTabletqty() + stockupdate.getTabletqty()));
						stockupdate.setFreetotalqty((stk.getFreetotalqty() + stockupdate.getFreetotalqty()));
						stockupdate.setApprovalqty((stk.getApprovalqty() + stockupdate.getApprovalqty()));
//						stockupdate.setPenddingqty((stockupdate.getPenddingqty() - stk.getApprovalqty()));
//						stockupdate.setDamageqty((stockupdate.getDamageqty() - stk.getApprovalqty()));
						stockrepo.save(stockupdate);
						String totqty = stockrepo.getinvproductqty(stk.getPurchinvrefid(), stk.getDrugproductid(),
								stk.getBatchno());
						Double totalqt = Double.valueOf(totqty);
						if (totalqt.equals(stockupdate.getApprovalqty())) {
							purchaseApprovalRepository.updatepurstatus(stockupdate.getCompanyrefid(),
									stockupdate.getBranchrefid(), stockupdate.getLocname(), stockupdate.getLocrefid(),
									stockupdate.getPurchinvrefid(), stockupdate.getDrugproductid(),
									stockupdate.getBatchno());
						}
					} else {
						stockrepo.save(stk);
						String totqty = stockrepo.getinvproductqty(stk.getPurchinvrefid(), stk.getDrugproductid(),
								stk.getBatchno());
						Double totalqt = Double.valueOf(totqty);
						if (totalqt.equals(stk.getApprovalqty())) {
							purchaseApprovalRepository.updatepurstatus(stk.getCompanyrefid(), stk.getBranchrefid(),
									stk.getLocname(), stk.getLocrefid(), stk.getPurchinvrefid(), stk.getDrugproductid(),
									stk.getBatchno());
						}
					}
					result = true;
				}

			}

			else {
				result = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return result;
	}

//	@Transactional
//	public boolean savepurchaseApprovalrecords(PurchaseApproval purchaseApproval) {
//		boolean flag = false;
//		purchaseApprIncrement(purchaseApproval.getCompanyrefid(), purchaseApproval.getBranchrefid(), purchaseApproval.getLocname(),
//				purchaseApproval.getLocrefid());
//		System.out.println((purchaseApproval.getCompanyrefid()+" "+ purchaseApproval.getBranchrefid()+" "+ purchaseApproval.getLocname()+" "+
//				purchaseApproval.getLocrefid()));
//		String s = paautoincr.toString();//Boopalan 080419
//		purchaseApproval.setApprovalno(s.substring(1, s.length() - 1));//Boopalan 080419
//		System.out.println(purchaseApproval.getApprovalno());
//		try {
//			String queryData = "INSERT INTO medc_stock.medc_purchaseapproval(PurcApprovalNo, PurcApprovalDate, PurchaseInvRefID, CompanyRefID, BranchRefID, ShopRefID, WarehouseRefID, HospitalRefID, LocRefID, LocName) VALUES (? ,? ,? ,?, ?, ?, ?, ?, ?, ?)";
//			query = em.createNativeQuery(queryData);
//			query.setParameter(1, purchaseApproval.getApprovalno());
//			query.setParameter(2, purchaseApproval.getApprovaldate());
//			query.setParameter(3, purchaseApproval.getInvoicenumber());
//			query.setParameter(4, purchaseApproval.getCompanyrefid());
//			query.setParameter(5, purchaseApproval.getBranchrefid());
//			query.setParameter(6, purchaseApproval.getShoprefid());
//			query.setParameter(7, purchaseApproval.getWarehouserefid());
//			query.setParameter(8, purchaseApproval.getHospitalrefid());
//			query.setParameter(9, purchaseApproval.getLocrefid());
//			//purchaseApproval.setLocname(1);  //selva
//			query.setParameter(10, purchaseApproval.getLocname());  //selva
//			//query.setParameter(10, 1);
//			Integer returnID = query.executeUpdate();
//			if (returnID == 1) {
//				flag = true;
//				
//				purchaseApprovalRepository.updatepurstatus(purchaseApproval.getCompanyrefid(),purchaseApproval.getBranchrefid(),purchaseApproval.getLocname(),purchaseApproval.getLocrefid(),purchaseApproval.getInvoicenumber());
//			}
//		} catch (Exception eX) {
//			logger.error("Exception in Method : savepurchaseApprovalrecords() " + eX);
//			eX.printStackTrace();
//		}
//		return flag;
//	}
	/** PURCHASE APPROVAL NUMBER AUTO INCREMENT **/ // Boopalan 030419
	public void purchaseApprIncrement(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		List val = null;
		try {
			String value = "CALL medc_stock.pro_purcapprautoincrement(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "purchaseapproval");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : purchaseApprIncrement() " + e);
			throw new Exception(e);
		}
		paautoincr = val;
	}

	public boolean savepurchaseApprovalrecords(PurchaseApproval purchaseApproval) throws Exception{

		String lastid = purchaseApprovalRepository.lastPurchaseApp(purchaseApproval.getCompanyrefid(),
				purchaseApproval.getBranchrefid(), purchaseApproval.getLocname(), purchaseApproval.getLocrefid());
		String oldInco = lastid.substring(lastid.length() - 9, lastid.length());
		Long newInco = Long.parseLong(oldInco) + 1;
		String newid = StringUtils.leftPad(newInco.toString(), 9, "0");

		purchaseApproval.setPurcapprovalno("PAN" + newid);
			purchaseApprovalRepository.save(purchaseApproval);

		return true;
	}

	public int savePAJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		Double incid = PjournalRepo.viewInvJrnlId(jrnl.getLocname(), jrnl.getLocrefid());
		String incno = PjournalRepo.viewInvJrnlIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);
		if (incno == null) {
			incno = "0";
		}

		int sid = purchaseApprovalRepository.viewPurchaseAppId(jrnl.getLocname(), jrnl.getLocrefid());
		String invname = purchaseApprovalRepository.viewPurchaseAppMaxNo(jrnl.getLocname(), jrnl.getLocrefid());
		String personame = purchaseApprovalRepository.viewCustName(jrnl.getPersonid());

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("IN/JRNL/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));
		jrnl.setPersoname(personame);

		jrnl.setInvoicename(invname);
		//jrnl.setCreditamount(jrnl.getDebitamount());
		jrnl.setInvoiceno(sid);
		jrnl.setJournalno(incr.toString());
		PjournalRepo.save(jrnl);

		saveflag = 1;
		return saveflag;
	}

	public List getVendordetails(Integer id) throws Exception {
		return purchaseApprovalRepository.getVendordetails(id);
	}

	public ArrayList getPurchaseduelist(Integer lname, Integer lrefid)throws Exception {
		ArrayList x = purchaseApprovalRepository.getPurchaseduelist(lname, lrefid);
		return x;
	}

}
