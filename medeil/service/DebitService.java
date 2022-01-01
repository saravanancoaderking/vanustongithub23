package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.Journal1;
import com.medeil.repository.DebitRepository;
import com.medeil.repository.DebitRepository1;
import com.medeil.repository.PatientRepository;
import com.medeil.util.AutoIncrement;

@Service
public class DebitService {

	private final DebitRepository debitrepo;

	private final DebitRepository1 debitrepo1;

	private final PatientRepository patientRepo;

	private final Logger log = LoggerFactory.getLogger(DebitService.class);

	List list;

	@Autowired
	DebitService(DebitRepository Debitrepo, PatientRepository PatientRepo, DebitRepository1 Debitrepo1) {

		this.debitrepo = Debitrepo;
		this.patientRepo = PatientRepo;
		this.debitrepo1 = Debitrepo1;

	}

	public int updateDebitNote(Journal dt) {
		int saveflag = 0;
		dt.setCreditamount(dt.getDebitamount());

		debitrepo.save(dt);

		saveflag = 1;
		return saveflag;
	}

	public List viewDebitNoteAll(IndCompModel loc) throws Exception {

		return debitrepo.viewDebitNoteAll(loc.getLocname(), loc.getLocrefid(), loc.getCompanyrefid(),
				loc.getBranchrefid());
	}

	public List viewDebitNote(IndCompModel loc) throws Exception {

		return debitrepo.viewDebitNote(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyrefid(),
				loc.getBranchrefid());
	}

	public int deleteDebitNote(IndCompModel loc) throws Exception {
		int saveflag = 0;
		debitrepo.deleteDebitNote(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyrefid(),
				loc.getBranchrefid());
		saveflag = 1;
		return saveflag;
	}

	// sabarish accounts for damage and expiry

	public int savedbnote(Journal1 jrnl) throws Exception {

		int saveflag = 0;

		Double incid = debitrepo.viewDebitNoteId(jrnl.getLocname(), jrnl.getLocrefid());

		String incno = debitrepo.viewDebitNoteIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);

		if (incno == null) {

			incno = "0";
		}

		// String personame = phretrepo.viewDistName(jrnl.getPersonid());

		// StringBuilder incr = new StringBuilder(
		// AutoIncrement.getIncrement01(incno));

		// incr.insert(0, "DR/NOTE");
		StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("DR/NOTE/", jrnl.getLocname().toString(),
				jrnl.getLocrefid().toString(), incno));

		// jrnl.setPersoname(personame);
		// jrnl.setInvoicename(invname);
		// jrnl.setCreditamount(jrnl.getDebitamount());

		// jrnl.setInvoiceno(prid);
		jrnl.setJournalno(incr.toString());
		debitrepo1.save(jrnl);

		saveflag = 1;
		return saveflag;
	}

	// Sabarish
	public List getReturntype(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer id)
			throws Exception {
		list = null;
		// try {
		if (id == 6) {
			list = debitrepo.getDamageStock(cid, bid, locname, locrefid);
		} else {
			list = debitrepo.getExpiryStock(cid, bid, locname, locrefid);
		}

		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		return list;
	}

	public List getTabledata(Integer cid, Integer bid, Integer locname, Integer locrefid, Integer id, Integer typeid)
			throws Exception {
		list = null;
		// try {
		if (typeid == 1) {
			list = debitrepo.getDamageStockdetails(cid, bid, locname, locrefid, id);
		} else {
			list = debitrepo.getExpiryStockdetails(cid, bid, locname, locrefid, id);
		}

		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		return list;
	}

}
