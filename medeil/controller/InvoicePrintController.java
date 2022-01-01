package com.medeil.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medeil.service.InvoicePrintService;

@SuppressWarnings("rawtypes")
@RestController

@RequestMapping("api")
public class InvoicePrintController {

	@Autowired
	InvoicePrintService invoicePrintService;

	@GetMapping(value = "/getinvoiceprint/{compid}/{branchid}/{locname}/{locrefid}/{shopid}")
	public List invoicePrint(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer shopid) throws Exception {
		return invoicePrintService.getInvoice(compid, branchid, locname, locrefid, shopid);
	}

	@GetMapping(value = "/getinvoicedetail/{compid}/{branchid}/{locname}/{locrefid}/{pono}")

	public List invoiceDetail(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer pono) throws Exception {

		System.out.println("Succes");
		return invoicePrintService.getInvoiceDetail(compid, branchid, locname, locrefid, pono);

	}

}
