package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.Journal1;
//import com.medeil.domain.Journal1;
import com.medeil.service.DebitService;

@RestController
@RequestMapping("api/drnote")
public class DebitNoteController {

	private final Logger log = LoggerFactory.getLogger(DebitNoteController.class);

	@Autowired
	DebitService debitNoteService;

	@ResponseBody
	@RequestMapping("/updateDebitNote")
	public int updateDebitNote(@RequestBody Journal cust) {

		return debitNoteService.updateDebitNote(cust);

	}

	// sabarish
	@GetMapping(value = "getreturntype/{cid}/{bid}/{locname}/{locrefid}/{id}")
	public List getReturntype(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer id) throws Exception {

		return debitNoteService.getReturntype(cid, bid, locname, locrefid, id);
	}

	@GetMapping(value = "gettabledata/{cid}/{bid}/{locname}/{locrefid}/{id}/{typeid}")
	public List getTabledata(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer id, @PathVariable Integer typeid) throws Exception {

		return debitNoteService.getTabledata(cid, bid, locname, locrefid, id, typeid);
	}

	@ResponseBody
	@RequestMapping("/savedbnote")
	public int savedbnote(@RequestBody Journal1 jrn) throws Exception {
		return debitNoteService.savedbnote(jrn);
	}

	@ResponseBody
	@RequestMapping("/viewDebitNoteAll")
	public List viewDebitNoteAll(@RequestBody IndCompModel loc) throws Exception {

		return debitNoteService.viewDebitNoteAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDebitNote")
	public List viewDebitNote(@RequestBody IndCompModel loc) throws Exception {

		return debitNoteService.viewDebitNote(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteDebitNote")
	public int deleteDebitNote(@RequestBody IndCompModel loc) throws Exception {

		return debitNoteService.deleteDebitNote(loc);

	}

}
