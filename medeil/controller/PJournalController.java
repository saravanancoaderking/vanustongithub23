package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.service.PJournalService;

@RestController
@RequestMapping("api/purcjrnl")
public class PJournalController {

	@Autowired
	PJournalService pjournalService;

	private final Logger log = LoggerFactory.getLogger(PJournalController.class);

	@RequestMapping("/updatePrcJournal")
	public int updatePrcJournal(@RequestBody Journal purc) throws Exception {

		return pjournalService.updatePrcJournal(purc);

	}

	@RequestMapping("/viewPurJrnlAll")
	public List viewPurJrnlAll(@RequestBody IndCompModel loc) throws Exception {

		return pjournalService.viewPurJrnlAll(loc);

	}

	@RequestMapping("/viewPurJrnl")
	public List viewPurJrnl(@RequestBody IndCompModel loc) throws Exception {

		return pjournalService.viewPurJrnl(loc);

	}

	@RequestMapping("/deletePurJrnl")
	public int deletePurJrnl(@RequestBody IndCompModel loc) throws Exception {

		return pjournalService.deletePurJrnl(loc);

	}

}
