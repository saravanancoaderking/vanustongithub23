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
import com.medeil.domain.PriceEnquiry;
import com.medeil.service.DistUpdateService;

@Controller
@RequestMapping("api/distupd")
public class DistUpdateController {

	@Autowired
	DistUpdateService distupdateService;

	private final Logger log = LoggerFactory.getLogger(DistUpdateController.class);

	@ResponseBody
	@RequestMapping("/viewDUPriceEnquiry")
	public List viewPriceEnquiry(@RequestBody IndCompModel loc) throws Exception {
		return distupdateService.viewPriceEnquiry(loc);

	}

	@ResponseBody
	@RequestMapping("/updatePriceEnquiry")
	public int updatePriceEnquiry(@RequestBody List<PriceEnquiry> loc) throws Exception {
		return distupdateService.updatePriceEnquiry(loc);

	}

}
