package com.medeil.service;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.repository.ReceiptRepository;
import com.medeil.util.AutoIncrement;

@Service
public class ReceiptService {

	private final ReceiptRepository receiptRepo;

	private final Logger log = LoggerFactory.getLogger(ReceiptService.class);

	@Autowired
	ReceiptService(ReceiptRepository ReceiptRepo) {

		this.receiptRepo = ReceiptRepo;

	}

	public int saveReceipt(List<Journal> temp) throws Exception {
		int saveflag = 0;
		for (Journal rt : temp) {
			Double incid = receiptRepo.viewReceiptId(rt.getLocname(), rt.getLocrefid());

			String incno = receiptRepo.viewReceiptIncNo(rt.getLocname(), rt.getLocrefid(), incid);

			if (incno == null) {

				incno = "0";

			}
			// StringBuilder incr = new StringBuilder(
			// AutoIncrement.getIncrement01(incno));
			// incr.insert(0, "RT/JRNL");

			StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("RT/JRNL/", rt.getLocname().toString(),
					rt.getLocrefid().toString(), incno));

			//rt.setCreditamount(rt.getDebitamount());
			rt.setJournalno(incr.toString());
			Journal journal = receiptRepo.findByCompanyrefidAndBranchrefidAndLocnameAndLocrefidAndJrnltypeAndInvoiceno(rt.getCompanyrefid(), rt.getBranchrefid(), rt.getLocname(), rt.getLocrefid(), 6, rt.getInvoiceno());
			if(journal != null) {
			 journal.setCreditamount(journal.getCreditamount() - rt.getCreditamount());	
			 receiptRepo.save(journal);
			}
			receiptRepo.save(rt);
		}
		saveflag = 1;
		return saveflag;
	}

	public int updateReceipt(Journal rt) throws Exception {
		int saveflag = 0;
		rt.setCreditamount(rt.getDebitamount());
		receiptRepo.save(rt);

		saveflag = 1;
		return saveflag;
	}

	public int saveBulkReceipt(List<Journal> rt) throws Exception {
		int saveflag = 0;
		for (Journal temp : rt) {

			if (temp.getBulkflag() == true && temp.getCalcflag() != 1) {

				Double incid = receiptRepo.viewReceiptId(temp.getLocname(), temp.getLocrefid());

				String incno = receiptRepo.viewReceiptIncNo(temp.getLocname(), temp.getLocrefid(), incid);

				if (incno == null) {

					incno = "0";

				}
				// StringBuilder incr = new StringBuilder(
				// AutoIncrement.getIncrement01(incno));

				// incr.insert(0, "RT/JRNL");
				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("RT/JRNL/",
						temp.getLocname().toString(), temp.getLocrefid().toString(), incno));

				temp.setCreditamount(temp.getDebitamount());
				temp.setJournalno(incr.toString());

				receiptRepo.save(temp);

			}

		}

		saveflag = 1;
		return saveflag;
	}

	public List viewSalesInvoiceNo(IndCompModel loc) throws Exception {

		return receiptRepo.viewSalesInvoiceNo(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewSalesInvoice(IndCompModel loc) throws Exception {

		return receiptRepo.viewSalesInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewCustomerSalesInvoice(IndCompModel loc) throws Exception {

		return receiptRepo.viewCustomerSalesInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewPurchaseReturnNo(IndCompModel loc) throws Exception {

		return receiptRepo.viewPurchaseReturnNo(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewPurchaseReturn(IndCompModel loc) throws Exception {

		return receiptRepo.viewPurchaseReturn(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewAccounts(IndCompModel loc) throws Exception {

		return receiptRepo.viewAccounts(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewAccount(IndCompModel loc) throws Exception {

		return receiptRepo.viewAccount(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewReceiptAll(IndCompModel loc) throws Exception {

		return receiptRepo.viewReceiptAll(loc.getLocname(), loc.getLocrefid());
	}

	public List viewReceipt(IndCompModel loc) throws Exception {

		return receiptRepo.viewReceipt(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewCustomers(IndCompModel loc) throws Exception {

		return receiptRepo.viewCustomers(loc.getLocname(), loc.getLocrefid());
	}

	public List viewCustOutstanding(IndCompModel loc) throws Exception {

		return receiptRepo.viewCustOutstanding(loc.getFrmint1());
	}

	public int deleteReceipt(IndCompModel loc) throws Exception {
		int saveflag = 0;
		receiptRepo.deleteReceipt(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}


}
