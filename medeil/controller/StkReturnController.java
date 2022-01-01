package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.StockRetProducts;
import com.medeil.service.StkReturnService;

@Controller
@RequestMapping("api/stkretn")
public class StkReturnController {

	@Autowired
	StkReturnService stkreturnService;

	@ResponseBody
	@RequestMapping(value = "/saveStockRetProducts")
	public int saveStockRetProducts(@RequestBody List<StockRetProducts> stk) throws Exception {

		return stkreturnService.saveStockRetProducts(stk);

	}

	@ResponseBody
	@RequestMapping(value = "/saveSRNGenJournal")
	public int saveGenJournal(@RequestBody Journal jrnl) throws Exception {

		return stkreturnService.saveGenJournal(jrnl);

	}

	@ResponseBody
	@RequestMapping("/viewSRStkTransfer")
	public List viewStkTransfer(@RequestBody IndCompModel loc) throws Exception {
		return stkreturnService.viewStkTransfer(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSRStkTransfProducts")
	public List viewStkTransfProducts(@RequestBody IndCompModel loc) throws Exception {
		return stkreturnService.viewStkTransfProducts(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStkReturnAll")
	public List viewStkReturnAll(@RequestBody IndCompModel loc) throws Exception {
		return stkreturnService.viewStkReturnAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStkReturnProds")
	public List viewStkReturnProds(@RequestBody IndCompModel loc) throws Exception {
		return stkreturnService.viewStkReturnProds(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteStockReturn")
	public int deleteStockReturn(@RequestBody IndCompModel loc) throws Exception {
		System.out.println(loc.getLocname() + "  " + loc.getLocrefid() + "  " + loc.getFrmint1());
		return stkreturnService.deleteStockReturn(loc);

	}

}
