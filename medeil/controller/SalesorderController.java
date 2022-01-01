/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.SalesOrderRecord;
import com.medeil.domain.Salesorder;
//import com.medeil.domain.SalesOrderRecord;
//import com.medeil.domain.Salesorder;
import com.medeil.service.SalesorderService;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class SalesorderController {

	@Autowired
	private SalesorderService salesorderService;

	@GetMapping(value = "salesOrderIncrement/{cid}/{bid}/{locrefid}/{locname}")
	public List getAutoIncrement(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return salesorderService.getAutoIncrement(cid, bid, locrefid, locname);
	}

	// Boopalan 300719
	@GetMapping(value = "searchSalesorderproduct/{data}/{cid}/{bid}/{locrefid}/{locname}")
	public List searchProduct(@PathVariable String data, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return salesorderService.searchProduct(data, cid, bid, locrefid, locname);
	}

	@GetMapping(value = "salesorderCustomerlist/{cid}/{bid}/{locrefid}/{locname}")
	public List patientList(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return salesorderService.patientList(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getsalesProduct/{productid}")
	public List getProductdata(@PathVariable Integer productid) throws Exception {
		return salesorderService.getProductdata(productid);
	}

	@PostMapping(value = "saveSalesorder")
	public Boolean createSalesOrder(@RequestBody Salesorder salesorder) throws Exception {
		return salesorderService.createSalesOrder(salesorder);
	}

	@PostMapping(value = "saveSalesorderRecord")
	public Boolean createSalesOrderRecord(@RequestBody List<SalesOrderRecord> salesorder) throws Exception {
		return salesorderService.createSalesOrderRecord(salesorder);
	}

	@GetMapping(value = "getsalesorderview/{drugID}")
	public List viewSalesOrder(@PathVariable Integer drugID) throws Exception {
		return salesorderService.viewSalesOrder(drugID);
	}

	@GetMapping(value = "getallSalesorderview/{cid}/{bid}/{locrefid}/{locname}")
	public List getAll(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return salesorderService.getAll(cid, bid, locrefid, locname);
	}

	// puthiran
	@GetMapping(value = "getomniSalesorderview/{cid}/{bid}/{locrefid}/{locname}")
	public List getomnisalesAll(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return salesorderService.getomnisalesAll(cid, bid, locrefid, locname);
	}

	/** EDIT SALES ORDER */
	@GetMapping(value = "editSalesorderdata/{id}")
	public Salesorder editSalesOrder(@PathVariable Integer id) throws Exception {
		return salesorderService.editSalesOrder(id);
	}

	@GetMapping(value = "editSalesorderRecord/{id}")
	public List editSalesRecord(@PathVariable Integer id) throws Exception {
		return salesorderService.editSalesRecord(id);
	}

	@PostMapping(value = "updateSalesorder")
	public Boolean updateSalesorderData(@RequestBody Salesorder salesorder) throws Exception {
		return salesorderService.updateSalesorderData(salesorder);
	}

	@PostMapping(value = "updateSalesorderRecord")
	public Boolean updateSalesRecord(@RequestBody List<SalesOrderRecord> salesorder) throws Exception {
		return salesorderService.updateSalesRecord(salesorder);
	}

	/* Get sales Order Type Boo */
	@GetMapping(value = "salesOrderType")
	public List getsalesOrderType() throws Exception {
		return salesorderService.getsalesOrderType();
	}

	/** DELETE SALES ORDER */ // Boo
	@GetMapping(value = "/deletesalesOrder/{soid}")
	public boolean deleteSalesOrder(@PathVariable int soid) throws Exception {
		return salesorderService.deleteSalesOrder(soid);
	}

	// padmini

	@GetMapping(value = "CustomerSearch/{data}/{cid}/{bid}/{locrefid}/{locname}")
	public List CustomerSearch(@PathVariable String data, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return salesorderService.CustomerSearch(data, cid, bid, locrefid, locname);
	}

	@GetMapping(value = "CustsalesOrder1/{data}/{cid}/{bid}/{locrefid}/{locname}")
	public List CustsalesOrder(@PathVariable Integer data, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return salesorderService.CustsalesOrder(data, cid, bid, locrefid, locname);
	}

	@GetMapping(value = "CustsalesOrderstatus/{data}/{cid}/{bid}/{locrefid}/{locname}")
	public List CustsalesOrderstatus(@PathVariable Integer data, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return salesorderService.CustsalesOrderstatus(data, cid, bid, locrefid, locname);
	}

	// Kishore 140919
	@GetMapping(value = "getAllList/{cid}/{bid}/{locrefid}/{locname}")
	public List getAllList(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return salesorderService.getAllList(cid, bid, locrefid, locname);
	}

	// Boopalan 210919
	@GetMapping(value = "getSalesOrderRefIDDetails/{soid}")
	public List getSalesOrderRefIDDetails(@PathVariable Integer soid) throws Exception {
		return salesorderService.getSalesOrderRefIDDetails(soid);
	}

	// customer tracking
	@GetMapping(value = "custtracking/{cid}/{bid}/{locname}/{locrefid}/{orderid}")
	public List getCusttrack(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer orderid) throws Exception {
		return salesorderService.getCusttrack(cid, bid, locname, locrefid, orderid);
	}

	// view sales order
	@GetMapping(value = "viewtracksalesorder/{cid}/{bid}/{locname}/{locrefid}/{orderid}")
	public List viewsalesorder(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer orderid) throws Exception {
		return salesorderService.viewsalesorder(cid, bid, locname, locrefid, orderid);
	}

	@GetMapping(value = "custsalesOrdermobile/{data}/{cid}/{bid}/{locrefid}/{locname}")
	public List CustsalesOrdermobile(@PathVariable Integer data, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return salesorderService.custsalesOrdermobile(data, cid, bid, locrefid, locname);
	}

}
