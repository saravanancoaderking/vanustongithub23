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
import com.medeil.domain.PurchaseJournal;
import com.medeil.service.CreditService;

@Controller
@RequestMapping("api/crnote")
public class CreditNoteController {

	@Autowired
	CreditService creditService;
	private final Logger log = LoggerFactory.getLogger(CreditNoteController.class);

	@ResponseBody
	@RequestMapping("/updateCreditNote")
	public int updateCreditNote(@RequestBody Journal cr) throws Exception{

		return creditService.updateCreditNote(cr);

	}

	@ResponseBody
	@RequestMapping("/viewCreditNoteAll")
	public List viewCreditNoteAll(@RequestBody IndCompModel loc)throws Exception {

		return creditService.viewCreditNoteAll(loc);
	}

	@ResponseBody
	@RequestMapping("/viewCreditNote")
	public List viewCreditNote(@RequestBody IndCompModel loc)throws Exception {

		return creditService.viewCreditNote(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteCreditNote")
	public int deleteCreditNote(@RequestBody IndCompModel loc)throws Exception {

		return creditService.deleteCreditNote(loc);

	}

}
