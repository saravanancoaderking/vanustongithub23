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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medeil.service.AbcAnalysisService;

/**
 * 
 * @author Boopalan Alagesan and sabarish
 * @Date 03-09-2019
 *
 */
//
/**
 * DESCRIPTION : ABC analysis is an approach for classifying inventory items
 * based on the items’ consumption values. Consumption value is the total value
 * of an item consumed over a specified time period, for example a year. The
 * approach is based on the Pareto principle.
 */
@RestController
@RequestMapping("/api")
public class AbcAnalysisController {
	@Autowired
	AbcAnalysisService abcAnalysisService;

	/** This shopslist(), scheduled to run every day @12am. */
	@Scheduled(cron = "0 0 0 * * *")
	@GetMapping(value = "shopslist")
	public List shopslist() throws Exception{

		/**
		 * This Method(abcAnalysisService.shopslist()) Calls Stored Procedure to get
		 * list of shops placed Sales Invoice
		 */
		abcAnalysisService.shopslist();

		return abcAnalysisService.shopsiterator();

	}

}
