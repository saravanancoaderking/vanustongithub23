package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.StatusService;

/*************************************************************************
 * 
 * Vanuston CONFIDENTIAL __________________
 * 
 * [2009] - [2019] Vanuston Intelligence Pvt.Ltd All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property of
 * Vanuston Intelligence Pvt.Ltd and its suppliers, if any. The intellectual and
 * technical concepts contained herein are proprietary to Vanuston Intelligence
 * Pvt.Ltd and its suppliers and may be covered by Indian and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material is
 * strictly forbidden unless prior written permission is obtained from Vanuston
 * Intelligence Pvt.Ltd.
 */

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class StatusController {
	@Autowired
	private StatusService stservice;

	@GetMapping(value = "salesstatus/{cid}/{bid}/{locrefid}/{locname}/{soid}")
	public List getSalesorderlead(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer soid) throws Exception {
		return stservice.stsaleservice(cid, bid, locrefid, locname, soid);
	}

	@GetMapping(value = "statustrack/{cid}/{bid}/{locrefid}/{locname}/{soid}")
	public List salessatus(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer soid) throws Exception {
		return stservice.salessatus(cid, bid, locrefid, locname, soid);
	}
}
