package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.domain.SDProducts;
import com.medeil.domain.SalesDummy;
import com.medeil.service.SDummyService;

@Controller
@RequestMapping("api/slsdum")
public class SDummyController {

	@Autowired
	SDummyService sdummyService;

	private final Logger log = LoggerFactory.getLogger(SDummyController.class);

	@ResponseBody
	@RequestMapping(value = "/saveSalesDummy", method = RequestMethod.POST)
	public int saveSalesDummy(@RequestBody SalesDummy so) throws Exception {

		return sdummyService.saveSalesDummy(so);

	}

	@ResponseBody
	@RequestMapping(value = "/saveSDProduct")
	public int saveSDProduct(@RequestBody List<SDProducts> so) throws Exception {

		return sdummyService.saveSDProduct(so);

	}

	@ResponseBody
	@RequestMapping(value = "/saveSalesJournal")
	public int saveSalesJournal(@RequestBody Journal jrnl) throws Exception {

		return sdummyService.saveSalesJournal(jrnl);

	}

	@ResponseBody
	@RequestMapping("/saveSDPresImage")
	public String savePresImage(@RequestParam("file") MultipartFile file, @RequestParam("locrefid") Double locrefid,
			@RequestParam("locrefid") Double locname) throws Exception {

		return sdummyService.savePresImage(file, locrefid, locname);

	}

	@ResponseBody
	@RequestMapping(value = "/updateSalesDummy")
	public int updateSalesDummy(@RequestBody SalesDummy so) throws Exception {

		return sdummyService.updateSalesDummy(so);

	}

	@ResponseBody
	@RequestMapping(value = "/updateSDProduct")
	public int updateSDProduct(@RequestBody List<SDProducts> so) throws Exception {

		return sdummyService.updateSDProduct(so);

	}

	@ResponseBody
	@RequestMapping("/viewSDCustomers")
	public List viewCustomers(@RequestBody IndCompModel loc) throws Exception {

		return sdummyService.viewCustomers(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSDDoctors")
	public List viewDoctors(@RequestBody IndCompModel loc) throws Exception {

		return sdummyService.viewDoctors(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesDummyAll")
	public List viewSalesDummyAll(@RequestBody IndCompModel loc) throws Exception {

		return sdummyService.viewSalesDummyAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesDummy")
	public List viewSalesDummy(@RequestBody IndCompModel loc) throws Exception {
		return sdummyService.viewSalesDummy(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSDProducts")
	public List viewSDProducts(@RequestBody IndCompModel loc) throws Exception {
		return sdummyService.viewSDProducts(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSDProductNames")
	public List viewProductNames(@RequestBody IndCompModel loc) throws Exception {
		return sdummyService.viewProductNames(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSDProductName")
	public List viewProductName(@RequestBody IndCompModel loc) throws Exception {
		return sdummyService.viewProductName(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSDBarCodeProd")
	public List viewBarCodeProd(@RequestBody IndCompModel loc) throws Exception {
		return sdummyService.viewBarCodeProd(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSDPriceSettings")
	public List viewPriceSettings(@RequestBody IndCompModel loc) throws Exception {
		return sdummyService.viewPriceSettings(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSDDiscountSettings")
	public List viewDiscountSettings(@RequestBody IndCompModel loc) throws Exception {
		return sdummyService.viewDiscountSettings(loc);

	}

	@ResponseBody
	@RequestMapping("/viewInvoiceNoInc")
	public StringBuilder viewInvoiceNoInc(@RequestBody IndCompModel loc) throws Exception {
		return sdummyService.viewInvoiceNoInc(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteSalesDummy")
	public int deleteSalesDummy(@RequestBody IndCompModel loc) throws Exception {
		return sdummyService.deleteSalesDummy(loc);

	}

}
