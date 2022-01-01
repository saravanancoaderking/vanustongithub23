package com.medeil.controller;

/**
 * @author Boopalan Alagesan
 *
 */

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.DashBoardService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class DashBoardController {

	@Autowired
	DashBoardService dashBoardService;

	@GetMapping(value = "/getsalesordertype/{compid}/{branchid}/{locname}/{locrefid}")
	public List getsalesordertype(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return dashBoardService.getsalesordertype(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getsaleschart/{compid}/{branchid}/{locname}/{locrefid}/{clientcdate1}")
	public List getsaleschart(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String clientcdate1) throws Exception {
		return dashBoardService.getsaleschart(compid, branchid, locname, locrefid, clientcdate1);
	}

	@GetMapping(value = "/getpurchasechart/{compid}/{branchid}/{locname}/{locrefid}/{clientcdate1}")
	public List getpurchasechart(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String clientcdate1) throws Exception {
		return dashBoardService.getpurchasechart(compid, branchid, locname, locrefid, clientcdate1);
	}

	@GetMapping(value = "/getpurchaseinvoicevalue/{compid}/{branchid}/{locname}/{locrefid}")
	public List getPurchaseValue(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return dashBoardService.getPurchaseValue(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/purchasebyshop/{compid}/{branchid}/{locname}/{locrefid}/{clientcdate1}")
	public List getpurchasebyshop(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String clientcdate1) throws Exception {
		return dashBoardService.getweeklyPurchase(compid, branchid, locname, locrefid, clientcdate1);

	}

	// padmini
	@GetMapping(value = "/SIDBoard/{compid}/{branchid}/{locname}/{locrefid}")
	public List SIDBoard(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {

		return dashBoardService.SIDBoard(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getminimunstock/{compid}/{branchid}/{locname}/{locrefid}")
	public List getminimunstock(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return dashBoardService.getminimunstock(compid, branchid, locname, locrefid);
	}

	// Dashboard by Puthiran
	@GetMapping(value = "/getdashsalesdatas/{compid}/{branchid}/{locname}/{locrefid}")
	public Map getsalesdatas(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {

		System.out.println("Dash Sales");
		return dashBoardService.getsalesdatas(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getsalesdatasbyproductwise/{compid}/{branchid}/{locname}/{locrefid}")
	public List getsalesdatasbyproductwise(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return dashBoardService.getsalesdatasbyproductwise(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getdashpurchasedatas/{compid}/{branchid}/{locname}/{locrefid}")
	public Map getpurchasedatas(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return dashBoardService.getpurchasedatas(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getdistributorwisepurchasedatas/{compid}/{branchid}/{locname}/{locrefid}")
	public List getdistributorwisepurchasedatas(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return dashBoardService.getdistributorwisepurchasedatas(compid, branchid, locname, locrefid);
	}

	// Raja Customer count
	// Puthiran get Customer Count by day month yearly
	@GetMapping(value = "/getcustomercount/{compid}/{branchid}/{locname}/{locrefid}")
	public Map getcustcounts(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("Dash Stock Count's");
		return dashBoardService.getcustcounts(compid, branchid, locname, locrefid);
	}

	// Raja Product count
	// Puthiran get Prod counts by day moth year
	@GetMapping(value = "/getproductcount/{compid}/{branchid}/{locname}/{locrefid}")
	public Map getproductcount(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("Dash Stock Count's");
		return dashBoardService.getproductcount(compid, branchid, locname, locrefid);
	}

	// Raja stock count
	// Puthiran get stockcount by day month yearly
	@GetMapping(value = "/getstockcount/{compid}/{branchid}/{locname}/{locrefid}")
	public Map getstockcounts(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("Dash Stock Count's");
		return dashBoardService.getstockcount(compid, branchid, locname, locrefid);
	}

	// Raja out of stock count
	// Puthiran Out od Stocks day month year wise
	@GetMapping(value = "/getoutofstockcount/{compid}/{branchid}/{locname}/{locrefid}")
	public Map getoutofstock(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("Dash Stock Count's");
		return dashBoardService.getoutofstock(compid, branchid, locname, locrefid);
	}

	// Raja Short Expiry stock count
	@GetMapping(value = "/getshortexpirycount/{compid}/{branchid}/{locname}/{locrefid}")
	public int getshortexp1(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		System.out.println("Rajad");
		return dashBoardService.getexpstockcount(compid, branchid, locname, locrefid);
	}

	// Raja Expiry Stock count
	@GetMapping(value = "/getexpirystockcount/{compid}/{branchid}/{locname}/{locrefid}")
	public int getexpstock(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return dashBoardService.getexpstockcount(compid, branchid, locname, locrefid);
	}

	// Desing Raja ABC Analysis Day Datas
	@GetMapping(value = "/getdashabcdatas/{compid}/{branchid}/{locname}/{locrefid}")
	public Map getabcdatas(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) {
		System.out.println("Dash Sales");
		return dashBoardService.getabcdatas(compid, branchid, locname, locrefid);
	}

}
