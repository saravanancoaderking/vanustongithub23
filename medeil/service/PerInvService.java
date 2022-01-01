package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.SDProducts;
import com.medeil.domain.SalesDummy;
import com.medeil.repository.PerInvProdRepository;
import com.medeil.repository.PerInvRepository;
import com.medeil.repository.SJournalRepository;
import com.medeil.util.AutoIncrement;

@Service
public class PerInvService {

	private final PerInvRepository perinvRepo;

	private final PerInvProdRepository perinvprodRepo;

	private final SJournalRepository sjournalRepo;

	private final Logger log = LoggerFactory.getLogger(PerInvService.class);

	@Autowired
	PerInvService(PerInvRepository PerinvRepo, PerInvProdRepository PerinvprodRepo, SJournalRepository SjournalRepo) {

		this.perinvRepo = PerinvRepo;

		this.perinvprodRepo = PerinvprodRepo;

		this.sjournalRepo = SjournalRepo;

	}

	public int saveSalesInvoice(SalesDummy si) throws Exception {
		int saveflag = 0;
		int incid = perinvRepo.viewSalesInvoiceId(si.getLocname(), si.getLocrefid());

		String incno = perinvRepo.viewSalesInvoiceIncNo(si.getLocname(), si.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement01(incno));

		incr.insert(0, "PER/INV");
		si.setSalesbilltype("3");
		si.setSalesbillno(incr.toString());
		perinvRepo.save(si);

		saveflag = 1;
		return saveflag;

	}

	public int saveSIProduct(List<SDProducts> si) throws Exception {
		int saveflag = 0;
		int sid = 0;

		SDProducts sinc = si.get(0);

		sid = perinvRepo.viewSalesInvoiceId(sinc.getLocname(), sinc.getLocrefid());
		for (SDProducts temp : si) {

			if (temp.getCalcflag() != 1) {
				/*
				 * perinvRepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(),
				 * temp.getDrugproductid(), temp.getBatchrefid(), temp.getTotalqty());
				 */

				temp.setSalesrefid(sid);

				perinvprodRepo.save(temp);

			}

		}

		saveflag = 1;
		return saveflag;

	}

	public int saveSalesJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		Double incid = sjournalRepo.viewSjournalId(jrnl.getLocname(), jrnl.getLocrefid());

		String incno = sjournalRepo.viewSjournalIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement01(incno));

		incr.insert(0, "SLS/JRNL");

		jrnl.setJournalno(incr.toString());
		sjournalRepo.save(jrnl);

		saveflag = 1;
		return saveflag;

	}

	public int saveTempStock(IndCompModel loc) throws Exception {
		int saveflag = 0;
		/*
		 * perinvRepo.updateTempStockMain(loc.getLocname(), loc.getLocrefid(),
		 * loc.getFrmint1(), loc.getFrmint2(), loc.getFrmint3());
		 * 
		 * perinvRepo.saveTempStock(loc.getLocname(), loc.getLocrefid(),
		 * loc.getFrmint1(), loc.getFrmint2(), loc.getFrmint3());
		 */

		saveflag = 1;
		return saveflag;

	}

	public int updateSalesInvoice(SalesDummy si) throws Exception {
		int saveflag = 0;
		perinvRepo.save(si);
		saveflag = 1;
		return saveflag;
	}

	public int updateSIProduct(List<SDProducts> si) throws Exception {
		int saveflag = 0;

		SDProducts snv = si.get(0);

		/*
		 * perinvRepo.updateMainstockEdit(snv.getLocname(), snv.getLocrefid(),
		 * snv.getSalesrefid());
		 */

		for (SDProducts temp : si) {
			if (temp.getCalcflag() != 1) {

				if (temp.getDelflag() == true) {
					temp.setStatus(5.0);

				} else {

					temp.setStatus(0.0);
				}

				/*
				 * perinvRepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(),
				 * temp.getDrugproductid(), temp.getBatchrefid(), temp.getTotalqty());
				 */
				temp.setSalesrefid(snv.getSalesrefid());

				perinvprodRepo.save(temp);

			}
		}

		saveflag = 1;
		return saveflag;

	}

	public int updateTempStockMain(IndCompModel loc) throws Exception {
		int saveflag = 0;
		/*
		 * perinvRepo.updateTempStockMain(loc.getLocname(), loc.getLocrefid(),
		 * loc.getFrmint1(), loc.getFrmint2(), loc.getFrmint1());
		 */

		saveflag = 1;
		return saveflag;

	}

	public List viewCustomers(IndCompModel loc) throws Exception {

		return perinvRepo.viewCustomers(loc.getLocname(), loc.getLocrefid());

	}

	public List viewDoctors(IndCompModel loc) throws Exception {

		return perinvRepo.viewDoctors(loc.getLocname(), loc.getLocrefid());

	}

	public List viewSalesInvoiceAll(IndCompModel loc) throws Exception {

		return perinvRepo.viewSalesInvoiceAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewSalesInvoice(IndCompModel loc) throws Exception {

		return perinvRepo.viewSalesInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewSIProducts(IndCompModel loc) throws Exception {

		return perinvprodRepo.viewSIProducts(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewProductNames(IndCompModel loc) throws Exception {

		return perinvRepo.viewProductNames(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());

	}

	public List viewProductName(IndCompModel loc) throws Exception {

		return perinvRepo.viewProductName(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getFrmint2());

	}

	public List viewPriceSettings(IndCompModel loc) throws Exception {

		return perinvRepo.viewPriceSettings(loc.getLocname(), loc.getLocrefid());

	}

	public List viewDiscountSettings(IndCompModel loc) throws Exception {

		return perinvRepo.viewDiscountSettings(loc.getLocname(), loc.getLocrefid());

	}

	public List viewSalesInvCustAll(IndCompModel loc) throws Exception {

		return perinvRepo.viewSalesInvCustAll(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewSalesDumCustAll(IndCompModel loc) throws Exception {

		return perinvRepo.viewSalesDumCustAll(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public int deleteSalesInvoice(IndCompModel loc) throws Exception {
		int saveflag = 0;
		perinvRepo.deleteSalesInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

}
