package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.ProductMap;
import com.medeil.service.ProdMapService;

@Controller
@RequestMapping("api/prodmap")
public class ProdMapController {

	@Autowired
	ProdMapService prodmapService;

	private final Logger log = LoggerFactory.getLogger(ProdMapController.class);

	@ResponseBody
	@RequestMapping(value = "/saveProdMap")
	public int saveProdMap(@RequestBody List<ProductMap> prod) throws Exception {

		return prodmapService.saveProdMap(prod);

	}

	@ResponseBody
	@RequestMapping(value = "/updateProdMap")
	public int updateProdMap(@RequestBody List<ProductMap> prod) throws Exception {

		return prodmapService.updateProdMap(prod);

	}

	@ResponseBody
	@RequestMapping("/viewPMCustProducts")
	public List viewCustProducts(@RequestBody IndCompModel loc) throws Exception {

		return prodmapService.viewCustProducts(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPMCustProduct")
	public List viewCustProduct(@RequestBody IndCompModel loc) throws Exception {

		return prodmapService.viewCustProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPMCustProducts1")
	public List viewCustProducts1(@RequestBody IndCompModel loc) throws Exception {

		return prodmapService.viewCustProducts(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPMCustProduct1")
	public List viewCustProduct1(@RequestBody IndCompModel loc) throws Exception {

		return prodmapService.viewCustProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/viewProdMapAll")
	public List viewProdMapAll(@RequestBody IndCompModel loc) throws Exception {

		return prodmapService.viewProdMapAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewProdMap")
	public List viewProdMap(@RequestBody IndCompModel loc) throws Exception {

		return prodmapService.viewProdMap(loc);

	}

}
