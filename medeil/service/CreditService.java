package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.PurchaseJournal;
import com.medeil.repository.CreditRepository;
import com.medeil.repository.PatientRepository;

@Service
public class CreditService {

	private final CreditRepository creditrepo;

	private final PatientRepository patientRepo;

	private final Logger log = LoggerFactory.getLogger(CreditService.class);

	@Autowired
	CreditService(CreditRepository Creditrepo, PatientRepository PatientRepo) {

		this.creditrepo = Creditrepo;
		this.patientRepo = PatientRepo;

	}

	public Integer updateCreditNote(Journal cr) throws Exception {
		int saveflag = 0;
		cr.setCreditamount(cr.getDebitamount());

		creditrepo.save(cr);

		saveflag = 1;
		return saveflag;
	}

	public List viewCreditNoteAll(IndCompModel loc)throws Exception {

		return creditrepo.viewCreditNoteAll(loc.getLocname(), loc.getLocrefid(), loc.getCompanyrefid(),
				loc.getBranchrefid());
	}

	public List viewCreditNote(IndCompModel loc)throws Exception {

		return creditrepo.viewCreditNote(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyrefid(),
				loc.getBranchrefid());
	}

	public int deleteCreditNote(IndCompModel loc)throws Exception {
		int saveflag = 0;
		creditrepo.deleteCreditNote(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1(), loc.getCompanyrefid(),
				loc.getBranchrefid());
		saveflag = 1;
		return saveflag;
	}

}
