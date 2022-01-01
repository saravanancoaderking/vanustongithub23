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
import com.medeil.domain.PickList;
import com.medeil.service.PickListService;

@Controller
@RequestMapping("api/pck")
public class PickListController {

	@Autowired
	PickListService picklistService;

	private final Logger log = LoggerFactory.getLogger(PickListController.class);

	@ResponseBody
	@RequestMapping(value = "/savePickList")
	public int savePickList(@RequestBody List<PickList> pck) throws Exception {

		return picklistService.savePickList(pck);

	}

	@ResponseBody
	@RequestMapping("/viewPickListAll")
	public List viewPickListAll(@RequestBody IndCompModel loc) throws Exception {

		return picklistService.viewPickListAll(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPickList")
	public List viewPickList(@RequestBody IndCompModel loc) throws Exception {

		return picklistService.viewPickList(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPCKCustProducts")
	public List viewCustProducts(@RequestBody IndCompModel loc) throws Exception {

		return picklistService.viewCustProducts(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPCKCustProduct")
	public List viewCustProduct(@RequestBody IndCompModel loc) throws Exception {

		return picklistService.viewCustProduct(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPCKEmployees")
	public List viewEmployees(@RequestBody IndCompModel loc) throws Exception {

		return picklistService.viewEmployees(loc);
	}

	@ResponseBody
	@RequestMapping("/viewPCKCustomers")
	public List viewCustomers(@RequestBody IndCompModel loc) throws Exception {

		return picklistService.viewCustomers(loc);
	}

	@ResponseBody
	@RequestMapping("/deletePickList")
	public int deletePickList(@RequestBody IndCompModel loc) throws Exception {

		return picklistService.deletePickList(loc);
	}

}
