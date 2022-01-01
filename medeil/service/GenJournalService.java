package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.repository.GenJrnlRepository;
import com.medeil.util.AutoIncrement;

@Service
public class GenJournalService {

	private final GenJrnlRepository genJrnlrepo;

	private final Logger log = LoggerFactory.getLogger(GenJournalService.class);

	@Autowired
	GenJournalService(GenJrnlRepository GenJrnlrepo) {

		this.genJrnlrepo = GenJrnlrepo;

	}

	public int saveGenJournal(List<Journal> journal) throws Exception {
		int saveflag = 0;
		for (Journal jrnl : journal) {
			Double incid = genJrnlrepo.viewJournalId(jrnl.getLocname(), jrnl.getLocrefid());

			String incno = genJrnlrepo.viewJournalIncNo(jrnl.getLocname(), jrnl.getLocrefid(), incid);

			if (incno == null) {

				incno = "0";
			}

			// StringBuilder incr = new StringBuilder(
			// AutoIncrement.getIncrement01(incno));

			// incr.insert(0, "GEN/JRNL");
			StringBuilder incr = new StringBuilder(AutoIncrement.getIncrement03("GEN/JRNL/", jrnl.getLocname().toString(),
					jrnl.getLocrefid().toString(), incno));

			jrnl.setJournalno(incr.toString());
			genJrnlrepo.save(jrnl);	
		}
		

		saveflag = 1;
		return saveflag;
	}

	public int updateGenJournal(Journal jrnl) throws Exception {
		int saveflag = 0;
		// jrnl.setCreditamount(jrnl.getDebitamount());

		genJrnlrepo.save(jrnl);

		saveflag = 1;
		return saveflag;
	}

	public List viewGenJournalAll(IndCompModel loc) throws Exception {

		return genJrnlrepo.viewGenJournalAll(loc.getLocname(), loc.getLocrefid());
	}

	public List viewGenJournal(IndCompModel loc) throws Exception {

		return genJrnlrepo.viewGenJournal(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
	}

	public int deleteGenJournal(IndCompModel loc) throws Exception {
		int saveflag = 0;
		genJrnlrepo.deleteGenJournal(loc.getLocname(), loc.getLocrefid(), loc.getFrmint1());
		saveflag = 1;
		return saveflag;
	}

}
