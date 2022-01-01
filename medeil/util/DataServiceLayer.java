package com.medeil.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.repository.StocksRepository;
import com.medeil.service.StkMinService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class DataServiceLayer {
	@Autowired
	private StocksRepository repository;

	@Autowired
	StkMinService stkminService;

	@Scheduled(cron = "0 0 0 * * *")
	@GetMapping(value = "stockEntryAge")
	public void stockEntryAge() {
		repository.stockEntryAge();
	}

	@Scheduled(cron = "0 0 0 * * *")
	@GetMapping(value = "manufDateAge")
	public void manufDateAge() {
		repository.manufDateAge();
	}

	@Scheduled(cron = "0 0 0 * * *")
	@GetMapping(value = "ExpiryAge")
	public void ExpiryAge() {
		repository.ExpiryAge();
	}

	@Scheduled(fixedRate = 60000) // 10 seconds
	public void updateMinimumStock() {
		stkminService.updateMinimumStock();

	}
}
