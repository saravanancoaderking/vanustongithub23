package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Distributor;
import com.medeil.domain.IndCompModel;
import com.medeil.service.DistService;

@Controller
@RestController
@RequestMapping("api/dist")
public class DistributorController {

	@Autowired
	DistService distservice;

	private final Logger log = LoggerFactory.getLogger(DistributorController.class);

	@ResponseBody
	@RequestMapping(value = "/saveDistributor")
	public int saveDistributor(@RequestBody Distributor dist) throws Exception {
		System.out.println("Boopalan : " + dist.getDlno());
		return distservice.saveDistributor(dist);
	}

	@ResponseBody
	@RequestMapping(value = "/saveDistPhcompany")
	public int saveDistPhcompany(@RequestBody List<IndCompModel> loc) throws Exception {

		return distservice.saveDistPhcompany(loc);
	}

	@ResponseBody
	@RequestMapping("/updateDistributor")
	public int updateDistributor(@RequestBody Distributor dist) throws Exception {

		return distservice.updateDistributor(dist);

	}

	@ResponseBody
	@RequestMapping(value = "/saveIndvDistType")
	public int saveIndvDistType(@RequestBody IndCompModel loc) throws Exception {

		return distservice.saveIndvDistType(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDistributors")
	public List viewDistributors(@RequestBody IndCompModel loc) throws Exception {

		return distservice.viewDistributors(loc);
	}

	@ResponseBody
	@RequestMapping("/viewDistributorEdit")
	public Distributor viewDistributorEdit(@RequestBody IndCompModel loc) throws Exception {

		return distservice.viewDistributorEdit(loc);
	}

	@ResponseBody
	@RequestMapping("/viewDistributor")
	public List viewDistributor(@RequestBody IndCompModel loc) throws Exception {

		return distservice.viewDistributor(loc);
	}

	@ResponseBody
	@RequestMapping("/viewDistributorId")
	public Integer viewDistributorId(@RequestBody IndCompModel loc) throws Exception {

		return distservice.viewDistributorId(loc);
	}

	@ResponseBody
	@RequestMapping("/viewDistType")
	public List viewDistType(@RequestBody IndCompModel loc) throws Exception {

		return distservice.viewDistType(loc);
	}

	@ResponseBody
	@RequestMapping("/viewDstPhCompanies")
	public List viewPhCompanies(@RequestBody IndCompModel loc) throws Exception {

		return distservice.viewPhCompanies(loc);
	}

	@ResponseBody
	@RequestMapping("/viewDistEditPhCompanies")
	public List viewDistPhCompanies(@RequestBody IndCompModel loc) throws Exception {

		return distservice.viewDistPhCompanies(loc);
	}

	@ResponseBody
	@RequestMapping("/deleteDistributor")
	public int deleteDistributor(@RequestBody IndCompModel loc) throws Exception {
		return distservice.deleteDistributor(loc);

	}

	@ResponseBody // Boopalan 290319
	@RequestMapping(value = "geteditdistState")
	public List editDistsstate(@RequestBody IndCompModel distributorid) throws Exception {
		return distservice.editDistsstate(distributorid);

	}

	@ResponseBody // Boopalan 290319
	@RequestMapping(value = "geteditdistCity")
	public List editDistscity(@RequestBody IndCompModel distributorid) throws Exception {
		return distservice.editDistscity(distributorid);

	}

	@ResponseBody // Boopalan 010419
	@RequestMapping(value = "geteditdistType")
	public List editDiststype(@RequestBody IndCompModel distributorid) throws Exception {
		return distservice.editDiststype(distributorid);

	}
	
	// Raja 28022021
	@GetMapping(value = "/distlist/{cid}/{bid}/{lnid}/{lrid}/{searchkey}")
	public List editDiststype(@PathVariable Integer cid,@PathVariable Integer bid,@PathVariable Integer lnid,@PathVariable Integer lrid,@PathVariable String searchkey) throws Exception {
		System.out.println("DistSearch");
		return distservice.distlist(cid,bid,lnid,lrid,searchkey);

	}
	
	
	
}
