package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.IndentProducts;
import com.medeil.domain.IndentRequest;
import com.medeil.repository.IndtReqRepository;
import com.medeil.service.IndReqService;

@Controller
@RestController
@RequestMapping("api/indreq")
public class IndtReqController {

	@Autowired
	IndReqService irqService;

	@Autowired
	IndtReqRepository indtreqrepo;

	private final Logger log = LoggerFactory.getLogger(IndtReqController.class);

	@ResponseBody
	@RequestMapping(value = "/saveIndentRequest")
	public int saveIndentRequest(@RequestBody IndentRequest ir) throws Exception {

		return irqService.saveIndentRequest(ir);

	}

	@ResponseBody
	@RequestMapping(value = "/saveIndentProducts")
	public int saveIndentProducts(@RequestBody List<IndentProducts> ip) throws Exception {

		return irqService.saveIndentProducts(ip);

	}
	// padmini
//	@ResponseBody
//	@RequestMapping(value = "/saveIndentRequest1")
	// public int saveIndentRequest1(@RequestBody List<IndentRequest> ip1) throws
	// Exception {

	// return irqService.saveIndentRequest1(ip1);

//	}

	@ResponseBody
	@RequestMapping(value = "/updateIndentRequest")
	public int updateIndentRequest(@RequestBody IndentRequest ir) throws Exception {

		return irqService.updateIndentRequest(ir);

	}

	@ResponseBody
	@RequestMapping(value = "/updateIndentProducts")
	public int updateIndentProducts(@RequestBody List<IndentProducts> ip) throws Exception {

		return irqService.updateIndentProducts(ip);

	}

	@ResponseBody
	@RequestMapping("/viewIndentRequests")
	public List viewIndentRequests(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewIndentRequests(loc);
	}

	/** Boopalan Edited **/ // 250419
	@ResponseBody
	@RequestMapping("/viewIndentRequest")
	public List viewIndentRequest(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewIndentRequest(loc);

	}

	@ResponseBody
	@RequestMapping("/viewshopinformation")
	public List viewshopinformation(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewshopinformation(loc);

	}

	@ResponseBody
	@RequestMapping("/viewWareHouse")
	public List viewWareHouse(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewWareHouse(loc);

	}

	@ResponseBody
	@RequestMapping("/viewHospital")
	public List viewHospital(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewHospital(loc);

	}

	@ResponseBody
	@RequestMapping("/viewIrqCustProducts")
	public List viewWhCustProduct(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewWhCustProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/viewIrqCustProduct")
	public List viewCustProduct(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewCustProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/viewIndentProduct")
	public List viewIndentProduct(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewIndentProduct(loc);

	}

	@ResponseBody
	@RequestMapping("/viewIndentRequestsAll")
	public List viewIndentRequestsAll(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewIndentRequestsAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewIrqStkMinQtyAll")
	public List viewStkMinQtyAll(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewStkMinQtyAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewIrqStkMinQty")
	public List viewStkMinQty(@RequestBody IndCompModel loc) throws Exception {

		return irqService.viewStkMinQty(loc);

	}

	@ResponseBody
	@RequestMapping("/deleteIndReq")
	public int deleteIndReq(@RequestBody IndCompModel loc) throws Exception {

		return irqService.deleteIndReq(loc);

	}

	@ResponseBody // sankar 100419
	@RequestMapping(value = "/getbussinamename")
	public List editbussiname(@RequestBody IndCompModel indentreqid) throws Exception {
		return irqService.editbusinameservice(indentreqid);

	}

	/* Stock Checking */
	@ResponseBody
	@RequestMapping(value = "/saveIndentRequest1")
	public int saveIndentRequest1(@RequestBody List<IndentRequest> ip2) throws Exception {
		System.out.println("inside indent req11");
		return irqService.saveIndentRequest1(ip2);

	}

	@ResponseBody
	@RequestMapping(value = "/saveIndentProducts1")

	public int saveIndentProducts1(@RequestBody List<IndentProducts> ip) throws Exception {

		System.out.println("inside indent req1");
		return irqService.saveIndentProducts1(ip);

	}

	@GetMapping(value = "/torequestshopdetails/{compid}/{lname}")
	public List getToRequsitionshop(@PathVariable Integer compid,@PathVariable Integer lname) throws Exception {
		return irqService.getToRequsitionshop(compid,lname);

	}
	
	@GetMapping(value = "/multistorereqproducts/{compid}/{drug}/{lrefid}")
	public List getMultistorereqproducts(@PathVariable Integer compid,@PathVariable Integer drug,@PathVariable Integer lrefid) throws Exception {
		return irqService.getMultistorereqproducts(compid,drug,lrefid);

	}
}
