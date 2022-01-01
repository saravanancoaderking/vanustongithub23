package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.repository.PJournalRepository;

@Service
public class PJournalService {

	private final PJournalRepository pjournalRepo;

	private final Logger log = LoggerFactory.getLogger(DebitService.class);

	@Autowired
	PJournalService(PJournalRepository PjournalRepo) {

		this.pjournalRepo = PjournalRepo;

	}

	public int updatePrcJournal(Journal purc) throws Exception {
		int saveflag = 0;
		purc.setCreditamount(purc.getDebitamount());
		pjournalRepo.save(purc);

		saveflag = 1;
		return saveflag;
	}

	public List viewPurJrnlAll(IndCompModel loc) throws Exception {

		return pjournalRepo.viewPurJrnlAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewPurJrnl(IndCompModel loc) throws Exception {

		return pjournalRepo.viewPurJrnl(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public int deletePurJrnl(IndCompModel loc) throws Exception {
		int saveflag = 0;
		pjournalRepo.deletePurJrnl(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

}
