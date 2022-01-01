package com.medeil.controller;

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
import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.service.PurchaseService;

/**
 * @author Ajith
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@GetMapping(value = "getpiDistibutor/{cid}/{bid}/{locrefid}/{locname}")
	public List getDistributor(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return purchaseService.getDistributor(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getpiDistvalues/{distid}")
	public List getDistvalues(@PathVariable Integer distid) throws Exception {
		return purchaseService.getDistvalues(distid);
	}

	@GetMapping(value = "getPibrandlist/{val}/{cid}/{bid}/{locrefid}/{locname}")
	public List getBrandlist(@PathVariable String val, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return purchaseService.getBrandlist(val, cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getPitablevalues/{data}/{cid}/{bid}/{locrefid}/{locname}")
	public List getPitabledata(@PathVariable Integer data, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return purchaseService.getPitabledata(data, cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getPurchasetax/{cid}/{bid}/{locrefid}/{locname}")
	public List getPurTax(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return purchaseService.getPurTax(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getPurquantity/{id}")
	public List getQuantity(@PathVariable Integer id) throws Exception {
		return purchaseService.getQuantity(id);
	}

	/** CREATE PURCHASE MAINTENANCE RECORD **/
	@PostMapping(value = "createPurcrecord")
//	@Transactional
	public boolean createRecord(@RequestBody Purchase purchase) throws Exception {
		return purchaseService.createRecord(purchase);
	}

	/** CREATE PURCHASE INVOICE RECORD **/
	@PostMapping(value = "createPurctablerecord")
//	@Transactional
	public boolean createPurcinvoice(@RequestBody List<PurchaseInvoice> purchaseinvoice) throws Exception {
		return purchaseService.createPurcinvoice(purchaseinvoice);
	}

	/** VIEW PURCHASE INVOICE RECORD **/

	@GetMapping(value = "viewPurchasemaintance/{cid}/{bid}/{locrefid}/{locname}")
	public List getViewinvoice(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return purchaseService.getViewinvoice(cid, bid, locrefid, locname);
	}

	/** EDIT PURCHASE INVOICE RECORD **/ // Boopalan 150419

	@GetMapping(value = "getEditpurchase/{id}")
	public List getEditpurchase(@PathVariable("id") Integer id) throws Exception {
		return purchaseService.getEditpurchase(id);
	}

	@GetMapping(value = "getEditpurchasemaintance/{id}")
	public List getEditpurcMaintance(@PathVariable("id") Integer id) throws Exception {
		return purchaseService.getEditpurcMaintance(id);
	}

	/** UPDATE PURCHASE MAINTENANCE RECORD **/
	@PostMapping(value = "updatePurcrecord")
	@Transactional
	public boolean updatepurcRecord(@RequestBody Purchase purchase) throws Exception {
		return purchaseService.updateRecord(purchase);
	}

	@PostMapping(value = "updatePurctablerecord")
	@Transactional
	public boolean updatePurcinvoice(@RequestBody List<PurchaseInvoice> purchaseinvoice) throws Exception {
		return purchaseService.updatePurcinvoice(purchaseinvoice);
	}

	/** DELETE PURCHASE INVOICE **/
	@GetMapping(value = "deletepurchaseRecord/{id}")
	public void deletePurchaseinvoice(@PathVariable("id") Integer id) throws Exception {
		purchaseService.deletePurchaseinvoice(id);
	}

	/** PURCHASE ORDER CONVERT **/
	@GetMapping(value = "purchaseorderlist/{cid}/{bid}/{locrefid}/{locname}")
	public List getPurchaseOrder(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return purchaseService.getPurchaseOrder(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "purchaseordertable/{pid}")
	public List getPurchaseOrdertable(@PathVariable("pid") Integer pid) throws Exception {
		return purchaseService.getPurchaseOrdertable(pid);
	}

	@GetMapping(value = "getTaxmaster/{cid}/{bid}/{locrefid}/{locname}")
	public List chechTaxmaster(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return purchaseService.chechTaxmaster(cid, bid, locrefid, locname);
	}

	/** @deprecated **/
	@GetMapping(value = "purchaseIncrement/{cid}/{bid}/{locrefid}/{locname}")
	public void getAutoIncrement(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		purchaseService.getAutoIncrement(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getPOdist/{pid}")
	public List getdist(@PathVariable Integer pid) throws Exception {
		return purchaseService.getdist(pid);
	}

	/** PURCHASE INVOICE LIST **/ // Boopalan 090419
	@GetMapping(value = "purchaseinvoicelist/{cid}/{bid}/{locname}/{locrefid}")
	public List getPurchaseInvoiceList(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return purchaseService.getPurchaseInvoiceList(cid, bid, locname, locrefid);
	}

	/** GET EDIT POID PURCHASE INVOICE **/ // Boopalan 230519
	@GetMapping(value = "getpoidpi/{piid}")
	public List getpoidpi(@PathVariable Integer piid) throws Exception {
		return purchaseService.getpoidpi(piid);
	}

	@PostMapping(value = "savePIJournal")
	@Transactional
	public int savePIJournal(@RequestBody Journal jrnl) throws Exception {
		return purchaseService.savePIJournal(jrnl);
	}

	/** GET Dist Delivery Chellan **/
	@GetMapping(value = "getDistDc/{cmpid}/{brnchid}/{lname}/{lrefid}/{poid}")
	public List getdistdc(@PathVariable Integer cmpid, @PathVariable Integer brnchid, @PathVariable Integer lname,
			@PathVariable Integer lrefid, @PathVariable Integer poid) throws Exception {
		return purchaseService.getdistdc(cmpid, brnchid, lname, lrefid, poid);
	}

	/** GET Dist Delivery Chellan **/
	@GetMapping(value = "getDistDcpro/{cmpid}/{brnchid}/{lname}/{lrefid}/{poid}/{dcrefid}")
	public List getdcproducts(@PathVariable Integer cmpid, @PathVariable Integer brnchid, @PathVariable Integer lname,
			@PathVariable Integer lrefid, @PathVariable Integer poid, @PathVariable Integer dcrefid) throws Exception {
		return purchaseService.getdcproducts(cmpid, brnchid, lname, lrefid, poid, dcrefid);
	}

	/** GET purchase journal **/
	@GetMapping(value = "getPurjrnl/{cmpid}/{brnchid}/{lname}/{lrefid}/{invoiceno}")
	public Journal getPurjournal(@PathVariable Integer cmpid, @PathVariable Integer brnchid, @PathVariable Double lname,
			@PathVariable Double lrefid, @PathVariable Integer invoiceno) throws Exception {
		return purchaseService.getPurjournal(cmpid, brnchid, lname, lrefid, invoiceno);
	}
	
	/** GET Hsn code List **/
	@GetMapping(value = "/getHsncode")
	public List getHsncodelist() throws Exception {	
		return purchaseService.getHsncodelist();
	}
}
