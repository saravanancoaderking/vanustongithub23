package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.StockTransfer;
import com.medeil.domain.StockTrnfrProd;
import com.medeil.repository.GenJrnlRepository;
import com.medeil.repository.StkTfrProdRepository;
import com.medeil.repository.StkTransRepository;
import com.medeil.util.AutoIncrement;

@Transactional
@Service
public class StkTrnsfrService {

	private StkTransRepository stktrnsrepo;

	private StkTfrProdRepository stktrnsProdrepo;

	private GenJrnlRepository genjournalRepo;

	private final Logger log = LoggerFactory.getLogger(DebitService.class);

	@Autowired
	StkTrnsfrService(StkTfrProdRepository StktrnsProdrepo, StkTransRepository Stktrnsrepo,
			GenJrnlRepository GenjournalRepo) {

		this.stktrnsProdrepo = StktrnsProdrepo;

		this.stktrnsrepo = Stktrnsrepo;
		this.genjournalRepo = GenjournalRepo;

	}

	public int saveStockTransfer(StockTransfer stk) throws Exception {

		int saveflag = 0;
		int incid = stktrnsrepo.viewStkTransId(stk.getLocname(), stk.getLocrefid());

		String incno = stktrnsrepo.viewStkTransIncNo(stk.getLocname(), stk.getLocrefid(), incid);
		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));

		// incr.insert(0, "STK/TRNS");

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("STK/TRNS/", stk.getLocname().toString(),
				stk.getLocrefid().toString(), incno));
		stk.setStktrfno(incr.toString());
		stktrnsrepo.save(stk);

		saveflag = 1;
		return saveflag;
	}

	public int saveStkTrnfrProducts(List<StockTrnfrProd> stk) throws Exception {
		int saveflag = 0;
		StockTrnfrProd stkinc = stk.get(0);

		int transid = stktrnsrepo.viewStkTransId(stkinc.getLocname(), stkinc.getLocrefid());

		for (StockTrnfrProd temp : stk) {
			if (temp.getCalcflag() != 1) {
				temp.setStktrfrefid(transid);

				stktrnsProdrepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductrefid(),
						temp.getBatchrefid(), temp.getTransfertotalqty());
				if (temp.getWaitingtotalqty() == 0) {

					stktrnsProdrepo.updateStkTransFlag(temp.getIndentrefid(), temp.getDrugproductrefid());
				}

				stktrnsProdrepo.save(temp);

			}

		}
		saveflag = 1;
		return saveflag;

	}

	public int saveGenJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		Double incid = genjournalRepo.viewJournalId(jrnl.getLocname(), jrnl.getLocrefid());

		String incno = genjournalRepo.viewJournalIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		int sid = stktrnsrepo.viewStkTransId(jrnl.getLocname(), jrnl.getLocrefid());

		String invname = stktrnsrepo.viewStkTransMaxNo(jrnl.getLocname(), jrnl.getLocrefid());

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));

		// incr.insert(0, "GEN/JRNL");
		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("GEN/JRNL/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));

		jrnl.setInvoicename(invname);
		jrnl.setCreditamount(jrnl.getDebitamount());
		jrnl.setInvoiceno(sid);
		jrnl.setJournalno(incr.toString());
		genjournalRepo.save(jrnl);

		saveflag = 1;
		return saveflag;

	}

	public List viewIndentRequests(IndCompModel loc) throws Exception {

		return stktrnsProdrepo.viewIndentRequests(loc.getLocname(), loc.getLocrefid());
	}

	public List viewIndentProduct(IndCompModel loc) throws Exception {

		return stktrnsProdrepo.viewIndentProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewIndMainstock(IndCompModel loc) throws Exception {

		return stktrnsProdrepo.viewIndMainstock(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());
	}

	public List viewMainstocks(IndCompModel loc) throws Exception {

		return stktrnsProdrepo.viewMainstocks(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewMainstock(IndCompModel loc) throws Exception {

		return stktrnsProdrepo.viewMainstock(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getFrmint2(),
				loc.getCompanyid());
	}

	public List viewStkTrnfrAll(IndCompModel loc) throws Exception {

		return stktrnsProdrepo.viewStkTrnfrAll(loc.getLocname(), loc.getLocrefid());
	}

	public List viewStkTransferNo(IndCompModel loc) throws Exception {

		return stktrnsProdrepo.viewStkTransferNo(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewStkTransfProducts(IndCompModel loc) throws Exception {

		return stktrnsProdrepo.viewStkTransfProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

}
