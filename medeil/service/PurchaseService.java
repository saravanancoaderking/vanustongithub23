/**
 * 
 */
package com.medeil.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Drug;
import com.medeil.domain.Hsncode;
import com.medeil.domain.Journal;
import com.medeil.domain.PoProduct;
import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.domain.Stocks;
import com.medeil.repository.DrugRepository;
import com.medeil.repository.HsncodeRepository;
import com.medeil.repository.PJournalRepository;
import com.medeil.repository.PoproductRepository;
import com.medeil.repository.PurchaseRepository;
import com.medeil.repository.PurchasenvoiceproRepository;
import com.medeil.repository.StocksRepository;
import com.medeil.util.AutoIncrement;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class PurchaseService {
	private static Logger logger = LogManager.getLogger();
	static List piautoincr;
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private PurchasenvoiceproRepository purcprorepo;
	@Autowired
	private DrugRepository drugrepo;
	@Autowired
	private HsncodeRepository hsnrepo;
	@Autowired
	private PJournalRepository PjournalRepo;
	@Autowired
	private StocksRepository stkrepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PoproductRepository poproductRepository;
	@PersistenceContext
	private EntityManager em;

	Query query;

	List list;

	public List getDistributor(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		list = null;
		try {
			if (locname == 1) {// Shop
				list = purchaseRepository.getshopDistributor(cid, bid, locrefid);
			}
			if (locname == 2) {// Warehouse
				list = purchaseRepository.getwareDistributor(cid, bid, locrefid);
			}
			if (locname == 3) {// Hosp
				list = purchaseRepository.gethospDistributor(cid, bid, locrefid);
			}
		} catch (Exception e) {
			logger.error("Exception in Method : getDistributor() " + e);
			throw new Exception(e);
		}
		return list;
	}

	public List getDistvalues(Integer distid) throws Exception {
		// list = null;
		// try {
		// list = purchaseRepository.getDistvalues(distid);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : getDistvalues() " + ex);
		// }
		return purchaseRepository.getDistvalues(distid);
	}

	public List getBrandlist(String val, Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		// List list = null;
		// try {
		// list = purchaseRepository.getBrandlist(val, cid);//

		// } catch (Exception e) {
		// logger.error("Exception in Method : getBrandlist() " + e);
		// }
		return purchaseRepository.getBrandlist(val, cid);
	}

	public List getPitabledata(Integer data, Integer cid, Integer bid, Integer locrefid, Integer locname)
			throws Exception {
		// list = null;
		// try {
		// list = purchaseRepository.getPitabledata(data, cid);
		// } catch (Exception es) {
		// logger.error("Exception in Method : getPitabledata() " + es);
		// }
		return purchaseRepository.getPitabledata(data, cid);
	}

	public List getPurTax(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		list = null;
		try {
			if (locname == 1) {// Shop
				list = purchaseRepository.getshopPurTax(cid, bid, locrefid);
			}
			if (locname == 2) {// Warehouse
				list = purchaseRepository.getwarePurTax(cid, bid, locrefid);
			}
			if (locname == 3) {// Hosp
				list = purchaseRepository.gethospPurTax(cid, bid, locrefid);
			}
		} catch (Exception ex) {
			logger.error("Exception in Method : getPurTax() " + ex);
			throw new Exception(ex);
		}
		return list;
	}

	public List getQuantity(Integer id) throws Exception {
		// list = null;
		// try {
		// list = purchaseRepository.getpurQuantity(id);
		// } catch (Exception ea) {
		// logger.error("Exception in Method : getQuantity() " + ea);
		// }
		return purchaseRepository.getpurQuantity(id);
	}

	/** CREATE PURCHASE MAINTENANCE RECORD **/
	public boolean createRecord(Purchase purchase) throws Exception {

		String lastid = purchaseRepository.lastPurchaseInvoice(purchase.getCompanyrefid(), purchase.getBranchrefid(),
				purchase.getLocname(), purchase.getLocrefid());

		String oldInco = lastid.substring(lastid.length() - 9, lastid.length());
		Long newInco = Long.parseLong(oldInco) + 1;
		String newid = StringUtils.leftPad(newInco.toString(), 9, "0");

		purchase.setPino("PIV" + newid);
		// try {
		purchase.getPuapprovalst();
		System.out.println(">>>>>>>>>>>>>>>>>" + purchase.getPuapprovalst());
		purchaseRepository.save(purchase);
		return true;
		// } catch (Exception e) {
		// e.printStackTrace();
		// logger.error("Exception in Method : getQuantity() " + e);
		// return false;
		// }
	}

//	/** CREATE PURCHASE MAINTENANCE RECORD **/
//	public boolean createRecord(Purchase purchase) throws Exception {
//		boolean flag = false;
//		getAutoIncrement(purchase.getCompanyrefid(), purchase.getBranchrefid(), purchase.getLocrefid(),
//				purchase.getLocname());// Boopalan 040419
//		String s = piautoincr.toString();// Boopalan 040419
//		purchase.setPino(s.substring(1, s.length() - 1));// Boopalan 040419
//		try {
//			flag = purchaseRepository.createRecord(purchase);
//		} catch (Exception ex) {
//			logger.error("Exception in (Purchase)Method : createRecord() " + ex);
//		}
//		return flag;
//	}

	/** CREATE PURCHASE INVOICE RECORD **/
	@Transactional
	public boolean createPurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception {
		boolean result = true;
		if (result == true) {
			for (PurchaseInvoice p : purchaseinvoice) {
				p.setPaflag(0);
				Integer batchid = purcprorepo.getbatchid(p.getCompanyrefid(), p.getDrugproductrefid(), p.getBatchid());
				System.out.println("::::::::::::::::::::::::FOREACH" + batchid);
				if (batchid != null) {
					System.out.println("if_Condition::::" + batchid);
					p.setBatchno(batchid);
				} else {
					System.out.println(":::::::::::::::" + "Else" + batchid);
					System.out.println("::::::::::::::::::::::::::::::::::COmpanyid" + p.getCompanyrefid()
							+ p.getDrugproductrefid() + p.getBatchid());
					purcprorepo.insertbatchid(p.getCompanyrefid(), p.getDrugproductrefid(), p.getBatchid());
					// purchaseRepository.insertbatchid(purchaseinvoice.get(0).getCompanyrefid(),purchaseinvoice.get(0).getDrugproductrefid(),purchaseinvoice.get(0).getBatchid());
					System.out.println(
							"::::::::::::::::::::::::::::::::::COmpanyid" + purchaseinvoice.get(0).getCompanyrefid());
					Integer batchidss = purcprorepo.getbatchid(p.getCompanyrefid(), p.getDrugproductrefid(),
							p.getBatchid());
					p.setBatchno(batchidss);
					System.out.println("::::::::::::::::::::ElseCompleted" + batchidss);

				}
				List<Integer> PIID = purchaseRepository.getPIID(p.getCompanyrefid(), p.getBranchrefid(), p.getLocname(),
						p.getLocrefid());
				for (Integer PID : PIID) {
					System.out.println(">>>>>>>>>>>>>>>>.PIID" + PIID);
					p.setPirefid(PID);
				}
				Drug drug = drugrepo.findById(p.getDrugproductrefid()).get();
				// drug = drugrepo.findById(p.getDrugproductrefid()).get();
				drug.setGst(p.getGst());
				drug.setCgst(p.getCgst());
				drug.setSgst(p.getSgst());
				drug.setUtgst(p.getUtgst());
				drug.setIgst(p.getIgst());
				drug.setVat(p.getVat());
				drug.setHsnid(p.getHsnid());
				drugrepo.save(drug);
				if (p.getHsnid()!=null) {
					Optional<Hsncode> hsn = hsnrepo.findById(p.getHsnid());
					if (hsn.isPresent()) {
						hsn.get().setGst(p.getHsngst());
						hsnrepo.save(hsn.get());
					}
				}
	
				// hsn = hsnrepo.findById(p.getDrugproductrefid()).get();
				purcprorepo.save(p);
				Stocks stocks = new Stocks();
				stocks.setDrugproductid(p.getDrugproductrefid());
				stocks.setFormulationid(p.getFormulationid());
				stocks.setDosageid(p.getDosageid());
				stocks.setMrp(Double.valueOf(p.getMrp()));
				stocks.setSellingprice(Double.valueOf(p.getSellingprice()));
				stocks.setUnitprice(Double.valueOf(p.getUnitprice()));
				stocks.setUnitcgst(Double.valueOf(p.getCgst()));
				stocks.setUnitsgst(Double.valueOf(p.getSgst()));
				stocks.setUnitutgst(Double.valueOf(p.getUtgst()));
				stocks.setUnitigst(Double.valueOf(p.getIgst()));
				stocks.setUnitgst(Double.valueOf(p.getGst()));
				stocks.setVat(Double.valueOf(p.getVat()));
				stocks.setBatchname(p.getBatchid());
				stocks.setBatchno(p.getBatchno().toString());
				stocks.setQty(Double.valueOf(p.getTotalquantity()));
				stocks.setBoxperstrip(Double.valueOf(p.getStripperbox()));
				stocks.setStrippertablet(Double.valueOf(p.getQuantityperstrip()));
				stocks.setBoxqty(Double.valueOf(p.getBoxquantity()));
				stocks.setStripqty(0.00);
				stocks.setApprovalqty(0.00);
				stocks.setTabletqty(0.00);
				stocks.setFreeboxqty(Double.valueOf(p.getFreeboxqty()));
				stocks.setFreetabletqty(0.00);
				stocks.setFreetotalqty(Double.valueOf(p.getFreetotalqty()));
				stocks.setCompanyrefid(p.getCompanyrefid());
				stocks.setBranchrefid(p.getBranchrefid());
				stocks.setBatchname("NewBatchname"+p.getId());
				stocks.setLocname(p.getLocname());
				stocks.setLocrefid(p.getLocrefid());
				stocks.setExpirydate(p.getExpirydate());
				stocks.setPackageunit(p.getPackageunit());
				stocks.setPurchinvrefid(p.getPirefid());
				stocks.setPurchaseprice(Double.valueOf(p.getPurprice()));
				stocks.setDamagedestroystatus(0);
				stkrepo.save(stocks);
				Optional<PoProduct> optional = poproductRepository.findByPorefidAndDrugproductrefid(p.getRefpoid(),
						p.getDrugproductrefid());
				if (optional.isPresent()) {
					if (optional.get().getTotalquantity().equalsIgnoreCase(p.getTotalquantity())) {
						p.setPaflag(1);
						purcprorepo.save(p);
					}
				}
				purcprorepo.getupdateflag(p.getCompanyrefid(), p.getBranchrefid(), p.getLocname(), p.getLocrefid(),
						p.getRefpoid(), p.getDrugproductrefid());
				result = true;
			}

		} else {
			result = false;
		}
		return result;

	}

	/** VIEW PURCHASE INVOICE RECORD **/

	public List getViewinvoice(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		// list = null;
		// try {
		// list = purchaseRepository.getViewinvoice(cid, bid, locrefid, locname);
		// } catch (Exception ev) {
		// logger.error("Exception in (Purchase)Method : getViewinvoice() " + ev);
		// }
		return purchaseRepository.getViewinvoice(cid, bid, locrefid, locname);
	}

	/** EDIT PURCHASE INVOICE RECORD **/ // Boopalan 150419

	public List getEditpurchase(Integer id) throws Exception {
		// list = null;
		// try {
		// list = purchaseRepository.getEditpurchase(id);
		// } catch (Exception ep) {
		// logger.error("Exception in (Purchase)Method : getEditpurchase() " + ep);
		// }
		return purchaseRepository.getEditpurchase(id);
	}

	public List getEditpurcMaintance(Integer id) throws Exception {
		// list = null;
		// try {
		// list = purchaseRepository.getEditpurcMaintance(id);
		// } catch (Exception em) {
		// logger.error("Exception in (Purchase)Method : getEditpurcMaintance() " + em);
		// }
		return purchaseRepository.getEditpurcMaintance(id);
	}

	/** UPDATE PURCHASE MAINTENANCE RECORD **/
	public boolean updateRecord(Purchase purchase) throws Exception {
		// try {
		purchaseRepository.save(purchase);
		return true;
		// } catch (Exception e) {
		// e.printStackTrace();
		// logger.error("Exception in Method : getQuantity() " + e);
		// return false;
		// }
	}

//	/** UPDATE PURCHASE MAINTENANCE RECORD **/
//	public boolean updateRecord(Purchase purchase) throws Exception {
//		boolean flag = false;
//		try {
//			flag = purchaseRepository.updateRecord(purchase);
//		} catch (Exception ex) {
//			logger.error("Exception in (Purchase)Method : updateRecord() " + ex);
//		}
//		return flag;
//	}

	public boolean updatePurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception {

		boolean result = true;
		if (result == true) {
			for (PurchaseInvoice p : purchaseinvoice) {
				p.setPaflag(0);
				try {
					System.out.println(p.getCompanyrefid() + " " + p.getBranchrefid() + " " + p.getLocname() + " "
							+ p.getLocrefid() + " " + p.getDrugproductrefid() + " " + p.getBatchid());
					Integer batchid = purcprorepo.getbatchid(p.getCompanyrefid(), p.getDrugproductrefid(),
							p.getBatchid());

					if (batchid != null) {
						System.out.println("if_Condition::::" + batchid);
						p.setBatchno(batchid);
					} else {
						System.out.println(":::::::::::::::" + "Else" + batchid);
						purcprorepo.insertbatchid(p.getCompanyrefid(), p.getDrugproductrefid(), p.getBatchid());
						Integer batchidss = purcprorepo.getbatchid(p.getCompanyrefid(), p.getDrugproductrefid(),
								p.getBatchid());
						p.setBatchno(batchidss);
						System.out.println("::::::::::::::::::::ElseCompleted" + batchid);
					}

//					List<Integer> PIID = purchaseRepository.getPIID(p.getCompanyrefid(), p.getBranchrefid(),
//							p.getLocname(), p.getLocrefid());
//					for (Integer integer : PIID) {
//						System.out.println(">>>>>>>>>>>>>>>>.PIID" + integer);
//						p.setPirefid(integer);
//					}

					purcprorepo.save(p);
					purcprorepo.getupdateflag(p.getCompanyrefid(), p.getBranchrefid(), p.getLocname(), p.getLocrefid(),
							p.getRefpoid(), p.getDrugproductrefid());

					Optional<Stocks> stocks = stkrepo
							.findByPurchinvrefidAndDrugproductidAndCompanyrefidAndLocrefidAndLocname(p.getPirefid(),
									p.getDrugproductrefid(), p.getCompanyrefid(), p.getLocrefid(), p.getLocname());
					if (stocks.isPresent()) {
						stocks.get().setDrugproductid(p.getDrugproductrefid());
						stocks.get().setFormulationid(p.getFormulationid());
						stocks.get().setDosageid(p.getDosageid());
						stocks.get().setMrp(Double.valueOf(p.getMrp()));
						stocks.get().setSellingprice(Double.valueOf(p.getSellingprice()));
						stocks.get().setUnitprice(Double.valueOf(p.getUnitprice()));
						stocks.get().setUnitcgst(Double.valueOf(p.getCgst()));
						stocks.get().setUnitsgst(Double.valueOf(p.getSgst()));
						stocks.get().setUnitutgst(Double.valueOf(p.getUtgst()));
						stocks.get().setUnitigst(Double.valueOf(p.getIgst()));
						stocks.get().setUnitgst(Double.valueOf(p.getGst()));
						stocks.get().setVat(Double.valueOf(p.getVat()));
						stocks.get().setBatchname(p.getBatchid());
						stocks.get().setBatchno(p.getBatchno().toString());
						stocks.get().setQty(Double.valueOf(p.getTotalquantity()));
						stocks.get().setBoxperstrip(Double.valueOf(p.getStripperbox()));
						stocks.get().setStrippertablet(Double.valueOf(p.getQuantityperstrip()));
						stocks.get().setBoxqty(Double.valueOf(p.getBoxquantity()));
						stocks.get().setFreetabletqty(Double.valueOf(p.getFreetabletqty()));
						stocks.get().setFreetotalqty(Double.valueOf(p.getFreetotalqty()));
						stocks.get().setCompanyrefid(p.getCompanyrefid());
						stocks.get().setBranchrefid(p.getBranchrefid());
						stocks.get().setLocname(p.getLocname());
						stocks.get().setLocrefid(p.getLocrefid());
						stocks.get().setExpirydate(p.getExpirydate());
						stocks.get().setPackageunit(p.getPackageunit());
						stocks.get().setPurchinvrefid(p.getPirefid());
						stocks.get().setPurchaseprice(Double.valueOf(p.getPurprice()));
						stkrepo.save(stocks.get());
					}

					/* This code is used when edit purchase add the products. */
//					Drug drug = drugrepo.findById(p.getDrugproductrefid()).get();
//					//drug = drugrepo.findById(p.getDrugproductrefid()).get();
//					drug.setGst(p.getGst());
//					drug.setCgst(p.getCgst());
//					drug.setSgst(p.getSgst());
//					drug.setUtgst(p.getUtgst());
//					drug.setIgst(p.getIgst());
//					drug.setVat(p.getVat());
//					drug.setHsnid(p.getHsnid());
//					drugrepo.save(drug);
//					Hsncode hsn = hsnrepo.findById(p.getHsnid()).get();
//					if(hsn == null) {
//						System.out.println("Hsn null");
//					}else {
//						hsn.setGst(p.getHsngst());
//						hsnrepo.save(hsn);
//					}
					result = true;
				}

				catch (Exception e) {
					// logger.error("Exception in Method : getQuantity() " + e);
					// return false;
					throw new Exception(e);
				}

			}
		} else {
			result = false;
		}
		return result;
	}
//	public boolean updatePurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception {
//		boolean flag = false;
//		try {
//			flag = purchaseRepository.updatePurcinvoice(purchaseinvoice);
//		} catch (Exception ex) {
//			logger.error("Exception in (Purchase)Method : updatePurcinvoice() " + ex);
//		}
//		return flag;
//	}

	/** DELETE PURCHASE INVOICE **/
	public void deletePurchaseinvoice(Integer id) throws Exception {
		// try {
		purchaseRepository.deletePurchaseinvoice(id);
		// } catch (Exception ed) {
		// logger.error("Exception in (Purchase)Method : deletePurchaseinvoice() " +
		// ed);
		// }
	}

	public List getPurchaseOrder(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		// list = null;
		// try {
		// list = purchaseRepository.getPurchaseOrder(cid, bid, locrefid, locname);
		// } catch (Exception El) {
		// logger.error("Exception in Method : getPurchaseOrder() " + El);
		// }
		return purchaseRepository.getPurchaseOrder(cid, bid, locrefid, locname);
	}

	public List getPurchaseOrdertable(Integer pid) throws Exception {
		// list = null;
		// try {
		// list = purchaseRepository.getPurchaseOrdertable(pid);
		// } catch (Exception Ep) {
		// logger.error("Exception in Method : getPurchaseOrdertable() " + Ep);
		// }
		return purchaseRepository.getPurchaseOrdertable(pid);
	}

	public List chechTaxmaster(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		list = null;
		try {
			if (locname == 1) {// Shop
				list = purchaseRepository.chechshopTaxmaster(cid, bid, locrefid);
			}
			if (locname == 2) {// Warehouse
				list = purchaseRepository.chechwareTaxmaster(cid, bid, locrefid);
			}
			if (locname == 3) {// Hosp
				list = purchaseRepository.chechhospTaxmaster(cid, bid, locrefid);
			}
		} catch (Exception ex) {
			logger.error("Exception in Method : chechTaxmaster() " + ex);
			throw new Exception(ex);
		}
		return list;
	}

	public void getAutoIncrement(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {
		List val = null;
		try {
			String value = "CALL medil.pro_piautoincrement(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "purchaseinvoice");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locrefid);
			query.setParameter(5, locname);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}
		piautoincr = val;
	}

	public List getdist(Integer pid) throws Exception {
		// List list = null;
		// try {
		// list = purchaseRepository.getdistrepo(pid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : getdist() " + e);
		// }
		return purchaseRepository.getdistrepo(pid);
	}

	/** PURCHASE INVOICE LIST **/ // Boopalan 090419
	public List getPurchaseInvoiceList(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		// list = null;
		// try {
		// list = purchaseRepository.getPurchaseInvoiceList(cid, bid, locname,
		// locrefid);
		// } catch (Exception El) {
		// logger.error("Exception in Method : getPurchaseInvoiceList() " + El);
		// }
		return purchaseRepository.getPurchaseInvoiceList(cid, bid, locname, locrefid);
	}

	/** GET EDIT POID PURCHASE INVOICE **/ // Boopalan 230519
	public List getpoidpi(Integer piid) throws Exception {
		// list = null;
		// Integer[][] s = { { 0, 0 } };
		// List s1 = Arrays.asList(s);
		// try {
		// list = purchaseRepository.getpoidpi(piid);
		// } catch (Exception El) {
		// logger.error("Exception in Method : getPurchaseInvoiceList() " + El);
		// }
		/*
		 * if (list.isEmpty()) { return s1; }
		 */
		return purchaseRepository.getpoidpi(piid);
	}

	public int savePIJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		if (jrnl.getId() == 0) {
			System.out.println(jrnl.getLocname() + "++" + jrnl.getLocrefid());
			Double incid = PjournalRepo.viewPurJrnlId(jrnl.getLocname(), jrnl.getLocrefid());

			System.out.println(incid + "  sdadsas   ");
			String incno = PjournalRepo.viewPurJrnlIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);
			System.out.println(incid + "     " + incno);
			if (incno == null) {
				incno = "0";
			}

			int sid = purchaseRepository.viewPurchaseInvoiceId(jrnl.getLocname(), jrnl.getLocrefid());
			String invname = purchaseRepository.viewPurchaseInvoiceMaxNo(jrnl.getLocname(), jrnl.getLocrefid());
			String personame = purchaseRepository.viewCustName(jrnl.getPersonid());
			System.out.println(sid + " " + invname + " " + personame);
			// StringBuilder incr = new StringBuilder(
			// AutoIncrement.getIncrement01(incno));

			// incr.insert(0, "SLS/JRNL");

			StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("PI/JRNL/",
					jrnl.getLocname().toString(), jrnl.getLocrefid().toString(), incno));
			jrnl.setPersoname(personame);

			jrnl.setInvoicename(invname);
			// jrnl.setCreditamount(jrnl.getDebitamount());
			jrnl.setInvoiceno(sid);
			jrnl.setJournalno(incr.toString());
			PjournalRepo.save(jrnl);

			saveflag = 1;
		} else {
			PjournalRepo.save(jrnl);
		}

		return saveflag;
	}

	public List getdistdc(Integer cmpid, Integer brnchid, Integer lname, Integer lrefid, Integer poid)
			throws Exception {
		return purchaseRepository.getdistdc(cmpid, brnchid, lname, lrefid, poid);
	}

	public List getdcproducts(Integer cmpid, Integer brnchid, Integer lname, Integer lrefid, Integer poid,
			Integer dcrefid) throws Exception {
		return purchaseRepository.getdcproducts(poid, dcrefid);
	}

	public Journal getPurjournal(Integer cmpid, Integer brnchid, Double lname, Double lrefid, Integer invoiceno)
			throws Exception {
		return PjournalRepo.findByCompanyrefidAndBranchrefidAndLocnameAndLocrefidAndInvoicenoAndJrnltype(cmpid, brnchid,
				lname, lrefid, invoiceno, 2);
	}

	public List getHsncodelist() {
		return purchaseRepository.getHsncodelist();
	}
}