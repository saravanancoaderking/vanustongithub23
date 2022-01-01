package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.StockRecProd;
import com.medeil.domain.StockReceive;
import com.medeil.repository.GenJrnlRepository;
import com.medeil.repository.StkRecProdRepository;
import com.medeil.repository.StkRecRepository;
import com.medeil.util.AutoIncrement;

@Service
public class StkReceiveService {

	private final StkRecRepository stkrecrepo;

	private final StkRecProdRepository stkprodrecrepo;

	private GenJrnlRepository genjournalRepo;

	private final Logger log = LoggerFactory.getLogger(StkReceiveService.class);

	@Autowired
	StkReceiveService(StkRecRepository Stkrecrepo, StkRecProdRepository Stkprodrecrepo,
			GenJrnlRepository GenjournalRepo) {

		this.stkrecrepo = Stkrecrepo;

		this.stkprodrecrepo = Stkprodrecrepo;
		this.genjournalRepo = GenjournalRepo;

	}

	public int saveStockReceive(StockReceive stk) throws Exception {
		int saveflag = 0;

		Double incid = stkrecrepo.viewStockReceiveId(stk.getLocname(), stk.getLocrefid());
		String incno = stkrecrepo.viewStockReceiveIncNo(stk.getLocname(), stk.getLocrefid(), incid);
		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "STK/REC");

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("STK/REC/", stk.getLocname().toString(),
				stk.getLocrefid().toString(), incno));

		stk.setStkrecno(incr.toString());

		stkrecrepo.save(stk);
		saveflag = 1;
		return saveflag;
	}

	public int saveStkRecProducts(List<StockRecProd> stk) throws Exception { 
		int saveflag = 0;

		int stkcount = 0;
		StockRecProd stkinc = stk.get(0);
		Double recid = stkrecrepo.viewStockReceiveId(stkinc.getLocname(), stkinc.getLocrefid());

		for (StockRecProd temp : stk) {
			if (temp.getCalcflag() != 1) {

				temp.setStkrecrefid(recid);

				stkcount = stkprodrecrepo.StockCount(temp.getFromlocname(), temp.getFromlocrefid(),
						temp.getDrugproductrefid(), temp.getBatchname());
				// Boopalan200619 >=
				if (stkcount < 1) {
					// Boopalan050719

					Integer lastqty = stkprodrecrepo.getLastReceivedQty(temp.getCompanyrefid(), temp.getBranchrefid(),
							temp.getLocname(), temp.getLocrefid(), temp.getDrugproductrefid());
					// Boopalan 250919 mainstock , minimum stock update
					stkprodrecrepo.updateMinimumStock(temp.getCompanyrefid(), temp.getBranchrefid(), temp.getLocname(),
							temp.getLocrefid(), temp.getDrugproductrefid());
					stkprodrecrepo.saveStock(temp.getTolocname(), temp.getTolocrefid(), temp.getFromlocname(),
							temp.getFromlocrefid(), temp.getDrugproductrefid(), temp.getBatchrefid(),
							temp.getBranchrefid(), lastqty,temp.getPackageunit());
				}
				Integer lastqty = stkprodrecrepo.getLastReceivedQty(temp.getCompanyrefid(), temp.getBranchrefid(),
						temp.getLocname(), temp.getLocrefid(), temp.getDrugproductrefid());
				stkprodrecrepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductrefid(),
						temp.getBatchrefid(), temp.getReceivetotalqty(), temp.getBranchrefid(), lastqty);
				// Boopalan 250919 mainstock , minimum stock update
				stkprodrecrepo.updateMinimumStock(temp.getCompanyrefid(), temp.getBranchrefid(), temp.getLocname(),
						temp.getLocrefid(), temp.getDrugproductrefid());
				if ((temp.getTransfertotalqty() - temp.getReceivetotalqty()) < 0.5) {
					stkprodrecrepo.updateStkRecFlag(temp.getStktrfrefid(), temp.getDrugproductrefid(),
							temp.getBatchrefid());

				}
				stkprodrecrepo.save(temp);
			}
		}

		// stkprodrecrepo.updateStockTransfer(
		// stkinc.getStktrfrefid());

		saveflag = 1;
		System.out.println(saveflag);
		return saveflag;
	}

	public int saveGenJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		Double incid = genjournalRepo.viewJournalId(jrnl.getLocname(), jrnl.getLocrefid());

		String incno = genjournalRepo.viewJournalIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		int sid = stkrecrepo.viewStockReceiveIdInt(jrnl.getLocname(), jrnl.getLocrefid());

		String invname = stkrecrepo.viewStockReceiveMaxNo(jrnl.getLocname(), jrnl.getLocrefid());

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

	public List viewStkTransfer(IndCompModel loc) throws Exception {

		return stkprodrecrepo.viewStkTransfer(loc.getLocname(), loc.getLocrefid());

	}

	public List viewStkTransfProducts(IndCompModel loc) throws Exception {

		return stkprodrecrepo.viewStkTransfProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

	public List viewStkReceiveAll(IndCompModel loc) throws Exception {

		return stkprodrecrepo.viewStkReceiveAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewStkReceiveNo(IndCompModel loc) throws Exception {

		return stkprodrecrepo.viewStkReceiveNo(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewStkReceiveProds(IndCompModel loc) throws Exception {

		return stkprodrecrepo.viewStkReceiveProds(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

}
