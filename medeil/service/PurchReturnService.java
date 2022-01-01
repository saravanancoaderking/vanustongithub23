package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.PrProducts;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.domain.PurchaseReturn;
import com.medeil.repository.DebitRepository;
import com.medeil.repository.PatientRepository;
import com.medeil.repository.PrProductsRepository;
import com.medeil.repository.PurchReturnRepository;
import com.medeil.repository.PurchasenvoiceproRepository;
import com.medeil.util.AutoIncrement;

@Service
public class PurchReturnService {

	private final PrProductsRepository prProducRepo;

	private final PurchReturnRepository phretrepo;

	private final PatientRepository patientRepo;

	private final DebitRepository debitrepo;

	private final PurchasenvoiceproRepository purchasenvoiceproRepository;

	private final Logger log = LoggerFactory.getLogger(PurchReturnService.class);

	@Autowired
	PurchReturnService(PurchReturnRepository Phretrepo, PatientRepository CustRepo, PrProductsRepository PrProducRepo,
			DebitRepository Debitrepo, PurchasenvoiceproRepository purchasenvoiceproRepository) {

		this.phretrepo = Phretrepo;
		this.patientRepo = CustRepo;
		this.prProducRepo = PrProducRepo;
		this.debitrepo = Debitrepo;
		this.purchasenvoiceproRepository = purchasenvoiceproRepository;

	}

	public int savePurchReturn(PurchaseReturn pr) throws Exception {
		int saveflag = 0;
		int incid = phretrepo.viewPrId(pr.getLocname(), pr.getLocrefid());

		String incno = phretrepo.viewPrIncNo(pr.getLocname(), pr.getLocrefid(), incid);
		if (incno == null) {

			incno = "0";
		}

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "PR/RET");

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("PR/RET/", pr.getLocname().toString(),
				pr.getLocrefid().toString(), incno));

		pr.setPrno(incr.toString());
		phretrepo.save(pr);

		saveflag = 1;
		return saveflag;
	}

	public int savePrProducts(List<PrProducts> pr) throws Exception {
		int saveflag = 0;
		int prid = 0;

		PrProducts princ = pr.get(0);

		prid = phretrepo.viewPrId(princ.getLocname(), princ.getLocrefid());
		for (PrProducts temp : pr) {

			if (temp.getCalcflag() != 1) {
				prProducRepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
						temp.getBatchname(), temp.getTotalquantity());

				temp.setPrrefid(prid);

				prProducRepo.save(temp);

			}

			if (temp.getStatus().equalsIgnoreCase("1")) {
				PurchaseInvoice purchaseInvoice = purchasenvoiceproRepository.findByPirefidAndDrugproductrefid(
						Integer.valueOf(temp.getPirefid()), Integer.valueOf(temp.getDrugproductid()));
				purchaseInvoice.setPrflag(1);
				purchasenvoiceproRepository.save(purchaseInvoice);

			}
		}
		saveflag = 1;
		System.out.println(saveflag);
		return saveflag;

	}

	public int saveDebitNote(Journal jrnl) throws Exception {

		int saveflag = 0;

		Double incid = debitrepo.viewDebitNoteId(jrnl.getLocname(), jrnl.getLocrefid());

		String incno = debitrepo.viewDebitNoteIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		int prid = phretrepo.viewPrId(jrnl.getLocname(), jrnl.getLocrefid());

		String invname = phretrepo.viewPrIncMaxNo(jrnl.getLocname(), jrnl.getLocrefid());

		String personame = phretrepo.viewDistName(jrnl.getPersonid());

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));

		// incr.insert(0, "DR/NOTE");
		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("DR/NOTE/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));

		//Double journal = debitrepo.getinvoiceAmt(jrnl.getPersonid(),jrnl.getInvoiceno(),jrnl.getLocrefid());
		jrnl.setPersoname(personame);
		jrnl.setInvoicename(invname);
		// jrnl.setCreditamount(jrnl.getDebitamount());

		jrnl.setInvoiceno(prid);
		jrnl.setJournalno(incr.toString());
		debitrepo.save(jrnl);
	
		saveflag = 1;
		return saveflag;

	}

	public int updatePurchReturn(PurchaseReturn pr) throws Exception {

		int saveflag = 0;

		phretrepo.save(pr);

		saveflag = 1;
		return saveflag;
	}

	public int updatePrProducts(List<PrProducts> pr) throws Exception {

		int saveflag = 0;

		PrProducts prn = pr.get(0);

		prProducRepo.updateMainstockEdit(prn.getLocname(), prn.getLocrefid(), prn.getPrrefid());

		for (PrProducts temp : pr) {
			if (temp.getCalcflag() != 1) {

				if (temp.getDelflag() == true) {
					temp.setStatus("5");

				} else {

					temp.setStatus("0");
				}

				prProducRepo.updateMainstockSave(temp.getLocname(), temp.getLocrefid(), temp.getDrugproductid(),
						temp.getBatchname(), temp.getTotalquantity());

				prProducRepo.save(temp);

			}
		}
		saveflag = 1;
		return saveflag;
	}

	public List viewPurcInvoicesNo(IndCompModel loc) throws Exception {

		return phretrepo.viewPurcInvoicesNo(loc.getLocname(), loc.getLocrefid());
	}

	public List viewPurcInvoice(IndCompModel loc) throws Exception {

		return phretrepo.viewPurcInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewPiProduct(IndCompModel loc) throws Exception {

		return phretrepo.viewPiProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public List viewPurchReturnNo(IndCompModel loc) throws Exception {

		return phretrepo.viewPurchReturnNo(loc.getLocname(), loc.getLocrefid());
	}

	// Boopalan 060519
	public List viewPurchaseReturn(IndCompModel loc) throws Exception {

		return phretrepo.viewPurchaseReturn(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewPrProduct(IndCompModel loc) throws Exception {

		return phretrepo.viewPrProduct(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public int deletePurchReturn(IndCompModel loc) throws Exception {
		int saveflag = 0;
		phretrepo.deletePurchReturn(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

	/*** Purchase Return Save VendorID ***/ // Boopalan 020519
	public List saveVendoridPurchReturn(IndCompModel loc) throws Exception {
		return phretrepo.saveVendoridPurchReturn(loc.getPiid());
	}
}
