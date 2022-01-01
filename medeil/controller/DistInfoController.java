
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.DistService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class DistInfoController {
	@Autowired
	DistService distInfoService;

	@GetMapping(value = "/getdistinfo/{comid}/{branchid}/{locname}/{locrefid}")
	public List getDistInfo(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return distInfoService.getDistInfo(comid, branchid, locname, locrefid);
	}

//	@GetMapping(value = "/getdistinfo/{cid}")
//	public List getDistInfo(@PathVariable Integer cid) {
//		return distInfoService.getDistInfo(cid);
//	}
	// Desing 040419 Inventory Report/StkTrans by Product
	@GetMapping(value = "/stktrnsfer/{cid}/{bid}/{lnid}/{lrid}")

	public List getstktrnsInfo(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lnid,
			@PathVariable Integer lrid) throws Exception {
		return distInfoService.getstktrnsInfo(cid, bid, lnid, lrid);

	}

	// Desing 040419 Inventory Report/Requisition No by Product
	@GetMapping(value = "/IndentReqNo/{cid}/{bid}/{lnid}/{lrid}")
	public List getIndentReqInfo(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lnid,
			@PathVariable Integer lrid) throws Exception {
		return distInfoService.getIndentReqInfo(cid, bid, lnid, lrid);
	}

	// Desing 120419 Purchase Report/BatchNamewise Purchase
	@GetMapping(value = "/batchname/{str}/{cid}/{bid}/{lnid}/{lrid}")
	public List getBatchNameInfo(@PathVariable String str, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer lnid, @PathVariable Integer lrid) throws Exception {
		return distInfoService.getBatchNameInfo(str, cid, bid, lnid, lrid);
	}

	// Desing 070519 Purchase Report/PurchaseInvoicewise
	@GetMapping(value = "/purchaseinvoice/{cid}/{bid}/{lnid}/{lrid}")
	public List getPurInvoiceInfo(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lnid,
			@PathVariable Integer lrid) throws Exception {
		return distInfoService.getPurInvoiceInfo(cid, bid, lnid, lrid);
	}

	
	
	
}
