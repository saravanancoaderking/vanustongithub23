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
import com.medeil.service.BalAdjService;

@Controller
@RequestMapping("api/baladj")
public class BalAdjController {

	@Autowired
	BalAdjService baladjService;

	private final Logger log = LoggerFactory.getLogger(BalAdjController.class);

	@ResponseBody
	@RequestMapping("/updateGenJournal")
	public int updateGenJournal(@RequestBody Journal cust) throws Exception {

		return baladjService.updateGenJournal(cust);

	}

	@ResponseBody
	@RequestMapping("/viewGenJournalAll")
	public List viewGenJournalAll(@RequestBody IndCompModel loc) throws Exception {

		return baladjService.viewGenJournalAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewGenJournal")
	public List viewGenJournal(@RequestBody IndCompModel loc) throws Exception {

		return baladjService.viewGenJournal(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteGenJournal")
	public int deleteGenJournal(@RequestBody IndCompModel loc) throws Exception {

		return baladjService.deleteGenJournal(loc);

	}

}
