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
import com.medeil.service.SJournalService;

@Controller
@RequestMapping("api/sjournal")
public class SJournalController {

	@Autowired
	SJournalService sjournalService;

	private final Logger log = LoggerFactory.getLogger(SJournalController.class);

	@ResponseBody
	@RequestMapping("/updateSJournal")
	public int updateSJournal(@RequestBody Journal sls) throws Exception {

		return sjournalService.updateSJournal(sls);

	}

	@ResponseBody
	@RequestMapping("/viewSjournalAll")
	public List viewSjournalAll(@RequestBody IndCompModel loc) throws Exception {

		return sjournalService.viewSjournalAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSjournal")
	public List viewSjournal(@RequestBody IndCompModel loc) throws Exception {

		return sjournalService.viewSjournal(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteSjournal")
	public int deleteSjournal(@RequestBody IndCompModel loc) throws Exception {

		return sjournalService.deleteSjournal(loc);

	}

}
