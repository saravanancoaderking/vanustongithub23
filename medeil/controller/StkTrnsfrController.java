package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;

import com.medeil.domain.StockTrnfrProd;
import com.medeil.domain.StockTransfer;
import com.medeil.service.StkTrnsfrService;

@Controller
@RequestMapping("api/stocktrans")
public class StkTrnsfrController {

	@Autowired
	StkTrnsfrService stktrnsfrService;

	@ResponseBody
	@RequestMapping(value = "/saveStockTransfer")
	public int saveStockTransfer(@RequestBody StockTransfer stk) throws Exception {

		return stktrnsfrService.saveStockTransfer(stk);

	}

	@ResponseBody
	@RequestMapping(value = "/saveStkTrnfrProducts")
	public int saveStkTrnfrProducts(@RequestBody List<StockTrnfrProd> stk) throws Exception {

		return stktrnsfrService.saveStkTrnfrProducts(stk);

	}

	@ResponseBody
	@RequestMapping("/viewSTIndentRequests")
	public List viewIndentRequests(@RequestBody IndCompModel loc) throws Exception {
		return stktrnsfrService.viewIndentRequests(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSTIndentProduct")
	public List viewIndentProduct(@RequestBody IndCompModel loc) throws Exception {
		return stktrnsfrService.viewIndentProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSTIndMainstock")
	public List viewIndMainstock(@RequestBody IndCompModel loc) throws Exception {

		return stktrnsfrService.viewIndMainstock(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSTMainstocks")
	public List viewMainstocks(@RequestBody IndCompModel loc) throws Exception {
		return stktrnsfrService.viewMainstocks(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSTMainstock")
	public List viewMainstock(@RequestBody IndCompModel loc) throws Exception {

		return stktrnsfrService.viewMainstock(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStkTrnfrAll")
	public List viewStkTrnfrAll(@RequestBody IndCompModel loc) throws Exception {

		return stktrnsfrService.viewStkTrnfrAll(loc);
	}

	@ResponseBody
	@RequestMapping("/viewStkTransferNo")
	public List viewStkTransferNo(@RequestBody IndCompModel loc) throws Exception {

		return stktrnsfrService.viewStkTransferNo(loc);
	}

	@ResponseBody
	@RequestMapping("/viewStkTransfProducts")
	public List viewStkTransfProducts(@RequestBody IndCompModel loc) throws Exception {

		return stktrnsfrService.viewStkTransfProducts(loc);
	}

}
