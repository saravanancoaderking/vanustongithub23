package com.medeil.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.CurrencySetting;
import com.medeil.domain.Decimalsettings;
import com.medeil.domain.FinacialSetting;
import com.medeil.domain.Journal;
import com.medeil.domain.Setupcostsetting;
import com.medeil.service.CurrencySettingService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")

public class CurrencySettingController {

	@Autowired
	CurrencySettingService currencysettingservice;

	@GetMapping(value = "/getCountryname/{cn}")
	public List getCountryname(@PathVariable String cn) throws Exception {
		return currencysettingservice.getCountryname(cn);

	}

	@GetMapping(value = "/getCurrency/{id}")
	public List getCurrency(@PathVariable Integer id) throws Exception {
		return currencysettingservice.getCurrency(id);
	}

	/** CREATE Currency RECORD **/
	@PostMapping(value = "saveCurrencyset")
	public ResponseEntity<Boolean> createCurrency(@RequestBody CurrencySetting currency) throws Exception {
		return currencysettingservice.createCurrency(currency);

	}

	/** Currency Status **/
	@GetMapping(value = "/getCurrencyStatus")
	public List getCurrencySts() throws Exception {
		return currencysettingservice.getCurrencySts();
	}

	/** CREATE Decimal settings RECORD **/
	@PostMapping(value = "saveDecimalset")
	public ResponseEntity<Boolean> createDecimal(@RequestBody Decimalsettings decimalsetting) throws Exception {
		return currencysettingservice.createDecimal(decimalsetting);

	}

	@GetMapping(value = "/getdecimalstatus/{compid}/{brnchid}/{lname}/{lrefid}")
	public List getDecimalSts(@PathVariable Integer compid, @PathVariable Integer brnchid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		return currencysettingservice.getDecimalSts(compid, brnchid, lname, lrefid);
	}

	/** CREATE SetupCost settings RECORD **/
	@PostMapping(value = "saveSetupcost")
	public ResponseEntity<Boolean> createSetup(@RequestBody Setupcostsetting setupcostsetting) throws Exception {
		return currencysettingservice.createSetup(setupcostsetting);

	}

	@GetMapping(value = "/fetchcurrencystatus/{compid}/{brnchid}/{lrefid}")
	public List fetchCurrsts(@PathVariable Integer compid, @PathVariable Integer brnchid, @PathVariable Integer lrefid)
			throws Exception {
		return currencysettingservice.fetchCurrsts(compid, brnchid, lrefid);
	}

	@GetMapping(value = "/fetchsetupcostvalue/{compid}/{brnchid}/{lname}/{lrefid}")
	public Setupcostsetting fetchsetupcost(@PathVariable Integer compid, @PathVariable Integer brnchid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		return currencysettingservice.fetchsetupcost(compid, brnchid, lname, lrefid);
	}
	
	@GetMapping(value = "/fetchsetupcostjrnl/{compid}/{brnchid}/{lname}/{lrefid}")
	public Journal fetchsetupcostjrnl(@PathVariable Integer compid, @PathVariable Integer brnchid, @PathVariable Double lname,
			@PathVariable Double lrefid) throws Exception {
		return currencysettingservice.fetchsetupcostjrnl(compid, brnchid, lname, lrefid);
	}
	
	/** CREATE Setup Journal RECORD **/
	@PostMapping(value = "saveSetupcostJournal")
	public ResponseEntity<Boolean> saveSetupcostjournal(@RequestBody Journal journal) throws Exception {
		return currencysettingservice.saveSetupcostjournal(journal);

	}

	/** CREATE FinacialYear RECORD **/
	@PostMapping(value = "saveFinacialyr")
	public ResponseEntity<Boolean> createFinacialyr(@RequestBody FinacialSetting finacial) throws Exception {
		return currencysettingservice.createFinacialyr(finacial);

	}
}
