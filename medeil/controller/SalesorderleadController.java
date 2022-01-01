package com.medeil.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.SalesorderleadService;

/*************************************************************************
 * 
 * Vanuston CONFIDENTIAL __________________
 * 
 * [2009] - [2019] Vanuston Intelligence Pvt.Ltd All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property of
 * Vanuston Intelligence Pvt.Ltd and its suppliers, if any. The intellectual and
 * technical concepts contained herein are proprietary to Vanuston Intelligence
 * Pvt.Ltd and its suppliers and may be covered by Indian and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material is
 * strictly forbidden unless prior written permission is obtained from Vanuston
 * Intelligence Pvt.Ltd.
 */

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class SalesorderleadController {

	@Autowired
	private SalesorderleadService salesorderleadService, salesorderService;

	// emedsure
	@GetMapping(value = "salesOrderlead/{cid}/{bid}/{locrefid}/{locname}")
	public List getSalesorderlead(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return salesorderleadService.soleadlist(cid, bid, locrefid, locname);
	}

	// omni process direct wapp
	@GetMapping(value = "omnisalesOrderlead/{cid}/{bid}/{locrefid}/{locname}")
	public List getomniSalesorderlead(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return salesorderleadService.omnisoleadlist(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "omnigetsalesorderleadimageview/{drugid}")
	public Map<String, String> paitentsaveSalesorderleadimage(@PathVariable Integer drugid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = salesorderleadService.getsendImage(drugid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

	@GetMapping(value = "sotypelist/{id}")
	public List getSotypelist(@PathVariable Integer id) throws Exception {
		return salesorderleadService.soleadtypelist(id);
	}

	@GetMapping(value = "sopatientlist/{id}")
	public List getSopatientlist(@PathVariable Integer id) throws Exception {
		return salesorderleadService.soleadpatientlist(id);
	}

	@GetMapping(value = "soleadrecord/{id}")
	public List getSoleadrecord(@PathVariable Integer id) throws Exception {
		return salesorderleadService.soleadrecordlist(id);
	}

	@GetMapping(value = "solproducts/{cid}/{bid}/{locname}/{locrefid}/{soid}")
	public List getsolproducts(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer soid) throws Exception {
		return salesorderleadService.getsolproducts(cid, bid, locname, locrefid, soid);
	}

	@GetMapping(value = "fetchsalesOrderlead/{cid}/{bid}/{locrefid}/{locname}/{soid}")
	public List fetchSalesorderlead(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname, @PathVariable Integer soid)
			throws Exception {
		return salesorderleadService.fetchsoleadlist(cid, bid, locrefid, locname, soid);
	}

	// Boopalan Alagesan 180919 10:23AM
	@GetMapping(value = "getsalesProduct/{cid}/{bid}/{locrefid}/{locname}/{productid}/{qty}")
	public List getProductdata(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer productid, @PathVariable Double qty) throws Exception {

		/**
		 * NOTE : TAKE CARE ON RESULT SET: 0 for active product, 1 for active product
		 * but insufficient quantity, 2 for product not available.
		 */
		return salesorderService.getProductdata(cid, bid, locrefid, locname, productid, qty);
	}
//	@GetMapping(value = "fetchsoleadrecord/{id}")
//	public List fetchSoleadrecord(@PathVariable Integer id) throws Exception {
//		return salesorderleadService.fetchsoleadrecord(id);
//	}

	@GetMapping(value = "addsolproduct/{cid}/{bid}/{locrefid}/{locname}/{data}")
	public List addsoproduct(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer data) throws Exception {
		return salesorderleadService.addsoproduct(cid, bid, locrefid, locname, data);
	}

	@GetMapping(value = "getstockcheck/{cid}/{bid}/{locrefid}/{locname}/{data}")
	public List stockcheck(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer data) throws Exception {
		return salesorderleadService.stockcheck(cid, bid, locrefid, locname, data);
	}

	// Boopalan Alagesan 160919 04:55PM
	@GetMapping(value = "fetchsoleadrecord/{cid}/{bid}/{locname}/{locrefid}/{id}")
	public List fetchSoleadrecord(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer id) throws Exception {
		/**
		 * NOTE : TAKE CARE ON [fetchsoleadrecord] RESULT SET: [sp.flagid as flag] 0 for
		 * active product, 1 for active product but insufficient quantity, 2 for product
		 * not available.
		 */
		return salesorderleadService.fetchsoleadrecord(cid, bid, locname, locrefid, id);
	}
}
