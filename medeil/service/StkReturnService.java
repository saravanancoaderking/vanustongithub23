package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.StockRetProducts;
import com.medeil.repository.GenJrnlRepository;
import com.medeil.repository.StkRetnProdRepository;
import com.medeil.util.AutoIncrement;

@Service
public class StkReturnService {

	private final StkRetnProdRepository stkretnprodrepo;

	private final GenJrnlRepository genjournalRepo;

	private final Logger log = LoggerFactory.getLogger(StkReturnService.class);

	@Autowired
	StkReturnService(StkRetnProdRepository Stkretnprodrepo, GenJrnlRepository GenjournalRepo) {

		this.stkretnprodrepo = Stkretnprodrepo;
		this.genjournalRepo = GenjournalRepo;
	}

	public int saveStockRetProducts(List<StockRetProducts> stk) throws Exception {
		int saveflag = 0;

		int stkcount = 0;

		StockRetProducts stkinc = stk.get(0);

		Double incid = Double.valueOf(stkretnprodrepo.viewStockReturnId(stkinc.getLocname(), stkinc.getLocrefid()));

		Double incidnu = stkretnprodrepo.viewStockReturnIdNU(stkinc.getLocname(), stkinc.getLocrefid());

		String incno = stkretnprodrepo.viewStockReturnIncNo(stkinc.getLocname(), stkinc.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";

		}

		if (incidnu == null) {

			incidnu = 0.0;

		}

		incidnu += 1;

		for (StockRetProducts temp : stk) {

			if (temp.getCalcflag() != 1) {
				// StringBuilder incr = new StringBuilder(
				// AutoIncrement.getIncrement01(incno));
				// incr.insert(0, "STK/RETN");

				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("STK/RETN/",
						stkinc.getLocname().toString(), stkinc.getLocrefid().toString(), incno));

				temp.setStkretnno(incr.toString());
				temp.setStkretnid(incidnu);

				stkretnprodrepo.updateMainstockFrom(temp.getFromlocname(), temp.getFromlocrefid(),
						temp.getDrugproductrefid(), temp.getBatchrefid(), temp.getReturntotalqty());

				stkcount = stkretnprodrepo.StockCount(temp.getTolocname(), temp.getTolocrefid(),
						temp.getDrugproductrefid(), temp.getBatchrefid());

				if (stkcount < 1) {

					stkretnprodrepo.saveStock(temp.getFromlocname(), temp.getFromlocrefid(), temp.getTolocname(),
							temp.getTolocrefid(), temp.getDrugproductrefid(), temp.getBatchrefid());
				}

				stkretnprodrepo.updateMainstockTo(temp.getTolocname(), temp.getTolocrefid(), temp.getDrugproductrefid(),
						temp.getBatchrefid(), temp.getReturntotalqty());
				if(temp.getRetstatus().equals(1)) {
					stkretnprodrepo.updatesktrflag(temp.getStktrfrefid());// Boopalan 260719	
				}
				stkretnprodrepo.save(temp);

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

		int sid = stkretnprodrepo.viewStockReturnId(jrnl.getLocname(), jrnl.getLocrefid());

		String invname = stkretnprodrepo.viewStockReturnMaxNo(jrnl.getLocname(), jrnl.getLocrefid());

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

		return stkretnprodrepo.viewStkTransfer(loc.getLocname(), loc.getLocrefid());

	}

	public List viewStkTransfProducts(IndCompModel loc) throws Exception {

		return stkretnprodrepo.viewStkTransfProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

	public List viewStkReturnAll(IndCompModel loc) throws Exception {

		return stkretnprodrepo.viewStkReturnAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewStkReturnProds(IndCompModel loc) throws Exception {

		return stkretnprodrepo.viewStkReturnProds(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(),
				loc.getCompanyid());

	}

	public int deleteStockReturn(IndCompModel loc) throws Exception {
		int saveflag = 0;
		stkretnprodrepo.deleteStockReturn(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

}
