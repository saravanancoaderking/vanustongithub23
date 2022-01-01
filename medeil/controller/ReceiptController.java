package com.medeil.controller;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Journal;
import com.medeil.service.ReceiptService;

@RestController
@Transactional
@RequestMapping("api/receipt")
public class ReceiptController {

	@Autowired
	ReceiptService receiptService;

	private final Logger log = LoggerFactory.getLogger(ReceiptController.class);

	@ResponseBody
	@RequestMapping(value = "/saveReceipt")
	public int saveReceipt(@RequestBody List<Journal> pt) throws Exception {

		return receiptService.saveReceipt(pt);
	}

	@ResponseBody
	@RequestMapping("/updateReceipt")
	public int updateReceipt(@RequestBody Journal pt) throws Exception {

		return receiptService.updateReceipt(pt);

	}

	@ResponseBody
	@RequestMapping("/saveBulkReceipt")
	public int saveBulkReceipt(@RequestBody List<Journal> rt) throws Exception {

		return receiptService.saveBulkReceipt(rt);

	}

	@ResponseBody
	@RequestMapping("/viewRTAccounts")
	public List viewAccounts(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewAccounts(loc);

	}

	@ResponseBody
	@RequestMapping("/viewRTAccount")
	public List viewAccount(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewAccount(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesInvoiceNo")
	public List viewSalesInvoiceNo(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewSalesInvoiceNo(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSalesInvoice")
	public List viewSalesInvoice(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewSalesInvoice(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCustomerSalesInvoice")
	public List viewCustomerSalesInvoice(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewCustomerSalesInvoice(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPurchaseReturnNo")
	public List viewPurchaseReturnNo(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewPurchaseReturnNo(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPurchaseReturn")
	public List viewPurchaseReturn(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewPurchaseReturn(loc);

	}

	@ResponseBody
	@RequestMapping("/viewReceiptAll")
	public List viewReceiptAll(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewReceiptAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewReceipt")
	public List viewReceipt(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewReceipt(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCustomers")
	public List viewCustomers(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewCustomers(loc);

	}

	@ResponseBody
	@RequestMapping("/viewCustOutstanding")
	public List viewCustOutstanding(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.viewCustOutstanding(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteReceipt")
	public int deleteReceipt(@RequestBody IndCompModel loc) throws Exception {
		return receiptService.deleteReceipt(loc);

	}

}
