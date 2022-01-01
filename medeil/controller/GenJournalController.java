package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.service.GenJournalService;

@Controller
@RequestMapping("api/genjrnl")
public class GenJournalController {

	private final Logger log = LoggerFactory.getLogger(GenJournalController.class);

	@Autowired
	GenJournalService genJournalService;

	@ResponseBody
	@RequestMapping("/saveGenJournal")
	public int saveGenJournal(@RequestBody List<Journal> jrnl) throws Exception {

		return genJournalService.saveGenJournal(jrnl);

	}

	@ResponseBody
	@RequestMapping("/updateGenJournal")
	public int updateGenJournal(@RequestBody Journal jrnl) throws Exception {

		return genJournalService.updateGenJournal(jrnl);

	}

	@ResponseBody
	@RequestMapping("/viewGenJournalAll")
	public List viewGenJournalAll(@RequestBody IndCompModel loc) throws Exception {

		return genJournalService.viewGenJournalAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewGenJournal")
	public List viewGenJournal(@RequestBody IndCompModel loc) throws Exception {

		return genJournalService.viewGenJournal(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteGenJournal")
	public int deleteGenJournal(@RequestBody IndCompModel loc) throws Exception {

		return genJournalService.deleteGenJournal(loc);

	}
}
