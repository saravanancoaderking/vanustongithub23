package com.medeil.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.DistributorSelect;
import com.medeil.domain.IndCompModel;
import com.medeil.service.DistSelectService;

@Controller
@RequestMapping("api/distslct")
public class DistSelectController {

	@Autowired
	DistSelectService distselectService;

	private final Logger log = LoggerFactory.getLogger(DistSelectController.class);

	@ResponseBody
	@RequestMapping(value = "/savePriceEnqury")
	public int savePriceEnqury(@RequestBody List<DistributorSelect> dist) throws Exception {

		return distselectService.savePriceEnqury(dist);

	}

	@ResponseBody
	@RequestMapping(value = "/saveDistSelect")
	public int saveDistSelect(@RequestBody List<DistributorSelect> dist) throws Exception {

		return distselectService.saveDistSelect(dist);

	}

	@ResponseBody
	@RequestMapping("/viewDSPriceEnquiryNo")
	public List viewPriceEnquiryNo(@RequestBody IndCompModel loc) throws Exception {
		return distselectService.viewPriceEnquiryNo(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDSDistSelectNo")
	public List viewDistSelectNo(@RequestBody IndCompModel loc) throws Exception {
		return distselectService.viewDistSelectNo(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDSPriceEnquiry")
	public List viewPriceEnquiry(@RequestBody IndCompModel loc) throws Exception {
		return distselectService.viewPriceEnquiry(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDistSelectAll")
	public List viewDistSelectAll(@RequestBody IndCompModel loc) throws Exception {

		return distselectService.viewDistSelectAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDistSelectNewAll")
	public List viewDistSelectNewAll(@RequestBody IndCompModel loc) throws Exception {

		return distselectService.viewDistSelectNewAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewDistSelect")
	public List viewDistSelect(@RequestBody IndCompModel loc) throws Exception {
		return distselectService.viewDistSelect(loc);

	}

}
