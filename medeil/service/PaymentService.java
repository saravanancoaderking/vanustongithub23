package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.repository.PaymentRepository;
import com.medeil.repository.PurchaseRepository;
import com.medeil.util.AutoIncrement;

@Transactional
@Service
public class PaymentService {

	private final PaymentRepository paymentRepo;

	private final Logger log = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	PaymentService(PaymentRepository PaymentRepo) {

		this.paymentRepo = PaymentRepo;

	}
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	public int savePayment(List<Journal> temp) throws Exception {

		int saveflag = 0;
		for (Journal pt : temp) {
			Double incid = paymentRepo.viewPaymentId(pt.getLocname(), pt.getLocrefid());

			String incno = paymentRepo.viewPaymentIncNo(pt.getLocname(), pt.getLocrefid(), incid);

			if (incno == null) {

				incno = "0";

			}
			// StringBuilder incr = new StringBuilder(
			// AutoIncrement.getIncrement01(incno));
			// incr.insert(0, "PT/JRNL");

			StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("PT/JRNL/", pt.getLocname().toString(),
					pt.getLocrefid().toString(), incno));
			List<Journal> journals = paymentRepo.findByLocrefidAndJrnltypeAndInvoiceno(pt.getLocrefid(),4,pt.getInvoiceno());
			for(Journal journals1 : journals) {
				journals1.setInvoicebalamt(0.00);
				paymentRepo.save(journals1);	
			}
			
			//pt.setCreditamount(pt.getDebitamount());
			pt.setJournalno(incr.toString());
			pt.setInvoicebalamt(pt.getInvoicebalamt());
			paymentRepo.save(pt);
		}
		saveflag = 1;
		return saveflag;
	}

	public int updatePayment(Journal pt) throws Exception {

		int saveflag = 0;
		//pt.setCreditamount(pt.getDebitamount());
		paymentRepo.save(pt);

		saveflag = 1;
		return saveflag;
	}

	public int saveBulkPayment(List<Journal> pt) throws Exception {

		int saveflag = 0;

		for (Journal temp : pt) {

			if (temp.getBulkflag() == true && temp.getCalcflag() != 1) {

				Double incid = paymentRepo.viewPaymentId(temp.getLocname(), temp.getLocrefid());

				String incno = paymentRepo.viewPaymentIncNo(temp.getLocname(), temp.getLocrefid(), incid);

				if (incno == null) {

					incno = "0";

				}
				// StringBuilder incr = new StringBuilder(
				// AutoIncrement.getIncrement01(incno));

				// incr.insert(0, "PT/JRNL");
				StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("PT/JRNL/",
						temp.getLocname().toString(), temp.getLocrefid().toString(), incno));
				temp.setCreditamount(temp.getDebitamount());
				temp.setJournalno(incr.toString());

				paymentRepo.save(temp);

			}

		}

		saveflag = 1;
		return saveflag;
	}

	public List viewPurchaseInvoiceNo(IndCompModel loc) throws Exception {

		return paymentRepo.viewPurchaseInvoiceNo(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewPurchaseInvoice(IndCompModel loc) throws Exception {

		return paymentRepo.viewPurchaseInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewVendorPurchaseInvoice(IndCompModel loc) throws Exception {

		return paymentRepo.viewVendorPurchaseInvoice(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}
	
	public List viewCustomersalesreturn(IndCompModel loc) throws Exception {

		return paymentRepo.viewCustomersalesreturn(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewSalesReturnNo(IndCompModel loc) throws Exception {

		return paymentRepo.viewSalesReturnNo(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewSalesReturn(IndCompModel loc) throws Exception {

		return paymentRepo.viewSalesReturn(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewAccounts(IndCompModel loc) throws Exception {

		return paymentRepo.viewAccounts(loc.getLocname(), loc.getLocrefid(), loc.getFrmstr1());
	}

	public List viewAccount(IndCompModel loc) throws Exception {

		return paymentRepo.viewAccount(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewAccountsAll(IndCompModel loc) throws Exception {

		return paymentRepo.viewAccountsAll(loc.getLocname(), loc.getLocrefid());
	}

	public List viewPaymentAll(IndCompModel loc) throws Exception {

		return paymentRepo.viewPaymentAll(loc.getLocname(), loc.getLocrefid());
	}

	public List viewPayment(IndCompModel loc) throws Exception {

		return paymentRepo.viewPayment(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public List viewDistributors(IndCompModel loc) throws Exception {

		return paymentRepo.viewDistributors(loc.getLocname(), loc.getLocrefid());
	}

	public List viewDistOutstanding(IndCompModel loc) throws Exception {

		return paymentRepo.viewDistOutstanding(loc.getFrmint1());
	}

	public int deletePayment(IndCompModel loc) throws Exception {
		int saveflag = 0;
		paymentRepo.deletePayment(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;
	}

	public List Viewpaymentout(Integer cid, Integer bid, Integer lname, Integer lrefid,String date) {
		return paymentRepo.Viewpaymentout(cid,bid,lname,lrefid,date);
	}

	public List GetAllCreditAlerts(Integer cid, Integer bid, Integer lname, Integer lrefid) {
		return paymentRepo.GetAllCreditAlerts(cid,bid,lname,lrefid);
	}

	public List Getemplists(Integer cid, Integer bid, Integer lname, Integer lrefid) {
		return paymentRepo.Getemplists(cid,bid,lname,lrefid);
	}

	public int savePaymentsin(Journal pt) {
		int saveflag = 0;
		Double incid = paymentRepo.viewPaymentId(pt.getLocname(), pt.getLocrefid());

		String incno = paymentRepo.viewPaymentIncNo(pt.getLocname(), pt.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";

		}
		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "PT/JRNL");

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("PT/JRNL/", pt.getLocname().toString(),
				pt.getLocrefid().toString(), incno));
		Integer PIID = paymentRepo.getPIID(pt.getCompanyrefid(), pt.getBranchrefid(), pt.getLocname(),
				pt.getLocrefid());
		pt.setInvoiceno(PIID);
		//pt.setCreditamount(pt.getDebitamount());
		pt.setJournalno(incr.toString());
		paymentRepo.save(pt);
		saveflag = 1;
		return saveflag;
	}

	public int saveBankdeposit(Journal bk) {
		int saveflag = 0;
		Double incid = paymentRepo.viewbdId(bk.getLocname(), bk.getLocrefid());

		String incno = paymentRepo.viewbdIncNo(bk.getLocname(), bk.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";

		}
		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));
		// incr.insert(0, "PT/JRNL");

		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("BD/JRNL/", bk.getLocname().toString(),
				bk.getLocrefid().toString(), incno));
		bk.setJournalno(incr.toString());
		paymentRepo.save(bk);
		saveflag = 1;
		return saveflag;
	}

}
