package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.repository.SJournalRepository;

@Service
public class SJournalService {

	private final SJournalRepository sjournalRepo;

	private final Logger log = LoggerFactory.getLogger(DebitService.class);

	@Autowired
	SJournalService(SJournalRepository SjournalRepo) {

		this.sjournalRepo = SjournalRepo;

	}

	public int updateSJournal(Journal sls) throws Exception {
		int saveflag = 0;
		sls.setCreditamount(sls.getDebitamount());
		sjournalRepo.save(sls);

		saveflag = 1;
		return saveflag;
	}

	public List viewSjournalAll(IndCompModel loc) throws Exception {

		return sjournalRepo.viewSjournalAll(loc.getLocname(), loc.getLocrefid());

	}

	public List viewSjournal(IndCompModel loc) throws Exception {

		return sjournalRepo.viewSjournal(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());

	}

	public int deleteSjournal(IndCompModel loc) throws Exception {
		int saveflag = 0;
		sjournalRepo.deleteSjournal(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;

	}

}
