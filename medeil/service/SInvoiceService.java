package com.medeil.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.Customerloyaltypoints;
import com.medeil.domain.HoldSalesInvoiceProducts;
import com.medeil.domain.Holdsalesinvoice;
import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.PickingListToDispaly;
import com.medeil.domain.SDProducts;
import com.medeil.domain.SalesDummy;
import com.medeil.domain.Stocks;
import com.medeil.repository.CreditRepository;
import com.medeil.repository.CustomerloyaltypointsReposity;
import com.medeil.repository.HoldSalesProductsRepository;
import com.medeil.repository.HoldsalesRepository;
import com.medeil.repository.ReceiptRepository;
import com.medeil.repository.SInvProdRepository;
import com.medeil.repository.SInvoiceRepository;
import com.medeil.repository.SJournalRepository;
import com.medeil.repository.SalesorderRepository;
import com.medeil.repository.StockLogRepository;
import com.medeil.repository.StocksRepository;
import com.medeil.util.AutoIncrement;

@SuppressWarnings("rawtypes")
@Service
public class SInvoiceService {
	List list;
	private final SInvoiceRepository sinvrepo;

	private final SInvProdRepository sinvprodrepo;

	private final HoldsalesRepository holdsirepo;

	private final HoldSalesProductsRepository holdsiprodrepo;

	private final SJournalRepository sjournalRepo;

	private final ReceiptRepository receiptRepo;

	private final SalesorderRepository sorepo;

	private PickingListToDispaly pickingListToDispaly;

	private CustomerloyaltypointsReposity customerloyaltypointsReposity;

	private final StocksRepository stocksRepository;

	@Autowired
	private StockLogRepository stockLogRepo;

	private final CreditRepository creditrepo;
	@PersistenceContext
	private EntityManager manager;

	@PersistenceContext
	EntityManager em;

	Query query;

	private final Logger log = LoggerFactory.getLogger(SInvoiceService.class);

	@Autowired
	SInvoiceService(SInvoiceRepository Sinvrepo, SInvProdRepository Sinvprodrepo, SJournalRepository SjournalRepo,
			CreditRepository creditrepo, ReceiptRepository ReceiptRepo, SalesorderRepository Sorepo,
			CustomerloyaltypointsReposity customerloyaltypointsReposity, StocksRepository stockLogRepository,
			HoldsalesRepository holdsirepo, HoldSalesProductsRepository holdsiprodrepo) {

		this.sinvrepo = Sinvrepo;

		this.sinvprodrepo = Sinvprodrepo;

		this.sjournalRepo = SjournalRepo;

		this.receiptRepo = ReceiptRepo;

		this.sorepo = Sorepo;

		this.creditrepo = creditrepo;

		this.holdsirepo = holdsirepo;

		this.holdsiprodrepo = holdsiprodrepo;
		this.customerloyaltypointsReposity = customerloyaltypointsReposity;
		this.stocksRepository = stockLogRepository;
	}

	/*
	 * public int saveSalesInvoice(SalesDummy si) { String
	 * medc_salesordertrack_statusdate = si.getClientcdate(); int saveflag = 0;
	 * 
	 * 
	 * Integer incid = sinvrepo.viewSalesInvoiceId(si.getLocname(),
	 * si.getLocrefid());
	 * 
	 * String incno = sinvrepo.viewSalesInvoiceIncNo(si.getLocname(),
	 * si.getLocrefid(), incid);
	 * 
	 * if (incno == null) {
	 * 
	 * incno = "0"; }
	 * 
	 * StringBuilder incr = new
	 * StringBuilder(AutoIncrement.getIncrement03("SLS/INV/",
	 * si.getLocname().toString(), si.getLocrefid().toString(), incno));
	 * 
	 * si.setSalesbilltype("1"); si.setSalesbillno(incr.toString());
	 * 
	 * if (si.getPerfomaflag() == 2) {
	 * 
	 * sinvrepo.updatePerfomaFlag(si.getLocname(), si.getLocrefid(), si.getId());
	 * 
	 * si.setId(0); }
	 * 
	 * sinvrepo.save(si); sorepo.updatestatus(si.getCompanyrefid(),
	 * si.getBranchrefid(), si.getLocname(), si.getLocrefid(),
	 * si.getSalesorderrefid());
	 * sinvrepo.updateSalesOrderFlag(si.getSalesorderrefid());
	 * sinvrepo.save_medc_salesordertrack(si.getSalesorderrefid(), 2,
	 * medc_salesordertrack_statusdate); if (si.getRefillcust() == 1) {
	 * sinvrepo.updatecus(si.getCompanyrefid(), si.getBranchrefid(),
	 * si.getLocname(), si.getLocrefid()); } // if(si.getRefillcust().equal(null)) {
	 * // si.setRefillcust(0); // } // Boopalan 200919 - For saving data //
	 * medc_status.medc_salesordertrack saveflag = 1; return saveflag;
	 * 
	 * }
	 */

	/*
	 * old public int saveSalesInvoice(SalesDummy si) { String
	 * medc_salesordertrack_statusdate = si.getClientcdate(); int saveflag = 0;
	 * Integer incid = sinvrepo.viewSalesInvoiceId(si.getLocname(),
	 * si.getLocrefid()); String incno =
	 * sinvrepo.viewSalesInvoiceIncNo(si.getLocname(), si.getLocrefid(), incid); if
	 * (incno == null) { incno = "0"; } StringBuilder incr = new
	 * StringBuilder(AutoIncrement.getIncrement03("SLS/INV/",
	 * si.getLocname().toString(), si.getLocrefid().toString(), incno));
	 * 
	 * si.setSalesbilltype("1"); si.setSalesbillno(incr.toString());
	 * 
	 * if (si.getPerfomaflag() == 2) {
	 * 
	 * sinvrepo.updatePerfomaFlag(si.getLocname(), si.getLocrefid(), si.getId());
	 * 
	 * si.setId(0); }
	 * 
	 * sinvrepo.save(si); sorepo.updatestatus(si.getCompanyrefid(),
	 * si.getBranchrefid(), si.getLocname(), si.getLocrefid(),
	 * si.getSalesorderrefid());
	 * sinvrepo.updateSalesOrderFlag(si.getSalesorderrefid());
	 * sinvrepo.save_medc_salesordertrack(si.getSalesorderrefid(), 2,
	 * medc_salesordertrack_statusdate); if (si.getRefillcust() == 1) {
	 * sinvrepo.updatecus(si.getCompanyrefid(), si.getBranchrefid(),
	 * si.getLocname(), si.getLocrefid()); } // if(si.getRefillcust().equal(null)) {
	 * // si.setRefillcust(0); // } // Boopalan 200919 - For saving data //
	 * medc_status.medc_salesordertrack saveflag = 1; return saveflag;
	 * 
	 * }
	 */

	public List saveSIProduct(List<SDProducts> si) throws Exception {

		int saveflag = 0;
		List returndata = new ArrayList();
		SDProducts sinc = si.get(0);

		int sid = sinvrepo.viewSalesInvoiceId(sinc.getLocname(), sinc.getLocrefid());
		for (SDProducts temp : si) {

			if (temp.getCalcflag() != 1) {

				if (temp.getPerfomaflag() == 2) {

					temp.setId(0);
				} else {

					sinvrepo.updateMainstockForSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
							temp.getBatchrefid(), temp.getTotalqty());
					sinvrepo.saveStockLogs(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
							temp.getBatchrefid(), sid);
				}

				temp.setSalesrefid(sid);

				sinvprodrepo.save(temp);
				sinvrepo.updatesalesorderflag(temp.getLocname(), temp.getLocrefid(), temp.getSalesorderrefid(),
						temp.getDrugproductid());

			}
		}

		saveflag = 1;

		returndata.add(saveflag);
		returndata.add(sid);
		System.out.println("out" + returndata);
		return returndata;

	}

	public int saveSalesJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		Double incid = sjournalRepo.viewSjournalId(jrnl.getLocname(), jrnl.getLocrefid());
		String incno = sjournalRepo.viewSjournalIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);
		if (incno == null) {
			incno = "0";
		}

		int sid = sinvrepo.viewSalesInvoiceId(jrnl.getLocname(), jrnl.getLocrefid());
		String invname = sinvrepo.viewSalesInvoiceMaxNo(jrnl.getLocname(), jrnl.getLocrefid());
		String personame = sinvrepo.viewCustName(jrnl.getPersonid());

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("SLS/JRNL/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));
		System.out.print("SLS Journal:" + incr + "--" + sid + "--" + invname + "---" + personame);
		jrnl.setPersoname(personame);
		jrnl.setInvoicename(invname);
		// jrnl.setCreditamount(jrnl.getDebitamount());
		jrnl.setInvoiceno(sid);
		jrnl.setJournalno(incr.toString());
		sjournalRepo.save(jrnl);
		saveflag = 1;
		return saveflag;

	}

	public int saveReceipt(Journal jrnl) throws Exception {
		int saveflag = 0;
		Double incid = receiptRepo.viewReceiptId(jrnl.getLocname(), jrnl.getLocrefid());
		String incno = receiptRepo.viewReceiptIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);
		String personame = sinvrepo.viewCustName(jrnl.getPersonid());
		if (incno == null) {
			incno = "0";
		}
		int sid = sinvrepo.viewSalesInvoiceId(jrnl.getLocname(), jrnl.getLocrefid());
		String invname = sinvrepo.viewSalesInvoiceMaxNo(jrnl.getLocname(), jrnl.getLocrefid());

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));

		// incr.insert(0, "RT/JRNL");
		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("RT/JRNL/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));
		jrnl.setPersoname(personame);
		jrnl.setInvoicename(invname);
		// jrnl.setCreditamount(jrnl.getDebitamount());
		jrnl.setInvoiceno(sid);
		jrnl.setJournalno(incr.toString());

		receiptRepo.save(jrnl);

		saveflag = 1;
		return saveflag;
	}

	// Update SI Receipt
	public int UpdatePaySIReceipt(List<Journal> jrnl) {
		int saveflag = 0;
		for (Journal journal : jrnl) {
			Double incid = receiptRepo.viewReceiptId(journal.getLocname(), journal.getLocrefid());
			String incno = receiptRepo.viewReceiptIncNo(journal.getLocname(), journal.getLocrefid(), incid);
			String personame = sinvrepo.viewCustName(journal.getPersonid());
			if (incno == null) {
				incno = "0";
			}
			StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("RT/JRNL/",
					journal.getLocname().toString(), journal.getLocrefid().toString(), incno));
			System.out.print("journalno: " + incr + "--" + journal.getId() + "---" + journal.getPersonid());
			Journal journals = receiptRepo.findById(journal.getId()).get();
			journals.setInvoicebalamt(0.00);
			// journals.setInvoicebalamt(journal.getInvoicebalamt());
			// journals.setCreditamount((journals.getCreditamount() +
			// journal.getCreditamount()));
			// System.out.print("journalUpdate: " + incr + "--" + journals.getCreditamount()
			// + "---" + journal.getCreditamount());
			receiptRepo.save(journals);
			journal.setId(0);
			journal.setPersoname(personame);
			journal.setJournalno(incr.toString());
			receiptRepo.save(journal);
		}

		saveflag = 1;
		return saveflag;
	}

	public Double saveTempStock(IndCompModel loc) throws Exception {
		int saveflag = 0;

		/*
		 * sinvrepo.updateTempStockMain(loc.getLocname(), loc.getLocrefid(),
		 * loc.getFrmint1(), loc.getFrmint2(), loc.getFrmint3());
		 */

		return sinvrepo.saveTempStock(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getFrmint2(),
				loc.getFrmint3());

	}

	public String savePresImage(MultipartFile file, Integer locrefid, Integer locname, String srcpath)
			throws Exception {
		// String srcpath = "D://files2/customerscustomisation1/cust
		// change1/saimed25/New folder (5)/";
		String path;
		String path1 = null;
		String nameLocName = null;
		String concatString;
		if (locname == 1) {
			nameLocName = "SH_" + locrefid + "_";
		} else if (locname == 2) {
			nameLocName = "WH_" + locrefid + "_";
		} else if (locname == 3) {
			nameLocName = "HO_" + locrefid + "_";
		}

		try {

			byte[] bytes = file.getBytes();

			Integer i = sinvrepo.viewSalesInvoiceId(Double.parseDouble(locrefid + ""),
					Double.parseDouble(locname + ""));

			concatString = (i == null || i == 0) ? file.getOriginalFilename() : i + "_" + file.getOriginalFilename();
			path = srcpath + nameLocName + concatString;
			path1 = nameLocName + concatString;

			File serverFile = new File(path);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

			stream.write(bytes);
			stream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new FileNotFoundException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		return path1;
	}

	public int updateSalesInvoice(SalesDummy si) throws Exception {
		int saveflag = 0;
		sinvrepo.save(si);

		// sinvrepo.updateSalesJouirnal(si.getLocname(), si.getLocrefid(),
		// si.getTotalamount(), si.getId());

		saveflag = 1;
		return saveflag;
	}

	public int updateSIProduct(List<SDProducts> si) throws Exception {
		int saveflag = 0;
		SDProducts snv = si.get(0);

		sinvrepo.updateMainstockEdit(snv.getLocname(), snv.getLocrefid(), snv.getSalesrefid());

		try {
			for (SDProducts temp : si) {
				if (temp.getCalcflag() != 1) {
					if (temp.getDelflag() == true) {
						temp.setStatus(5.0);

					} else {

						temp.setStatus(0.0);
					}

					sinvrepo.updateMainstockForEdit(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
							temp.getBatchrefid(), temp.getTotalqty());

					sinvrepo.saveStockLogs(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
							temp.getBatchrefid(), temp.getSalesrefid());
					// temp.setSalesrefid(snv.getSalesrefid());

					sinvprodrepo.save(temp);

				}
			}
			saveflag = 1;

		} catch (Exception e) {
			System.out.println("tyty" + e.getMessage());
			throw new Exception(e);

		}

		return saveflag;

	}

	public Double updateTempStockMain(IndCompModel loc) throws Exception {
		return sinvrepo.updateTempStockMain(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getFrmint2(),
				loc.getFrmint1());

	}

	public List viewCustomers(IndCompModel loc) throws Exception {
		List dcid = this.getindex(loc.getLocname(), loc.getLocrefid(), loc.getSearchvalue());
		return dcid;

	}

	@Transactional
	public List getindex(int locname, int locrefid, String searchvalue) throws Exception {
		List ls = null;
		try {
			String q = "Call medc_sales.medc_socustomer(?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, locname);
			query.setParameter(2, locrefid);
			query.setParameter(3, searchvalue);
			ls = query.getResultList();
			System.out.println("SutoIncrement  :" + ls);
		} catch (Exception e) {
			System.out.println("getAutoincrements  :" + e);
			throw new Exception(e);
		}

		return ls;
	}

	public List viewsoCustomers(IndCompModel loc) throws Exception {
		return sinvrepo.viewsoCustomers(loc.getLocname(), loc.getLocrefid());
	}

	public List viewallcustomer(IndCompModel loc) throws Exception {
		return sinvrepo.viewallcustomer(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(), loc.getLocrefid(),
				loc.getSearchvalue());
	}

	public List viewDoctors(IndCompModel loc) throws Exception {
		return sinvrepo.viewDoctors(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(), loc.getLocrefid());
	}

	public List viewSalesOrderCustomer(IndCompModel loc) throws Exception {
		return sinvrepo.viewSalesOrderCustomer(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid(), loc.getSearchvalue());
	}

	public List viewSalesOrderProd(IndCompModel loc) throws Exception {
		return sinvrepo.viewSalesOrderProd(loc.getLocname(), loc.getLocrefid(), loc.getSorderid());
	}

	public List viewRefillProd(IndCompModel loc) throws Exception {
		return sinvrepo.viewRefillProd(loc.getLocname(), loc.getLocrefid(), loc.getSorderid());
	}

	public List viewSalesInvoiceAll(Integer cid, Integer bid, Integer lname, Integer lrid) {
		return sinvrepo.viewSalesInvoiceAll(cid, bid, lname, lrid);
	}

	public Page viewPagingSalesInvoiceAll(Integer cid, Integer bid, Integer lname, Integer lrid, Integer pageno,
			Integer size) throws Exception {

		Page page = null;
		try {

			Pageable paging = PageRequest.of(pageno, size);
			page = sinvrepo.viewPagingSalesInvoiceAll(lname, lrid, paging);
			System.out.println(page.getTotalPages());
		} catch (Exception ex) {
			log.error("Exception in Method : domainList() : " + ex);
			throw new Exception(ex);
		}

		return page;

	}

	/** Raja **/
	/** DELETE SALES INVOICE **/
	public boolean sinvoiceService(Integer id) throws Exception {
		boolean flag = false;
		try {
			List<Object[]> list = sinvrepo.getproductandbatch(id);
			for (Object[] productid : list) {
				Integer drugproductid = Integer.valueOf(String.valueOf(productid[0]));
				String batchid = String.valueOf(productid[1]);
				Double qty = Double.valueOf(String.valueOf(productid[2]));
				Integer compid = Integer.valueOf(String.valueOf(productid[3]));
				Integer locrefid = Integer.valueOf(String.valueOf(productid[4]));
				Stocks stocks = stocksRepository.findByDrugproductidAndBatchnoAndCompanyrefidAndLocrefid(drugproductid,
						batchid, compid, locrefid);
				Double qtyadd = (double) (stocks.getQty() + qty);
				stocks.setQty(qtyadd);
				stocksRepository.save(stocks);
				flag = true;
			}
			sinvrepo.deleteslinvoice(id);
		} catch (Exception ed) {
			log.error("Exception in (Purchase)Method : deletePurchaseinvoice() " + ed);
			throw new Exception(ed);
		}
		return flag;
	}

	public List viewSalesInvoice(IndCompModel loc) throws Exception {
		return sinvrepo.viewSalesInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewSIProducts(IndCompModel loc) throws Exception {
		return sinvprodrepo.viewSIProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List GetSIProducts(IndCompModel loc) {
		return sinvprodrepo.GetSIProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewProductNames(IndCompModel loc) throws Exception {
		List drugname = null;
		// try {
		if (loc.getSearchid() == 1) {
			return sinvrepo.viewProductNames(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(),
					loc.getLocrefid(), loc.getSearchvalue());
		} else if (loc.getSearchid() == 2) {
			return sinvrepo.viewGenericNames(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(),
					loc.getLocrefid(), loc.getSearchvalue());
		}
		// } catch (Exception ed) {
		// log.error("Exception in (viewProductNames)Method : viewProductNames() " +
		// ed);
		// }
		return drugname;
	}

	public List viewPdtNamesGeneric(IndCompModel loc) throws Exception {
		return sinvrepo.viewPdtNamesGeneric(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	// Puthiran Product name view barcode base
	public List viewProductNamesBarcode(IndCompModel loc) throws Exception {
		// List drugname = null;
		// try {
		return sinvrepo.viewBarcodeNames(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(), loc.getLocrefid(),
				loc.getSearchvalue());
		// } catch (Exception ed) {
		// log.error("Exception in (viewProductNames)Method : viewProductNames() " +
		// ed);
		// }
		// return drugname;
	}

	public List viewProductName(IndCompModel loc) throws Exception {
		return sinvrepo.viewProductName(loc.getLocname(), loc.getLocrefid(), loc.getProductid(), loc.getBatchid());
	}

	public List viewBarCodeProd(IndCompModel loc) throws Exception {
		return sinvrepo.viewBarCodeProd(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewPriceSettings(IndCompModel loc) throws Exception {
		return sinvrepo.viewPriceSettings(loc.getLocname(), loc.getLocrefid());
	}

	public List viewDiscountSettings(IndCompModel loc) throws Exception {
		return sinvrepo.viewDiscountSettings(loc.getLocname(), loc.getLocrefid());

	}

	public List viewTaxSettings(IndCompModel loc) throws Exception {
		return sinvrepo.viewTaxSettings(loc.getLocname(), loc.getLocrefid());
	}

	public List viewSalesInvCustAll(IndCompModel loc) throws Exception {
		return sinvrepo.viewSalesInvCustAll(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewSalesDumCustAll(IndCompModel loc) throws Exception {
		return sinvrepo.viewSalesDumCustAll(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewProductNameDrug(IndCompModel loc) throws Exception {
		return sinvrepo.viewProductNameDrug(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyid());
	}

	public List viewCustOutstandingTot(IndCompModel loc) throws Exception {
		return sinvrepo.viewCustOutstandingTot(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewScheme(IndCompModel loc) throws Exception {
		return sinvrepo.viewScheme(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());

	}

	public Double viewCustAmt(IndCompModel loc) throws Exception {
		String startdate = sinvrepo.viewSchemeStartDate(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
		return sinvrepo.viewCustAmt(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), startdate);

	}

	public StringBuilder viewCustInvoiceNo(IndCompModel loc) throws Exception {

		Integer incid = sinvrepo.viewSalesInvoiceId((double) loc.getLocname(), (double) loc.getLocrefid());

		String incno = sinvrepo.viewSalesInvoiceIncNo((double) loc.getLocname(), (double) loc.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}
		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));

		// incr.insert(0, "SLS/INV");
		StringBuilder incr = new StringBuilder(
				AutoIncrement.getIncrement03("SLS/INV/", loc.getLocname() + "", loc.getLocrefid() + "", incno));

		return incr;

	}

	public int deleteSalesInvoice(IndCompModel loc) throws Exception {
		int saveflag = 0;
		sinvrepo.deleteSalesInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

	/** SALES INVOICE LIST **/
	// Boopalan 090419
	public List getSalesInvoiceList(IndCompModel loc) throws Exception {
		// list = null;
		// try {
		return sinvrepo.getSalesInvoiceList(loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid());
//			System.out.println(loc.getCompanyrefid() + " " + loc.getBranchrefid() + " " + loc.getLocname() + " "
//					+ loc.getLocrefid());
//		} catch (Exception El) {
//			log.error("Exception in Method : getPurchaseInvoiceList() " + El);
//		}
//		return list;
	}

	public List viewcustsono(IndCompModel loc) throws Exception {
		return sinvrepo.viewcustsono(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(), loc.getLocrefid(),
				loc.getPatientid());
	}

	public List viewAllSalesorders(IndCompModel loc) throws Exception {
		return sinvrepo.viewAllSalesorders(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid());
	}

	public List SaveSalesInvoice(SalesDummy si) throws Exception {
		String medc_salesordertrack_statusdate = si.getClientcdate();
		int saveflag = 0;

		List returndata = new ArrayList();

		Integer lastid = sinvrepo.lastbillid(si.getLocrefid().intValue());
		lastid = lastid + 1;
		String sidvalue = "SIV";
		String newidvalue = String.format("%010d", lastid);
		String sid = sidvalue + newidvalue;
		si.setSalesbillno(sid);
		System.out.println("inside service1" + sid);

		List txnno = this.gettxnAutoincrement(si.getCompanyrefid(), si.getBranchrefid(), si.getLocname(),
				si.getLocrefid(), si.getBilldate());
		System.out.println("txn0" + txnno);
		String txn = (String) txnno.get(0);
		System.out.println("txn" + txn);
		// String txn = txnno.get(0).toString();
		si.setTxnno(txn);

		sinvrepo.save(si);
		System.out.println("inside service3");
		// MainTable UpdateWork
		System.out.println("salesrefid" + si.getSalesorderrefid());
		sorepo.updatestatus(si.getCompanyrefid(), si.getBranchrefid(), si.getLocname(), si.getLocrefid(),
				si.getSalesorderrefid());

		sinvrepo.updateSalesOrderFlag(si.getSalesorderrefid());
		sinvrepo.save_medc_salesordertrack(si.getSalesorderrefid(), 2, medc_salesordertrack_statusdate);
		System.out.println("inside2" + si.getSalesorderrefid());
//		if (si.getRefillcust() == 1) {
		System.out.println("refillcust" + si.getRefillcust());
		sinvrepo.updatecus(si.getCompanyrefid(), si.getBranchrefid(), si.getLocname(), si.getLocrefid(),
				si.getPreviousbalance(), si.getCustomerrefid(), si.getRefillcust(), si.getRefilldays(),
				si.getCustomertype());
//		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++Star");
		boolean patientid = customerloyaltypointsReposity.existsByCustrefid(si.getCustomerrefid().intValue());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + patientid);
		Customerloyaltypoints customerloyaltypoints = new Customerloyaltypoints();
		if (patientid == true) {
			System.out.println("______________________________________True");
			Customerloyaltypoints patientid1 = customerloyaltypointsReposity
					.findByCustrefid(si.getCustomerrefid().intValue());
			System.out.println("++++++++++++++++++++++++++++++++" + patientid1.getCustrefid() + "---" + "_____"
					+ (patientid1.getTotalpurchaseprice() + si.getGrandtotal().intValue()));
			patientid1.setLoyalitypointrefid(si.getLoyalitypointrefid());
			patientid1.setCurrentprice(si.getGrandtotal().intValue());
			patientid1.setCurrentloyalpoints(si.getCurrentloyalpoints());
			patientid1.setTotalpurchaseprice((patientid1.getTotalpurchaseprice() + si.getGrandtotal().intValue()));
			patientid1.setAvailloyalpoints(((si.getCurrentloyalpoints() + patientid1.getAvailloyalpoints())
					- (si.getCurrentuseloyalpoints())));
			patientid1.setTotalloyalpoints((si.getCurrentloyalpoints() + patientid1.getTotalloyalpoints()));
			System.out
					.println("______________________________________Truecal"
							+ ((si.getCurrentloyalpoints() + patientid1.getTotalloyalpoints())
									- (si.getCurrentuseloyalpoints()))
							+ "__________" + patientid1.getTotalloyalpoints());
			patientid1.setCompanyrefid(si.getCompanyrefid());
			patientid1.setBranchrefid(si.getBranchrefid());
			patientid1.setLocname(si.getLocname().intValue());
			patientid1.setLocrefid(si.getLocrefid().intValue());
			patientid1.setStatus(0);
			customerloyaltypointsReposity.save(patientid1);
		} else {
			System.out.println("______________________________________fales");
			customerloyaltypoints.setLoyalitypointrefid(si.getLoyalitypointrefid());
			customerloyaltypoints.setCustrefid(si.getCustomerrefid().intValue());
			customerloyaltypoints.setCurrentprice(si.getGrandtotal().intValue());
			customerloyaltypoints.setCurrentloyalpoints(si.getCurrentloyalpoints());
			customerloyaltypoints.setTotalpurchaseprice(si.getGrandtotal().intValue());
			customerloyaltypoints.setTotalloyalpoints(si.getCurrentloyalpoints());
			customerloyaltypoints.setAvailloyalpoints(si.getCurrentloyalpoints());
			customerloyaltypoints.setCompanyrefid(si.getCompanyrefid());
			customerloyaltypoints.setBranchrefid(si.getBranchrefid());
			customerloyaltypoints.setLocname(si.getLocname().intValue());
			customerloyaltypoints.setLocrefid(si.getLocrefid().intValue());
			customerloyaltypoints.setStatus(0);
			customerloyaltypointsReposity.save(customerloyaltypoints);
		}
		System.out.println("inside3" + si.getSalesorderrefid());
		// ProducTtable UpdateWork
		System.out.println(si.getsDProducts().size());
		for (int i = 0; i < si.getsDProducts().size(); i++) {

			System.out.println(" " + si.getsDProducts().get(i).getIndvqty());
			sinvrepo.updateMainstockForSave(si.getsDProducts().get(i).getLocname(),
					si.getsDProducts().get(i).getLocrefid(), si.getsDProducts().get(i).getDrugproductid(),
					si.getsDProducts().get(i).getBatchrefid(), si.getsDProducts().get(i).getIndvqty());
			sinvrepo.saveStockLogs(si.getsDProducts().get(i).getLocname(), si.getsDProducts().get(i).getLocrefid(),
					si.getsDProducts().get(i).getDrugproductid(), si.getsDProducts().get(i).getBatchrefid(),
					si.getId());

			sinvrepo.updatesalesorderflag(si.getsDProducts().get(i).getLocname(),
					si.getsDProducts().get(i).getLocrefid(), si.getsDProducts().get(i).getSalesorderrefid(),
					si.getsDProducts().get(i).getDrugproductid());
		}
		// saveflag = 1;
		// return saveflag;

		saveflag = 1;
		returndata.add(saveflag);
		returndata.add(si.getId());
		returndata.add(si.getSalesbillno());
		System.out.println("out" + returndata);
		return returndata;

	}

	@Transactional
	public List getSalesAutoincrement(Integer compid, Integer branchid, Double locname, Double locrefid)
			throws Exception {
		List ls = null;
		String a1 = "sinvoice";

		try {
			String q = "Call medc_sales.pro_siautoincrement(?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, a1);
			query.setParameter(2, compid);
			query.setParameter(3, branchid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);

			ls = query.getResultList();
			System.out.println("SutoIncrement  :" + ls);
		} catch (Exception e) {
			System.out.println("getAutoincrements  :" + e);
			throw new Exception(e);
		}

		return ls;
	}

	@Transactional
	public List gettxnAutoincrement(Integer compid, Integer branchid, Double locname, Double locrefid, String billdate)
			throws Exception {

		List ls = null;
		String a1 = "txnno";
		System.out.println("inside");

		try {

			String q = "Call medc_sales.pro_txnincreament(?,?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, a1);
			query.setParameter(2, compid);
			query.setParameter(3, branchid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			query.setParameter(6, billdate);

			ls = query.getResultList();
			System.out.println("SutoIncrement  :" + ls);
		} catch (Exception e) {
			System.out.println("getAutoincrements  :" + e);
			throw new Exception(e);
		}

		return ls;
	}

	public List getparticularcustomer(IndCompModel loc) throws Exception {
		return sinvrepo.getparticularcustomer(loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid(), loc.getPatientid());

	}

	public List soparticularcustomer(IndCompModel loc) throws Exception {
		return sinvrepo.getparticularcustomer(loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid(), loc.getPatientid());

	}

	public List viewsocustomerlist(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer soid)
			throws Exception {
		return sinvrepo.viewsocustomerlist(cid, bid, locname, locrefid, soid);
	}

	// Credit Note
	public int saveCreditNote(Journal jrnl) throws Exception {
		int saveflag = 0;
		Double incid = creditrepo.viewCreditNoteId(jrnl.getLocname(), jrnl.getLocrefid(), jrnl.getCompanyrefid(),
				jrnl.getBranchrefid());

		String incno = creditrepo.viewCreditNoteIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		String invname = sinvrepo.viewSInvMaxNo(jrnl.getCompanyrefid(), jrnl.getLocname(), jrnl.getLocrefid(),
				jrnl.getInvoiceno());
		System.out.println("invname" + invname);

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("CR/NOTE/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));

		jrnl.setInvoicename(invname);
		System.out.println("jrnl" + jrnl.getInvoiceno());

		jrnl.setJournalno(incr.toString());
		creditrepo.save(jrnl);

		saveflag = 1;
		return saveflag;

	}

	public List GetPendingPaymentsList(IndCompModel loc) throws Exception {

		return sinvrepo.GetPendingPaymentsList(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public Boolean UpdateCustBalance(IndCompModel loc) throws Exception {
		Double prevbal = sinvrepo.getcustpreviousbal(loc.getFrmint1());
		System.out.print("PRevbal: " + prevbal);
		double balance = prevbal - loc.getFrmdbl1();
		System.out.print("Update Bal: " + balance);
		sinvrepo.UpdateCustBalance(loc.getFrmint1(), balance);
		return true;
	}

	public List GetSReturnPaymentsList(Integer compid, Integer custid) throws Exception {
		return sinvrepo.GetSReturnPaymentsList(compid, custid);
	}

	// puthiran hold sales invoice
	public boolean holssalesinvoice(Holdsalesinvoice holdsi) {
		Integer lastid = holdsirepo.getlastid();
		String compFormat = String.format("%06d", lastid + 1);
		String holdbillno = "HOL" + compFormat;
		holdsi.setSalesbillno(holdbillno);
		// TODO Auto-generated method stub
		holdsirepo.save(holdsi);
		return true;
	}

	// save hold products
	public ResponseEntity<Boolean> holdsalesproducts(List<HoldSalesInvoiceProducts> holdproducts) {
		try {
			Integer lastid = holdsirepo.getlastid();
			for (HoldSalesInvoiceProducts holdSalesInvoiceProducts : holdproducts) {
				holdSalesInvoiceProducts.setSalesrefid(lastid);
				holdsiprodrepo.save(holdSalesInvoiceProducts);
			}

			return ResponseEntity.created(null).body(true);
		} catch (DataIntegrityViolationException e) {
			HashMap<String, String> errorMessage = new HashMap<String, String>();
			errorMessage.put("message", e.getRootCause().getMessage());
			return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			HashMap<String, String> errorMessage = new HashMap<String, String>();
			errorMessage.put("message", e.toString());
			return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	public List viewholdbillslist(Integer cid, Integer bid, Integer locname, Integer locrefid) {
		return holdsirepo.viewholdbillslist(cid, bid, locname, locrefid);
	}

	public Holdsalesinvoice getholdbilldetails(Integer id) {
		return holdsirepo.findById(id);
	}

	public List<HoldSalesInvoiceProducts> getholdbillproddetails(Integer id) {
		return holdsiprodrepo.findBySalesrefid(id);
	}

	public List GetSalesInvoicecount(Integer cid, Integer bid, Integer lname, Integer lrid) {
		return sinvrepo.GetSalesInvoicecount(cid, bid, lname, lrid);
	}

	// SIVAKUMAR-- For converting sales order customers
	public List convertsalescustomer(IndCompModel loc) throws Exception {

		return sinvrepo.convertsales(loc.getCompanyid(), loc.getBranchrefid(), loc.getLocname(), loc.getLocrefid(),
				loc.getSalesorderid());
	}

//	SIVAKUMAR- X-Reading Over view

	public List xReadOverView(IndCompModel loc) throws Exception {
		// Map<Object,Object> map=new HashMap<>();

		return sinvrepo.xReadOverView(loc.getBilldate(), loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid());

	}

	// SIVAKUMAR -X-Reading sales bills details

	public List xReadSalesDetails(IndCompModel loc) throws Exception {

		return sinvrepo.xReadSalesDetails(loc.getBilldate(), loc.getCompanyrefid(), loc.getBranchrefid(),
				loc.getLocname(), loc.getLocrefid());

	}

	public List zReadOverView(IndCompModel loc) throws Exception {
		// TODO Auto-generated method stub
		return sinvrepo.zReadOverView(loc.getFromdate(), loc.getTodate(), loc.getCompanyrefid(), loc.getBranchrefid(),
				loc.getLocname(), loc.getLocrefid());
	}

	public List zReadSalesDetails(IndCompModel loc) throws Exception {
		// TODO Auto-generated method stub

		return sinvrepo.zReadSalesDetails(loc.getFromdate(), loc.getTodate(), loc.getCompanyrefid(),
				loc.getBranchrefid(), loc.getLocname(), loc.getLocrefid());

		// return a;
	}

	public ResponseEntity<?> generateLabelDetails(Integer salesinvid) {
		SalesDummy salesinvoice = sinvrepo.findById(salesinvid).get();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(salesinvoice);
	}

	public List viewSalesInvoiceIdBased(Integer cid, Integer bid, Integer lname, Integer lrid,Integer sid) {
		return sinvrepo.viewSalesInvoiceIdBased(cid, bid, lname, lrid,sid);
	}

}
