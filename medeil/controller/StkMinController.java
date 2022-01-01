package com.medeil.controller;

/*************************************************************************
 * 
 * Vanuston CONFIDENTIAL
 * __________________
 * 
 *  [2009] - [2019] Vanuston Intelligence Pvt.Ltd  
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Vanuston Intelligence Pvt.Ltd and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Vanuston Intelligence Pvt.Ltd
 * and its suppliers and may be covered by Indian and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Vanuston Intelligence Pvt.Ltd.
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.IndCompModel;
import com.medeil.domain.StkMinQty;
import com.medeil.service.StkMinService;

@RestController
@RequestMapping("api/stkmin")
public class StkMinController {

	@Autowired
	StkMinService stkminService;

	private final Logger log = LoggerFactory.getLogger(StkMinController.class);

	@ResponseBody
	@RequestMapping(value = "/saveStkMinQty")
	public int saveStkMinQty(@RequestBody List<StkMinQty> stk) throws Exception {

		return stkminService.saveStkMinQty(stk);

	}

	@ResponseBody // Boopalan 060519
	@RequestMapping("/viewMinimumStock")
	public List viewMinimumStock(@RequestBody IndCompModel loc) throws Exception {

		return stkminService.viewMinimumStock(loc);

	}

	@ResponseBody
	@RequestMapping("/viewMinimumProdNew")
	public List viewMinimumProdNew(@RequestBody IndCompModel loc) throws Exception {

		return stkminService.viewMinimumProdNew(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStkMinQtyAll")
	public List viewStkMinQtyAll(@RequestBody IndCompModel loc) throws Exception {
		loc.getCompanyrefid();
		loc.getBranchrefid();
		loc.getLocname();
		loc.getLocrefid();

		return stkminService.viewStkMinQtyAll(loc);

	}

	@ResponseBody
	@RequestMapping("/viewStk1MinQtyAll")
	public List viewStk1MinQtyAll(@RequestBody IndCompModel loc) throws Exception {

		return stkminService.viewStk1MinQtyAll(loc);

	}

	// Boopalan 060519 added stm.Qty,stm.locname, stm.locrefid
	@ResponseBody
	@RequestMapping("/viewStkMinQty")
	public List viewStkMinQty(@RequestBody IndCompModel loc) throws Exception {

		return stkminService.viewStkMinQty(loc);

	}

	// padmini
	@ResponseBody
	@RequestMapping(value = "/updatestkproduct", method = RequestMethod.POST)
	public int updatestkproduct(@RequestBody List<StkMinQty> stkproduct) throws Exception {

		return stkminService.updatestkproduct(stkproduct);

	}

}
