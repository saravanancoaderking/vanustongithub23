package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.DistributortProd;
import com.medeil.domain.IndCompModel;
import com.medeil.service.DistProdService;

@Controller
@RequestMapping("api/distprod")
public class DistProdController {

	@Autowired
	DistProdService distProdService;

	private final Logger log = LoggerFactory.getLogger(DistProdController.class);

	@ResponseBody
	@RequestMapping(value = "/saveDistProd")
	public int saveDistProd(@RequestBody List<DistributortProd> dt) throws Exception {

		return distProdService.saveDistProd(dt);

	}

	@ResponseBody
	@RequestMapping("/updateDistProd")
	public int updateDistProd(@RequestBody List<DistributortProd> dt) throws Exception {

		return distProdService.updateDistProd(dt);

	}

	@ResponseBody
	@RequestMapping("/viewDistProds")
	public List viewDistProd() throws Exception {

		return distProdService.viewDistProd();

	}

	// Boopalan 270619
	@ResponseBody
	@RequestMapping("/viewProdDistributors")
	public List viewProdDistributors(@RequestBody IndCompModel loc) throws Exception {

		return distProdService.viewDistributors(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDPCustProducts")
	public List viewCustProducts(@RequestBody IndCompModel loc) throws Exception {

		return distProdService.viewCustProducts(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDPCustProduct")
	public List viewCustProduct(@RequestBody IndCompModel loc) throws Exception {

		return distProdService.viewCustProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDistProdWhole")
	public List viewDistProdWhole(@RequestBody IndCompModel loc) throws Exception {

		return distProdService.viewDistProdWhole(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDistProdAll")
	public List viewDistProdAll(@RequestBody IndCompModel loc) throws Exception {

		return distProdService.viewDistProdAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDistProd")
	public List viewDistProduct(@RequestBody IndCompModel loc) throws Exception {

		return distProdService.viewDistProd(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDPPhCompanies")
	public List viewPhCompanies(@RequestBody IndCompModel loc) throws Exception {

		return distProdService.viewPhCompanies(loc);

	}

	@ResponseBody
	@RequestMapping("/viewProductPhComp")
	public List viewProductPhComp(@RequestBody IndCompModel loc) throws Exception {

		return distProdService.viewProductPhComp(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteDistProd")
	public int deleteDistProd(@RequestBody IndCompModel loc) throws Exception {

		return distProdService.deleteDistProd(loc);

	}

	@ResponseBody
	@RequestMapping(value = "/updateDistProdDetails")
	public int updateDistProdDetails(@RequestBody DistributortProd distributortProds) throws Exception {
		return distProdService.updateDistProdDetails(distributortProds);

	}

}
