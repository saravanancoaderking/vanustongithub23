/**
 * 
 */
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

import com.medeil.domain.Purchasesession;
import com.medeil.service.PurchasesessionService;

/**
 * @author Ajith Kumar
 *
 * 
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class PurchasesessionController {

	@Autowired
	private PurchasesessionService purchasesessionservice;

	@GetMapping(value = "getSessioncomp/{compid}")
	public List getSessionCompany(@PathVariable Integer compid) throws Exception {
		return purchasesessionservice.getSessionCompany(compid);
	}

	@GetMapping(value = "getSessionbranch/{cid}")
	public List getSessionBranch(@PathVariable("cid") Integer cid) throws Exception {
		return purchasesessionservice.getSessionBranch(cid);
	}

	@GetMapping(value = "getSessionshop/{cid}/{bid}")
	public List getSessionShop(@PathVariable("cid") Integer cid, @PathVariable("bid") List<Integer> bid)
			throws Exception {
		return purchasesessionservice.getSessionShop(cid, bid);
	}

	@GetMapping(value = "getSessionwarehouse/{cid}/{bid}")
	public List getSessionWarehouse(@PathVariable("cid") Integer cid, @PathVariable("bid") List<Integer> bid)
			throws Exception {
		return purchasesessionservice.getSessionWarehouse(cid, bid);
	}

	@GetMapping(value = "getSessionhosp/{cid}/{bid}")
	public List getSessionHospital(@PathVariable("cid") Integer cid, @PathVariable("bid") List<Integer> bid)
			throws Exception {
		return purchasesessionservice.getSessionHospital(cid, bid);
	}

	@GetMapping(value = "getpurcSessiontable/{sid}/{wid}/{hid}")
	public List getpurcSessionTable(@PathVariable("sid") List<Integer> sid, @PathVariable("wid") List<Integer> wid,
			@PathVariable("hid") List<Integer> hid) throws Exception {
		return purchasesessionservice.getpurcSessionTable(sid, wid, hid);
	}

	// Boopalan 030419
	@GetMapping(value = "getpurcSessionshoptable/{sid}/{cid}/{bid}/{locname}/{locrefid}")
	public List getpurcSessionShop(@PathVariable("sid") List<Integer> sid, @PathVariable Integer cid,
			@PathVariable Integer bid, @PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return purchasesessionservice.getpurcSessionShop(sid, cid, bid, locname, locrefid);
	}

	@GetMapping(value = "getpurcSessionwaretable/{wid}/{cid}/{bid}/{locname}/{locrefid}")
	public List getpurcSessionWarehouse(@PathVariable("wid") List<Integer> wid, @PathVariable Integer cid,
			@PathVariable Integer bid, @PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return purchasesessionservice.getpurcSessionWarehouse(wid, cid, bid, locname, locrefid);
	}

	@GetMapping(value = "getpurcSessionhosptable/{hid}/{cid}/{bid}/{locname}/{locrefid}")
	public List getpurcSessionHosp(@PathVariable("hid") List<Integer> hid, @PathVariable Integer cid,
			@PathVariable Integer bid, @PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return purchasesessionservice.getpurcSessionHosp(hid, cid, bid, locname, locrefid);
	}

	@GetMapping(value = "getpurcSessionview/{id}")
	public List getpurcSessionView(@PathVariable("id") Integer id) throws Exception {
		return purchasesessionservice.getpurcSessionView(id);
	}

	/** CREATE PURCHASE SESSION **/
	@PostMapping(value = "savePurcsession")
	@Transactional
	public boolean savePurchaseSession(@RequestBody Purchasesession purchasesession) throws Exception {
		return purchasesessionservice.savePurchaseSession(purchasesession);
	}

	/** CREATE PURCHASE SESSION TABLE PRODUCTS **/
	@PostMapping(value = "savePurcsessionproducts")
	@Transactional
	public boolean saveSessionproduct(@RequestBody List<Purchasesession> purchasesession) throws Exception {
		return purchasesessionservice.saveSessionproduct(purchasesession);
	}

	/** VIEW SESSION TABLE PRODUCTS **/
	@GetMapping(value = "getSessionview/{cid}/{bid}/{locname}/{locrefid}")
	public List getViewSessiontable(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return purchasesessionservice.getViewSessiontable(cid, bid, locname, locrefid);
	}

	@GetMapping(value = "getpurcSessiondetails/{id}")
	public List getSessionDetails(@PathVariable("id") Integer id) throws Exception {
		return purchasesessionservice.getSessionDetails(id);
	}

	@GetMapping(value = "getSessionchartdata")
	public List getSessionChart() throws Exception {
		return purchasesessionservice.getSessionChart();
	}

	@GetMapping(value = "getsessionall/{cid}/{bid}/{locname}/{locrefid}")
	public List getSessionAll(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return purchasesessionservice.getSessionAll(cid, bid, locname, locrefid);
	}

	// Boopalan 030419
	@Deprecated
	@GetMapping(value = "purchasesessionIncrement/{cid}/{bid}/{locrefid}/{locname}")
	public void getAutoIncrement(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		purchasesessionservice.getAutoIncrement(cid, bid, locname, locrefid);
	}

	// Get Hq data
	// Raja
	@GetMapping(value = "hqtabledata/{sid}/{cid}/{bid}/{locname}/{locrefid}")
	public List getpurcSessionhqShop(@PathVariable("sid") List<Integer> sid, @PathVariable Integer cid,
			@PathVariable Integer bid, @PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return purchasesessionservice.getpurcSessionhqShop(sid, cid, bid, locname, locrefid);
	}

	@GetMapping(value = "getpurcSessionnonwaiting/{sid}/{cid}/{bid}/{locname}/{locrefid}")
	public List getpurcSessionnonwaiting(@PathVariable Integer sid, @PathVariable Integer cid,
			@PathVariable Integer bid, @PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return purchasesessionservice.getpurcSessionnonwaiting(sid, cid, bid, locname, locrefid);
	}
}
