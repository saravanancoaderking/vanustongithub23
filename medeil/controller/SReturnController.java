package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.SReturnProd;
import com.medeil.domain.SalesReturn;
import com.medeil.service.SReturnService;

@Controller
@RequestMapping("api/slsretn")
public class SReturnController {

	@Autowired
	SReturnService sreturnService;

	private final Logger log = LoggerFactory.getLogger(SReturnController.class);

	@ResponseBody
	@RequestMapping(value = "/saveSalesReturn")
	public int saveSalesReturn(@RequestBody SalesReturn sr) throws Exception {
		return sreturnService.saveSalesReturn(sr);
	}

	@ResponseBody
	@RequestMapping(value = "/saveSrProducts")
	public int saveSrProducts(@RequestBody List<SReturnProd> sr) throws Exception {

		return sreturnService.saveSrProducts(sr);

	}

	@ResponseBody
	@RequestMapping(value = "/saveCreditNote")
	public int saveCreditNote(@RequestBody Journal jrnl) throws Exception {

		return sreturnService.saveCreditNote(jrnl);

	}

	@ResponseBody
	@RequestMapping("/updateSalesReturn")
	public int updateSalesReturn(@RequestBody SalesReturn sr) throws Exception {

		return sreturnService.updateSalesReturn(sr);

	}

	@ResponseBody
	@RequestMapping(value = "/updateSrProducts")
	public int updateSrProducts(@RequestBody List<SReturnProd> sr) throws Exception {

		return sreturnService.updateSrProducts(sr);

	}

	@ResponseBody
	@RequestMapping("/viewSalesInvoiceNo")
	public List viewSalesInvoiceNo(@RequestBody IndCompModel loc) throws Exception {
		return sreturnService.viewSalesInvoiceNo(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesInvoice")
	public List viewSalesInvoice(@RequestBody IndCompModel loc) throws Exception {

		return sreturnService.viewSalesInvoice(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIProduct")
	public List viewSIProduct(@RequestBody IndCompModel loc) throws Exception {
		return sreturnService.viewSIProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesReturnAll")
	public List viewSalesReturnAll(@RequestBody IndCompModel loc) throws Exception {

		return sreturnService.viewSalesReturnAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesReturn")
	public List viewSalesReturn(@RequestBody IndCompModel loc) throws Exception {
		return sreturnService.viewSalesReturn(loc);
	}
	
	@ResponseBody
	@RequestMapping("/viewSalesReturnProducts")
	public List viewSalesReturnProducts(@RequestBody IndCompModel loc) throws Exception {
		return sreturnService.viewSalesReturnProducts(loc);
	}

	@ResponseBody
	@RequestMapping("/viewSrProduct")
	public List viewPrProduct(@RequestBody IndCompModel loc) throws Exception {
		return sreturnService.viewSrProduct(loc);
	}

	@ResponseBody
	@RequestMapping("/viewSrProductRemain")
	public List viewSrProductRemain(@RequestBody IndCompModel loc) throws Exception {
		return sreturnService.viewSrProductRemain(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteSalesRetn")
	public int deleteSalesRetn(@RequestBody IndCompModel loc) throws Exception {
		return sreturnService.deleteSalesRetn(loc);

	}

}
