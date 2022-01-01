/**
 * 
 */
package com.medeil.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Journal;
import com.medeil.domain.PurchaseApproval;
import com.medeil.domain.Stocks;
import com.medeil.service.PurchaseApprovalService;

/**
 * @author AjithKumar
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class PurchaseApprovalController {

	@Autowired
	private PurchaseApprovalService purchaseapprovalservice;

	@GetMapping(value = "getApprovalinvoice/{cid}/{bid}/{locrefid}/{locname}")
	public List getPurcinvoiceno(@PathVariable("cid") Integer cid, @PathVariable("bid") Integer bid,
			@PathVariable("locrefid") Integer locrefid, @PathVariable("locname") Integer locname) throws Exception {
		return purchaseapprovalservice.getPurcinvoiceno(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getPurcapprovaldata/{id}")
	public List getPurcApprovaldata(@PathVariable("id") Integer id) throws Exception {
		return purchaseapprovalservice.getPurcApprovaldata(id);
	}

//	/** CREATE APPROVAL LIST RECORD **/
//	@PostMapping(value = "savepurchaseApprovalRecord")
//	public boolean savepurchaseApproval(@RequestBody List<PurchaseApproval> purchaseApproval) throws Exception {
//		return purchaseapprovalservice.savepurchaseApproval(purchaseApproval);
//	}

	/** CREATE APPROVAL LIST RECORD **/
	@PostMapping(value = "savepurchaseApprovalRecord")
	public boolean savepurchaseApproval(@RequestBody List<Stocks> stock) throws Exception {
		return purchaseapprovalservice.savepurchaseApproval(stock);
	}

//	/** CREATE APPROVAL RECORD **/
//	@PostMapping(value = "savepurchaseApprovaldata")
//	public boolean savepurchaseApprovalrecords(@RequestBody PurchaseApproval purchaseApproval) throws Exception {
//		return purchaseapprovalservice.savepurchaseApprovalrecords(purchaseApproval);
//	}

	/** CREATE APPROVAL RECORD **/
	@PostMapping(value = "savepurchaseApprovaldata")
	public boolean savepurchaseApprovalrecords(@RequestBody PurchaseApproval purchaseApproval) throws Exception {
		return purchaseapprovalservice.savepurchaseApprovalrecords(purchaseApproval);
	}

	/** PURCHASE APPROVAL NUMBER AUTO INCREMENT **/ // Boopalan 030419
	/** @deprecated **/
	@GetMapping(value = "purchaseApprIncrement/{cid}/{bid}/{locname}/{locrefid}")
	public void purchaseApprIncrement(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		purchaseapprovalservice.purchaseApprIncrement(cid, bid, locname, locrefid);
	}

	@PostMapping(value = "savePAJournal")
	@Transactional
	public int savePIJournal(@RequestBody Journal jrnl) throws Exception {
		return purchaseapprovalservice.savePAJournal(jrnl);
	}

	@GetMapping(value = "getpurchasevendordetails/{id}")
	public List getVendordetails(@PathVariable("id") Integer id) throws Exception {
		return purchaseapprovalservice.getVendordetails(id);
	}
	
	@GetMapping(value = "getpurchaseduedetails/{cid}/{bid}/{lname}/{lrefid}")
	public ArrayList getPurchaseduelist(@PathVariable("cid") Integer cid,@PathVariable("bid") Integer bid,@PathVariable("lname") Integer lname,@PathVariable("lrefid") Integer lrefid) throws Exception {
		return purchaseapprovalservice.getPurchaseduelist(lname,lrefid);
	}
}
