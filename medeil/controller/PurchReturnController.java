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
import com.medeil.domain.PrProducts;
import com.medeil.domain.PurchaseReturn;
import com.medeil.service.PatientService;
import com.medeil.service.PurchReturnService;

@Controller
@RequestMapping("api/pr")
public class PurchReturnController {

	@Autowired
	PurchReturnService prService;

	private final Logger log = LoggerFactory.getLogger(PatientService.class);

	@ResponseBody
	@RequestMapping(value = "/savePurchReturn")
	public int savePurchReturn(@RequestBody PurchaseReturn cust) throws Exception {

		return prService.savePurchReturn(cust);

	}

	@ResponseBody
	@RequestMapping(value = "/savePrProducts")
	public int savePrProducts(@RequestBody List<PrProducts> pr) throws Exception {

		return prService.savePrProducts(pr);

	}

	@ResponseBody
	@RequestMapping("/saveDebitNote")
	public int saveDebitNote(@RequestBody Journal jrnl) throws Exception {

		return prService.saveDebitNote(jrnl);

	}

	@ResponseBody
	@RequestMapping("/updatePurchReturn")
	public int updatePurchReturn(@RequestBody PurchaseReturn cust) throws Exception {

		return prService.updatePurchReturn(cust);

	}

	@ResponseBody
	@RequestMapping(value = "/updatePrProducts")
	public int updatePrProducts(@RequestBody List<PrProducts> pr) throws Exception {

		return prService.updatePrProducts(pr);

	}

	@ResponseBody
	@RequestMapping("/viewPurcInvoicesNo")
	public List viewPurcInvoices(@RequestBody IndCompModel loc) throws Exception {
		return prService.viewPurcInvoicesNo(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPurcInvoice")
	public List viewPurcInvoice(@RequestBody IndCompModel loc) throws Exception {

		return prService.viewPurcInvoice(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPiProduct")
	public List viewPiProduct(@RequestBody IndCompModel loc) throws Exception {
		return prService.viewPiProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPurchReturnNo")
	public List viewPurchReturnAll(@RequestBody IndCompModel loc) throws Exception {
		return prService.viewPurchReturnNo(loc);

	}

	@ResponseBody // Boopalan 060519
	@RequestMapping("/viewPurchaseReturn")
	public List viewPurchaseReturn(@RequestBody IndCompModel loc) throws Exception {

		return prService.viewPurchaseReturn(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPrProduct")
	public List viewPrProduct(@RequestBody IndCompModel loc) throws Exception {
		return prService.viewPrProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/deletePurchReturn")
	public int deletePurchReturn(@RequestBody IndCompModel loc) throws Exception {
		return prService.deletePurchReturn(loc);

	}

	/*** Purchase Return Save VendorID ***/ // Boopalan 020519
	@ResponseBody
	@RequestMapping("/savevendoridPurchReturn")
	public List saveVendoridPurchReturn(@RequestBody IndCompModel loc) throws Exception {
		return prService.saveVendoridPurchReturn(loc);

	}
}
