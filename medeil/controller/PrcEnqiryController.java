package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.PriceEnquiry;
import com.medeil.service.PrcEnqiryService;

@Controller
@RequestMapping("api/prcenq")
public class PrcEnqiryController {

	@Autowired
	PrcEnqiryService prcenqiryService;

	@ResponseBody
	@RequestMapping(value = "/savePriceEnquiry")
	public int savePriceEnquiry(@RequestBody List<PriceEnquiry> prc) throws Exception {

		return prcenqiryService.savePriceEnquiry(prc);

	}

	@ResponseBody
	@RequestMapping("/viewPRCPurchSession")
	public List viewPurchSession(@RequestBody IndCompModel loc) throws Exception {
		return prcenqiryService.viewPurchSession(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPurchSessionProd")
	public List viewPurchSessionProd(@RequestBody IndCompModel loc) throws Exception {
		return prcenqiryService.viewPurchSessionProd(loc);

	}

	@ResponseBody // Boopalan 030719
	@RequestMapping("/viewProdWiseDist")
	public List viewProdWiseDist(@RequestBody IndCompModel loc) throws Exception {
		return prcenqiryService.viewProdWiseDist(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPriceEnquiryAll")
	public List viewPriceEnquiryAll(@RequestBody IndCompModel loc) throws Exception {
		return prcenqiryService.viewPriceEnquiryAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPriceEnquiryNewAll")
	public List viewPriceEnquiryNewAll(@RequestBody IndCompModel loc) throws Exception {
		return prcenqiryService.viewPriceEnquiryNewAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewPriceEnquiryProd")
	public List viewPriceEnquiryProd(@RequestBody IndCompModel loc) throws Exception {
		return prcenqiryService.viewPriceEnquiryProd(loc);

	}
	
	@ResponseBody
	@RequestMapping("/view-dist-previous-price")
	public List viewDistPreviousPrice(@RequestBody IndCompModel loc) throws Exception {
		return prcenqiryService.viewDistPreviousPrice(loc);

	}

}
