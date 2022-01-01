package com.medeil.archive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.SalesorderService;

@RestController
@RequestMapping("api")
public class SalesOrderArchive {
	@Autowired
	private SalesorderService salesorderService;

	@Scheduled(cron = "0 0 0 1 4 *") // Every Year First of April
	@GetMapping(value = "sales-order-archive")
	public void salesOrderArchive() throws Exception {
		salesorderService.salesOrderArchive();
	}
}
