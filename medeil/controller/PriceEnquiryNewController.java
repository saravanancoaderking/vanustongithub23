package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.PrcEnqiryService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class PriceEnquiryNewController {
	@Autowired
	PrcEnqiryService prcenqiryService;

	@GetMapping(value = "/getdistpriceenq/{compid}/{branchid}/{locname}/{locrefid}")
	public List getDisPriceEnq(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return prcenqiryService.getDisPriceEnq(compid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/getdate/{compid}/{branchid}/{locname}/{locrefid}/{vendorid}")
	public List getDate(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer vendorid) throws Exception {
		return prcenqiryService.getDate(compid, branchid, locname, locrefid, vendorid);
	}

	@GetMapping(value = "/getdistprod/{compid}/{branchid}/{locname}/{locrefid}/{vendorid}/{cdate}")
	public List getDistProd(@PathVariable Integer compid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer vendorid, @PathVariable String cdate)
			throws Exception {
		return prcenqiryService.getDistProd(compid, branchid, locname, locrefid, vendorid, cdate);
	}

}
