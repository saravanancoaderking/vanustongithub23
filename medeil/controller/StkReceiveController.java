package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.StockRecProd;
import com.medeil.domain.StockReceive;
import com.medeil.service.StkReceiveService;

@Controller
@RequestMapping("api/stkrec")
public class StkReceiveController {

	@Autowired
	StkReceiveService stkreceiveService;

	@ResponseBody
	@RequestMapping(value = "/saveStockReceive")
	public int saveStockReceive(@RequestBody StockReceive stk) throws Exception {

		return stkreceiveService.saveStockReceive(stk);

	}

	@ResponseBody
	@RequestMapping(value = "/saveStkRecProducts")
	public int saveStkRecProducts(@RequestBody List<StockRecProd> stk) throws Exception { 

		return stkreceiveService.saveStkRecProducts(stk);

	}

	@ResponseBody
	@RequestMapping(value = "/saveSRCGenJournal")
	public int saveGenJournal(@RequestBody Journal jrnl) throws Exception {

		return stkreceiveService.saveGenJournal(jrnl);

	}

	@ResponseBody
	@RequestMapping("/viewStkTransfer")
	public List viewStkTransfer(@RequestBody IndCompModel loc) throws Exception {
		return stkreceiveService.viewStkTransfer(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStkTransfProducts")
	public List viewStkTransfProducts(@RequestBody IndCompModel loc) throws Exception {
		return stkreceiveService.viewStkTransfProducts(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStkReceiveAll")
	public List viewStkReceiveAll(@RequestBody IndCompModel loc) throws Exception {
		return stkreceiveService.viewStkReceiveAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStkReceiveNo")
	public List viewStkReceiveNo(@RequestBody IndCompModel loc) throws Exception {
		return stkreceiveService.viewStkReceiveNo(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStkReceiveProds")
	public List viewStkReceiveProds(@RequestBody IndCompModel loc) throws Exception {
		return stkreceiveService.viewStkReceiveProds(loc);

	}

}
