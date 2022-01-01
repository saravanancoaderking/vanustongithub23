package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.SDProducts;
import com.medeil.domain.SalesDummy;
import com.medeil.service.PerInvService;

@Controller
@RequestMapping("api/perinv")
public class PerInvController {

	@Autowired
	PerInvService perinvService;

	private final Logger log = LoggerFactory.getLogger(PerInvController.class);

	@ResponseBody
	@RequestMapping(value = "/saveSalesInvoice", method = RequestMethod.POST)
	public int saveSalesInvoice(@RequestBody SalesDummy si) throws Exception {

		return perinvService.saveSalesInvoice(si);

	}

	@ResponseBody
	@RequestMapping(value = "/saveSIProduct")
	public int saveSIProduct(@RequestBody List<SDProducts> si) throws Exception {

		return perinvService.saveSIProduct(si);

	}

	@ResponseBody
	@RequestMapping(value = "/saveSalesJournal")
	public int saveSalesJournal(@RequestBody Journal jrnl) throws Exception {

		perinvService.saveSalesJournal(jrnl);

		return 1;

	}

	@ResponseBody
	@RequestMapping("/saveTempStock")
	public int saveTempStock(@RequestBody IndCompModel loc) throws Exception {

		return perinvService.saveTempStock(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/updateSalesInvoice", method = RequestMethod.POST)
	public int updateSalesInvoice(@RequestBody SalesDummy si) throws Exception {

		return perinvService.updateSalesInvoice(si);

	}

	@ResponseBody
	@RequestMapping(value = "/updateSIProduct")
	public int updateSIProduct(@RequestBody List<SDProducts> si) throws Exception {

		return perinvService.updateSIProduct(si);

	}

	@ResponseBody
	@RequestMapping("/updateTempStockMain")
	public int updateTempStockMain(@RequestBody IndCompModel loc) throws Exception {

		return perinvService.updateTempStockMain(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSICustomers")
	public List viewCustomers(@RequestBody IndCompModel loc) throws Exception {

		return perinvService.viewCustomers(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIDoctors")
	public List viewDoctors(@RequestBody IndCompModel loc) throws Exception {

		return perinvService.viewDoctors(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesInvoiceAll")
	public List viewSalesInvoiceAll(@RequestBody IndCompModel loc) throws Exception {

		return perinvService.viewSalesInvoiceAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSISalesInvoice")
	public List viewSalesInvoice(@RequestBody IndCompModel loc) throws Exception {
		return perinvService.viewSalesInvoice(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIProducts")
	public List viewSIProducts(@RequestBody IndCompModel loc) throws Exception {
		return perinvService.viewSIProducts(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIProductNames")
	public List viewProductNames(@RequestBody IndCompModel loc) throws Exception {
		return perinvService.viewProductNames(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIProductName")
	public List viewProductName(@RequestBody IndCompModel loc) throws Exception {
		return perinvService.viewProductName(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIPriceSettings")
	public List viewPriceSettings(@RequestBody IndCompModel loc) throws Exception {
		return perinvService.viewPriceSettings(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSIDiscountSettings")
	public List viewDiscountSettings(@RequestBody IndCompModel loc) throws Exception {
		return perinvService.viewDiscountSettings(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesInvCustAll")
	public List viewSalesInvCustAll(@RequestBody IndCompModel loc) throws Exception {
		return perinvService.viewSalesInvCustAll(loc);

	}

}
