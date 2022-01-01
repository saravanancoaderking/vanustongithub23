package com.medeil.controller;

/**
 * @author Sankar
 * @date   27-08-2019
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Packing;
import com.medeil.domain.PackingMaterial;
import com.medeil.domain.PackingProducts;
import com.medeil.service.PackingService;

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
public class PackingController {
	@Autowired
	private PackingService pckservice;

	@GetMapping(value = "packingdatas/{cid}/{bid}/{locrefid}/{locname}/{pickid}")
	public List packingdata(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer pickid) throws Exception {
		return pckservice.packingdata(cid, bid, locrefid, locname, pickid);
	}

	@GetMapping(value = "packingfielddatas/{cid}/{bid}/{locrefid}/{locname}/{pickid}")
	public List packingfielddata(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer pickid) throws Exception {
		return pckservice.packingfielddata(cid, bid, locrefid, locname, pickid);
	}

	@GetMapping(value = "getpicklist/{cid}/{bid}/{locrefid}/{locname}")
	public List picklist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return pckservice.picklist(cid, bid, locrefid, locname);
	}

	@ResponseBody
	@RequestMapping(value = "/savepackageno", method = RequestMethod.POST)
	public boolean savePackagematerial(@RequestBody PackingMaterial packmaterial) throws Exception {
		return pckservice.savePackagematerial(packmaterial);
	}

	@RequestMapping(value = "/savepacking", method = RequestMethod.POST)
	public boolean savePacking(@RequestBody Packing packingMain) throws Exception {
		return pckservice.savePacking(packingMain);
	}

	@RequestMapping(value = "/savepackingproducts", method = RequestMethod.POST)
	public boolean savePackingprod(@RequestBody List<PackingProducts> packprodMain) throws Exception {
		return pckservice.savePackingProducts(packprodMain);
	}

	@GetMapping(value = "getpacklist/{cid}/{bid}/{locrefid}/{locname}")
	public List packlist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return pckservice.packlist(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "checkpackingdatas/{cid}/{bid}/{locrefid}/{locname}/{packid}")
	public List checkpackingdata(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer packid) throws Exception {
		return pckservice.checkpackingdata(cid, bid, locrefid, locname, packid);
	}

	@GetMapping(value = "checkpackingfielddatas/{cid}/{bid}/{locrefid}/{locname}/{packid}")
	public List checkpackingfielddata(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname, @PathVariable Integer packid)
			throws Exception {
		return pckservice.checkpackingfielddata(cid, bid, locrefid, locname, packid);
	}

	@GetMapping(value = "getpackingno/{cid}/{bid}/{locrefid}/{locname}")
	public List getpacklist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return pckservice.getpacklist(cid, bid, locrefid, locname);
	}

	@RequestMapping(value = "/checksavepacking", method = RequestMethod.POST)
	public boolean checksavePacking(@RequestBody Packing packingMain) throws Exception {
		return pckservice.checksavePacking(packingMain);
	}

	@RequestMapping(value = "/checksavepackingproducts", method = RequestMethod.POST)
	public boolean checksavePackingprod(@RequestBody List<PackingProducts> packprodMain) throws Exception {

		return pckservice.checksavePackingProducts(packprodMain);
	}

	@GetMapping(value = "getcheckedpicklist/{cid}/{bid}/{locrefid}/{locname}")
	public List checkedpicklist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return pckservice.checkedpicklist(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getapprovepackingno/{cid}/{bid}/{locrefid}/{locname}")
	public List getapprovepacklist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return pckservice.getapprovepacklist(cid, bid, locrefid, locname);
	}
}
