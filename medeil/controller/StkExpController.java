package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.Shortexpirysettings;
import com.medeil.domain.StockExpiry;
import com.medeil.service.StkExpService;

@Controller
@RequestMapping("api/stockexp")
public class StkExpController {

	@Autowired
	StkExpService stkexpService;

	private final Logger log = LoggerFactory.getLogger(StkExpController.class);

	@ResponseBody
	@RequestMapping(value = "/saveStockExpiry")

	public int saveStockExpiry(@RequestBody List<StockExpiry> stk) throws Exception {

		return stkexpService.saveStockExpiry(stk);

	}

	@ResponseBody
	@RequestMapping(value = "/updateStockExpiry")
	public int updateStockExpiry(@RequestBody List<StockExpiry> stk) throws Exception {
		return stkexpService.updateStockExpiry(stk);

	}

	@ResponseBody
	@RequestMapping("/viewSPMainstocks")
	public List viewMainstocks(@RequestBody IndCompModel loc) throws Exception {
		return stkexpService.viewMainstocks(loc);

	}

	@ResponseBody
	@RequestMapping("/viewSPMainstock")
	public List viewMainstock(@RequestBody IndCompModel loc) throws Exception {

		return stkexpService.viewMainstock(loc);

	}

	@ResponseBody
	@RequestMapping("/viewMainstockExpiry")
	public List viewMainstockExpiry(@RequestBody IndCompModel loc) throws Exception {
		System.out.println("ViewMainstockController");

		return stkexpService.viewMainstockExpiry(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStockExpAll")
	public List viewStockExpAll(@RequestBody IndCompModel loc) throws Exception {
		return stkexpService.viewStockExpAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStockExpiry")
	public List viewStockExpiry(@RequestBody IndCompModel loc) throws Exception {
		return stkexpService.viewStockExpiry(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteStockExpiry")
	public int deleteStockExpiry(@RequestBody IndCompModel loc) throws Exception {
		return stkexpService.deleteStockExpiry(loc);

	}

	// DesingRaja
	// Short Expiry
	@ResponseBody
	@RequestMapping("/saveses")
	public int saveexpset(@RequestBody Shortexpirysettings ses) throws Exception {
		System.out.println("Short Expiry Controll Raja");
		System.out.println(ses);

		return stkexpService.minimumstkexp(ses);
	}

	// DesingRaja
	@ResponseBody
	@RequestMapping(value = "getdata/{comid}/{branchid}/{locname}/{locrefid}")
	public List getexpdata(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		System.out.println(comid + " " + branchid + " " + locname + " " + locrefid);
		return stkexpService.getsedata(comid, branchid, locname, locrefid);
	}

	// DesingRaja
	@ResponseBody
	@RequestMapping("destprod/{stockid}/{prodid}/{compid}/{branchid}/{locname}/{locrefid}")
	public boolean destroy(@PathVariable Integer stockid, @PathVariable Integer prodid, @PathVariable Integer compid,
			@PathVariable Integer branchid, @PathVariable Integer locname, @PathVariable Integer locrefid)
			throws Exception {
		System.out.println(stockid + " " + prodid + "  " + compid + " " + locrefid);
		return stkexpService.dest(stockid, prodid, compid, branchid, locname, locrefid);
	}

	// Deasinguraja Short Expiry
	@ResponseBody
	@RequestMapping("shortexpsatatus/{compid}/{branchid}/{locname}/{locrefid}")
	public List shortexpstatus(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("shortexpsatatus" + locrefid);
		return stkexpService.shortexp(compid, branchid, locname, locrefid);
	}

}
