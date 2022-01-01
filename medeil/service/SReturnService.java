package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.SReturnProd;
import com.medeil.domain.SalesReturn;
import com.medeil.domain.Stocks;
import com.medeil.repository.CreditRepository;
import com.medeil.repository.SRetnProdRepository;
import com.medeil.repository.SReturnRepository;
import com.medeil.repository.StockLogRepository;
import com.medeil.repository.StocksRepository;
import com.medeil.util.AutoIncrement;

@Service
public class SReturnService {

	private final SReturnRepository sretnrepo;

	private final SRetnProdRepository sretnprodrepo;

	private final CreditRepository creditrepo;
	
	private final StocksRepository stocksRepository;

	@Autowired
	private StockLogRepository stockLogRepo;

	private final Logger log = LoggerFactory.getLogger(SReturnService.class);

	@Autowired
	SReturnService(SReturnRepository Sretnrepo, SRetnProdRepository Sretnprodrepo, CreditRepository Creditrepo,
			StocksRepository stockRepository) {

		this.sretnrepo = Sretnrepo;

		this.sretnprodrepo = Sretnprodrepo;

		this.creditrepo = Creditrepo;
		
		this.stocksRepository=stockRepository;

	}

	public int saveSalesReturn(SalesReturn sr) throws Exception {
		int saveflag = 0;
		System.out.println(">>>>>>1" + sr.getLocname());
		int incid = sretnrepo.viewSRetnId(sr.getLocname(), sr.getLocrefid());
		System.out.println(">>>>>>2" + sr.getLocname());
		String incno = sretnrepo.viewSRetnIncNo(sr.getLocname(), sr.getLocrefid(), incid);
		System.out.println(">>>>>>3" + sr.getLocname());
		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "SLS/RET");

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("SLS/RET/", sr.getLocname().toString(),
				sr.getLocrefid().toString(), incno));
		System.out.println(">>>>>>4" + sr.getLocname());
		sr.setSrno(incr.toString());
		sretnrepo.save(sr);
		System.out.println(">>>>>>5" + sr.getLocname());
		saveflag = 1;
		return saveflag;
	}

	public int saveSrProducts(List<SReturnProd> sr) throws Exception {
		int saveflag = 0;
		SReturnProd srinc = sr.get(0);

		int id = sretnrepo.viewSRetnId(srinc.getLocname(), srinc.getLocrefid());
		for (SReturnProd temp : sr) {

			if (temp.getCalcflag() != 1) {
				sretnprodrepo.updateMainstockForSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
						temp.getBatchrefid(), temp.getTotalqty());
				sretnrepo.saveStockLogs(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
						temp.getBatchrefid(), id);

				temp.setSrrefid(id);

				sretnprodrepo.save(temp);
			}

		}
		saveflag = 1;
		return saveflag;
	}

	public int saveCreditNote(Journal jrnl) throws Exception {
		int saveflag = 0;
		Double incid = creditrepo.viewCreditNoteId(jrnl.getLocname(), jrnl.getLocrefid(), jrnl.getCompanyrefid(),
				jrnl.getBranchrefid());

		String incno = creditrepo.viewCreditNoteIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		int id = sretnrepo.viewSRetnId(jrnl.getLocname(), jrnl.getLocrefid());

		System.out.println("invoiceno" + id);

		String invname = sretnrepo.viewSRetnMaxNo(jrnl.getLocname(), jrnl.getLocrefid());
		String personame = sretnrepo.viewCustName(jrnl.getPersonid());

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "CR/NOTE");
		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("CR/NOTE/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));

		jrnl.setPersoname(personame);
		jrnl.setInvoicename(invname);

		//jrnl.setCreditamount(jrnl.getDebitamount());
		jrnl.setInvoiceno(id);
		System.out.println("jrnl" + jrnl.getInvoiceno());

		jrnl.setJournalno(incr.toString());
		creditrepo.save(jrnl);

		saveflag = 1;
		return saveflag;

	}

	public int updateSalesReturn(SalesReturn sr) throws Exception {
		int saveflag = 0;
		sretnrepo.save(sr);

		// sretnrepo.updateSalesJouirnal(sr.getLocname(), sr.getLocrefid(),
		// sr.getTotalamount(), sr.getId());

		saveflag = 1;
		return saveflag;
	}

	public int updateSrProducts(List<SReturnProd> sr) throws Exception {
		int saveflag = 0;
		SReturnProd srp = sr.get(0);
		sretnprodrepo.updateMainstockEdit(srp.getLocname(), srp.getLocrefid(), srp.getSrrefid());

		for (SReturnProd temp : sr) {

			if (temp.getCalcflag() != 1) {
				if (temp.getDelflag() == true) {
					temp.setStatus(5.0);

				} else {

					temp.setStatus(0.0);
				}

				sretnprodrepo.updateMainstockForEdit(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
						temp.getBatchrefid(), temp.getTotalqty());
				sretnrepo.saveStockLogs(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
						temp.getBatchrefid(), temp.getSrrefid());

				// temp.setSrrefid(srp.getSrrefid());

				sretnprodrepo.save(temp);

			}
		}

		saveflag = 1;
		return saveflag;

	}

	public List viewSalesInvoiceNo(IndCompModel loc) throws Exception {

		return sretnrepo.viewSalesInvoiceNo(loc.getLocname(), loc.getLocrefid());
	}

	public List viewSalesInvoice(IndCompModel loc) throws Exception {

		return sretnrepo.viewSalesInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewSIProduct(IndCompModel loc) throws Exception {

		return sretnrepo.viewSIProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewSalesReturnAll(IndCompModel loc) throws Exception {

		return sretnrepo.viewSalesReturnAll(loc.getLocname(), loc.getLocrefid());
	}

	public List viewSalesReturn(IndCompModel loc) throws Exception {

		return sretnrepo.viewSalesReturn(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}
	
	public List viewSalesReturnProducts(IndCompModel loc) throws Exception {
		return sretnrepo.viewSalesReturnProducts(loc.getFrmint1());
	}

	public List viewSrProduct(IndCompModel loc) throws Exception {

		return sretnrepo.viewSrProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewSrProductRemain(IndCompModel loc) throws Exception {

		return sretnrepo.viewSrProductRemain(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public int deleteSalesRetn(IndCompModel loc) throws Exception {
		int saveflag = 0;
		List<Object[]> list=sretnrepo.getproductandbatch(loc.getFrmint1());
		for (Object[] productid : list) {
			Integer drugproductid=Integer.valueOf(String.valueOf(productid[0]));
			Integer batchid=Integer.valueOf(String.valueOf(productid[1]));
			String qty=String.valueOf(productid[2]);
			Integer compid=Integer.valueOf(String.valueOf(productid[3]));
			Integer locrefid=Integer.valueOf(String.valueOf(productid[4]));
			Stocks stocks=stocksRepository.findByDrugproductidAndBatchnoAndCompanyrefidAndLocrefid(drugproductid,batchid.toString(),compid,locrefid);
			Double qtyadd=(stocks.getQty()+(Double.valueOf(qty)));
			stocks.setQty(qtyadd);
			stocksRepository.save(stocks);			
		}
		sretnrepo.deleteSalesRetn(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		sretnrepo.deleteJournal(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		return saveflag;
	}

}
