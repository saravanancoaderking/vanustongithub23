package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.StockIn;
import com.medeil.service.StocksInService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class StocksInController {
	@Autowired
	StocksInService service;

	// get for stock tax
	@GetMapping(value = "/addstocktax", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StockIn> getAll() throws Exception {

		return service.getAll();
	}
	// post

	@PostMapping(value = "/poststockstax")
	public StockIn postStockstax(@RequestBody StockIn stockstax) throws Exception {

		service.postStockstax(stockstax);
		return stockstax;
	}

	// get sgst
	@GetMapping(value = "/getsgsts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List sgst() throws Exception {

		return service.sgst();
	}

	// get cgst
	@GetMapping(value = "/getcgsts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List cgst() throws Exception {

		return service.cgst();
	}

	// get igst
	@GetMapping(value = "/getigsts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List igst() throws Exception {

		return service.igst();
	}

	// get utgst
	@GetMapping(value = "/getutgsts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List utgst() throws Exception {

		return service.utgst();
	}

	// get gst
	@GetMapping(value = "/getgsts", produces = MediaType.APPLICATION_JSON_VALUE)
	public List gst() throws Exception {

		return service.gst();
	}

	// get vat
	@GetMapping(value = "/getvats", produces = MediaType.APPLICATION_JSON_VALUE)
	public List vat() throws Exception {

		return service.vat();
	}

}
